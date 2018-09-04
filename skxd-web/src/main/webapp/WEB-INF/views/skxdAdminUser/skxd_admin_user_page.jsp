<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminUser">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdAdminUser');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdAdminUser_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdAdminUser_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdAdminUser',document.getElementById('skxdAdminUser_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdAdminUser_delete" class="btn green"/>
                    </td>
                    <td>
                        <input type="button" value="添加管理员" id="skxdAdminUser_toAdd" class="btn green" onclick="skxdAdminUserPage.toAdd_skxdAdminUser();"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdAdminUser" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAdminUserPage={};
    skxdAdminUserPage.modify_skxdAdminUser_by_id=function(id){
        window.messageDialog({
            title:"修改信息",
            url:'/admin/skxdAdminUser/toUpdateSkxdAdminUser?id='+id
        });
    };
    skxdAdminUserPage.bind_role_by_id=function(id){
        window.messageDialog({
            title:"角色信息",
            url:'/admin/skxdAdminUserRole/toBindRole?userId='+id
        });
    };
    skxdAdminUserPage.toAdd_skxdAdminUser=function(){
        window.messageDialog({
            title:"添加管理员",
            url:'/admin/skxdAdminUser/toAddSkxdAdminUser'
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdAdminUser",
            "url": contextPath + "/admin/skxdAdminUser/skxdAdminUserPage",
            "aoColumns": [
                {"mData": 'name', "sTitle": "用户名"},
                {"mData": 'createdDate', "sTitle": "创建时间"},
                {"mData": 'createdUser', "sTitle": "创建人"},
                {"mData": 'updatedDate', "sTitle": "更新时间"},
                {"mData": 'updatedUser', "sTitle": "更新人"},
                {"mData": 'id', "sTitle": "修改信息",render:function(id){
                    var operator="<a href=\"javascript:void(0);\" onclick=\"skxdAdminUserPage.modify_skxdAdminUser_by_id('"+id+"');\">操作</a>";
                    var role_info="<a href=\"javascript:void(0);\" onclick=\"skxdAdminUserPage.bind_role_by_id('"+id+"');\">角色信息</a>";
                    return operator+"&nbsp;"+role_info;
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdAdminUser_wrapper .toolbar").html($("#skxdAdminUser_search").html());
                $("#skxdAdminUser_search").html("");
                $('#skxdAdminUser_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdAdminUserName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdAdminUser/removeSkxdAdminUserByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == "0") {
                                            TABLE.refresh('data_table_skxdAdminUser');
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