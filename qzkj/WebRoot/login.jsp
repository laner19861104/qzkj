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
<title>ѧԱע��</title>
<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="www/stuInfo/css/login.css">
	<script type="text/javascript" src="templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="www/stuInfo/js/common.js"></script>
  </head>
  
  <body>
  <div class="center_box">
  <div class="logo mt_88">
    <div class="zuo"><a href="http://www.chinaacc.com/" target="_blank"><img src="www/stuInfo/images/logo.gif"></a></div>
    <div class="you"><a href="http://www.chinaacc.com/" target="_blank" class="link_bai">��У��ҳ</a> �� <a href="http://www.chinaacc.com/help/" target="_blank" class="link_bai">����</a></div>
  </div>
  <div class="main">
    <div class="top"><a href="www/stuInfo/reg.jsp" class="link_ho">��ѧԱע��&gt;&gt;</a></div>
    <div class="zhuti">
      <div class="left">
        <strong>����ʦ�ڿΣ�</strong>Ȩ��ʦ�����ݡ���λ��ʦ����������<br>
        <strong>���� ѧ ��</strong>�л������У50��Ԫ��ѧ���ؽ�����ѧԱ��<br>
        <strong>��ѧ���Żݣ�</strong>VIP��Ա����6-8��ѧ���Ż��ۿۣ�<br>
        <strong>��ר�Ҵ��ɣ�</strong>������ʦ��ͬ���ɡ���һ��һ��˫�ر��ϣ�<br>
        <strong>�����ѧϰ��</strong>�����Ρ��󸶷ѡ�7�����ѧϰ��<br>
        <strong>���μ����أ�</strong>�ṩ���ֿμ����ط�ʽ������ѧϰ����Լ�������ã�<br>
        <strong>����Ƶֱ����</strong>��Ƶ���������������ʦ���㡱����Ӵ���
      </div>
      <div class="right">
      	<div class="bar">
          <div class="bi"> ��</div>
          <c:if test="${message=='false'}">
          <div class="shu" style="height: 18px;line-height: 18px;">
            <font color="#FF0000"><b>�Բ��������ʺŻ��������</b></font>
          </div>
          </c:if>
          <form method="post" id="form1" action="wlogin.do" onsubmit="return chenckdata()">
        </div>        
        <div class="bar">
          <div class="bi">�û���</div>
          <div class="shu"><input name="account" id="account" type="text" class="input01" value="" maxlength="20" style="width:160px" onfocus="inputVerify(this);" onblur="inputVerify(this);" onclick="if(this.value=='')changeVerifyCode(document.form1.randcode)"></div>
        </div>
        <div class="bar">
          <div class="bi"> ��</div>
          <div class="shu">
            <div class="tishi" id="username_tip" style="display: none;">�û�����ʾ</div>
          </div>
        </div>
        <div class="bar">
          <div class="bi">�� ����</div>
          <div class="shu"><input name="password" id="password" type="password" class="input01" value="" maxlength="18" style="width:160px" onfocus="inputVerify(this);" onblur="inputVerify(this);"></div>
        </div>
        <div class="bar">
          <div class="bi"> ��</div>
          <div class="shu">
          	<div class="tishi" id="passwd_tip" style="display: none;">������ʾ</div>          
          </div>
        </div>
        <div class="bar">
          <div class="bi">��֤��</div>
          <div class="shu"><input name="verifycode" id="randcode" type="text" class="input01" onfocus="this.select()" onclick="if(this.value=='�������Ҳ�����')this.value=''" onmouseover="this.focus()" onmouseout="if(this.value=='')this.value='�������Ҳ�����';" value="�������Ҳ�����" size="12" maxlength="4">
           <img name="verifyCodeImg" id="verifyCodeImg"  src="/qzkj/VerifyCodeServlet.action" style="padding:0 1px;width:70px" />
            <a href="javascript:void(0)" onclick="changeVerifyCode(document.getElementById('verifyCodeImg'))" class="link_lan">ˢ��</a>
          </div>
        </div>
        <div class="anniu">
            <input type="submit" value="" class="submitBtn">
        	<a href="/getPassword/index.shtm" style="text-decoration:underline;">�һ�����</a></div>
        <div class="anniu">��û��ע�᣿<a href="www/stuInfo/reg.jsp" class="link_ho">����ע��һ����</a></div>
        <div class="miao" style="display: none;">
          <div class="bao">�˻���ȫ����</div>
          <div class="con">��½�����������ĸ�����Ϣ�����������˻���<br><font class="color_qlan">����ͨ�����䡢���ʡ��˹���ʽ�һ�����</font></div>
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
		username_tip.innerHTML = "������ѧԱ���룡";
		username_tip.style.display = "block";
		passwd_tip.style.display = "none";
		userName.focus();
		return false;  
	}else if (isEmpty(passwd.value)){
		passwd_tip.innerHTML = "���������룡";
		username_tip.style.display = "none";
		passwd_tip.style.display = "block";
		passwd.focus();
		return false;  
	}else if (isEmpty(randcode.value) || randcode.value=="�������Ҳ�����"){	
		alert("Ϊ��֤���ѧԱ�˺ŵİ�ȫ�ԣ����ڡ���֤��������������Ҳ��4λ���֣�");
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
			username_tip.innerHTML = "������ѧԱ���룡";
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
			passwd_tip.innerHTML = "���������룡";
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

	//1�������<iframe>ʵ�֣������¼���<iframe>������
	//verifyCodeFrame.location.reload();

	//2�������<img>ʵ�֣����޸�<img src=url>��url
	//������һ��С���ɣ������url����ͬ��ֵ��������������·������������js����һ����ʱ��������url�еĲ���
	t = new Date().getTime();
	obj.src = "VerifyCodeServlet.action?t=" + t;
}	
</script>
<script language="javascript" for="document" event="onkeydown"> 

//�س���ť�¼�����  
if (event.keyCode == 13){  
	event.keyCode=0; 
	checkdata();
}  
</script>
  </body>
</html>
