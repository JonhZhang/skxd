<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel-project-add">
<form:form action="" id="" class="form-horizontal" method="post" modelAttribute="project" >
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
            <label class="control-label col-md-3">项目名称<span class="required">*</span>
            </label>

            <div class="col-md-4">
                <div class="input-icon right">
                    <i class="fa"></i>
                    <form:input path="name" type="text" class="form-control" name="name"/>
                </div>
            </div>
        </div>
        <div class="form-group" id="address-group">
            <label class="control-label col-md-3">备注<span class="required">*</span></label>

            <div class="col-md-4">
                <div class="input-icon right">
                    <i class="fa"></i>
                    <form:textarea path="remark" class="form-control"/>
                </div>
            </div>
        </div>
    </div>
    <div class="form-actions">
        <div class="col-md-offset-4 col-md-9">
            <button type="submit" class="btn green">提交</button>
            <button type="button" class="btn default close-dialog">取消</button>
        </div>
    </div>
</form:form>
</div>
<script>
    $(document).ready(function () {
        var $viewPanel = $("#panel-project-add");
        var form2 = $("form", $viewPanel);
        var error2 = $('.alert-danger', form2);
        var success2 = $('.alert-success', form2);
        $("form", $viewPanel).validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                name: {
                    required: true
                }
            },
            messages: {
                name: {
                    required: "请输入项目名",
                }
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                success2.hide();
                error2.show();
                Metronic.scrollTo(error2, -200);
            },
            highlight: function (element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
            },
            success: function (label) {
                error2.hide();
                label.closest('.form-group').removeClass('has-error'); // set success class to the control group
            },
            submitHandler: function (form) {
                $.ajax({
                    url: contextPath + "/admin/template/addProject",
                    method: "post",
                    data: $("form", $viewPanel).serialize(),
                    success: function (json) {
                        TABLE.refresh('dataTable-project');
                        window.closeMessageDialog();
                        return false;
                    }
                });
                return false;
            }
        });
    });

</script>

