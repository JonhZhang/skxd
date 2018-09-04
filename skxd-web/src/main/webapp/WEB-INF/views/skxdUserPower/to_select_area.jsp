<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdUserPower">
    <div class="portlet-body">
        <div id="skxdUserPower_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">区域名称</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdUserPower',this);"
                                   id="skxdUserPower_search_all"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">是否已选</span>
                            <select class="form-control" onchange="TABLE.preSearch('data_table_skxdUserPower',this,1);">
                                <option value="" selected="selected">全部</option>
                                <option value="1">已选择</option>
                                <option value="0">未选择</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdUserPower',document.getElementById('skxdUserPower_search_all'));"/>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${level==1}">
                                <input type="button" value="下一步" class="btn green"
                                       onclick="javascript:zxsUser.selectArea('${userId}',2);"/>
                            </c:when>
                            <c:when test="${level==2}">
                                <input type="button" value="上一步" class="btn green"
                                       onclick="javascript:zxsUser.selectArea('${userId}',1);"/>
                                <input type="button" value="下一步" class="btn green"
                                       onclick="javascript:zxsUser.selectCustom('${userId}');"/>
                            </c:when>
                            <%--<c:when test="${level==3}">--%>
                            <%--<input type="button" value="上一步" class="btn green"  onclick="javascript:zxsUser.selectArea('${userId}',2);"/>--%>
                            <%--<input type="button" value="下一步" class="btn green"  onclick="javascript:zxsUser.selectArea('${userId}',2);"/>--%>
                            <%--</c:when>--%>
                            <%--<c:when test="${level==4}">--%>
                            <%--<input type="button" value="上一步" class="btn green"  onclick="javascript:zxsUser.selectArea('${userId}',2);"/>--%>
                            <%--</c:when>--%>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdUserPower" cellspacing="0" width="100%"
               class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<!--选择到的省份-->
<input type="hidden" value="${level}" name="level" id="level">
<input type="hidden" value="${areaNos}" name="areaNos" id="areaNos">
<input type="hidden" name="selectUserId" value="${userId}">
<script>
    //选择区域
    var selectAreaPage = {};
    var userId = $("input[name='selectUserId']").val();
    var areaNos = $("input[name='areaNos']").val();
    var level = $("#level").val();
    selectAreaPage.selectArea = function (id, level) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/selectArea",
            data: {"userId": userId, "level": level, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("input[name='areaNos']").val(result.data);
                    $("#" + value).parent().html("<input type='button'  id='" + value + "'  value='移除' class='btn' onclick=\"selectAreaPage.deleteArea('" + value + "'," + level + ");\" style='background-color:#E71C33;color: #FFFFFF;'/>");
                }
            }
        });
    };
    selectAreaPage.deleteArea = function (id, level) {
        var value = id;
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/deleteArea",
            data: {"userId": userId, "level": level, value: value},
            success: function (result) {
                if (result.status == 1) {
                    $("input[name='areaNos']").val(result.data);
                    $("#" + value).parent().html("<input type='button' id='" + value + "' value='添加' class='btn green' onclick=\"selectAreaPage.selectArea('" + value + "'," + level + ");\" />");
                }
            }
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdUserPower",
            "url": contextPath + "/admin/skxdUserPower/skxdAreaPage?level=" + level + "&userId=" + userId,
            "pageSize": 5,
            "aoColumns": [
                {"mData": 'name', "sTitle": "区域名称"},
                {"mData": 'areaNo', "sTitle": "区域编码"},
                {
                    "mData": 'id', "sTitle": "操作", width: 70, render: function (id, obj, row) {
                    var temp = $("input[name='areaNos']").val();
                    if (temp == null || temp == "") {
                        return "<input type='button' id='" + row.areaNo + "'   value='添加' class='btn green' onclick=\"selectAreaPage.selectArea('" + row.areaNo + "'," + row.level + ");\"/>";
                    } else {
                        if (temp.isContains(row.areaNo)) {
                            return "<input type='button' id='" + row.areaNo + "' value='移除'  class='btn' onclick=\"selectAreaPage.deleteArea('" + row.areaNo + "'," + row.level + ");\"' style='background-color:#E71C33;color: #FFFFFF;'/>";
                        } else {
                            return "<input type='button' id='" + row.areaNo + "' value='添加' class='btn green' onclick=\"selectAreaPage.selectArea('" + row.areaNo + "'," + row.level + ");\"/>";
                        }
                    }
                }
                }
            ],
            initComplete: function () {
                $("#data_table_skxdUserPower_wrapper .toolbar").html($("#skxdUserPower_search").html());
                $("#skxdUserPower_search").html("");
            }
        });
    });
</script>