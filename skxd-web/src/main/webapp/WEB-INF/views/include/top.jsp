<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="page-header navbar navbar-fixed-top" id="skxd_top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner">
        <!-- BEGIN LOGO -->
        <div class="page-logo">
            <a href="javascript:void(0);">
                <img src="${ctx}/resources/img/logo.png" alt="logo" class="logo-default"/>
            </a>

            <div class="menu-toggler sidebar-toggler hide">
            </div>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
           data-target=".navbar-collapse">
        </a>
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <!-- END TODO DROPDOWN -->
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <img alt="" class="img-circle"
                             src="${ctx}/resources/img/user.ico"/>
					<span class="username username-hide-on-mobile">${sessionScope.adminUser.name}</span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="${ctx}/login/loginOut"><i class="icon-key"></i>退出</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="top_panel.modify_password();"><i class="icon-key"></i>修改密码</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    var top_panel=$("#skxd_top");
    top_panel.modify_password=function(){
        window.messageDialog({
            title:"修改密码",
            saveBtn:true,
            url:'/admin/skxdAdminUser/toModifyPassword'
        });
    };
</script>