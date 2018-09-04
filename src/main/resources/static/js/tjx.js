$(function () {

    //根据体检项名称获取姓名简拼
    $("input[name='checkName']").on("keyup keydown change blur", function() {
        $("input[name='checkSpellCode']").val($(this).toPinyin());
    });

    var checkid = localStorage["cid"];

    if (checkid != "null") {
        var sname = localStorage["secname"];
        var sid = localStorage["secid"];
        var tyid=localStorage["tid"];
        $("#sectionname").val(sname);
        $("input[name='sectionId']").val(sid);
        showCheckById(checkid);
        var getresult="<input type='button' value='查看结果'  onclick='goresult("+checkid+")'>"
        if(tyid!=1){
        }else{
            $("input[type='reset']").after(getresult)
        }


    } else {
        var sname = localStorage["secname"];
        var sid = localStorage["secid"];
        $("#sectionname").val(sname);
        $("input[name='sectionId']").val(sid);
    }

})

//添加修改判断
function addandupd() {
    var cid = $("#ckid").val();
    $.ajax({
        url: "http://localhost:8080/getCheckInfoById",
        type: "post",
        dataType: "json",
        data: {"checkId": cid},
        success: function (data) {
            if (data.length==0) {
                add();
            }else{
                updcheck();
            }
        }

    })
}


//根据id查询体检项信息
function showCheckById(checkid) {
    $.ajax({
        url: "http://localhost:8080/getCheckInfoById",
        type: "post",
        dataType: "json",
        data: {"checkId": checkid},
        success: function (data) {
            console.log(data)
            $.each(data, function (i, e) {

                if (e.isEnable == 1) {
                    $("input[name='isEnable']").eq(0).prop("checked",true);
                } else {
                    $("input[name='isEnable']").eq(1).prop("checked", true);
                }
                $("input[name='checkName']").val(e.checkName)
                $("input[name='checkName']").attr("readonly",true);

                $("input[name='checkId']").val(e.checkId)
                $("#ckid").val(e.checkId);
                $("input[name='checkSpellCode']").val(e.checkSpellCode);
                $("input[name='checkSpellCode']").attr("readonly",true);

                if (e.termSex == "男") {
                    $("input[name='termSex']").eq(0).prop("checked", true);
                } else if(e.termSex == "女") {
                    $("input[name='termSex']").eq(1).prop("checked", true);
                }else{
                    $("input[name='termSex']").eq(2).prop("checked", true);
                }
                $("input[name='termSex']").attr("readonly",true);

                $("input[name='checkPrice']").val(e.checkPrice);
                $("input[name='checkPrice']").attr("readonly",true);

                $("input[name='checkAddress']").val(e.checkAddress);
                $("input[name='checkAddress']").attr("readonly",true);

                $("input[name='referenceCeil']").val(e.referenceCeil);
                $("input[name='referenceCeil']").attr("readonly",true);

                $("input[name='referenceFloor']").val(e.referenceFloor);
                $("input[name='referenceFloor']").attr("readonly",true);

                $("input[name='maxValue']").val(e.maxValue);
                $("input[name='maxValue']").attr("readonly",true);

                $("input[name='minValue']").val(e.minValue);
                $("input[name='minValue']").attr("readonly",true);

                $("input[name='promptHigh']").val(e.promptHigh);
                $("input[name='promptHigh']").attr("readonly",true);

                $("input[name='promptFlat']").val(e.promptFlat);
                $("input[name='promptFlat']").attr("readonly",true);

                $("textarea[name='remark']").val(e.remark);
                $("textarea[name='remark']").attr("readonly",true);

            })

        }, error: function () {
            alert("发生错误")
        }
    })
}
function add() {

    var textControl = $("#addform input");
    var text=$("textarea[name='remark']").val();
    var flag=true;
    if(flag==true){
        if(text.trim()==""){
        $.each(textControl,function (i,e) {
            if(e.type=="text" && e.value=="") {
                    flag = false;
                    alert("请完善体检项目信息！");
                    return false;
            }
        })
        }
    }else{
        addcheck();
    }

}

//添加体检项
function addcheck() {
    var a = $("#addform").serialize();
    $.ajax({
        url: "http://localhost:8080/addCheckInfo",
        data: a,
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data == 1){
                alert("添加成功");
                $("input[name='checkName']").val("");
                $("input[name='checkSpellCode']").val("");
                $("input[name='checkPrice']").val("");
                $("input[name='checkAddress']").val("");
                $("input[name='referenceCeil']").val("");
                $("input[name='referenceFloor']").val("");
                $("input[name='maxValue']").val("");
                $("input[name='minValue']").val("");
                $("input[name='promptHigh']").val("");
                $("input[name='promptFlat']").val("");
                $("textarea[name='remark']").val("");
            }
            else{
                alert("添加失败")
            }

        },
        error: function () {
            alert("发生错误");
        }
    })
}


//修改体检项
function updcheck() {
    var a = $("#addform").serialize();
    $.ajax({
        url: "http://localhost:8080/updCheckInfo",
        data: a,
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data == 1)
                alert("修改成功");
            else
                alert("修改失败")
        },
        error: function () {
            alert("发生错误");
        }
    })
}
function goresult(chkid) {
    sessionStorage.setItem("checkId",chkid);
    window.location.href="http://localhost:8080/Thebackend-page/jieguojianyi.html";
    //   $("#rightMain").attr("src", "/Thebackend-page/jieguojianyi.html");
}