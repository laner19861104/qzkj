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
<title>��Ƶ-���������ѵ��У</title>
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="topflash">
  <div class="btn">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/btn_03.jpg" width="58" height="46" alt="���߿ͷ�" /></td>
        <c:if test="${webuser==null}">
        <td><a href="wlogin.do"><img src="images/btn_055.jpg" width="57" height="46" alt="��¼" /></a></td>
        </c:if>
        <c:if test="${webuser!=null}">
        <td><a href="entryStuInfo.do"><img src="images/btn_05.jpg" width="57" height="46" alt="�ҵ��ʻ�" /></a></td>
        </c:if>
        <td><img src="images/btn_07.jpg" width="57" height="46" alt="ѡ���嵥" /></td>
        <td><img src="images/btn_09.jpg" width="57" height="46" alt="��������" /></td>
        <td><img src="images/btn_11.jpg" width="57" height="46" alt="ȥ���" /></td>
        <td><img src="images/btn_13.jpg" width="57" height="46" alt="�����У" /></td>
      </tr>
    </table>
  </div>
  <!--btnx����--> 
  
</div>
<!--topflash����-->

<div class="clear"></div>
<div id="menu">
  <ul>
    <li><a href="index.do">��ҳ</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu1">�����γ�</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu2">�����γ�</a></li>
    <li><a href="zhongbiao.html?a=�б깫��" rel="dropmenu3">��ֵ����</a></li>
  </ul>
  <div class="search">
    <select name="">
      <option value="�γ�">�γ�</option>
    </select>
    <input name="" type="text" />
    <img src="images/19.gif" width="43" height="20" alt="����" /></div>
  <!--search����--> 
</div>
<!--end menu--> 

<!--end menu-->
<div class="clear"></div>
<div id="main"><!--�м俪ʼ-->
  <div id="left" ><!--���-->
    <div class="department"><!--�γ�-->
      <h1>ȫ���γ�<span><a href="#">����>></a></span></h1>
      <div class="news">
        <ul>
          <%for(JocSubject s : subjectlist) { %>
          <li><a href="list.do?subject=<%=s.getCode() %>" target="_self"><%=s.getName() %></a></li>
          <%} %>
        </ul>
      </div>
    </div>
    <!--�γ̽���--> 
    
  </div>
  <!--������-->
  <div id="right">
    <div class="position">
      <h2> ����λ�ã���ҳ>>��Ƶ</h2>
    </div>
    <div class="clear mt8"></div>
    <div class="w746">
      <div class="w775_h3">
      <c:if test="${subject!=null}">
      ${subject.name }
      </c:if>
      </div>
      <!--w775_h3����-->
      <div class="w600">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"   class="list3">
          <%
          if (null == courselist || 0 == courselist.size()) {
          %>
          <tr>
	        <td>�Բ��𣬴˿�Ŀ��������Ƶ�γ̡�</td>
	      </tr>
       	  <%
          } else {
	          int i = 0;
	          for(JocCourse c : courselist) { 
	          %>
	          <tr>
	            <td><input name="" type="checkbox" value="" /><%=c.getName()%></td>
	            <td><%=c.getCost()%>Ԫ&nbsp;&nbsp;<%=0==i%2?"<a href='player.do?'><span>�ۿ�</span></a>":"<span>����</span>" %></td>
	            <td>���򸨵���</td>
	          </tr>
	          <% i++;
	          }
          }%>
        </table>
      </div>
      <!--w575����--> 
      
    </div>
    <!--w746����-->
    <div class="clear mt8"></div>
    <div class="page"> 
    <a href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>">��ҳ</a> 
    <a<%if(queryjson.getPage()>0) {%> href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getPage()-1)*20 %>"<%} %>>��һҳ</a> 
    <a<%if(queryjson.getPage()*20>=queryjson.getTotal()) {%> href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getPage()+1)*20 %>"<%} %>>��һҳ</a> 
    <a href="list.do?subject=<%=(null==subject)?"":subject.getCode() %>&i=<%=(queryjson.getTotal()+19)/20*20 %>">ĩҳ</a> 
    <span>��<%=queryjson.getTotal() %>����¼&nbsp;20��/ҳ</span> </div>
    <!--end page--> 
    
  </div>
  <!--�Ҳ����--> 
  
</div>
<!--�м俪ʼ����-->

<div class="clear mt8"></div>
<div id="foot">
  <p>��Ȩ���У�Ϋ�������ɹ�<br>
    ����֧�֣�Ϋ���в��ſƼ����޹�˾ </p>
</div>
</body>
</html>

