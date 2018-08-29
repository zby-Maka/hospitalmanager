$(function () {
    $(".select").click(function () {
        getPerson();
    });
    $("#save").click(function () {
        addResultAndMedicalEvent();
    })
})
//查询全部
function  getPerson() {
    var peacId=$("input[name=physicalExaminationId]").val();
    $.getJSON("http://localhost:8080/Person.html",{"peacId":peacId},function (date) {
        $.each(date.map1,function (i,m) {
            alert(m.personName);
            $("label[name=personName]").text(m.personName);
            $("label[name=personAge]").text(m.personAge);
            $("label[name=personSex]").text(m.personSex);
            $("label[name=isMarry]").text(m.isMarry);
        });
        console.log(date);
        alert(date.map);
        var content="<ul></ul>";
        $.each(date.map,function (b,n) {
            content+="<a href='javascript:result("+n.checkId+")'><li class='checkli'>"+n.checkName+"</li></a>"
        });
        $("#check").html(content);
    });
}
//获取结果
function  result(checkId) {
    $("input[name=checkId]").val(checkId);
    $.getJSON("http://localhost:8080/getCommResultsByCheckId.html",{"checkId":checkId},function (result) {
        $.each(result,function (i,e) {
            $("#checkResultFinally textarea").html(e.resultDesc);
            getProposedByResultId(e.commonResultsId);
            $("input[name=checkResultFinally]").val(e.commonResultsId);//结果id

        });

    });
};
//根据结果获取建议
function getProposedByResultId(commonResultsId) {
    $.getJSON("http://localhost:8080/getProposedByResultId.html",{"resultId":commonResultsId},function (result) {
        $.each(result,function (i,e) {
            $("#checkAdvice textarea").html(e.adviceContent);
            $("input[name=checkAdvice]").val(e.proposedDescriptionId);//建议id
        });
    });
}
//增加
function  addResultAndMedicalEvent() {
    var arr = formToJson($("form").serialize());
    var par = {checkResult: arr,medicalEventsList:null};
    $.ajax({
        url: 'http://localhost:8080/addResultAndMedicalEvent.html',
        data: JSON.stringify(par),
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        type: "post",
        success: function (date) {
            console.log(date);
            if (date.stat == "ok") {
                alert("success");
            } else {
                alert("error");
            }
        }
    });
}

//form表单转为json对象
function formToJson(data){
    data= decodeURIComponent(data,true);//防止中文乱码
    data = data.replace(/&/g, "','" );
    data = data.replace(/=/g, "':'" );
    data = "({'" +data + "'})" ;
    obj = eval(data);
    return obj;
}

