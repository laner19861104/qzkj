/* =========================================================================*/
/*cookie函数*/
/* =========================================================================*/

function delCookie(cookieName){
	//$.cookie(cookieName, null); // 删除 cookie
	//var cookieOption = {expires: 10, path: '/'};
	var cookieOption = {path: '/'};
	$.cookie(cookieName, null, cookieOption);   
}

function setCookie(cookieName,cookieVal) {
	//var domainVal=document.domain;
	//var cookieOption = {expires: 10, path: '/', domain: domainVal, secure: true};
	//var cookieOption = {expires: 10, path: '/'};
	var cookieOption = {path: '/'};
	$.cookie(cookieName, cookieVal, cookieOption);  //设置带时间的cookie  
}

function getCookie(cookieName) {
	return $.cookie(cookieName);
}