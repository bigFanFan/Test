<div class="col-xs-12 nopd-lr wigtbox-head form-inline">
    <form id="search_form" action="/app/${table_name_first_low}s/grid" method="Post">
        <div class="pull-left">
            <#if model_column?exists>
                <#list model_column as model>
            <input type="text" class="form-control" name="${model.changeColumnName?uncap_first}" id="${model.changeColumnName?uncap_first}Query" placeholder="${model.columnComment!}" />
                </#list>
            </#if>

            <button class="btn btn-info btn-sm" type="button" id="btn-clear" data-toggle="tooltip" data-placement="top" title="清空搜索条件">
                <i class="fa fa-remove bigger-110"></i>
            </button>

            <button class="btn btn-primary btn-sm" type="button" id="btn-search" data-grid="#grid-table">
                <i class="fa fa-search bigger-110"></i> 搜索
            </button>
        </div>

        <div class="pull-right">
            <button class="btn btn-warning btn-sm" type="button" data-toggle="modal" data-target="#info-dialog">
                <i class="fa fa-plus bigger-110"></i> 添加
            </button>
            <button class="btn btn-danger btn-sm" type="button"  onclick=confrimDel2("#grid-table","/app/${table_name_first_low}s/delete")>
                <i class="fa fa-trash bigger-110"></i> 删除
            </button>
            <button class="btn btn-success btn-sm" type="button" onclick="exportExcelData()">
                <i class="fa fa-download bigger-110"></i> 导出
            </button>
        </div>
    </form>
</div>

<div class="col-xs-12 nopd-lr">
    <!-- PAGE CONTENT BEGINS -->
    <table id="grid-table"></table>
    <div id="grid-pager"></div>
    <!-- PAGE CONTENT ENDS -->
</div><!-- /.col -->



<!--添加、修改-->
<div class="modal fade" id="info-dialog" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title pull-left">添加${table_annotation}</h4>
                <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div class="clearfix"></div>
            </div>
            <div class="modal-body text-center">
                <form id="info_form" method="Post" class="form-horizontal" action="/app/${table_name_first_low}s/modify">
                    <div class="form-group">
                        <#if model_column?exists>
                            <#list model_column as model>
                        <div class="col-md-12">
                            <label for="${model.changeColumnName?uncap_first}" class="col-md-5">${model.columnComment!}</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="${model.changeColumnName?uncap_first}" id="${model.changeColumnName?uncap_first}" placeholder=""/></div>
                        </div>
                            </#list>
                        </#if>
                    </div>
                </form>
            </div>
            <div class="modal-footer text-center">
                <button type="button" class="btn btn-info btn-sm btn-confirm" id="btn-confirm">保存</button>
            </div>
        </div>
    </div>
</div><!--/End info-dialog-->

<script src="/js/common/thumbupload.js"></script>
<script src="/js/common/common.opreation.js"></script>
<script type="text/javascript">

$(function(){

    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    $(grid_selector).jqGrid({
        url:"/app/${table_name_first_low}s/grid",
        mtype: "post",
        datatype: "json",
        height: '100%',
        colNames:[
            <#if model_column?exists>
                <#list model_column as model>
            '${model.columnComment!}',
                </#list>
            </#if>
            '操作'],
        colModel:[
            <#if model_column?exists>
                <#list model_column as model>
        {name:'${model.changeColumnName?uncap_first}',index:'${model.changeColumnName?uncap_first}', editable: false},
                </#list>
            </#if>
        /*待翻译字典模板
        {name:'imageType',index:'imageType', editable: false,
             formatter: function(value,grid,rows,state){
                 return translateDicts('imageType',value);
             }
        },*/
        {name:'myac',index:'', fixed:true, sortable:false, resize:false,
             formatter: function(value,grid,rows,state){
                 return '<a class="btn btn-info btn-xs mr5" data-toggle="modal" data-target="#info-dialog" data-id="'+rows.id+'" title="查看详情"  onclick="detailDialog()"><i class="fa fa-eye"></i></a>'+
                         '<a class="btn btn-warning btn-xs mr5" data-toggle="modal" data-target="#info-dialog" title="修改" data-id="'+rows.id+'"  onclick="updateDialog()"><i class="fa fa-edit"></i></a>'+
                         '<a class="btn btn-danger btn-xs mr5" data-toggle="tooltip" data-placement="top" title="删除" onclick=confrimDel2("#grid-table","/app/${table_name_first_low}s/delete")><i class="fa fa-trash"></i></a>';
             }
         }
        ],
        viewrecords : true,
        rowNum:10,
        rowList:[10,20,30],
        pager : pager_selector,
        emptyrecords : "未找到任何数据",
        pgtext: "第{0}页 共{1}页",
        altRows: true,
        //toppager: true,
        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,
        loadComplete : function(res) {
            var table = this;
            setTimeout(function(){
                updatePagerIcons(table);
            }, 0);
            $("[data-toggle='tooltip']").tooltip({html : true});

            //缓存当前页面数据
            // $('#grid-table').data("gridTable",res);
        },
        editurl: "",//不需要
        caption: "${table_annotation}管理",
        autowidth: true
    });
    initNavGrid(grid_selector,pager_selector);

    //添加或编辑
    $('#info-dialog').on('show.bs.modal',function(e){
        var $button=$(e.relatedTarget);
        var id=$button.data("id");
        var modal = $(this);
        $("#info_form").data('validator').resetForm();
        if(id==null||id==""){
            //添加时清空表单数据
            $('#info_form')[0].reset();
            $('#info_form').find('input[type="hidden"]').each(function(i,item){
                $(item).val("");
            });

            return;
        }else{
            //发送ajax回去查询单条数据
            $.ajax({
                url:'/app/${table_name_first_low}s/detail',
                type:'Get',
                data:{id:id},
                success:function(result){
                    if(result.success){
                        result = result.datas;

                        //回填数据
                        <#if model_column?exists>
                            <#list model_column as model>
                        modal.find('#${model.changeColumnName?uncap_first}').val(result.${model.changeColumnName?uncap_first});
                            </#list>
                        </#if>
                    }
                    else
                    {
                        $.alert('提示',result.msg);
                    }
                }
            });
        }
    });


    //添加或修改提交
    $('#btn-confirm').on('click',function(){
        if(!$('#info_form').valid()){
            return;
        }

        //Ajax提交表单数据
        var data=JSON.stringify(getFromJsonData('#info_form'));

        if($('#info_form').valid()){
            $.ajax({
                url:'/app/${table_name_first_low}s/modify',
                type:'Post',
                dataType:'json',
                contentType: 'application/json',
                data: data,
                success:function(result){
                    if(result.success){
                        //操作成功之后
                        //关闭modal
                        $('#info-dialog').modal('hide');
                        $.alert('提示', result.msg);
                        //刷新Grid
                        $('#grid-table').trigger("reloadGrid");
                    }
                    else
                    {
                        $.alert('提示', result.msg);
                    }
                }
            });
        }
    });

    //表单校验
    $("#info_form").validate({
        //失去焦点 进行验证
        onfocusout: function(element) {
            $(element).valid();
        },
        rules: {
             <#if model_column?exists>
                 <#list model_column as model>
             ${model.changeColumnName?uncap_first}:"required",
                 </#list>
             </#if>
             count: {
                required: true,
                rationalNum:true
             }
        },
        messages: {
            //自定义提示

        }
    });
});

