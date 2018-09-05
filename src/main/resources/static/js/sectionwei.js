
//添加科室维护信息
function getinsertsection() {
    var content = $('form').serialize();
    var sectionid=$("#sectionid").val();
    var  sectionName=$("input[name=sectionName]").val();
    if (sectionName==""){
        alert("请输入科室名称");
        return;
    }
    if (sectionid==0){
        $.post("http://localhost:8080/keshiweihu.do",content,function (data) {
            if (data.status==1){
                alert("添加成功");
                resetInsert();
            }else {
                alert("添加失败");
            }
        },"json");
    }else {
        $.post("http://localhost:8080/keshiweihu.do?sectionId="+sectionid,content,function (data) {
            if (data.status==1){
                alert("修改成功");
                findByIds();
            }else {
                alert("修改失败");
            }
        },"json");
    }

}
function resetInsert() {
    $("#sectionid").val(0);
    $('form')[0].reset();
    $("textarea[name=remark]").attr("readonly",false);
    $("input[name='sectionName']").attr("readonly",false);
}