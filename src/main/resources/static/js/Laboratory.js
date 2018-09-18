var dataArry;
$(function () {
    $(".select").click(function () {
        var peacId=$("input[name=physicalExaminationId]").val();
        if(peacId == "") {
            alert("请输入体检编号！");
            return false;
        }
        getPerson();
    });
    $("#save").click(function () {
        addResultAndMedicalEvent();
    });

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
                alert("该体检人员在本科室的体检已全部完成！");
            }else{
                var content="";
                $.each(date.map,function (b,n) {
                    content+="<a href='javascript:getYan("+n.checkId+")'><li class='checkli'>"+n.checkName+"</li></a>";
                });
                $("#check").html(content);
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
    //增加
    function  addResultAndMedicalEvent() {
        var arr = formToJson($("form").serialize());
        console.log(arr);
        var dataStr = JSON.stringify(dataArry);
        console.log(dataStr);
        var par={
            checkResult:arr,
            medicalEventsList:dataArry
        };
        console.log(par);
        $.ajax({
            url: '/hospitalOne/addResultAndMedicalEvent.do',
            data:JSON.stringify(par),
            contentType:"application/json;charset=utf-8",
            dataType: "json",
            type: "post",
            success: function (resultJSON) {
                console.log(resultJSON);
                if (resultJSON.stat == "ok") {
                    updateStatu();
                    alert(" 保存成功！");
                    $(".xuan").parent().remove();
                    qing();
                } else {
                    alert(" 保存失败！");
                }
            }
        });
    }
})
//根据checkId获取传过来的lis 小项显示
    function getYan(checkId){
        $("input[name=checkId]").val(checkId);
    $.getJSON("/hospitalOne/getYan.do",{"checkId":checkId},function (date) {
        var content="";
        console.log(date);
        dataArry=date;
        var jian="";
        $.each(date,function (i,e) {
            if(e.medicalResultData<e.lowerLimit){       //如果小于参考下限
                jian="↓";
            }else if (e.medicalResultData>e.upperLimit) {   //如果大于参考上限
                jian="↑";
            }else {
                jian="-";
            }
            content+="<tr>" +
                "<td align=\"center\">"+e.eventsName+"</td>" +
                "<td align=\"center\">"+e.unit+"</td>" +
                "<td align=\"center\">"+e.upperLimit+"-"+e.lowerLimit+"</td>" +
                "<td align=\"center\">"+e.medicalResultData+"</td>" +
                "<td align=\"center\">"+jian+"</td>" +
                "</tr>";
        });
        $("#show").html(content);
    });

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
    $("#checkAdvice textarea").html("");
    $("input[name=checkAdvice]").val("");//建议id
    $("#show").html("");
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