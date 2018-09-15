//验证电话号
$("input[name='telephone']").on("blur", function() {
    var phone = $("input[name='telephone']").val();
    if(phone != "") {
        var checkResult = checkPhone(phone);
        if(!checkResult) {
            $("td[name='checkTelephone']").text("电话号格式不正确");
        } else {
            $("td[name='checkTelephone']").text("");
        }
    } else {
        $("td[name='checkTelephone']").text("");
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
        url: "/hospitalOne/showCompanyInfo.do",
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
                $("input[name=bankName]").val(data.bankName);
            }


        },
        dataType: "json"
    });
});
var flag=true;
var choose = false;
    //确定事件
    $("input[name=confirm]").click(function () {

        var textControl = $("#companyInfo input");
        var companyId = $("input[name=companyId]").val();
        $.each(textControl,function (i,e) {
            if(e.type=="text" && e.value=="") {
                flag = false;
                swal("请完善公司信息！");
                return false;
            }
        });
        if($.trim($("#file").val())==''){
            flag = false;
            swal("请选择Excel文件");
            return false;
        }
        if(flag && choose){
            //确定禁用
            $("input[name=confirm]").attr({"disabled":"disabled"});
            if(companyId > 0){
                //执行修改操作
                var content = $("#companyInfo").serialize();
                $.ajax({
                    url:"/hospitalOne/updCompanyInfo.do",
                    data:content,
                    type:"get",
                    dataType:"json",
                    success:function (data) {
                        if(data>0){
                            swal({title:"修改成功！",
                                text:"已成功修改数据",
                                type:"success"},function(){
                                location.href ="/hospitalOne/booking.html" ;
                            });

                            /*$("input[name=companyName]").val("");
                            $("input[name=companyId]").val("");
                            $("input[name=companyPrincipal]").val("");
                            $("input[name=telephone]").val("");
                            $("input[name=address]").val("");
                            $("input[name=bankNumber]").val("");
                            $("input[name=companyNature]").val("");
                            $("input[name=authorizedStrength]").val("");
                            var file = $("#file") ;
                            file.after(file.clone().val(""));
                            file.remove();
                            $("input[name=spellCode]").val("");
                            $("input[name=bankName]").val("");*/
                        }
                    }
                });
            }else{
                var contents = $("#companyInfo").serialize();
                $.ajax({
                    url: "/hospitalOne/addCompanyInfo.do",
                    data: contents,
                    type: "get",
                    dataType:"json",
                    success: function (data) {
                        if (data > 0) {
                            swal({title:"添加成功！",
                                text:"已添加数据",
                                type:"success"},function(){
                                    location.href ="/hospitalOne/booking.html" ;
                            });

                            /* $("input[name=companyName]").val("");
                             $("input[name=companyId]").val("");
                             $("input[name=companyPrincipal]").val("");
                             $("input[name=telephone]").val("");
                             $("input[name=address]").val("");
                             $("input[name=bankNumber]").val("");
                             $("input[name=companyNature]").val("");
                             $("input[name=authorizedStrength]").val("");
                             var file = $("#file") ;
                             file.after(file.clone().val(""));
                             file.remove();
                             $("input[name=spellCode]").val("");
                             $("input[name=bankName]").val("");*/
                        }
                    }
                });
            }
        }else {
            swal("请将Excel文件上传");
        }

});
var ch = true;
//上传按钮
$("input[name=upload]").click(function () {
    var file=$("#file").val();
    var ext = file.slice(file.lastIndexOf(".")+1).toLowerCase();
    /*if(!/\.(xlsx|xls|XLSX|XLS)$/.test(ext)){*/
    if($.trim($("#file").val())==''){
        swal("请选择Excel文件");
        ch = false;
        return false;
    }
    if ("xls" != ext && "xlsx" != ext) {
        swal("只能上传Excle文件");
        ch = false;
        return false;
    }
    var textControl = $("#companyInfo input");
    $.each(textControl,function (i,e) {
        if(e.type=="text" && e.value=="") {
            ch = false;
            swal("请先完善公司信息！");
            return false;
        }
    });
    if(ch){
        //获取公司名称
        var companyName = $("input[name=companyName]").val();
        //获取上传文件的文件名称
        //           C:\fakepath\北大青鸟.xlsx
        var file=$("#file").val();
        var fileNames=file.substring(file.lastIndexOf("\\")+1,file.indexOf("."));
        if(companyName == fileNames){
            upload();
        }else{
            swal("文件名与公司名不匹配");
        }

    }
   /* */
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
    /*if(!/\.(xlsx|xls|XLSX|XLS)$/.test(ext)){*/
    if($.trim($("#file").val())==''){
        swal("请选择Excel文件");
        flag = false;
        return false;
    }
    if ("xls" != ext && "xlsx" != ext) {
        swal("只能上传Excle文件");
        flag = false;
        return false;
    }
    else {
        //创建FormData对象，初始化为form表单中的数据。需要添加其他数据可使用formData.append("property", "value");
        //formData对象可以把所有表单元素的name和value组成一个String提交到后台，可以减少拼接数据的工作量
        var formData = new FormData($('#companyInfo')[0]);
        //ajax异步上传
        $.ajax({
            url: "/hospitalOne/admin/import",
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
                if (result == 1) {
                    choose = true;
                    swal("上传成功");

                }
                if (result == 2) {
                    flag = false;
                    swal("文件上传格式不正确,请重新选择");
                }
                if (result == 3) {
                    flag = false;
                    swal("请重新核实文件数据");
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