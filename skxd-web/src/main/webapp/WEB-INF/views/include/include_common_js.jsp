<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<input type="hidden" name="context" value="${ctx }"/>
<script src="${ctx}/resources/assets/global/plugins/respond.min.js"></script>
<script src="${ctx}/resources/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/resources/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ctx}/resources/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>

<script src="${ctx}/resources/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="${ctx}/resources/assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/resources/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script src="${ctx}/resources/assets/admin/pages/scripts/table-managed.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/resources/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_utils.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_table.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_tab.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_sidebar.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_common.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/zxs_ext.js" type="text/javascript"></script>
<script src="${ctx}/resources/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript" ></script>
<script src="${ctx}/resources/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript" ></script>
<script src="${ctx}/resources/common/laydate/laydate.js" type="text/javascript"></script>
<script src="${ctx}/resources/common/js/jquery.serializejson.min.js" type="text/javascript"></script>

<script>
    String.prototype.trim = function() {
        return this.replace(/^\s+/g,"").replace(/\s+$/g,"");
    }
    function ifEmptyRender(obj){
        if(obj==null || obj==""){
            return "";
        }else{
            return obj;
        }
    }
</script>
