<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<!--common css-->
<link href="${ctx}/resources/common/css/google-font.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>

<link href="${ctx}/resources/common/css/google-font.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>

<link href="${ctx}/resources/assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="${ctx}/resources/assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${ctx}/resources/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/resources/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="${ctx}/resources/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/common/css/common.css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="${ctx}/resources/assets/global/plugins/datatables/media/images/favicon.ico"/>
<style>
.common_search td{
   padding: 8px;
}
.table-hover>tbody>tr.selected:hover>td {
   background-color: #e5e5e5;
}
.table>tbody>tr.selected>td {
   background-color: #e5e5e5;
}
.default-font{
   font-family:"宋体";
   color:#F6F6F6;
}
</style>

