<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/resources/jquery-1.8.0.js"></script>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8"/>
    <title>接口测试</title>
    <script>
        function req(){
            var baseUrl="${ctx}/client/?productType=android&version=1.0";
            var url=$("#url").val();
            var params=$("#params").val();
            url=baseUrl+"&method="+url+"&"+params;
            $.ajax({
                type: 'POST',
                url: url ,
                success:function(data){
                    $("#resp").html(data);
                }
            });
        }
    </script>
</head>
<body>
<div style="text-align: center;">
    <table align="center"..>
        <tr>
            <td>接口名称</td>
            <td height="40px;" width="500px;">
                <select id="url">
                    <option value="sendMessage">发送短信</option>
                    <option value="getProvinceList">获得省数据</option>
                    <option value="register">注册用户</option>
                    <option value="login">登录</option>
                    <option value="modifySkxdUser">完善信息接口</option>
                    <option value="modifyPassword">修改密码接口</option>
                    <option value="addSkxdCase">添加病例接口</option>
                    <option value="querySkxdCasePageByUserAccount">查询个人病例接口</option>
                    <option value="querySkxdCaseById">根据id查询病例接口</option>
                    <option value="modifySkxdCase">修改病例接口</option>
                    <option value="removeSkxdCase">删除病例接口</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>参数</td>
            <td>
                <input type="text" name="params" id="params" style="width:300px;height:30px;"/>
            </td>
        </tr>
        <tr>
            <td>执行结果</td>
            <td>
                <textarea id="resp" cols="40" rows="20" disabled="disabled"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" onclick="req();" value="测试"/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>