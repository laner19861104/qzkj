<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	Map resMap=(Map)request.getAttribute("resMap");
    List tableList=new ArrayList();
    Map cmpInfo=(Map)resMap.get("cmpInfo");
    if(resMap!=null){
       tableList=(List)resMap.get("tableList");
    }
    String urlpath=request.getContextPath();
    
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list1">
   <tr>
	  <th>报表</th>
      <th>1月份</th>
	  <th>2月份</th>
	  <th>3月份</th>
	  <th>4月份</th>
	  <th>5月份</th>
	  <th>6月份</th>
	  <th>上半年</th>
	  <th>7月份</th>
	  <th>8月份</th>
	  <th>9月份</th>
	  <th>10月份</th>
	  <th>11月份</th>
	  <th>12月份</th>
	  <th>下半年</th>
	  <th>年报</th>
	</tr>
	<%for (int i = 0; i < tableList.size(); i++) { 
	     Map rptMap=(Map)tableList.get(i);
	     String sblx="3";
	     if(rptMap.get("sblx")!=null){
	         sblx=rptMap.get("sblx").toString();
	     }
	%>
	<tr>
	  <td><%=rptMap.get("name") %></td>
	
	  <td><%if(rptMap.get("1")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("1_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=1&sblx=3','1000','660')" ><%=rptMap.get("1")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("2")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("2_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=2&sblx=3','1000','660')" ><%=rptMap.get("2")%></a><%}else{ %>&nbsp;<%} %></td>
      <td ><%if(rptMap.get("3")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("3_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=3&sblx=<%=sblx%>','1000','660')" ><%=rptMap.get("3")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("4")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("4_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=4&sblx=3','1000','660')" ><%=rptMap.get("4")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("5")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("5_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=5&sblx=3','1000','660')" ><%=rptMap.get("5")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("6")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("6_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=6&sblx=<%=sblx%>','1000','660')" ><%=rptMap.get("6")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("1_bn")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("1_bnid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&sblx=4','1000','660')" ><%=rptMap.get("1_bn")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("7")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("7_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=7&sblx=3','1000','660')" ><%=rptMap.get("7")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("8")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("8_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=8&sblx=3','1000','660')" ><%=rptMap.get("8")%></a><%}else{ %>&nbsp;<%} %></td>
	  <td><%if(rptMap.get("9")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("9_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=9&sblx=<%=sblx%>','1000','660')" ><%=rptMap.get("9")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("10")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("10_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=10&sblx=3','1000','660')" ><%=rptMap.get("10")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("11")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("11_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=11&sblx=3','1000','660')" ><%=rptMap.get("11")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("12")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("12_zbid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&yd=12&sblx=<%=sblx%>','1000','660')" ><%=rptMap.get("12")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("2_bn")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("2_bnid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&sblx=4','1000','660')" ><%=rptMap.get("2_bn")%></a><%}else{ %>&nbsp;<%} %></td>
      <td><%if(rptMap.get("yearReport")!=null){ %><a href="#" onclick="openWindow('<%=urlpath%>/companyReportEnyRpt?sbzl=<%=rptMap.get("sbzl")%>&zbid=<%=rptMap.get("ndid")%>&&dwbh=<%=rptMap.get("dwbh")%>&nd=<%=rptMap.get("nd")%>&sblx=1','1000','660')" ><%=rptMap.get("yearReport")%></a><%}else{ %>&nbsp;<%} %></td>
	</tr>
	<% 
	} %>

 </table>
