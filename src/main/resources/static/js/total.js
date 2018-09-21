$(function () {
    sessionStorageData();
});

/**
 * 获取打印数据
 */
function sessionStorageData() {
    //人员信息
    var persionInfo = sessionStorage.getItem("one");
    //体检项
    var checkInfo = sessionStorage.getItem("two");

    //个人信息
    $.each(JSON.parse(persionInfo),function (i,e) {
        $("label[name=personName]").text(e.personName);
        $("label[name=personAge]").text(e.personAge);
        $("label[name=personSex]").text(e.personSex);
        $("label[name=isMarry]").text(e.isMarry);
    });

        var contents="";
        var comt="";
        var jianyan="";
        var one = "" ;
        var two = "" ;
        $.each(JSON.parse(checkInfo),function (i,e) {
            comt="";
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
                contents+="<table style=\"margin-left: 48px;\">" +
                    "<tbody>" +
                    "<tr>" +
                    "<td align=\"right\">体检项：</td>" +
                    "<td>"+e.checkName+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">体检结果：</td>" +
                    "<td>"+conss+"</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td align=\"right\">建&nbsp;&nbsp;&nbsp;&nbsp;议：</td>" +
                    "<td>\n" +
                    "<div style=\"width:  150mm;\">"+
                    cons +
                    "</div>" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<hr/>";
                one += ""+conss+"\n";
                two += ""+cons+"\n";
            }else {
                //通过体检编号查询体检人员的检验项
                $.each(e.medicalEventsList, function (i, c) {
                    comt += "<tr>" +
                        "<td>" + c.eventsName + "</td>" +
                        "<td>" + c.unit + "</td>" +
                        "<td>" + c.upperLimit + "-" + c.lowerLimit + "</td>" +
                        "<td>" + c.medicalResultData + "</td>" +
                        "<td>" + c.medicalResult + "</td>" +
                        "</tr>";
                });
                jianyan += "<table style=\"margin:0 auto; margin-bottom: 15px; line-height: 30px;\">\n" +
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
        })

    $("#jiancha").html(contents);
    $("#jiancha").after(jianyan);
    // $($("textarea").get(0)).html(one);
    $($("textarea").get(0)).html(sessionStorage.getItem("jianyi"));
    $($("textarea").get(0)).attr("disabled",true);
    $("#Checkdate").text(getNowFormatDate());
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