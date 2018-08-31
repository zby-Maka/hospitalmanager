$(function() {
	//根据姓名获取姓名简拼
	$("input[name='personName']").on("keyup keydown change blur", function() {
		$("input[name='personNameSpellCode']").val($(this).toPinyin());
	});
	//根据单位名称获取简拼
	$("input[name='companyName']").on("keyup keydown change blur", function() {
		$("input[name='spellCode']").val($(this).toPinyin());
	});

	//验证身份证并根据身份证获取年龄、出生日期、性别
	$("input[name='personIdCard']").on("blur", function() {
		var idCard = $("input[name='personIdCard']").val();
		if(idCard == "") {
			$("td[name='checkIdCard']").text("");
			$("input[name='personBirthday']").val("");
			$("input[name='personSex']").val("");
			$("input[name='personAge']").val("");
			return
		} else {
			var checkResult = CheckIdCard(idCard);
			if(checkResult == "验证通过!") {
				var birthday = GetBirthday(idCard);
				if(birthday == false) {
					$("input[name='personBirthday']").val("");
				} else {
					//根据身份证查询用户是否体检过，并赋值历史信息
					$.getJSON("/getPersonInfoByNameAndCard.do",{"personIdCard":idCard},function (date) {
						alert(date);
						if(date==null){
                            $("input[name=personTelephone]").val("");
                            $("input[name=personAddress]").val("");
                            document.getElementsByName('isMarry')[0].checked = true;
						}else {
                            $("input[name=personTelephone]").val(date.personTelephone);
                            $("input[name=personAddress]").val(date.personAddress);
                            if("未婚"==date.isMarry)
                                //$(isMarry[0]).prop("checked",true);
                                document.getElementsByName('isMarry')[0].checked = true;
                            else if("已婚"==date.isMarry)
                                //$(isMarry[1]).prop("checked",true);
                                document.getElementsByName('isMarry')[1].checked = true;
						}
					})
					$("input[name='personBirthday']").val(birthday);
					var age = GetAge(birthday);
					$("input[name='personAge']").val(age);
				}
				var sex = Getsex(idCard);
				$("input[name='personSex']").val(sex);
				$("td[name='checkIdCard']").text("");
			} else {
				$("td[name='checkIdCard']").text(checkResult);
			}
		}
	});
	//验证电话号
	$("input[name='personTelephone']").on("blur", function() {
		var phone = $("input[name='personTelephone']").val();
		if(phone != "") {
			var checkResult = checkPhone(phone);
			if(!checkResult) {
				$("td[name='checkTelephone']").text("请输入正确的电话号");
			} else {
				$("td[name='checkTelephone']").text("");
			}
		} else {
			$("td[name='checkTelephone']").text("");
		}
	});
	//判断银行卡号的所属银行
	$("input[name='bankNumber']").on("blur", function() {
		var bankNumber = $("input[name='bankNumber']").val();
		if(bankNumber != "") {
			var bankName = bankCardAttribution(bankNumber);
			console.log(bankName);
			if(bankName == "error") {
				$("td[name='checkBankNumber']").text("请输入正确的银行卡号");
				$("input[name='bankName']").val("");
				return;
			}
			$("input[name='bankName']").val(bankName.bankName);
			$("td[name='checkBankNumber']").text("");
		}else{
			$("input[name='bankName']").val("");
			$("td[name='checkBankNumber']").text("");
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
});