<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-device">
    <div class="portlet-body">
        <div id="device_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="device_search_all" placeholder="请输入搜索内容"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">是否已选</span>
                            <select class="form-control" onchange="TABLE.preSearch('data_table_device',this,3);">
                                <option value="" selected="selected">全部</option>
                                <option value="1">已选择</option>
                                <option value="0">未选择</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_device',document.getElementById('device_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="上一步" class="btn green"
                               onclick="javascript:zxsUser.selectCustom('${userId}');"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_device" cellspacing="0" width="100%"
               class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<input type="hidden" value="3" name="level" id="level">
<input type="hidden" value="${deviceIds}" name="deviceIds" id="deviceIds">
<input type="hidden" name="selectUserId" value="${userId}">
<script>
    var selectDevicePage = {};
    var userId = $("input[name='selectUserId']").val();
    var level = $("#level").val();
    selectDevicePage.selectDevice = function (id) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/selectArea",
            data: {"userId": userId, "level": 4, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("#deviceIds").val(result.data);
                    $("#" + value).parent().html("<input type='button' value='移除'  id='" + value + "' class='btn' onclick=\"selectDevicePage.deleteDevice('" + value + "'," + level + ");\" style='background-color:#E71C33;color: #FFFFFF;'/>");
                }
            }
        });
    };
    selectDevicePage.deleteDevice = function (id) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/deleteArea",
            data: {"userId": userId, "level": 4, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("#deviceIds").val(result.data);
                    $("#" + value).parent().html("<input type='button' value='添加'  id='" + value + "' class='btn green' onclick=\"selectDevicePage.selectDevice('" + value + "'," + level + ");\" />");
                }
            }
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_device",
            "url": contextPath + "/admin/skxdUserPower/skxdDevicePage?userId=${userId}",
            "pageSize":5,
            "aoColumns": [
                {"mData": 'deviceNo', "sTitle": "仪器编号"},
                {"mData": 'deviceType', "sTitle": "仪器型号"},
                {"mData": 'customName', "sTitle": "客户姓名"},
                {
                    "mData": 'id', "sTitle": "操作", width: 70, render: function (id, obj, row) {
                    var temp = $("#deviceIds").val();
                    if (temp == null || temp == "") {
                        return "<input type='button' id='" + row.id + "'   value='添加' class='btn green' onclick=\"selectDevicePage.selectDevice('" + row.id + "');\"/>";
                    } else {
                        if (temp.isContains(row.id)) {
                            return "<input type='button' id='" + row.id + "' value='移除'  class='btn' onclick=\"selectDevicePage.deleteDevice('" + row.id + "');\"' style='background-color:#E71C33;color: #FFFFFF;'/>";
                        } else {
                            return "<input type='button' id='" + row.id + "' value='添加' class='btn green' onclick=\"selectDevicePage.selectDevice('" + row.id + "');\"/>";
                        }
                    }
                }
                }
            ],
            initComplete: function () {
                $("#data_table_device_wrapper .toolbar").html($("#device_search").html());
                $("#device_search").html("");
            }
        });
    });
</script>