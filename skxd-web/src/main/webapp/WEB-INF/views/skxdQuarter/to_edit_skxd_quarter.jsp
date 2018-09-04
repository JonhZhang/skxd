<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_skxdQuarter_form_saveOrUpdate">
    <form:form action="" id="skxdQuarter_form_saveOrUpdate" class="form-horizontal" method="post"
               modelAttribute="skxdQuarter">
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
                        <label class="control-label col-md-3">customName<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="customName" type="text" class="form-control"
                                            name="customName"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">name<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="name" type="text" class="form-control"
                                            name="name"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">year<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="year" type="text" class="form-control"
                                            name="year"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">spring<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="spring" type="text" class="form-control"
                                            name="spring"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">summer<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="summer" type="text" class="form-control"
                                            name="summer"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">autumn<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="autumn" type="text" class="form-control"
                                            name="autumn"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">winter<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="winter" type="text" class="form-control"
                                            name="winter"/>
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
    var update_skxdQuarter_panel = $("#panel_skxdQuarter_form_saveOrUpdate");
    var skxdQuarter_form = $('#skxdQuarter_form_saveOrUpdate');
    var skxdQuarter_error = $('.alert-danger', skxdQuarter_form);
    var skxdQuarter_success = $('.alert-success', skxdQuarter_form);
    $(document).ready(function () {
                $("#skxdQuarter_form_saveOrUpdate").validate({
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
                    customId:
                        {
                            required: true
                        }
                        ,
                    customName:
                        {
                            required: true
                        }
                        ,
                    name:
                        {
                            required: true
                        }
                        ,
                    year:
                        {
                            required: true
                        }
                        ,
                    spring:
                        {
                            required: true
                        }
                        ,
                    summer:
                        {
                            required: true
                        }
                        ,
                    autumn:
                        {
                            required: true
                        }
                        ,
                    winter:
                        {
                            required: true
                        }
                        ,
                    createdTime:
                        {
                            required: true
                        }
            },
            invalidHandler
    :
    function (event, validator) { //display error alert on form submit
        skxdQuarter_success.hide();
        skxdQuarter_error.show();
        Metronic.scrollTo(skxdQuarter_error, -200);
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
        skxdQuarter_error.hide();
        label.closest('.form-group').removeClass('has-error'); // set success class to the control group
    }
    ,
    submitHandler: function (form) {
        $.ajax({
            url: contextPath + "/admin/skxdQuarter/saveOrUpdateSkxdQuarter",
            method: "post",
            data: $("#skxdQuarter_form_saveOrUpdate").serialize(),
            success: function (json) {
                if (json.status == "0") {
                    message({content:json.message});
                    TABLE.refresh('data_table_skxdQuarter');
                    //清空表单
                    $(':input', '#skxdQuarter_form_saveOrUpdate')
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

