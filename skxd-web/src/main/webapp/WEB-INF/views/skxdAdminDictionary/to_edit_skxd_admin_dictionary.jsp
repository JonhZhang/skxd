<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_skxdAdminDictionary_form_saveOrUpdate">
    <form:form action="" id="skxdAdminDictionary_form_saveOrUpdate" class="form-horizontal" method="post"
               modelAttribute="skxdAdminDictionary">
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
                <label class="control-label col-md-3">选项名称<span
                        class="required">*</span></label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="name" type="text" class="form-control"
                                    name="name"/>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn green">提交</button>
                        <button type="button" class="btn default">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<script>
    var update_skxdAdminDictionary_panel = $("#panel_skxdAdminDictionary_form_saveOrUpdate");
    var skxdAdminDictionary_form = $('#skxdAdminDictionary_form_saveOrUpdate');
    var skxdAdminDictionary_error = $('.alert-danger', skxdAdminDictionary_form);
    var skxdAdminDictionary_success = $('.alert-success', skxdAdminDictionary_form);
    $(document).ready(function () {
        $("#skxdAdminDictionary_form_saveOrUpdate").validate({
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
                createdTime: {
                    required: true
                }
                ,
                updatedTime: {
                    required: true
                }
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                skxdAdminDictionary_success.hide();
                skxdAdminDictionary_error.show();
                Metronic.scrollTo(skxdAdminDictionary_error, -200);
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
                skxdAdminDictionary_error.hide();
                label.closest('.form-group').removeClass('has-error'); // set success class to the control group
            }
            ,
            submitHandler: function (form) {
                $.ajax({
                    url: contextPath + "/admin/skxdAdminDictionary/saveOrUpdateSkxdAdminDictionary",
                    method: "post",
                    data: $("#skxdAdminDictionary_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        if (json.status == "1") {
                            message({content: json.message});
                            TABLE.refresh('data_table_skxdAdminDictionary');
                            //清空表单
                            $(':input', '#skxdAdminDictionary_form_saveOrUpdate')
                                    .not(':button, :submit, :reset, :hidden')
                                    .val('')
                                    .removeAttr('checked')
                                    .removeAttr('selected');
                        } else {
                            message({content: json.message});
                        }
                        return false;
                    }
                });
                return false;
            }
        })
        ;
    })
    ;
</script>

