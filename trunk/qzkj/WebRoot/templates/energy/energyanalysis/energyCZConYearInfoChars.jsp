<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String tjflchildern=request.getParameter("tjflchildern");
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��Դ���ѽṹ</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/charts/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js"></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/lightbox.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">

function setTab(name,cursel,n){
	//for(i=1;i<=n;i++){
	//	var menu=document.getElementById(name+i);
	//	var con=document.getElementById("con_"+name+"_"+i);
	//	menu.className=i==cursel?"hover":"";
	//	con.style.display=i==cursel?"block":"none";
	//}
	searchForm.action="<%=request.getContextPath()%>/energyCZConsumeYearInfo.action?tjflchildern=<%=tjflchildern %>";
	searchForm.submit();
}
var tableidArray = new Array('table1','table2');
onloadEvent(showtable);
var obj = new Object();

function searchSubmitChart(){
 searchForm.action="<%=request.getContextPath()%>/energyCZConsumeYearInfoCharts.action?tjflchildern=<%=tjflchildern %>";
 searchForm.submit();
}

function searchSubmit(){
 searchForm.action="<%=request.getContextPath()%>/energyCZConsume.action";
 searchForm.submit();
}


</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
		<td>��ǰλ�ã��ܺ�ˮƽ����ϵͳ&gt;&gt; ��Ҫ��ҵ��Դ����״��&gt;&gt;ȫ���ܺ�״������&gt;&gt;��Ȳ�ֵ�ܺĻ���</td>
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
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${zhnyxfldl=='zhnyxfldl'}">checked="checked"</c:if>   value="zhnyxfldl"/>�ۺ��ܺ�&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzcz=='gyzcz'}">checked="checked"</c:if>   value="gyzcz"/>��ҵ�ܲ�ֵ&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzjz=='gyzjz'}">checked="checked"</c:if>   value="gyzjz"/> ��ҵ����ֵ&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${dwgyzczdl=='dwgyzczdl'}">checked="checked"</c:if>   value="dwgyzczdl"/>��Ԫ��ҵ��ֵ�ܺ�&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${wyzjznhdl=='wyzjznhdl'}">checked="checked"</c:if>   value="wyzjznhdl"/> ��Ԫ����ֵ�ܺ�&nbsp;				     
				     
					${nd}��&nbsp; 
					 <c:if test="${tjfl==1}">���ص�����</c:if><c:if test="${tjfl==2}">����ҵ</c:if><c:if test="${tjfl==3}">������</c:if>-
					 <c:if test="${xhlx==1}">�ܺ�</c:if><c:if test="${xhlx==2}">ˮ��</c:if>
				 </td>	
				 	<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmitChart();"><span class="search">��ѯ</span></a></td>
				<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit();"><span class="search">����</span></a></td>
           </tr>
          </table>		
		</form>
	 </fieldset>
</td>
</tr>
 </table>
 </div>   
    <br />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
	 
	 <tr>
	    <td>
	 	   <table border="0" cellpadding="0" cellspacing="0" class="Menubox">
			  <tr>
				<td><ul>
				  <li id="one1" onmousedown="setTab('one',1,2)">�����б�</li>
				  <li id="one2" onmousedown="setTab('one',2,2)" class="hover" >ͼ��</li>
				</ul></td>
			  </tr>
			</table>
	     </td>
	 </tr>
	 
	 <tr>
      	<td>
	  		<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox" >
				<tr>
				  <td>
				 	
				 		<!--�б�   -->
						<table width="100%" id="con_one_1"  cellpadding="0" cellspacing="0" class="list" style="display:none">
						    <tr>
						    <td colspan="11"> <a class="btn" style="float: right;" onclick="" href="#"><span class="search">�� ��</span></a></td>
						    </tr>
							
						</table>

                       <!--ͼ��   -->
						<table width="100%" id="con_one_2" >
							<tr><td>
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
							</td></tr>
						</table>
			 
				  </td>
				</tr>  
				</table>	
		 </td>
	</tr>

</table>
</body>
</html>
