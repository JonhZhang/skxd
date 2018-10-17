<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box grey-cascade" id="panel-skxdAdminDictionary">
    <div class="portlet-title green">
        <div class="caption">
            <i class="fa fa-globe"></i>
        </div>
    </div>
    <div class="portlet-body">
        <table class="common_search">
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon green">请输入图片数据</span>
                        <input type="text" class="form-control" id="imageUrlShow" placeholder="请输入图片数据"
                               style="width: 400px;"/>
                    </div>
                </td>
                <td>
                    <input type="button" value="开始转化" class="btn green" onclick="javascript:showImage();"/>
                </td>
            </tr>
        </table>
        <br>

        <div id="imageShow" style="font-size: 20px;">

        </div>
    </div>
    <script>
        function showImage() {
            var imageValue = $("#imageUrlShow").val();
            if(imageValue==null || imageValue==""){
                message({
                    content:"情输入图片数据"
                });
                return;
            }
            var array = imageValue.split(",");
            $("#imageShow").html(" <h4>点击以下地址查看图片</h4><br>");
            for (var i = 0; i < array.length; i++) {
                var src = "http://101.201.147.34:8082/skxd-client/down/" + array[i] + "/a11.jpg";
                var image=$("<a target='_blank'></a>");
                $(image).attr("href",src);
                $(image).html("图片"+(i+1));
                $("#imageShow").append(image);
                $("#imageShow").append("&nbsp;");
            }
        }
    </script>
</div>
