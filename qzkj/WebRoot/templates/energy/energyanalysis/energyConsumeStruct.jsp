<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>能源消费结构</title>
<link href="<%=request.getContextPath() %>/charts/Contents/Style.css"  rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js" language="JavaScript" ></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/lightbox.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
function searchSubmit(flag){
//  var end_time = document.getElementsByName("endyf")[0].value*1;
//  var begin_time = document.getElementsByName("beginyf")[0].value*1;
//  if(end_time<begin_time){
//  alert("截至时间 要晚于 开始时间！");
//  return;
//  }
  
  if(flag=="1"){
    searchForm.action="<%=request.getContextPath()%>/energyConsumeStruct.action";
    
  }else if(flag=="2"){
    searchForm.action="<%=request.getContextPath()%>/energyConsumeStructOutExcel.action";
  }
 searchForm.submit();
}


</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
		<td><div style="margin-left: 17px;">当前位置：能耗水平评价系统&gt;&gt; 主要行业能源利用状况&gt;&gt;全市能耗状况分析&gt;&gt;能源消费结构</div></td>
	</tr>
</table>

<table  border="0" cellpadding=0 cellspacing=0 width="100%" height="25" align="center" >
        <tr> 
          <td  class="updown"  style="cursor: hand" onClick="outliner()" child="1ALL" id="updown1" background="templates/image/title_bg_down.jpg">&nbsp;&nbsp;&nbsp;&nbsp;</td>
         </tr>
 </table>
 <div  class="expanded"   id="1ALL" > 
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset>
          <legend></legend>
                      
        <form action="<%=request.getContextPath()%>/energyConsumeStruct.action" 	name="searchForm" method="post">  
          <table border="0" cellpadding="0" cellspacing="0" width="98%">
               <tr>
			      <th>时间:</th>
				  <td  id="nd">
					  <select name="nd"  id="nd" >
					      <c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
						 </c:forEach>	
					  </select>年
				      <select name="beginyf"  id="beginyf" >
						  <c:forEach items="${yfList}" var="tmp" varStatus="varsta" >
							<option value="${tmp}" <c:if test="${tmp==beginyf}">selected</c:if>>${tmp}</option>
						  </c:forEach>	
					  </select>月
<!--				       ——    -->
<!--				      <select name="endyf"  id="endyf" >-->
<!--				   			<c:forEach items="${yfList}" var="tmp" varStatus="varsta" >-->
<!--							   <option value="${tmp}" <c:if test="${tmp==endyf}">selected</c:if>>${tmp}</option>-->
<!--							</c:forEach>	-->
<!--					 </select>&nbsp;月-->
				 </td>	
				 
<!--				  <th>分析目标:</th>-->
<!--				    <td>-->
<!--				    <select name="fxmb"  id="fxmb" >-->
<!--						<option value="1" <c:if test="${fxmb==1}">selected</c:if>>能源消费合计</option>-->
<!--						<option value="2" <c:if test="${fxmb==2}">selected</c:if>>工业消费合计</option>-->
<!--					</select>-->
<!--				 	</td>					 	-->
						
<!--				 	<th>统计类别:</th>-->
<!--				    <td>-->
<!--				    <select name="tjlb"  id="tjlb" >-->
<!--						<option value="1" <c:if test="${tjlb==1}">selected</c:if>>明细汇总</option>-->
<!--						<option value="2" <c:if test="${tjlb==2}">selected</c:if>>大类汇总</option>-->
<!--					</select>-->
<!--				 	</td>	-->
					
				<th>统计分类:</th>
				<td> <select name="tjfl" id="tjfl" onchange="javascript:searchSubmit(1);">
						<option value="1" <c:if test="${tjfl==1}">selected</c:if>>重点类型</option>
						<option value="2" <c:if test="${tjfl==2}">selected</c:if>>行业</option>
						<option value="3" <c:if test="${tjfl==3}">selected</c:if>>区域</option>
					</select>
					<select name="tjflchild"  id="tjflchild" >
					    <option value="-1" >全部</option>
					    <c:forEach items="${tjflList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.bh}" <c:if test="${tmp.bh==tjflchild}">selected</c:if>>${tmp.mc}</option>
						</c:forEach> 
					   </select>
					</td>	
			</tr>
            <tr>
            <td colspan="6" width="100%" style="border-top: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
				  <input type="hidden" name="dataList" id="dataList" value="${data_list}"/>
				  <input name="fxmb" value='1' id="fxmb" type='hidden'/>			  
				  <input name="tjlb" value='1' id="tjlb" type='hidden'/>
<!--				   <a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit(2);"><span class="search">导 出</span></a>-->
				   <a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit(1);"><span class="search">查 询</span></a></td>	
            </tr>
        
        
          </table>		
		</form>
	 </fieldset>
</td>
</tr>
 </table>
 </div>   
    <br />
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<!--	<tr>-->
<!--	   <td>-->
<!--	   说明：查出数据后，单击蓝色表头区域可以分别查看“本月”、“本月止累计”、“去年同月”、“上年同月止累计”的能源占比分析图。-->
<!--	   </td>-->
<!--	 </tr>-->
	 <tr>
      	  <td>
	  		<table  width="100%" border="0" cellspacing="0" cellpadding="0"  class="tableout_jsd list_jsd " >
				 <tr >
				   <th  rowspan="2"> 能源品种</th>
					<th rowspan="2">计量单位</th>
<!--                	<a  id="addbtn" ><th colspan="3">本月</th></a>-->
<!--                	<a  id="addbtn1" ><th colspan="3">本月止累计</th></a>-->
<!--                	<a  id="addbtn2" ><th colspan="3">上年同月</th></a>-->
<!--                	<a  id="addbtn3" ><th colspan="3">上年同月止累计</th></a>-->
					<th colspan="3">本月</th>
                	<th colspan="3">本月止累计</th>
                	<th colspan="3">上年同月</th>
                	<th colspan="3">上年同月止累计</th>
                	<th>同比</th>
                	<th>累计同比</th>
				 </tr>
				 
                 <tr>
					<th >实物量</th>
					<th >拆标量</th>
					<th >占比%</th>
					
					<th >实物量</th>
					<th >拆标量</th>
					<th >占比%</th>
					
					<th >实物量</th>
					<th >拆标量</th>
					<th >占比%</th>
					
					<th >实物量</th>
					<th >拆标量</th>
					<th >占比%</th>		
					
					<th >%</th>
					<th >%</th>
				</tr>
				
				<c:forEach items="${data_list}" var="po" varStatus="varsta">
				<tr>
                 <td>${po.nypz}</td>
                 <td>${po.jldw}</td>

                 <td align="right">${po.bysw}</td>
                 <td align="right">${po.byzbl}</td>
                 <td align="right">${po.byzb}</td>

                 <td align="right">${po.byzljswl}</td>
                 <td align="right">${po.byzljzbl}</td>
                 <td align="right">${po.byljzb}</td>

                 <td align="right">${po.qnbysw}</td>
                 <td align="right">${po.qnbyzbl}</td>
                 <td align="right">${po.qnbyzb}</td>

                 <td align="right">${po.qnbyzljswl}</td>
                 <td align="right">${po.qnbyzljzbl}</td>
                 <td align="right">${po.qnljzb}</td>

                 <td align="right">${po.tb}</td>
                 <td align="right">${po.lztb}</td>				
				</tr>
				</c:forEach>
				
				
				
				
				
			</table>
	  
			
		</td>
	</tr>
</table>


</body>
</html>
