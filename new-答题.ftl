<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html40/strict.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>${project.name}-工单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="基于Bootstrap的web表单构造器，通过拖拽组件的方式生成完整可用的表单">
    <meta name="keywords" content="Bootstrap,Form,表单,拖拽">
    <meta name="author" content="Bootstrap中文网">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${ctx}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="${ctx}/resources/common/css/pikaday.css" rel="stylesheet">

    <script src="${ctx}/resources/bootstrap/js/jquery-1.10.2.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/resources/common/js/ajaxfileupload.js"></script>
    <script src="${ctx}/resources/common/js/ajaxfileupload.js"></script>
    <script src="${ctx}/resources/common/js/pikaday.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EfpqriVZU1wSQ64R7jyZ8uw5"></script>
    <style>
        .file {
            position: relative;
            display: inline-block;
            background: #CAD0D3;
            border: 1px solid #CAD0D3;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #090A0A;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }
        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }
    </style>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<input type="hidden" name="projectId" id="projectId" value="${userInfo.projectId}">
<input type="hidden" name="userId" id="userId" value="${userInfo.userId}">
<input type="hidden" name="deviceId" id="deviceId" value="${userInfo.deviceId}">
<div class="container-fluid">
    <div class="panel">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#deviceInfo">
                    仪器信息
                </a>
            </h4>
        </div>
        <div id="deviceInfo" class="panel-collapse collapse in">
            <div class="panel-body">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="input01">工作内容概要</label>
                        <div class="controls">
                            <div class="textarea">
                                <textarea name="title" id="title" style="margin: 0px; height: 36px; width: 271px;"></textarea>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
    <form class="form-horizontal" id="form">
    <#list stepList as step>
        <div class="panel">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#${step.id}">
                        ${step.stepName}
                    </a>
                </h4>
            </div>
            <div id="${step.id}" class="panel-collapse collapse in">
            <div class="panel-body">
            <fieldset>
                <#list step.skxdTemplateInputVoList as input>
                    <#if input.inputType=="view">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>

                            <div class="controls">
                                <div class="col-md-12 column">
                                    <ol>
                                        <#list input.inputContent?split("|") as temp>
                                            <li>
                                                ${temp}
                                            </li>
                                        </#list>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <#elseif input.inputType=="text">
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">${input.inputName}</span>
                                    <input class="input-xlarge" placeholder="请输入${input.inputName}" name="${input.id}"
                                           type="text"
                                           onblur="form_to_string();">
                                </div>
                            </div>
                        </div>
                    <#elseif input.inputType=="select">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>

                            <div class="controls">
                                <#list input.inputContent?split(",") as temp>
                                    <label class="checkbox">
                                        <input type="checkbox" name="${input.id}" value="${temp}"
                                               onblur="form_to_string();">${temp}
                                    </label>
                                </#list>
                            </div>
                        </div>
                    <#elseif input.inputType=="title">
                        <div class="control-group">
                            <span class="label label-default">${input.inputName}</span>
                        </div>
                    <#elseif input.inputType=="file">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>
                            <div class="controls">
                                <input type="hidden" name="${input.id}" hType="file" id="hidden_${input.id}">
                                <div id="img_${input.id}"></div>
                                <a href="javascript:;" class="file">上传图片
                                    <input class="input-file" id="file_${input.id}" name="file_${input.id}" type="file"     onchange="uploadFile('${input.id}');">
                                </a>
                            </div>
                        </div>
                    <#elseif input.inputType=="textarea">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>
                            <div class="controls">
                                <div class="textarea">
                                    <textarea type="" name="${input.id}" onblur="form_to_string();"></textarea>
                                </div>
                            </div>
                        </div>
                    <#elseif input.inputType=="position">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>
                            <div class="controls">
                                <div id="map_${input.id}" style="height: 300px;width:100%;"></div>
                                <input type="hidden" name="${input.id}" id="${input.id}" value="">
                                <input type="button" onclick="javascript:window.android.getLocation('${input.id}');" value="定位">
                            </div>
                        </div>
                        <script>
                            var map_temp = new BMap.Map("map_${input.id}");
                            var point_temp = new BMap.Point(116.331398,39.897445);
                            map_temp.centerAndZoom(point_temp,12);
                        </script>
                    <#elseif input.inputType=="dic">
                        <label class="control-label">选择字典</label>
                        <div class="controls">
                            <select name="dictionary"  class="input-xlarge" onchange="dictionaryList('${input.id}',this);">
                                <option value="">无</option>
                                <#list dictionaryList as temp>
                                    <option value="${temp.id}">${temp.name}</option>
                                </#list>
                            </select>
                        </div>
                        <label class="control-label">选择字典项</label>
                        <div class="controls">
                            <select class="input-xlarge"  name="${input.id}" id="${input.id}" onclick="form_to_string();">
                                <option value="">无</option>
                            </select>
                        </div>
                    <#elseif input.inputType=="date">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>
                            <div class="controls">
                                <input class="input-xlarge" inputType="date" placeholder="请输入${input.inputName}" name="${input.id}"  type="text" onblur="form_to_string();">
                            </div>
                        </div>
                    <#elseif input.inputType=="cam">
                        <div class="control-group">
                            <label class="control-label">${input.inputName}</label>
                            <div class="controls">
                                <input type="text" name="${input.id}" id="${input.id}" value="">
                                <input type="button" onclick="javascript:window.android.getJavaInterface(1,'${input.id}');" value="扫描">
                            </div>
                        </div>
                    </#if>
                </#list>
                </fieldset>
            </div>
        </div>
    </#list>
    </form>
    <div class="row-fluid">
        <div class="span12">
            <button class="btn btn-block" type="button" onclick="form_submit();">提交工单</button>
            <button class="btn btn-block" type="button" onclick="data_reload();">加载数据</button>
        </div>
    </div>
