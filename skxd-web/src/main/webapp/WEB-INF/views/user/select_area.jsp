<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form class="form-horizontal" method="post" modelAttribute="user">
<div class="portlet box grey-cascade" id="panel-select-assessor">
    <div class="portlet-body">
        <input type="hidden" name="select_userId" value="${user.id}"/>
        <table class="common_search">
            <tr align="center">
                <td>
                    <div class="form-group">
                        <div class="skxd-condition-l">选择角色：</div>
                        <div class="skxd-width-200 skxd-float-left">
                            <form:select path="roleId" class="form-control selectpicker">
                                <form:options items="${roles}" itemLabel="roleName" itemValue="id"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="skxd-condition-l">公司名称：</div>
                        <div class="skxd-width-200 skxd-float-left">
                            <input type="text" name="company" value="${company}"/>
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="button" value="确定" class="btn green" onclick="panel_select_area.modify_area();"/>
                </td>
            </tr>
        </table>
    </div>
</div>
</form:form>
<script>
    var panel_select_area_panel = $("#panel-select-area");
    var panel_select_area = {};
    panel_select_area.modify_area = function () {
        var roleId = $("select[name=roleId] option:selected").val();
        var userId = $("input[name=select_userId]").val();
        var leader = $("select[name=leader] option:selected").val();
        var company= $("input[name=company]").val();
        $.getJSON(contextPath + "/admin/user/modifySkxdUser", {
            id: userId,
            roleId: roleId,
            leader:leader,
            company:company
        }, function (json) {
            TABLE.refresh('dataTable-user');
            closeMessageDialog();
        });
    };

</script>