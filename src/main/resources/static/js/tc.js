$(function () {
    showSectionAndCombinationAndCheck();
    var packid = localStorage["pid"];


    if (packid != "null") {
        getPackageAndCombinationInfo(packid);
        getPackageAndCheckInfo(packid)
    }


})
var oncheck = [];//已选择的项目数组

function updandadd() {
    var packid = localStorage["pid"];
    if (packid == "null") {
        add();
    } else {
        updpack();

    }
}


//根据套餐id查询套餐信息以及套餐下的组合项
function getPackageAndCombinationInfo(packaid) {
    $.ajax({
        url: "/hospitalOne/getPackageAndCombinationInfoById",
        type: "post",
        dataType: "json",
        data: {"packageId": packaid},
        success: function (data) {
            console.log(data)
            var content = "";
            $.each(data, function (i, e) {
                if (e.isEnable == 1) {
                    $("input[name='isEnable']").eq(0).prop("checked", true);
                } else {
                    $("input[name='isEnable']").eq(1).prop("checked", true);
                }
                $("input[name='packageName']").val(e.packageName);
                $("input[name='packageName']").attr("readonly", true)
                $("input[name='packageId']").val(e.packageId)
                $("#pacid").val(e.packageId);
                $("input[name='note']").val(e.note);
                $("textarea[name='scopeApplication']").val(e.scopeApplication);
                $("textarea[name='scopeApplication']").attr("readonly", true)
                $("a").removeAttr("onclick")
                $.each(e.packageCombinationList, function (o, r) {
                    content += "<lable name='combiantionInfo'  value='" + r.combinationId + "'>" + r.combinationName + "</lable><hr/>"
                })

            })
            $("#checkcombinationAndcheck").append(content);

        }, error: function () {
            alert("发生错误")
        }
    })
}

//根据套餐id查询套餐信息以及套餐下的体检项
function getPackageAndCheckInfo(packaid) {
    $.ajax({
        url: "/hospitalOne/getPackageAndCheckInfoById",
        type: "post",
        dataType: "json",
        data: {"packageId": packaid},
        success: function (data) {
            console.log(data)
            var content = "";
            $.each(data, function (i, e) {
                if (e.isEnable == 1) {
                    $("input[name='isEnable']").eq(0).prop("checked", true);
                } else {
                    $("input[name='isEnable']").eq(1).prop("checked", true);
                }
                $("input[name='packageName']").val(e.packageName);
                $("input[name='packageName']").attr("readonly", true)
                $("input[name='packageId']").val(e.packageId)
                $("#pacid").val(e.packageId);
                $("input[name='note']").val(e.note);
                $("input[name='note']").attr("readonly", true)
                $("textarea[name='scopeApplication']").val(e.scopeApplication);
                $("textarea[name='scopeApplication']").attr("readonly", true)
                $("a").removeAttr("onclick");
                $.each(e.packageCheckList, function (o, r) {
                    content += "<lable name='combiantionInfo'  value='" + r.checkId + "'>" + r.checkName + "</lable><hr/>"
                })

            })
            $("#checkcombinationAndcheck").append(content);
        }, error: function () {
            alert("发生错误")
        }
    })

}


