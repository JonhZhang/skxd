<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminDictionary">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAdminDictionary');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAdminDictionary_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdAdminDictionary_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdAdminDictionary',document.getElementById('skxdAdminDictionary_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="添加选项" id="skxdAdminDictionaryValue_add" class="btn green" onclick="skxdAdminDictionaryPage.add_skxdAdminDictionary();"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdAdminDictionary_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAdminDictionary" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAdminDictionaryPage={};
    skxdAdminDictionaryPage.modify_skxdAdminDictionary_by_id=function(id){
        TAB.create_tab({id:'skxdAdminDictionary_update',name:'详细信息',url:'/admin/skxdAdminDictionary/toUpdateSkxdAdminDictionary?id='+id});
    };
    skxdAdminDictionaryPage.add_skxdAdminDictionary=function(){
        TAB.create_tab({id:'13E3A682A3DB4DF1BDAD5FD14984B994',name:'添加分类',url:'/admin/skxdAdminDictionary/toAddSkxdAdminDictionary'});
    };
    skxdAdminDictionaryPage.view_value=function(id){
        TAB.create_tab({id:'D2FE8C39BC61490D9EB2F60826B861F6',name:'选项列表',url:'${ctx}/admin/skxdAdminDictionaryValue/toSkxdAdminDictionaryValuePage?dId='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAdminDictionary",
            "url": contextPath + "/admin/skxdAdminDictionary/skxdAdminDictionaryPage",
            "aoColumns": [
                {"mData": 'name', "sTitle": "选项名称"},
                {"mData": 'createdTime', "sTitle": "创建时间"},
                {"mData": 'updatedTime', "sTitle": "更新时间"},
                {"mData": 'id', "sTitle": "详细信息",render:function(id){
                    var modify="<a href=\"javascript:void(0);\" onclick=\"skxdAdminDictionaryPage.modify_skxdAdminDictionary_by_id('"+id+"');\">修改</a>";
                    var childList="<a href=\"javascript:void(0);\" onclick=\"skxdAdminDictionaryPage.view_value('"+id+"');\">管理选项</a>";
                    return modify+" "+childList;
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdAdminDictionary_wrapper .toolbar").html($("#skxdAdminDictionary_search").html());
                $("#skxdAdminDictionary_search").html("");
                $('#skxdAdminDictionary_delete').click(function () {
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
                                    url: contextPath + "/admin/skxdAdminDictionary/removeSkxdAdminDictionaryByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        TABLE.refresh('data_table_skxdAdminDictionary');
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