//清空
function  getclearproposedDescription() {
    $("input[name='sciencePopularization']").val("");
    $("input[name='adviceContent']").val("");
    $("input[name=isDelete]").get(0).checked = true;
    $("input[name=sciencePopularization]").val("");
    $("input[name=adviceContent]").attr("readonly",false);
    $("input[name=sciencePopularization]").attr("readonly",false);
    $("select[name='resultId']").attr("disabled",true);
}
//添加常见建议
function getinsertproposedDescription() {
    var content = $('form').serialize();
    var proposedDescriptionId=$("#proposedDescriptionIds").val();
    var sciencePopularization = $("[name=sciencePopularization]").val();
    var adviceContent=$("[name=adviceContent]").val();
    if (sciencePopularization==""){
        swal("请输入建议内容")
        return;
    }else if(adviceContent==""){
        swal("请输入科普说明")
        return;
    }
    if (proposedDescriptionId==0){
        $.post("/hospitalOne/insertProposedDescription.do",content,function (data) {
            if (data.status==1){
                swal("添加成功");
                location.href="/hospitalOne/Thebackend-page/jy.html"
            } else {
                swal("添加失败")
            }
        },"json")
    } else {
        $.post("/hospitalOne/insertProposedDescription.do?proposedDescriptionId="+proposedDescriptionId,content,function (data) {
            if (data.status==1){
                swal("修改成功");
                $("#proposedDescriptionIds").val(0);
                location.href="/hospitalOne/Thebackend-page/jy.html"
            } else {
                swal("修改失败")
            }
        },"json")
    }
}
