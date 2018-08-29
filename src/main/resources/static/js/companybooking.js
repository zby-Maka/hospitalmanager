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
        url: "/showCompanyInfo.do",
        data: {companyName: companyName},
        type: "get",
        success: function (data) {
            if (data != undefined) {
                $("input[name=companyId]").val(data.companyId);
                $("input[name=companyPrincipal]").val(data.companyPrincipal);
                $("input[name=telephone]").val(data.telephone);
                $("input[name=address]").val(data.address);
                $("input[name=bankNumber]").val(data.bankNumber);
                $("input[name=companyNature]").val(data.companyNature);
                $("input[name=authorizedStrength]").val(data.authorizedStrength);
            }


        },
        dataType: "json"
    });
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
});

//上传按钮
$("input[name=upload]").click(function () {
    upload();
});

//绑定type=file的元素的onchange事件的处理函数
$(':file').change(
    function() {
        var file = this.files[0]; //假设file标签没打开multiple属性，那么只取第一个文件就行了
        name = file.name;
        size = file.size;
        type = file.type;
        url = window.URL.createObjectURL(file); //获取本地文件的url，如果是图片文件，可用于预览图片
        $(this).next().html(
            "文件名：" + name + " 文件类型：" + type + " 文件大小：" + size
            + " url: " + url);
        $("#info").html("总大小: " + size + "bytes");
    });
function upload() {
    var file=$("#file").val();
    var ext = file.slice(file.lastIndexOf(".")+1).toLowerCase();
    alert(ext);
    /*if(!/\.(xlsx|xls|XLSX|XLS)$/.test(ext)){*/
    if ("xls" != ext && "xlsx" != ext) {
        alert("只能上传Excle文件");
        return false;
    }
    else {
        //创建FormData对象，初始化为form表单中的数据。需要添加其他数据可使用formData.append("property", "value");
        //formData对象可以把所有表单元素的name和value组成一个String提交到后台，可以减少拼接数据的工作量
        var formData = new FormData($('#companyInfo')[0]);
        //ajax异步上传
        $.ajax({
            url: "/admin/import",
            type: "POST",
            data: formData,
            //因为upload属性是XMLHttpRequest的属性，所以，必须获取到请求中的XMLHttpRequest对象
            xhr: function () {
                //获取ajaxSettings中的xhr对象，为它的upload属性绑定progress事件的处理函数
                myXhr = $.ajaxSettings.xhr();
                if (myXhr.upload) { //检查upload属性是否存在
                    //绑定progress事件的回调函数
                    myXhr.upload.addEventListener('progress',
                        progressHandlingFunction, false);
                }
                return myXhr; //xhr对象返回给jQuery使用
            },
            success: function (result) {
                alert(result);
                if (result == 1) {
                    alert("上传成功");
                }
                if (result == 2) {
                    alert("文件上传格式不正确,请重新选择");
                }
                if (result == 3) {
                    alert("请重新核实文件数据");
                }
                //$("#result").html(result.data);
            },
            contentType: false, //必须false才会自动加上正确的Content-Type，当有文件要上传时，此项是必须的，否则后台无法识别文件流的起始位置，涉及到http协议，有兴趣的同学下去自己可以了解一下
            processData: false//必须false才会避开jQuery对 formdata 的默认处理  是否序列化data属性，默认true(注意：false时type必须是post）
        });
    }
}
//上传进度回调函数：
function progressHandlingFunction(e) {
    if (e.lengthComputable) {
        $('progress').attr({
            value : e.loaded,
            max : e.total
        }); //更新数据到进度条
        var percent = e.loaded / e.total * 100;
        $('#progress').html(
            e.loaded + "/" + e.total + " bytes. " + percent.toFixed(2)
            + "%");
    }

}