//查询科室信息以及下的组合信息和体检信息
function showSectionAndCombinationAndCheck() {
    $.ajax({
        url: "/hospitalOne/getSecionAndCheckAndCombinationInfo",
        type: "post",
        dataType: "json",
        data: {},
        success: function (data) {
            console.log(data)
            var content = "";
            $.each(data, function (i, e) {
                content += "<a onclick='showSectionAndCombinationAndCheckByid(" + e.sectionId + ")' id='showxiang'>" + e.sectionName + "</a><hr/>";
            })
            $("#secionContent").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
}

//根据科室id查询科室信息以及下的组合项信息和体检项信息
function showSectionAndCombinationAndCheckByid(sectionid) {
    var flag = false;
    var flag1 = false;
    $.ajax({
        url: "/hospitalOne/getSecionAndCheckAndCombinationInfoById",
        type: "post",
        dataType: "json",
        data: {"sectionId": sectionid},
        success: function (data) {
            console.log(data)
            var content = "";
            $.each(data, function (i, e) {
                $.each(e.sectioandcombinationList, function (i, e1) {
                    flag = false;
                    for (var i = 0; i < oncheck.length; i++) {
                        if (oncheck[i][0] == e1.combinationId && oncheck[i][1] == e1.combinationName) {
                            if (e1.combinationName == undefined) {
                                content += "";
                            } else {
                                content += "<input name='combiantionInfo' type='checkbox' checked='checked' value='" + e1.combinationId + "'><span>" + e1.combinationName + "</span><hr/>";
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        if (e1.combinationName == undefined) {
                            content += "";
                        } else {
                            content += "<input name='combiantionInfo' type='checkbox' value='" + e1.combinationId + "'><span>" + e1.combinationName + "</span><hr/>";
                        }

                    }

                })
                $.each(e.sectionandcheckList, function (i, e2) {
                    flag1 = false;
                    for (var i = 0; i < oncheck.length; i++) {
                        if (oncheck[i][0] == e2.checkId && oncheck[i][1] == e2.checkName) {
                            if (e2.checkName == undefined) {
                                content += "";
                            } else {
                                content += "<input name='checkInfo' type='checkbox' checked='checked' value='" + e2.checkId + "'><span>" + e2.checkName + "</span><hr/>";
                            }
                            flag1 = true;
                            break;
                        }
                    }
                    if (flag1 == false) {
                        if (e2.checkName == undefined) {
                            content += "";
                        } else {
                            content += "<input name='checkInfo' type='checkbox' value='" + e2.checkId + "'><span>" + e2.checkName + "</span><hr/>";
                        }

                    }
                })
            })
            $("#combinationAndcheck").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
};


/**
 * 点击科室下的项添加到已选择
 */
$("#combinationAndcheck").on("click", "input[name='combiantionInfo'],input[name='checkInfo']", function () {
    var xiangid = $(this).val();//选中checkbox的id
    var xiangname = $(this).next().text();//选中checkbox的内容
    var check = $(this).prop("checked");//选中状态
    var checkorcom = $(this).attr("name");//选中checkbox的name属性的值
    if (check) {
        var html = "";
        if ($("lable[name='combiantionInfo']").val() == undefined && $("lable[name='checkInfo']").val() == undefined) {
            if (checkorcom == "combiantionInfo") {
                html = "<lable name='combiantionInfo' id='" + xiangname + "'  value='" + xiangid + "'>" + xiangname + "</lable><hr/>";
                var arr1 = [];
                arr1.push(xiangid);
                arr1.push(xiangname);
                oncheck.push(arr1);
            } else if (checkorcom == "checkInfo") {
                html = "<lable name='checkInfo' id='" + xiangname + "' value='" + xiangid + "'>" + xiangname + "</lable><hr/>";
                var arr1 = [];
                arr1.push(xiangid);
                arr1.push(xiangname);
                oncheck.push(arr1);
            }

        } else {
            if (checkorcom == "checkInfo") {
                var combinationID = [];//组合项id数组
                var checkID = [];//体检项id数组
                var a = $("#checkcombinationAndcheck > lable[name='checkInfo']").length;
                var b = $("#checkcombinationAndcheck > lable[name='combiantionInfo']").length;
                if (b != 0) {
                    for (var i = 0; i < b; i++) {//循环属于组合项的lable
                        combinationID[i] = $("lable[name='combiantionInfo']").eq(i).attr("value");
                    }
                    var boolean = false;
                    for (var i = 0; i < combinationID.length; i++) {
                        var count = 0;
                        $.ajax({
                            url: "/hospitalOne/getCombinationAndCheckInfo",
                            type: "post",
                            dataType: "json",
                            data: {"combinationId": combinationID[i]},
                            success: function (data) {
                                $.each(data[0].combinationCheckList, function (j, e) {
                                    if (e.checkId == xiangid) {
                                        alert("您已选择的组合项目中已包含该体检项");
                                        $("input[name='checkInfo'][value='"+xiangid+"']").prop("checked", false);
                                        boolean = true;
                                        return false;
                                    } else if (data[0].combinationCheckList.length == [j + 1]) {
                                        count++;
                                        if (count == combinationID.length) {
                                            html = "<lable name='checkInfo' id='" + xiangname + "' value='" + xiangid + "'>" + xiangname + "</lable><hr/>"
                                            $("#checkcombinationAndcheck").append(html);
                                            var arr1 = [];
                                            arr1.push(xiangid);
                                            arr1.push(xiangname);
                                            oncheck.push(arr1);
                                        }

                                    }
                                });
                            }
                        })
                        if (boolean == true) {
                            boolean == false;
                            break;
                        }
                    }
                } else {
                    if (checkorcom == "checkInfo") {
                        html = "<lable name='checkInfo' id='" + xiangname + "' value='" + xiangid + "'>" + xiangname + "</lable><hr/>"
                    }
                    var arr1 = [];
                    arr1.push(xiangid);
                    arr1.push(xiangname);
                    oncheck.push(arr1);

                }
            } else if (checkorcom == "combiantionInfo") {
                var combinationID = [];//组合项id数组
                var checkID = [];//体检项id数组
                var a = $("#checkcombinationAndcheck > lable[name='checkInfo']").length;
                var b = $("#checkcombinationAndcheck > lable[name='combiantionInfo']").length;
                if (a != 0) {
                    for (var i = 0; i < a; i++) {//循环属于体检项的lable
                        checkID[i] = $("lable[name='checkInfo']").eq(i).attr("value");
                    }
                    var boolean = false;

                        var count = 0;
                        $.ajax({
                            url: "/hospitalOne/getCombinationAndCheckInfo",
                            type: "post",
                            dataType: "json",
                            data: {"combinationId": xiangid},
                            success: function (data) {
                                $.each(data[0].combinationCheckList, function (c, e) {
                                    for (var j=0;j<checkID.length;j++){
                                        if (e.checkId == checkID[j]) {
                                            alert("您选择的组合项中已包含"+e.checkName+"项,请取消该体检项重新选择。");
                                            $("input[name='combiantionInfo'][value='"+xiangid+"']").prop("checked", false);
                                            boolean = true;
                                            return false;
                                        }else if(checkID.length==(j+1)){
                                            if(data[0].combinationCheckList.length==(c+1)){
                                                html = "<lable name='combiantionInfo' id='" + xiangname + "'  value='" + xiangid + "'>" + xiangname + "</lable><hr/>"
                                                $("#checkcombinationAndcheck").append(html);
                                                var arr1 = [];
                                                arr1.push(xiangid);
                                                arr1.push(xiangname);
                                                oncheck.push(arr1)
                                            }
                                        }
                                    }
                                })
                            }
                        })


                } else {
                    alert("您选择的组合项可能会有重复体检项,客户选择该套餐将会自动去除")
                    if (checkorcom == "combiantionInfo") {
                        html = "<lable name='combiantionInfo' id='" + xiangname + "'  value='" + xiangid + "'>" + xiangname + "</lable><hr/>"
                    }
                    var arr1 = [];
                    arr1.push(xiangid);
                    arr1.push(xiangname);
                    oncheck.push(arr1);
                }
            }
        }
        $("#checkcombinationAndcheck").append(html);
    } else {
        for (var i = 0; i < oncheck.length; i++) {
            if (xiangid == oncheck[i][0] && xiangname == oncheck[i][1]) {
                oncheck.splice(i, 1);
            }
        }
        if (checkorcom == "combiantionInfo") {
            $("#checkcombinationAndcheck").children("lable[id='" + xiangname + "']").remove()
        } else if (checkorcom == "checkInfo") {
            $("#checkcombinationAndcheck").children("lable[id='" + xiangname + "']").remove()
        }
    }

})


function add() {
    var textControl = $("#addform input");
    var name=$("input[name='packageName']").val();
    var flag = true;

    if(name==""){
        alert("请完善套餐信息")
    }else{
        addpack();
    }



}

//添加套餐信息
function addpack() {
    var combination = $("#addform").serialize();
    var combinationID = [];//组合项id数组
    var checkID = [];//体检项id数组
    var a = $("#checkcombinationAndcheck > lable[name='checkInfo']").length;
    var b = $("#checkcombinationAndcheck > lable[name='combiantionInfo']").length;
    for (var i = 0; i < b; i++) {//循环属于组合项的lable
        combinationID[i] = $("lable[name='combiantionInfo']").eq(i).attr("value");
    }
    for (var i = 0; i < a; i++) {//循环属于体检项的lable
        checkID[i] = $("lable[name='checkInfo']").eq(i).attr("value");
    }



/*
    if(combinationID.length==0){
        date = $.param({
            "sectionandcheckList": checkID,
        }) + "&" + combination;
    }else if(checkID.length==0){
        date = $.param({
            "sectionandcombinationList": combinationID,
        }) + "&" + combination;
    }else{
        date = $.param({
            "sectionandcheckList": checkID,
            "sectionandcombinationList": combinationID,
        }) + "&" + combination;
    }
    console.log(date);*/

    $.ajax({
        url: "/hospitalOne/addPackageInfo?checkList="+checkID+"&combinationList="+combinationID,
        data: combination,
        dataType: "json",
        type: "get",
        traditional: true,
        success: function (data) {
            if (data == 1) {
                alert("套餐添加成功");
                top.location="/hospitalOne/index.html";
                $("input[name='packageName']").val("");
                $("input[name='note']").val("")
                $("#checkcombinationAndcheck").html("");
                $("#combinationAndcheck").html("");
            }
            else {
                alert("添加失败")
            }

        },
        error: function () {
            alert("发生错误");
        }
    })
}

//修改套餐信息
function updpack() {
    var combination = $("#addform").serialize();
    $.ajax({
        url: "/hospitalOne/updPackageInfo",
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



