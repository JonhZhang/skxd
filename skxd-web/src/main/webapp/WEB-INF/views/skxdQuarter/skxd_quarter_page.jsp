<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdQuarter">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_skxdQuarter');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdQuarter_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">选项名称</span>
                            <input type="text" class="form-control" id="skxdQuarter_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">客户名称</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdQuarter',this,1);"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">统计年份</span>
                            <input type="text" class="form-control" placeholder="请输入"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_skxdQuarter',this,2);"/>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_skxdQuarter',document.getElementById('skxdQuarter_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdQuarter_delete" class="btn green"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="导入数据" id="skxdQuarter_import" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_skxdQuarter" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var skxdQuarterPage={};
    skxdQuarterPage.modify_skxdQuarter_by_id=function(id){
        TAB.create_tab({id:'skxdQuarter_update',name:'详细信息',url:'/admin/skxdQuarter/toUpdateSkxdQuarter?id='+id});
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_skxdQuarter",
            "url": contextPath + "/admin/skxdQuarter/skxdQuarterPage",
            "aoColumns": [
                {"mData": 'customName', "sTitle": "客户名称"},
                {"mData": 'year', "sTitle": "统计年份"},
                {"mData": 'name', "sTitle": "选项名"},
                {"mData": 'spring', "sTitle": "第一季度"},
                {"mData": 'summer', "sTitle": "第二季度"},
                {"mData": 'autumn', "sTitle": "第三季度"},
                {"mData": 'winter', "sTitle": "第四季度"},
                {"mData": 'createdTime', "sTitle": "创建时间"}
            ],
            initComplete: function () {
                $("#data_table_skxdQuarter_wrapper .toolbar").html($("#skxdQuarter_search").html());
                $("#skxdQuarter_search").html("");
                $('#skxdQuarter_delete').click(function () {
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
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "条数据吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/skxdQuarter/removeSkxdQuarterByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_skxdQuarter');
                                        }
                                        return false;
                                    }
                                });
                            }
                        });
                    }
                });
                $('#skxdQuarter_import').click(function(){
                    window.messageDialog({
                        title: "导入仪器数据",
                        url: "${ctx}/admin/skxdQuarter/toImportSkxdQuarterExcel"
                    });
                });
            }
        });
    });
</script>