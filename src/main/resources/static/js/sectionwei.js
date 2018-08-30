//修改赋值
function findById(sectionid) {
    $.post("http://localhost:8080/addkeshiweihu?sectionid="+sectionid,function (data) {
        if(data.sectionStatus == 1){
            $("input[name=sectionStatus]").get(0).checked = true;
        }else{
            $("input[name=sectionStatus]").get(1).checked = true;
        }
        if(data.sectionTypeId == 1){
            $("input[name=sectionTypeId]").get(0).checked = true;
        }else if (data.sectionTypeId==2) {
            $("input[name=sectionTypeId]").get(1).checked = true;
        }else {
            $("input[name=sectionTypeId]").get(2).checked = true;
        }
        $("#sectionid").val(data.sectionid);
        $("input[name=resultDesc]").val(data.resultDesc);

    },"json")
}
//添加科室维护信息
function getinsertsection() {
    var content = $('form').serialize();
    var sectionid=$("#sectionid").val();
    if (sectionid==0){
        $.post("http://localhost:8080/keshiweihu.do",content,function (data) {
            if (data.status==1){
                alert("添加成功");
            }else {
                alert("添加失败");
            }
        },"json");
    }else {
        $.post("http://localhost:8080/keshiweihu.do",content,function (data) {
            if (data.status==1){
                alert("修改成功");
            }else {
                alert("修改成功");
            }
        },"json");
    }

}