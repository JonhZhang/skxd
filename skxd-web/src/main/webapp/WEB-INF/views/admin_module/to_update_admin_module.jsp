<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="portlet-body form">
    <form:form action="/admin/user/test" id="module_form_add" class="form-horizontal" method="post" modelAttribute="adminModule">
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
                <label class="control-label col-md-3">模块名称<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="name" type="text" class="form-control" name="name"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="url-group">
                <label class="control-label col-md-3">请求地址<span class="required">*</span></label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="url" type="text" class="form-control" name="url"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="level-group">
                <label class="control-label col-md-3">模块级别<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" id="module_level" name="level" path="level">
                            <form:option value="1" label="一级栏目"/>
                            <form:option value="2" label="二级栏目"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">是否是菜单<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" id="module_isMenu" name="isMenu" path="isMenu">
                            <form:option value="1" label="是"/>
                            <form:option value="0" label="否"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-3">模块值<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="value" type="text" class="form-control" name="value"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="parent-group">
                <label class="control-label col-md-3">父级模块<span class="required">*</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select path="parent"  class="form-control" >
                            <form:option label="无" value=""/>
                            <form:options items="${adminModuleList}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group" id="sort-group">
                <label class="control-label col-md-3">模块排序<span class="required">&nbsp;</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:input path="sort" type="text" class="form-control" name="sort"/>
                    </div>
                </div>
            </div>
            <div class="form-group" id="style-group">
                <label class="control-label col-md-3">模块样式<span class="required">&nbsp;</span>
                </label>
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <form:select class="form-control" id="module_style" name="style" path="style">
                            <form:option value="icon-rocket" label="icon-rocket"/>
                            <form:option value="icon-pencil" label="icon-pencil"/>
                            <form:option value="icon-handbag" label="icon-handbag"/>
                            <form:option value="icon-tag"  label="icon-tag"/>
                            <form:option value="icon-basket"  label="icon-basket"/>
                            <form:option value="icon-diamond"  label="icon-diamond"/>
                            <form:option value="icon-puzzle" label="icon-puzzle"/>
                            <form:option value="icon-paper-plane"  label="icon-paper-plane"/>
                        </form:select>
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
    var form2 = $('#module_form_add');
    var error2 = $('.alert-danger', form2);
    var success2 = $('.alert-success', form2);
    if('${adminModule.id}'==null || '${adminModule.id}'==""){
        $('#url-group').hide();
        $('#parent-group').hide();
    }else{
        var level_old='${adminModule.level}';
        if(level_old==1){
            $('#parent-group').hide();
            $('#url-group').hide();
        }else{
            $('#parent-group').show();
            $('#url-group').show();
        }
    }
    $(document).ready(function() {
        $("#module_form_add").validate({
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
                    minlength: 2,
                    maxlength:8,
                    required: true
                },
                sort:{
                    number:true
                }
            },
            messages: {
                name:{
                  required:"请输入模块名称",
                  minlength:"模块名称为2-8个字符",
                  maxlength:"模块名称为2-8个字符"
                },
                parent:"请选择父级模块",
                sort:"请输入数字"
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
                var level=$('#module_level').val();
                var parent=$('#module_parent').val();
                if(level==2 && parent==""){
                    $('#module_parent').closest('.form-group').addClass('has-error'); // set error class to the control group
                    $('#module_parent').after("<span id='parent-error' class='help-block help-block-error'>请选择父级模块</span>")
                    error2.show();
                    return false;
                }else if(level==1 && parent!="" && parent!=null){
                    $('#module_parent').closest('.form-group').addClass('has-error'); // set error class to the control group
                    $('#module_parent').after("<span id='parent-error' class='help-block help-block-error'>一级模块没有父级模块</span>")
                    error2.show();
                    return false;
                }else{
                    $('#module_parent').closest('.form-group').removeClass('has-error');
                    $.ajax({
                       url: contextPath+"/admin/adminModule/saveOrUpdateAdminModule",
                       method:"post",
                       data:$("#module_form_add").serialize(),
                       success:function(json){
                         if(json.status==1){
                             SIDEBAR.create_sidebar({
                                 url:contextPath+"${ctx}/admin/adminModule/adminModulelist",
                                 data:null
                             });
                             TABLE.refresh('module');
                             TAB.closeTab("module_save_id");
                         }else{
                             message({content:json.message});
                         }
                         return false;
                       }
                    });
                    return false;
                }
            }
        });
    });
    $("#module_level").change(function(){
       var level=$(this).val();
       if(level=="1"){
          $('#parent-group').hide();
          $('#url-group').hide();
       }else{
           $('#parent-group').show();
           $('#url-group').show();
       }
    });
</script>

