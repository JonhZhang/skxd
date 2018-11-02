<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAnswer">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAnswer');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAnswer_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">标题</span>
                            <input type="text" class="form-control" placeholder="请输入标题"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdAnswer',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">工单名称</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdAnswer',this,2);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">用户名</span>
                            <input type="text" class="form-control" id="skxdAnswer_search_all" placeholder="请输入用户名"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                </tr>

                <tr>

                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">流水号</span>
                            <input type="text" class="form-control" id="" placeholder="请输入流水号"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdAnswer',this,4);"/>
                        </div>
                    </td>

                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">开始时间</span>
                            <input type="text"  id="startDate" onclick="laydate();" class="form-control"  placeholder="" style="width: 200px;height:30px;">
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">结束时间</span>
                            <input type="text" id="endDate"  onclick="laydate();" class="form-control"  placeholder="" style="width: 200px;height:30px;">
                        </div>
                    </td>

                </tr>

                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">项目类型</span>
                            <form:select class="form-control" path="skxdTemplateProjectList" name="projectId"
                                         id="selectProjectId"
                                         onchange="TABLE.preSearch('data_table_skxdAnswer',this,3);">
                                <form:option value="" label="全部项目"></form:option>
                                <form:options items="${skxdTemplateProjectList}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:cliSearch();" />
                        <input type="button" value="导出工单" class="btn green" id="exportAnswer"/>
                        <input type="button" value="删除工单" class="btn green" id="deleteAnswer"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAnswer" cellspacing="0" width="100%"
               class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>

    var cliSearch = function() {
        var startDate = $("#startDate");
        var endDate = $("#endDate");
        TABLE.preSearch('data_table_skxdAnswer',startDate[0],5)
        TABLE.preSearch('data_table_skxdAnswer',endDate[0],6)
        TABLE.search('data_table_skxdAnswer',document.getElementById('skxdAnswer_search_all'));
    }

    var skxdAnswerPage = {};
    skxdAnswerPage.view_skxdAnswer_by_id = function (id) {
        window.open(clientPath + '/answer/queryAnswerById?answerId=' + id);
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAnswer",
            "url": contextPath + "/admin/skxdAnswer/skxdAnswerPage",
            "aoColumns": [
                {"mData": 'orderno', "sTitle": "流水号"},
                {"mData": 'title', "sTitle": "标题", width: 200},
                {"mData": 'projectName', "sTitle": "项目名称"},
                {"mData": 'userName', "sTitle": "用户名"},
                {
                    "mData": 'status', "sTitle": "状态", render: function (status) {
                    if (status == 0) {
                        return "未审批";
                    } else if (status == 1) {
                        return "审批通过";
                    } else if (status == -1) {
                        return "审批驳回";
                    }
                }
                },
                {"mData": 'createdDate', "sTitle": "创建时间"},
                {
                    "mData": 'id', "sTitle": "详细信息", render: function (id) {
                    return "<a href=\"javascript:void(0);\" onclick=\"skxdAnswerPage.view_skxdAnswer_by_id('" + id + "');\">操作</a>";
                }
                }

            ],
            initComplete: function () {
                $("#data_table_skxdAnswer_wrapper .toolbar").html($("#skxdAnswer_search").html());
                $("#skxdAnswer_search").html("");
                $('#exportAnswer').click(function () {
                    var projectId = $("#selectProjectId").val();
                    if (projectId == null || projectId.length <= 5) {
                        message({content: "请选择项目"});
                        return;
                    }
                    var startDate = $("#startDate").val();
                    var endDate = $("#endDate").val();
                    console.log(startDate)
                    console.log(endDate)
                    window.location.href = contextPath + "/admin/skxdAnswer/exportAnswerExcel?projectId=" + projectId+"&startDate="+startDate+"&endDate="+endDate;
                });
                $('#deleteAnswer').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].title;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除题目为: [" + names + "] " + array.length + "个部门吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdAnswer/removeAnswersByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_skxdAnswer');
                                        }
                                        return false;
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    });
</script>