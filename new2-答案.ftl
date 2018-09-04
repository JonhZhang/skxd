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
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EfpqriVZU1wSQ64R7jyZ8uw5"></script>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<div class="panel-group" id="accordion">
    <form class="form-horizontal" id="form">
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
                            <label class="control-label">工作内容概要</label>
                            <div class="controls">
                                <div class="textarea">
                                    <textarea readonly="readonly" name="title"><#if answer.title??>${answer.title}</#if></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">客户姓名</span>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdCustom.customName}"  type="text" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">工程师姓名</span>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdUser.userName}"  type="text" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">仪器编号</span>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.deviceNo}"  type="text" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">仪器型号</span>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.deviceType}"  type="text" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">销售商</span>
                                <#if skxdDevice.seller??>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.seller}"  type="text" disabled>
                                <#else>
                                    <input class="input-xlarge"   value=""  type="text" disabled>
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">服务商</span>
                                <#if skxdDevice.server??>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.server}"  type="text" disabled>
                                <#else>
                                    <input class="input-xlarge"  value=""  type="text" disabled>
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">安装时间</span>
                                <#if skxdDevice.installTime??>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.installTime?string("yyyy-MM-dd HH:mm:ss")}"  type="text" disabled>
                                <#else>
                                    <input class="input-xlarge"  value=""  type="text" disabled>
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">安装人</span>
                                <#if skxdDevice.installer??>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.installer}"  type="text" disabled>
                                <#else>
                                    <input class="input-xlarge" value=""  type="text" disabled>
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">仪器状态</span>
                                <#if skxdDevice.deviceState??>
                                    <input class="input-xlarge" placeholder="placeholder"  value="${skxdDevice.deviceState}"  type="text" disabled>
                                <#else>
                                    <input class="input-xlarge"  value=""  type="text" disabled>
                                </#if>
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
                                        <div class="container-fluid" id="XS">
                                            <div class="row-fluid">
                                                <div class="span12">
                                                    <ol>
                                                        <#if input.inputContent??>
                                                            <#list input.inputContent?split("|") as temp>
                                                                <li>
                                                                    ${temp}
                                                                </li>
                                                            </#list>
                                                        </#if>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <#elseif input.inputType=="text">
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="input-prepend">
                                            <span class="add-on">${input.inputName}</span>
                                            <#if input.answers??>
                                                <input class="input-xlarge" placeholder="请输入${input.inputName}"
                                                       value="${input.answers}" name="${input.id}" type="text" disabled>
                                            <#else>
                                                <input class="input-xlarge" placeholder="请输入${input.inputName}" value=""
                                                       name="${input.id}" type="text" disabled>
                                            </#if>
                                        </div>
                                    </div>
                                </div>
                            <#elseif input.inputType=="select">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
                                        <#if input.inputContent??>
                                            <#list input.inputContent?split(",") as temp>
                                                <label class="checkbox">
                                                    <input type="checkbox" name="${input.id}" value="${temp}"
                                                        <#if input.answers??>
                                                            <#list input.answers?split(",") as answer>
                                                                <#if answer==temp>
                                                           checked="checked" <#break>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                           disabled>${temp}
                                                </label>
                                            </#list>
                                        </#if>
                                    </div>
                                </div>
                            <#elseif input.inputType=="dic">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
					    <#if input.answers??>
                            <input class="input-xlarge" placeholder="请输入${input.inputName}"
                                   value="${input.answers}" name="${input.id}" type="text" disabled>
                        <#else>
                                                <input class="input-xlarge" placeholder="请输入${input.inputName}" value=""
                                                       name="${input.id}" type="text" disabled>
                        </#if>
                                    </div>
                                </div>
                            <#elseif input.inputType=="title">
                                <div class="control-group">
                                    <span class="label label-default">${input.inputName}</span>
                                </div>
                            <#elseif input.inputType=="date">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
                                        <#if input.answers??>
                                            <input class="input-xlarge" placeholder="请输入${input.inputName}"
                                                   value="${input.answers}" name="${input.id}" type="text" disabled>
                                        <#else>
                                            <input class="input-xlarge" placeholder="请输入${input.inputName}" value=""
                                                   name="${input.id}" type="text" disabled>
                                        </#if>
                                    </div>
                                </div>
                            <#elseif input.inputType=="file">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
                                        <#if input.answers?? && input.answers!="">
                                            <#list input.answers?split(",") as answer>
                                                <#if answer?? && answer!="">
                                                    <img src="${ctx}/down/${answer}/a11.jpg" style="padding: 2px;"/>
                                                </#if>
                                            </#list>
                                        <#else>
                                            未上传图片
                                        </#if>
                                    </div>
                                </div>
                            <#elseif input.inputType=="textarea">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
                                        <div class="textarea">
                                            <textarea readonly="readonly"  name="${input.id}"><#if input.answers??>${input.answers}</#if></textarea>
                                        </div>
                                    </div>
                                </div>
                            <#elseif input.inputType=="position">
                                <div class="control-group">
                                    <label class="control-label">${input.inputName}</label>
                                    <div class="controls">
                                        <div id="map_${input.id}" style="height: 300px;width:100%;"></div>
                                    </div>
                                </div>
                                <script>
                                    var map_temp = new BMap.Map("map_${input.id}");
                                    var point = new BMap.Point(116.331398,39.897445);
                                        <#if input.answers??>
                                            <#if input.answers?length gt 8>
                                            point = new BMap.Point(${input.answers?split("-")[0]},${input.answers?split("-")[1]});
                                            var marker = new BMap.Marker(point);
                                            map_temp.addOverlay(marker);
                                            </#if>
                                        </#if>
                                    map_temp.centerAndZoom(point,12);
                                </script>
                            <#elseif input.inputType=="cam">
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="input-prepend">
                                            <span class="add-on">${input.inputName}</span>
                                            <#if input.answers??>
                                                <input class="input-xlarge" placeholder="请输入${input.inputName}"
                                                       value="${input.answers}" name="${input.id}" type="text" disabled>
                                            <#else>
                                                <input class="input-xlarge" placeholder="请输入${input.inputName}" value=""
                                                       name="${input.id}" type="text" disabled>
                                            </#if>
                                        </div>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                    </fieldset>
                </div>
            </div>
        </div>
    </#list>
    </form>
</div>
</body>
</html>