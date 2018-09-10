<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="portlet box grey-cascade" id="panel-user">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-globe"></i>用户信息
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse">
            </a>
            <a href="javascript:;" class="reload" onclick="TABLE.refresh('dataTable-user');">
            </a>
            <a href="javascript:;" class="remove">
            </a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="user_search" style="display: none;">
            <table class="common_search">
                <tr>
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon green">用户名</span>
                            <input type="text" class="form-control" id="user_search_all" placeholder="请输入用户名"
                                   style="width: 200px;" onblur="TABLE.preSearch('ddataTable-user',this,1);"/>


                            <span class="input-group-addon green">是否是模板用户</span>
                            <select  class="form-control selectpicker" id="isModel" onchange="TABLE.preSearch('dataTable-user',this,2);">
                                <option value="model">是</option>
                                <option value="" selected>否</option>
                            </select>


                        </div>


                    </td>
                    <td>
                        <input type="button" value="查询" class="btn green"
                               onclick="javascript:TABLE.search('dataTable-user',document.getElementById('user_search_all'));"/>
                    </td>
                    <td>
                        <input type="button" value="删除选中项" id="skxdUser_delete" class="btn green"/>
                    </td>
                    <td>
                        <input type="button" value="导出数据"   class="btn green" id="skxdUser_export" onclick="userExport()" />
                    </td>
                </tr>

            </table>
        </div>
        <table id="dataTable-user" cellspacing="0" width="100%" class="table table-striped table-bordered table-hover">
        </table>
    </div>
</div>
<script>


