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
     var table = document.createElement("table");//创建table 
     var row = table.insertRow();//创建一行 
     var cell = row.insertCell();//创建一个单元 
       cell.width="600"
     cell.innerHTML="${resList}"; 
     div.appendChild(table); 

		
