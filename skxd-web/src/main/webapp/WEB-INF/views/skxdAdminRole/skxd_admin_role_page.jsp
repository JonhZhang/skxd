<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminRole">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAdminRole');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAdminRole_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdAdminRole_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdAdminRole',document.getElementById('skxdAdminRole_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdAdminRole_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAdminRole" cellspacing="0" width="100%"
               class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAdminRolePage = {};
    skxdAdminRolePage.modify_skxdAdminRole_by_id = function (id) {
        window.messageDialog({
            title: "角色信息",
            url: '/admin/skxdAdminRole/toUpdateSkxdAdminRole?id=' + id
        });
    };
    skxdAdminRolePage.bind_module=function(id){
        window.messageDialog({
            title:"角色权限",
            saveBtn:true,
            url:'/admin/skxdAdminRoleModule/toBindModule?roleId='+id
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAdminRole",
            "url": contextPath + "/admin/skxdAdminRole/skxdAdminRolePage",
            "aoColumns": [
                {"mData": 'roleName', "sTitle": "角色名称"},
                {
                    "mData": 'id', "sTitle": "详细信息", render: function (id) {
                    var modify="<a href=\"javascript:void(0);\" onclick=\"skxdAdminRolePage.modify_skxdAdminRole_by_id('" + id + "');\">修改信息</a>";
                    var bind_module="<a href=\"javascript:void(0);\" onclick=\"skxdAdminRolePage.bind_module('" + id + "');\">绑定模块</a>";
                    return modify+"&nbsp;"+bind_module;
                }
                }
            ],
            initComplete: function () {
                $("#data_table_skxdAdminRole_wrapper .toolbar").html($("#skxdAdminRole_search").html());
                $("#skxdAdminRole_search").html("");
                $('#skxdAdminRole_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdAdminRoleName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdAdminRole/removeSkxdAdminRoleByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == "0") {
                                            TABLE.refresh('data_table_skxdAdminRole');
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