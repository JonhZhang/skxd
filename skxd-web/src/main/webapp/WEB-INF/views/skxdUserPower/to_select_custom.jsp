<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-select-custom">
    <div class="portlet-body">
        <div id="custom_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="custom_search_all" placeholder="请输入搜索内容"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">是否已选</span>
                            <select class="form-control" onchange="TABLE.preSearch('data_table_select_custom',this,1);">
                                <option value="" selected="selected">全部</option>
                                <option value="1">已选择</option>
                                <option value="0">未选择</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_select_custom',document.getElementById('custom_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="上一步" class="btn green"
                               onclick="javascript:zxsUser.selectArea('${userId}',2);"/>
                        <input type="button" value="下一步" class="btn green"
                               onclick="javascript:zxsUser.selectDevice('${userId}');"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_select_custom" cellspacing="0" width="100%"
               class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<input type="hidden" value="3" name="level" id="level">
<input type="hidden" value="${customIds}" name="customIds" id="customIds">
<input type="hidden" name="selectUserId" value="${userId}">
<script>
    var selectCustomPage = {};
    var userId = $("input[name='selectUserId']").val();
    var level = $("#level").val();
    selectCustomPage.selectCustom = function (id) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/selectArea",
            data: {"userId": userId, "level": 3, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("input[name='customIds']").val(result.data);
                    $("#" + value).parent().html("<input type='button' value='移除'  id='" + value + "' class='btn' onclick=\"selectCustomPage.deleteCustom('" + value + "'," + level + ");\" style='background-color:#E71C33;color: #FFFFFF;'/>");
                }
            }
        });
    };
    selectCustomPage.deleteCustom = function (id) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/deleteArea",
            data: {"userId": userId, "level": 3, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("input[name='customIds']").val(result.data);
                    $("#" + value).parent().html("<input type='button' value='添加'  id='" + value + "' class='btn green' onclick=\"selectCustomPage.selectCustom('" + value + "'," + level + ");\" />");
                }
            }
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_select_custom",
            "url": contextPath + "/admin/skxdUserPower/skxdCustomPage?userId=" + userId,
            "pageSize": 5,
            "aoColumns": [
                {"mData": 'customName', "sTitle": "客户名称"},
                {"mData": 'address', "sTitle": "客户地址"},
                {
                    "mData": 'id', "sTitle": "操作", width: 70, render: function (id, obj, row) {
                    var temp = $("input[name='customIds']").val();
                    if (temp == null || temp == "") {
                        return "<input type='button' id='" + row.id + "'   value='添加' class='btn green' onclick=\"selectCustomPage.selectCustom('" + row.id + "');\"/>";
                    } else {
                        if (temp.isContains(row.id)) {
                            return "<input type='button' id='" + row.id + "' value='移除'  class='btn' onclick=\"selectCustomPage.deleteCustom('" + row.id + "');\"' style='background-color:#E71C33;color: #FFFFFF;'/>";
                        } else {
                            return "<input type='button' id='" + row.id + "' value='添加' class='btn green' onclick=\"selectCustomPage.selectCustom('" + row.id + "');\"/>";
                        }
                    }
                }
                }
            ],
            initComplete: function () {
                $("#data_table_select_custom_wrapper .toolbar").html($("#custom_search").html());
                $("#custom_search").html("");
            }
        });
    });
</script>