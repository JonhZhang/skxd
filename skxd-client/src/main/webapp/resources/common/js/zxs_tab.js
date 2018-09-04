var TAB = {};
function Tab() {
    var tab = {};
    tab.create_tab = function (json) {
        var ul = $("#myTab");
        var content = $("#myTabContent");
        if (($("#" + json.id).length > 0)) {
            $("#myTab .active").removeClass("active");
            $("#myTabContent .active").removeClass("active");
            var li = $("#tab_" + json.id);
            var div = $("#" + json.id);
            li.addClass("active");
            div.addClass("tab-pane fade in active");
            tab.refresh({id:json.id,url:json.url,data:json.data});
        } else {
            var div = $("<div></div>");
            div.attr("id", json.id);
            if (json.url != null && json.url != "") {
                content.append(div);
                var li = $("<li></li>");
                var a = $("<a></a>");
                a.attr("href", "#" + json.id);
                a.dblclick(function () {
                    tab.refresh({id:json.id});
                });
                li.attr("id", "tab_" + json.id);
                a.attr("data-toggle", "tab");
                a.append(json.name);
                var cxt = $("[name=context]").val();
                var close = $("<img src='"+cxt+"/resources/assets/admin/layout/img/close.png' style='cursor:pointer; margin-left:4px;width:8px;height:8px'/>");
                close.click(function() {
                	tab.closeTab(json.id);
                });
                a.append(close);
                li.append(a);
                ul.append(li);
                $("#myTab .active").removeClass("active");
                $("#myTabContent .active").removeClass("active");
                li.addClass("active");
                div.addClass("tab-pane fade in active");
                var url_hidden = $("<input type='hidden'>");
                url_hidden.attr("id", "url_hidden_" + json.id);
                url_hidden.val(json.url);
                var otherLis = $("#myTab li:not('.active')");
                $.each(otherLis,function(i,n) {
                	$(this).find("img").css("visibility","hidden");
                });
                $.ajax({
                    type: 'GET',
                    url: contextPath + json.url,
                    data: json.data,
                    success: function (data) {
                        div.html(data);
                        div.append(url_hidden);
                    },
                    error: function () {
                        var content = "<div style='text-align: center;'><div class='number_404'>404</div></div>"
                        div.html(content);
                    }
                });
            }
        }
    };
    tab.closeTab = function (id) {
    	if(id instanceof jQuery) {
    		id  = id.attr("id");
    	}
        //关闭TAB
        $("#tab_" + id).remove();
        $("#" + id).remove();
        $('#myTab a:last').tab('show');
        $('#myTab a:last').find("img").css("visibility","visible");
    };
    tab.closeThis = function (obj) {
        var id = $(obj).parents(".tab-pane").attr("id");
        tab.closeTab(id);
    };
    tab.refresh = function (json) {
        var div = $("#" + json.id);
        var url = (json.url == null || json.url == "") ? $("#url_hidden_" + json.id).val() : json.url;
        $.ajax({
            type: 'POST',
            url: contextPath+url,
            data: json.data,
            success: function (data) {
                div.html(data);
                var url_hidden = $("<input type='hidden'>");
                url_hidden.attr("id", "url_hidden_" + json.id);
                url_hidden.val(url);
                div.append(url_hidden);
            },
            error: function () {
                var content = "<div style='text-align: center;'><div class='number_404'>404</div></div>"
                div.html(content);
            }
        });
    };
    tab.focus=function(indx){
        $('#myTab li:eq(indx) a').tab('show')
    };
    
    $("body").on("click",".menu-item-link",function(){
    	var name=$(this).attr("title");
    	var url=$(this).attr("url");
    	var id=$(this).attr("tab_id");
    	tab.create_tab({id:id,name:name,url:url});
    });
    
    $("body").on("click","button.cancel",function(){
    	var id = $(this).closest("div.active").attr("id");
    	 tab.closeTab(id);
    });
    
    $("body").on("mouseover","#myTab li:not('.active')",function(){
    	$(this).find("img").css("visibility","visible");
    });
    
    $("body").on("mouseout","#myTab li:not('.active')",function(){
    	$(this).find("img").css("visibility","hidden");
    });
    
    $("body").on("click","#myTab li a:not('.active')",function(e){
		 e.preventDefault();//阻止a链接的跳转行为
	     $(this).tab('show');
    	var otherLis = $("#myTab li:not('.active')");
        $.each(otherLis,function(i,n) {
        	$(this).find("img").css("visibility","hidden");
        })
    });
    return tab;
}
TAB = new Tab();
