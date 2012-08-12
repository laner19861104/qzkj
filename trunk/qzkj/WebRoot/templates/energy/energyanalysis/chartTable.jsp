<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
%>


		   var chart = new FusionCharts("${path}/FusionChartsFree/Charts/${charsvo.swfName}", "ChartId", "600", "380", "0", "0");
		   chart.setDataXML('${charsvo.strXML}');	   
		   chart.render("chartdiv");


     var div = document.getElementById("chartdiv"); 
     var table = document.createElement("table");//创建table 
     var row = table.insertRow();//创建一行 
     var cell = row.insertCell();//创建一个单元 
     cell.width="600"
     cell.innerHTML="${resList}"; 
     div.appendChild(table); 

		
