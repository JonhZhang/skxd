<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--提示框-->
<div class="modal fade" id="message_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">提示框</h4>
      </div>
      <div class="modal-body">
        操作成功
      </div>
      <div class="modal-footer">
        <button type="button" class="btn default" data-dismiss="modal">确定</button>
      </div>
    </div>
  </div>
</div>
<!--确认框-->
<div class="modal fade" id="message_confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width:400px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">确认</h4>
      </div>
      <div class="modal-body">
        是否确认该操作?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn blue" id="message_confirm_ok">确定</button>
        <button type="button" class="btn default" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>
<!--对话框-->
<div class="modal fade" id="message_dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content" >
      <div class="modal-header" style="background-color:#26A69A;">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title default-font">确认</h4>
      </div>
      <div class="modal-body" id="message_dialog_content">
            对话框内容
      </div>
    </div>
  </div>
</div>
<script>
  var DIALOG
  //消息提示框
  window.message=function(json){
    if(json!=null && json.title!=null || json.title!=""){
      $('#message_alert .modal-title').html(json.title);
    }else{
      $('#message_alert .modal-title').html("提示");
    }
    if(json!=null && json.content!=null || json.content!=""){
      $('#message_alert .modal-body').html(json.content);
    }else{
      $('#message_alert .modal-body').html("操作成功");
    }
    $('#message_alert').modal('show');
  };
  //确认框
  window.messageConfirm=function(json){
    if(json!=null && json.title!=null || json.title!=""){
      $('#message_confirm .modal-title').html(json.title);
    }else{
      $('#message_confirm .modal-title').html("确认");
    }
    if(json!=null && json.content!=null || json.content!=""){
      $('#message_confirm .modal-body').html(json.content);
    }else{
      $('#message_confirm .modal-body').html("确认该操作吗");
    }
    //减除上一次的绑定
    $("#message_confirm_ok").unbind('click');
    if(json.callback!=null && json.callback!=""){
      $('#message_confirm_ok').click(function(){
          $('#message_confirm').modal('hide');
          json.callback();
      });
    }else{
      $('#message_confirm_ok').click(function(){
        alert("您按了确认");
      });
    }
    $('#message_confirm').modal('show');
  }
  //对话框
  window.messageDialog=function(json){
    if(json!=null && json.title!=null || json.title!=""){
      $('#message_dialog .modal-title').html(json.title);
    }else{
      $('#message_dialog .modal-title').html("确认");
    }

    if(json!=null && json.save!=null && json.save!=""){
        $("#dialog_save").click(json.save);
    }
    if(json!=null && json.width!=null && json.width!=""){
    	$('#message_dialog .modal-dialog').css("min-width",json.width);
    }
    if(json!=null && json.content!=null && json.content!=""){
      $('#message_dialog_content').html(json.content);
    }else if(json!=null && json.url!=null && json.url!=""){
      $.ajax({
          type: 'POST',
          url:contextPath+json.url,
          data:json.data,
          success:function(data){
            $("#message_dialog_content").html(data);
          },
          error : function() {
            var content="<div style='text-align: center;'><div class='number_404'>404</div></div>"
            $("#message_dialog_content").html(content);
          }
        });
    }else{
      $("#message_dialog_content").html("暂无内容");
    }
    $('#message_dialog').modal('show');
    $('#message_dialog').on('hidden.bs.modal', function (e) {
    	$("#dialog_save").unbind("click");
    })
    
  };
  window.closeMessageDialog=function(){
	 $('#message_dialog_content').html("");
     $('#message_dialog').modal('hide');
  };
  $("body").on("click",".close-dialog",function(){
    window.closeMessageDialog();
  });
</script>