var TABLE;
function Table(){
    var table={};
    table.defaultDataTable=function(json){
        var dataTable=$('#'+json.table).DataTable({
            "bPaginate": true, //翻页功能
            "bLengthChange": true, //改变每页显示数据数量
            "bFilter": true, //过滤功能
            "bSort": false, //排序功能
            "bInfo": true,//页脚信息
            "bAutoWidth": true,//自动
            "bServerSide":true,
            "sAjaxSource":json.url,
            "sDom": '<"top"<"toolbar">>t<"bottom"lpi><"clear">',
            "bStateSave":false,
            "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
            "bServerSide": true,
            "sPaginationType":"full_numbers",
            oLanguage: {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)"
            },
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            },
            "aLengthMenu": [[10, 25, 50], [10, 25, 50]],
            "aoColumns":json.aoColumns,
            initComplete:json.initComplete
        });
        $("#"+json.table+" tbody").on('click', 'tr', function (){
            $(this).toggleClass('selected');
        });
        return dataTable;
    };
    table.refresh=function(table_id){
    	if(table_id instanceof jQuery){ 
    		table_id.dataTable().fnDraw(false);
    	}else {
    		$("#"+table_id).dataTable().fnDraw(false);
    	}
    };
    table.preSearch=function(table_id,obj,i){
        var text=$(obj).val();
        if(i==0 || i==null){
            $('#'+table_id).DataTable().search(
                text
            );
        }else{
            $('#'+table_id).DataTable().column(i).search(
                text
            );
        }
    };
    table.search=function(table_id,obj){
    	var text;
    	if(obj instanceof jQuery) {
    		text = obj.val();
    	}else {
    		text=$(obj).val();
    	}
        $('#'+table_id).DataTable().search(text).draw();
    };
    table.del = function(dataTable,dataTableId,url,options) {
    	var defaultOptions = {
    			itemName:"数据"
    	};
    	var settings = $.extend(defaultOptions,options);
    	var array = dataTable.rows('.selected').data();
        if (array == null || array.length == 0) {
            message({content: "请选择要删除的"+settings.itemName});
        } else {
            var names = "";
            var ids = "";
            for (var i = 0; i < array.length; i++) {
                ids = ids + "," + array[i].id;
            }
            ids = ids.substr(1, ids.length);
            messageConfirm({
                title: "删除"+settings.itemName,
                content: "您确认要删除选中的 "+ array.length + "条"+settings.itemName+"吗?",
                callback: function () {
                    $.ajax({
                        url: url,
                        method: "post",
                        data: {ids: ids},
                        success: function (json) {
                            message({content: json.message});
                            TABLE.refresh(dataTableId);
                            return false;
                        }
                    });
                }
            });
        }
    }
    return table;
}
TABLE=new Table();