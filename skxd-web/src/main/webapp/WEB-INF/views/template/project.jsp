<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="portlet box grey-cascade" id="panel-project" >
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-globe"></i>项目列表
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('dataTable-user');">
            </a>
            <a href="javascript:;" class="remove">
            </a>
        </div>
    </div>
    <div class="portlet-body">
    	<div id="project_search" >
            <table class="common_search" >
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="project_search_all" placeholder="请输入搜索内容"  style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="添加模块" class="btn green" onclick="$viewProjectPanel.modyfy_project_by_id();"/>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green" onclick="javascript:TABLE.search('dataTable-project',document.getElementById('project_search_all'));"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="dataTable-project" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
var $viewProjectPanel = $("#panel-project");
$viewProjectPanel.modyfy_project_by_id = function (id) {
    if(id==null){
        window.messageDialog({
            title: "添加项目",
            url: '${ctx}/admin/template/toAddProject'
        });
    }else{
        window.messageDialog({
            title: "修改项目",
            url: '${ctx}/admin/template/toAddProject?id='+id
        });
    }
};
$viewProjectPanel.stepList= function (id) {
    TAB.create_tab({id:'project_step_list',name:'步骤详情',url:'${ctx}/admin/template/step?projectId='+id});
};
$viewProjectPanel.projectPreView=function(id){
    TAB.create_tab({id:'project_Pre_view',name:'项目预览',url:'${ctx}/admin/template/preview?projectId='+id});
};
$viewProjectPanel.publishingProject=function(id){
    $.ajax({
        type : "get",
        url :clientPath+"/project/publishingProject?projectId="+id,
        dataType : "jsonp",
        jsonp: "jsonpCallback",
        success : function(data){
            message({
                content:"操作成功"
            });
        },
        error:function(){
            alert('fail');
        }
    });
};
$(document).ready(function () {
    TABLE.defaultDataTable({
        "table": "dataTable-project",
        "url": contextPath + "/admin/template/projectPage",
        "aoColumns": [
            {"mData": 'name', "sTitle": "项目名"},
            {"mData": 'createdDate', "sTitle": "创建时间"},
            {"mData": 'updatedDate', "sTitle": "修改时间"},
            {"mData": 'remark', "sTitle": "备注"},
            {
                "mData": '', "sTitle": "操作" ,width:200,
                "render": function (data, type, row) {
                	var widget = '<a href=\"javascript:void(0);\" onclick=\"$viewProjectPanel.modyfy_project_by_id(\''+row.id+'\')\" title=\"更新项目\"  class=\"menu-item-link\">更新项目</a> ';
                	    widget += '<a href=\"javascript:void(0);\" onclick=\"$viewProjectPanel.stepList(\''+row.id+'\')\" title=\"步骤详情\"  class=\"menu-item-link\">步骤详情</a> ';
                        widget += '<a href=\"javascript:void(0);\" onclick=\"$viewProjectPanel.publishingProject(\''+row.id+'\')\" title=\"发布项目\"  class=\"menu-item-link\">发布项目</a> ';
                    return widget;
                 }
            }
        ]
    });
});
</script>