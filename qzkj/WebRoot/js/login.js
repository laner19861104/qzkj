window.document.onkeydown = disableEnterKey;

var allowLogin = true;
function disableEnterKey() {
	if (event.keyCode == 13) {
		if (document.loginForm.username.value == '') {
			alert("�û�������Ϊ�գ��������û�����");
			document.loginForm.username.focus();
			return ;
		}
		if (document.loginForm.password.value == '') {
			document.loginForm.password.focus();
			return ;
		}
		if (document.loginForm.verifycode.value == '') {
			document.loginForm.verifycode.focus();
			return;
		}
		submitButton('LOGIN');
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
	if (document.loginForm.username.value == "") {
		document.loginForm.username.focus();
	} else {
		document.loginForm.password.focus();
	}
	changeVerifyCode();
}

function submitButton(linkType) {

	if (document.loginForm.username.value == '') {
		alert("�û�������Ϊ�գ��������û�����");
		document.loginForm.username.focus();
		return;
	} else {
		if (!loginCheck(document.loginForm.username.value)) {
			alert("�û�����������������û�����");
			document.loginForm.username.focus();
			return;
		}
		//document.loginForm.password.focus();
	}
	if (document.loginForm.password.value == '') {
		alert("��������Ϊ�գ�����������");
		document.loginForm.password.focus();
		return;
	}
	if (document.loginForm.verifycode.value == '') {
		alert("��������֤��");
		document.loginForm.verifycode.focus();
		return;
	}
	//	document.loginForm.verifyCodeImg.src="";
	document.loginForm.action = "../qzkj/adminLogin.action";
	document.loginForm.submit();
}

//������֤��
function changeVerifyCode() {

	//1�������<iframe>ʵ�֣������¼���<iframe>������
	//verifyCodeFrame.location.reload();

	//2�������<img>ʵ�֣����޸�<img src=url>��url
	//������һ��С���ɣ������url����ͬ��ֵ��������������·������������js����һ����ʱ��������url�еĲ���
	t = new Date().getTime();
	document.loginForm.verifyCodeImg.src = "VerifyCodeServlet.action?t=" + t;
}