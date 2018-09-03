function  getpersoninfo() {
    var physicalexaminationid=$("input[name=physicalexaminationid]").val();
    //通过体检编号查询体检人员
    $.post("http://localhost:8080/personInfo.do",{"physicalexaminationid":physicalexaminationid},function (data) {
        $("#dayin").removeAttr("disabled");
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
    $.post("http://localhost:8080/checkList.do",{"physicalExaminationId":physicalexaminationid},function (date) {
        sessionStorage.setItem("two",JSON.stringify(date));
        var contents="";
        var comt="";
        var jianyan="";
        var one = "" ;
        var two = "" ;
        $("#content").html("<table border=\"1\" style=\"margin:0 auto; margin-bottom: 15px; line-height: 30px;\" id=\"checknum\"></table>");
        $.each(date,function (i,e) {
            jianyan="";
            if (e.medicalEventsList.length==0) {
                contents+="<tr>" +
                    "<td align=\"right\">体检项：</td>" +
                    "<td>"+e.checkName+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">体检结果：</td>" +
                    "<td>"+e.commonResults.resultDesc+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">建&nbsp;&nbsp;&nbsp;&nbsp;议：</td>" +
                    "<td>" +
                    "<div style=\"width:  150mm;\">"+e.proposedDescription.adviceContent+"</div>" +
                    "</td>" +
                    "</tr>";
                one += ""+e.commonResults.resultDesc+"";
                two += ""+e.proposedDescription.adviceContent+"";

            }else {
                //通过体检编号查询体检人员的检验项
                $.each(e.medicalEventsList, function (i, c) {
                    comt += "<tr>" +
                        "<td>" + c.eventsName + "</td>" +
                        "<td>" + c.unit + "</td>" +
                        "<td>" + c.upperLimit + "-" + c.lowerLimit + "</td>" +
                        "<td>" + e.commonResults.resultDesc + "</td>" +
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
        $(".one").val(one);
        $(".two").val(two);
        $("#checknum").html(contents);
    },"json");
    $.post("http://localhost:8080/checkResults.do",{"physicalexaminationid":physicalexaminationid},function (result) {
        sessionStorage.setItem("three",JSON.stringify(result));
        alert(result);
        var content="";
        $.each(result,function (i,n) {
            content+=n.commonResults.resultDesc+"\n";
        });
        /*$("#one").val(content);*/
    },"json");
    $.post("http://localhost:8080/checkResults.do",{"physicalexaminationid":physicalexaminationid},function (results) {
        sessionStorage.setItem("four",JSON.stringify(results));
        alert(result);
        var contens="";
        $.each(results,function (i,e) {
            contens+=e.commonResults.proposedDescription.adviceContent+"\n";
        });
        /*$("#two").val(contens);*/
    },"json");
}

//跳转打印页面
function sendTotal() {
    location.href="/Thebackend-page/total.html";
}