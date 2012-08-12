//**************************************************/
//常用JavaScript脚本函数
//	1.0.0
//最后修改：2002-10-21
//**************************************************/

function click() {
	if (event.button == 2) {
		alert('抱歉，不能使用鼠标右键!');
	}
}
//document.onmousedown=click

function navbarOver(src, clrOver, clrOverBorder) {
	if (!src.contains(event.fromElement)) {
		src.style.cursor = 'hand';
		src.bgColor = clrOver;
		src.borderColor = clrOverBorder;
	}
}
function navbarOut(src, clrIn, clrInBorder) {
	if (!src.contains(event.toElement)) {
		src.style.cursor = 'default';
		src.bgColor = clrIn;
		src.borderColor = clrInBorder;
	}
}
function navbardown(src, clrOver, clrOverBorder) {
	if (!src.contains(event.fromElement)) {
		if (src.bgColor == clrOver) {
          src.style.cursor = 'hand';
			src.bgColor = "#FFFFFF";
			src.borderColor = "#FFFFFF";
		} else {
			src.style.cursor = 'hand';
			src.bgColor = clrOver;
			src.borderColor = clrOverBorder;
		}
	}
}
//**************************************************/
//checkbox全选函数
//**************************************************/
function f_SelectAll(obj) {
	if (obj.value == "全选") {
		flag = true;
		obj.value = "清除";
	} else {
		flag = false;
		obj.value = "全选";
	}
	var objs = document.getElementsByTagName("INPUT");
	for ( var i = 0; i < objs.length; i++) {
		if (objs[i].type == "checkbox")
			objs[i].checked = flag;
	}
}

//**************************************************/
//小数取位数函数
//**************************************************/
function f_MyRound(number, i) {
	var y = Math.pow(10, i);
	number = number * y;
	number = Math.round(number) / y;
	return number;
}

//**************************************************/
//判断是否有radio选择函数
// 1.0.0
//最后修改：2002-10-21
//**************************************************/
function f_RadioCheck(_sName, _oForm) {
	try {
		if (_sName.length > 0) {
			var objs = _oForm.all[_sName];
			if (objs.checked)
				return true;
			for ( var i = 0; i < objs.length; i++) {
				if (objs[i].checked)
					return true;
			}
		}
	} catch (e) {
		//	alert(e);
		return false;
	}
	return false;
}

//**************************************************/
//判断是否有radio选择函数，并给出提示
// 1.0.0
//最后修改：2002-10-21
//**************************************************/
function f_RadioCheckM(_sName, _oForm) {
	try {
		if (_sName.length > 0) {
			var objs = _oForm.all[_sName];
			if (objs.checked)
				return true;
			for ( var i = 0; i < objs.length; i++) {
				if (objs[i].checked)
					return true;
			}
		}
	} catch (e) {
		//	alert(e);
		return false;
	}
	alert("您还没有选择！");
	return false;
}

//**************************************************/
//文本替换函数
// 1.0.0
//**************************************************/
function f_TextReplace(_inputVal) {
	var inputStr = _inputVal.toString();
	inputStr = inputStr.replace(/>/g, "&gt;");
	inputStr = inputStr.replace(/</g, "&lt;");
	inputStr = inputStr.replace(/ /g, "&nbsp;");
	inputStr = inputStr.replace(/\n/g, "<br>");
	return inputStr
}

//**************************************************/
//选择当前行的radio函数
//最后修改：2002-10-21
//**************************************************/
function f_SelectRadio(_oTR, _sRadio) {
	_oTR.all[_sRadio].checked = !(_oTR.all[_sRadio].checked);
}

//格式化日期字符串 函数
function f_FormatDate(_oDate) { //返回 y-m-d 型的日期字符串
	switch (_oDate.constructor) {
	case Date:
		return _oDate.getYear().toString() + "-"
				+ (_oDate.getMonth() + 1).toString() + "-"
				+ _oDate.getDate().toString();
		break;
	case String:
		var arr = _oDate.split("-");
		return arr[0] + "-" + arr[1].replace(/^0/, "") + "-"
				+ arr[2].replace(/^0/, "");
		break;
	default:
		return "";
	}
}

//判断两个日起相差几个月函数
function f_MonthDiff(_sNowDate, _sOldDate) {
	var arrNow = _sNowDate.split("-");
	var arrOld = _sOldDate.split("-");
	var iYearDiff = parseInt(arrNow[0]) - parseInt(arrOld[0])
	var iOldM = parseInt(arrOld[1]);
	var iNowM = parseInt(arrNow[1]) + 1;
	if (iYearDiff < 0)
		return -1;
	if (iYearDiff == 0) {
		return iNowM - iOldM;
	} else {
		return iYearDiff * 12 + iNowM - iOldM;
	}
}

//**************************************************/
//折旧对象
//
// 1.0.0
//最后修改：2002-10-23
//**************************************************/
function ZheJiu(_sYz, _sZjnx, _sCzl, _sQiyongriqi, _sNowDate) {
	this.fYz = parseFloat(_sYz);
	this.iZjnx = parseInt(_sZjnx);
	this.fCzl = parseFloat(_sCzl);
	this.sQYDate = f_FormatDate(_sQiyongriqi);
	if (_sNowDate) {
		this.sNowDate = f_FormatDate(_sNowDate);
	} else {
		var oNow = new Date();
		this.sNowDate = f_FormatDate(oNow);
	}
	this.GetMonthZJ = f_MonthZJ;
	this.GetYearZJ = f_YearZJ;
	this.GetJingZhi = f_JingZhi;
	this.GetZheJiu = f_ZheJiu;
	return this;
}

