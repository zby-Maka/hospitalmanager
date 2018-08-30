$(function () {
    showSectionAndCombinationAndCheck();

})

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
            console.log(data)
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
             html="<lable name='combiantionInfo' value='"+xiangid+"'>"+xiangname+"</lable><hr/>"
        }else if(checkorcom=="checkInfo"){
            html="<lable name='checkInfo' value='"+xiangid+"'>"+xiangname+"</lable><hr/>"
        }
        $("#checkcombinationAndcheck").append(html);
    }else{
        if(checkorcom=="combiantionInfo"){
            $("#checkcombinationAndcheck").children("input[name='"+checkorcom+"']").remove()
        }else if(checkorcom=="checkInfo"){
            $("#checkcombinationAndcheck").children("input[name='"+checkorcom+"']").remove()
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


for (var i=0;i<b; i++){
    combinationID[i]=$("lable[name='combiantionInfo']").attr("value");
}
    for (var i=0;i<a; i++){
        checkID[i]=$("lable[name='checkInfo']").attr("value");
    }
console.log(combinationID);
    console.log(checkID)


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



