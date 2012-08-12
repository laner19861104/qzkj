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
         <script src="templates/js/ajax.js" type="text/javascript"></script>
		<script src="templates/js/setmonth1.js"></script>
			
		<script language="JavaScript" src="<%=request.getContextPath() %>/FusionChartsFree/JSClass/FusionCharts.js"></script>
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


/*工作区内小菜单*/
.fenlei ul {
	margin: 2px 1px 1px 1px;
	padding: 0px;
	list-style-type: none;
	overflow-y: auto
}

.fenlei ul li {
	background-repeat: no-repeat;
	border-bottom: 1px solid #fff;
	background-position: 3px top;
}

.fenlei ul li a {
	height: 12px;
	display: block;
	color: #0066CC;
	text-decoration: none;
	border: none;
	padding-top: 5px;
	padding-left: 15px;
	margin-bottom: 5px;
	padding-bottom: 4px;
}

.fenlei ul li a:hover {
	background-color:#0066FF;
	height:12px;
	color: #ffffff;
	border: none;
}

.fenlei ul li a span {
	float: right;
	margin-right: 5px; *
	margin-right: 3px; *
	margin-top: -12px;
	display: none;
}

.fenlei ul li a:hover span {
	display: block;
}

.fenlei ul li a:hover span img {
	cursor: default;
	border: none;
}
</style>
</head>

<body>
<script>
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
function searchSubmit(){
if(formlist.nd2.value>formlist.nd1.value){
alert("基期时间应小于查询时间");
return;
}
  var tjfl='${tjfl}';
  //alert(formlist.tjfl.value+"="+tjfl);
  if(formlist.tjfl.value!=tjfl)
     formlist.bh.value="";
  formlist.submit();
}



function tjflShowChart(urls,bh){
	
	formlist.bh.value=bh;
	

	urls=urls+"&nd1="+formlist.nd1.value;
	urls=urls+"&yuefen1=1";
	urls=urls+"&nd2="+formlist.nd2.value;
	urls=urls+"&yuefen2=12";
//	urls=urls+"&jd1="+formlist.jd2.value;
//	urls=urls+"&jd2="+formlist.jd2.value;
	urls=urls+"&tjlx="+formlist.tjlx.value;
	urls=urls+"&zsfs="+formlist.zsfs.value;
	urls=urls+"&tjfl="+formlist.tjfl.value;
	urls=urls+"&bh="+formlist.bh.value;
	showChart(urls);
}

function actionShowChart(urls){

	urls=urls+"&nd1="+formlist.nd1.value;
//	urls=urls+"&yuefen1="+formlist.yuefen1.value;
	urls=urls+"&nd2="+formlist.nd2.value;
//	urls=urls+"&yuefen2="+formlist.yuefen2.value;
	urls=urls+"&tjlx="+formlist.tjlx.value;
	urls=urls+"&zsfs="+formlist.zsfs.value;
	urls=urls+"&tjfl="+formlist.tjfl.value;
	urls=urls+"&bh="+formlist.bh.value;
	//alert(urls)
	window.location.href=urls; 
}

function processRequest() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) { 
			eval(http_request.responseText);		   

		} 
	}
}

function showChart(urls){
	//ajax 取东西 插入到 id=showCompany的层
	http_request = false;
	send_request(urls);
	processRequest();
//	 document.getElementById("companyName").innerHTML=nd+qymc+"-上报情况";

}

</script>
<div class="position">当前位置：能耗水平评价系统 >> 主要行业能源利用状况 >> 全市能耗状况分析 >> 重点能耗指标</div>
<br/>
          <form action="${path}/energyUse.action" name="formlist" method="post">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
				<tr>
					<td>
					<fieldset>
						<legend>查询条件</legend>
						
						<table border="0" cellpadding="0" cellspacing="3" >
				            <tr>
			                  <th>时间:</th>
							  <td  id="nd1">
				                  <select name="nd1"  id="nd1" >
				                     <c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd1}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>年
							  </td>
							  <!-- 
							  <td  id="yuefen1">
				                  <select name="yuefen1"  id="yuefen1" >
				 
										<c:forEach items="${yfList}" var="tmp" varStatus="varsta" >
											<option value="${tmp}" <c:if test="${tmp==yuefen1}">selected</c:if>>${tmp}</option>
										</c:forEach>	
									</select>月
							  </td>
							   <td style="display:none" id="nd2">
				                  <select name="nd2"  id="nd2" >
				                         <c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd2}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							  <td  id="yuefen2">
				                  <select name="yuefen2"  id="yuefen2" >
				   
										<c:forEach items="${yfList}" var="tmp" varStatus="varsta" >
											<option value="${tmp}" <c:if test="${tmp==yuefen2}">selected</c:if>>${tmp}</option>
										</c:forEach>	
									</select>月
							  </td>
							  <td style="display:none" id="jd1">
				                  <select name="jd1"  id="jd1" >
				                        <option value="" >----</option>
										<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							  <td style="display:none" id="jd2">
				                  <select name="jd2"  id="jd2" >
				                        <option value="" >----</option>
										<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							   -->
<!--				              <th>统计类型:</th>-->
				              <td>
<!--				              <select name="tjlx"  id="tjlx" >-->
<!--										<option value="1" <c:if test="${tjlx==1}">selected</c:if>>汇总统计</option>-->
<!--										<option value="2" <c:if test="${tjlx==2}">selected</c:if>>趋势统计</option>-->
<!--									</select>-->
									<input name="tjlx" value='1' id="tjlx" type='hidden'/>
						      </td>
						      
