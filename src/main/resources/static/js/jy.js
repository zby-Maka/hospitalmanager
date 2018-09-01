//清空
function  getclearproposedDescription() {
    $("input[name='sciencePopularization']").val("");
    $("input[name='adviceContent']").val("");
}
//添加常见结果
function getinsertproposedDescription() {
    var content = $('form').serialize();
    var proposedDescriptionId=$("#proposedDescriptionIds").val();
    var sciencePopularization = $("[name=sciencePopularization]").val();
    var adviceContent=$("[name=adviceContent]").val();
    alert(proposedDescriptionId);
    if (proposedDescriptionId==0){
        $.post("http://localhost:8080/insertProposedDescription.do",content,function (data) {
            alert(data);
            if (data.status==1){
                alert("添加成功");
                location.href="http://localhost:8080/Thebackend-page/jy.html"
            } else {
                alert("添加失败")
            }
        },"json")
    } else {
        $.post("http://localhost:8080/insertProposedDescription.do?proposedDescriptionId="+proposedDescriptionId+"&sciencePopularization="+sciencePopularization+"&adviceContent="+adviceContent,function (data) {
            if (data.status==1){
                alert("修改成功");
                $("#proposedDescriptionIds").val(0);
                location.href="http://localhost:8080/Thebackend-page/jy.html"
            } else {
                alert("修改失败")
            }
        },"json")
    }
}