</div>
<div class="modal hide fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">×</button>
        <h5 id="myModalLabel">Modal header</h5>
    </div>
    <div id="modal-body" class="modal-body"></div>
</div>

<div class="modal hide fade" id="load" tabindex="-1" role="dialog">
    <div class="modal-header">
        <h5>正在上传</h5>
    </div>
    <div class="modal-body" style="text-align: center;">
        <img src="${ctx}/resources/bootstrap/img/load.gif"></div>
</div>
</div>
<script>
    $("div input[inputType='date']").each(function(){
        var picker = new Pikaday(
                {
                    field:this,
                    firstDay: 1,
                    minDate: new Date('2001-01-01'),
                    maxDate: new Date('2020-12-31'),
                    yearRange: [2000,2020]
                });
    });
    var project_id = $("#projectId").val();
    var form_json_obj = null;
    var form_json_str = "";
    //将form表单转化成字符串保存
    //将字符串和json保存在本地
    function form_to_string() {
        var form_json_obj = $("#form").serializeArray();
        var form_json_str = JSON.stringify(form_json_obj);
        localStorage.setItem(project_id + "_form_json_obj", form_json_obj);
        localStorage.setItem(project_id + "_form_json_str", form_json_str);
    }

    function dictionaryList(id,obj){
        var value=$(obj).val();
        var name=$(obj).find("option:selected").text();
        $.ajax({
            url: "${ctx}/answer/queryDicList",
            data: {
                "dId": value
            },
            success: function (data) {
                if(data.status==1){
                    var options="";
                    for(var i=0;i<data.data.length;i++){
                        options=options+"<option value=' "+name+"-"+data.data[i].name+" '>"+data.data[i].name+"</option>";
                    }
                    $("#"+id).html("");
                    $("#"+id).html(options);
                }
            }
        });
    }

    function setLocation(longitude,latitude,inputId){
        var map = new BMap.Map("map_"+inputId);
        var point = new BMap.Point(longitude,latitude);
        map.setCenter(point);
        map.centerAndZoom(point,12);
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
        var label = new BMap.Label("当前位置",{offset:new BMap.Size(20,-10)});
        marker.setLabel(label); //添加百度label
        position=longitude+'-'+latitude;
        $("#"+inputId).val(position);
    }
    //加载本地缓存 取出数据
    function data_reload() {
        form_json_obj = eval('(' + localStorage.getItem(project_id + "_form_json_str") + ')');
        for (var temp in form_json_obj) {
            var element = $(":input[name=" + form_json_obj[temp].name + "]");
            var input_type = $(":input[name=" + form_json_obj[temp].name + "]").attr("type");
            if (input_type == "text") {
                element.val(form_json_obj[temp].value);
            } else if (input_type == "checkbox") {
                $("input[name='" + form_json_obj[temp].name + "']").each(function () {
                    if ($(this).val() == form_json_obj[temp].value) {
                        $(this).prop("checked", true);
                    }
                });
            } else if (input_type == "radio") {
                $("input[name='" + form_json_obj[temp].name + "']").each(function () {
                    if ($(this).val() == form_json_obj[temp].value) {
                        $(this).prop("checked", true);
                    }
                });
            } else {
                var hType = element.attr("hType");
                if (hType == "file") {
                    var dirs = form_json_obj[temp].value;
                    var dir_array = dirs.split(",");
                    var img_div = element.next();
                    img_div.val("");
                    for (var i = 0; i < dir_array.length; i++) {
                        if (dir_array[i] != "" && dir_array[i] != null) {
                            var img = $("<img style='width:50px;height:50px;padding:2px;'></img>")
                            img.attr("src", "${ctx}/" + dir_array[i] + '?' + new Date().getTime());
                            img_div.append(img);
                            img_div.val(dir_array[i] + "," + img_div.val());
                        }
                    }
                }
                element.val(form_json_obj[temp].value);
            }
        }
    }
    function javaCallBack(type,inputId,result){
        $("#"+inputId).val(result);
    }
    function form_submit() {
        var projectId = $("#projectId").val();
        var customId = $("#customId").val();
        var userId = $("#userId").val();
        var departmentId = $("#departmentId").val();
        var deviceId = $("#deviceId").val();
        var deviceNo = $("#deviceNo").val();
        var title = $("#title").val();
        if(title==null || title.length<2){
            message({content:"工程描述至少两个字"});
            return;
        }
        else if(title==null || title.length>50){
            message({content:"工程描述不能大于50个字"});
            return ;
        }
        $('#load').modal({backdrop: 'static',keyboard: false},'show');
        var form_json_obj = $("#form").serializeArray();
        var form_json_str = JSON.stringify(form_json_obj);
        $.ajax({
            url: "${ctx}/answer/execute",
            data: {
                "projectId": projectId,
                "customId": customId,
                "userId": userId,
                departmentId: departmentId,
                deviceId: deviceId,
                deviceNo: deviceNo,
                title: title,
                answers: form_json_str
            },
            success: function (data) {
                if(data.status==1){
                    window.location.href = "skxd:close";
                }else{
                    window.message({title:"提示",content:data.message});
                }
            }
        });
    }
    function uploadFile(id) {
        if ($("#" + id).val() != "") {
            $.ajaxFileUpload({
                url: '${ctx}/uploadFile?name=file_' + id + '&userId=${userInfo.userId}',
                secureuri: true,
                fileElementId: "file_" + id,
                dataType: 'json',
                success: function (result) {
                    var img = $("<img style='width:50px;height:50px;padding:2px;'></img>")
                    img.attr("src", "${ctx}/down/" + result.data + "/a11.jpg"+'?' + new Date().getTime());
                    $("#img_" + id).html(img);
                    $("#hidden_" + id).val(result.data);
                    form_to_string();
                }, error: function (data, status, e) {
                    message({content:"error"});
                }
            });
        }
    }
    window.message=function(json){
        if(json!=null && json.title!=null && json.title!=""){
            $('#myModalLabel').html(json.title);
        }else{
            $('#myModalLabel').html("提示");
        }
        if(json!=null && json.content!=null && json.content!=""){
            $('#modal-body').html(json.content);
        }else{
            $('modal-body').html("操作成功");
        }
        $('#myModal').modal({
            backdrop: 'static',
            keyboard: false
        },'show');
    };
</script>

</body>
</html>