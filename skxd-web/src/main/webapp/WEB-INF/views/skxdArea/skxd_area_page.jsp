<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdArea">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdArea');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdArea_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="skxdArea_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">预留1</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdArea',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">预留2</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdArea',this,2);"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdArea',document.getElementById('skxdArea_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdArea_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdArea" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdAreaPage={};
    skxdAreaPage.modify_skxdArea_by_id=function(id){
        TAB.create_tab({id:'skxdArea_update',name:'详细信息',url:'/admin/skxdArea/toUpdateSkxdArea?id='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdArea",
            "url": contextPath + "/admin/skxdArea/skxdAreaPage",
            "aoColumns": [
                {"mData": 'name', "sTitle": "未加注释"},
                {"mData": 'areaNo', "sTitle": "未加注释"},
                {"mData": 'parent', "sTitle": "未加注释"},
                {"mData": 'isActivated', "sTitle": "0:未激活 1:已激活"},
                {"mData": 'level', "sTitle": "未加注释"},
                {"mData": 'id', "sTitle": "详细信息",render:function(id){
                    return "<a href=\"javascript:void(0);\" onclick=\"skxdAreaPage.modify_skxdArea_by_id('"+id+"');\">操作</a>";
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdArea_wrapper .toolbar").html($("#skxdArea_search").html());
                $("#skxdArea_search").html("");
                $('#skxdArea_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdAreaName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdArea/removeSkxdAreaByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == "0") {
                                            TABLE.refresh('data_table_skxdArea');
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