<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_department_form_saveOrUpdate">
    <form:form action="" id="department_form_saveOrUpdate" class="form-horizontal" method="post" modelAttribute="department" >
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
                <label class="control-label col-md-3">部门名称<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="departmentName" type="text" class="form-control" name="departmentName"/>
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
    var update_department_panel=$("#panel_department_form_saveOrUpdate");
    var form2 = $('#department_form_saveOrUpdate');
    var error2 = $('.alert-danger', form2);
    var success2 = $('.alert-success', form2);
    $(document).ready(function () {
        $("#department_form_saveOrUpdate").validate({
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
                departmentName: {
                    minlength: 2,
                    maxlength: 20,
                    required: true
                }
            },
            messages: {
                departmentName: {
                    required: "请输入部门名称",
                    minlength: "部门名称为2-20个字符",
                    maxlength: "部门名称为2-20个字符"
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
                    url: contextPath + "/admin/department/saveOrUpdateDepartment",
                    method: "post",
                    data: $("#department_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        if (json.status == 1) {
                            TABLE.refresh('data_table_department');
                            closeMessageDialog();
                        } else {
                            message({content: json.message});
                        }
                        return false;
                    }
                });
                return false;
            }
        });
    });
</script>

