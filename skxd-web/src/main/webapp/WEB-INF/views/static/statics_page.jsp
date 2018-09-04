<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-statics">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>统计信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_statics');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="statics_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">查询年份</span>
                            <select class="form-control" id="statics_search_all">
                                <option value="">全部</option>
                                <option value="2016">&nbsp;&nbsp;2016&nbsp;&nbsp;</option>
                                <option value="2017">&nbsp;&nbsp;2017&nbsp;&nbsp;</option>
                                <option value="2018">&nbsp;&nbsp;2018&nbsp;&nbsp;</option>
                                <option value="2019">&nbsp;&nbsp;2019&nbsp;&nbsp;</option>
                                <option value="2020">&nbsp;&nbsp;2020&nbsp;&nbsp;</option>
                                <option value="2021">&nbsp;&nbsp;2021&nbsp;&nbsp;</option>
                            </select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_statics',document.getElementById('statics_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="导出统计数据" id="statics_export" class="btn green"/>
                    </td>
                    <td>
                        <input type="button" value="导入统计数据" class="btn green" onclick="staticsPage.import_statics();">
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_statics" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var staticsPage={};
    staticsPage.import_statics=function(){
        window.messageDialog({
            title: "导出统计数据",
            url: "${ctx}/admin/statics/toImportStaticsExcel"
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_statics",
            "url": contextPath + "/admin/statics/queryStaticsPage?customId=${customId}",
            "bPaginate":true,
            "pageSize":10,
            "aoColumns": [
                {"mData": 'name', "sTitle": "选项名称"},
                {"mData": 'customName', "sTitle": "客户名称"},
                {"mData": 'staticType', "sTitle": "选项类型"},
                {"mData": 'year', "sTitle": "年份"},
                {"mData": 'spring', "sTitle": "春季"},
                {"mData": 'summer', "sTitle": "夏季"},
                {"mData": 'autumn', "sTitle": "秋季"},
                {"mData": 'winter', "sTitle": "冬季"}
            ],
            initComplete: function () {
                $("#data_table_statics_wrapper .toolbar").html($("#statics_search").html());
                $("#statics_search").html("");
                $('#statics_export').click(function () {
                    window.location.href=contextPath + "/admin/statics/exportStaticsExcel";
                });
            }
        });
    });
</script>