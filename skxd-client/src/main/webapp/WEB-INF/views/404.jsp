<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>

<html lang="en" class="no-js">

<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<title>404</title>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="">
<div class="row">
	<div class=" ">
		<div class=" number">
			 404
		</div>
		<div class=" details">
			<h3>资源不存在</h3>
			<p>
				Please come back in a while. <a href="welcome">login </a> <br/><br/>
			</p>
		</div>
	</div>
</div>

</body>

</html>