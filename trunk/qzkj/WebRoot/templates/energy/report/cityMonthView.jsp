<%@ page language="java" import="java.util.*,com.bip.energy.reportinfoprediction.po.*"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
List list=(List)request.getAttribute("list");
int start=Integer.parseInt(request.getAttribute("start").toString());
int end=Integer.parseInt(request.getAttribute("end").toString());
int nd=Integer.parseInt(request.getAttribute("nd").toString());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
 <HEAD>
  <TITLE>潍坊市工业经济运行 </TITLE>
  <meta http-equiv="x-ua-compatible" content="ie=7" /> 
  <meta http-equiv="content-type" content="text/html; charset=gbk">
  <link href="<%=request.getContextPath() %>/templates/css/main_top_view.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/util.js"></script>		
	<script>		
function thisheight(){
	
var thirdheight=document.documentElement.clientHeight-40;
var thirdwidth=document.documentElement.clientWidth-10;
var _div=document.getElementById("aaa"); 
var _height=parseInt(_div.style.height); 
var _width=parseInt(_div.style.width); 
_div.style.height=thirdheight+"px"; 
_div.style.width=thirdwidth+"px"; 
}

</script>

</HEAD>
<body onload="thisheight()">

<div align="center"><font style="font-size: 24px;"><strong><%=nd %>年度<%=start %>月份-<%=end %>月份 单耗预警</strong></font></div>
<div id="aaa"  style="width:970px;height:;overflow: auto; position:relative;"  >
	<table class="list" border="0" cellpadding="0" cellspacing="0" width="<%=330+(end-start)*2*12 %>px" >
	
	<tr>
	<th rowspan="2" width="150px">
	企业名称
	</th>
	<th rowspan="2" width="180px">
	单位产品综合能耗指标
	</th>
	<%
	for(int i=start;i<=end;i++)
		{	
	%>
	<th colspan="2">
	<%=i %>月
	</th>
	
	<%} %>
	</tr>
	<tr>
	<%
	for(int i=start;i<=end;i++)
		{
	%>
	<th>国</th>
	<th>省</th>
	<%} %>
	</tr>
	<%
	for(int i=0;i<list.size();i++)
		{
		jnjyPO po=(jnjyPO)list.get(i);
		for(int j=0;j<po.getDataList().size();j++)
			{
			%>
			<tr>
			<%
			if(j==0){
				Map map=(Map)po.getDataList().get(j);
			%>
			<td  width="150px" rowspan="<%=po.getDataList().size() %>" width="150px"><%=po.getDwmc() %></td>
			<td  width="180px"><%=map.get("zbmc").toString() %></td>
			<%
			for(int n=start;n<=end;n++)
			{
			%>
			<td width="12px" bgcolor='#FFFFFF'><%=map.get("cmonth"+n).toString().equals("red")?"<IMG src='"+request.getContextPath() +"/templates/image/hong.gif' />":map.get("cmonth"+n).toString().equals("yello")?"<IMG src='"+request.getContextPath() +"/templates/image/cheng.gif' />":map.get("cmonth"+n).toString().equals("green")?"<IMG src='"+request.getContextPath() +"/templates/image/liu.gif' />":"&nbsp;" %></td>
			<td width="12px" bgcolor='#FFFFFF'><%=map.get("pmonth"+n).toString().equals("red")?"<IMG src='"+request.getContextPath() +"/templates/image/hong.gif' />":map.get("pmonth"+n).toString().equals("yello")?"<IMG src='"+request.getContextPath() +"/templates/image/cheng.gif' />":map.get("pmonth"+n).toString().equals("green")?"<IMG src='"+request.getContextPath() +"/templates/image/liu.gif' />":"&nbsp;" %></td>
			<%} %>
			</tr>
	<%}else{ 
		Map map=(Map)po.getDataList().get(j);
	%>
			<td width="180px"><%=map.get("zbmc").toString() %></td>
			<%
			for(int m=start;m<=end;m++)
			{
			%>
			<td width="12px" bgcolor='#FFFFFF'><%=map.get("cmonth"+m).toString().equals("red")?"<IMG src='"+request.getContextPath() +"/templates/image/hong.gif' />":map.get("cmonth"+m).toString().equals("yello")?"<IMG src='"+request.getContextPath() +"/templates/image/cheng.gif' />":map.get("cmonth"+m).toString().equals("green")?"<IMG src='"+request.getContextPath() +"/templates/image/liu.gif' />":"&nbsp;" %></td>
			<td width="12px" bgcolor='#FFFFFF'><%=map.get("pmonth"+m).toString().equals("red")?"<IMG src='"+request.getContextPath() +"/templates/image/hong.gif' />":map.get("pmonth"+m).toString().equals("yello")?"<IMG src='"+request.getContextPath() +"/templates/image/cheng.gif' />":map.get("pmonth"+m).toString().equals("green")?"<IMG src='"+request.getContextPath() +"/templates/image/liu.gif' />":"&nbsp;" %></td>
			<%} %>
			</tr>
	<%}}} %>

	</table>	
</div>

</body>
</HTML>







        
          
	      
	      
	           
