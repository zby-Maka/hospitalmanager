$(function () {
    var combinationid = localStorage["comid"];

    if (combinationid != "null") {
        var sname = localStorage["secname"];
        var sid = localStorage["secid"];
        $("#sectionname").val(sname);
        $("input[name='sectionId']").val(sid);
        showcheckcheckbox(combinationid);
        getcombinationidByid(combinationid);
    }else{
        var sname = localStorage["secname"];
        var sid = localStorage["secid"];
        $("#sectionname").val(sname);
        $("input[name='sectionId']").val(sid);
        getCheckInfoBySectionId(sid);
    }
})



//添加修改判断
function addandupd() {
    var cmbid = $("#cmbid").val();
    $.ajax({
        url: "http://localhost:8080/getCombinationAndCheckInfo",
        type: "post",
        dataType: "json",
        data: {"combinationId": cmbid},
        success: function (data) {
            if (data.length==0) {
                addcom();
            }else{
                updcom();
            }
        }

    })
}


//修改绑定
function getcombinationidByid(combinaid) {
    $.ajax({
        url: "http://localhost:8080/getCombinationAndCheckInfo",
        type: "post",
        dataType: "json",
        data: {"combinationId": combinaid},
        success: function (data) {
            console.log(data)
            $.each(data, function (i, e) {
                if (e.isEnable == 1) {
                    $("input[name='isEnable']").eq(0).prop("checked",true);
                } else {
                    $("input[name='isEnable']").eq(1).prop("checked",true);
                }

                $("input[name='combinationName']").val(e.combinationName)
                $("input[name='combinationName']").attr("readonly",true)
                $("input[name='combinationId']").val(e.combinationId);
                $("#cmbid").val(e.combinationId);
                $("input[name='promptInformation']").val(e.promptInformation)
                $("input[name='promptInformation']").attr("readonly",true)
                $("input[name='resultToWay']").val(e.resultToWay)
                $("input[name='resultToWay']").attr("readonly",true)

                if (e.isSpecimen == 1) {
                    $("input[name='isSpecimen']").eq(0).prop("checked",true);
                } else {
                    $("input[name='isSpecimen']").eq(1).prop("checked", true);
                }
                $("input[name='isSpecimen']").attr("readonly",true)
                $("input[name='specimenType']").val(e.specimenType);
                $("input[name='specimenType']").attr("readonly",true)

            })
        }, error: function () {
            alert("发生错误")
        }
    })
}

//根据科室id查询体检项信息
function getCheckInfoBySectionId(secid) {

    $.ajax({
        url: "http://localhost:8080/getCheckInfoBySectionId",
        type: "post",
        dataType: "json",
        data: {"sectionId": secid},
        success: function (data) {
            console.log(data)
            var content = "";
            $.each(data, function (i, e) {
                content += "<tr><td><input type='checkbox' value='" + e.checkId + "'>" + e.checkName + "</td></tr>";
            })
            $("#content").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
}

//添加组合项信息
function addcom() {
    var combination = $("#addform").serialize();
    var checkID = [];//定义一个空数组

    $("input[type='checkbox']:checked").each(function (i) {//把所有被选中的复选框的值存入数组
        checkID[i] = $(this).val();
    })

    var date = $.param({
        "comAncCheckList": checkID
    }) + "&" + combination;

    $.ajax({
        url: "http://localhost:8080/addCombinationInfo",
        data: date,
        dataType: "json",
        type: "get",
        traditional: true,
        success: function (data) {
            if (data == 1){
                alert("添加成功");
                $("input[name='combinationName']").val("");
                $("input[name='promptInformation']").val("")
                $("input[name='resultToWay']").val("")
                $("input[name='specimenType']").val("");
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

//修改组合项信息
function updcom() {
    var combination = $("#addform").serialize();
    // var checkID = [];//定义一个空数组
    //
    // $("input[type='checkbox']:checked").each(function (i) {//把所有被选中的复选框的值存入数组
    //     checkID[i] = $(this).val();
    // })
    //
    // var date = $.param({
    //     "comAncCheckList": checkID
    // }) + "&" + combination;

    $.ajax({
        url: "http://localhost:8080/updCombinationInfo",
        data: combination,
        dataType: "json",
        type: "get",
        traditional: true,
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


//查询组合项id查询下面的体检项信息
function showcheckcheckbox(combid) {

    $.ajax({
        url: "http://localhost:8080/getCombinationAndCheckInfo",
        type: "post",
        dataType: "json",
        data: {"combinationId": combid},
        success: function (data) {
            var content = "";
            $.each(data, function (i, e) {
                content += "<tr><td><input type='checkbox' value='" + e.combinationCheckList[i].checkId + "'>" + e.combinationCheckList[i].checkName + "</td></tr>";
            })
            $("#content").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
}