//----------------------------------------------------------
//    功能：根据身份证号获得出生日期
//  参数：身份证号 psidno
//    返回值：
//    出生日期
//----------------------------------------------------------
function GetBirthday(psidno) {
	var birthdayno, birthdaytemp
	if(psidno.length == 18) {
		birthdayno = psidno.substring(6, 14)
	} else if(psidno.length == 15) {
		birthdaytemp = psidno.substring(6, 12)
		birthdayno = "19" + birthdaytemp
	} else {
		alert("错误的身份证号码，请核对！")
		return false
	}
	var birthday = birthdayno.substring(0, 4) + "-" + birthdayno.substring(4, 6) + "-" + birthdayno.substring(6, 8)
	return birthday
}

//----------------------------------------------------------
//    功能：根据身份证号获得性别
//  参数：身份证号 psidno
//    返回值：
//    性别
//----------------------------------------------------------
function Getsex(psidno) {
	var sexno, sex
	if(psidno.length == 18) {
		sexno = psidno.substring(16, 17)
	} else if(psidno.length == 15) {
		sexno = psidno.substring(14, 15)
	} else {
		alert("错误的身份证号码，请核对！")
		return false
	}
	var tempid = sexno % 2;
	if(tempid == 0) {
		sex = '女'
	} else {
		sex = '男'
	}
	return sex
}

//----------------------------------------------------------
//    功能：根据生日获取年龄
//  参数：生日
//    idcard 
//    返回值：年龄
//----------------------------------------------------------
function GetAge(birthday) {
	var reg_birthday = birthday.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if(reg_birthday == null) {
		return false;
	}
	var date = new Date(reg_birthday[1], reg_birthday[3] - 1, reg_birthday[4]);
	if(date.getFullYear() == reg_birthday[1] && (date.getMonth() + 1) == reg_birthday[3] && date.getDate() == reg_birthday[4]) {
		var year = new Date().getFullYear();
		return(year - reg_birthday[1]);
	}
	return("生日格式错误!");
}

//----------------------------------------------------------
//    功能：检查电话号
//  参数：电话
//    idcard 
//    返回值：
//----------------------------------------------------------
function checkPhone(telephone) {
	var reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
	if(!reg.exec(telephone)) {
		return false;
	}
	return true;
}

//----------------------------------------------------------
//    功能：检查身份证号码
//  参数：
//    idcard 
//    返回值：
//----------------------------------------------------------
function CheckIdCard(idcard) {　　
	var Errors = new Array(　　　　"验证通过!", 　　　　"身份证号码位数不对!", 　　　　"身份证号码出生日期超出范围或含有非法字符!", 　　　　"身份证号码校验错误!", 　　　　"身份证地区非法!"　　);　　
	var area = {
		11: "北京",
		12: "天津",
		13: "河北",
		14: "山西",
		15: "内蒙古",
		21: "辽宁",
		22: "吉林",
		23: "黑龙江",
		　　　　　　31: "上海",
		32: "江苏",
		33: "浙江",
		34: "安徽",
		35: "福建",
		36: "江西",
		37: "山东",
		　　　　　　41: "河南",
		42: "湖北",
		43: "湖南",
		44: "广东",
		45: "广西",
		46: "海南",
		50: "重庆",
		51: "四川",
		52: "贵州",
		53: "云南",
		54: "西藏",
		　　　　　　61: "陕西",
		62: "甘肃",
		63: "青海",
		64: "宁夏",
		65: "新疆",
		71: "台湾",
		81: "香港",
		82: "澳门",
		91: "国外"
	}

	　　
	var idcard, Y, JYM;　　
	var S, M;　　
	var idcard_array = new Array();　　
	idcard_array = idcard.split("");　　 //地区检验 
	　　
	if(area[parseInt(idcard.substr(0, 2))] == null) return Errors[4];　　 //身份号码位数及格式检验 
	　　
	switch(idcard.length) {　　　　
		case 15:
			　　　　　　if((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && 　　　　　　　　　　(parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {　　　　　　　　
				ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/; //测试出生日期的合法性 
				　　　　　　
			} else {　　　　　　　　
				ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/; //测试出生日期的合法性 
				　　　　　　
			}　　　　　　
			if(ereg.test(idcard)) return Errors[0];　　　　　　
			else return Errors[2];

			　　　　　　
			break;　　　　
		case 18:
			　　 //18位身份号码检测 
			　　 //出生日期的合法性检查 
			　　 //闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9])) 
			　　 //平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8])) 
			　　　　　　if(parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && 　　　　　　　　　　parseInt(idcard.substr(6, 4)) % 4 == 0)) {　　　　　　　　
				ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/; //闰年出生日期的合法性正则表达式 
				　　　　　　
			} else {　　　　　　　　
				ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/; //平年出生日期的合法性正则表达式 
				　　　　　　
			}　　　　　　
			if(ereg.test(idcard)) { //测试出生日期的合法性 
				　　　　　　 //计算校验位 
				　　　　　　
				S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7　　　　　　　　 + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9　　　　　　　　 + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10　　　　　　　　 + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5　　　　　　　　 + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8　　　　　　　　 + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4　　　　　　　　 + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2　　　　　　　　 + parseInt(idcard_array[7]) * 1　　　　　　　　 + parseInt(idcard_array[8]) * 6　　　　　　　　 + parseInt(idcard_array[9]) * 3;　　　　　　　　
				Y = S % 11;　　　　　　　　
				M = "F";　　　　　　　　
				JYM = "10X98765432";　　　　　　　　
				M = JYM.substr(Y, 1); //判断校验位 
				　　　　　　
				if(M == idcard_array[17]) return Errors[0]; //检测ID的校验位 
				　　　　　　
				else return Errors[3];　　　　
			}　　　　
			else return Errors[2];　　　　
			break;　　　　
		default:
			　　　　return Errors[1];　　　　
			break;　　
	}
}