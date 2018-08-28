$(function() {
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

	//获取体检项
	$("input[name='checkItem'],input[name='combineItem'],input[name='packageItem']").change(function() {
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
	
	$("input[name='combineItem'],input[name='packageItem']").mouseenter(function(){
		var result=$(this).children("input").val();
		$(".childBox").show();
	});
	$("input[name='combineItem'],input[name='packageItem']").mouseleave(function(){
		var result=$(this).children("input").val();
		$(".childBox").hide();
	});
})