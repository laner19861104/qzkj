window.document.onkeydown = disableEnterKey;

var allowLogin = true;
function disableEnterKey() {
	if (event.keyCode == 13) {
		if (document.activeElement.type == "text") {
			if (document.loginForm.entcode.value == '') {
				alert("�û�������Ϊ�գ��������û�����");
				document.loginForm.entcode.focus();
				return false;
			} else {
				document.loginForm.entuserpass.focus();
			}
		} else {
			if (document.loginForm.entuserpass.value == '') {
				alert("��������Ϊ�գ�����������");
				document.loginForm.entuserpass.focus();
				return false;
			}
			submitButton('LOGIN');
		}
	}
}

function onLoad() {
	/*
	 try {
	 if(navigator.appName=="Microsoft Internet Explorer") {//IE��������
	 if(navigator.appVersion.indexOf("MSIE 6.0") == -1){
	 alert("��ʹ�õ�������汾���ʺϱ�ϵͳ����Ҫ��\r\n�뽫��������IE6.0�����ٵ�¼��");
	 allowLogin = false;
	 return false;
	 }
	 }else{//�����������
	 alert("��ʹ�õ�������汾���ʺϱ�ϵͳ����Ҫ��\r\n��ʹ��Microsoft Internet Explorer 6.0 �����ϰ汾����������е�¼��");
	 allowLogin = false;
	 return false;
	 }
	 }catch(e){
	 alert("��ʹ�õ�������汾���ʺϱ�ϵͳ����Ҫ��\r\n��ʹ��Microsoft Internet Explorer 6.0 �����ϰ汾����������е�¼��");
	 allowLogin = false;
	 return false;
	 }
	 */
	if (document.loginForm.entcode.value == "") {
		document.loginForm.entcode.focus();
	} else {
		document.loginForm.entuserpass.focus();
	}
}
function selButton(linkType) {

	if (document.loginForm.entcode.value == '') {
		alert("�û�������Ϊ�գ��������û�����");
		document.loginForm.entcode.focus();
		return false;
	} else {
		if (!entloginCheck(document.loginForm.entcode.value)) {
			alert("�û�����������������û�����");
			document.loginForm.entcode.focus();
			return false;
		}
		//document.loginForm.entuserpass.focus();
	}
	document.loginForm.action = "../ecrs/entloginentry.action";
	document.loginForm.submit();
}

function submitButton(linkType) {

	if (document.loginForm.entcode.value == '') {
		alert("�û�������Ϊ�գ��������û�����");
		document.loginForm.entcode.focus();
		return false;
	} else {
		if (!entloginCheck(document.loginForm.entcode.value)) {
			alert("�û�����������������û�����");
			document.loginForm.entcode.focus();
			return false;
		}
		//document.loginForm.entuserpass.focus();
	}
	if (document.loginForm.entuserpass.value == '') {
		alert("��������Ϊ�գ�����������");
		document.loginForm.entuserpass.focus();
		return false;
	}
	if (document.loginForm.projcode.value == '') {
		alert("��Ŀ����Ϊ�գ���ѡ����Ŀ");
		document.loginForm.entuserpass.focus();
		return false;
	}
	document.loginForm.submit();
}