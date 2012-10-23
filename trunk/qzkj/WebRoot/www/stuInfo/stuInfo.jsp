<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

<body onload="init()">
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
            	<li><a href="#">首页</a></li>
                <li><a href="entryStuInfo.do">设置</a></li>
                <li><a href="#">邮箱</a></li>
                <li><a href="#">账户</a></li>
                <li><a href="#">退出</a></li>
              
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
<DIV class=biao>我的题库<span><a href="#">返回首页</a></span></DIV>
</DIV>
<DIV class=er_text>

  <div id="TabbedPanels1" class="TabbedPanels">
    <ul class="TabbedPanelsTabGroup">
      <li class="TabbedPanelsTab" tabindex="0">个人资料修改</li>
      <li class="TabbedPanelsTab" tabindex="0">密码修改</li>
      <li class="TabbedPanelsTab" tabindex="0">密码修改</li>
    </ul>
    <div class="TabbedPanelsContentGroup">
      <div class="TabbedPanelsContent">
      	<DIV class=wdzh>
<DIV class=zan_w>为保证您的合法权益，请务必填写以下尽可能详细的真实个人信息，主要用于：<BR>　　 ·密码丢失后身份确认；<BR>　　 
·网校的学费确认；<BR>　　 ·网校<A class=link_lan href="http://member.chinaacc.com/shop/" 
target=_blank>财会书店</A>订购辅导书邮购等…… </DIV>
<DIV class="wdzl mt_10">
<DIV class=wdzl_tit>注册信息修改 </DIV>
<DIV class=wdzl_txt>
<DIV class=to>
<form id="form1" method="post" action="userEdit.do">
<DIV class=name>真实姓名：</DIV>
<DIV class=tc><INPUT class=input_zl value='${webuser.username}' maxLength=18 size=20 type=text 
name=wuser.username></DIV></DIV>
<DIV class=to>
<DIV class=name>Email：</DIV>
<DIV class=tc><INPUT id=email class=input_zl maxLength=50 value='${webuser.email}' size=40 type=text 
name=wuser.email></DIV></DIV>
<DIV class=to>
<DIV class=name>QQ号码：</DIV>
<DIV class=tc><INPUT id=qq class=input_zl maxLength=50 size=40 type=text value="${webuser.qq}"
name=wuser.qq></DIV></DIV>
<DIV class=to>
<DIV class=name>性&nbsp;&nbsp;&nbsp;&nbsp;别：</DIV>
<DIV class=tc>
<c:if test="${webuser.sex=='女'}">
<INPUT value=女 type=radio checked name=wuser.sex>女 <INPUT value=男  type=radio name=wuser.sex>男 
</c:if>
<c:if test="${webuser.sex=='男'}">
<INPUT value=女 type=radio  name=wuser.sex>女 <INPUT value=男  type=radio checked name=wuser.sex>男 
</c:if>
</DIV></DIV>
<DIV class=to>
<DIV class=name>出生日期：</DIV>
<DIV class=tc>
<select id="year1"  name=year></select>年 
<select id="month1" name=month onchange="selectedMonth(form1.month1.value,this.value)"></select>月
<select id="date1"  name=date></select> 日 
 </DIV></DIV>
<DIV class=to>
<DIV class=name>居住地区：</DIV>
<DIV class=tc><SELECT onchange="areaMap.city(this.value)" id="province" name=wuser.province></SELECT>省（直辖市） 
<SELECT id=city name=wuser.city> </SELECT>市（地区） </DIV></DIV>
<script>
		var areaMap = new AreaMap('province','city');
		var province='${webuser.province}';
		var city='${webuser.city}';
		if(province=="")
		{
        areaMap.province('请选择省份名','请选择城市名');
        }
		else
		{
		areaMap.province(province,city);
		}
