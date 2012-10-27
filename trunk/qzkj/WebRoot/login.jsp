<%@ page language="java" import="java.util.*" pageEncoding="gb2312"   contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK2312" />
<meta http-equiv="x-ua-compatible" content="ie=7" /> 
<title>学员注册</title>
<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="www/stuInfo/css/login.css">
	<script type="text/javascript" src="templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="www/stuInfo/js/common.js"></script>
  </head>
  
  <body>
  <div class="center_box">
  <div class="logo mt_88">
    <div class="zuo"><a href="http://www.chinaacc.com/" target="_blank"><img src="www/stuInfo/images/logo.gif"></a></div>
    <div class="you"><a href="http://www.chinaacc.com/" target="_blank" class="link_bai">网校首页</a> │ <a href="http://www.chinaacc.com/help/" target="_blank" class="link_bai">帮助</a></div>
  </div>
  <div class="main">
    <div class="top"><a href="www/stuInfo/reg.jsp" class="link_ho">新学员注册&gt;&gt;</a></div>
    <div class="zhuti">
      <div class="left">
        <strong>·名师授课：</strong>权威师资阵容　百位名师联袂主讲；<br>
        <strong>·奖 学 金：</strong>中华会计网校50万元奖学金　重奖优秀学员；<br>
        <strong>·学费优惠：</strong>VIP会员享受6-8折学费优惠折扣；<br>
        <strong>·专家答疑：</strong>两名教师共同答疑　“一答一审”双重保障；<br>
        <strong>·免费学习：</strong>先听课、后付费　7天免费学习；<br>
        <strong>·课件下载：</strong>提供多种课件下载方式，断网学习，节约上网费用；<br>
        <strong>·视频直播：</strong>视频互动交流活动，与名师“零”距离接触。
      </div>
      <div class="right">
      	<div class="bar">
          <div class="bi"> 　</div>
          <c:if test="${message=='false'}">
          <div class="shu" style="height: 18px;line-height: 18px;">
            <font color="#FF0000"><b>对不起，您的帐号或密码错误</b></font>
          </div>
          </c:if>
          <form method="post" id="form1" action="wlogin.do" onsubmit="return chenckdata()">
        </div>        
        <div class="bar">
          <div class="bi">用户名</div>
          <div class="shu"><input name="account" id="account" type="text" class="input01" value="" maxlength="20" style="width:160px" onfocus="inputVerify(this);" onblur="inputVerify(this);" onclick="if(this.value=='')changeVerifyCode(document.form1.randcode)"></div>
        </div>
        <div class="bar">
          <div class="bi"> 　</div>
          <div class="shu">
            <div class="tishi" id="username_tip" style="display: none;">用户名提示</div>
          </div>
        </div>
        <div class="bar">
          <div class="bi">密 　码</div>
          <div class="shu"><input name="password" id="password" type="password" class="input01" value="" maxlength="18" style="width:160px" onfocus="inputVerify(this);" onblur="inputVerify(this);"></div>
        </div>
        <div class="bar">
          <div class="bi"> 　</div>
          <div class="shu">
          	<div class="tishi" id="passwd_tip" style="display: none;">密码提示</div>          
          </div>
        </div>
        <div class="bar">
          <div class="bi">验证码</div>
          <div class="shu"><input name="verifycode" id="randcode" type="text" class="input01" onfocus="this.select()" onclick="if(this.value=='请输入右侧数字')this.value=''" onmouseover="this.focus()" onmouseout="if(this.value=='')this.value='请输入右侧数字';" value="请输入右侧数字" size="12" maxlength="4">
           <img name="verifyCodeImg" id="verifyCodeImg"  src="/qzkj/VerifyCodeServlet.action" style="padding:0 1px;width:70px" />
            <a href="javascript:void(0)" onclick="changeVerifyCode(document.getElementById('verifyCodeImg'))" class="link_lan">刷新</a>
          </div>
        </div>
        <div class="anniu">
            <input type="submit" value="" class="submitBtn">
        	<a href="/getPassword/index.shtm" style="text-decoration:underline;">找回密码</a></div>
        <div class="anniu">还没有注册？<a href="www/stuInfo/reg.jsp" class="link_ho">马上注册一个！</a></div>
        <div class="miao" style="display: none;">
          <div class="bao">账户安全保护</div>
          <div class="con">登陆后请完善您的个人信息，保护您的账户！<br><font class="color_qlan">您可通过邮箱、提问、人工方式找回密码</font></div>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>
  <script type="text/javascript">
function checkdata(){
	var userName = document.getElementById("account");
	var passwd = document.getElementById("password");
	var randcode = document.getElementById("randcode");
	var username_tip = document.getElementById("username_tip");
	var passwd_tip = document.getElementById("passwd_tip");
	
	if(isEmpty(userName.value)){
		username_tip.innerHTML = "请输入学员代码！";
		username_tip.style.display = "block";
		passwd_tip.style.display = "none";
		userName.focus();
		return false;  
	}else if (isEmpty(passwd.value)){
		passwd_tip.innerHTML = "请输入密码！";
		username_tip.style.display = "none";
		passwd_tip.style.display = "block";
		passwd.focus();
		return false;  
	}else if (isEmpty(randcode.value) || randcode.value=="请输入右侧数字"){	
		alert("为保证广大学员账号的安全性，请在“验证码输入框”中输入右侧的4位数字！");
		randcode.focus();
		return false;  
	}
	return true;
}
	
function inputVerify(obj)
{
	var username_tip = document.getElementById("username_tip");
	var passwd_tip = document.getElementById("passwd_tip");
	
	if(obj.id == "account")
	{
		if(isEmpty(obj.value)){
			username_tip.innerHTML = "请输入学员代码！";
			username_tip.style.display = "block";
			passwd_tip.style.display = "none";
		}
		else
		{
			username_tip.style.display = "none";
		}
	}
	
	if(obj.id == "password")
	{
		if(isEmpty(obj.value)){
			passwd_tip.innerHTML = "请输入密码！";
			username_tip.style.display = "none";
			passwd_tip.style.display = "block";
		}
		else
		{
			passwd_tip.style.display = "none";
		}
	}
	
}
function changeVerifyCode(obj) {

	//1、如果用<iframe>实现，则重新加载<iframe>的内容
	//verifyCodeFrame.location.reload();

	//2、如果用<img>实现，则修改<img src=url>的url
	//这里有一个小技巧，如果给url赋相同的值，浏览器不会重新发出请求，因此用js生成一个即时毫秒数做url中的参数
	t = new Date().getTime();
	obj.src = "VerifyCodeServlet.action?t=" + t;
}	
</script>
<script language="javascript" for="document" event="onkeydown"> 

//回车按钮事件处理  
if (event.keyCode == 13){  
	event.keyCode=0; 
	checkdata();
}  
</script>
  </body>
</html>
