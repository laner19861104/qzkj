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
  //  Map cmpInfo=(Map)resMap.get("cmpInfo");
    if(resMap!=null){
       tableList=(List)resMap.get("tableList");
    }
    String urlpath=request.getContextPath();
    
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="slist">
   <tr>
	  <th >����</th>
	  <th>1�·�</th>
	  <th>2�·�</th>
	  <th>3�·�</th>
	  <th>4�·�</th>
	  <th>5�·�</th>
	  <th>6�·�</th>
	  <th>7�·�</th>
	  <th>8�·�</th>
	  <th>9�·�</th>
	  <th>10�·�</th>
	  <th>11�·�</th>
	  <th>12�·�</th>
	</tr>
	<%for (int i = 0; i < tableList.size(); i++) { 
	     Map rptMap=(Map)tableList.get(i);
	%>
	<tr>
	  <td><%=rptMap.get("name") %></td>
	  <td><%=rptMap.get("mark1") %></td>
	  <td><%=rptMap.get("mark2") %></td>
      <td><%=rptMap.get("mark3") %></td>
      <td><%=rptMap.get("mark4") %></td>
      <td><%=rptMap.get("mark5") %></td>
      <td><%=rptMap.get("mark6") %></td>
      <td><%=rptMap.get("mark7") %></td>
      <td><%=rptMap.get("mark8") %></td>
      <td><%=rptMap.get("mark9") %></td>
      <td><%=rptMap.get("mark10") %></td>
      <td><%=rptMap.get("mark11") %></td>
      <td><%=rptMap.get("mark12") %></td>
	</tr>
	<% 
	} %>

 </table>
