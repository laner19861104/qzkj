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
<script src="js/city.js" type="text/javascript"></script>
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
 
    	<div id="reg" ><!--左侧-->
        	<div class="maintop">
        	<div class="left">
        		<img src="images/ft3.gif"/>
        		</div>
            </div>
            <div class="zhuce mid">
        	<div class="zhuceok">
            <input type="button" value="免费试听" class="butom" onclick="window.open('list.html');">
            　　<input type="button" value="选购课程" class="butom" onclick="window.open('http://member.chinaacc.com/selectcourse/index.shtm');">
            </div>
        </div>
        <div class="zhuceft" style="margin-left:auto; margin-right:auto;"><span class="hui">您还可以去：</span>
    	<a href="index.do" style="color:#3F3F3F">网校首页</a>　
    	<a href="s_center.jsp">我的网校我的家</a>　
    	<br>
    	<span class="f12" style="color:#3F3F3F">提示信息</span></a> </span>
        </div>
        </div><!--左侧结束-->

    </div><!--中间开始结束-->
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>版权所有：潍坊政府采购<br>
            技术支持：潍坊中财信科技有限公司
        </p>
    
    
    
    </div>
</body>
</html>
