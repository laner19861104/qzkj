<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
%>

     var div = document.getElementById("chartdiv"); 
     var table = document.createElement("table");//����table 
     var row = table.insertRow();//����һ�� 
     var cell = row.insertCell();//����һ����Ԫ 
       cell.width="600"
     cell.innerHTML="${resList}"; 
     div.appendChild(table); 

		
