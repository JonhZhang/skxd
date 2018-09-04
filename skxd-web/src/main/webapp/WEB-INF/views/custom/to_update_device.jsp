<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link href="${ctx}/resources/common/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script src="${ctx}/resources/common/js/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/resources/common/js/bootstrap-datepicker.zh-CN.min.js"></script>
<div class="portlet-body form" id="panel_device_form_saveOrUpdate">
    <form:form action="" id="device_form_saveOrUpdate" class="form-horizontal" method="post" modelAttribute="device" >
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
                <label class="control-label col-md-3">省<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <c:if test="${empty device.id}">
                            <form:select class="form-control" path="" name="provience">
                                <form:options items="${provinceList}" itemLabel="name" itemValue="areaNo"/>
                            </form:select>
                        </c:if>
                        <c:if test="${not empty device.id}">
                            <input type="text" class="form-control" value="${province.name}" disabled="disabled">
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="form-group" >
                <label class="control-label col-md-3">市<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <c:if test="${empty device.id}">
                            <form:select class="form-control" path="" name="city">
                            </form:select>
                        </c:if>
                        <c:if test="${not empty device.id}">
                            <input type="text" class="form-control" value="${city.name}"  disabled="disabled">
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">客户<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="customId" name="customId">
                            <form:options items="${customList}" itemLabel="customName" itemValue="id"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">部门<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="departmentId" name="departmentId">
                            <form:options items="${departmentList}" itemLabel="departmentName" itemValue="id"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">仪器型号<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="deviceType" type="text" class="form-control" name="deviceType"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">仪器编号<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="deviceNo" type="text" class="form-control" name="deviceNo"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="fixedPhone-group">
                <label class="control-label col-md-3">固定电话</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="fixedPhone" type="text" class="form-control" name="fixedPhone"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="leaderName-group">
                <label class="control-label col-md-3">负责人姓名</label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="leaderName" type="text" class="form-control" name="leaderName"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="leaderPhone-group">
                <label class="control-label col-md-3">负责人联系方式</label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="leaderPhone" type="text" class="form-control" name="leaderPhone"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="operatorName-group">
                <label class="control-label col-md-3">操作员姓名<span class="required">*</span></label>

                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="operatorName" type="text" class="form-control" name="operatorName"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="operatorPhone-group">
                <label class="control-label col-md-3">操作员电话<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="operatorPhone" type="text" class="form-control" name="operatorPhone"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">销售商</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="seller" type="text" class="form-control" name="seller"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">服务机构</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="server" type="text" class="form-control" name="operatorPhone"/>
                    </div>
                </div>
            </div>

            <div class="form-group" >
                <label class="control-label col-md-3">安装人</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="installer" type="text" class="form-control" name="installer"/>
                    </div>
                </div>
            </div>

            <div class="form-group" >
                <label class="control-label col-md-3">安装时间</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="installTime" type="text" class="form-control" value="${installTime}"></form:input>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">仪器状态</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="deviceState" name="deviceState">
                            <form:option value="在用">在用</form:option>
                            <form:option value="停用">停用</form:option>
                        </form:select>
                    </div>
                </div>
            </div>

            <div class="form-group" >
                <label class="control-label col-md-3">项目开展状况</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="projectRemark" type="text" class="form-control" name="projectRemark"/>
                    </div>
                </div>
            </div>

            <div class="form-group" >
                <label class="control-label col-md-3">对手信息</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="competitor" type="text" class="form-control" name="competitor"/>
                    </div>
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
    </form:form>
</div>
<script>
    var update_device_panel=$("#panel_device_form_saveOrUpdate");
    var form2 = $('#device_form_saveOrUpdate');
    var error2 = $('.alert-danger', form2);
    var success2 = $('.alert-success', form2);
    $(document).ready(function () {
        $('#installTime').datepicker({
                field:this,
                firstDay: 1,
                minDate: new Date('2001-01-01'),
                maxDate: new Date('2020-12-31'),
                yearRange: [2000,2020],
                format: 'yyyy-mm-dd',
                language: 'cn',
        });
        $("#device_form_saveOrUpdate").validate({
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
                deviceNo: {
                    minlength: 2,
                    maxlength: 20,
                    required: true
                },
                deviceType:{
                    required: true
                },
                customId:{
                    required: true
                },
                departmentId:{
                    required: true
                }
            },
            messages: {
                deviceNo: {
                    required: "请输入仪器编号",
                },
                deviceType:"请输入仪器型号",
                customId:"请选择客户",
                departmentId:"请选择部门"
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
                    url: contextPath + "/admin/custom/saveOrUpdateDevice",
                    method: "post",
                    data: $("#device_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        if (json.status == 1) {
                            TABLE.refresh('data_table_device');
                            message({content: json.message});
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
    update_device_panel.find("select[name=provience]").change(function () {
        var pid = $(this).children("option:selected").val();
        update_device_panel.find("select[name=city]").html("");
        $.getJSON(contextPath + "/admin/common/findCityByParent/" + pid, function (json) {
            $(json).each(function (i) {
                var x = json[i];
                update_device_panel.find("select[name=city]").append("<option value='" + x.areaNo + "' " + ">" + x.name + "</option>");
            });
            update_device_panel.find("select[name=city]").change();
        });
        return false;
    });
    update_device_panel.find("select[name=city]").change(function () {
        var areaNo = $(this).children("option:selected").val();
        update_device_panel.find("select[name=customId]").html("");
        $.getJSON(contextPath + "/admin/custom/queryCustomListByAreaNo?areaNo=" +areaNo, function (json) {
            $(json).each(function (i) {
                var x = json[i];
                update_device_panel.find("select[name=customId]").append("<option value='" + x.id + "' " + ">" + x.customName + "</option>");
            });
        });
    });

</script>