</script>
<DIV class=to>
<DIV class=name>教育程度：</DIV>
<DIV class=tc><SELECT name=wuser.edulv>
<OPTION ${webuser.edulv=='1'?'selected':''} value=1>大专以下</OPTION> 
<OPTION ${webuser.edulv=='2'?'selected':''} value=2>大专</OPTION>
<OPTION ${webuser.edulv=='3'?'selected':''} value=3>本科</OPTION>
<OPTION ${webuser.edulv=='4'?'selected':''} value=4>本科以上</OPTION>
</SELECT></DIV></DIV>
<DIV class=to>
<DIV class=name>身份证号：</DIV>
<DIV class=tc><INPUT id=cardID value="${webuser.id}" class=input_zl maxLength=18 size=20 type=text 
name=wuser.id></DIV></DIV>
<DIV class=to>
<DIV class=name>工作单位：</DIV>
<DIV class=tc><INPUT class=input_zl value="${webuser.workFor}" maxLength=120 size=40 type=text 
name=wuser.workFor></DIV></DIV>
<DIV class=to>
<DIV class=name>通信地址：</DIV>
<DIV class=tc><INPUT class=input_zl maxLength=120 value="${webuser.postAddress}" size=40 type=text 
name=wuser.postAddress></DIV></DIV>
<DIV class=to>
<DIV class=name>邮政编码：</DIV>
<DIV class=tc><INPUT id=zipCode value="${webuser.postNo}" class=input_zl maxLength=6 size=20 type=text 
name=wuser.postNo></DIV></DIV>
<DIV class=to>
<DIV class=name>手机号码：</DIV>
<DIV class=tc><INPUT class=input_zl value="${webuser.tel}" maxLength=50 size=20 
type=text name=wuser.tel> <SPAN class=font_12><FONT class=color_cheng>*</FONT> 
强烈建议您认真填写手机号码，以便我们为您发送开课情况等提示短信！</SPAN></DIV></DIV>
<DIV class=to>
<DIV class=name>会计资质：</DIV>
<DIV class=tc>
<INPUT value=1 ${fn:indexOf(webuser.proSkill,'1')>-1?'checked':''} type=checkbox name=proSkill> 初级职称&nbsp;&nbsp; 
<INPUT value=2 ${fn:indexOf(webuser.proSkill,'2')>-1?'checked':''} type=checkbox name=proSkill> 中级职称&nbsp;&nbsp; 
<INPUT value=3 ${fn:indexOf(webuser.proSkill,'3')>-1?'checked':''} type=checkbox name=proSkill> 高级职称<BR>
<INPUT value=4 ${fn:indexOf(webuser.proSkill,'4')>-1?'checked':''} type=checkbox name=proSkill> 注册会计师
<INPUT value=5 ${fn:indexOf(webuser.proSkill,'5')>-1?'checked':''} type=checkbox name=proSkill> 注册评估师 
<INPUT value=6 ${fn:indexOf(webuser.proSkill,'6')>-1?'checked':''} type=checkbox name=proSkill> 注册税务师 
</DIV></DIV>
<DIV class="tong input_gg"></DIV>
<DIV class=to>
<DIV class=name>验&nbsp;证&nbsp;码：</DIV>
<DIV class=tc><INPUT id=check class=input_zl onfocus=this.select() 
onmouseover=this.focus() onMouseOut="if(this.value=='')this.value='请输入右侧数字';" 
onclick="if(this.value=='请输入右侧数字')this.value=''" value=请输入右侧数字 maxLength=4 
size=15 type=text name=verifycode> 
<img name="verifyCodeImg" id="verifyCodeImg" src="/qzkj/VerifyCodeServlet.action" style="cursor:hand" align="top" onClick="javascript:changeVerifyCode()"/>
 <SPAN class=font_12><FONT 
class=color_cheng>*</FONT> 点击图片刷新验证码 <FONT class=color_cheng>*</FONT></SPAN> 
</DIV></DIV>
<DIV class=to>
<DIV class=name>　</DIV>
<DIV class=tc>
<A href="javascript:if(checkdata()){document.getElementById('form1').submit();}"><IMG src="images/tj2.gif"></A> 
<A href="javascript:document.getElementById('memberform').reset();"><IMG src="images/cz2.gif"></A> 
</DIV></DIV></DIV></DIV></DIV>
 </form>     
      
      
 
      
      
      
      
      
      
      
      
      </div>
      <div class="TabbedPanelsContent">
      	<DIV class=wdzh>
