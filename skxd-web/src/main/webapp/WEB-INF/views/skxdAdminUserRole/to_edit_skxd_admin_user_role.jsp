<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="" id="skxdAdminUserRole_form_saveOrUpdate" class="form-horizontal" method="post"
           modelAttribute="skxdAdminUserRole">
    <div class="portlet-body form" id="panel_skxdAdminUserRole_form_saveOrUpdate">
        <form:hidden path="id" name="id"/>
        <div class="form-body">
            <div class="alert alert-danger display-hide">
                <button class="close" data-close="alert"></button>
                数据有误,请检查表单输入内容
            </div>
            <div class="alert alert-success display-hide">
                <button class="close" data-close="alert"></button>
                验证成功,服务器正在飞奔接收数据
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">用户名<span class="required">*</span></label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="userId" type="hidden" class="form-control" name="userId"/>
                        <input type="text" value="${skxdAdminUser.name}" class="form-control" disabled>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">分配角色<span class="required">*</span></label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="roleId" class="form-control" name="roleId">
                            <form:options items="${skxdAdminRoleList}" itemLabel="roleName" itemValue="id"/>
                        </form:select>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-actions">
        <div class="row">
            <div class="col-md-offset-4 col-md-9">
                <button type="submit" class="btn green">提交</button>
                <button type="button" class="btn close-dialog">取消</button>
            </div>
        </div>
    </div>
</form:form>
<script>
    var update_skxdAdminUserRole_panel = $("#panel_skxdAdminUserRole_form_saveOrUpdate");
    var skxdAdminUserRole_form = $('#skxdAdminUserRole_form_saveOrUpdate');
    var skxdAdminUserRole_error = $('.alert-danger', skxdAdminUserRole_form);
    var skxdAdminUserRole_success = $('.alert-success', skxdAdminUserRole_form);
    $(document).ready(function () {
        $("#skxdAdminUserRole_form_saveOrUpdate").validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            messages: {
                select_multi: {
                    maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                    minlength: jQuery.validator.format("At least {0} items must be selected")
                }
            },
            rules: {
                roleId: {
                    required: true
                }
                ,
                adminUserId: {
                    required: true
                }
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                skxdAdminUserRole_success.hide();
                skxdAdminUserRole_error.show();
                Metronic.scrollTo(skxdAdminUserRole_error, -200);
            }
            ,
            highlight: function (element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            }
            ,
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
            }
            ,
            success: function (label) {
                skxdAdminUserRole_error.hide();
                label.closest('.form-group').removeClass('has-error'); // set success class to the control group
            }
            ,
            submitHandler: function (form) {
                $.ajax({
                    url: contextPath + "/admin/skxdAdminUserRole/saveOrUpdateSkxdAdminUserRole",
                    method: "post",
                    data: $("#skxdAdminUserRole_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        window.closeMessageDialog();
                        return false;
                    }
                });
                return false;
            }
        });
    });
</script>