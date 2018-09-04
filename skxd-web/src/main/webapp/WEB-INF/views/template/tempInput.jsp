<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="portlet box grey-cascade" id="panel-input">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-globe"></i>题库列表
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('dataTable-input');">
            </a>
            <a href="javascript:;" class="remove">
            </a>
        </div>
    </div>
    <div class="portlet-body">
        <div class="search">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" name="q" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">是否统计</span>
                            <select class="form-control" onchange="TABLE.preSearch('dataTable-input',this,1);">
                                <option value="">全部</option>
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">选择步骤</span>
                            <select name="stepId" id="search_stepId"
                                    onchange="TABLE.preSearch('dataTable-input',this,2);" class="form-control">
                                <option value="">全部步骤</option>
                                <c:forEach items="${skxdTemplateStepList}" var="temp">
                                    <option value="${temp.id}"
                                            <c:if test="${temp.id==stepId}">selected</c:if> >${temp.stepName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="查询" class="btn green queryBtn"/>
                        <input type="button" value="添加题目" class="btn green addBtn"
                               onclick="$viewInputPanel.add_input_by_id();"/>
                        <input type="button" value="删除选中项" class="btn green delBtn"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="dataTable-input" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var $viewInputPanel = $("#panel-input");
    $viewInputPanel.add_input_by_id = function (id) {
        if (id == null) {
            window.messageDialog({
                title: "添加步骤",
                url: '${ctx}/admin/template/toAddInput?projectId=${projectId}&stepId=${stepId}'
            });
        } else {
            window.messageDialog({
                title: "修改步骤",
                url: '${ctx}/admin/template/toAddInput?id=' + id + "&projectId=${projectId}&stepId=${stepId}"
            });
        }
    };

    $viewStepPanel.upMove = function (id) {
        var url = contextPath + "/admin/template/upMove4Input?id=" + id;
        $.getJSON(url, function (data) {
            TABLE.refresh('dataTable-input');
        });
    }

    $(document).ready(function () {
        var dataTable;
        dataTable = TABLE.defaultDataTable({
            "table": "dataTable-input",
            "url": contextPath + "/admin/template/tempInputPage?projectId=${projectId}",
            "aoColumns": [
                {
                    "mData": 'inputType', "sTitle": "类型",
                    "render": function (data, type, row) {
                        var result = "";
                        if (row.inputType == "view") {
                            result = "文本展示";
                        } else if (row.inputType == "title") {
                            result = "标题展示";
                        } else if (row.inputType == "text") {
                            result = "文本输入";
                        } else if (row.inputType == "textarea") {
                            result = "大文本输入";
                        } else if (row.inputType == "select") {
                            result = "选项选择";
                        } else if (row.inputType == "file") {
                            result = "文件上传";
                        } else if (row.inputType == "position") {
                            result = "位置上传";
                        } else if (row.inputType == "dic") {
                            result = "引用字典";
                        } else if (row.inputType == "date") {
                            result = "日期输入";
                        } else if (row.inputType == "cam") {
                            result = "扫描输入";
                        }
                        return result;
                    }
                },
                {"mData": 'inputName', "sTitle": "名称"},
                {"mData": 'inputName', "sTitle": "内容"},
                {"mData": 'createdDate', "sTitle": "创建时间"},
                {
                     "mData": 'isStatics', "sTitle": "是否进行统计", "render": function (data, type, row) {
                        return data == 1 ? "是" : "否";
                   }
                },
                {
                    "mData": 'staticType', "sTitle": "统计类型",
                    "render": function (data, type, row) {
                        var result = "未知类型";
                        if (row.staticType == "1") {
                            result = "凝血标本量及质控开展情况";
                        } else if (row.staticType == "2") {
                            result = "流变标本量及质控开展情况";
                        } else if (row.staticType == "3") {
                            result = "预留第三种类型";
                        } else if (row.staticType == "4") {
                            result = "预留第四种类型";
                        }
                        return result;
                    }
                },
                {
                    "mData": 'isRequired', "sTitle": "是否必填", "render": function (data, type, row) {
                        return data == 1 ? "是" : "否";
                    }
                },

                {
                    "mData": '', "sTitle": "操作",
                    "render": function (data, type, row) {
                        var widget = "<a href=\"javascript:void(0)\" onclick=\"$viewInputPanel.add_input_by_id('" + row.id + "');\">更新题目</a>";
                        widget += '<img src="' + contextPath + '/resources/img/upArrow.png" title="向上移动" style="cursor:pointer" width=16 onclick=\"$viewStepPanel.upMove(\'' + row.id + '\');\"' + '/>';
                        return widget;
                    }
                }
            ],
            initComplete: function () {
                $('.delBtn', $viewInputPanel).click(function () {
                    TABLE.del(dataTable, "dataTable-input", contextPath + "/admin/template/deleteInput");
                });
                $('.queryBtn', $viewInputPanel).click(function () {
                    TABLE.search('dataTable-input', $("input[name=q]", $viewInputPanel));
                });
            },
            preDrawCallback: function () {
                TABLE.preSearch('dataTable-input', $('#search_stepId'), 2);
            }
        });
    });
</script>