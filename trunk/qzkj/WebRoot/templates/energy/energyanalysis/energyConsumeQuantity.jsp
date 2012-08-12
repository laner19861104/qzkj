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


			function searchSubmit(){
			  var tjfl='${tjfl}';
			  //alert(formlist.tjfl.value+"="+tjfl);
			  if(formlist.tjfl.value!=tjfl)
			     formlist.bh.value="";
			  formlist.submit();
			}
			
			
			
			function tjflShowChart(urls,bh){
	
				formlist.bh.value=bh;
			
				urls=urls+"&nd="+formlist.nd.value;
				urls=urls+"&yuefen1="+formlist.yuefen1.value;
				urls=urls+"&yuefen2="+formlist.yuefen2.value;
			
				urls=urls+"&fxmb="+formlist.fxmb.value;
				urls=urls+"&tjlb="+formlist.tjlb.value;
				urls=urls+"&tjfl="+formlist.tjfl.value;
				urls=urls+"&bbzt="+formlist.bbzt.value;
				urls=urls+"&bh="+formlist.bh.value;
				
				showChart(urls);
			}
			
			function actionShowChart(urls){
			
				urls=urls+"&nd="+formlist.nd.value;
				urls=urls+"&yuefen1="+formlist.yuefen1.value;
				urls=urls+"&yuefen2="+formlist.yuefen2.value;
				
				urls=urls+"&fxmb="+formlist.fxmb.value;
				urls=urls+"&tjlb="+formlist.tjlb.value;
				urls=urls+"&tjfl="+formlist.tjfl.value;
				urls=urls+"&bbzt="+formlist.bbzt.value;
				urls=urls+"&bh="+formlist.bh.value;
				window.location.href=urls; 
			}
			
			function processRequest() {
				if (http_request.readyState == 4) {
					if (http_request.status == 200) { 
					  //  alert(http_request.responseText);
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

<div class="position">当前位置：能耗水平评价系统 >> 主要行业能源利用状况 >> 企业能耗状况分析 >> 企业能源消费情况</div>
<br/>
          <form action="${path}/energyConsumeQuantity.action" name="formlist" method="post">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
				<tr>
					<td>
					<fieldset>
						<legend>查询条件</legend>
						
						<table border="0" cellpadding="0" cellspacing="3" >
				            <tr>
			                  <th>时间:</th>
				              
							  <td  id="nd">
				                  <select name="nd"  id="nd" >
				   
										<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
											<option value="${tmp.nd}" <c:if test="${tmp.nd==nd1}">selected</c:if>>${tmp.nd}</option>
										</c:forEach>	
									</select>
							  </td>
							  <td  id="yuefen1">
				                  <select name="yuefen1"  id="yuefen1" >
				 
										<c:forEach items="${yfList}" var="tmp" varStatus="varsta" >
											<option value="${tmp}" <c:if test="${tmp==yuefen1}">selected</c:if>>${tmp}</option>
										</c:forEach>	
									</select>
							  </td>
							  
							  <td  id="yuefen2">
				                  <select name="yuefen2"  id="yuefen2" >
				   
										<c:forEach items="${yfList}" var="tmp" varStatus="varsta" >
											<option value="${tmp}" <c:if test="${tmp==yuefen2}">selected</c:if>>${tmp}</option>
										</c:forEach>	
									</select>
							  </td>
							  
							  <th>分析目标:</th>
				              <td><select name="fxmb"  id="fxmb" >
										<option value="1" <c:if test="${tjlx==1}">selected</c:if>>能源消费合计</option>
										<option value="2" <c:if test="${tjlx==2}">selected</c:if>>趋势统计</option>
									</select>
						      </td>
				              <th>统计类别:</th>
				              <td><select name="tjlb"  id="tjlb" >
										<option value="1" <c:if test="${tjlx==1}">selected</c:if>>大类汇总</option>
										<option value="2" <c:if test="${tjlx==2}">selected</c:if>>趋势统计</option>
									</select>
						      </td>
						      
				              <th>统计分类:</th>
				              <td>  <select name="tjfl" id="tjfl" >
										<option value="1" <c:if test="${tjfl==1}">selected</c:if>>重点类型</option>
										<option value="2" <c:if test="${tjfl==2}">selected</c:if>>行业</option>
										<option value="3" <c:if test="${tjfl==3}">selected</c:if>>区域</option>
									</select>
							  </td>
							 
							  <th>报表状态:</th>
				              <td><select name="bbzt" id="bbzt">
				              		<option value="0" <c:if test="${bbzt==0}">selected</c:if>>审核通过</option>
									<option value="1" <c:if test="${bbzt==1}">selected</c:if>>已上报</option>
								</select>
							  </td>
							  
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
		<td><ul>
			<li id="one1"  class="hover"><span style="font-size:12px;">能源消费分行业构成表</span></li>
		  	<li id="one2"><span style="font-size:12px;"><a href="#" target="_self">分行业能源消费实物量合计</a></span></li>
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
							  <th width="291" height="40" rowspan="2"><p >行业</p></th>
							  <th colspan="2"><p >2010年</p></th>
							  <th colspan="2"><p >同期增减</p></th>
					     </tr>
						  <tr>
							  <th width="235"><p >综合能源消费量(万吨标准煤)</p></th>
							  <th width="235"><p >占全市企业能源消费量的比重(%)</p></th>
							  <th width="235"><p >综合能源消费量(万吨标准煤)</p></th>
							  <th width="235"><p >占全市企业能源消费量的比重(%)</p></th>
						  </tr>
						  
				  
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
						  </tr>
						  <tr>
						  <td align="center">1</td>
						  <td align="center">2222</td>
						  <td align="center">3333</td>
						  <td align="center">4444</td>
						  <td align="center">5555</td>
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
				    	<div id="chartdiv" align="center"> </div>
				        <script type="text/javascript">
						   var chart = new FusionCharts("${path}/charts/Charts/FCF_MSColumn2D.swf", "ChartId", "600", "380", "0", "0");
						   chart.setDataXML("");	   
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
     
     <td valign="top">
        <fieldset ><legend>${tjflname}</legend>
		   <table width="150" height="670" border="0" cellpadding="0" cellspacing="0" class="tableout">
			    <tr>
				  <td valign="top">
					  <div class="fenlei">
						<ul>
							<c:forEach items="${tjflList}" var="tmp" varStatus="varsta" >
							<li><a href="#" onclick="tjflShowChart('${path}/energyQuantityShowChart.action?urlaction=${urlaction}','${tmp.bh}')" >${tmp.mc} </a></li>
							</c:forEach> 
						</ul>
					  </div>
				  </td>
				</tr>
			    
			</table>	
		</fieldset>

		</td>
     
     
   </tr>
</table>


</body>