<DIV class=zan_w>为了您的个人帐户安全，建议您定期更改您的密码！</DIV>
<DIV class="wdzl mt_10">
<DIV class=wdzl_tit>修改密码</DIV>
<DIV class=wdzl_txt>
<DIV class=to>
<DIV class=name>旧密码：</DIV>
<DIV class=tc><INPUT id=oldPassword class=input_zl tabIndex=1 size=20 
type=password name=oldPassword> 请填写正确的旧密码 </DIV></DIV>
<DIV class="tong input_gg"></DIV>
<DIV class=to>
<DIV class=name>新密码：</DIV>
<DIV class=tc><INPUT id=newPassword class=input_zl tabIndex=2 
onkeyup=chkpassw(value.length) size=20 type=password name=newPassword> 
由4至15位数字和字母组成</DIV></DIV>
<DIV class=to>
<DIV class=name>确认新密码：</DIV>
<DIV class=tc><INPUT id=newPassword1 class=input_zl tabIndex=3 
onkeyup=chkpassw(value.length) size=20 type=password name=newPassword1> 
重复输入新密码</DIV></DIV>
<DIV class=to>
<DIV class=name>验证码：</DIV>
<DIV class=tc><INPUT id=validateNumber class=input_zl onfocus=this.select() 
onmouseover=this.focus() tabIndex=5 
onmouseout="if(this.value=='')this.value='请输入右侧数字';" 
onclick="if(this.value=='请输入右侧数字')this.value=''" value=请输入右侧数字 maxLength=4 
size=15 type=text name=validateNumber> <IMG 
onclick="javascript:var date=new Date();this.src='/jsp/image.jsp?VIName=updatePasswd&amp;num='+Date.parse(date);" 
src="images/image(1).jpg"> <SPAN class=font_12><FONT 
class=color_cheng>*</FONT> 点击图片刷新验证码 <FONT class=color_cheng>*</FONT></SPAN> 
</DIV></DIV>
<DIV class=to>
<DIV class=name>　</DIV>
<DIV class=tc><A 
href="javascript:if(checkPasswordData()){document.getElementById('passwd').submit();}"><IMG 
src="images/tj2.gif"></A> 　　<A 
href="javascript:document.getElementById('passwd').reset();"><IMG 
src="images/cz2.gif"></A> <INPUT value=31259736 type=hidden 
name=uid> <INPUT value=zhujiang0006 type=hidden name=userName> 
</DIV></DIV></DIV></DIV></DIV>
      
      
      
      
      
      
      
      
      
      
      
      
      </div>
       <div class="TabbedPanelsContent">
       		<DIV class=wdzh>
<TABLE style="MARGIN-TOP: 15px" class=backcolor3 border=0 cellSpacing=1 
cellPadding=6 width=700 align=center>
  <TBODY>
  <TR>
    <TD class=backcolor8>
      <FORM id=uploadForm method=post name=iconform 
      action=/myhome/myInfo/updateUsericon.shtm>
      <TABLE border=0 cellSpacing=0 cellPadding=0 width=600 align=center>
        <TBODY>
        <TR>
          <TD style="PADDING-BOTTOM: 10px; PADDING-TOP: 10px" class=font14 
          height=40>我的昵称：<LABEL> <INPUT id=nickName maxLength=16 type=text 
            name=nickName> <INPUT id=nickName_old type=hidden name=nickName_old> 
            <INPUT id=nickName_old 
            value=http://img.cdeledu.com/ADVC/2009/1119/1258620743934-0.jpg 
            type=hidden name=newicon_old> </LABEL></TD></TR>
        <TR>
          <TD style="PADDING-BOTTOM: 10px; PADDING-TOP: 10px" class=font14 
          height=80>您的头像： <IMG 
            style="BORDER-BOTTOM: #dddddd 1px solid; BORDER-LEFT: #dddddd 1px solid; PADDING-BOTTOM: 2px; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; BORDER-TOP: #dddddd 1px solid; BORDER-RIGHT: #dddddd 1px solid; PADDING-TOP: 2px" 
            id=usericon src="images/man1.gif" width=111 
            height=111><INPUT id=iconUrl type=hidden name=iconUrl></TD></TR>
        <TR>
           <TD class=font14 height=40>
          上传控件
          
          
          </TD></TR>
        <TR>
          <TD height=50><LABEL><SPAN><A 
            href="javascript:document.getElementById('uploadForm').submit();"><IMG 
            src="images/bcsz.gif"></A> <INPUT value=1 type=hidden 
            name=s> <INPUT type=hidden name=classid> <INPUT value=31259736 
            type=hidden name=uid> <INPUT value=zhujiang0006 type=hidden 
            name=userName> <INPUT type=hidden name=userID> 
        </SPAN></LABEL></TD></TR></TBODY></TABLE></FORM></TD></TR></TBODY></TABLE></DIV>
       
       
       
       
       
       </div>
    </div>
  </div>
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
