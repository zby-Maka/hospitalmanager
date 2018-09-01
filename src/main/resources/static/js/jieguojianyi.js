//清空
function  getclearcommonresult() {
    $("input[name='resultDesc']").val("");
}

//添加常见结果
function getinsertcommonresult() {
    var content = $('form').serialize();
    var commonResultsId=$("#commonResultsIds").val();
    var resultDesc = $("[name=resultDesc]").val();
    var checkid=$("#checkid").val();
    var resutltid=localStorage["rid"];
    var getid="<input type='button' value='查看建议' onclick='getjianyi()'> "
    alert(checkid);
    if (commonResultsId==0){
        $.post("http://localhost:8080/insertcommonResults.do",content,function (data) {
            if (data.status==1){
                alert("添加成功");
                location.href="http://localhost:8080/Thebackend-page/jieguojianyi.html"
            } else {
                alert("添加失败")
            }
        },"json")
    } else {
        $.post("http://localhost:8080/insertcommonResults.do?commonResultsId="+commonResultsId+"&resultDesc="+resultDesc,function (data) {
            if (data.status==1){
                alert("修改成功");
                location.href="http://localhost:8080/Thebackend-page/jieguojianyi.html"
            } else {
                alert("修改失败")
            }
        },"json")
    }
    function getjianyi() {
        window.location.href="http://localhost:8080/Thebackend-page/jy.html?rid="+commonResultsId;
    }
}
