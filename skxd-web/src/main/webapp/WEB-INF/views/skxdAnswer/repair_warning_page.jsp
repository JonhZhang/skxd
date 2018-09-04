<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>




<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-repairWarning">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('data_table_repairWarning');"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="repairWarning_search" >
            <table class="common_search">
                <tr>


                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">设备编号</span>
                            <input type="text" class="form-control" placeholder="请输入设备编号"
                                   style="width: 200px;" onblur="TABLE.preSearch('data_table_repairWarning',this,2);"/>
                        </div>
                    </td>

                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">用户名</span>
                            <input type="text" class="form-control" id="repairWarning_search_all" placeholder="请输入用户名"
                                   onblur="TABLE.preSearch('data_table_repairWarning',this,1);"
                                   style="width: 200px;"/>
                        </div>
                    </td>



                    <td>


                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('data_table_repairWarning',document.getElementById('repairWarning_search_all'));"/>
                    </td>

                </tr>

            </table>
        </div>
        <table id="data_table_repairWarning" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>


        var repairWarningPage={};

        $(document).ready(function () {




        var table = TABLE.defaultDataTable({
            "table": "data_table_repairWarning",
            "url": contextPath + "/admin/skxdAnswer/repairWarningPage",
            "aoColumns": [
                {"mData": 'userName', "sTitle": "用户名"},
                {"mData": 'deviceType', "sTitle": "设备类型"},
                {"mData": 'deviceNo', "sTitle": "设备编号"},
                {"mData": 'createdDate', "sTitle": "创建时间"}

            ],
            initComplete: function () {

            }
        });



    });
</script>