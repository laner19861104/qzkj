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

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="slist">
   <tr>
	  <th width="70%">����</th>
	  <th width="30%">�ϱ�״̬</th>
	</tr>
	<%for (int i = 0; i < tableList.size(); i++) { 
	     Map rptMap=(Map)tableList.get(i);
	    
	%>
	<tr>
	  <td><%=rptMap.get("name") %></td>
	
	
      <td><%=rptMap.get("mark") %></td>
	</tr>
	<% 
	} %>

 </table>
