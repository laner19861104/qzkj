<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="org.apache.struts2.components.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>能耗趋势预测分析</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/charts/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js"></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/Calendar.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/setmonth1.js" type="text/javascript"></script>
<script src="templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/templates/js/createxmldoc.js" type="text/javascript"></script> 






<script language="javascript"> 



function searchSubmit(){
  var bigin_time = document.getElementsByName("beginTime")[0].value;
  var end_time = document.getElementsByName("endTime")[0].value;
  
  if(bigin_time==""){
  alert("请选择 开始时间 ！");
  return;
  }
   
  if(end_time==""){
  alert("请选择 截至时间 ！");
  return;
  }
  
  if(end_time<bigin_time){
  alert("截至时间 要晚于 开始时间！");
  return;
  }
  
  if(document.getElementsByName("searchmodel_class")[0].value=="-1"){
  alert("请选择要 模型类别 ！");
  return;
  }

   searchForm.submit();
}


</script>



</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
		<td><div style="margin-left: 17px;">当前位置：能源预测、预警系统&gt;&gt; 能耗趋势预测分析</div></td>
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
                      
        <form action="<%=request.getContextPath()%>/energytrendanalysis.action" 	name="searchForm" method="post">  
       <input type="hidden" name="flag" id="flag" value="query"/>
          <table border="0" cellpadding="0" cellspacing="6" width="98%">
            
             <tr>
              <td >开始时间：&nbsp;&nbsp;
               <select name="beginTime"  id="beginTime" style="width:60px">
                  
                  <option value="2007">2007</option>
                  <option value="2008">2008</option>
                  <option value="2009">2009</option>
                  <option value="2010">2010</option>
                  <option value="2011">2011</option>
                  <option value="2012">2012</option>
                  <option value="2013">2013</option>
                  <option value="2014">2014</option>
                  <option value="2015">2015</option>
                  <option value="2016">2016</option>
                  <option value="2017">2017</option>
                  <option value="2018">2018</option>
                  <option value="2019">2019</option>
                  <option value="2020">2020</option>
                  <option value="2021">2021</option>
                  <option value="2022">2022</option>
				 </select>
              
<!--              <input type="text" name="beginTime"  value="${beginTime}"  size="8" readonly="true" onclick="setMonth(this)"/>-->
              &nbsp;——&nbsp;
              <select name="endTime"  id="endTime" style="width:60px">
                  
                  <option value="2007">2007</option>
                  <option value="2008">2008</option>
                  <option value="2009">2009</option>
                  <option value="2010">2010</option>
                  <option value="2011">2011</option>
                  <option value="2012">2012</option>
                  <option value="2013">2013</option>
                  <option value="2014">2014</option>
                  <option value="2015">2015</option>
                  <option value="2016">2016</option>
                  <option value="2017">2017</option>
                  <option value="2018">2018</option>
                  <option value="2019">2019</option>
                  <option value="2020">2020</option>
                  <option value="2021">2021</option>
                  <option value="2022">2022</option>
				 </select>
<!--              <input type="text" name="endTime" value="${endTime}" size="8" readonly="true" onclick="setMonth(this)"/>-->
              &nbsp;&nbsp;</td>
              
              
                   <td ><table>
		           <s:select name="qytype"  label="企业类型"  cssStyle="width:200px;" labelSeparator="：" labelposition="-1"  headerValue="请选择" list="qytype_list" listKey="bh" listValue="mc"   />
		           </table></td>
             </tr>
	           <tr>
		           <td  style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;"><table>
		           <s:select name="searchmodel_class"  label="模型类别"  cssStyle="width:200px;" labelSeparator="：" labelposition="-1" headerKey="-1" headerValue="请选择" list="model_list" listKey="algid" listValue="name"   />
		           </table></td>
		           
		           <td style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
		                         指标选择：&nbsp;&nbsp;
		          <select name="zbselect" id="zbselect" style="width:200px;">
		          <option value="zhnyxfldl" <c:if test="${zbselect=='zhnyxfldl'}">selected="selected"</c:if>>综合能耗</option>
		          <option value="gyzcz" <c:if test="${zbselect=='gyzcz'}">selected="selected"</c:if>>工业总产值</option>
		          <option value="gyzjz" <c:if test="${zbselect=='gyzjz'}">selected="selected"</c:if>>工业增加值</option>
		          <option value="dwgyzczdl" <c:if test="${zbselect=='dwgyzczdl'}">selected="selected"</c:if>>万元工业产值能耗</option>
		          <option value="wyzjznhdl" <c:if test="${zbselect=='wyzjznhdl'}">selected="selected"</c:if>>万元增加值能耗 </option>
		          </select>               
		      </td>
		       </tr>
				<tr>
				   <td colspan="2" width="100%" ><a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit();"><span class="search">查 询</span></a></td>		
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
			<table border="0" cellpadding="0" cellspacing="0" class="Menubox">
			  <tr>
				<td><ul>
				  <li id="one1"   class="hover">市县区情况</li>
				</ul></td>
			  </tr>
			</table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			  <tr>
				<td>
						<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
								
	                                 <table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
										  <tr> 
										    <td valign="top" class="text" align="center"> 
										       <div id="chartdiv" align="center">企业预测</div>
										       <script type="text/javascript">
												   var chart = new FusionCharts("<%=request.getContextPath() %>/FusionChartsFree/Charts/${freeChartPO.swfName}", "ChartId", "600", "350");
												   chart.setDataXML('${freeChartPO.strXML}');		   
												   chart.render("chartdiv");
												   
												</script>
											</td>
										  </tr>
										 
										</table>																	
									

									
								</td>
							</tr>
						</table>
	
								</td>
							</tr>
					</table>		
						
						
						
						
						
						
						

						
						
						
						
						
						
						
						
						
						
						
						
							
										
				</td>
			  </tr>
			</table>
			













</body>
</html>
