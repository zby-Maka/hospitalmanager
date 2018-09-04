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
    //检查结果
    var resultInfo = sessionStorage.getItem("three");
    //建议
    var commInfo = sessionStorage.getItem("four");

    //个人信息
    $.each(JSON.parse(persionInfo),function (i,e) {
        $("label[name=personName]").text(e.personName);
        $("label[name=personAge]").text(e.personAge);
        $("label[name=personSex]").text(e.personSex);
        $("label[name=isMarry]").text(e.isMarry);
    });

    var jiancha="";
    var jianyan="";
    var events="";
    //体检项
    $.each(JSON.parse(checkInfo),function (i,e) {
        var jianyi="";
        if (e.medicalEventsList.length==0) {
            if(e.proposedDescription.adviceContent!=undefined){
                jianyi=e.proposedDescription.adviceContent;
            }else {
                jianyi="";
            }
            jiancha+="<table style=\"margin-left: 48px;\">" +
                    "<tbody>" +
                        "<tr>" +
                            "<td align=\"right\">体检项：</td>" +
                            "<td>"+e.checkName+"</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td align=\"right\">体检结果：</td>" +
                            "<td>"+e.commonResults.resultDesc+"</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td align=\"right\">建&nbsp;&nbsp;&nbsp;&nbsp;议：</td>" +
                            "<td>\n" +
                                "<div style=\"width:  150mm;\">"+
                                    jianyi +
                                "</div>" +
                            "</td>" +
                        "</tr>" +
                    "</tbody>" +
                "</table>" +
                "<hr/>";
        }else {
            //通过体检编号查询体检人员的检验项
            $.each(e.medicalEventsList,function (i,c) {
                events+= "<tr>" +
                            "<td align=\"center\">"+c.eventsName+"</td>" +
                            "<td align=\"center\">"+c.unit+"</td>" +
                            "<td align=\"center\">"+c.upperLimit+"-"+c.lowerLimit+"</td>" +
                            "<td align=\"center\">"+e.commonResults.resultDesc+"</td>" +
                            "<td align=\"center\">"+c.medicalResult+"</td>" +
                          "</tr>";
            });
            jianyan+=""+
                "<table style=\"margin-bottom: 15px; margin-left:56px; line-height: 30px;\">" +
                    "<tbody>" +
                        "<tr>" +
                            "<td align=\"center\">体检项：</td>" +
                            "<td align=\"center\">"+e.checkName+"</td>" +
                        "</tr>" +
                        "<tr>" +
                            "<td align=\"left\">体检结果：</td>" +
                            "<td>" +
                                "<table border=\"1\" style=\"width: 150mm;\">" +
                                    "<thead>" +
                                        "<tr>" +
                                            "<td align=\"center\">检验项</td>" +
                                            "<td align=\"center\">单位</td>" +
                                            "<td align=\"center\">参考范围</td>" +
                                            "<td align=\"center\">结果</td>" +
                                            "<td align=\"center\">提示</td>" +
                                        "</tr>" +
                                    "</thead>" +
                                    "<tbody>" +
                                        events
                                    "</tbody>" +
                                "</table>" +
                            "</td>" +
                        "</tr>" +
                    "</tbody>" +
                "</table><hr/>";
        }
    });
    $("#jiancha").html(jiancha);
    $("#jiancha").after(jianyan);
    $.each(JSON.parse(resultInfo),function (i,n) {
        $($("textarea").get(0)).append(n.commonResults.resultDesc+"\n");
    });
    $.each(JSON.parse(commInfo),function (i,e) {
        if(e.commonResults.proposedDescription.adviceContent!=undefined){
            $($("textarea").get(1)).append(e.commonResults.proposedDescription.adviceContent+"\n");
        }
    });

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