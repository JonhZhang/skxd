<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<html>
<head>


</head>
<div class="portlet box grey-cascade" id="panel-skxdUserPosition">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdUserPosition');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdUserPosition_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">工程师姓名</span>
                            <input type="text" class="form-control" id="skxdUserPosition_search_all" placeholder="请输入工程师姓名"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdUserPosition',document.getElementById('skxdUserPosition_search_all'));"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdUserPosition" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdUserPositionPage={};
    skxdUserPositionPage.modify_skxdUserPosition_by_id=function(id){
        TAB.create_tab({id:'skxdUserPosition_update',name:'客户信息详情',url:'/admin/skxdUserPosition/toUpdateSkxdUserPosition?id='+id});
    };
    skxdUserPositionPage.view_the_way=function(userId){
        TAB.create_tab({id:'04C6EC76482641128C47D067B398ABD0',name:'工程师历史轨迹',url:'/admin/skxdUserPosition/toSkxdUserPositionMapIframe?userId='+userId});
    };

    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdUserPosition",
            "url": contextPath + "/admin/skxdUserPosition/skxdUserPositionPage",
            "aoColumns": [
                {"mData": 'userName', "sTitle": "工程师姓名"}
                ,
                {"mData": 'longitude', "sTitle": "所在经度"}
                ,
                {"mData": 'latitude', "sTitle": "所在纬度"}
                ,
                {"mData": 'createdDate', "sTitle": "上传时间"},
                {"mData": 'userId', "sTitle": "操作",render:function (userId){
                    return "<a href='javascript:void(0);' onclick='skxdUserPositionPage.view_the_way(\""+userId+"\");'>查看历史轨迹</a>"
                }}
            ],
            initComplete: function () {
                $("#data_table_skxdUserPosition_wrapper .toolbar").html($("#skxdUserPosition_search").html());
                $("#skxdUserPosition_search").html("");
                $('#skxdUserPosition_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].skxdUserPositionName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdUserPosition/removeSkxdUserPositionByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_skxdUserPosition');
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
</html>