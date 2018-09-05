//清空
function  getclearcommonresult() {
    $("input[name=isDelete]").get(0).checked = true;
    $("input[name=isPositive]").get(1).checked = true;
    $("#commonResultsIds").val(0);
    $("input[name='resultDesc']").val("");
    $("input[name='resultDesc']").attr("readonly",false);

}

//添加常见结果
function getinsertcommonresult() {
    var content = $('form').serialize();
    var commonResultsId=$("#commonResultsIds").val();
    var resultDesc = $("[name=resultDesc]").val();
    var checkid=$("#checkid").val();
    var crId=localStorage["cid"];
    //$("input[type='button']").parent().append(get());
    if (resultDesc==""){
        alert("请输入建议描述")
        return
    }
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
        $.post("http://localhost:8080/insertcommonResults.do?commonResultsId="+commonResultsId,content,function (data) {
            if (data.status==1){
                alert("修改成功");
                location.href="http://localhost:8080/Thebackend-page/jieguojianyi.html"
            } else {
                alert("修改失败")
            }
        },"json")
    }
}

function getjianyi(commonResultsid,cid) {
    alert(cid);
    sessionStorage.setItem("commonResultsId",commonResultsid);
    sessionStorage.setItem("cid",cid);
    window.location.href="http://localhost:8080/Thebackend-page/jy.html";
}
