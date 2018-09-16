var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
var packId = new Array();
var comId = new Array();
var checkId = new Array();
$(function() {
    //查询预约时间
    $.ajax({
        url:"/hospitalOne/listDate.do",
        dataType:"json",
        success:function (res) {
            var index = 1;
            var divControl = document.getElementById("chooseDate").getElementsByTagName("div");
            $.each(res,function (i,e) {
                var myDate = new Date(Date.parse(e.key.replace(/-/g, "/")));
                var week = weekDay[myDate.getDay()];
                if(week!="星期六"&&week!="星期天"){
                    if(e.value>0){
                        divControl[index].innerHTML=week+"\n"+"<lable>"+e.key+"</lable>";
                    }else {
                        divControl[index].innerHTML="<lable>约满了</lable>";
                    }
                    index++;
                }
            })
        }
    })

    $("#chooseDate>div").not(":eq(0)").click(function () {
        var yue = $(this).find("lable").text();
        if(yue!="约满了"){
            EV_closeAlert();
            $("#chooseDate").hide();
            makeAnAppointment(yue,packId,comId,checkId);
        }else {
            swal("该日期约满了，请选择其他日期！");
        }
    });

    //点击预约选择时间
    $("input[name='submit']").click(function(){
        //获取所有选中的套餐项Id
        var packIdControl = document.getElementsByName('packageItem');
        for(var i = 0; i < packIdControl.length; i++){
            if(packIdControl[i].checked)
                packId.push(packIdControl[i].value);
        }

        //获取所有选中的组合项Id
        var comIdControl = document.getElementsByName('combineItem');
        for(var i = 0; i < comIdControl.length; i++){
            if(comIdControl[i].checked)
                comId.push(comIdControl[i].value);
        }

        //获取所有选中的体检项Id
        var checkIdControl = document.getElementsByName('checkItem');
        for(var i = 0; i < checkIdControl.length; i++){
            if(checkIdControl[i].checked)
                checkId.push(checkIdControl[i].value);
        }
        if(packId.length==0&&comId.length==0&&checkId.length==0){
            swal("请选择体检项目！");
        }else {
            EV_modeAlert('chooseDate');
            //$("#chooseDate").show();
        }
    });

	//选项卡设计交互
	$(function() {
		var li_a = $(".tab_menu ul li a");
		li_a.click(function() {
			$(this).addClass("selected");
			$(this).parent().siblings().children().removeClass("selected");
			var index = li_a.index(this);
			$(".tab_box > div").eq(index).show().siblings().hide();
		});
	});

    //上一步按钮
    $("input[name=back]").click(function () {
        location.href="/hospitalOne/booking.html";
    });

	//查询所有体检项，组合项，套餐项
    selAllCheck();

	//浮动组合项时显示该项下边的体检项
    $("#com").on("mouseenter","td[name=c]",function () {
        var comId=$(this).find("span input").val();
        $.getJSON("/hospitalOne/getComCheck.do",{"comId":comId},function (comCheck) {
            var checkCom = "<tr>";
            $.each(comCheck,function (i,e) {
                checkCom+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>&nbsp;&nbsp;";
                if ((i+1)%4==0){
                    checkCom+="</tr>";
                }
            })
            $(".childBox").html(checkCom);
            $(".childBox").show();
        })
    })

    //浮动套餐时显示该项下边的体检项
    $("#package").on("mouseenter","td[name=p]",function () {
        var packId=$(this).find("span input").val();
        $.getJSON("/hospitalOne/getPackCheck.do",{"packId":packId},function (packCheck) {
            var checkPack = "<tr>";
            $.each(packCheck.packageCombinationList,function (i,e) {
                checkPack+="<td style=\"font-weight: bolder; text-align: center;\">"+e.combinationName+"</td>&nbsp;&nbsp;";
                if ((i+1)%3==0){
                    checkPack+="</tr>";
                }
            })
            $.each(packCheck.packageCheckList,function (i,e) {
                checkPack+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>&nbsp;&nbsp;";
                if ((i+1)%3==0){
                    checkPack+="</tr>";
                }
            })
            $(".childBox").html(checkPack);
            $(".childBox").show();
        })
    })

    //移出事件
	$(".tab_box").on("mouseleave ","td[name=t],td[name=p],td[name=c]",function(){
        $(".childBox").html("");
        $(".childBox").hide();
	});

    //选中体检时，去重，并给已选项赋值
    $("#check").on("change","input[name=checkItem]",function () {
        var result = $(this).parent().text();
        if($(this).is(':checked')){
            var html="<span class='check' name='checkItem' id='c"+$(this).val()+"'>"+result+"</span>";
            $(".checked").append(html);
            CheckDuplicateRemoval(this,$(this).val());
        }else{
            $(".checked").children("#c"+$(this).val()).remove();
        }
    });

    //选中组合项时，去重，并给已选项赋值
    $("#com").on("change","input[name=combineItem]",function () {
        var result = $(this).parent().text();
        if($(this).is(':checked')){
            var html="<span class='check' name='combineItem' id='com"+$(this).val()+"'>"+result+"</span>";
            $(".checked").append(html);
            ComDuplicateRemoval($(this).val());
        }else{
            $(".checked").children("#com"+$(this).val()).remove();
        }
    });

    //选中套餐时，去重，并给已选项赋值
    $("#package").on("change","input[name=packageItem]",function () {
        var result = $(this).parent().text();
        if($(this).is(':checked')){
            var html="<span class='check' name='packageItem' id='p"+$(this).val()+"'>"+result+"</span>";
            $(".checked").append(html);
            PackDuplicateRemoval($(this).val());
        }else{
            $(".checked").children("#p"+$(this).val()).remove();
        }
    });

    //获取体检项
    // $(".tab_box").on("click","input[name='combineItem'],input[name='packageItem']",function() {
    //     var result = $(this).parent().text();
    //     //判断是否选中
    //     var check = $(this).prop("checked");
    //     if(check){
    //         var html="<span class='check' name='checkItem' id='"+result+"'>"+result+"</span>";
    //         $(".checked").append(html);
    //     }else{
    //         $(".checked").children("#"+result).remove();
    //     }
    // });
});




