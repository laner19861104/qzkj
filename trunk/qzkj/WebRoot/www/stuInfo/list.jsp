<%@ page language="java" import="java.util.*,com.bip.sys.course.po.*,com.bip.common.util.QueryJson" pageEncoding="gb2312"   contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<JocSubject> subjectlist = (List<JocSubject>)request.getAttribute("subjectlist");
JocSubject subject = (JocSubject)request.getAttribute("subject");
QueryJson queryjson = (QueryJson)request.getAttribute("queryjson");
List<JocCourse> courselist = (List<JocCourse>)queryjson.getRows();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>视频-奇正会计培训网校</title>
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
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
      <h1>全部课程<span><a href="#">更多>></a></span></h1>
      <div class="news">
        <ul>
          <%for(JocSubject s : subjectlist) { %>
          <li><a href="list.do?subject=<%=s.getCode() %>" target="_self"><%=s.getName() %></a></li>
          <%} %>
        </ul>
      </div>
    </div>
    <!--课程结束--> 
    
  </div>
  <!--左侧结束-->
  <div id="right">
    <div class="position">
      <h2> 您的位置：首页>>视频</h2>
    </div>
    <div class="clear mt8"></div>
    <div class="w746">
      <div class="w775_h3">
      <c:if test="${subject!=null}">
      ${subject.name }
      </c:if>
      </div>
      <!--w775_h3结束-->
      <div class="w600">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"   class="list3">
          <%
          if (null == courselist || 0 == courselist.size()) {
          %>
          <tr>
	        <td>对不起，此科目下暂无视频课程。</td>
	      </tr>
       	  <%
          } else {
	          int i = 0;
	          for(JocCourse c : courselist) { 
	          %>
	          <tr>
	            <td><input name="" type="checkbox" value="" /><%=c.getName()%></td>
	            <td><%=c.getCost()%>元&nbsp;&nbsp;<%=0==i%2?"<a href='player.do?'><span>观看</span></a>":"<span>购买</span>" %></td>
	            <td>购买辅导书</td>
	          </tr>
	          <% i++;
	          }
          }%>
        </table>
      </div>
      <!--w575结束--> 
      
    </div>
    <!--w746结束-->
    <div class="clear mt8"></div>
    <div class="page"> 
    <a href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>">首页</a> 
    <a<%if(queryjson.getPage()>0) {%> href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getPage()-1)*20 %>"<%} %>>上一页</a> 
    <a<%if(queryjson.getPage()*20>=queryjson.getTotal()) {%> href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getPage()+1)*20 %>"<%} %>>下一页</a> 
    <a href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getTotal()+19)/20*20 %>">末页</a> 
    <span>共<%=queryjson.getTotal() %>条记录&nbsp;20条/页</span> </div>
    <!--end page--> 
    
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

