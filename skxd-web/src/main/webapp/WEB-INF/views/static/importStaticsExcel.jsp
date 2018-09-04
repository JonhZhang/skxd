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
<script src="${ctx}/resources/common/js/ajaxfileupload.js"></script>
<div class="portlet-body form" id="panel-statics-excel">
        <div class="form-body">
            <div class="form-group">
                <div class="col-md-4">
                    <div class="input-icon right">
                        <i class="fa"></i>
                        <input type="file" value="选择文件" name="staticsExcel" class="btn green" id="staticsExcel">
                    </div>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <div class="row">
                <div class="col-md-offset-4 col-md-9">
                    <input type="button" onclick="uploadFile();" value="确定导入" class="btn green">
                    <button type="button" class="btn default close-dialog">取消</button>
                </div>
            </div>
        </div>
</div>
<script>
    function uploadFile() {
        if ($("#staticsExcel").val() != "") {
            $.ajaxFileUpload({
                url: '${ctx}/admin/statics/importStaticsExcel',
                secureuri: true,
                fileElementId: "staticsExcel",
                dataType: 'json',
                success: function (result) {
                    alert(result.message);
                }, error: function (data, status, e) {
                    alert("error");
                }
            });
        } else {
            alert("请选择文件");
        }
    }
</script>