<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ���ۼ�����</title>
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
	<td><div style="margin-left: 17px;">��ǰλ�ã��ܺ�ˮƽ����ϵͳ&gt;&gt; ��Ҫ��ҵ��Դ����״��&gt;&gt;ȫ���ܺ�״������&gt;&gt;��Ⱦ���ָ��</div></td>
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
             <s:select name="unittype"  label="��λ����"  cssStyle="width:200px;" labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="ȫ��" list="importTypeList" listKey="bh" listValue="mc"   />
             </table></td>
              
              <td><table>
             <s:select name="classtype"  label="��ҵ"  cssStyle="width:200px;" labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="ȫ��" list="classTypeList" listKey="bh" listValue="mc"   />
             </table></td>
            
            <td><table>
             <s:select name="areatype"  label="����"  cssStyle="width:200px;" labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="ȫ��" list="areaNameList" listKey="bh" listValue="mc"   />
             </table></td>
                </tr>
             
           
			<tr >
			   <td colspan="3" style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
					   ָ��ѡ��
                     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${zhnyxfldl=='zhnyxfldl'}">checked="checked"</c:if>   value="zhnyxfldl"/>�ۺ��ܺ�&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzcz=='gyzcz'}">checked="checked"</c:if>   value="gyzcz"/>��ҵ�ܲ�ֵ&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzjz=='gyzjz'}">checked="checked"</c:if>   value="gyzjz"/> ��ҵ����ֵ&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${dwgyzczdl=='dwgyzczdl'}">checked="checked"</c:if>   value="dwgyzczdl"/>��Ԫ��ҵ��ֵ�ܺ�&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${wyzjznhdl=='wyzjznhdl'}">checked="checked"</c:if>   value="wyzjznhdl"/> ��Ԫ����ֵ�ܺ�&nbsp;				     
				 </td>
			  </tr>
				<tr>
				       <td colspan="3" width="100%" ><a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit();"><span class="search">�� ѯ</span></a></td>		
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
				  <li id="one1" onmousedown="setTab('one',1,2)"  class="hover">��Ⱦ���ָ�����</li>
				  <li id="one2" onmousedown="setTab('one',2,2)" >��Ⱦ���ָ��ɳ��Է���</li>
				</ul></td>
			   </tr>
			 </table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			  <tr>
				<td>
			
			<!--���ع�ҵ  -->
						
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
						
				<!--�ص���ҵ  -->					
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
