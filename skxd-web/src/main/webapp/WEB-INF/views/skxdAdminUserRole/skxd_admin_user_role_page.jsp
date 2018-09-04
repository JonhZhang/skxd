<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminUserRole">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAdminUserRole');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAdminUserRole_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdAdminUserRole_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">预留1</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdAdminUserRole',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">预留2</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdAdminUserRole',this,2);"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdAdminUserRole',document.getElementById('skxdAdminUserRole_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdAdminUserRole_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAdminUserRole" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAdminUserRolePage={};
    skxdAdminUserRolePage.modify_skxdAdminUserRole_by_id=function(id){
        TAB.create_tab({id:'skxdAdminUserRole_update',name:'详细信息',url:'/admin/skxdAdminUserRole/toUpdateSkxdAdminUserRole?id='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAdminUserRole",
            "url": contextPath + "/admin/skxdAdminUserRole/skxdAdminUserRolePage",
            "aoColumns": [
                                {"mData": 'userId', "sTitle": "未加注释"},
                                {"mData": 'roleId', "sTitle": "未加注释"},
                                {"mData": 'createdUser', "sTitle": "未加注释"},
                                {"mData": 'createdDate', "sTitle": "未加注释"},
                                {"mData": 'updatedUser', "sTitle": "未加注释"},
                                {"mData": 'updatedDate', "sTitle": "未加注释"},
                {"mData": 'id', "sTitle": "详细信息",render:function(id){
                    return "<a href=\"javascript:void(0);\" onclick=\"skxdAdminUserRolePage.modify_skxdAdminUserRole_by_id('"+id+"');\">操作</a>";
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdAdminUserRole_wrapper .toolbar").html($("#skxdAdminUserRole_search").html());
                $("#skxdAdminUserRole_search").html("");
                $('#skxdAdminUserRole_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdAdminUserRoleName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdAdminUserRole/removeSkxdAdminUserRoleByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == "0") {
                                            TABLE.refresh('data_table_skxdAdminUserRole');
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