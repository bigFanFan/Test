<div class="col-xs-12 nopd-lr wigtbox-head form-inline">
    <form id="search_form" action="/app/products/grid" method="Post">
        <div class="pull-left">
            <input type="text" class="form-control" name="id" id="id" placeholder="商品ID" />
            <input type="text" class="form-control" name="productCode" id="productCode" placeholder="商品编码" />
            <input type="text" class="form-control" name="productName" id="productName" placeholder="商品名称" />
            <input type="text" class="form-control" name="groupId" id="groupId" placeholder="分类ID" />
            <input type="text" class="form-control" name="sourceCode" id="sourceCode" placeholder="产地id" />
            <input type="text" class="form-control" name="image" id="image" placeholder="商品主图" />
            <input type="text" class="form-control" name="smallImage" id="smallImage" placeholder="商品小图标" />
            <input type="text" class="form-control" name="largeImage" id="largeImage" placeholder="大图标" />
            <input type="text" class="form-control" name="status" id="status" placeholder="商品状态" />
            <input type="text" class="form-control" name="unitId" id="unitId" placeholder="基础单位id" />
            <input type="text" class="form-control" name="baseBarcode" id="baseBarcode" placeholder="基础条码" />
            <input type="text" class="form-control" name="hdSkuid" id="hdSkuid" placeholder="海鼎skuid" />
            <input type="text" class="form-control" name="videoUrl" id="videoUrl" placeholder="商品介绍视频地址" />
            <input type="text" class="form-control" name="videoImage" id="videoImage" placeholder="视频遮罩图片" />
            <input type="text" class="form-control" name="baseQty" id="baseQty" placeholder="基础重量，比如1个0.2kg填写0.2" />
            <input type="text" class="form-control" name="limitQty" id="limitQty" placeholder="允许销售的最低库存" />
            <input type="text" class="form-control" name="description" id="description" placeholder="商品描述" />

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
            <button class="btn btn-danger btn-sm" type="button"  onclick=confrimDel2("#grid-table","/app/products/delete")>
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
                <h4 class="modal-title">商品信息详情</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <input type="hidden" name="id" id="id" />
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品ID：</label>
                            <div class="id col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品编码：</label>
                            <div class="productCode col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品名称：</label>
                            <div class="productName col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">分类ID：</label>
                            <div class="groupId col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">产地id：</label>
                            <div class="sourceCode col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品主图：</label>
                            <div class="image col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品小图标：</label>
                            <div class="smallImage col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">大图标：</label>
                            <div class="largeImage col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品状态：</label>
                            <div class="status col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">基础单位id：</label>
                            <div class="unitId col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">基础条码：</label>
                            <div class="baseBarcode col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">海鼎skuid：</label>
                            <div class="hdSkuid col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品介绍视频地址：</label>
                            <div class="videoUrl col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">视频遮罩图片：</label>
                            <div class="videoImage col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">基础重量，比如1个0.2kg填写0.2：</label>
                            <div class="baseQty col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">允许销售的最低库存：</label>
                            <div class="limitQty col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">商品描述：</label>
                            <div class="description col-md-7 nopd-lr"></div>
                        </div>
                    </div>
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
                <h4 class="modal-title pull-left">添加商品信息</h4>
                <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div class="clearfix"></div>
            </div>
            <div class="modal-body text-center">
                <form id="info_form" method="Post" class="form-horizontal" action="/app/products/modify">
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="id" class="col-md-5">商品ID</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="id" id="id" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="productCode" class="col-md-5">商品编码</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="productCode" id="productCode" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="productName" class="col-md-5">商品名称</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="productName" id="productName" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="groupId" class="col-md-5">分类ID</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="groupId" id="groupId" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="sourceCode" class="col-md-5">产地id</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="sourceCode" id="sourceCode" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="image" class="col-md-5">商品主图</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="image" id="image" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="smallImage" class="col-md-5">商品小图标</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="smallImage" id="smallImage" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="largeImage" class="col-md-5">大图标</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="largeImage" id="largeImage" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="status" class="col-md-5">商品状态</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="status" id="status" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="unitId" class="col-md-5">基础单位id</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="unitId" id="unitId" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="baseBarcode" class="col-md-5">基础条码</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="baseBarcode" id="baseBarcode" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="hdSkuid" class="col-md-5">海鼎skuid</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="hdSkuid" id="hdSkuid" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="videoUrl" class="col-md-5">商品介绍视频地址</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="videoUrl" id="videoUrl" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="videoImage" class="col-md-5">视频遮罩图片</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="videoImage" id="videoImage" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="baseQty" class="col-md-5">基础重量，比如1个0.2kg填写0.2</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="baseQty" id="baseQty" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="limitQty" class="col-md-5">允许销售的最低库存</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="limitQty" id="limitQty" placeholder=""/></div>
                        </div>
                        <div class="col-md-12">
                            <label for="description" class="col-md-5">商品描述</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="description" id="description" placeholder=""/></div>
                        </div>
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
        url:"/app/products/grid",
        mtype: "post",
        datatype: "json",
        height: '100%',
        colNames:[
            '商品ID',
            '商品编码',
            '商品名称',
            '分类ID',
            '产地id',
            '商品主图',
            '商品小图标',
            '大图标',
            '商品状态',
            '基础单位id',
            '基础条码',
            '海鼎skuid',
            '商品介绍视频地址',
            '视频遮罩图片',
            '基础重量，比如1个0.2kg填写0.2',
            '允许销售的最低库存',
            '商品描述',
            '操作'],
        colModel:[
        {name:'id',index:'id', editable: false},
        {name:'productCode',index:'productCode', editable: false},
        {name:'productName',index:'productName', editable: false},
        {name:'groupId',index:'groupId', editable: false},
        {name:'sourceCode',index:'sourceCode', editable: false},
        {name:'image',index:'image', editable: false},
        {name:'smallImage',index:'smallImage', editable: false},
        {name:'largeImage',index:'largeImage', editable: false},
        {name:'status',index:'status', editable: false},
        {name:'unitId',index:'unitId', editable: false},
        {name:'baseBarcode',index:'baseBarcode', editable: false},
        {name:'hdSkuid',index:'hdSkuid', editable: false},
        {name:'videoUrl',index:'videoUrl', editable: false},
        {name:'videoImage',index:'videoImage', editable: false},
        {name:'baseQty',index:'baseQty', editable: false},
        {name:'limitQty',index:'limitQty', editable: false},
        {name:'description',index:'description', editable: false},
        {name:'myac',index:'', fixed:true, sortable:false, resize:false,
             formatter: function(value,grid,rows,state){
                 return '<a class="btn btn-info btn-xs mr5" data-toggle="modal" data-target="#detail-dialog" data-id="'+rows.id+'" title="查看详情"><i class="fa fa-eye"></i></a>'+
                         '<a class="btn btn-warning btn-xs mr5" data-toggle="modal" data-target="#info-dialog" title="修改" data-id="'+rows.id+'"><i class="fa fa-edit"></i></a>'+
                         '<a class="btn btn-danger btn-xs mr5" data-toggle="tooltip" data-placement="top" title="删除" onclick=confrimDel2("#grid-table","/app/products/delete")><i class="fa fa-trash"></i></a>';
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
        editurl: "",//不需要
        caption: "商品信息管理",
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
            url:'/app/products/detail',
            type:'Get',
            data:{id:id},
            success:function(result){
                if(result){
                    //回填数据
                    modal.find('.id').text(result.id);
                    modal.find('.productCode').text(result.productCode);
                    modal.find('.productName').text(result.productName);
                    modal.find('.groupId').text(result.groupId);
                    modal.find('.sourceCode').text(result.sourceCode);
                    modal.find('.image').text(result.image);
                    modal.find('.smallImage').text(result.smallImage);
                    modal.find('.largeImage').text(result.largeImage);
                    modal.find('.status').text(result.status);
                    modal.find('.unitId').text(result.unitId);
                    modal.find('.baseBarcode').text(result.baseBarcode);
                    modal.find('.hdSkuid').text(result.hdSkuid);
                    modal.find('.videoUrl').text(result.videoUrl);
                    modal.find('.videoImage').text(result.videoImage);
                    modal.find('.baseQty').text(result.baseQty);
                    modal.find('.limitQty').text(result.limitQty);
                    modal.find('.description').text(result.description);
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
                url:'/app/products/detail',
                type:'Get',
                data:{id:id},
                success:function(result){
                    if(result){
                        //回填数据
                        modal.find('#id').val(result.id);
                        modal.find('#productCode').val(result.productCode);
                        modal.find('#productName').val(result.productName);
                        modal.find('#groupId').val(result.groupId);
                        modal.find('#sourceCode').val(result.sourceCode);
                        modal.find('#image').val(result.image);
                        modal.find('#smallImage').val(result.smallImage);
                        modal.find('#largeImage').val(result.largeImage);
                        modal.find('#status').val(result.status);
                        modal.find('#unitId').val(result.unitId);
                        modal.find('#baseBarcode').val(result.baseBarcode);
                        modal.find('#hdSkuid').val(result.hdSkuid);
                        modal.find('#videoUrl').val(result.videoUrl);
                        modal.find('#videoImage').val(result.videoImage);
                        modal.find('#baseQty').val(result.baseQty);
                        modal.find('#limitQty').val(result.limitQty);
                        modal.find('#description').val(result.description);
                    }
                    else
                    {
                        $.alert('提示','操作失败 ！');
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
        var data=JSON.stringify(getFromJsonData('#info_form'););

        if($('#info_form').valid()){
            $.ajax({
                url:'/app/products/modify',
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
             id:"required",
             productCode:"required",
             productName:"required",
             groupId:"required",
             sourceCode:"required",
             image:"required",
             smallImage:"required",
             largeImage:"required",
             status:"required",
             unitId:"required",
             baseBarcode:"required",
             hdSkuid:"required",
             videoUrl:"required",
             videoImage:"required",
             baseQty:"required",
             limitQty:"required",
             description:"required",
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
    format:"yyyy-mm-dd hh:ii:ss",
    weekStart: 1,
    todayBtn:  "linked",
    clearBtn:1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    minView:'hour',
    showMeridian: false,
    language:'zh-CN'
});

function exportExcelData(){
    //Ajax提交表单数据
    var paramData={};

    // 导出查询条件对象
    paramData.searchParam = getFromJsonData('#search_form');
    // 请求导出列表url
    paramData.requestUrl = Common.local.serverRequest.concat("/app/products/grid");
    // 导出显示表头名称字符串,逗号分割
    paramData.colName ="商品ID,商品编码,商品名称,分类ID,产地id,商品主图,商品小图标,大图标,商品状态,基础单位id,基础条码,海鼎skuid,商品介绍视频地址,视频遮罩图片,基础重量，比如1个0.2kg填写0.2,允许销售的最低库存,商品描述,";

    // 导出显示表头对应字段字符串,逗号分割
    paramData.keyStr ="id,productCode,productName,groupId,sourceCode,image,smallImage,largeImage,status,unitId,baseBarcode,hdSkuid,videoUrl,videoImage,baseQty,limitQty,description,";

    // 导出显示标题
    paramData.title = "商品信息管理";

    // 需要翻译字段信息 格式{status:{on:"进行中",off:"未开启",expire:"已结束"}}
    paramData.translateDicts = translateDicts();

    var data=JSON.stringify(paramData);
    var path = '/app/export?params='+data;
    var content ="确定导出数据?";
    $.confirm(content,"确定","取消",function (){
        window.open(path);
    });
}

/**
 * 翻译字典    fieldName不传值或者为空或者value不传值或空返回所有字典数据对象
 * fieldName 需要翻译的字段名称，value 需要翻译的字段值
 */
function translateDicts(fieldName,value) {

    //定义页面字典数据  start
    var translateDicts = {};
    translateDicts.imageStatus = {
        "ON": "开启",
        "OFF": "关闭"
    };
    //定义页面字典数据  end

    if (fieldName == undefined || fieldName == ''
            || value == undefined || value == '') {
        return translateDicts;
    }


    var translateDictName = '';//需要翻译字典名称
    //判断字段名称存在字典对象  并且值也存在,则获取翻译名称
    if(translateDicts.hasOwnProperty(fieldName)
            && translateDicts[fieldName].hasOwnProperty(value)){
        translateDictName = translateDicts[fieldName][value];
    }
    return (translateDictName == undefined || translateDictName == '') ? "N/A" : translateDictName;
}
</script>