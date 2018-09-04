<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminDictionaryValue">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAdminDictionaryValue');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAdminDictionaryValue_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdAdminDictionaryValue_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">选项列表</span>
                            <select class="form-control" id="selectSkxdAdminDictionary" onchange="TABLE.preSearch('data_table_skxdAdminDictionaryValue',this,1);">
                                <option value="">全部选项</option>
                                <c:forEach var="temp" items="${skxdAdminDictionaryList}">
                                    <option value="${temp.id}" <c:if test="${temp.id==dId}">selected</c:if>>${temp.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdAdminDictionaryValue',document.getElementById('skxdAdminDictionaryValue_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdAdminDictionaryValue_delete" class="btn green"/>
                    </td>
                    <td>
                        <input type="button" value="添加选项" id="skxdAdminDictionaryValue_add" class="btn green" onclick="skxdAdminDictionaryValuePage.add_skxdAdminDictionaryValue_by_id();"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAdminDictionaryValue" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAdminDictionaryValuePage={};
    skxdAdminDictionaryValuePage.modify_skxdAdminDictionaryValue_by_id=function(id){
        TAB.create_tab({id:'skxdAdminDictionaryValue_update',name:'详细信息',url:'/admin/skxdAdminDictionaryValue/toUpdateSkxdAdminDictionaryValue?id='+id});
    };
    skxdAdminDictionaryValuePage.add_skxdAdminDictionaryValue_by_id=function(){
        TAB.create_tab({id:'942BC2576AD64812B4452FF745397086',name:'添加选项',url:'/admin/skxdAdminDictionaryValue/toAddSkxdAdminDictionaryValue?dId=${dId}'});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAdminDictionaryValue",
            "url": contextPath + "/admin/skxdAdminDictionaryValue/skxdAdminDictionaryValuePage",
            "aoColumns": [
                {"mData": 'name', "sTitle": "名称"},
                {"mData": 'dName', "sTitle": "字典项"},
                {"mData": 'createdTime', "sTitle": "创建时间"},
                {"mData": 'updatedTime', "sTitle": "修改时间"},
                {"mData": 'id', "sTitle": "详细信息",render:function(id){
                    return "<a href=\"javascript:void(0);\" onclick=\"skxdAdminDictionaryValuePage.modify_skxdAdminDictionaryValue_by_id('"+id+"');\">操作</a>";
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdAdminDictionaryValue_wrapper .toolbar").html($("#skxdAdminDictionaryValue_search").html());
                $("#skxdAdminDictionaryValue_search").html("");
                $('#skxdAdminDictionaryValue_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].name;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdAdminDictionaryValue/removeSkxdAdminDictionaryValueByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == "0") {
                                            TABLE.refresh('data_table_skxdAdminDictionaryValue');
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
        TABLE.preSearch('data_table_skxdAdminDictionaryValue',document.getElementById('selectSkxdAdminDictionary'),1);
        TABLE.search('data_table_skxdAdminDictionaryValue',document.getElementById('skxdAdminDictionaryValue_search_all'));
    });
</script>