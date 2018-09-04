<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
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
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>赛科希德后台管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/common/css/google-font.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/assets/global/css/components.css" id="style_components" rel="stylesheet"   type="text/css"/>
    <link href="${ctx}/resources/assets/admin/pages/css/login.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/resources/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"   type="text/javascript"></script>
</head>
<body class="login">
<div class="menu-toggler sidebar-toggler">
</div>
<div class="logo">
    <a href="index.html">
        <img src="${ctx}/resources/assets/admin/layout/img/logo-big.png" alt=""/>
    </a>
</div>
<div class="content">
    <form class="login-form" action="index.html" method="post">
        <h3 class="form-title">登录验证</h3>
        <div class="alert alert-danger display-hide">
            <button class="close" data-close="alert"></button>
			<span> 请输入正确的用户名和密码 </span>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off"  placeholder="用户名" name="userName"/>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off"
                   placeholder="密码" name="password"/>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-success uppercase">登录</button>
        </div>
    </form>
</div>
<div class="copyright">
    2015 © 版权归赛科希德所有.
</div>
<script>
    $(document).ready(function () {
        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                userName: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                userName: {
                    required: "Username is required."
                },
                password: {
                    required: "Password is required."
                }
            },
            invalidHandler: function(event, validator) { //display error alert on form submit
                $('.alert-danger', $('.login-form')).show();
            },
            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },
            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },
            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },
            submitHandler: function(form) {
                var userName = $(".login-form").find("input[name=userName]").val();
                var password = $(".login-form").find("input[name=password]").val();
                $.ajax({
                    url: "${ctx}/login/execute",
                    data: {userName: userName, password: password},
                    success: function (result) {
                        if (result.status == 1) {
                            window.location.href = "${ctx}/admin/common/index";
                        } else {
                            $('.alert-danger', $('.login-form')).show();
                            return false;
                        }
                    }
                });
                return false;
            }
        });
        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    $('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
    });
</script>
<script>
</script>
</body>
</html>