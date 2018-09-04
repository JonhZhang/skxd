<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="panel-select-assessor" class=" skxd-padT-15 skxd-mrgB-20">
		<div class="form-body">
			<div class="form-group">


			<div class="skxd-condition-l">选择主管：</div>
			<div class="skxd-width-800 skxd-float-left" style="overflow: auto;height: 250px;text-align: left" >
				<form>
				<c:forEach var="item" items="${leaders }">
					<input class="chk"  type="checkbox" name="selectedAssessor" value="${item.id}" > ${item.userName}
				</c:forEach>
					<input type="hidden" name="userId" value="${userId}"  />
				</form>
			</div>

		</div>
		<h3>
			<input type="hidden" name="select_userId" value="${userId}"/>
		</h3>
	</div>
	<div class="form-actions">
		<div class="row">
			<div class="col-md-offset-4 col-md-9">
				<button type="button" class="btn green" onclick="zxsAssessor.viewPanel.submit();">提交</button>
				<button type="button" class="btn default close-dialog">取消</button>
			</div>
		</div>
	</div>

<script>


    var panel_select_assessor = $("#panel-select-assessor");

    $(function () {
        var $viewPanel = $("#panel-select-assessor");
        zxsAssessor.viewPanel = $viewPanel;
		var selectedLeaderIds = '${selectedLeaderIds}';

        var selectedLeaderIds =selectedLeaderIds.split(",");

        zxsAssessor.viewPanel.find(".chk").each(function() {
            var _this = $(this);
			console.log(_this.val());
            var r = $.inArray(_this.val(), selectedLeaderIds);
            if(r < 0 ) {
                _this.prop("checked",false);
			}else {
                _this.prop("checked",true);
			}
		})


        zxsAssessor.viewPanel.submit = function() {
            $.ajax({
                url: contextPath + "/admin/user/modifyAssessor",
                method: "post",
                data: zxsAssessor.viewPanel.find("form").serialize(),
                success: function (json) {
                  console.log(json);
                    window.closeMessageDialog();
                    return false;
                }
            });
		}
    });
</script>