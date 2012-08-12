window.document.onkeydown = disableEnterKey;

var allowLogin = true;
function disableEnterKey() {
	if (event.keyCode == 13) {
		if (document.activeElement.type == "text") {
			if (document.loginForm.entcode.value == '') {
				alert("用户名输入为空，请输入用户名！");
				document.loginForm.entcode.focus();
				return false;
			} else {
				document.loginForm.entuserpass.focus();
			}
		} else {
			if (document.loginForm.entuserpass.value == '') {
				alert("密码输入为空，请输入密码");
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
	 if(navigator.appName=="Microsoft Internet Explorer") {//IE浏览器检查
	 if(navigator.appVersion.indexOf("MSIE 6.0") == -1){
	 alert("你使用的浏览器版本不适合本系统运行要求，\r\n请将它升级到IE6.0以上再登录。");
	 allowLogin = false;
	 return false;
	 }
	 }else{//其他浏览器的
	 alert("你使用的浏览器版本不适合本系统运行要求，\r\n请使用Microsoft Internet Explorer 6.0 及以上版本的浏览器进行登录。");
	 allowLogin = false;
	 return false;
	 }
	 }catch(e){
	 alert("你使用的浏览器版本不适合本系统运行要求，\r\n请使用Microsoft Internet Explorer 6.0 及以上版本的浏览器进行登录。");
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
		alert("用户名输入为空，请输入用户名！");
		document.loginForm.entcode.focus();
		return false;
	} else {
		if (!entloginCheck(document.loginForm.entcode.value)) {
			alert("用户名输入错误，请输入用户名！");
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
		alert("用户名输入为空，请输入用户名！");
		document.loginForm.entcode.focus();
		return false;
	} else {
		if (!entloginCheck(document.loginForm.entcode.value)) {
			alert("用户名输入错误，请输入用户名！");
			document.loginForm.entcode.focus();
			return false;
		}
		//document.loginForm.entuserpass.focus();
	}
	if (document.loginForm.entuserpass.value == '') {
		alert("密码输入为空，请输入密码");
		document.loginForm.entuserpass.focus();
		return false;
	}
	if (document.loginForm.projcode.value == '') {
		alert("项目不能为空，请选择项目");
		document.loginForm.entuserpass.focus();
		return false;
	}
	document.loginForm.submit();
}