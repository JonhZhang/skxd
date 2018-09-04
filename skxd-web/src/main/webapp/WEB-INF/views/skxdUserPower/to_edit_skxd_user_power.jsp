<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_skxdUserPower_form_saveOrUpdate">
    <form:form action="" id="skxdUserPower_form_saveOrUpdate" class="form-horizontal" method="post"
               modelAttribute="skxdUserPower">
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
                        <label class="control-label col-md-3">userId<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="userId" type="text" class="form-control"
                                            name="userId"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">provinceNo<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="provinceNo" type="text" class="form-control"
                                            name="provinceNo"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">cityNo<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="cityNo" type="text" class="form-control"
                                            name="cityNo"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">customId<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="customId" type="text" class="form-control"
                                            name="customId"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">deviceId<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="deviceId" type="text" class="form-control"
                                            name="deviceId"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">createdTime<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="createdTime" type="text" class="form-control"
                                            name="createdTime"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">updatedTime<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="updatedTime" type="text" class="form-control"
                                            name="updatedTime"/>
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
    var update_skxdUserPower_panel = $("#panel_skxdUserPower_form_saveOrUpdate");
    var skxdUserPower_form = $('#skxdUserPower_form_saveOrUpdate');
    var skxdUserPower_error = $('.alert-danger', skxdUserPower_form);
    var skxdUserPower_success = $('.alert-success', skxdUserPower_form);
    $(document).ready(function () {
                $("#skxdUserPower_form_saveOrUpdate").validate({
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
                    userId:
                        {
                            required: true
                        }
                        ,
                    provinceNo:
                        {
                            required: true
                        }
                        ,
                    cityNo:
                        {
                            required: true
                        }
                        ,
                    customId:
                        {
                            required: true
                        }
                        ,
                    deviceId:
                        {
                            required: true
                        }
                        ,
                    createdTime:
                        {
                            required: true
                        }
                        ,
                    updatedTime:
                        {
                            required: true
                        }
            },
            invalidHandler
    :
    function (event, validator) { //display error alert on form submit
        skxdUserPower_success.hide();
        skxdUserPower_error.show();
        Metronic.scrollTo(skxdUserPower_error, -200);
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
        skxdUserPower_error.hide();
        label.closest('.form-group').removeClass('has-error'); // set success class to the control group
    }
    ,
    submitHandler: function (form) {
        $.ajax({
            url: contextPath + "/admin/skxdUserPower/saveOrUpdateSkxdUserPower",
            method: "post",
            data: $("#skxdUserPower_form_saveOrUpdate").serialize(),
            success: function (json) {
                if (json.status == "0") {
                    message({content:json.message});
                    TABLE.refresh('data_table_skxdUserPower');
                    //清空表单
                    $(':input', '#skxdUserPower_form_saveOrUpdate')
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

