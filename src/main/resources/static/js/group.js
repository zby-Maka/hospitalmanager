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
            alert(data);
            var content = "";
            $.each(data,function (i,e) {
                alert(i);
                content +=
                    "<td><input type='radio' name='packageId' value='"+e.packageId+"' />"+e.packageName+"</td>" ;
                if((i+1)%3 ==0){
                    alert("aaa");
                    content += "/n";
                }

            });
            $("#packageMes").html(content);
        }
    });
}