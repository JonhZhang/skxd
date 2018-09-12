<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form" id="panel_custom_form_saveOrUpdate">
    <form:form action="" id="custom_form_saveOrUpdate" class="form-horizontal" method="post" modelAttribute="custom" >
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
                <label class="control-label col-md-3">客户名称<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="customName" type="text" class="form-control" name="customName"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="address-group">
                <label class="control-label col-md-3">客户地址<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="address" type="text" class="form-control" name="address"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="provience-group">
                <label class="control-label col-md-3">省<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="" name="provience">
                            <form:options items="${province}" itemLabel="name" itemValue="areaNo"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group" id="areaNo-group">
                <label class="control-label col-md-3">市<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="areaNo" name="areaNo">
                            <form:options items="${cityList}" itemLabel="name" itemValue="areaNo"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">客户类型</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="customType" name="customType">
                            <form:option value="">无</form:option>
                            <form:option value="A">A</form:option>
                            <form:option value="B">B</form:option>
                            <form:option value="C">C</form:option>
                            <form:option value="D">D</form:option>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">客户级别</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="customLevel" name="customLevel">
                            <form:option value="">无</form:option>
                            <form:option value="三甲">三甲</form:option>
                            <form:option value="三乙">三乙</form:option>
                            <form:option value="三级">三级</form:option>

                            <form:option value="二甲">二甲</form:option>
                            <form:option value="二乙">二乙</form:option>
                            <form:option value="二级">二级</form:option>

                            <form:option value="一甲">一甲</form:option>
                            <form:option value="一乙">一乙</form:option>
                            <form:option value="一级">一级</form:option>

                            <form:option value="民营">民营</form:option>
                            <form:option value="私立">私立</form:option>
                            <form:option value="基层卫生院">基层卫生院</form:option>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">室间质评</label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" path="roomTest" name="roomTest">
                            <form:option value="">无</form:option>
                            <form:option value="市级">市级</form:option>
                            <form:option value="部级">部级</form:option>
                            <form:option value="省级">省级</form:option>
                        </form:select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">联系人<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="linkman" type="text" class="form-control" name="linkman"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">电话号码<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="phone" type="text" class="form-control" name="phone"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">项目开展<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="itemSpread" type="text" class="form-control" name="itemSpread"/>
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
    var update_custom_panel=$("#panel_custom_form_saveOrUpdate");
    var form2 = $('#custom_form_saveOrUpdate');
    var error2 = $('.alert-danger', form2);
    var success2 = $('.alert-success', form2);
    $(document).ready(function () {
        $("#custom_form_saveOrUpdate").validate({
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
                customName: {
                    minlength: 1,
                    maxlength: 128,
                    required: true
                },
                address:{
                    required: true
                },
                areaNo:{
                    required: true
                },
                leaderPhone:{
                    number: true,
                    minlength:8,
                    maxlength:20
                },
                operatorPhone:{
                    number: true,
                    minlength:8,
                    maxlength:20
                },
                sort: {
                    number: true
                }
            },
            messages: {
                customName: {
                    required: "请输入客户姓名",
                    minlength: "客户姓名为1-128个字符",
                    maxlength: "客户姓名为1-128个字符"
                },
                address:"请输入客户地址",
                areaNo:"请选择区域",
                leaderPhone:{
                    number: "请输入正确的电话号码",
                    minlength: "请输入11位电话号码",
                    maxlength: "请输入11位电话号码"
                },
                operatorPhone:{
                    number: "请输入正确的电话号码",
                    minlength: "请输入11位电话号码",
                    maxlength: "请输入11位电话号码"
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
                    url: contextPath + "/admin/custom/saveOrUpdateCustom",
                    method: "post",
                    data: $("#custom_form_saveOrUpdate").serialize(),
                    success: function (json) {
                        if (json.status == 1) {
                            TABLE.refresh('data_table_custom');
                            TAB.closeTab("EC201A6E5E254AE9862B4FB7F0A8A3AC");
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
    update_custom_panel.find("select[name=provience]").change(function () {
        var pid = $(this).children("option:selected").val();
        update_custom_panel.find("select[name=areaNo]").html("");
        $.getJSON(contextPath + "/admin/common/findCityByParent/" + pid, function (json) {
            $(json).each(function (i) {
                var x = json[i];
                update_custom_panel.find("select[name=areaNo]").append("<option value='" + x.areaNo + "' " + ">" + x.name + "</option>");
            });
        });
        return false;
    });
    update_custom_panel.find("select[name=provience]").val('${area.parent}');
</script>

