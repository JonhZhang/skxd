<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="" id="skxdAdminUser_form_saveOrUpdate" class="form-horizontal" method="post"
           modelAttribute="skxdAdminUser">
    <div class="portlet-body form" id="panel_skxdAdminUser_form_saveOrUpdate">
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
                        <form:input path="name" type="text" class="form-control" name="name"/>
                    </div>
                </div>
            </div>
            <c:if test="${empty skxdAdminUser.id }">
                <div class="form-group">
                    <label class="control-label col-md-3">密码<span class="required">*</span></label>

                    <div class="col-md-4">
                        <div class="input-icon right">
                            <i class="fa"></i>
                            <form:input path="password" type="text" class="form-control" name="password"/>
                        </div>
                    </div>
                </div>
            </c:if>
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
    var update_skxdAdminUser_panel = $("#panel_skxdAdminUser_form_saveOrUpdate");
    var skxdAdminUser_form = $('#skxdAdminUser_form_saveOrUpdate');
    var skxdAdminUser_error = $('.alert-danger', skxdAdminUser_form);
    var skxdAdminUser_success = $('.alert-success', skxdAdminUser_form);
    $(document).ready(function () {
        $("#skxdAdminUser_form_saveOrUpdate").validate({
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
                name: {
                    required: true
                }
                ,
                password: {
                    required: true
                }
                ,
                createdUser: {
                    required: true
                }
                ,
                updatedUser: {
                    required: true
                }
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
                $.ajax({
                    url: contextPath + "/admin/skxdAdminUser/saveOrUpdateSkxdAdminUser",
                    method: "post",
                    data: $("#skxdAdminUser_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        TABLE.refresh('data_table_skxdAdminUser');
                        window.closeMessageDialog();
                        return false;
                    }
                });
                return false;
            }
        });
    });
</script>

