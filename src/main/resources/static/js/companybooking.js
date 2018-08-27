//验证电话号
$("input[name='telephone']").on("blur", function() {
    var phone = $("input[name='telephone']").val();
    if(phone != "") {
        var checkResult = checkPhone(phone);
        if(!checkResult) {
            $("td[name='telephone']").text("请输入正确的电话号");
        } else {
            $("td[name='telephone']").text("");
        }
    } else {
        $("td[name='telephone']").text("");
    }
});
function checkPhone(telephone) {
    var reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
    if(!reg.exec(telephone)) {
        return false;
    }
    return true;
}
/*单位预约*/
/*点击公司名称的失焦事件*/
$("input[name=companyName]").blur(function () {
    //获取公司名称进行查询
    var companyName = $("input[name=companyName]").val();
    $.ajax({
        url:"/showCompanyInfo.do",
        data:{companyName:companyName},
        type:"get",
        success:function(data) {
            if(data != undefined){
                $("input[name=companyId]").val(data.companyId);
                $("input[name=companyPrincipal]").val(data.companyPrincipal);
                $("input[name=telephone]").val(data.telephone);
                $("input[name=address]").val(data.address);
                $("input[name=bankNumber]").val(data.bankNumber);
                $("input[name=companyNature]").val(data.companyNature);
                $("input[name=authorizedStrength]").val(data.authorizedStrength);
            }


        },
        dataType:"json"
    });

    //确定事件
    $("input[name=confirm]").click(function () {
        var companyId = $("input[name=companyId]").val();
        if(companyId > 0){
            //执行修改操作
            var content = $("#companyInfo").serialize();
            $.ajax({
                url:"/updCompanyInfo.do",
                data:content,
                type:"get",
                dataType:"json",
                success:function (data) {
                    if(data>0){
                        alert("操作成功");
                        $("input[name=companyId]").val("");
                        $("input[name=companyPrincipal]").val("");
                        $("input[name=telephone]").val("");
                        $("input[name=address]").val("");
                        $("input[name=bankNumber]").val("");
                        $("input[name=companyNature]").val("");
                        $("input[name=authorizedStrength]").val("");
                    }
                }
            });
        }else{
            var contents = $("#companyInfo").serialize();
            $.ajax({
                url: "/addCompanyInfo.do",
                data: contents,
                type: "get",
                dataType:"json",
                success: function (data) {
                    if (data > 0) {
                        alert("操作成功");
                        $("input[name=companyName]").val("");
                        $("input[name=companyId]").val("");
                        $("input[name=companyPrincipal]").val("");
                        $("input[name=telephone]").val("");
                        $("input[name=address]").val("");
                        $("input[name=bankNumber]").val("");
                        $("input[name=companyNature]").val("");
                        $("input[name=authorizedStrength]").val("");
                    }
                }

            });


        }

        if(companyId = undefined  ) {
        }
    });

});