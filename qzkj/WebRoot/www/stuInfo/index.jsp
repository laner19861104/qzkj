<%@ page language="java" import="java.util.*,com.bip.sys.course.po.*" pageEncoding="gb2312"   contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<JocSubject> subjectlist = (List<JocSubject>)request.getAttribute("subjectlist");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>奇正会计培训网校</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="topflash">
  <div class="btn">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/btn_03.jpg" width="58" height="46" alt="在线客服" /></td>
        <c:if test="${webuser==null}">
        <td><a href="wlogin.do"><img src="images/btn_055.jpg" width="57" height="46" alt="登录" /></a></td>
        </c:if>
        <c:if test="${webuser!=null}">
        <td><a href="entryStuInfo.do"><img src="images/btn_05.jpg" width="57" height="46" alt="我的帐户" /></a></td>
        </c:if>
        <td><img src="images/btn_07.jpg" width="57" height="46" alt="选课清单" /></td>
        <td><img src="images/btn_09.jpg" width="57" height="46" alt="帮助中心" /></td>
        <td><img src="images/btn_11.jpg" width="57" height="46" alt="去书店" /></td>
        <td><img src="images/btn_13.jpg" width="57" height="46" alt="会计网校" /></td>
      </tr>
    </table>
  </div>
  <!--btnx结束--> 
  
</div>
<!--topflash结束-->

<div class="clear"></div>
<div id="menu">
  <ul>
    <li><a href="index.do">首页</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu1">促销课程</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu2">热销课程</a></li>
    <li><a href="zhongbiao.html?a=招标公告" rel="dropmenu3">增值服务</a></li>
  </ul>
  <div class="search">
    <select name="">
      <option value="课程">课程</option>
    </select>
    <input name="" type="text" />
    <img src="images/19.gif" width="43" height="20" alt="搜索" /></div>
  <!--search结束--> 
</div>
<!--end menu--> 

<!--end menu-->
<div class="clear"></div>
<div id="main"><!--中间开始-->
  <div id="left" ><!--左侧-->
    <div class="department"><!--课程-->
      <h1>全部课程<span><a href="list.do" target="_blank">更多>></a></span></h1>
      <div class="news">
        <ul>
          <%for(JocSubject s : subjectlist) { %>
          <li><a href="list.do?subject=<%=s.getCode() %>" target="_blank"><%=s.getName() %></a></li>
          <%} %>
        </ul>
      </div>
    </div>
    <!--课程结束--> 
    
  </div>
  <!--左侧结束-->
  <div id="right">
    <div class="zuo">
      <div class=box >
        <div class=boxpadding>
          <div id=Slide> <img id=focpic style="FILTER: RevealTrans(duration=1;ransition=12); VISIBILITY: visible; POSITION: absolute; left:484; top:94" 
            src="images/wall1.jpg"  width="534" height="176" />
            <div class=thumb_title id=foctitle></div>
            <div id=Slide_Thumb>
              <div class=thumb_on id=tmb0 onmouseover=setfoc(0); onmouseout=playit();> <img  src="images/wall1.jpg" /></div>
              <div class=thumb_off id=tmb1 onmouseover=setfoc(1); onmouseout=playit();> <img src="images/wall2.jpg" /></div>
              <div class=thumb_off id=tmb2 onmouseover=setfoc(2); onmouseout=playit();> <img  src="images/wall3.jpg" /></div>
              <div class=thumb_off id=tmb3 onmouseover=setfoc(3); onmouseout=playit();> <img  src="images/wall4.jpg" /></div>
              <script language=javascript type=text/javascript>
var picarry = {};
var lnkarry = {};
var ttlarry = {};
picarry[0] = "images/wall1.jpg";
lnkarry[0] = "/";
ttlarry[0] = "图一";
picarry[1] = "images/wall2.jpg";
lnkarry[1] = "/";
ttlarry[1] = "图二";
picarry[2] = "images/wall3.jpg";
lnkarry[2] = "/";
ttlarry[2] = "图三";
picarry[3] = "images/wall4.jpg";
lnkarry[3] = "/";
ttlarry[3] = "图四";

      </script> 
            </div>
          </div>
        </div>
      </div>
      <SCRIPT type=text/javascript>
var currslid = 0;
var slidint;
function setfoc(id){
	document.getElementById("focpic").src = picarry[id];
	
	
	currslid = id;
	for(i=0;i<4;i++){
		document.getElementById("tmb"+i).className = "thumb_off";
	};
	document.getElementById("tmb"+id).className ="thumb_on";
	focpic.style.visibility = "hidden";
	focpic.filters[0].Apply();
	if (focpic.style.visibility == "visible") {
		focpic.style.visibility = "hidden";
		focpic.filters.revealTrans.transition=23;
	}
	else {
		focpic.style.visibility = "visible";
		focpic.filters[0].transition=23;
	}
	focpic.filters[0].Play();
	stopit();
}

function playnext(){
	if(currslid==3){
		currslid = 0;
	}
	else{
		currslid++;
	};
	setfoc(currslid);
	playit();
}
function playit(){
	slidint = setTimeout(playnext,6000);
}
function stopit(){
	clearTimeout(slidint);
	}
