<!DOCTYPE html>
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
    <script src="${ctx}/resources/bootstrap/js/jquery-1.10.2.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/resources/common/js/ajaxfileupload.js"></script>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<input type="hidden" name="projectId" id="projectId" value="${userInfo.projectId}">
<input type="hidden" name="userId" id="userId" value="${userInfo.userId}">
<input type="hidden" name="deviceId" id="deviceId" value="${userInfo.deviceId}">

<div class="panel-group" id="accordion">
    <form class="form-horizontal" id="form">
        <div class="panel">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#deviceInfo">
                        设备信息
                    </a>
                </h4>
            </div>
            <div id="deviceInfo" class="panel-collapse collapse in">
                <div class="panel-body">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label">工程描述</label>

                            <div class="controls">
                                <div class="textarea">
                                    <textarea name="title" id="title"></textarea>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
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
                                <input class="input-file" id="file_${input.id}" name="file_${input.id}" type="file"
                                       onchange="uploadFile('${input.id}');">
                                <input type="hidden" name="${input.id}" hType="file" id="hidden_${input.id}">

                                <div id="img_${input.id}"></div>
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
                    </#if>
                </#list>
                </fieldset>
            </div>
        </div>
    </#list>
    </form>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <button class="btn blue" type="button" onclick="form_submit();">提交数据</button>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <button class="btn blue" type="button" onclick="data_reload();">读取缓存数据</button>
            </div>
        </div>
    </div>
</div>
</div>
<script>
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
                    alert(dirs);
                }
                element.val(form_json_obj[temp].value);
            }
        }
    }
    function form_submit() {
        var projectId = $("#projectId").val();
        var customId = $("#customId").val();
        var userId = $("#userId").val();
        var departmentId = $("#departmentId").val();
        var deviceId = $("#deviceId").val();
        var deviceNo = $("#deviceNo").val();
        var title = $("#title").val();
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
                window.location.href = "skxd:close";
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
                    img.attr("src", "${ctx}/" + result.data + '?' + new Date().getTime());
                    $("#img_" + id).append(img);
                    $("#hidden_" + id).val(result.data + "," + $("#hidden_" + id).val());
                    form_to_string();
                }, error: function (data, status, e) {
                    alert("error");
                }
            });
        }
    }
</script>
</body>
</html>