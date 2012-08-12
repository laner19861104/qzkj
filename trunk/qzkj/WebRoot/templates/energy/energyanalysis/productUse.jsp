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
	
</head>

<body>

<div class="position">当前位置：能耗水平评价系统 >> 主要产品单耗情况 >> 部分行业主要产品单耗指标</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset >
          <legend></legend>
          <form action="${path}/zbpf" name="formlist" method="post">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
			<tr>
				<td>
				<fieldset>
					<legend>查询条件</legend>
					
					<table border="0" cellpadding="0" cellspacing="3" >
			            <tr>
		        <!---->   <th>年度:</th>
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
			
         <br />
         
         
         <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1"  width="100%">
      
          
          <tr>
			  <th width="314" height="40" rowspan="2"><p >指标名称</p></th>
			  <th width="73" rowspan="2"><p >单位</p></th>
              <th width="182"><p >企业本期</p></th>
			  <th width="166"><p >比上年</p></th>
			  <th width="178"><p >国内平均</p></th>
			  <th width="164" rowspan="2"><p >国家限额</p></th>
			  <th width="154" rowspan="2"><p >省限额</p></th>
		 </tr>
		  <tr>
			  <th><p >平均</p></th>
			  <th><p >下降</p></th>
			  <th><p >水平</p></th>
		  </tr>
		  
   		<c:forEach items="${viewList}" var="tmp" varStatus="varsta" >
		  <tr>
		 
		  <td>${tmp.zbmc}</td>
		  <td>${tmp.jldw}</td>
		  <td>${tmp.bnz}</td>
		  <td>${tmp.bhl}%</td>
		  <td>&nbsp;</td>
		  <td>${tmp.gjde}&nbsp;</td>
		  <td>&nbsp;</td>
		  </tr>
         </c:forEach> 
          
        </table>
          
       </form>
     </fieldset></td>
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
				   var chart = new FusionCharts("${path}/charts/Charts/MultiLevelPie.swf", "ChartId", "750", "400", "0", "0");
				  // chart.setDataURL("${path}/productUseToXml.action");	
				   chart.setDataXML("${xmlStr}");	   
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





</body>

