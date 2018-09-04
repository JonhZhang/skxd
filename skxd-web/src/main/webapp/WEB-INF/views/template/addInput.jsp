<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="portlet-body form" id="panel-input-add">
    <form:form action="" id="" class="form-horizontal" method="post" modelAttribute="input" >
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
                <label class="control-label col-md-3">项目名称
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" class="form-control" name="projectId"  value="${project.id }" />
                        <input type="text" class="form-control"  value="${project.name }" disabled="disabled"/>
                    </div>
                </div>
            </div>
             <div class="form-group">
                <label class="control-label col-md-3">步骤名称
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="hidden" class="form-control" name="stepId"  value="${step.id }" />
                        <input type="text" class="form-control" value="${step.stepName }" disabled="disabled"/>
                    </div>
                </div>
            </div>
             <div class="form-group">
                <label class="control-label col-md-3">题目类型<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="inputType" name="inputType" cssClass="form-control"  onchange="checkDictionaryId(this);">
		                   <form:options items="${inputList}"  itemLabel="name" itemValue="type"/>
		                </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">是否统计<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="isStatics"  cssClass="form-control"  >
                            <form:option value="0" label="否"></form:option>
                            <form:option value="1" label="是"></form:option>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">统计类型<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="staticType"  name="staticType"  cssClass="form-control"  >
                            <form:options items="${staticTypeList}"  itemLabel="name" itemValue="type"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">题目名称<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="inputName" type="text" class="form-control" name="inputName"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">题目内容<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:textarea path="inputContent"  htmlEscape="false" name="inputContent" style="width:340px;height:75px"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-3">是否必填<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="isRequired"  cssClass="form-control"  >
                            <form:option value="1"  >是</form:option>
                            <form:option value="0"  >否</form:option>
                        </form:select>
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
</div>
<script>
    function checkDictionaryId(obj){
       var value=$(obj).val();
       if(value=="dic"){
           $("#dictionaryId").show();
       }else{
           $("#dictionaryId").hide();
       }
    }
    $(document).ready(function () {
        var value=$("select[name='inputType']").val();
    	var $viewPanel = $("#panel-input-add");
   	    var form2 = $("form",$viewPanel);
   	    var error2 = $('.alert-danger', form2);
   	    var success2 = $('.alert-success', form2);
        $("form",$viewPanel).validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block help-block-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
            	inputName: {
                    required: true
                },
                inpuContent: {
                    required: true
                }
              
            },
            messages: {
            	inputName: {
                    required: "请输入题目名",
                },
            	inputContent: {
                    required: "请输入内容",
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
                var reg=new RegExp("\n","g");
                var regSpace=new RegExp(" ","g");
                var inputContentVal = $("[name=inputContent]").val();
                inputContentVal = inputContentVal.replace(reg,"<br>");
                inputContentVal= inputContentVal.replace(regSpace,"&nbsp;");
                var data = $("form",$viewPanel).serializeJSON();
                data.inputContent = inputContentVal;
                console.log(inputContentVal);
                $.ajax({
                    url: contextPath + "/admin/template/addInput",
                    method: "post",
                    contentType:"application/json",
                    data:  JSON.stringify(data),
                    success: function (json) {
                        TABLE.refresh('dataTable-input');
                        window.closeMessageDialog();
                        return false;
                    }
                });
                return false;
            }
        });
    });
  
</script>

