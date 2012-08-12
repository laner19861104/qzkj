<%@ page language="java" import="java.util.*,com.bip.energy.reportinfoprediction.po.*"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
List list=(List)request.getAttribute("list");
int start=Integer.parseInt(request.getAttribute("beginyd").toString());
int end=Integer.parseInt(request.getAttribute("endyd").toString());
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

<div align="center"><font style="font-size: 24px;"><strong><%=nd %>年度<%=start %>月份-<%=end %>月份 月度指标查询</strong></font></div>
	
	<div id="aaa"  style="width:970px;height:;overflow: auto; position:relative;"  >
	<table class="list" border="0" cellpadding="0" cellspacing="0" style="width:<%=800+(end-start+1)*70 %>px" >
	
	<tr>
	<th style="width:100px">
	区域名称
	</th>
	<th style="width:280px">企业名称</th>
	<th>行业类别</th>
	<th style="width:280px">
	指标名称
	</th>
	<th style="width:100px">
	指标单位
	</th>
	<%
	for(int i=start;i<=end;i++)
		{	
	%>
	<th style="width:70px">
	<%=i %>月
	</th>
	
	<%} %>
	<th style="width:70px">合计</th>
	</tr>
	<%
	for(int i=0;i<list.size();i++)
		{
		jnljyPO po=(jnljyPO)list.get(i);
		for(int j=0;j<po.getDataList().size();j++)
			{
			%>
			<tr>
			<%
			if(j==0){
				Map map=(Map)po.getDataList().get(j);
			%>
			<td   rowspan="<%=po.getDataList().size() %>" ><%=po.getQymc() %></td>
			<td  ><%=map.get("dwmc")==null?"":map.get("dwmc").toString() %></td>
			<td  ><%=map.get("xxtype")==null?"&nbsp;":map.get("xxtype").toString().equals("0")?"标准行业":"传统行业" %></td>
			<td ><%=map.get("zbmc")==null?"":map.get("zbmc").toString() %></td>
			<td  ><%=map.get("zbdw")==null?"":map.get("zbdw").toString() %></td>
			<%
			for(int n=start;n<=end;n++)
			{
			%>
			<td align="right"><%=map.get("y"+n)==null?"&nbsp;":map.get("y"+n).toString() %></td>
			<%} %>
			<td align="right"><%=map.get("yhj")==null?"&nbsp;":map.get("yhj").toString() %></td>
			</tr>
	<%}else{ 
		Map map=(Map)po.getDataList().get(j);
	%>
			<td  ><%=map.get("dwmc")==null?"":map.get("dwmc").toString() %></td>
			<td  ><%=map.get("xxtype")==null?"&nbsp;":map.get("xxtype").toString().equals("0")?"标准行业":"传统行业" %></td>
			<td ><%=map.get("zbmc")==null?"":map.get("zbmc").toString() %></td>
			<td  ><%=map.get("zbdw")==null?"":map.get("zbdw").toString() %></td>
			<%
			for(int m=start;m<=end;m++)
			{
			%>
			<td align="right"><%=map.get("y"+m)==null?"&nbsp;":map.get("y"+m).toString() %></td><%} %>
			<td align="right"><%=map.get("yhj")==null?"&nbsp;":map.get("yhj").toString() %></td>
			</tr>
	<%}}} %>

	</table>	
</div>
</body>
</HTML>







        
          
	      
	      
	           
