<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<html lang="en" class="no-js">
<head>
    <%@ include file="include/include_common_css.jsp" %>
    <meta charset="utf-8"/>
    <title>赛科希德</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<%@ include file="include/include_common_js.jsp" %>
<%@ include file="include/window.jsp" %>
<%@ include file="include/top.jsp" %>
<div class="clearfix"></div>
<div class="page-container">
    <%@ include file="include/left.jsp" %>
    <div class="page-content-wrapper">
        <div class="page-content" id="content">
            <div class="row">
                <ul id="myTab" class="nav nav-tabs">
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="home">
                        <p class=""><input type="button" value="确认框" class="btn red" onclick="testMessageConfirm();"></p>
                        <p class=""><input type="button" value="提示框" class="btn blue" onclick="testAlert();"></p>
                        <p class=""><input type="button" value="提示框" class="btn green" onclick="testDialog();"></p>
                        <p class=""><input type="button" value="table事例" class="btn green" onclick="javascript:void(0);"></p>
                        <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()">
                        <div class="portlet-body">
                            <table id="test_table"  cellspacing="0" width="100%" class="table table-striped table-bordered table-hover" >
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>
<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        QuickSidebar.init(); // init quick sidebar
        Demo.init(); // init demo features
        SIDEBAR.create_sidebar({
            url:"${ctx}/admin/adminModule/querySkxdAdminModulelist",
            data:null
        });
    });
</script>
<script>
//测试弹出框
function testDialog(){
    messageDialog({
        title:'我是弹出框标题',
        url:'/user/toUserList',
        data:null,
        save:function(){
            $.ajax({
                type: 'POST',
                url:contextPath,
                data:null,
                success:function(data){

                },
                error : function() {

                }
            });
        }
    });
}
//测试提示框
function testAlert(){
    message({
        content:'记录已经删除'
    });
};
//测试确认框
function  testMessageConfirm(){
    messageConfirm({content:'确认执行?',callback:function(){
        alert('这是回调函数');
    }});
}

$(document).ready(function(){
    TABLE.defaultDataTable({
        "div":"test_table",
        "url":contextPath+"/admin/user/page",
        "aoColumns": [
            {"mData": 'userAccount',"sTitle":"账户名称"},
            {"mData": 'realName',"sTitle":"真实姓名"},
            {"mData": 'idNumber',"sTitle":"身份证号",
                "render": function (idNumber) {
                    if(idNumber!=null && idNumber!=""){
                        idNumber=idNumber.substr(0,14);
                        idNumber=idNumber+"****";
                    }
                    return idNumber;
                }
            },
            {"mData": 'age',"sTitle":"年龄"},
            {"mData": 'sex',"sTitle":"性别",
                "render": function (sex) {
                    if(sex==1){
                        return "男";
                    }else{
                        return "女";
                    }
                }
            },
            {
                "mData": "id",
                "sClass": "center",
                sWidth:"15%",
                "sclass":"center",
                "sTitle":"操作",
                "bSearchable": false,
                "bStorable": false,
                "render": function (id,obj1,row) {
                    return "<a href='javascript:void(0);' onclick=\"view('"+id+"',"+row.userAccount+");\">测试</a>";
                }
            }
        ]
    });
});
</script>
<%@ include file="include/footer.jsp" %>
</body>
</html>