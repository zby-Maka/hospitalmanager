
//添加科室维护信息
function getinsertsection() {
    var content = $('form').serialize();
    $.post("http://localhost:8080/keshiweihu.do",content,function (data) {
       if (data.status==1){
           alert("添加成功");
       }else {
           alert("添加失败");
       }
    },"json");
}