<!--				              <th>展示方式:</th>-->
				              <td><!-- <select name="zsfs"  id="zsfs">
										<option value="1" <c:if test="${zsfs==1}">selected</c:if>>图层显示</option>
										<option value="2" <c:if test="${zsfs==2}">selected</c:if>>数据列表</option>
										<option value="3" <c:if test="${zsfs==3}">selected</c:if>>综合显示</option>
									</select> -->
									<input name="zsfs" value='3' id="zsfs" type='hidden'/>
						      </td>
				              <th>统计分类:</th>
				              <td>  <select name="tjfl" id="tjfl" >
										<option value="1" <c:if test="${tjfl==1}">selected</c:if>>重点类型</option>
<!--										<option value="2" <c:if test="${tjfl==2}">selected</c:if>>行业</option>-->
										<option value="3" <c:if test="${tjfl==3}">selected</c:if>>区域</option>
									</select>
							  </td>
							  <th>基期:</th>
							  <td>
				                  <select name="nd2"  id="nd2" >
				                     <option value="2010">2010</option>
				                     <option value="2015">2015</option>
				                     <option value="2020">2020</option>
				                     <option value="2025">2025</option>
				                     <option value="2030">2030</option>
				                     <option value="2035">2035</option>
				                     <option value="2040">2040</option>
				                     <option value="2045">2045</option>
				                     <option value="2050">2050</option>
									</select>年
							  </td>
							  
							  <td width="500"></td>
					          <td>
					            <input name="urlaction" type="hidden" value="${urlaction}"/>
					            <input name="bh" type="hidden" value="${bh}"/>
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
		<td valign="top"><ul>
		<%String action="outputValue";
		  if(request.getAttribute("urlaction")!=null && !request.getAttribute("urlaction").equals(""))
		     action=request.getAttribute("urlaction").toString(); 
		  if(action.equals("outputValue")){%>
			<li id="one1"  class="hover"><span style="font-size:12px;">工业总产值</span></li>
		 <% }else{%>
		 	<li id="one1"><span style="font-size:12px;"><a href="#" onclick="actionShowChart('${path}/energyUse.action?urlaction=outputValue')" > 工业总产值 </a></span></li>
		 <% } 
		  if(action.equals("useCoal")){%>
			<li id="one2"  class="hover"><span style="font-size:12px;">综合能源消费量</span></li>
		 <% }else{%>
		 	<li id="one2"><span style="font-size:12px;"><a href="#" onclick="actionShowChart('${path}/energyUse.action?urlaction=useCoal')" > 综合能源消费量 </a></span></li>
		 <% }
		  if(action.equals("useEletricity")){%>
			<li id="one3"  class="hover"><span style="font-size:12px;">万元工业产值能耗</span></li>
		 <% }else{%>
		 	<li id="one3"><span style="font-size:12px;"><a href="#" onclick="actionShowChart('${path}/energyUse.action?urlaction=useEletricity')" > 万元工业产值能耗 </a></span></li>
		 <% } 
		  if(action.equals("wyzjznhacion")){%>
			<li id="one4"  class="hover"><span style="font-size:12px;">万元增加值能耗 </span></li>
		 <% }else{%>
		 	<li id="one4"><span style="font-size:12px;"><a href="#" onclick="actionShowChart('${path}/energyUse.action?urlaction=wyzjznhacion')" >万元增加值能耗  </a></span></li>
		 <% } 	
		   if(action.equals("nqslaction")){%>
			<li id="one5"  class="hover"><span style="font-size:12px;">年取水量</span></li>
		 <% }else{
		 %>
		 	<li id="one5"><span style="font-size:12px;"><a href="#" onclick="actionShowChart('${path}/energyUse.action?urlaction=nqslaction')" > 年取水量 </a></span></li>
		 <% } %>
		  	
		</ul></td>
	  </tr>
	</table>


    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
      <tr>
        <td valign="top"><fieldset >
          <legend></legend>      
         <table width="100%" height="500" border="0" cellpadding="0" cellspacing="0">
			<tr>
			  <td valign="top">
			     <div id="showCart">  
					   <table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
						  <tr> 
						     <td valign="top" class="text" align="center"> 
						    	<div id="chartdiv"  align="center"></div>
<!--						        <script type="text/javascript">-->
<!--								   var chart = new FusionCharts("${path}/charts/Charts/MultiAxisLine.swf", "ChartId", "750", "400", "0", "0");-->
<!--								   chart.setDataXML("${xmlStr}");	   -->
<!--								   chart.render("chartdiv");-->
<!--								   -->
<!--								</script> -->
						     </td>
						  </tr>
						  <tr>
						    <td valign="top" class="text" >&nbsp;</td>
						  </tr>
						</table>   
				  </div>
				</td>
				
			</tr>
		</table>	 
     </fieldset>
     </td>
     <td valign="top"><fieldset ><legend>${tjflname}</legend>
		   <table width="150" height="500" border="0" cellpadding="0" cellspacing="0" >
			    <tr>
				  <td valign="top">
					  <div class="fenlei">
						<ul>
							<c:forEach items="${tjflList}" var="tmp" varStatus="varsta" >
							<li><a href="#" onclick="tjflShowChart('${path}/importenergyShowChart.action?urlaction=${urlaction}','${tmp.bh}')" >${tmp.mc} </a></li>
							</c:forEach> 
						</ul>
					  </div>
				  </td>
				</tr>
			    
			</table>	
		</fieldset></td>
   </tr>
</table>
<script type="text/javascript">
   showChart('${path}/importenergyShowChart.action?urlaction=${urlaction}&nd1=${nd1}&yuefen1=${yuefen1}&nd2=${nd2}&yuefen2=${yuefen2}&tjlx=${tjlx}&zsfs=${zsfs}&tjfl=${tjfl}&bh=${bh}');
</script>
</body>

