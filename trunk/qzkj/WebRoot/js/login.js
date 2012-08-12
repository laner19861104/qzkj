window.document.onkeydown = disableEnterKey;

var allowLogin = true;
function disableEnterKey() {
	if (event.keyCode == 13) {
		if (document.loginForm.username.value == '') {
			alert("用户名输入为空，请输入用户名！");
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
	if (document.loginForm.username.value == "") {
		document.loginForm.username.focus();
	} else {
		document.loginForm.password.focus();
	}
	changeVerifyCode();
}

function submitButton(linkType) {

	if (document.loginForm.username.value == '') {
		alert("用户名输入为空，请输入用户名！");
		document.loginForm.username.focus();
		return;
	} else {
		if (!loginCheck(document.loginForm.username.value)) {
			alert("用户名输入错误，请输入用户名！");
			document.loginForm.username.focus();
			return;
		}
		//document.loginForm.password.focus();
	}
	if (document.loginForm.password.value == '') {
		alert("密码输入为空，请输入密码");
		document.loginForm.password.focus();
		return;
	}
	if (document.loginForm.verifycode.value == '') {
		alert("请输入验证码");
		document.loginForm.verifycode.focus();
		return;
	}
	//	document.loginForm.verifyCodeImg.src="";
	document.loginForm.action = "../qzkj/adminLogin.action";
	document.loginForm.submit();
}

//更换验证码
function changeVerifyCode() {

	//1、如果用<iframe>实现，则重新加载<iframe>的内容
	//verifyCodeFrame.location.reload();

	//2、如果用<img>实现，则修改<img src=url>的url
	//这里有一个小技巧，如果给url赋相同的值，浏览器不会重新发出请求，因此用js生成一个即时毫秒数做url中的参数
	t = new Date().getTime();
	document.loginForm.verifyCodeImg.src = "VerifyCodeServlet.action?t=" + t;
}