var userExport = function() {
    window.location.href=contextPath + "/admin/user/exportSkxdUserExcel";
}
$(document).ready(function () {



	var $viewPanel = $("#panel-user");
    var table=TABLE.defaultDataTable({
        "table": "dataTable-user",
        "url": contextPath + "/admin/user/page",
        "aoColumns": [
            {"mData": 'userEmail', "sTitle": "Email"},
            {"mData": 'userName', "sTitle": "用户名"},
            {"mData": 'company', "sTitle": "公司"},
            {
                "mData": 'status', "sTitle": "状态",
                "render": function (data, type, row) {
                   if(data == 0) {
                	   return "未通过"; 
                   }else {
                	   return "通过";
                   }
                }
            },{
                "mData": 'roleName', "sTitle": "角色" 
            },{
                "mData": 'createdTime', "sTitle": "创建时间" 
            },{
                "mData": 'createdUser', "sTitle": "创建人"
            },{
                "mData": '', "sTitle": "操作" ,
                "render": function (data, type, row) {
                	var widget = "";
                	widget+='<a href="javascript:void(0)" userId='+row.id+' onclick="zxsUser.selectArea(\''+row.id+'\',1);">完善资料 </a>';
                	widget+= '<a href="javascript:void(0)" userId='+row.id+' status='+row.status+' onclick="zxsUser.audit(this);"> 审核 </a>';
                    widget+= '<a href="javascript:void(0)" onclick="zxsUser.selectRole(\''+row.id+'\');"> 角色选择 </a>';
                    widget+='<a href="javascript:void(0)" userId='+row.id+' onclick="zxsUser.selectAssessor(this)">配置审核员 </a>';
                    widget+='<a href="javascript:void(0)" userId='+row.id+' onclick="zxsUser.setModel(this)">设置为模板</a>';
                    return widget;
                 }
            },
            {"mData": 'id', "sTitle": "查看历史轨迹",render:function (id){
                return "<a href='javascript:void(0);' onclick='zxsUser.view_the_way(\""+id+"\");'>查看历史轨迹</a>"
            }}
        ],
        initComplete: function () {
            $("#dataTable-user_wrapper .toolbar").html($("#user_search").html());
            $("#user_search").html("");
            $('#skxdUser_delete').click(function () {
                var array = table.rows('.selected').data();
                if (array == null || array.length == 0) {
                    message({content: "请选择要删除的模块"});
                } else {
                    var names = "";
                    var ids = "";
                    for (var i = 0; i < array.length; i++) {
                        ids = ids + "," + array[i].id;
                        names = names + "," + array[i].userName;
                    }
                    names = names.substr(1, names.length);
                    ids = ids.substr(1, ids.length);
                    messageConfirm({
                        title: "删除模块",
                        content: "您确认要删除用户名为: [" + names + "] " + array.length + "个模块吗?",
                        callback: function () {
                            $.ajax({
                                url: contextPath + "/admin/user/removeSkxdUsersByIds",
                                method: "post",
                                data: {ids: ids},
                                success: function (json) {
                                    TABLE.refresh('dataTable-user');
                                    return false;
                                }
                            });
                        }
                    });
                }
            });
        }
    });
    zxsUser.audit = function(_this) {
    	var status = $(_this).attr("status");
    	var url =  contextPath + "/admin/user/modifySkxdUser";
    	var params = {};
    		params.id =  $(_this).attr("userId");
    	if(status == 0) {
    		params.status = 1;
    		messageConfirm({content:'确认审核通过?',callback:function(){
    			$.getJSON(url,params, function(json){
    				TABLE.refresh('dataTable-user');
	    		});
    	   	
    		}});
    	}else {
    		messageConfirm({content:'确认驳回?',callback:function(){
    			params.status = 0;
    			$.getJSON(url,params, function(json){
    				TABLE.refresh('dataTable-user');
	    		});
    	    }});
    	}
    };
    zxsUser.selectArea = function(id,level) {
        $viewPanel.find("input[name=select_userId]").val(id);
    	messageDialog({
            title:level==1?"选择省份":"选择市区",
            url: "/admin/skxdUserPower/toSelectArea",
            data:{id:id,level:level},
            width:900,
            height:600
        });
    };
    zxsUser.selectCustom = function(id) {
        $viewPanel.find("input[name=select_userId]").val(id);
        messageDialog({
            title:level==1?"选择省份":"选择客户",
            url: "/admin/skxdUserPower/toSelectCustom",
            data:{userId:id},
            width:900,
            height:600
        });
    };
    zxsUser.selectDevice = function(id,level) {
        $viewPanel.find("input[name=select_userId]").val(id);
        messageDialog({
            title:level==1?"选择省份":"选择设备",
            url: "/admin/skxdUserPower/toSelectDevice",
            data:{userId:id},
            width:900,
            height:600
        });
    };

    zxsUser.selectRole = function(id) {
        messageDialog({
            title:"选择角色",
            url: "/admin/user/selectArea",
            data:{userId:id},
            width:300,
            height:400
        });
    };

    zxsUser.view_the_way=function(userId){
        TAB.create_tab({id:'04C6EC76482641128C47D067B398ABD0',name:'工程师历史轨迹',url:'/admin/skxdUserPosition/toSkxdUserPositionMapIframe?userId='+userId});
    };

    zxsUser.selectAssessor  = function(_this) {
        $viewPanel.find("input[name=select_userId]").val($(_this).attr("userId"));
        messageDialog({
            title:'配置审核员',
            url: "/admin/user/selectAssessor",
            data:{userId:$(_this).attr("userId")},
            width:900,
            height:300
        });
    };


    zxsUser.templateConfig  = function(_this) {
        $viewPanel.find("input[name=select_userId]").val($(_this).attr("userId"));
        var userId = $(_this).attr("userId");

            messageConfirm({
                title: "复制工程师权限",
                content: "您确认要使用模板权限配置该用户吗?",
                callback: function () {
                    $.ajax({
                        url: contextPath + "/admin/skxdUserPower/templateConfig",
                        method: "post",
                        data: {userId: userId},
                        success: function (json) {
                            alert('权限复制完成');
                        }
                    });
                }
            });
    };

    zxsUser.setModel  = function(_this) {
        $viewPanel.find("input[name=select_userId]").val($(_this).attr("userId"));
        var userId = $(_this).attr("userId");

        messageConfirm({
            title: "设置模板",
            content: "您确认要设置该用户为模板用户吗?",
            callback: function () {
                $.ajax({
                    url: contextPath + "/admin/user/setModel",
                    method: "post",
                    data: {userId: userId},
                    success: function (json) {
                        alert('操作完成');
                    }
                });
            }
        });
    };

});
</script>