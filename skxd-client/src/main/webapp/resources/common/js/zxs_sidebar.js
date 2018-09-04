var SIDEBAR = {};
function Sidebar() {
    var temp = {};
    temp.create_sidebar = function (json) {
        //需要的元素
        var ul_parent = $("#sidebar");
        $.ajax({
            type: 'POST',
            url: json.url,
            data: json.data,
            success: function (temp) {
                ul_parent.html("");
                if (!temp.status) {
                    ul_parent.append("菜单加载失败.");
                } else {
                    var menuList = temp.data;
                    for (var i = 0; i < menuList.length; i++) {
                        var node = menuList[i];
                        var li = create_menu(node);
                        if(i==0){
                            li.addClass("start active open");
                        }
                        ul_parent.append(li);
                    }
                }
            }
        });
    };
    return temp;
}
SIDEBAR = new Sidebar();

function create_menu(node) {
    var li = $("<li></li>");
    var a = $("<a></a>");
    a.attr("href", "javascript:void(0);");
    var i = $("<i></i>");
    if(node.style!=null && node.style!=''){
        i.addClass(node.style);
    }else{
        i.addClass("icon-rocket");
    }
    var span1 = $("<span></span>");
    var span2 = $("<span></span>");
    span1.addClass("title");
    span2.addClass("arrow");
    span1.append(node.name);
    li.append(a);
    a.append(i);
    a.append(span1);
    a.append(span2);
    var ul = $("<ul></ul>");
    ul.attr("id","menu_child_ul_"+node.id);
    ul.addClass("sub-menu");
    for (var j = 0; j < node.children.length; j++) {
        var child = node.children[j];
        var child_li = $("<li></li>");
        child_li.attr("id","menu_child_"+child.id);

        var child_i = $("<i></i>");
        if(child.style!=null && child.style!=''){
            child_i.addClass(child.style);
        }else{
            child_i.addClass("icon-rocket");
        }
        var child_a = $("<a></a>");
        child_a.append(child_i);
        child_a.append(child.name);
        ul.append(child_li);
        child_li.append(child_a);
        child_a.bind("click",{name:child.name,url:child.url,id:child.id,nodeId:node.id}, function(e){
            $("#menu_child_ul_"+ e.data.nodeId+" .active").removeClass("active");
            $(this).parent().addClass("active");
            TAB.create_tab({id: e.data.id,name:e.data.name,url:e.data.url});
        });
    }
    li.append(ul);
    return li;
}
function sidebar_click(e){

}