
//添加常见结果
function getinsertcommonresult() {
    var content = $('form').serialize();
    alert(content);
        $.post("http://localhost:8080/insertcommonResults.do",content,function (data) {
            alert(data);
            if (data.status==1){
                alert("添加成功");
            } else {
                alert("添加失败")
            }
        },"json")
}
function getupdatecommonresult() {
    var commonResultsId=$("#commonResultsId").val();
    var resultDesc = $("[name=resultDesc]").val();
    $.post("http://localhost:8080/updatecommonResults.do?commonResultsId="+commonResultsId+"&resultDesc="+resultDesc,function (data) {
        alert(data);
        if (data.status==1){
            alert("修改成功");
        } else {
            alert("修改失败")
        }
    },"json")
}