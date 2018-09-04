<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-device">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>仪器信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_device');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="device_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="device_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">仪器编号</span>
                            <input type="text" class="form-control" placeholder="请输入仪器编号"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_device',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">仪器型号</span>
                            <input type="text" class="form-control" placeholder="请输入仪器型号"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_device',this,2);"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_device',document.getElementById('device_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="device_delete" class="btn green"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="导出数据"   class="btn green" id="device_export" onclick=""/>
                        <input type="button" value="导入excel" class="btn green" id="device_import" onclick=""/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_device" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    devicePage.modify_device_by_id=function(id) {
        TAB.create_tab({id:'83392C7D1839401A925556BB7D786894',name:'仪器信息详情',url:'${ctx}/admin/custom/toUpdateDevice?id='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_device",
            "url": contextPath + "/admin/custom/devicePage?customId=${customId}",
            "aoColumns": [
                {"mData": 'deviceNo', "sTitle": "仪器编号"},
                {"mData": 'deviceType', "sTitle": "仪器型号"},
                {"mData": 'customName', "sTitle": "客户姓名"},
                {"mData": 'departMentName', "sTitle": "部门名称"},
                {"mData": 'leaderName', "sTitle": "负责人姓名"},
                {"mData": 'seller', "sTitle": "销售商"},
                {"mData": 'server', "sTitle": "服务商"},
                {"mData": 'installTime', "sTitle": "安装时间"},
                {"mData": 'installer', "sTitle": "安装人"},
                {"mData": 'deviceState', "sTitle": "设备状态"},
                {"mData": 'projectRemark', "sTitle": "项目开展状况"},
                {"mData": 'competitor', "sTitle": "对手信息"},
                {"mData": 'createdUser', "sTitle": "创建人"},
                {"mData": 'createdDate', "sTitle": "创建时间"},

                {
                    "mData": 'id', "sTitle": "详细信息", render: function (id) {
                     var a1 = "<a onclick=\"devicePage.modify_device_by_id('" + id + "')\">详细信息</a>";
                     return a1;
                    }
                }
            ],
            initComplete: function () {
                $("#data_table_device_wrapper .toolbar").html($("#device_search").html());
                $("#device_search").html("");
                $('#device_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].deviceNo;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除编号为: [" + names + "] " + array.length + "个仪器吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/custom/removeDeviceByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_device');
                                        }
                                        return false;
                                    }
                                });
                            }
                        });
                    }
                });
                //导出数据
                $('#device_export').click(function(){
                    window.location.href=contextPath + "/admin/custom/exportDeviceExcel";
                });
                //导入数据
                $('#device_import').click(function(){
                    window.messageDialog({
                        title: "导入仪器数据",
                        url: "${ctx}/admin/custom/toImportDeviceExcel"
                    });
                });
            }
        });
    });
</script>