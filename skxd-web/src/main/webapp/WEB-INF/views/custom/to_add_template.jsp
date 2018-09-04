<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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
    <meta name="description" content="基于Bootstrap的web表单构造器，通过拖拽组件的方式生成完整可用的表单">
    <meta name="keywords" content="Bootstrap,Form,表单,拖拽">
    <meta name="author" content="Bootstrap中文网">
    <link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css?a=11" rel="stylesheet">
    <link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap-responsive.min.css?a=11"       rel="stylesheet">
    <script src="${ctx}/resources/assets/global/plugins/jquery.min.js?a=11"></script>
    <script src="${ctx}/resources/assets/global/plugins/bootstrap/js/bootstrap.min.js?a=11"></script>
<body>
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <input type="button" value="测试" onclick="">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" onclick="test();">
                    ${step.stepName}
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <div class="panel-body">
                <form class="form-horizontal" id="form">
                    <fieldset>
                        <div id="legend" class="">
                            <legend class="">表单名</legend>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="input01">Text input</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge" name="input01">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Search input</label>
                            <div class="controls">
                                <input type="text" placeholder="placeholder" class="input-xlarge search-query" name="input02">
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Prepended text</label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">^_^</span>
                                    <input class="span2" placeholder="placeholder" id="prependedInput" type="text" name="input03">
                                </div>
                                <p class="help-block">Supporting help text</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Checkboxes</label>
                            <div class="controls">
                                <label class="checkbox">
                                    <input type="checkbox" value="Option one" name="input04">
                                    Option one
                                </label>
                                <label class="checkbox">
                                    <input type="checkbox" value="Option two" name="input04">
                                    Option two
                                </label>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Select - Basic</label>
                            <div class="controls">
                                <select class="input-xlarge" name="input05">
                                    <option>Enter</option>
                                    <option>Your</option>
                                    <option>Options</option>
                                    <option>Here!</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script>
        function test(){
            var json=$("#form").serialize();
            var jsonStr=JSON.stringify(json);
            $.ajax({
                url: "${ctx}/admin/custom/success",
                method:"post",
                data:{"jsonStr":jsonStr},
                success: function(){
                    $(this).addClass("done");
                }
            });
        }
    </script>
</div>
</body>
</html>