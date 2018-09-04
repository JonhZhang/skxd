<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<script src="${ctx}/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EfpqriVZU1wSQ64R7jyZ8uw5"></script>
<script src="${ctx}/resources/common/js/lushu.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="${ctx}/resources/common/laydate/laydate.js"></script>
<div class="portlet box grey-cascade" id="panel-skxdUserPosition-map">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
        <div class="tools">
            <a href="javascript:;" class="collapse"></a>
            <a href="javascript:;" class="fullscreen"></a>
        </div>
    </div>
    <div class="portlet-body">
        <div id="skxdUserPosition_search" style="display: none;">
            <input type="hidden" value="${userId}" name="userId">
        </div>
        <div id="data_table_skxdUserPosition_wrapper" class="dataTables_wrapper no-footer">
            <div class="top">
                <div class="toolbar">
                    <table class="common_search">
                        <tbody>
                        <tr>
                            <td>
                                <div class="input-group">
                                    <span class="input-group-addon green">开始时间</span>
                                    <input type="text"  name="startDate" onclick="laydate();"  placeholder="请输入开始时间" style="width: 200px;height:30px;">
                                </div>
                            </td>
                            <td>
                                <div class="input-group">
                                    <span class="input-group-addon green">结束时间</span>
                                    <input type="text" name="endDate"  onclick="laydate();"  placeholder="请输入结束时间" style="width: 200px;height:30px;">
                                </div>
                            </td>
                            <td>
                                <input type="button" value="查询" style="color: #FFFFFF;background-color: #26a69a;width: 100px;height: 30px;"  onclick="javascript:drawUserWay();">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="span6">
                <div id="map_canvas" style="height: 500px;width: 100%;"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    // 百度地图API功能
    var panel_skxdUserPosition_map=$("#panel-skxdUserPosition-map");
    var map = new BMap.Map("map_canvas");
    //设置中心点
    map.centerAndZoom(new BMap.Point(118.454, 32.955), 12);
    map.enableScrollWheelZoom();
    var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/Mario.png", new BMap.Size(32, 70), {    //小车图片
        imageOffset: new BMap.Size(0, 0)    //图片的偏移量。为了是图片底部中心对准坐标点。
    });
    var carMk=new BMap.Marker(new BMap.Point(118.454, 32.955));//地图添加自定义标识
//    map.addOverlay(carMk);
    function drawUserWay() {
        map.clearOverlays();
        var userId =panel_skxdUserPosition_map.find("input[name=userId]").val();
        var startDate =panel_skxdUserPosition_map.find("input[name=startDate]").val();
        var endDate =panel_skxdUserPosition_map.find("input[name=endDate]").val();
        $.ajax({
            url: contextPath+"/admin/skxdUserPosition/queryListByMap",
            method: "post",
            data: {userId: userId, startDate: startDate, endDate: endDate},
            success: function (result) {
                if (result.status == 1) {
                    var i=0;
                    var points = [];
                    var timeId=setInterval(function(){
                      if(i<result.data.length){
                          var position = new BMap.Point(result.data[i].longitude, result.data[i].latitude);
                          points.push(position);
                          drawPoint(position,result.data[i].userName+":"+result.data[i].createdDate);
                          map.centerAndZoom(position, 12);
                          map.enableScrollWheelZoom();
                          drawLine(points);
                          i++;
                      }else {
                          window.clearInterval(timeId);
                      }
                    },"1000");
                } else {
                    message({content: "查询失败"});
                }
            }
        });
    }
    /**
     * 画点
     * @param point
     */
    function drawPoint(point,remark){
        var marker = new BMap.Marker(point);
        var label = new BMap.Label(remark,{offset:new BMap.Size(20,-10)});
        marker.setLabel(label);
        map.addOverlay(marker);
    }
    /**
     * 画线
     * @param points
     */
    function drawLine(points){
        var curve = new BMapLib.CurveLine(points, {
            strokeColor: "blue",
            strokeWeight: 3,
            strokeOpacity: 0.5
        }); //创建弧线对象
        map.addOverlay(curve); //添加到地图中
    };
</script>