//设定grid为单选
function beforeSelectRow(){
    $('#grid-pro-table').jqGrid('resetSelection');
    return(true);
}

//datepicker plugin
$('.form_datatime').datetimepicker({
    format:"yyyy-mm-dd",
    // format:"yyyy-mm-dd hh:ii:ss",//时分秒
    weekStart: 1,
    todayBtn:  "linked",
    clearBtn:1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    minView:2,
    // minView:'hour',//时分秒
    showMeridian: false,
    language:'zh-CN'
});

//查看详情
function detailDialog(){
    let $modal = $('#info-dialog');
    let title = $modal.find('h4').text();
    $modal.find('h4').text(title.replace('添加','').replace('修改','')  + '详情');
    $modal.find('.webuploader-pick').hide();
    $modal.find('input').attr('disabled','disabled');
    $modal.find('select').attr('disabled','disabled');
    $modal.find('input').removeClass('error');
    $modal.find('select').removeClass('error');
    $modal.find('.text-muted').hide();
    $modal.find('.btn').hide();
    $('#info-dialog').find('.modal-footer').append('<button id="btn-close" class="btn btn-info" type="button" data-dismiss="modal" aria-hidden="true">关闭</button>')
};
//窗口隐藏复位信息
$('#info-dialog').on('hidden.bs.modal',function(e){
    let $modal = $('#info-dialog');
    $modal.find('.webuploader-pick').show();
    $modal.find('input').removeAttr("disabled");
    $modal.find('select').removeAttr("disabled");
    $modal.find('.text-muted').show();
    $modal.find('.btn').show();
    $modal.find('.modal-footer').find('#btn-close').remove();

    let title = $modal.find('h4').text();
    if(title.indexOf('添加') == -1)
        $modal.find('h4').text('添加' + title.replace('修改','').replace('详情','') );
    else
        $modal.find('h4').text(title.replace('修改','').replace('详情','') );

});
//修改详情
function updateDialog(){
    $('#info-dialog').find('h4').text($('#info-dialog').find('h4').text().replace('添加','修改'));
};

//导出
function exportExcelData(){
    //Ajax提交表单数据
    var paramData={};

    // 导出查询条件对象
    paramData.searchParam = getFromJsonData('#search_form');
    // 请求导出列表url
    paramData.requestUrl = Common.local.serverRequest.concat("/app/${table_name_first_low}s/grid");
    // 导出显示表头名称字符串,逗号分割
    paramData.colName ="<#if model_column?exists><#list model_column as model>${model.columnComment!},</#list></#if>";

    // 导出显示表头对应字段字符串,逗号分割
    paramData.keyStr ="<#if model_column?exists><#list model_column as model>${model.changeColumnName?uncap_first},</#list></#if>";

    // 导出显示标题
    paramData.title = "${table_annotation}管理";

    // 需要翻译字段信息 格式{status:{on:"进行中",off:"未开启",expire:"已结束"}}
    paramData.translateDicts = translateDicts;

    var data=JSON.stringify(paramData);
    var path = '/app/export?params='+data;
    var content ="确定导出数据?";
    $.confirm(content,"确定","取消",function (){
        window.open(path);
    });
}


//待翻译字典对象信息
var translateDicts = {};
/**
 * 获取所有要翻译字典信息
 */
function getAllDicts() {
    //只初始化一次
    if(JSON.stringify(translateDicts)=="{}"){
        console.log("加载字典:::"+JSON.stringify(translateDicts));

        // translateDicts.STATUS = {
        //     "0": "成功",
        //     "1": "失败"
        // };
    }
}
/**
 * 翻译字典
 * fieldName 需要翻译的字段名称，value 需要翻译的字段值
 */
function getDictByName(fieldName,value) {
    getAllDicts();


    var translateDictName = '';//需要翻译字典名称

    //判断字段名称存在字典对象  并且值也存在,则获取翻译名称
    if(translateDicts.hasOwnProperty(fieldName)
            && translateDicts[fieldName].hasOwnProperty(value)){
        translateDictName = translateDicts[fieldName][value];
    }

    return translateDictName == '' ? "N/A" : translateDictName;
}
</script>