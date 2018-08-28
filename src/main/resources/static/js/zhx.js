

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
                content+="<tr><td><input type='radio' name='checkId' value='"+e.checkId+"'>"+e.checkName+"</td></tr>";
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
    var checkid=$("input[name='checkId']:checked").val();
    for(var i=0;i<checkid.length;i++){
        var arr=new Array();
        //console.log(arr);
        arr.push(1);
        arr.push(checkid);
    }

    $.ajax({
        url: "http://localhost:8080/addCombinationInfo",
        data:combination,combinationCheckList:arr,
        dataType: "json",
        type: "post",
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