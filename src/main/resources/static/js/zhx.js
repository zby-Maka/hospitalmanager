

$(function () {
    showcomandcheckinfo()
})


//查询组合项id查询下面的体检项信息
function showcomandcheckinfo() {
    $.ajax({
        url: "http://localhost:8080/getCombinationAndCheckInfo",
        type: "post",
        dataType: "json",
        data: {"combinationId":1},
        success: function (data) {
            var content = "";
            $.each(data, function (i, e) {
                content+="<tr><td><input type='checkbox' value='"+e.checkId+"'>"+e.checkName+"</td></tr>";
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

    $("input[type='checkbox']:checked").each(function(i){//把所有被选中的复选框的值存入数组
        checkID[i] =$(this).val();
    })

    var date = $.param({
        "comAncCheckList": checkID
    })+"&"+combination;

    $.ajax({
        url: "http://localhost:8080/addCombinationInfo",
        data:date,
        dataType: "json",
        type: "get",
        traditional:true,
        success: function (data) {
            if (data==1)
                alert("组合项表添加成功");
            else
                alert("添加失败")
        },
        error: function () {
            alert("发生错误");
        }
    })
}