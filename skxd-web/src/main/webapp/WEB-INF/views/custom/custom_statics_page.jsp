<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-custom-statics">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>统计信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_custom_statics');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="custom_statics_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">查询年份</span>
                            <select class="form-control" id="custom_statics_search_all">
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
                               onclick="javascript:TABLE.search('data_table_custom_statics',document.getElementById('custom_statics_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="导出统计数据" id="statics_custom_export" class="btn green"/>
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_custom_statics" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    var staticsCustomPage={};
    staticsCustomPage.import_custom_statics=function(){
        window.messageDialog({
            title: "导出统计数据",
            url: "${ctx}/admin/custom/toImportStaticsExcel"
        });
    };
    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_custom_statics",
            "url": contextPath + "/admin/custom/queryStaticsPage?customId=${customId}",
            "bPaginate":false,
            "aoColumns": [
                {"mData": 'name', "sTitle": "选项名称"},
                {"mData": 'staticType', "sTitle": "选项类型","render": function (data, type, row) {
                    var result = "未知类型";
                    if (row.staticType == "1") {
                        result = "凝血标本量及质控开展情况";
                    } else if (row.staticType == "2") {
                        result = "流变标本量及质控开展情况";
                    } else if (row.staticType == "3") {
                        result = "预留第三种类型";
                    } else if (row.staticType == "4") {
                        result = "预留第四种类型";
                    }
                    return result;
                }},
                {"mData": 'year', "sTitle": "年份"},
                {"mData": 'spring', "sTitle": "春季"},
                {"mData": 'summer', "sTitle": "夏季"},
                {"mData": 'autumn', "sTitle": "秋季"},
                {"mData": 'winter', "sTitle": "冬季"}
            ],
            initComplete: function () {
                $("#data_table_custom_statics_wrapper .toolbar").html($("#custom_statics_search").html());
                $("#custom_statics_search").html("");
                $('#statics_custom_export').click(function () {
                    window.location.href=contextPath + "/admin/custom/exportStaticsExcel?customId=${customId}";
                });
            }
        });
    });
</script>