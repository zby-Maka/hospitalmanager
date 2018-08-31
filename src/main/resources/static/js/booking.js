$(function () {
    assignmentPersonInfo();

    //下一步按钮
    $("input[name=next]").click(function () {
        var flag=true;
        var textControl = $("#personal input");
        $.each(textControl,function (i,e) {
            if(e.type=="text" && e.value=="") {
                flag = false;
                alert("请完善用户信息！");
                return false;
            }
        })
        if (flag) {
            var params = $("#personal").serializeObject();
            sessionStorage.setItem("personInfo",JSON.stringify(params));
            sessionStorage.setItem("personInfoSer",$("#personal").serialize());
            location.href = "/check.html";
        }
    });


});

/**
 * 根据身份证号查询人员信息
 */
function assignmentPersonInfo() {
    var persionInfo = sessionStorage.getItem("personInfo");
    var persion = JSON.parse(persionInfo);
    if (persion!=null) {
        console.log(persion);
        $("input[name=personName]").val(persion.personName);
        $("input[name=personNameSpellCode]").val(persion.personNameSpellCode);
        $("input[name=personIdCard]").val(persion.personIdCard);
        $("input[name=personAge]").val(persion.personAge);
        $("input[name=personBirthday]").val(persion.personBirthday);
        $("input[name=personSex]").val(persion.personSex);
        var isMarry=$("input[name=isMarry]");
        if("未婚"==persion.isMarry)
            $(isMarry[0]).prop("checked",true);
        else if("已婚"==persion.isMarry)
            $(isMarry[1]).prop("checked",true);
        $("input[name=personTelephone]").val(persion.personTelephone);
        $("input[name=personAddress]").val(persion.personAddress);
    }
}

/**
 * 用户点击上一步时赋值
 */
function assignmentPersonInfo() {
    var persionInfo = sessionStorage.getItem("personInfo");
    var persion = JSON.parse(persionInfo);
    if (persion!=null) {
        console.log(persion);
        $("input[name=personName]").val(persion.personName);
        $("input[name=personNameSpellCode]").val(persion.personNameSpellCode);
        $("input[name=personIdCard]").val(persion.personIdCard);
        $("input[name=personAge]").val(persion.personAge);
        $("input[name=personBirthday]").val(persion.personBirthday);
        $("input[name=personSex]").val(persion.personSex);
        var isMarry=$("input[name=isMarry]");
        if("未婚"==persion.isMarry)
            $(isMarry[0]).prop("checked",true);
        else if("已婚"==persion.isMarry)
            $(isMarry[1]).prop("checked",true);
        $("input[name=personTelephone]").val(persion.personTelephone);
        $("input[name=personAddress]").val(persion.personAddress);
    }
}

/**
 * 将表单序列化为JSON对象
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}