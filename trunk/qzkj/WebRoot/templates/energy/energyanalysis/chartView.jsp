<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
%>
		   var chart = new FusionCharts("${path}/FusionChartsFree/Charts/${charsvo.swfName}", "ChartId", "600", "380", "0", "0");
		   chart.setDataXML('${charsvo.strXML}');	   
		   chart.render("chartdiv");
		

		