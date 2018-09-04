<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdMessage">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdMessage');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdMessage_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">标题</span>
                            <input type="text" class="form-control" id="skxdMessage_search_all" placeholder="请输入标题"   style="width: 200px;"/>
                        </div>
                    </td>
                  
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdMessage',document.getElementById('skxdMessage_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdMessage_delete" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdMessage" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdMessagePage={};
    skxdMessagePage.modify_skxdMessage_by_id=function(id){
        TAB.create_tab({id:'skxdMessage_update',name:'详细信息',url:'/admin/skxdMessage/toUpdateSkxdMessage?id='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdMessage",
            "url": contextPath + "/admin/skxdMessage/skxdMessagePage",
            "aoColumns": [
                                {"mData": 'title', "sTitle": "标题"},
                                {"mData": 'content', "sTitle": "内容"},
                                {"mData": 'senderName', "sTitle": "发送人姓名"},
                                {"mData": 'createdDate', "sTitle": "发送时间"},
//                                 {"mData": 'messageType', "sTitle": "消息类型"}
// 				                {"mData": 'id', "sTitle": "详细信息",render:function(id){
// 				                    return "<a href=\"javascript:void(0);\" onclick=\"skxdMessagePage.modify_skxdMessage_by_id('"+id+"');\">操作</a>";
// 				                }}
            ],
            initComplete: function () {
                $("#data_table_skxdMessage_wrapper .toolbar").html($("#skxdMessage_search").html());
                $("#skxdMessage_search").html("");
                $('#skxdMessage_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdMessageName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdMessage/removeSkxdMessageByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        TABLE.refresh('data_table_skxdMessage');
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