/*单位预约*/
/*点击公司名称的失焦事件*/
$("input[name=companyName]").blur(function () {
    //获取公司名称进行查询
    var companyName = $("input[name=companyName]").val();
    alert(companyName);
    $.ajax({
        url:"/showCompanyInfo.do",
        data:{companyName:companyName},
        type:"get",
        success:function(data) {
            alert(data);
            $("input[name=companyId]").val(data.companyId);

            $("input[name=companyPrincipal]").val(data.companyPrincipal);
            $("input[name=telephone]").val(data.telephone);
            $("input[name=address]").val(data.address);
            $("input[name=bankNumber]").val(data.bankNumber);
            $("input[name=companyNature]").val(data.companyNature);
            $("input[name=authorizedStrength]").val(data.authorizedStrength);

        },
        dataType:"json"
    });

    //确定事件
    $("input[name=confirm]").click(function () {
        alert("a");
        var companyId = $("input[name=companyId]").val();
        alert(companyId);
        if(companyId >0){
            //执行修改操作
            alert("修改");
        }
        if(companyId < 0 ){
            //执行添加操作
            alert("添加")
        }
    });

});