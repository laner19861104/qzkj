<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>能源消费结构</title>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/lightbox.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />

<%
String tjflchildern=request.getParameter("tjflchildern");
 %>
<script type="text/javascript">
function searchSubmit(tjfl){
 searchForm.submit();

}

function searchSubmit1(){

 searchForm.action="<%=request.getContextPath() %>/energyCZConsumeInfo.action?tjflchildern=<%=tjflchildern %>";
  searchForm.submit();
}
</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
		<td>当前位置：能耗水平评价系统&gt;&gt; 年度产值能耗汇总</td>
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
                      
        <form action="<%=request.getContextPath()%>/energyCZConsume.action" 	name="searchForm" method="post">  
          <table border="0" cellpadding="0" cellspacing="6" width="98%">
               <tr>
			 	  <td  id="nd">
				     <input type="hidden" name="nd" id="nd" value="${nd}"/>
				     <input type="hidden" name="xhlx" id="xhlx" value="${xhlx}"/>
				     <input type="hidden" name="tjfl" id="tjfl" value="${tjfl}"/>
					${nd}年&nbsp; 
					 <c:if test="${tjfl==1}">按重点类型</c:if><c:if test="${tjfl==2}">按行业</c:if><c:if test="${tjfl==3}">按区域</c:if>-
					 <c:if test="${xhlx==1}">能耗</c:if><c:if test="${xhlx==2}">水耗</c:if>
				 </td>	
				 <th>排序:</th>
				  <td>
					  <select name="orderfl"  id="orderfl" >
					      <option value="1">按综合能耗倒序</option>
					      <option value="2">按万元工业产值能耗倒序</option>
					      <option value="3">按万元增加值能耗倒序</option>
					  </select>
				 </td>	
				 
				<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit1();"><span class="search">查询</span></a></td>
				<td><a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit();"><span class="search">返回</span></a></td>
<!--				<td> <a class="btn" style="float: right;" onclick="" href="<%=request.getContextPath()%>/energyCZConsumeYearInfoExportExcel.action"><span class="search">导 出</span></a></td>-->

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
	 <tr>
      	  <td>
	  		<table  width="100%" border="0" cellspacing="0" cellpadding="0"  class="list_jsd" >
				 <tr >
				   <th  rowspan="2">企业名称  </th>
                	<th colspan="2">综合能耗</th>
                	<th colspan="2">工业总产值</th>
                	<th colspan="2">工业增加值</th>
                	<th colspan="2">万元工业产值能耗</th>                	                	
                	<th colspan="2">万元增加值能耗</th>       
				 </tr>
				 
                 <tr>
					<th >万吨标准煤</th>
					<th >同比%</th>
					
					<th >万元</th>
					<th >同比%</th>
					
					<th >万元</th>
					<th >同比%</th>
					
					<th >吨标准煤/万元</th>
					<th >同比%</th>
					
					<th >吨标准煤/万元</th>
					<th >同比%</th>
				</tr>
		
			<c:forEach items="${data_list}" var="po" varStatus="varsta">
				<tr>
                 <th>${po.dwmc}&nbsp;</th>
                                 
                 <td align="right">${po.zhnyxfldl}</td>
                 <td align="right">${po.zhnhtb}</td>

                 <td align="right">${po.gyzcz}</td>
                 <td align="right">${po.gyzcztb}</td>

                 <td align="right">${po.gyzjz}</td>
                 <td align="right">${po.gyzjztb}</td>

                 <td align="right">${po.dwgyzczdl}</td>
                 <td align="right">${po.dwgyzczdltb}</td>

                 <td align="right">${po.wyzjznhdl}</td>
                 <td align="right">${po.wyzjznhdltb}</td>
				</tr>
			</c:forEach>
			</table>
			
		</td>
	</tr>
</table>
</body>
</html>
