var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
var packId = new Array();
var comId = new Array();
var checkId = new Array();
$(function() {
    //查询预约时间
    $.ajax({
        url:"/listDate.do",
        dataType:"json",
        success:function (res) {
            var divControl = document.getElementById("chooseDate").getElementsByTagName("div");
            $.each(res,function (i,e) {
                if(e.value>0){
                    var myDate = new Date(Date.parse(e.key.replace(/-/g, "/")));
                    divControl[i+1].innerHTML=weekDay[myDate.getDay()]+"\n"+"<lable>"+e.key+"</lable>";
                }else {
                    divControl[i+1].innerHTML="<lable>约满了</lable>";
                }
            })
        }
    })

    $("#chooseDate>div").not(":eq(0)").click(function () {
        var yue = $(this).find("lable").text();
        if(yue!="约满了"){
            makeAnAppointment(yue,packId,comId,checkId);
            EV_closeAlert();
            $("#chooseDate").hide();
        }else {
            alert("该日期约满了，请选择其他日期！");
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

        //获取所有选中的组合项Id
        var checkIdControl = document.getElementsByName('checkItem');
        for(var i = 0; i < checkIdControl.length; i++){
            if(checkIdControl[i].checked)
                checkId.push(checkIdControl[i].value);
        }
        if(packId.length==0&&comId.length==0&&checkId.length==0){
            alert("请选择体检项目！");
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
        location.href="/booking.html";
    });

	//查询所有体检项，组合项，套餐项
    selAllCheck();

	//获取体检项
	$(".tab_box").on("click","input[name='checkItem'],input[name='combineItem'],input[name='packageItem']",function() {
		var result = $(this).parent().text();
		//判断是否选中
		var check = $(this).prop("checked");
		if(check){
			var html="<span class='check' name='checkItem' id='"+result+"'>"+result+"</span>";
			$(".checked").append(html);
		}else{
			$(".checked").children("#"+result).remove();
		}
	});

	//浮动组合项时显示该项下边的体检项
    $("#com").on("mouseenter","td[name=c]",function () {
        var comId=$(this).find("span input").val();
        $.getJSON("/getComCheck.do",{"comId":comId},function (comCheck) {
            var checkCom = "<tr>";
            console.log(comCheck);
            $.each(comCheck,function (i,e) {
                checkCom+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>";
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
        $.getJSON("/getPackCheck.do",{"packId":packId},function (packCheck) {
            console.log(packCheck);
            var checkPack = "<tr>";
            $.each(packCheck.packageCombinationList,function (i,e) {
                checkPack+="<td style=\"font-weight: bolder; text-align: center;\">"+e.combinationName+"</td>";
                if ((i+1)%3==0){
                    checkPack+="</tr>";
                }
            })
            $.each(packCheck.packageCheckList,function (i,e) {
                checkPack+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>";
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
            url: "/UserReservation.do?" + date,
            date: {},
            dataType: "text",
            success: function (result) {
                alert(result);
                console.log(result);
                if (result == "ok") {
                    alert("预约成功！");
                    sessionStorage.setItem("personInfo",null);
                    checkId=[];
                    comId=[];
                    packId=[];
                    location.href="/booking.html";
                }
            }
        });
}

/**
 * 查询所有体检项，组合项，套餐项
 */
function selAllCheck() {
	//获取所有检查项
	$.getJSON("/ExhibitionAllCheck.do",{},function (check) {
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
    $.getJSON("/ExhibitionAllCombination.do",{},function (com) {
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
    $.getJSON("/ExhibitionAllPackages.do",{},function (package) {
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
//关闭预约时间弹框
function closeDate() {
    checkId=[];
    comId=[];
    packId=[];
    EV_closeAlert();
}
