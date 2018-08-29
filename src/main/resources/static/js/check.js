var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
$(function() {
    //查询预约时间
    $.ajax({
        url:"/listDate",
        dataType:"json",
        success:function (res) {
            var divControl = document.getElementById("chooseDate").getElementsByTagName("div");
            $.each(res,function (i,e) {
                if(e.value>0){
                    var myDate = new Date(Date.parse(e.key.replace(/-/g, "/")));
                    divControl[i+1].innerHTML=weekDay[myDate.getDay()]+"\n"+"<lable>"+e.key+"</lable>";
                }else {
                    divControl[i+1].innerHTML="约满了";
                }
            })
        }
    })

    var packId = new Array();
    var comId = new Array();
    var checkId = new Array();

    $("#chooseDate>div").not(":eq(0)").click(function () {
        makeAnAppointment($(this).find("lable").text(),packId,comId,checkId);
        $("#chooseDate").hide();
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
            $("#chooseDate").show();
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
        var comId=$(this).children("input").val();
        $.getJSON("/getComCheck",{"comId":comId},function (comCheck) {
            var checkCom = "<table><tr>";
            console.log(comCheck);
            $.each(comCheck,function (i,e) {
                checkCom+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>";
            })
            checkCom+="</tr></table>";
            $(".childBox").html(checkCom);
            $(".childBox").show();
        })
    })

    //浮动套餐时显示该项下边的体检项
    $("#package").on("mouseenter","td[name=p]",function () {
        var packId=$(this).children("input").val();
        var checkPack = "";
        $.getJSON("/getPackCheck",{"packId":packId},function (packCheck) {
            console.log(packCheck);
            // $.each(packCheck,function (i,e) {
            //     checkPack+="<td style=\"font-weight: bolder; text-align: center;\">"+e.checkName+"</td>";
            // })
        })
        $("#c").html(checkPack);
        $(".childBox").show();
    })

	// $("input[name='combineItem']").on("mouseenter",function(){
	// 	var result=$(this).children("input").val();
	// 	$(".childBox").show();
	// });
    //
	// $("input[name='combineItem'],input[name='packageItem']").on("mouseleave",function(){
	// 	var result=$(this).children("input").val();
	// 	$(".childBox").hide();
	// });


	//确定预约
	// $("input[name=submit]").click(function () {
     //    makeAnAppointment();
    // })
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
		var checkContent = "<tr>";
		$.each(check,function (i,e) {
			checkContent+="<td name=\"t\"><input type=\"checkbox\" name=\"checkItem\" value=\""+e.checkId+"\" />"+e.checkName+"</td>";
        })
        checkContent+="</tr>";
		$("#check").html(checkContent);
    })

	//获取是所有组合项
    $.getJSON("/ExhibitionAllCombination.do",{},function (com) {
        var comContent = "<tr>";
        $.each(com,function (i,e) {
            comContent+="<td name=\"c\"><input type=\"checkbox\" name=\"combineItem\" value=\""+e.combinationId+"\" />"+e.combinationName+"</td>";
        })
        comContent+="</tr>";

        $("#com").html(comContent);
    })

	//获取所有套餐项
    $.getJSON("/ExhibitionAllPackages.do",{},function (package) {
        var packageContent = "<tr>";
        $.each(package,function (i,e) {
            packageContent+="<td name=\"p\"><input type=\"checkbox\" name=\"packageItem\" value=\""+e.packageId+"\"/>"+e.packageName+"</td>";
        })
		packageContent+="</tr>";
        $("#package").html(packageContent);
    })
}