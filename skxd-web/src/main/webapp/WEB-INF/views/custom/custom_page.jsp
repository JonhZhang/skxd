<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-custom">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>客户信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_custom');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="custom_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">全局搜索</span>
                            <input type="text" class="form-control" id="custom_search_all" placeholder="请输入搜索内容"
                                   style="width: 200px;"/>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">省</span>
                            <form:select class="form-control" path="areaNo1" id="selectCustomProvience" cssStyle="width: 200px;" onchange="TABLE.preSearch('data_table_custom',this,2);">
                                <form:option value="">全部</form:option>
                                <form:options items="${province}" itemLabel="name" itemValue="areaNo"/>
                            </form:select>
                        </div>
                    </td>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">市区</span>
                            <form:select class="form-control" path="areaNo" id="selectCustomCity" cssStyle="width: 200px;" onchange="TABLE.preSearch('data_table_custom',this,1);">
                                <form:option value="">全部</form:option>
                                <form:options items="${cityList}" itemLabel="name" itemValue="areaNo" />
                            </form:select>
                        </div>
                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_custom',document.getElementById('custom_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="custom_delete" class="btn green"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="导出Excel" id="custom_export" class="btn green"/>
                        <input type="button" value="导入Excel" class="btn green" onclick="customPage.import_custom();">
                    </td>
                </tr>
            </table>
        </div>
        <table id="data_table_custom" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>
    customPage.modify_custom_by_id=function(id){
        TAB.create_tab({id:'EC201A6E5E254AE9862B4FB7F0A8A3AC',name:'客户信息详情',url:'${ctx}/admin/custom/toUpdateCustom?id='+id});
    };
    customPage.view_custom_device=function(id){
        TAB.create_tab({id:'3367B8FD887A4B56B9B62EEA1350502C',name:'设备列表',url:'${ctx}/admin/custom/toDevicePage?customId='+id});
    };
    customPage.view_custom_statics=function(id){
        TAB.create_tab({id:'3367B8FD887A4B56B9B6ADDDA350502C',name:'统计列表',url:'${ctx}/admin/custom/toStaticsPage?customId='+id});
    };
    customPage.import_custom=function(){
        window.messageDialog({
            title: "导入客户",
            url: "${ctx}/admin/custom/toImportCustomExcel"
        });
    };

    $(document).ready(function () {
        var table = TABLE.defaultDataTable({
            "table": "data_table_custom",
            "url": contextPath + "/admin/custom/customPage",
            "aoColumns": [
                {"mData": 'customName', "sTitle": "客户名称"},
                {"mData": 'address', "sTitle": "客户地址"},
                {"mData": 'customLevel', "sTitle": "客户级别"},
                {"mData": 'customType', "sTitle": "客户类型"},
                {"mData": 'roomTest', "sTitle": "室间质评"},
                {"mData": 'createdUser', "sTitle": "创建人"},
                {"mData": 'createdDate', "sTitle": "创建时间"},
                {
                    "mData": 'id', "sTitle": "详细信息", render: function (id) {
                     var a1 = "<a onclick=\"customPage.modify_custom_by_id('" + id + "')\">详细信息</a>";
                     var a2 = "<a onclick=\"customPage.view_custom_device('" + id + "')\">设备信息</a>";
                     var a3 = "<a onclick=\"customPage.view_custom_statics('" + id + "')\">查询统计</a>";
                     return a1+" "+a2+" "+a3;
                    }
                }
            ],
            initComplete: function () {
                $("#data_table_custom_wrapper .toolbar").html($("#custom_search").html());
                $("#custom_search").html("");
                $('#custom_delete').click(function () {
                    var array = table.rows('.selected').data();
                    if (array == null || array.length == 0) {
                        message({content: "请选择要删除的模块"});
                    } else {
                        var names = "";
                        var ids = "";
                        for (var i = 0; i < array.length; i++) {
                            ids = ids + "," + array[i].id;
                            names = names + "," + array[i].customName;
                        }
                        names = names.substr(1, names.length);
                        ids = ids.substr(1, ids.length);
                        messageConfirm({
                            title: "删除模块",
                            content: "您确认要删除名称为: [" + names + "] " + array.length + "个模块吗?",
                            callback: function () {
                                $.ajax({
                                    url: contextPath + "/admin/custom/removeCustomByIds",
                                    method: "post",
                                    data: {ids: ids},
                                    success: function (json) {
                                        message({content: json.message});
                                        if (json.status == 1) {
                                            TABLE.refresh('data_table_custom');
                                        }
                                        return false;
                                    }
                                });
                            }
                        });
                    }
                });
                $('#custom_export').click(function () {
                    window.location.href=contextPath + "/admin/custom/exportCustomExcel";
                });
                $("#selectCustomProvience").change(function () {
                    var pid = $(this).children("option:selected").val();
                    $("#selectCustomCity").html("<option value=''>全部</option>");
                    $.getJSON(contextPath + "/admin/common/findCityByParent/" + pid, function (json) {
                        $(json).each(function (i) {
                            var x = json[i];
                            $("#selectCustomCity").append("<option value='" + x.areaNo + "' " + ">" + x.name + "</option>");
                        });
                    });
                    return false;
                });
            }
        });
    });
</script>