function f_MonthZJ() { //月折旧额计算函数
	return f_MyRound(this.fYz * (1 - this.fCzl / 100) / this.iZjnx / 12, 2);
}

function f_YearZJ() { //年折旧额计算函数 ( =到现在的折旧-到去年底的折旧 )
	var arr = this.sNowDate.split("-");
	var oYDate = new Date(arr[0], 0, 1); //今年1月1日
	var iOldMonth = f_MonthDiff(f_FormatDate(oYDate), this.sQYDate) - 1;
	if (iOldMonth > this.iZjnx * 12) {
		iOldMonth = this.iZjnx * 12;
	}
	if (iOldMonth < 1) {
		return this.GetZheJiu();
	} else {
		return f_MyRound(this.GetZheJiu() - this.GetMonthZJ() * iOldMonth, 2);
	}
}

function f_JingZhi() { //净值计算
	return f_MyRound(this.fYz - this.GetZheJiu(), 2);
}

function f_ZheJiu() { //折旧计算
	var iTotalMonth = f_MonthDiff(this.sNowDate, this.sQYDate);
	if (iTotalMonth > this.iZjnx * 12) {
		iTotalMonth = this.iZjnx * 12;
	}
	return f_MyRound(this.GetMonthZJ() * iTotalMonth, 2);
}

// ZheJiu对象 End
//************************************************************************

//************************************************************************
//HttpSend
//************************************************************************
function SendHttp(sAspFile, sSend) {
	//sAspFile 为调用的ASP文件名串包括查询参数串
	//sSend为SEND的XML字符串
	//函数返回HTTP的响应结果
	if (navigator.onLine == false) {
		return "你现在处于脱机状态,请联机后再试!"
	}
	var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlhttp.Open("POST", sAspFile, false);
	try {
		//	alert(sSend);
		xmlhttp.Send(sSend);
	} catch (exception) {
		alert("服务器忙!")
	}
	//alert(xmlhttp.responseText)
	try {
		var sResponse = xmlhttp.responseText //系统错误: -1072896748。
	} catch (exception) {
		if (exception.description == '系统错误: -1072896748。') {
			sResponse = ""
			//alert("aa")
		}
	}
	//if (str11.indexOf("-2147483638")!=-1) str11=""
	return sResponse
}

//**************************************************/
//html字符串简化函数
//**************************************************/
function f_ShortHTML(_sHtml) {
	var s = _sHtml;
	var oReg = /style=(['"])[^'"<>]*\1|<span[^<>]*>|<\/span>|<o:p>|<\/o:p>|<\?xml[^<>]*>|<p[^<>]*>|<\/p>/ig
	s = s.replace(oReg, "")
	oReg = /<table[^<>]*>/ig
	s = s.replace(oReg, "<table>")
	oReg = /<tr[^<>]*>/ig
	s = s.replace(oReg, "<tr>")
	oReg = /<td[^<>]*(colspan=['"]?\d['"]?)?[^<>]*(rowSpan=['"]?\d['"]?)?[^<>]*>/ig
	s = s.replace(oReg, "<td \1 \2>")
	return s;
}

//**************************************************/
//网页转存Excel文件函数
//1.0.0
//最后修改 2002-11-13
//**************************************************/
function f_SaveAsExcel(_sHtml, _sFileName) {
	var oWin = window.open("", "", "top=2000,left=2000");
	with (oWin) {
		document.write(f_ShortHTML(_sHtml));
		document.execCommand('Saveas', false, _sFileName);
		close();
	}
}

//**************************************************/
//网页部分内容打印函数
//1.0.0
//最后修改 2002-11-13
//**************************************************/
function f_WebPrint(_sHtml) {
	var oWin = window.open("", "", "top=2000,left=2000");
	with (oWin) {
		document.write(_sHtml);
		print();
		location.reload();
		close();
	}
}

//***************************************************/
//将一个列表选择项目加入到另一个列表		
//1.0.0
//最后修改 2003-09-03
//***************************************************/
var flag;

function addElement(sList, tList) {
	for ( var x = 0; x < sList.length; x++) {
		var opt = sList.options[x];
		if (opt.selected) {
			flag = true;
			for ( var y = 0; y < tList.length; y++) {
				var topt = tList.options[y];
				if (topt.value == opt.value) {
					flag = false;
				}
			}
			if (flag) {
				tList.options[tList.options.length] = new Option(opt.text,
						opt.value, 0, 0);
			}
		}
	}
}

//****************************************************/
//从列表框中移去所选项
//1.0.0
//最后修改 2003-09-03
//****************************************************/
function delElement(locs, mylocs) {
	for ( var x = mylocs.length - 1; x >= 0; x--) {
		var opt = mylocs.options[x];
		if (opt.selected) {
			mylocs.options[x] = null;
		}
	}
}

//将指定的多选列表组成一个字符串
function listToString(listField, strField, sepChar) {
	strField.value = "";
	for (i = 0; i < listField.length; i++)
		if (i == listField.length - 1)
			strField.value += listField.options[i].value;
		else
			strField.value += listField.options[i].value + sepChar;
}