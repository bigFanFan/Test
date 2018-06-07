<div class="col-xs-12 nopd-lr wigtbox-head form-inline">
    <form id="search_form" action="/app/store-baks/grid" method="Post">
        <div class="pull-left">
            <input type="text" class="form-control" name="id" id="id" placeholder="门店id" />
            <input type="text" class="form-control" name="storeCode" id="storeCode" placeholder="门店编码" />
            <input type="text" class="form-control" name="storeName" id="storeName" placeholder="门店名称" />
            <input type="text" class="form-control" name="storeAddress" id="storeAddress" placeholder="门店地址" />
            <input type="text" class="form-control" name="storePhone" id="storePhone" placeholder="联系方式" />
            <input type="text" class="form-control" name="storeImage" id="storeImage" placeholder="门店图片" />
            <input type="text" class="form-control" name="storeArea" id="storeArea" placeholder="所属区域" />
            <input type="text" class="form-control" name="lng" id="lng" placeholder="坐标位置（经度）" />
            <input type="text" class="form-control" name="lat" id="lat" placeholder="坐标位置（纬度）" />
            <input type="text" class="form-control" name="storeStatus" id="storeStatus" placeholder="门店状态(0-未开启  1-开启)" />
            <input type="text" class="form-control" name="storeFlagship" id="storeFlagship" placeholder="旗舰店ID" />
            <input type="text" class="form-control" name="storeType" id="storeType" placeholder="门店类型：00-普通门店  01-旗舰店" />
            <input type="text" class="form-control" name="videoUrl" id="videoUrl" placeholder="门店视频" />
            <input type="text" class="form-control" name="activityUrl" id="activityUrl" placeholder="活动直播url" />
            <input type="text" class="form-control" name="switchStatus" id="switchStatus" placeholder="切换直播 0-门店直播 1-活动直播" />

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
            <button class="btn btn-danger btn-sm" type="button"  onclick=confrimDel2("#grid-table","/app/store-baks/delete")>
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
                <h4 class="modal-title">门店详情</h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <input type="hidden" name="id" id="id" />
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店id：</label>
                            <div class="id col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店编码：</label>
                            <div class="storeCode col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店名称：</label>
                            <div class="storeName col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店地址：</label>
                            <div class="storeAddress col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">联系方式：</label>
                            <div class="storePhone col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店图片：</label>
                            <div class="storeImage col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">所属区域：</label>
                            <div class="storeArea col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">坐标位置（经度）：</label>
                            <div class="lng col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">坐标位置（纬度）：</label>
                            <div class="lat col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店状态(0-未开启  1-开启)：</label>
                            <div class="storeStatus col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">旗舰店ID：</label>
                            <div class="storeFlagship col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店类型：00-普通门店  01-旗舰店：</label>
                            <div class="storeType col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">门店视频：</label>
                            <div class="videoUrl col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">活动直播url：</label>
                            <div class="activityUrl col-md-7 nopd-lr"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label class="col-md-5">切换直播 0-门店直播 1-活动直播：</label>
                            <div class="switchStatus col-md-7 nopd-lr"></div>
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
                <h4 class="modal-title pull-left">添加门店</h4>
                <button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <div class="clearfix"></div>
            </div>
            <div class="modal-body text-center">
                <form id="info_form" method="Post" class="form-horizontal" action="/app/store-baks/modify">
                    <div class="form-group">
                        <div class="col-md-6">
                            <label for="id" class="col-md-5">门店id</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="id" id="id" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeCode" class="col-md-5">门店编码</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeCode" id="storeCode" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeName" class="col-md-5">门店名称</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeName" id="storeName" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeAddress" class="col-md-5">门店地址</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeAddress" id="storeAddress" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storePhone" class="col-md-5">联系方式</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storePhone" id="storePhone" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeImage" class="col-md-5">门店图片</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeImage" id="storeImage" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeArea" class="col-md-5">所属区域</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeArea" id="storeArea" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="lng" class="col-md-5">坐标位置（经度）</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="lng" id="lng" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="lat" class="col-md-5">坐标位置（纬度）</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="lat" id="lat" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeStatus" class="col-md-5">门店状态(0-未开启  1-开启)</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeStatus" id="storeStatus" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeFlagship" class="col-md-5">旗舰店ID</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeFlagship" id="storeFlagship" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="storeType" class="col-md-5">门店类型：00-普通门店  01-旗舰店</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="storeType" id="storeType" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="videoUrl" class="col-md-5">门店视频</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="videoUrl" id="videoUrl" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="activityUrl" class="col-md-5">活动直播url</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="activityUrl" id="activityUrl" placeholder=""/></div>
                        </div>
                        <div class="col-md-6">
                            <label for="switchStatus" class="col-md-5">切换直播 0-门店直播 1-活动直播</label>
                            <div class="col-md-7 nopd-l"><input type="text" class="form-control" name="switchStatus" id="switchStatus" placeholder=""/></div>
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
        url:"/app/store-baks/grid",
        mtype: "post",
        datatype: "json",
        height: '100%',
        colNames:[
            '门店id',
            '门店编码',
            '门店名称',
            '门店地址',
            '联系方式',
            '门店图片',
            '所属区域',
            '坐标位置（经度）',
            '坐标位置（纬度）',
            '门店状态(0-未开启  1-开启)',
            '旗舰店ID',
            '门店类型：00-普通门店  01-旗舰店',
            '门店视频',
            '活动直播url',
            '切换直播 0-门店直播 1-活动直播',
            '操作'],
        colModel:[
        {name:'id',index:'id', editable: false},
        {name:'storeCode',index:'storeCode', editable: false},
        {name:'storeName',index:'storeName', editable: false},
        {name:'storeAddress',index:'storeAddress', editable: false},
        {name:'storePhone',index:'storePhone', editable: false},
        {name:'storeImage',index:'storeImage', editable: false},
        {name:'storeArea',index:'storeArea', editable: false},
        {name:'lng',index:'lng', editable: false},
        {name:'lat',index:'lat', editable: false},
        {name:'storeStatus',index:'storeStatus', editable: false},
        {name:'storeFlagship',index:'storeFlagship', editable: false},
        {name:'storeType',index:'storeType', editable: false},
        {name:'videoUrl',index:'videoUrl', editable: false},
        {name:'activityUrl',index:'activityUrl', editable: false},
        {name:'switchStatus',index:'switchStatus', editable: false},
        {name:'myac',index:'', fixed:true, sortable:false, resize:false,
             formatter: function(value,grid,rows,state){
                 return '<a class="btn btn-info btn-xs mr5" data-toggle="modal" data-target="#detail-dialog" data-id="'+rows.id+'" title="查看详情"><i class="fa fa-eye"></i></a>'+
                         '<a class="btn btn-warning btn-xs mr5" data-toggle="modal" data-target="#info-dialog" title="修改" data-id="'+rows.id+'"><i class="fa fa-edit"></i></a>'+
                         '<a class="btn btn-danger btn-xs mr5" data-toggle="tooltip" data-placement="top" title="删除" onclick=confrimDel2("#grid-table","/app/store-baks/delete")><i class="fa fa-trash"></i></a>';
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
        caption: "门店管理",
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
            url:'/app/store-baks/detail',
            type:'Get',
            data:{id:id},
            success:function(result){
                if(result){
                    //回填数据
                    modal.find('.id').text(result.id);
                    modal.find('.storeCode').text(result.storeCode);
                    modal.find('.storeName').text(result.storeName);
                    modal.find('.storeAddress').text(result.storeAddress);
                    modal.find('.storePhone').text(result.storePhone);
                    modal.find('.storeImage').text(result.storeImage);
                    modal.find('.storeArea').text(result.storeArea);
                    modal.find('.lng').text(result.lng);
                    modal.find('.lat').text(result.lat);
                    modal.find('.storeStatus').text(result.storeStatus);
                    modal.find('.storeFlagship').text(result.storeFlagship);
                    modal.find('.storeType').text(result.storeType);
                    modal.find('.videoUrl').text(result.videoUrl);
                    modal.find('.activityUrl').text(result.activityUrl);
                    modal.find('.switchStatus').text(result.switchStatus);
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
                url:'/app/store-baks/detail',
                type:'Get',
                data:{id:id},
                success:function(result){
                    if(result){
                        //回填数据
                        modal.find('#id').val(result.id);
                        modal.find('#storeCode').val(result.storeCode);
                        modal.find('#storeName').val(result.storeName);
                        modal.find('#storeAddress').val(result.storeAddress);
                        modal.find('#storePhone').val(result.storePhone);
                        modal.find('#storeImage').val(result.storeImage);
                        modal.find('#storeArea').val(result.storeArea);
                        modal.find('#lng').val(result.lng);
                        modal.find('#lat').val(result.lat);
                        modal.find('#storeStatus').val(result.storeStatus);
                        modal.find('#storeFlagship').val(result.storeFlagship);
                        modal.find('#storeType').val(result.storeType);
                        modal.find('#videoUrl').val(result.videoUrl);
                        modal.find('#activityUrl').val(result.activityUrl);
                        modal.find('#switchStatus').val(result.switchStatus);
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
                url:'/app/store-baks/modify',
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

    var id=_form.find('#id').val();
    var storeCode=_form.find('#storeCode').val();
    var storeName=_form.find('#storeName').val();
    var storeAddress=_form.find('#storeAddress').val();
    var storePhone=_form.find('#storePhone').val();
    var storeImage=_form.find('#storeImage').val();
    var storeArea=_form.find('#storeArea').val();
    var lng=_form.find('#lng').val();
    var lat=_form.find('#lat').val();
    var storeStatus=_form.find('#storeStatus').val();
    var storeFlagship=_form.find('#storeFlagship').val();
    var storeType=_form.find('#storeType').val();
    var videoUrl=_form.find('#videoUrl').val();
    var activityUrl=_form.find('#activityUrl').val();
    var switchStatus=_form.find('#switchStatus').val();
    var path = '/app/exportDate/store-baks/export?'
               +'&id='+id
               +'&storeCode='+storeCode
               +'&storeName='+storeName
               +'&storeAddress='+storeAddress
               +'&storePhone='+storePhone
               +'&storeImage='+storeImage
               +'&storeArea='+storeArea
               +'&lng='+lng
               +'&lat='+lat
               +'&storeStatus='+storeStatus
               +'&storeFlagship='+storeFlagship
               +'&storeType='+storeType
               +'&videoUrl='+videoUrl
               +'&activityUrl='+activityUrl
               +'&switchStatus='+switchStatus
        ;
    var content ="确定导出数据?";
    $.confirm(content,"确定","取消",function (){
        window.open(path);
    });
}
</script>