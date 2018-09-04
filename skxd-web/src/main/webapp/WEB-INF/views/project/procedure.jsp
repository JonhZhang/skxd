<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<head>
    <meta charset="utf-8">
    <title>Bootstrap表单构造器</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="基于Bootstrap的web表单构造器，通过拖拽组件的方式生成完整可用的表单">
    <meta name="keywords" content="Bootstrap,Form,表单,拖拽">
    <meta name="author" content="Bootstrap中文网">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script src="${ctx}/resources/bootstrap/js/jquery-1.10.2.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<div class="panel-group" id="accordion">
    <div class="panel">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#68A59563EBF04B9987108EC321938581">
                    步骤1
                </a>
            </h4>
        </div>
        <div id="68A59563EBF04B9987108EC321938581" class="panel-collapse collapse in">
            <div class="panel-body">
                <form class="form-horizontal">
                    <input type="hidden" name="projectId" id="projectId" value="0201B953E8B343858FFE280A94F36516">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label">通讯地址</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="51E2850B982D455CA5A953B37E7CE8F1">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">客户名称</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="BC80E6955E144C2BB4B5D9E02F91D8CA">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">使用科室</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="697486996FDD4DB5A17623685C06B67D">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">科室电话</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="AA9BB87B9E1A404FBE60621E5211D0CA">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">主任姓名</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="98D71F5DF68746BC945A6DB1F54FA643">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <div class="panel">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#ECF32F3E498441F4860EC381BE132ADB">
                    步骤2
                </a>
            </h4>
        </div>
        <div id="ECF32F3E498441F4860EC381BE132ADB" class="panel-collapse collapse in">
            <div class="panel-body">
                <form class="form-horizontal">
                    <input type="hidden" name="projectId" id="projectId" value="0201B953E8B343858FFE280A94F36516">
                    <fieldset>
                        <div class="control-group">
                            <span class="label label-default">1.使用前检查环境</span>
                        </div>
                        <div class="control-group">
                            <label class="control-label">环境温度</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="94FCE513C1C5481C86A5FF46FAEB3FF6">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">环境湿度</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="FD09B92C0C674D1CA0FD50B0E6DCCA6B">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">工作电压</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="4B67942FD9BF452F90FD502316DF59FB">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">未知</label>
                            <div class="controls">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<input type="button" onclick="form_to_string();" value="生存参数">
<input type="button" onclick="form_submit();" value="提交">
<input type="text" value="" id="test">
<script>
    var project_id = "11111111";
    var form_json_obj = null;
    var form_json_str = "";
    //将form表单转化成字符串保存
    //将字符串和json保存在本地
    function form_to_string() {
        var form_json_obj = $("#form").serializeArray();
        var form_json_str = JSON.stringify(form_json_obj);
        $("#test").val(form_json_str);
        localStorage.setItem(project_id + "_form_json_obj", form_json_obj);
        localStorage.setItem(project_id + "_form_json_str", form_json_str);
    }
    //加载本地缓存 取出数据
    function data_reload() {
        form_json_obj = eval('(' + localStorage.getItem(project_id + "_form_json_str") + ')');
        for (var temp in form_json_obj) {
            var element = $(":input[name=" + form_json_obj[temp].name + "]");
            var input_type = $(":input[name=" + form_json_obj[temp].name + "]").attr("type");
            if (input_type == "text") {
                element.val(form_json_obj[temp].value);
            } else if (input_type == "checkbox") {
                $("input[name='" + form_json_obj[temp].name + "']").each(function () {
                    if ($(this).val() == form_json_obj[temp].value) {
                        $(this).prop("checked", true);
                    }
                });
            } else if (input_type == "radio") {
                $("input[name='" + form_json_obj[temp].name + "']").each(function () {
                    if ($(this).val() == form_json_obj[temp].value) {
                        $(this).prop("checked", true);
                    }
                });
            } else if (input_type == "file") {
                element.val(form_json_obj[temp].value);
            } else {
                element.val(form_json_obj[temp].value);
            }
        }
    }
    function form_submit(){
        $.ajax({
            url:"${ctx}/answer/execute",
            data:{"projectId":"test","customId":"test","userId":"1111",password:"111111",departmentId:"222222",deviceId:"11111",deviceNo:"2222",answers:"                [{'name':'input1','value':'1'},{'name':'input2','value':'2'},{'name':'input3','value':'3'},{'name':'input4','value':'Option one'},{'name':'input4','value':'Option two'},{'name':'group','value':'Option two'}]"},
            success:function(data){
                alter(data.message);
            }
        });
    }
</script>
</body>
</html>