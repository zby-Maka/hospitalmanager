
//查询全部
function showdesk() {
    $.ajax({
        url: "getAllDeskinfo",
        type: "post",
        dataType: "json",
        data: {},
        success: function (data) {
            var content = "";
            $.each(data, function (i, e) {

            })
            $("#content").html(content);
        }, error: function () {
            alert("发生错误")
        }
    })
}



function addcheck() {
    var a = $("#addform").serialize();
    $.ajax({
        url: "http://localhost:8080/addCheckInfo",
        data: a,
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data==1)
                alert("添加成功");
            else
                alert("添加失败")
        },
        error: function () {
            alert("发生错误");
        }
    })
}