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
<title>个人信息</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/geren.css" rel="stylesheet" type="text/css" />
<link href="css/index_01.css" rel="stylesheet" type="text/css" />

<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<script src="js/datepicker.js" type="text/javascript"></script>
<script src="js/city.js" type="text/javascript"></script>
</head>

<body >
	<div id="ren_top"> 
    	<div id="menu_1">
       		<ul>
            	<li><a href="#">职业评测</a></li>
                <li><a href="#">职业评测</a></li>
                <li><a href="#">职业评测</a></li>
                <li><a href="#">职业评测</a></li>
                <li><a href="#">职业评测</a></li>
              
            </ul>	
        
      </div><!--menu结束-->
         <div class="menu_right">
         	<ul>
            	<li><a href="index.do">首页</a></li>
                <li><a href="entryStuInfo.do">设置</a></li>
                <li><a href="#">邮箱</a></li>
                <li><a href="entryAccount.do">账户</a></li>
                <li><a href="javascript:location.href='reLogin.do'">退出</a></li>
              
            </ul>
         </div> 
        
        
        
        
        
        
        
      
    
    
    
    </div><!--ren_top结束-->
    
    <div class="clear mt8"></div>
      
       
	
    
    
    <div id="main"><!--中间开始-->
    		<div class="position">
		
			 <h2> 亲爱的 ${webuser.account}，您好！欢迎回家，好好学习吧！ <a href="#">[退出]</a></h2>
             <div class="search">
        	<select name="">
        	  <option value="课程">课程</option>
        	</select>
        	<input name="" type="text" style="height:18px;"/>
        <img src="images/19.gif" width="43" alt="搜索" style="margin-top:3px;"/></div><!--search结束-->
		   </div> <!--end position-->
            <div class="clear mt8"></div>
           
           <table width="960" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                    <fieldset >
                    	<div class="w200">
                        	<DIV class=left_menu_fu>
<DIV class=text>
<DIV class=din>
<UL>
  <LI><IMG src="images/nav_21.gif"><A 
  href="#" target=_blank>互助答疑</A></LI>
  <LI><IMG src="images/nav_11.gif"><A 
  href="#">税务/会计会员</A></LI>
  <LI><IMG src="images/nav_15.gif"><A 
  href="#" target=_blank>梦想成真专区</A></LI>
  <LI><IMG src="images/nav_07.gif"><A 
  href="#" target=_blank>每日一练</A></LI>
  <LI><IMG src="images/nav_08.gif"><A 
  href="#">订阅服务</A></LI>
  <LI><IMG src="images/nav_09.gif"><A 
  href="#" 
  target=_blank>考试周刊</A></LI>
  <LI><IMG src="images/nav_19.gif"><A 
  href="#" 
  target=_blank>《财税资讯》月刊</A></LI>
  <LI><IMG src="images/nav_18.jpg"><A 
  href="#" target=_blank>新师资评价</A></LI>
  <LI><IMG src="images/nav_10.gif"><A 
  href="#" 
  target=_blank>网上支付</A></LI>
  <LI><IMG src="images/liwu.gif"><A 
  href="#">网校赠送活动</A></LI>
  <LI><IMG src="images/nav_18.jpg"><A onclick=tzzhuye(); 
  href="#">高会论文班</A></LI>
  <SCRIPT>
			         function tzzhuye(){
			        	 alert("你好,你还没有选课不能操作此项功能！");
			      }
			</SCRIPT>
</UL></DIV><!-- 
          <div class="tian">
            <a href="http://java.chinaacc.com/usercenter/tjzj.shtml"><img src="/images/userhome/01/tian.gif" />添加组件</a>
          </div>  --></DIV>
<DIV class=zxkf><img src="images/zxkf.jpg" width="154" height="126" alt="呼叫客服" /></DIV>
<DIV class=zxkf><IMG 
src="images/left_menu_dpic.gif"></DIV></DIV>
                        
                        
                        
                        </div><!--w200结束-->
                        <div class="w730">
                    
                            <div class="w521">
                            	<DIV class=main_box>
<DIV class=er_title>

<DIV class=er_text>
亲爱的 ，修改成功！<a href="javascript:location.href='entryStuInfo.do'">返回个人中心</a>

</DIV></DIV>
                            
                            </div><!--w521结束-->
                    
                    
                    		
                    
                    
                   	  </div><!--w730结束-->
                    
                    
                    
                    
                    </fieldset>
                    
                    
                    
                    
                    
                    
                    </td>
                  </tr>
      </table>

           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
    
    
	</div><!--中间开始结束-->
    
    <div class="clear mt8"></div>
<div id="foot">
    	<p>版权所有：潍坊政府采购<br>
            技术支持：潍坊中财信科技有限公司
        </p>
    
    
    
    </div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
    </script>
</body>
</html>
