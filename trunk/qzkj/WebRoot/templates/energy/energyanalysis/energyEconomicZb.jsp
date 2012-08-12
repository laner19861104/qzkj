<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>工业销售及出口</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/charts/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js"></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/Calendar.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/setmonth1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/searchjs.js" type="text/javascript"></script>
<script src="templates/js/updown.js" type="text/javascript"></script>
<script src="templates/js/lightbox.js" type="text/javascript"></script>
<script src="templates/js/createxmldoc.js" type="text/javascript"></script>  

<script language="javascript"> 
function setTab(name,cursel,n){
	for(i=1;i<=n;i++){
		var menu=document.getElementById(name+i);
		var con=document.getElementById("con_"+name+"_"+i);
		menu.className=i==cursel?"hover":"";
		con.style.display=i==cursel?"block":"none";
	}
}
var tableidArray = new Array('table1','table2');
onloadEvent(showtable);
var obj = new Object();


function searchSubmit(){

searchForm.submit();
}

</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
	<td><div style="margin-left: 17px;">当前位置：能耗水平评价系统&gt;&gt; 主要行业能源利用状况&gt;&gt;全市能耗状况分析&gt;&gt;年度经济指标</div></td>
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
                      
        <form action="<%=request.getContextPath()%>/energyEconomicZb.action" 	name="searchForm" method="post">  
          <input type="hidden" name="flag" id="flag" value="query"/>
           <table border="0" cellpadding="0" cellspacing="6" width="98%">
            
             
            
             <tr>
             <td><table>
             <s:select name="unittype"  label="单位类型"  cssStyle="width:200px;" labelSeparator="：" labelposition="-1" headerKey="-1" headerValue="全部" list="importTypeList" listKey="bh" listValue="mc"   />
             </table></td>
              
              <td><table>
             <s:select name="classtype"  label="行业"  cssStyle="width:200px;" labelSeparator="：" labelposition="-1" headerKey="-1" headerValue="全部" list="classTypeList" listKey="bh" listValue="mc"   />
             </table></td>
            
            <td><table>
             <s:select name="areatype"  label="区域"  cssStyle="width:200px;" labelSeparator="：" labelposition="-1" headerKey="-1" headerValue="全部" list="areaNameList" listKey="bh" listValue="mc"   />
             </table></td>
                </tr>
             
           
			<tr >
			   <td colspan="3" style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
					   指标选择：
                     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${zhnyxfldl=='zhnyxfldl'}">checked="checked"</c:if>   value="zhnyxfldl"/>综合能耗&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzcz=='gyzcz'}">checked="checked"</c:if>   value="gyzcz"/>工业总产值&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzjz=='gyzjz'}">checked="checked"</c:if>   value="gyzjz"/> 工业增加值&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${dwgyzczdl=='dwgyzczdl'}">checked="checked"</c:if>   value="dwgyzczdl"/>万元工业产值能耗&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${wyzjznhdl=='wyzjznhdl'}">checked="checked"</c:if>   value="wyzjznhdl"/> 万元增加值能耗&nbsp;				     
				 </td>
			  </tr>
				<tr>
				       <td colspan="3" width="100%" ><a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit();"><span class="search">查 询</span></a></td>		
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
				  <li id="one1" onmousedown="setTab('one',1,2)"  class="hover">年度经济指标分析</li>
				  <li id="one2" onmousedown="setTab('one',2,2)" >年度经济指标成长性分析</li>
				</ul></td>
			   </tr>
			 </table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			  <tr>
				<td>
			
			<!--轻重工业  -->
						
							<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
									<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
										  <tr> 
										    <td valign="top" class="text" align="center"> 
										       <div id="chartdiv_1" align="center"></div>
										       <script type="text/javascript">
													   var chart_1 = new FusionCharts("<%=request.getContextPath()%>/FusionChartsFree/Charts/FCF_MSColumn3D.swf", "ChartId", "600", "380", "0", "0");
													   chart_1.setDataXML('${charsvo.strXML}');	   
													   chart_1.render("chartdiv_1");
												</script>
											</td>
										  </tr>
									</table>
								</td>
							</tr>
						</table>
						
				<!--重点行业  -->					
                  <table width="100%" id="con_one_2" style="display:none">
							<tr>
								<td>
									<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
										  <tr> 
										    <td valign="top" class="text" align="center"> 
										       <div id="chartdiv" align="center"></div>
										       <script type="text/javascript">
													   var chart = new FusionCharts("<%=request.getContextPath()%>/FusionChartsFree/Charts/${charsvo.swfName}", "ChartId", "600", "380", "0", "0");
													   chart.setDataXML('${charsvo.strXML}');	   
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
