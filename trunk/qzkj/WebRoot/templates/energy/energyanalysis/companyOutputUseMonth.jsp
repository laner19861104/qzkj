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
					alert("��ѡ��ʱ��");
					return;
				}
				
				if(formlist.qy.value==""){
					alert("��ѡ������");
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

<div class="position">��ǰλ�ã��ܺ�ˮƽ����ϵͳ >> ��Ҫ��ҵ��Դ����״�� >> ��ҵ�ܺ�״������ >> ��ҵ��ֵ�ܺ����</div>
<br/>
          <form action="${path}/zbpf" name="formlist" method="post">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
				<tr>
					<td>
					<fieldset>
						<legend>��ѯ����</legend>
						
						<table border="0" cellpadding="0" cellspacing="3" >
				            <tr>
			        <!---->   <th>���:</th>
				              <td>
				                  <select name="nd"  id="nd" >
				                        <option value="" >----</option>
										<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							 
				              <th>��������:</th>
				              <td><select name="ssqy"  id="ssqy" >
				              			<option value="" >��������</option>
										<c:forEach items="${dqList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==ssqy}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>	
									</select>
						      </td>
						      
				              <th>��ҵ����:</th>
				              <td><select name="hyfl"  id="hyfl" style="width:150px;">
				              			<option value="" >���з���</option>
										<c:forEach items="${hyflList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==hyfl}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>
									</select>
						      </td>
				              <th>��λ����:</th>
				              <td>  <select name="dwlx" id="dwlx" style="width:150px;">
				              			<option value="" >��������</option>
										<c:forEach items="${dwlxList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.bh}" <c:if test="${tmp.bh==dwlx}">selected</c:if>>${tmp.mc}</option>
										</c:forEach>
									</select>
							  </td>
							 
							  <th>�ص�����:</th>
				              <td><select name="zdlx" id="zdlx">
				              		<option value="" >��������</option>
									<c:forEach items="${zdlxList}" var="tmp" varStatus="varsta" >
										<option value="${tmp.bh}" <c:if test="${tmp.bh==zdlx}">selected</c:if>>${tmp.mc}</option>
									</c:forEach>
								</select>
							  </td>
							  
					          <td>
								<a class="btn"  onClick="searchSubmit()" href="javascript:void(0);"><span class="search">�� ѯ</span></a>
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
			<li id="one1"  class="hover"><span style="font-size:12px;">���·ݣ���ҵ���²�ֵ�ܺ����</span></li>
		  	<li id="one2"><span style="font-size:12px;"><a href="#" target="_self">	����ȣ���ҵ�����ֵ�ܺ����</a></span></li>
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
					    <th height="40" colspan="2" rowspan="2"><p >ָ������</p></th>
					    <th colspan="12"><p >�·�</p>		      </th>
					  </tr>
					  <tr>
					    <td width="75" valign="center" ><p align="center" >1</p></td>
					    <td width="75" valign="center" ><p align="center" >2</p></td>
					    <td width="75" valign="center" ><p align="center" >3</p></td>
					    <td width="75" valign="center" ><p align="center" >4 </p></td>
					    <td width="75" valign="center" ><p align="center" >5</p></td>
					    <td width="75" valign="center" ><p align="center" >6</p></td>
					    <td width="75" valign="center" ><p align="center" >7 </p></td>
					    <td width="75" valign="center" ><p align="center" >8 </p></td>
			            <td width="75" valign="center" ><p align="center" >9 </p></td>
			            <td width="75" valign="center" ><p align="center" >10 </p></td>
			            <td width="75" valign="center" ><p align="center" >11 </p></td>
			            <td width="84" valign="center" ><p align="center" >12 </p></td>
				      </tr>
					  
			  
					  <tr>
					  <td width="222" rowspan="2"><div align="center">
					    <p >��λ��ҵ�ܲ�ֵ�ܺ�</p>
					  </div></td>
					  <td width="100"><div align="center">����ֵ</div></td>
					  <td width="75"><div align="center">2222</div></td>
					  <td width="75"><div align="center">3333</div></td>
					  <td width="75"><div align="center">3333</div></td>
					  <td width="75"><div align="center">4444</div></td>
					  <td width="75"><div align="center">5555</div></td>
					  <td width="75"><div align="center"></div></td>
					  <td width="75"><div align="center">6666</div></td>
					  <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="84"><div align="center">7777</div></td>
					  </tr>
					  <tr>
					    <td><div align="center">�ȼ�ֵ</div></td>
				        <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="84"><div align="center">3333</div></td>
					  </tr>
			          <tr>
					  <td rowspan="2"><div align="center">
					    <p >��Ԫ��ҵ����ֵ�ܺ�</p>
					  </div></td>
					  <td><div align="center">����ֵ</div></td>
					  <td width="75"><div align="center">2222</div></td>
					  <td width="75"><div align="center">3333</div></td>
					  <td width="75"><div align="center"></div></td>
					  <td width="75"><div align="center">4444</div></td>
					  <td width="75"><div align="center">5555</div></td>
					  <td width="75"><div align="center"></div></td>
					  <td width="75"><div align="center">6666</div></td>
					  <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="75"><div align="center">7777</div></td>
			          <td width="84"><div align="center">7777</div></td>
					  </tr>
					  <tr>
					    <td><div align="center">�ȼ�ֵ</div></td>
				        <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="75"><div align="center">3333</div></td>
					    <td width="84"><div align="center">3333</div></td>
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
				    	<div id="chartdiv" align="center"> ͼ�� </div>
				        <script type="text/javascript">
						   var chart = new FusionCharts("${path}/charts/Charts/MultiLevelPie.swf", "ChartId", "750", "400", "0", "0");
						  // chart.setDataURL("${path}/productUseToXml.action");	
						   chart.setDataXML("<chart palette='4' caption='CPU Usage' subcaption='(Last 10 Hours)' xAxisName='Time' showValues='0' divLineAlpha='100' numVDivLines='4' vDivLineAlpha='0' showAlternateVGridColor='1' alternateVGridAlpha='5' canvasPadding='0' labelDisplay='NONE'><categories><category label='1' /><category label='2' /><category label='3' /><category label='4' /><category label='5' /><category label='6' /><category label='7' /><category label='8' /><category label='9' /><category label='10' /><category label='11' /><category label='12' /><category label='13' /><category label='14' /><category label='15' /><category label='16' /><category label='17' /><category label='18' /><category label='19' /><category label='19' /></categories> <axis title='CPU Usage' titlePos='left' tickWidth='10' divlineisdashed='1' umberSuffix='%'><dataset seriesName='CPU 1' lineThickness='1' color='CC0000'> <set value='16' /><set value='19' /><set value='16' /><set value='17' /><set value='16' /><set value='18' /><set value='15' /><set value='14' /><set value='19' /><set value='18' /></dataset></axis></chart>");	   
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
