var UTILS;
function Utils(){
   var util={};
   util.reqToDiv=function(params){
      $("#"+params.div).load(params.url,params.data,params.callback);
   };
   return util;
}
UTILS=new Utils();