/**
 * 预约
 */
function makeAnAppointment(yue,packId,comId,checkId) {
        //用户预约
        var persionInfo = sessionStorage.getItem("personInfoSer");
        var date = $.param({
            "yue": yue,
            "packId": packId,
            "comId": comId,
            "checkId": checkId
        }) + "&" + persionInfo;

        $.ajax({
            type: "get",
            url: "/hospitalOne/UserReservation.do?" + date,
            date: {},
            dataType: "text",
            beforeSend:function(){
                    //弹出等待遮罩层
                    EV_modeAlert("loding");
            },
            success: function (result) {
                if (result == "ok") {
                    EV_closeAlert();//关闭等待遮罩层
                    $("#loding").hide();
                    swal({title:"预约成功",
                        type:"success"},function(){
                        sessionStorage.setItem("personInfo",null);
                        checkId=[];
                        comId=[];
                        packId=[];
                        location.href="/hospitalOne/booking.html";
                    })
                }
            }
        });
}
var personSex = sessionStorage.getItem("personSex");
/**
 * 查询所有体检项，组合项，套餐项
 */
function selAllCheck() {
	//获取所有检查项
	$.getJSON("/hospitalOne/getCheckListBySex.do",{sex:personSex},function (check) {
		var content = "<tr>";
		$.each(check,function (i,e) {
            content+="<td style='width: auto'><span style='text-align: center;margin-left: 15px;' name=\"t\"><input type=\"checkbox\" id='c"+i+"' name=\"checkItem\" value=\""+e.checkId+"\" /><label for='c"+i+"'>"+e.checkName+"</label></span></td>";
            if((i+1)%3==0){
                content+="</tr>";
            }
        });
		$("#check").html(content);
    });

	//获取是所有组合项
    $.getJSON("/hospitalOne/ExhibitionAllCombination.do",{},function (com) {
        var content = "<tr>";
        $.each(com,function (i,e) {
            content+="<td style='width: auto' name='c'><span style='text-align: center;margin-left: 15px;'><input type=\"checkbox\" id='com"+i+"' name=\"combineItem\" value=\""+e.combinationId+"\" /><label for='com"+i+"'>"+e.combinationName+"</label></span></td>";
            if((i+1)%3==0){
                content+="</tr>";
            }
        });
        $("#com").html(content);
    });

	//获取所有套餐项
    $.getJSON("/hospitalOne/ExhibitionAllPackages.do",{},function (package) {
        var packageContent = "";
        var content = "<tr>";
        $.each(package,function (i,e) {
            content+="<td style='width: auto' name='p'><span style='text-align: center;margin-left: 15px;'><input id='pack"+i+"' type=\"checkbox\" name=\"packageItem\" value=\""+e.packageId+"\"/><label for='pack"+i+"'>"+e.packageName+"</label></span></td>";
            if((i+1)%3==0){
                content +="</tr>";
            }
        });
        $("#package").html(content);
    })
}

