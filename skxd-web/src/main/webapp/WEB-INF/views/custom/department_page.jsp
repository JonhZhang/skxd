<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-department">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>部门信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_department');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="department_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="department_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_department',document.getElementById('department_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="添加" class="btn green"
                               onclick="javascript:departmentPage.add_department();"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" name="department_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_department" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var department_panel=$("#panel-department");
    departmentPage.modify_department_by_id=function(id){
        messageDialog({
            title:'修改部门信息',
            url: "/admin/department/toUpdateDepartment",
            data:{id:id},
            save:function() {
               $('#department_form_saveOrUpdate').submit();
            }
        });
    };
    departmentPage.add_department=function(){
        messageDialog({
            title:'添加部门信息',
            url: "/admin/department/toAddDepartment",
            save:function() {
                var form = $('#department_form_saveOrUpdate').submit();
            }
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_department",
            "url": contextPath + "/admin/department/departmentPage",
            "aoColumns": [
                {"mData": 'departmentName', "sTitle": "部门名称"},
                {
                    "mData": 'id', "sTitle": "操作", render: function (id) {
                     var a1 = "<a onclick=\"departmentPage.modify_department_by_id('" + id + "')\">修改</a>";
                     return a1;
                    }
                }
            ],
            initComplete: function () {
                $("#data_table_department_wrapper .toolbar").html($("#department_search").html());
                $("#department_search").html("");
                department_panel.find("input[name=department_delete]").click(function(){
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].departmentName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除编号为: [" + names + "] " + array.length + "个部门吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/department/removeDepartmentByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_department');
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