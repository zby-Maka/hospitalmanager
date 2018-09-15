$(function () {
    $(".select").click(function () {
        var peacId=$("input[name=physicalExaminationId]").val();
          if(peacId == "") {
               swal("请输入体检编号！");
               return false;
            }
         getPerson();
    });
    $("#save").click(function () {
        addResultAndMedicalEvent();
    })
})
//查询全部
function  getPerson() {
    var peacId=$("input[name=physicalExaminationId]").val();
    $.getJSON("/hospitalOne/Person.do",{"peacId":peacId},function (date) {
        $.each(date.map1,function (i,m) {
            $("label[name=personName]").text(m.personName);
            $("label[name=personAge]").text(m.personAge);
            $("label[name=personSex]").text(m.personSex);
            $("label[name=isMarry]").text(m.isMarry);
        });
        if($.trim(date.map)==''){
            swal("该体检编号在本科室的体检项！");
        }else{
            var content="<ul></ul>";
            $.each(date.map,function (b,n) {
                content+="<a href='javascript:result("+n.checkId+")'><li class='checkli'>"+n.checkName+"</li></a>"
            });
            $("#check").html(content);
        }
    });
}
//获取结果
function  result(checkId) {
    $("input[name=checkId]").val(checkId);
    $.getJSON("/hospitalOne/getCommResultsByCheckId.do",{"checkId":checkId},function (result) {
        $("#checkResultFinally textarea").html(result.resultDesc);
        $("input[name=checkResultFinally]").val(result.commonResultsId);//结果id
        //如果结果是正常的话建议为空
        if (result.resultDesc=="正常"){
            $("#checkAdvice textarea").html("");
        }else {
            //否则赋值
            getProposedByResultId(result.commonResultsId);
        }
    });
};
//根据结果获取建议
function getProposedByResultId(commonResultsId) {
    $.getJSON("/hospitalOne/getProposedByResultId.do",{"resultId":commonResultsId},function (result) {
        $.each(result,function (i,e) {
            $("#checkAdvice textarea").html(e.adviceContent);
        });
    });
}
//增加
function  addResultAndMedicalEvent() {
    //获取建议文本框
    var checkAdvice= $("#test").val();
    //判断结果文本域为空不能添加
    var checkResultFinally=$("#checkResultFinally textarea").html();
    if(checkResultFinally.trim()==""){
        swal("该体检项还没有结果！");
        return;
    }
    var arr = formToJson($("form").serialize());
    var par = {checkResult: arr,medicalEventsList:null};
    $.ajax({
        url: '/hospitalOne/addResultAndMedicalEvent.do?checkAdvice='+checkAdvice,
        data: JSON.stringify(par),
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        type: "post",
        success: function (date) {
            console.log(date);
            if (date.stat == "ok") {
                updateStatu();
                swal("保存成功！");
                $(".xuan").parent().remove();
                qing();
            } else {
                swal("保存失败！");
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
//增加之后清空数据
function  qing() {
    var checkli = $(".checkli");
    if(checkli.length==0){
        $("input[name=physicalExaminationId]").val("");
        $("label[name=personName]").text("");
        $("label[name=personAge]").text("");
        $("label[name=personSex]").text("");
        $("label[name=isMarry]").text("");
        $("#check").html("");
    }
    $("#checkResultFinally textarea").html("");
    $("input[name=checkResultFinally]").val("");//结果id
    $("#test").val("");//建议
}
//体检成功之后修改状态
function  updateStatu() {
    var peaId=$("input[name=physicalExaminationId]").val();
    var checkId=$("input[name=checkId]").val();
    $.getJSON("/hospitalOne/update.do",{"peaId":peaId,"checkId":checkId},function (data) {
        var ok="0";
        if(data>0){
           ok="1";
        }else{
            ok="0";
        }
    })
}
