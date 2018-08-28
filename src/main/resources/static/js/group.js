//单位分组js
$(function () {
    showPackage();
});
//显示所有套餐信息
function showPackage() {
    $.ajax({
        url: "/showPackage.do",
        data: {},
        type: "get",
        dataType: "json",
        success: function (data) {
            var content = "<tr>";
            $.each(data,function (i,e) {
                content +=
                    "<td><input type='radio' name='packageId' value='"+e.packageId+"' />"+e.packageName+"</td>" ;
                if((i+1)%3 ==0){
                    content += "</tr><tr>";
                }

            });
            $("#packageMes").html(content);
        }
    });
}