$(function() {
	
	//上一步按钮
	$("input[name=back]").click(function () {
		location.href="/booking.html";
    });

	//查询所有体检项，组合项，套餐项
    selAllCheck();

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
	//
	//获取体检项
	$(".tab_box").on("click","input[name='checkItem'],input[name='combineItem'],input[name='packageItem']",function() {
		var result = $(this).parent().text();
		alert(result);
		//判断是否选中
		var check = $(this).prop("checked");
		if(check){
			var html="<span class='check' name='checkItem' id='"+result+"'>"+result+"</span>";
			$(".checked").append(html);
		}else{
			$(".checked").children("#"+result).remove();
		}
	});
	
	$("input[name='combineItem'],input[name='packageItem']").on("mouseenter",function(){
		var result=$(this).children("input").val();
		$(".childBox").show();
	});
	$("input[name='combineItem'],input[name='packageItem']").on("mouseleave",function(){
		var result=$(this).children("input").val();
		$(".childBox").hide();
	});
})

/**
 * 查询所有体检项，组合项，套餐项
 */
function selAllCheck() {

	//获取所有检查项
	$.getJSON("/ExhibitionAllCheck.do",{},function (check) {
		console.log(check);
		var checkContent = "<tr>";
		$.each(check,function (i,e) {
			checkContent+="<td name=\"t\"><input type=\"checkbox\" name=\"checkItem\" value=\""+e.checkId+"\" />"+e.checkName+"</td>";
        })
        checkContent+="</tr>";
		$("#check").html(checkContent);
    })

	//获取是所有组合项
    $.getJSON("/ExhibitionAllCombination.do",{},function (com) {
        console.log(com);
        var comContent = "<tr>";
        $.each(com,function (i,e) {
            comContent+="<td name=\"c\"><input type=\"checkbox\" name=\"combineItem\" value=\""+e.combinationId+"\" />"+e.combinationName+"</td>";
        })
        comContent+="</tr>";
        $("#com").html(comContent);
    })

	//获取所有套餐项
    $.getJSON("/ExhibitionAllPackages.do",{},function (package) {
        console.log(package);
        var packageContent = "<tr>";
        $.each(package,function (i,e) {
            packageContent+="<td name=\"p\"><input type=\"checkbox\" name=\"packageItem\" value=\""+e.packageId+"\"/>"+e.packageName+"</td>";
        })
		packageContent+="</tr>";
        $("#package").html(packageContent);
    })
}