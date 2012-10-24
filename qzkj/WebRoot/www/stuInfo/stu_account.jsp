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
<title>账户信息</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/geren.css" rel="stylesheet" type="text/css" />
<link href="css/index_01.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<script src="js/ajax.util.js" type="text/javascript"  ></script>
<script>
account='${webuser.account}'
</script>
</head>
<body>
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
<DIV class=biao>我的账户<span><a href="#">返回首页</a></span></DIV>
</DIV>
<DIV class=er_text>

  <div id="TabbedPanels1" class="TabbedPanels">
    <ul class="TabbedPanelsTabGroup">
      <li class="TabbedPanelsTab" tabindex="0">累计</li>
      <li class="TabbedPanelsTab" tabindex="0">账户余额</li>
      <li class="TabbedPanelsTab" tabindex="0">学习卡</li>
      <li class="TabbedPanelsTab" tabindex="0" onclick="getPayRecord(1)">充值</li>
       <li class="TabbedPanelsTab" tabindex="0">交费记录</li>
    </ul>
    <div class="TabbedPanelsContentGroup">
      <div class="TabbedPanelsContent">
      	<DIV class=text>
            <DIV class=wdzh>
            <DIV class=wdzl_tit>累计交费金额查询</DIV>
            <DIV class=tong>
            <DIV class=hui_box>
            <DIV class="hui_cont ">
            <DIV class=chong><BR><BR>您累计交费金额：<SPAN class=color_cheng>${totalPay}</SPAN> 
            元<BR><BR><BR></DIV></DIV></DIV></DIV>
            </DIV></DIV>
      
      
      
      </div>
      <div class="TabbedPanelsContent">
      	<DIV class=text>
            <DIV class=wdzh>
            <DIV class=wdzl_tit>账户余额</DIV>
            <DIV class=tong>
            <DIV class=hui_box>
            <DIV class="hui_cont ">
            <DIV class="chong mt_10">
            <DIV class=shu>您的现金帐户余额为： <SPAN class=color_lv>${webuser.money}</SPAN> 元</DIV>
            <DIV class=ch><A 
            href="http://member.chinaacc.com/selectcourse/selectPayStyle.shtm"><IMG 
            src="images/xj.gif"></A></DIV></DIV>
            <DIV class=chong>
            <DIV class=shu>您的学习卡帐户余额为： <SPAN class=color_lv>0</SPAN> 元</DIV>
            <DIV class=ch><A 
            href="http://member.chinaacc.com/myhome/account/payinto.shtm"><IMG 
            src="images/xxk.gif"></A></DIV></DIV>
            <DIV class=chong>
            <DIV class=shu>您的从业卡帐户余额为： <SPAN class=color_lv>0</SPAN> 元</DIV>
            <DIV class=ch><A 
            href="http://member.chinaacc.com/myhome/account/payinto.shtm"><IMG 
            src="images/cyk.gif"></A></DIV></DIV></DIV></DIV></DIV>
            </DIV></DIV>
      </div>
       <div class="TabbedPanelsContent">
       		<DIV class=text>
                <DIV class=wdzh>
                <DIV class=tong>
                <DIV class=wdzl_tit  left>学习卡充值</DIV>
                <DIV class="left zhi_40">　　<A href="#" >学习卡支付</A></DIV>
                <DIV class="right font_14 zhi_40">可用学习卡余额：<SPAN class=color_lv>0</SPAN> 
                元</DIV></DIV>
                <DIV class=tong>
                <DIV class=hui_box>
                <DIV class="hui_cont ">
                <DIV class=chong_zhi>
                <FORM method=post name=account_form action=/myhome/account/check.shtm>
                <DIV class=sz>充值：<INPUT id=cardID class=input_chong maxLength=20 size=30 
                type=text name=cardID></DIV>
                <DIV class=ks><input name="" type="submit" value="提交" /> 
                </DIV></FORM></DIV>
                <DIV 
                class=chong_zy><SPAN>注意：</SPAN><BR>1、输入卡号时，请注意区分大小写！<BR>2、为保障您的听课安全，请务必通过本网公布的正规渠道购卡并自行注册、充值！<BR>3、请务必不要从别人那里(包括互联网)直接购买学习卡帐号或密码，以免上当受骗！<BR>4、请务必不要将您的学员代码和密码告诉他人，不要轻信他人代为充值！ 
                </DIV></DIV></DIV></DIV>
                </DIV></DIV>
       
       </div>
       
       
       
       <div class="TabbedPanelsContent">
       		<DIV class=text>
                <DIV class=wdzh>
                <DIV class=tong>
                <DIV class=wdzl_tit>充值记录及发票申请情况</DIV></DIV>
                <DIV class=jfjl>
                <DIV class=bt>
                <DIV class=fp_box01>充值号</DIV>
                <DIV class="fp_box02 text_center">充值金额(元)</DIV>
                <DIV class="fp_box02 text_center">充值时间</DIV>
                <DIV class="fp_box02 text_center">充值状态</DIV>
                <DIV class="fp_box02 text_center">付款方式</DIV>
               </DIV>
                <DIV class=nr>
                <UL></UL></DIV>
                <div id="plist">
               
               </div>
                <div id="pfoot">
               
               </div>
                
                </DIV>
                
                </DIV></DIV>
       </div>
       
       
       
       <div class="TabbedPanelsContent">
       		<DIV class=text>
                <DIV class=wdzh>
                <DIV class=tong>
                <DIV class=wdzl_tit>交费记录查询</DIV></DIV>
                <DIV class=jfjl>
                <DIV class=bt>
                <DIV class=jf_box02>交费号</DIV>
                <DIV class=jf_box01>课程（商品）名称</DIV>
                <DIV class="jf_box02 text_center">交费金额</DIV>
                <DIV class="jf_box02 text_center">交费方式</DIV>
                </DIV>
                <DIV class=nr>
                <UL></UL></DIV>
                <DIV class="zan_w mt_10">您好，暂无记录！</DIV>
                </DIV></DIV></DIV>
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