//选中套餐项时，去重，并给已选项赋值
function PackDuplicateRemoval(pid) {
    var ZuId = new Array();
    var checkIdControl = document.getElementsByName('checkItem');
    for(var i = 0; i < checkIdControl.length; i++){
        if(checkIdControl[i].checked)
            ZuId.push(checkIdControl[i]);
    }
    if(ZuId.length!=0){
        //获取所有选中的组合项下的体检项
        $.getJSON("/hospitalOne/getPackCheck.do",{"packId":pid},function (pack) {
            console.log(pack);
            var checkName = "";
            $.each(ZuId,function (i,checkIdControl) {
                $.each(pack.packageCheckList,function (i,e) {
                    if(e.checkId == checkIdControl.value){
                        checkName+="【"+e.checkName+"】";
                        checkIdControl.checked=false;
                        $(".checked").children("#c"+e.checkId).remove();
                    }
                })
                $.each(pack.packageCombinationList,function (i,e){
                    $.each(e.combinationCheckList,function (i,c) {
                        if(c.checkId == checkIdControl.value){
                            checkName+="【"+c.checkName+"】";
                            checkIdControl.checked=false;
                            $(".checked").children("#c"+c.checkId).remove();
                        }
                    })
                })
            });
            if(checkName!="")
                swal("小贴士","您所选的"+checkName+"已包含在您所选的【"+pack.packageName+"】套餐中,我们自动帮您去除哦");
                //swal("您所选的"+checkName+"已包含在您所选的【"+pack.packageName+"】套餐中,我们自动帮您去除哦");
        })
    }
}

//选中组合项时，去重，并给已选项赋值
function ComDuplicateRemoval(comId) {
    var ZuId = new Array();
    var checkIdControl = document.getElementsByName('checkItem');
    for(var i = 0; i < checkIdControl.length; i++){
        if(checkIdControl[i].checked)
            ZuId.push(checkIdControl[i]);
    }
    if(ZuId.length!=0){
        //获取所有选中的组合项下的体检项
        $.getJSON("/hospitalOne/getCheckByCombinationId.do",{"combinationId":comId},function (combination) {
            console.log(combination);
            var checkName = "";
            $.each(combination.combinationCheckList,function (i,e) {
                $.each(ZuId,function (i,checkIdControl) {
                    if(e.checkId == checkIdControl.value){
                        checkName+="【"+e.checkName+"】";
                        checkIdControl.checked=false;
                        $(".checked").children("#c"+e.checkId).remove();
                    }
                });
            })
            if(checkName!="")
                swal("小贴士","您所选的"+checkName+"已包含在您所选的【"+combination.combinationName+"】组合项中,我们自动帮您去除哦");
        })
    }
}

//体检项去重
function CheckDuplicateRemoval(that,checkId) {
    //所有选中组合项Id
    var ZuId = new Array();
    //所有选中套餐的Id
    var TaoId = new Array();
    //获取所有选中的组合项Id
    var comIdControl = document.getElementsByName('combineItem');
    for(var i = 0; i < comIdControl.length; i++){
        if(comIdControl[i].checked)
            ZuId.push(comIdControl[i].value);
    }
    if(ZuId.length!=0){
        //获取所有选中的组合项下的体检项
        $.getJSON("/hospitalOne/getCheckByComArrayId.do",{"combinationId":ZuId},function (ZuAllCheck) {
            console.log(ZuAllCheck);
            $.each(ZuAllCheck,function (i,e) {
                $.each(e.combinationCheckList,function (ic,c) {
                    if(c.checkId == checkId){
                        swal("小贴士","您所选的【"+c.checkName+"】已包含在您所选的【"+e.combinationName+"】组合项中");
                        $(that).prop("checked",false);
                        $(".checked").children("#c"+checkId).remove();
                        return;
                    }
                })
            })
        })
    }else{
        //获取所有选中的套餐项Id
        var packIdControl = document.getElementsByName('packageItem');
        for(var i = 0; i < packIdControl.length; i++){
            if(packIdControl[i].checked)
                TaoId.push(packIdControl[i].value);
        }
        if(TaoId.length!=0){
            $.getJSON("/hospitalOne/getPackCheckbyPackArray.do",{"packId":TaoId},function (TaoAllCheck) {
                var alertFlag = true;
                console.log(TaoAllCheck);
                $.each(TaoAllCheck,function (i,e) {
                    $.each(e.packageCheckList,function (ic,c) {
                        if(c.checkId == checkId&&alertFlag){
                            swal("小贴士","您所选的【"+c.checkName+"】已包含在您所选的【"+e.packageName+"】套餐中");
                            $(that).prop("checked",false);
                            $(".checked").children("#c"+checkId).remove();
                            alertFlag=false;
                            return;
                        }
                    })
                    $.each(e.packageCombinationList,function (im,m) {
                        $.each(m.combinationCheckList,function (imc,mc) {
                            if(mc.checkId == checkId&&alertFlag){
                                swal("小贴士","您所选的【"+mc.checkName+"】已包含在您所选的【"+e.packageName+"】套餐中");
                                $(that).prop("checked",false);
                                $(".checked").children("#c"+checkId).remove();
                                alertFlag=false;
                                return;
                            }
                        })
                    })
                })
            })
        }
    }
}

//关闭预约时间弹框
function closeDate() {
    checkId=[];
    comId=[];
    packId=[];
    EV_closeAlert();
}