window.onload = function(){
	playit();
}</SCRIPT>
      <div class="clear mt8"></div>
      <div class="new zhong_box"><!--采购开始-->
        <h2>采购程序<span><a href="#">更多>></a></span></h2>
        <table border="0" cellspacing="0" cellpadding="0"  class="list" >
          <tr>
            <th>课程名称</th>
            <th>原价</th>
            <th>促销价</th>
            <th>购买</th>
          </tr>
          <tr>
            <td class="zhong_zuo">［促销］2013年考研数长线包过</td>
            <td>2800</td>
            <td>2350</td>
            <td><img src="images/mai_19.jpg" width="46" height="19" alt="购买" /></td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <!--采购结束-->
      <div class="clear mt8"></div>
      <div class="new zhong_box"><!--采购开始-->
        <h2>采购程序<span><a href="#">更多>></a></span></h2>
        <table width="98%" border="0" cellspacing="0" cellpadding="0"  class="list" >
          <tr>
            <th>课程名称</th>
            <th>原价</th>
            <th>促销价</th>
            <th>购买</th>
          </tr>
          <tr>
            <td class="zhong_zuo">［促销］2013年考研数长线包过</td>
            <td>2800</td>
            <td>2350</td>
            <td><img src="images/mai_19.jpg" width="46" height="19" alt="购买" /></td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <!--采购结束-->
      
      <div class="clear mt8"></div>
      <div class="tese zhong_box"><!--采购开始-->
        <h2>教学特色<span><a href="#">更多>></a></span></h2>
        <table width="98%" border="0" cellspacing="0" cellpadding="0" class="list1">
          <tr>
            <td width="17%"  valign=top><img src="images/btn1.jpg" width="72" height="18" alt="特色班" /></td>
            <td width="83%" class="line_height">经典班次科学搭配经典班次科学搭配经典班次科学经典班次科学搭配经典班次科学搭配经典班次科学搭配搭配</td>
          </tr>
          <tr>
            <td  valign=top><img src="images/btn2.jpg" width="72" height="18" alt="特色班" /></td>
            <td class="line_height">郑重承诺:经典班次科学搭配经典班次科学搭配经典班次科学搭配郑重承诺:经典班次科学搭配经典班次科学搭配经典班次科学搭配</td>
          </tr>
          <tr>
            <td valign=top><img src="images/btn3.jpg" width="72" height="18" alt="特色班" /></td>
            <td class="line_height">郑重承诺:经典班次科学搭配经典班次科学搭配经典班次郑重承诺:经典班次科学搭配经典班次科学搭配经典班次</td>
          </tr>
        </table>
      </div>
    </div>
    <!--zuo结束-->
    
    <div class="w203">
      <div class="canyu right_box">
        <h3>公众参与<span><a href="#">更多>></a></span></h3>
        <div class="main_new">
          <ul>
            <li><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><a href="#"> 立即参与 </a> </li>
          </ul>
        </div>
      </div>
      <!--canyu right_box结束-->
      
      <div class="clear mt8"></div>
      <div class="c_zhi  right_box">
        <h3>快速充值</h3>
        <div class="ka"> 卡号:
          <input name="" type="text" />
          <input name="" type="submit" value="立即充值" style="margin-left:50px;margin-top:10px;"/>
        </div>
      </div>
      <!--c_zhi结束-->
      
      <div class="clear mt8"></div>
      <div class="canyu right_box" style="height:200px;">
        <h3>增值服务<span><a href="#">更多>></a></span></h3>
        <div class="main_new">
          <ul>
            <li><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><a href="#"> 立即参与 </a> </li>
            <li><a href="#"> 立即参与 </a> </li>
          </ul>
        </div>
      </div>
      <div class="clear mt8"></div>
      <div class="shuzi right_box" >
        <h3>增值服务<span><a href="#">更多>></a></span></h3>
        <div class="shuzi_new">
          <ul>
            <li><img src="images/n1.gif" width="13" height="11" alt="1" /><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><img src="images/n2.gif" width="13" height="11" alt="1" /><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><img src="images/n3.gif" width="13" height="11" alt="1" /><a href="#"> 投亿元建酷似鸟巢文化宫... </a> </li>
            <li><img src="images/n4.gif" width="13" height="11" alt="1" /><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><img src="images/n5.gif" width="13" height="11" alt="1" /><a href="#"> 立即参与 </a> </li>
            <li><img src="images/n6.gif" width="13" height="11" alt="1" /><a href="#"> 立即参与 </a> </li>
            <li><img src="images/n7.gif" width="13" height="11" alt="1" /><a href="#"> 广州女特警击毙劫匪... </a> </li>
            <li><img src="images/n8.gif" width="13" height="11" alt="1" /><a href="#"> 立即参与 </a> </li>
            <li><img src="images/n9.gif" width="13" height="11" alt="1" /><a href="#"> 立即参与 </a> </li>
          </ul>
        </div>
      </div>
      <!--shuzi结束-->
      
      <div class="clear mt8"></div>
      <div class="congshu right_box">
        <h3>增值服务<span><a href="#">更多>></a></span></h3>
        <ul>
          <li><a href="#">名师编写</a></li>
          <li><a href="#">权威专</a></li>
          <li><a href="#">针对性强</a></li>
          <li><a href="#">覆盖面广</a></li>
          <li><a href="#">解答详细</a></li>
          <li><a href="#">质量可靠</a></li>
        </ul>
      </div>
      <!--congshu结束--> 
      
    </div>
    <!--w203结束--> 
    
  </div>
  <!--右侧结束--> 
  
</div>
<!--中间开始结束-->

<div class="clear mt8"></div>
<div id="foot">
  <p>版权所有：潍坊政府采购<br>
    技术支持：潍坊中财信科技有限公司 </p>
</div>
</body>
</html>
