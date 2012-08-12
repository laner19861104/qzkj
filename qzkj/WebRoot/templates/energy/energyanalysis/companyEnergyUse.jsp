<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="templates/css/main.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js"></script>
        <script src="templates/js/lightbox.js" type="text/javascript"></script>
        <script src="templates/js/util.js" type="text/javascript"></script>
        <script src="templates/js/tdcolor.js" type="text/javascript"></script>      
         <script src="templates/js/createxmldoc.js" type="text/javascript"></script>  
		<script src="templates/js/setmonth1.js"></script>
			<script type="text/javascript">
			var tableidArray = new Array('table1');
			onloadEvent(showtable);
			
			function searchlist()
			{
				if(formlist.beginTime.value==""){
					alert("请选择时间");
					return;
				}
				
				if(formlist.qy.value==""){
					alert("请选择区域");
					return;
				}
				
				table1.style.display="block";
			//formlist.submit();
			}
		</script>
		<script language="JavaScript" src="charts/JSClass/FusionCharts.js"></script>
	<link rel="stylesheet" href="js/seekopen/sysjs/css/Style.css" type="text/css" />
<style>
.Menubox{
   margin-bottom: -6px;
   margin-left: 2px;
}	
.Menubox li{
	float:left;
	display:block;
	cursor:pointer;
	text-align:center;
	color:#666666;
	margin-right: 2px;
	margin-bottom: 1px;
	height: 15px;
	padding: 5px 10px;
	border:1px solid #999;
	border-bottom:0px;
	white-space: nowrap;
 }
.Menubox li a{
	color: #000000;
	text-decoration: none;
	border:none;	
}
.Menubox li a:hover{
	color:#FF0000;
	text-decoration: none;
	border:none;	
}
</style>
</head>

<body>

<div class="position">当前位置：能耗水平评价系统 >> 主要行业能源利用状况 >> 企业能耗状况分析 >> 企业能源消费情况</div>
<br/>
          <form action="${path}/zbpf" name="formlist" method="post">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
				<tr>
					<td>
					<fieldset>
						<legend>查询条件</legend>
						
						<table border="0" cellpadding="0" cellspacing="3" >
				            <tr>
			             <th>年度:</th>
				              <td>
				                  <select name="nd"  id="nd" >
				                        <option value="" >----</option>
										<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							 
				              <th>所属区域:</th>
				              <td><select name="ssqy"  id="ssqy" >
				              			<option value="" >所有区域</option>
										<c:forEach items="${dqList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==ssqy}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>	
									</select>
						      </td>
						      
				              <th>行业分类:</th>
				              <td><select name="hyfl"  id="hyfl" style="width:150px;">
				              			<option value="" >所有分类</option>
										<c:forEach items="${hyflList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==hyfl}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>
									</select>
						      </td>
				              <th>单位类型:</th>
				              <td>  <select name="dwlx" id="dwlx" style="width:150px;">
				              			<option value="" >所有类型</option>
										<c:forEach items="${dwlxList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==dwlx}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>
									</select>
							  </td>
							 
							  <th>重点类型:</th>
				              <td><select name="zdlx" id="zdlx">
				              		<option value="" >所有类型</option>
									<c:forEach items="${zdlxList}" var="tmp" varStatus="varsta" >
										<option value="${tmp.bh}" <c:if test="${tmp.bh==zdlx}">selected</c:if>>${tmp.mc}</option>
									</c:forEach>
								</select>
							  </td>
							  
					          <td>
								<a class="btn"  onClick="searchSubmit()" href="javascript:void(0);"><span class="search">查 询</span></a>
							  </td>
							  
				            </tr>
				          </table>
				    
					</fieldset>								
					</td>
				</tr>
		    </table>
		</form>	
         <br />
   <table border="0" cellpadding="0" cellspacing="0" class="Menubox">
	  <tr>
		<td><ul>
			<li id="one1"  class="hover"><span style="font-size:12px;">（月份）企业能耗总体情况表</span></li>
		  	<li id="one2"><span style="font-size:12px;"><a href="#" target="_self">（月份）企业各月总耗能情况</a></span></li>
		  	<li id="one2"><span style="font-size:12px;"><a href="#" target="_self">	（年度）企业各年总耗能情况</a></span></li>
		</ul></td>
	  </tr>
	</table>
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset >
          <legend></legend>      
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
			  <td>
					
			  		
					<table border="0" cellspacing="0" cellpadding="0" class="list" id="table1"  width="100%">
				          <tr>
							  <th width="326" height="40" rowspan="2"><p >单位名称</p></th>
							  <th colspan="3"><p >综合能源消费量</p></th>
							  <th colspan="3"><p >区域综合能源消费量</p></th>
							  <th colspan="2"><p >所占比率</p></th>
					     </tr>
						  <tr>
							  <th width="110"><p >本期值</p></th>
							  <th width="117"><p >去同值</p></th>
							  <th width="92"><p >变化率</p></th>
							  <th width="116"><p >本期值</p></th>
							  <th width="113"><p >去同值</p></th>
							  <th width="96"><p >变化率</p></th>
							  <th width="133"><p >本期</p></th>
							  <th width="128"><p >去同</p></th>
						  </tr>
						  
				  
						  <tr>
						  <td>1</td>
						  <td>2222</td>
						  <td>3333</td>
						  <td>&nbsp;</td>
						  <td>4444</td>
						  <td>5555</td>
						  <td>&nbsp;</td>
						  <td>6666</td>
						  <td>7777</td>
						  </tr>
				        </table>
					
				</td>
			</tr>
		</table>	 
         <br />      
		<table width="98%">
		  <tr>
		     <td>
				<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
				  <tr> 
				    <td valign="top" class="text" align="center"> 
				    	<div id="chartdiv" align="center"> 图标 </div>
				        <script type="text/javascript">
						   var chart = new FusionCharts("${path}/FusionChartsFree/Charts/${chartVO.swfName}", "ChartId", "750", "400", "0", "0");
						   chart.setDataXML('${chartVO.strXML}');	   
						// chart.setDataURL("${path}/charts/Gallery/Data/MSColumn2D.xml");
						   chart.render("chartdiv");
						</script> </td>
				  </tr>
				  <tr>
				    <td valign="top" class="text" align="center">&nbsp;</td>
				  </tr>
				</table>   
			</td>
			
		   </tr>
		</table>     
         
          
      
     </fieldset></td>
   </tr>
</table>








</body>

