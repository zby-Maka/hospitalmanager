
//修改赋值
function findByIds() {
    var keid=localStorage["keid"];
    if(keid!=0){
        $.post("http://localhost:8080/addkeshiweihu.do?sectionId="+keid,function (data) {
            if(data.sectionStatus == 1){
                $("input[name=sectionStatus]").eq(0).prop("checked",true);
            }else{
                $("input[name=sectionStatus]").eq(1).prop("checked",true);
            }
            if(data.sectionTypeId == 1){
                $("input[name=sectionTypeId]").eq(0).prop("checked",true);
            }else if (data.sectionTypeId==2) {
                $("input[name=sectionTypeId]").eq(1).prop("checked",true);
            }else {
                $("input[name=sectionTypeId]").eq(2).prop("checked",true);
            }
            $("#sectionid").val(data.sectionId);
            $("textarea[name=remark]").val(data.remark);
            $("input[name=sectionName]").val(data.sectionName);

        },"json")
    }else {

    }
}
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
                resetInsert();
            }else {
                alert("修改成功");
            }
        },"json");
    }

}
function resetInsert() {
    $("#sectionid").val(0);
    $('form')[0].reset();
}