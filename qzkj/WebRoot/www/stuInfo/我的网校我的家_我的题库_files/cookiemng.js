/* =========================================================================*/
/*cookie����*/
/* =========================================================================*/

function delCookie(cookieName){
	//$.cookie(cookieName, null); // ɾ�� cookie
	//var cookieOption = {expires: 10, path: '/'};
	var cookieOption = {path: '/'};
	$.cookie(cookieName, null, cookieOption);   
}

function setCookie(cookieName,cookieVal) {
	//var domainVal=document.domain;
	//var cookieOption = {expires: 10, path: '/', domain: domainVal, secure: true};
	//var cookieOption = {expires: 10, path: '/'};
	var cookieOption = {path: '/'};
	$.cookie(cookieName, cookieVal, cookieOption);  //���ô�ʱ���cookie  
}

function getCookie(cookieName) {
	return $.cookie(cookieName);
}