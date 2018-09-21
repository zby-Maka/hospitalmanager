function  getpersoninfo() {
    var physicalexaminationid=$("input[name=physicalexaminationid]").val();
    //通过体检编号查询体检人员
    $.post("/hospitalOne/personInfo.do",{"physicalexaminationid":physicalexaminationid},function (data) {
        sessionStorage.setItem("one",JSON.stringify(data));
        $.each(data,function (i,e) {
            $("label[name=personName]").text(e.personName);
            $("label[name=personAge]").text(e.personAge);
            $("label[name=personSex]").text(e.personSex);
            $("label[name=isMarry]").text(e.isMarry);
        });
        var content="<ul></ul>";
        $.each(data,function (b,n) {
            content+="<a href=\"#\"><li>"+n.checkName+"</li></a>"
        });
        $("#check").html(content);
    },"json");
    //通过体检编号查询体检人员的检查项
    $.post("/hospitalOne/checkList.do",{"physicalExaminationId":physicalexaminationid},function (date) {
        if(date.length>0)
            $("#dayin").removeAttr("disabled");
        sessionStorage.setItem("two",JSON.stringify(date));
        var contents="";
        var comt="";
        var jianyan="";
        var one = "" ;
        var two = "" ;
        $("#content").html("<table border=\"1\" style=\"margin:0 auto; margin-bottom: 15px; line-height: 30px;\" id=\"checknum\"></table>");
        $.each(date,function (i,e) {
            comt="";
            jianyan="";
            if (e.medicalEventsList.length==0) {
                var cons="";
                if(e.commonResults.checkAdvice==undefined){
                    cons=""
                }else {
                    cons=e.commonResults.checkAdvice;
                }
                var conss="";
                if (e.commonResults.resultDesc==undefined){
                    conss="";
                } else {
                    conss=e.commonResults.resultDesc;
                }
                contents+="<tbody style='padding-top: 20px;'><tr>" +
                    "<td align=\"right\">体检项：</td>" +
                    "<td>"+e.checkName+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">体检结果：</td>" +
                    "<td>"+conss+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">建&nbsp;&nbsp;&nbsp;&nbsp;议：</td>" +
                    "<td>" +
                    "<div style=\"width:  150mm;\">"+cons+"</div>" +
                    "</td>" +
                    "</tr>" +
                    "<tr style='border: 0px solid white; height: 20px;'>" +
                    "<td style='border: 0px solid white;'></td>" +
                    "<td style='border: 0px solid white;'></td>" +
                    "</tr></tbody>";
                one += ""+conss+"\n";
                two += ""+cons+"\n";

            }else {
                //通过体检编号查询体检人员的检验项
                $.each(e.medicalEventsList, function (i, c) {
                    comt +="<tr>" +
                        "<td>" + c.eventsName + "</td>" +
                        "<td>" + c.unit + "</td>" +
                        "<td>" + c.upperLimit + "-" + c.lowerLimit + "</td>" +
                        "<td>" + c.medicalResultData+ "</td>" +
                        "<td>" + c.medicalResult + "</td>" +
                        "</tr>";
                });
                jianyan = "<table border=\"1\" style=\"margin:0 auto; margin-bottom: 15px; line-height: 30px;\">\n" +
                    "<tbody><tr>" +
                    "<td align=\"right\">体检项：</td>" +
                    "<td>" + e.checkName + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">体检结果：</td>" +
                    "<td>" +
                    "<table style=\"width: 180mm;\">" +
                    "<thead>" +
                    "<tr>" +
                    "<td>检验项</td>" +
                    "<td>单位</td>" +
                    "<td>参考范围</td>" +
                    "<td>结果</td>" +
                    "<td>提示</td>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" + comt + "</tbody>" +
                    "</table>\n" +
                    "</td>" +
                    "</tr>" +
                    "</tbody></table>";
            }
            $("#content").append(jianyan);
        })
        // $(".one").val(one);
        // $(".two").val(two);
        $("#checknum").html(contents);
        $("#Checkdate").text(getNowFormatDate());
    },"json");
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
//跳转打印页面
function sendTotal() {
    var jianyi = $("#checkAdvice textarea").val();
    sessionStorage.setItem("jianyi",jianyi);
    location.href="/hospitalOne/Thebackend-page/total.html";
}
