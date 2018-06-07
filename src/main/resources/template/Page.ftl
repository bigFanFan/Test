<div class="col-xs-12 nopd-lr wigtbox-head form-inline">
    <form id="search_form" action="/app/${table_name_first_low}s/grid" method="Post">
        <div class="pull-left">
            <#if model_column?exists>
                <#list model_column as model>
            <input type="text" class="form-control" name="${model.changeColumnName?uncap_first}" id="${model.changeColumnName?uncap_first}" placeholder="${model.columnComment!}" />
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

<div class="modal fade" id="detail-dialog" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">${table_annotation}详情</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <input type="hidden" name="id" id="id" />
                    <#if model_column?exists>
                        <#list model_column as model>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">${model.columnComment!}：</label>
                            <div class="${model.changeColumnName?uncap_first} col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                        </#list>
                    </#if>
                </div>
            </div>
            <div class="modal-footer text-center">
                <button id="btn-close" class="btn btn-info" type="button" data-dismiss="modal" aria-hidden="true">
                                        关闭
                </button>
            </div>
        </div>
    </div>
</div>

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
                        <div class="col-md-6">
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
        {name:'myac',index:'', fixed:true, sortable:false, resize:false,
             formatter: function(value,grid,rows,state){
                 return '<a class="btn btn-info btn-xs mr5" data-toggle="modal" data-target="#detail-dialog" data-id="'+rows.id+'" title="查看详情"><i class="fa fa-eye"></i></a>'+
                         '<a class="btn btn-warning btn-xs mr5" data-toggle="modal" data-target="#info-dialog" title="修改" data-id="'+rows.id+'"><i class="fa fa-edit"></i></a>'+
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
        loadComplete : function() {
            var table = this;
            setTimeout(function(){
                updatePagerIcons(table);
            }, 0);
            $("[data-toggle='tooltip']").tooltip({html : true});
        },
        editurl: "/aaa/bbb",//不需要
        caption: "${table_annotation}管理",
        autowidth: true
    });

    initNavGrid(grid_selector,pager_selector);

    //查看详情
    $('#detail-dialog').on('show.bs.modal',function(e){
        var $button=$(e.relatedTarget);
        var id=$button.data("id");
        var modal = $(this);
        //发送ajax回去查询单条数据
        $.ajax({
            url:'/app/${table_name_first_low}s/detail',
            type:'Get',
            data:{id:id},
            success:function(result){
                if(result){
                    //回填数据
                    <#if model_column?exists>
                        <#list model_column as model>
                    modal.find('.${model.changeColumnName?uncap_first}').text(result.${model.changeColumnName?uncap_first});
                        </#list>
                    </#if>
                }
                else
                {
                    $.alert('提示','操作失败 ！');
                }
            }
        });

    });

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
            $('#info_form').find(".description").val("");

            return;
        }else{
            //发送ajax回去查询单条数据
            $.ajax({
                url:'/app/${table_name_first_low}s/detail',
                type:'Get',
                data:{id:id},
                success:function(result){
                    if(result){
                        //回填数据
                        <#if model_column?exists>
                            <#list model_column as model>
                        modal.find('#${model.changeColumnName?uncap_first}').val(result.${model.changeColumnName?uncap_first});
                            </#list>
                        </#if>
                    }
                    else
                    {
                        $.alert('提示','操作失败 ！');
                    }
                }
            });
        }
    });

    //模态框内部搜索
    $('#btn-modal-search').on('click',function(){
        var gridName=$(this).data("grid");
        var data=$('#select-dialog').find('#search_form').serializeArray();
        var jsonData={};
        for(var i=0;i<data.length;i++){
            jsonData[data[i].name]=data[i].value;
        }
        //console.log(jsonData);
        //提交后刷新grid
        $(gridName).setGridParam({postData:jsonData}).trigger('reloadGrid');
    });

    //添加或修改提交
    $('#btn-confirm').on('click',function(){
        //Ajax提交表单数据
        var formData= $('#info_form').serializeArray();
        var jsonData={};

        for(var i=0;i<formData.length;i++){
            jsonData[formData[i].name]=formData[i].value;
        }
        var data=JSON.stringify(jsonData);

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


    //增加正则验证
    jQuery.validator.addMethod("digit", function(value, element,param) {
        var tel = /^[0-9]*$/;
        return this.optional(element) || (tel.test(value));
    }, "请输入数字");

    jQuery.validator.addMethod("rationalNum", function(value, element,param) {
        var psw = /^[+]?[0-9]*\.?[0-9]+$/;
        return this.optional(element) || (psw.test(value));
    }, "请输入正确的数字");

    jQuery.validator.addMethod("limitChar", function(value, element,param) {
        var psw = /^.{0,5}$/;
        return this.optional(element) || (psw.test(value));
    }, "少于5个字");
    $("#info_form").validate({
        //失去焦点 进行验证
        onfocusout: function(element) {
            $(element).valid();
        },
        rules: {
            barcode:"required",
            specification:"required",
            count: {
                required: true,
                rationalNum:""
            },
            unit_code:"required",
            price: {
                required: true,
                rationalNum:""
            },
            description: {
                required: false,
                limitChar:""
            }
        },
        messages: {
            specification:"请输入规格",
            unit_code:"请输入单位"
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
    weekStart: 1,
    todayBtn:  "linked",
    clearBtn:1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1,
});

function exportExcelData(){
    var _form = $('#search_form');

    <#if model_column?exists>
        <#list model_column as model>
    var ${model.changeColumnName?uncap_first}=_form.find('#${model.changeColumnName?uncap_first}').val();
        </#list>
    var path = '/app/exportDate/${table_name_first_low}s/export?'
        <#list model_column as model>
               +'&${model.changeColumnName?uncap_first}='+${model.changeColumnName?uncap_first}
        </#list>
        ;
    </#if>
    var content ="确定导出数据?";
    $.confirm(content,"确定","取消",function (){
        window.open(path);
    });
}
</script>