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
    <td><img src="images/btn_03.jpg" width="58" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_05.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_07.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_09.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_11.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_13.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
  </tr>
</table>

        
        
        
        
        
        </div><!--btnx����-->
    
    
    
    </div><!--topflash����-->
    
    <div class="clear"></div>
      
      <div id="menu">
		<ul>
		  <li><span>����ѧԱ��Ϣע��</span></li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
		</ul>
        
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    <div id="main"><!--�м俪ʼ-->
    <form method="post" action="<%=basePath%>regUser.do" id="form1" onsubmit="return checkdata()">
    	<div id="reg" ><!--���-->
        	<div class="maintop">
        		<div class="left">
        		<img src="images/ft1.gif"/>
        		</div>
        		<div class="right" >
        		������Ѿ������ǵ�ѧԱ����ֱ��&nbsp;<a href="wlogin.do">��¼</a>
        		</div>
        	</div>	
        	<div class="conter mid">
        	<dl>
            	<dt>ѧԱ���룺</dt>
                <dd>
                	<input name="account" type="text" maxlength="20" id="account" value="${account}" tabindex="1" onblur="checkMember()"><span id="userNameOk"  style="display: none;"><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="report" ></div></div>
                </dd>  
                <dd class="crt hui">4-20���ַ�������Ϊ��ĸ�����ֻ��»���'_'�����ܰ����ո񣩣�<br>һ��ע��ɹ����û��������޸ġ�</dd>              
            </dl>
        	</div>
         	<div class="conter mid">
        	<dl>
            	<dt>��&nbsp;&nbsp;&nbsp;&nbsp;�룺</dt>
                <dd>
                	<input name="password" type="text" maxlength="20" id="password" tabindex="2" onblur="checkMsg(2,0)"><span id="passwordOk" class="martop6" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportPassword" ></div></div>
                </dd>  
                <dd class="crt hui martop6">������4��15λ���ֻ���ĸ��ɡ�</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>ȷ�����룺</dt>
                <dd>
                	<input name="rePassword" type="text" maxlength="20" id="rePassword" tabindex="3" onblur="checkMsg(3,0)"><span id="rePasswordOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportRePassword"></div></div>
                </dd>  
                <dd class="crt hui martop6">��������һ����������������롣</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>��ʵ������</dt>
                <dd>
                	<input name="username" type="text" maxlength="20" id="username" tabindex="4" onblur="checkMember()"><span id="userNameOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportusername" ></div></div>
                </dd>  
                <dd class="crt hui"></dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>��&nbsp;��&nbsp;�ţ�</dt>
                <dd>
                	<input name="tel" type="text" maxlength="20" id="tel" tabindex="5" onblur="checkMsg(6,0)"><span id="reportMobileOk" class="martop6" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportMobile" ></div></div>
                </dd>  
                <dd class="crt hui martop6" style="color: #C92525;">���һ����뼫Ϊ��Ҫ����������д���μǣ����õı��������ʺŰ�ȫ��</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>�������䣺</dt>
                <dd>
                	<input name="email" type="text" maxlength="20" id="email" tabindex="6" onblur="checkMsg(7,0)"><span id="reportMailOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportMail" ></div></div>
                </dd>  
                <dd class="crt hui martop6">(ѡ����)����ʵ��д</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>QQ���룺</dt>
                <dd>
                	<input name="qq" type="text" maxlength="20" id="qq" tabindex="7" onblur="checkMsg(8,0)"><span id="reportQQOk" style="display: none; "><img class="martop6" src="images/ok.gif"></span>
                	<div class="h25"><div id="reportQQ" ></div></div>
                </dd>  
                <dd class="crt hui martop6">(ѡ����)����ʵ��д</dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        	<dl>
            	<dt>��&nbsp;֤&nbsp;�룺</dt>
                <dd style="width:80px">
                	<input name="verifycode" type="text" maxlength="20" id="validateNumber" style="width: 70px;" tabindex="7" onblur="checkMsg(4,0)">
                	<c:if test="${smsg=='false'}">
                	<div class="h25"><div id="reportRandcode" class="note">��֤�����!</div></div>
                	</c:if>
                	<c:if test="${smsg!='false'}">
                	<div class="h25"><div id="reportRandcode" ></div></div>
                	</c:if>
                </dd>
                <dd style="width: 120px">
                <img name="verifyCodeImg" id="verifyCodeImg"  src="/qzkj/VerifyCodeServlet.action"  align="top" />
                </dd>  
                <dd class="crt hui martop6"><a href="javascript:changeVerifyCode(document.getElementById('verifyCodeImg'))">�����壿��һ��</a></dd>              
            </dl>
        	</div>
        	<div class="conter mid">
        		<div style="float: left">
        		<input type="image" src="images/kszhuce.gif" onclick="javascript:document.form1.submit()" style="border:none; margin-left:70px; width:132px; height:30px" tabindex="8">
        		<input id="article" tabindex="9" type="checkbox" checked name="article" style="width:auto; border:none;margin-bottom: 5px">
        		</div>
        		<div style="display:inline; float:right; padding-right:194px; padding-top:11px; _padding-top:15px;">�����Ķ�������
		        <a id="articleHtml" tabindex="7" href="http://www.chinaacc.com/register/termsOfServices.shtml" target="_blank">�л������У��������</a>
		         
		        <div id="reportArticle" class="note" style="display: none">���Ķ������ܷ�������</div> 
	        </div>
        	</div>
        </div><!--������-->
   
    </form>
    </div><!--�м俪ʼ����-->
    <script src="js/reg_check.js" type="text/javascript"  ></script>
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>��Ȩ���У�Ϋ�������ɹ�<br>
            ����֧�֣�Ϋ���в��ſƼ����޹�˾
        </p>
    
    
    
    </div>
</body>
</html>
