<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_skxdMessage_form_saveOrUpdate">
    <form:form action="" id="skxdMessage_form_saveOrUpdate" class="form-horizontal" method="post"
               modelAttribute="skxdMessage">
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
                        <label class="control-label col-md-3">标题<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="title" type="text" class="form-control"
                                            name="title"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3">内容<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="content" type="text" class="form-control"
                                            name="content"/>
                            </div>
                        </div>
                    </div>
                  
                  
                    <div class="form-group">
                        <label class="control-label col-md-3">发送人姓名<span
                                class="required">*</span></label>

                        <div class="col-md-4">
                            <div class="input-icon right">
                                <i class="fa"></i>
                                <form:input path="senderName" type="text" class="form-control"
                                            name="senderName"/>
                            </div>
                        </div>
                    </div>
                    
            <div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-4 col-md-9">
                        <button type="submit" class="btn green">提交</button>
                        <button type="button" class="btn default">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<script>
    var update_skxdMessage_panel = $("#panel_skxdMessage_form_saveOrUpdate");
    var skxdMessage_form = $('#skxdMessage_form_saveOrUpdate');
    var skxdMessage_error = $('.alert-danger', skxdMessage_form);
    var skxdMessage_success = $('.alert-success', skxdMessage_form);
    $(document).ready(function () {
                $("#skxdMessage_form_saveOrUpdate").validate({
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
                    title:
                        {
                            required: true
                        }
                        ,
                    content:
                        {
                            required: true
                        }
                        ,
                    recipient:
                        {
                            required: true
                        }
                        ,
                    senderId:
                        {
                            required: true
                        }
                        ,
                    createdUserId:
                        {
                            required: true
                        }
                        ,
                    senderName:
                        {
                            required: true
                        }
                        ,
                    messageType:
                        {
                            required: true
                        }
                        ,
            },
            invalidHandler
    :
    function (event, validator) { //display error alert on form submit
        skxdMessage_success.hide();
        skxdMessage_error.show();
        Metronic.scrollTo(skxdMessage_error, -200);
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
        skxdMessage_error.hide();
        label.closest('.form-group').removeClass('has-error'); // set success class to the control group
    }
    ,
    submitHandler: function (form) {
        $.ajax({
            url: contextPath + "/admin/skxdMessage/saveOrUpdateSkxdMessage",
            method: "post",
            data: $("#skxdMessage_form_saveOrUpdate").serialize(),
            success: function (json) {
                if (json.status == "0") {
                    message({content:json.message});
                    TABLE.refresh('data_table_skxdMessage');
                    //清空表单
                    $(':input', '#skxdMessage_form_saveOrUpdate')
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

