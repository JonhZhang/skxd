<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<link rel="stylesheet" href="${ctx}/resources/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<div class="portlet-body form" id="panel_skxdAdminRole_bind_module">
    <div class="form-body">
        <div class="content_wrap">
            <input type="hidden" value="${roleId}" name="roleId">

            <div class="zTreeDemoBackground left">
                <ul id="treeDemo" class="ztree"></ul>
            </div>
        </div>
        <div class="form-actions">
            <div class="row">
                <div class="col-md-offset-4 col-md-9">
                    <input type="button" class="btn green" onclick="getSelectedNodes();" value="确定">
                    <button type="button" class="btn close-dialog">取消</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var skxdAdminRole_bind_module_panel = $("#panel_skxdAdminRole_bind_module");
    var zNodes = [];
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    $(document).ready(function () {
        var roleId = skxdAdminRole_bind_module_panel.find("input[name=roleId]").val();
        $.ajax({
            url: '${ctx}/admin/adminModule/queryModuleToTree',
            method: 'post',
            data: {roleId: roleId},
            success: function (result) {
                zNodes = result.data;
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            }
        })
    });

    function getSelectedNodes() {
        var roleId = skxdAdminRole_bind_module_panel.find("input[name=roleId]").val();
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getCheckedNodes(true);
        var node_str = "";
        for (var i = 0; i < nodes.length; i++) {
            node_str = node_str + nodes[i].id + ",";
        }
        if (node_str != "") {
            $.ajax({
                url: '${ctx}/admin/skxdAdminRoleModule/bindModule',
                method: 'post',
                data: {"moduleIds": node_str, "roleId": roleId},
                success: function (data) {
                    window.closeMessageDialog();
                }
            })
        } else {
            message({content: "请选择菜单选项."});
        }
    }
</script>

