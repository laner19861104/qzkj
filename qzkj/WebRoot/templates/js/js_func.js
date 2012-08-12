//**************************************************/
//����JavaScript�ű�����
//	1.0.0
//����޸ģ�2002-10-21
//**************************************************/

function click() {
	if (event.button == 2) {
		alert('��Ǹ������ʹ������Ҽ�!');
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
//checkboxȫѡ����
//**************************************************/
function f_SelectAll(obj) {
	if (obj.value == "ȫѡ") {
		flag = true;
		obj.value = "���";
	} else {
		flag = false;
		obj.value = "ȫѡ";
	}
	var objs = document.getElementsByTagName("INPUT");
	for ( var i = 0; i < objs.length; i++) {
		if (objs[i].type == "checkbox")
			objs[i].checked = flag;
	}
}

//**************************************************/
//С��ȡλ������
//**************************************************/
function f_MyRound(number, i) {
	var y = Math.pow(10, i);
	number = number * y;
	number = Math.round(number) / y;
	return number;
}

//**************************************************/
//�ж��Ƿ���radioѡ����
// 1.0.0
//����޸ģ�2002-10-21
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
//�ж��Ƿ���radioѡ��������������ʾ
// 1.0.0
//����޸ģ�2002-10-21
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
	alert("����û��ѡ��");
	return false;
}

//**************************************************/
//�ı��滻����
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
//ѡ��ǰ�е�radio����
//����޸ģ�2002-10-21
//**************************************************/
function f_SelectRadio(_oTR, _sRadio) {
	_oTR.all[_sRadio].checked = !(_oTR.all[_sRadio].checked);
}

//��ʽ�������ַ��� ����
function f_FormatDate(_oDate) { //���� y-m-d �͵������ַ���
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

//�ж��������������º���
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
//�۾ɶ���
//
// 1.0.0
//����޸ģ�2002-10-23
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

function f_MonthZJ() { //���۾ɶ���㺯��
	return f_MyRound(this.fYz * (1 - this.fCzl / 100) / this.iZjnx / 12, 2);
}

function f_YearZJ() { //���۾ɶ���㺯�� ( =�����ڵ��۾�-��ȥ��׵��۾� )
	var arr = this.sNowDate.split("-");
	var oYDate = new Date(arr[0], 0, 1); //����1��1��
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

function f_JingZhi() { //��ֵ����
	return f_MyRound(this.fYz - this.GetZheJiu(), 2);
}

function f_ZheJiu() { //�۾ɼ���
	var iTotalMonth = f_MonthDiff(this.sNowDate, this.sQYDate);
	if (iTotalMonth > this.iZjnx * 12) {
		iTotalMonth = this.iZjnx * 12;
	}
	return f_MyRound(this.GetMonthZJ() * iTotalMonth, 2);
}

// ZheJiu���� End
//************************************************************************

//************************************************************************
//HttpSend
//************************************************************************
function SendHttp(sAspFile, sSend) {
	//sAspFile Ϊ���õ�ASP�ļ�����������ѯ������
	//sSendΪSEND��XML�ַ���
	//��������HTTP����Ӧ���
	if (navigator.onLine == false) {
		return "�����ڴ����ѻ�״̬,������������!"
	}
	var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	xmlhttp.Open("POST", sAspFile, false);
	try {
		//	alert(sSend);
		xmlhttp.Send(sSend);
	} catch (exception) {
		alert("������æ!")
	}
	//alert(xmlhttp.responseText)
	try {
		var sResponse = xmlhttp.responseText //ϵͳ����: -1072896748��
	} catch (exception) {
		if (exception.description == 'ϵͳ����: -1072896748��') {
			sResponse = ""
			//alert("aa")
		}
	}
	//if (str11.indexOf("-2147483638")!=-1) str11=""
	return sResponse
}

//**************************************************/
//html�ַ����򻯺���
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
//��ҳת��Excel�ļ�����
//1.0.0
//����޸� 2002-11-13
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
//��ҳ�������ݴ�ӡ����
//1.0.0
//����޸� 2002-11-13
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
//��һ���б�ѡ����Ŀ���뵽��һ���б�		
//1.0.0
//����޸� 2003-09-03
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
//���б������ȥ��ѡ��
//1.0.0
//����޸� 2003-09-03
//****************************************************/
function delElement(locs, mylocs) {
	for ( var x = mylocs.length - 1; x >= 0; x--) {
		var opt = mylocs.options[x];
		if (opt.selected) {
			mylocs.options[x] = null;
		}
	}
}

//��ָ���Ķ�ѡ�б����һ���ַ���
function listToString(listField, strField, sepChar) {
	strField.value = "";
	for (i = 0; i < listField.length; i++)
		if (i == listField.length - 1)
			strField.value += listField.options[i].value;
		else
			strField.value += listField.options[i].value + sepChar;
}