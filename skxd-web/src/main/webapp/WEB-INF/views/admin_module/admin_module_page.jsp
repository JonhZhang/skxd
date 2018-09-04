<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>模块信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('module');">
            </a>
            <a href="javascript:;" class="fullscreen">
            </a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="module_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="module_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">模块名称</span>
                            <input type="text" class="form-control" id="module_search_name" placeholder="请输入名称"
                                   style="width: 200px;" onblur="TABLE.preSearch('module',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">栏目级别</span>
                            <select class="form-control" id="module_search_level" onchange="TABLE.preSearch('module',this,3);">
                                <option value="">全部栏目</option>
                                <option value="1">一级栏目</option>
                                <option value="2">二级栏目</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="添加模块" class="btn green"
                               onclick="TAB.create_tab({id:'module_save_id',name:'添加模块',url:'${ctx}/admin/adminModule/toAddAdminModule'});"/>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('module',document.getElementById('module_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="module_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="module" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    function modify_module_by_id(id) {
        TAB.create_tab({id:'module_save_id',name:'修改模块',url:'${ctx}/admin/adminModule/toUpdateAdminModule?id='+id});
    }
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "module",
            "url": contextPath + "/admin/adminModule/adminModulePage",
            "aoColumns": [
                {"mData": 'name', "sTitle": "模块名称"},
                {
                    "mData": 'url', "sTitle": "模块url", render: function (obj) {
                    return ifEmptyRender(obj)
                }
                },
                {
                    "mData": 'level', "sTitle": "模块级别",
                    "render": function (level) {
                        if (level == 1) {
                            return "一级栏目";
                        } else {
                            return "二级栏目";
                        }
                    }
                },
                {
                    "mData": 'parent', "sTitle": "父级模块", render: function (obj) {
                                 return ifEmptyRender(obj)
                    }
                },
                {
                    "mData": 'isMenu', "sTitle": "是否菜单展示", render: function (obj) {
                              if(obj==1){
                                  return '是';
                              }else{
                                  return '否';
                              }
                     }
                },
                {
                    "mData": 'style', "sTitle": "样式风格", render: function (style) {
                                 return ifEmptyRender(style)
                    }
                },
                {
                    "mData": 'id', "sTitle": "操作", render: function (id) {
                        var a="<a onclick=\"modify_module_by_id('"+id+"')\">操作</a>";
                        return a;
                    }
                }
            ],
            initComplete: function () {
                $("#module_wrapper .toolbar").html($("#module_search").html());
                $("#module_search").html("");
                $('#module_delete').click(function () {
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
                        names=names.substr(1,names.length);
                        ids=ids.substr(1,ids.length);
                        messageConfirm({
                           title:"删除模块",
                           content:"您确认要删除名称为: ["+ names+"] "+array.length+"个模块吗?",
                           callback:function(){
                               $.ajax({
                                   url: contextPath+"/admin/adminModule/removeAdminModuleByIds",
                                   method:"post",
                                   data:{ids:ids},
                                   success:function(json){
                                       message({content:json.message});
                                       if(json.status==1){
                                           SIDEBAR.create_sidebar({
                                               url:contextPath+"${ctx}/admin/adminModule/adminModulelist",
                                               data:null
                                           });
                                           TABLE.refresh('module');
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