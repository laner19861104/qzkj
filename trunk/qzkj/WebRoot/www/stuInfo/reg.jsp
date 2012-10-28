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
<base href="<%=basePath+"www/stuInfo/"%>">
<script type="text/javascript" src="<%=basePath%>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>

<link href="css/gong.css" rel="stylesheet" type="text/css" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="topflash"> 
    	<div class="btn">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="images/btn_03.jpg" width="58" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_05.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_07.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_09.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_11.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_13.jpg" width="57" height="46" alt="在线客服" /></td>
  </tr>
</table>

        
        
        
        
        
        </div><!--btnx结束-->
    
    
    
    </div><!--topflash结束-->
    
    <div class="clear"></div>
      
      <div id="menu">
		<ul>
		  <li><span>◎新学员信息注册</span></li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
		</ul>
        
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    <div id="main"><!--中间开始-->
    <form method="post" action="<%=basePath%>regUser.do" id="form1" onsubmit="return checkdata()">
    	<div id="reg" ><!--左侧-->
        	<div class="maintop">
        		<div class="left">
        		<img src="images/ft1.gif"/>
        		</div>
        		<div class="right" >
        		如果您已经是我们的学员，请直接&nbsp;<a href="wlogin.do">登录</a>
        		</div>
        	</div>	
        	<div class="conter mid">
        	<dl>
            	<dt>学员代码：</dt>
                <dd>
                	<input name="account" type="text" maxlength="20" id="account" value="${account}" tabindex="1" onblur="checkMember()"><span id="userNameOk"  style="display: none;"><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="report" ></div></div>
                </dd>  
                <dd class="crt hui">4-20个字符（可以为字母、数字或下划线'_'，不能包含空格），<br>一旦注册成功，用户名不能修改。</dd>              
            </dl>
        	</div>
         	<div class="conter mid">
        	<dl>
            	<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码：</dt>
                <dd>
                	<input name="password" type="text" maxlength="20" id="password" tabindex="2" onblur="checkMsg(2,0)"><span id="passwordOk" class="martop6" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportPassword" ></div></div>
                </dd>  
                <dd class="crt hui martop6">密码由4～15位数字或字母组成。</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>确认密码：</dt>
                <dd>
                	<input name="rePassword" type="text" maxlength="20" id="rePassword" tabindex="3" onblur="checkMsg(3,0)"><span id="rePasswordOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportRePassword"></div></div>
                </dd>  
                <dd class="crt hui martop6">请再输入一遍您上面输入的密码。</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>真实姓名：</dt>
                <dd>
                	<input name="username" type="text" maxlength="20" id="username" tabindex="4" onblur="checkMember()"><span id="userNameOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportusername" ></div></div>
                </dd>  
                <dd class="crt hui"></dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>手&nbsp;机&nbsp;号：</dt>
                <dd>
                	<input name="tel" type="text" maxlength="20" id="tel" tabindex="5" onblur="checkMsg(6,0)"><span id="reportMobileOk" class="martop6" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportMobile" ></div></div>
                </dd>  
                <dd class="crt hui martop6" style="color: #C92525;">对找回密码极为重要，请慎重填写并牢记，更好的保护您的帐号安全！</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>电子邮箱：</dt>
                <dd>
                	<input name="email" type="text" maxlength="20" id="email" tabindex="6" onblur="checkMsg(7,0)"><span id="reportMailOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportMail" ></div></div>
                </dd>  
                <dd class="crt hui martop6">(选择项)请如实填写</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>QQ号码：</dt>
                <dd>
                	<input name="qq" type="text" maxlength="20" id="qq" tabindex="7" onblur="checkMsg(8,0)"><span id="reportQQOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportQQ" ></div></div>
                </dd>  
                <dd class="crt hui martop6">(选择项)请如实填写</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>验&nbsp;证&nbsp;码：</dt>
                <dd style="width:80px">
                	<input name="verifycode" type="text" maxlength="20" id="validateNumber" style="width: 70px;" tabindex="7" onblur="checkMsg(4,0)">
                	<c:if test="${smsg=='false'}">
                	<div class="h25"><div id="reportRandcode" class="note">验证码错误!</div></div>
                	</c:if>
                	<c:if test="${smsg!='false'}">
                	<div class="h25"><div id="reportRandcode" ></div></div>
                	</c:if>
                </dd>
                <dd style="width: 120px">
                <img name="verifyCodeImg" id="verifyCodeImg"  src="/qzkj/VerifyCodeServlet.action"  align="top" />
                </dd>  
                <dd class="crt hui martop6"><a href="javascript:changeVerifyCode(document.getElementById('verifyCodeImg'))">看不清？换一张</a></dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        		<div style="float: left">
        		<input type="image" src="images/kszhuce.gif" onclick="javascript:document.form1.submit()" style="border:none; margin-left:70px; width:132px; height:30px" tabindex="8">
        		<input id="article" tabindex="9" type="checkbox" checked name="article" style="width:auto; border:none;margin-bottom: 5px">
        		</div>
        		<div style="display:inline; float:right; padding-right:194px; padding-top:11px; _padding-top:15px;">我已阅读并接受
		        <a id="articleHtml" tabindex="7" href="http://www.chinaacc.com/register/termsOfServices.shtml" target="_blank">中华会计网校服务条款</a>
		         
		        <div id="reportArticle" class="note" style="display: none">请阅读并接受服务条款</div> 
	        </div>
        	</div>
        </div><!--左侧结束-->
   
    </form>
    </div><!--中间开始结束-->
    <script src="js/reg_check.js" type="text/javascript"  ></script>
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>版权所有：潍坊政府采购<br>
            技术支持：潍坊中财信科技有限公司
        </p>
    
    
    
    </div>
</body>
</html>
