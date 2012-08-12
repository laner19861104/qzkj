<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <script src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
 

 <!--弹出层的内容-->
<div id="idBox" class="lightbox" style="width:660px;">
	<h1 id="idBoxHead">全市能源消费结构分析<span><img src="templates/image/quit.png" id="idBoxCancel"  /></span></h1>
	<div class="content">
	                                 <table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
										  <tr> 
										    <td valign="top" class="text" align="center"> 
										       <div id="chartdiv" align="center"></div>
										       <script type="text/javascript">
												   var chart = new FusionCharts("<%=request.getContextPath() %>/FusionChartsFree/Charts/${freeChartPO.swfName}", "ChartId", "640", "450");
												   chart.setDataXML('${freeChartPO.strXML}');		   
												   chart.render("chartdiv");
												   
												</script>
											</td>
										  </tr>
										 
										</table>	
	
	
	</div>
</div>
<div id="idOverlay"></div>

<SCRIPT LANGUAGE="JavaScript">
		
var box = new LightBox("idBox", "idOverlay", { Center: true });
var drag = new Drag("idBox", "idBoxHead", { mxContainer: document.documentElement, Lock: true });
$("idBoxCancel").onclick = function(){ box.Close(); }
$("addbtn").onclick = function(){box.Show(); }
 
</SCRIPT>
