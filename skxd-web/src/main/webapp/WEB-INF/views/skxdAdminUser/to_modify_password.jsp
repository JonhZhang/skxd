<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="" id="skxdAdminUser_form_modifyPasswrd" class="form-horizontal" method="post"  modelAttribute="skxdAdminUser">
    <div class="portlet-body form" id="panel_skxdAdminUser_form_modifyPasswrd">
        <form:hidden path="id" name="id"/>
        <div class="form-body">
            <div class="alert alert-danger display-hide">
                <button class="close" data-close="alert"></button>
                数据有误,请检查表单输入内容
            </div>
            <div class="alert alert-success display-hide ">
                <button class="close" data-close="alert"></button>
                验证成功,服务器正在飞奔接收数据
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">用户名<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="name" type="text" class="form-control" name="name" disabled="true"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">旧密码<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="password" name="oldPassword" class="form-control" >
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">新密码<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="password" name="newPassword" class="form-control" >
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">确认新密码<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="password" name="newPassword1" class="form-control" >
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-actions">
        <div class="row">
            <div class="col-md-offset-4 col-md-9">
                <button type="submit" class="btn green">提交</button>
                <button type="button" class="btn default close-dialog">取消</button>
            </div>
        </div>
    </div>
</form:form>
<script>
    var update_skxdAdminUser_panel = $("#panel_skxdAdminUser_form_modifyPasswrd");
    var skxdAdminUser_form = $('#skxdAdminUser_form_modifyPasswrd');
    var skxdAdminUser_error = $('.alert-danger', skxdAdminUser_form);
    var skxdAdminUser_success = $('.alert-success', skxdAdminUser_form);
    $(document).ready(function () {
        $("#skxdAdminUser_form_modifyPasswrd").validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",  // validate all fields including form hidden input
            messages: {
                oldPassword:"旧密码不能为空",
                newPassword:"新密码不能为空",
                newPassword1:"确认密码不能为空"
            },
            rules: {
                oldPassword: {
                    required: true
                },
                newPassword:{
                    required: true
                },
                newPassword1:{
                    required: true
                },
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                skxdAdminUser_success.hide();
                skxdAdminUser_error.show();
                Metronic.scrollTo(skxdAdminUser_error, -200);
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
                skxdAdminUser_error.hide();
                label.closest('.form-group').removeClass('has-error'); // set success class to the control group
            }
            ,
            submitHandler: function (form) {
                var newPassword=update_skxdAdminUser_panel.find("input[name=newPassword]").val();
                var newPassword1=update_skxdAdminUser_panel.find("input[name=newPassword1]").val();
                if(newPassword!=newPassword1){
                    $('.alert-oldPassword-error',skxdAdminUser_form).html("两次新密码不一致");
                    $('.alert-oldPassword-error',skxdAdminUser_form).show();
                }else{
                    $.ajax({
                        url: contextPath + "/admin/skxdAdminUser/modifyPassword",
                        method: "post",
                        data: $("#skxdAdminUser_form_modifyPasswrd").serialize(),
                        success: function (json) {
                            if(json.status==1){
                                $('.alert-danger',skxdAdminUser_form).hide();
                                window.closeMessageDialog();
                            }else{
                                $('.alert-danger',skxdAdminUser_form).html(json.message);
                                $('.alert-danger',skxdAdminUser_form).show();
                            }
                            return false;
                        }
                    });
                }
                return false;
            }
        });
    });
</script>

