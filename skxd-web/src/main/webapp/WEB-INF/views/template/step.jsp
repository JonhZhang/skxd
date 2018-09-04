<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="portlet box grey-cascade" id="panel-step">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-globe"></i>步骤列表
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('dataTable-step');">
            </a>
            <a href="javascript:;" class="remove">
            </a>
        </div>
    </div>
    <div class="portlet-body">
    	<div class="search">
            <table class="common_search" >
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" name="q" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>

                    <td>
                        <input type="button" value="添加步骤" class="btn green addBtn"
                               onclick="$viewStepPanel.add_project_by_id();"/>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green queryBtn"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项"  class="btn green delBtn"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="dataTable-step" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
var $viewStepPanel = $("#panel-step");
$viewStepPanel.add_project_by_id=function(id){
    if(id==null){
        window.messageDialog({
            title: "添加步骤",
            url: '/admin/template/toAddStep?projectId=${projectId}'
        });
    }else{
        window.messageDialog({
            title: "修改项目",
            url: '/admin/template/toAddStep?id='+id
        });
    }
};
$viewStepPanel.panel_step_add=function(id){
    TAB.create_tab({id:"panel-11step-add",name:"维护题库",url:"/admin/template/tempInput?projectId=${projectId}&stepId="+id});
}

$viewStepPanel.upMove=function(id){
	var url = contextPath+"/admin/template/upMove?id="+id;
	$.getJSON(url,function(data) {
		TABLE.refresh('dataTable-step');
	});
}
$(document).ready(function () {
	var dataTable;
	dataTable = TABLE.defaultDataTable({
        "table": "dataTable-step",
        "url": contextPath + "/admin/template/stepPage?projectId=${projectId}",
        "aoColumns": [
            {"mData": 'stepName', "sTitle": "步骤名"},
            {"mData": 'createdDate', "sTitle": "创建时间"},
            {
                "mData": '', "sTitle": "操作" ,
                "render": function (data, type, row) {
                	var widget = '<a href=\"javascript:void(0);\" onclick=\"$viewStepPanel.add_project_by_id(\''+row.id+'\')\" title=\"修改步骤\"  class=\"menu-item-link\">修改步骤</a> ';
                	widget+='<a href="javascript:void(0)"  onclick=\"$viewStepPanel.panel_step_add(\''+row.id+'\');\"'+'>维护题库</a> ';
//                 	widget+='<a href="javascript:void(0)"  onclick=\"$viewStepPanel.upMove(\''+row.id+'\');\"'+'>向上移动</a>';
                	widget+='<img src="${ctx}/resources/img/upArrow.png" title="向上移动" style="cursor:pointer" width=16 onclick=\"$viewStepPanel.upMove(\''+row.id+'\');\"'+'/>';
                	return widget;
                 }
            }
        ],
        initComplete: function () {
        	 $('.delBtn',$viewStepPanel).click(function () {
        	    	TABLE.del(dataTable,"dataTable-step",contextPath + "/admin/template/deleteStep");
        	 });
        	 $('.queryBtn',$viewStepPanel).click(function() {
        		 	TABLE.search('dataTable-step',$("input[name=q]",$viewStepPanel));
        	 });
        }
    });
});
</script>