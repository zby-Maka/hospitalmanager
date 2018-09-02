$(function () {
    showSectionAndCombinationAndCheck();
    var packid=localStorage["pid"];




    if(packid!="null"){
        getPackageAndCombinationInfo(packid);
        getPackageAndCheckInfo(packid)
    }


    
})

function updandadd() {
    var packid=localStorage["pid"];
    if(packid=="null"){
        addpack();
    }else{
        updpack();

    }
}


//根据套餐id查询套餐信息以及套餐下的组合项目
function getPackageAndCombinationInfo(packaid) {
    $.ajax({
        url: "http://localhost:8080/getPackageAndCombinationInfoById",
        type: "post",
        dataType: "json",
        data: {"packageId":packaid},
        success: function (data) {
            console.log(data)
            var content="";
            $.each(data, function (i, e) {
                if (e.isEnable == 0) {
                    $("input[name='isEnable'],[value='0']").attr("checked", true);
                } else {
                    $("input[name='isEnable'],[value='1']").attr("checked", true);
                }
                $("input[name='packageName']").val(e.packageName);
                $("input[name='packageName']").attr("readonly",true)
                $("input[name='packageId']").val(e.packageId)
                $("#pacid").val(e.packageId);
                $("input[name='note']").val(e.note);
                $("textarea[name='scopeApplication']").val(e.scopeApplication);
                $("textarea[name='scopeApplication']").attr("readonly",true)

                content+="<lable name='combiantionInfo'  value='"+e.packageCombinationList[i].combinationId+"'>"+e.packageCombinationList[i].combinationName+"</lable><hr/>"
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
        url: "http://localhost:8080/getPackageAndCheckInfoById",
        type: "post",
        dataType: "json",
        data: {"packageId":packaid},
        success: function (data) {
            console.log(data)
            var content="";
            $.each(data, function (i, e) {
                if (e.isEnable == 0) {
                    $("input[name='isEnable'],[value='0']").attr("checked", true);
                } else {
                    $("input[name='isEnable'],[value='1']").attr("checked", true);
                }
                $("input[name='packageName']").val(e.packageName);
                $("input[name='packageName']").attr("readonly",true)
                $("input[name='packageId']").val(e.packageId)
                $("#pacid").val(e.packageId);
                $("input[name='note']").val(e.note);
                $("input[name='note']").attr("readonly",true)
                $("textarea[name='scopeApplication']").val(e.scopeApplication);
                $("textarea[name='scopeApplication']").attr("readonly",true)
                content+="<lable name='combiantionInfo'  value='"+e.packageCheckList[i].checkId+"'>"+e.packageCheckList[i].checkName+"</lable><hr/>"
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
        url: "http://localhost:8080/getSecionAndCheckAndCombinationInfo",
        type: "post",
        dataType: "json",
        data: {},
        success: function (data) {
            var content = "";
            $.each(data, function (i, e) {
                content+="<a onclick='showSectionAndCombinationAndCheckByid("+e.sectionId+")'>"+e.sectionName+"</a><hr/>";
            })
            $("#secionContent").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
}

//根据id查询科室信息以及下的组合信息和体检信息
function showSectionAndCombinationAndCheckByid(sectionid) {
    $.ajax({
        url: "http://localhost:8080/getSecionAndCheckAndCombinationInfoById",
        type: "post",
        dataType: "json",
        data: {"sectionId":sectionid},
        success: function (data) {
            var content = "";
            $.each(data, function (i, e) {
                $.each(e.sectioandcombinationList,function (i,e1) {
                    content+="<input name='combiantionInfo' type='checkbox' value='"+e1.combinationId+"'><span>"+e1.combinationName+"</span><hr/>";
                })
                $.each(e.sectionandcheckList,function (i,e2) {
                    content+="<input name='checkInfo' type='checkbox' value='"+e2.checkId+"'><span>"+e2.checkName+"</span><hr/>";
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
$("#combinationAndcheck").on("click","input[name='combiantionInfo'],input[name='checkInfo']",function () {
    var xiangid = $(this).val();//选中checkbox的id
    var xiangname = $(this).next().text();//选中checkbox的内容
    var check=$(this).prop("checked");//选中状态
    var checkorcom=$(this).attr("name");//选中checkbox的name属性的值
    if(check){
        var html="";
        if(checkorcom=="combiantionInfo"){
             html="<lable name='combiantionInfo'  value='"+xiangid+"'>"+xiangname+"</lable><hr/>"
        }else if(checkorcom=="checkInfo"){
            html="<lable name='checkInfo' value='"+xiangid+"'>"+xiangname+"</lable><hr/>"
        }
        $("#checkcombinationAndcheck").append(html);
    }else{
        if(checkorcom=="combiantionInfo"){
            $("#checkcombinationAndcheck").children("lable[name='"+checkorcom+"']").remove()
           var aa= $("#checkcombinationAndcheck").children("lable[name='"+checkorcom+"']").next().html();
        }else if(checkorcom=="checkInfo"){
            $("#checkcombinationAndcheck").children("lable[name='"+checkorcom+"']").remove()
            $("#checkcombinationAndcheck").children("lable[name='"+checkorcom+"']").next().remove()
        }

    }

})

//添加套餐信息
function addpack() {
    var combination = $("#addform").serialize();
    var combinationID = [];//组合项id数组
    var checkID = [];//体检项id数组
    var a=$("#checkcombinationAndcheck > lable[name='checkInfo']").length;
    var b=$("#checkcombinationAndcheck > lable[name='combiantionInfo']").length;
    for (var i=0;i<b; i++){//循环属于组合项的lable
        combinationID[i]=$("lable[name='combiantionInfo']").attr("value");
    }
    for (var i=0;i<a; i++){//循环属于体检项的lable
        checkID[i]=$("lable[name='checkInfo']").attr("value");
    }
    var date = $.param({
        "sectionandcheckList": checkID,
        "sectionandcombinationList":combinationID,
    })+"&"+combination;

    $.ajax({
        url: "http://localhost:8080/addPackageInfo",
        data:date,
        dataType: "json",
        type: "get",
        traditional:true,
        success: function (data) {
            if (data==1)
                alert("套餐表添加成功");
            else
                alert("添加失败")
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
        url: "http://localhost:8080/updPackageInfo",
        data:combination,
        dataType: "json",
        type: "get",
        traditional:true,
        success: function (data) {
            if (data==1)
                alert("修改成功");
            else
                alert("修改失败")
        },
        error: function () {
            alert("发生错误");
        }
    })
}



