<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="net.sf.json.JSONArray"%>
<%@ page import="net.sf.json.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	
	//Map searchMap=(Map)request.getAttribute("searchMap");
	if(session.getAttribute("sysuser")!=null){
   		
	}else{
	    response.sendRedirect("/"+request.getContextPath());
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<link href="templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="templates/js/tdcolor.js" type="text/javascript"></script>
<script src="My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="templates/js/lightbox.js" type="text/javascript"></script>
<script src="templates/js/ajax.js" type="text/javascript"></script>
<script type="text/javascript">
var tableidArray = new Array('table1');
onloadEvent(showtable);


function openWindow(strfileName, intWidth, intHeight) {
    var StrWindowName = "InfoWindow";
    var url = strfileName;
    var newtop;
    var newleft = (screen.width - intWidth) / 2;
    if (intHeight <= 900)
        newtop = (screen.height - intHeight) / 2;
    else
        newtop = 0;
   //window.showModalDialog(url,window,"dialogWidth:" + intWidth + "px;dialogHeight:" + intHeight + "px;center:yes;status:no;scroll:yes;help:no;");
    
    var nwin = window.open(url, StrWindowName, "toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,top=" + newtop + ",left=" + newleft + ",width=" + intWidth + ",height=" + intHeight);
    nwin.focus();
}

function searchSubmit(){
  formlist.submit();
}
</script>

</head>
<!-- companySearchEnyRpt -->
<body>
<div class="position">当前位置：<a href="${path}/templates/energy/report/rpt_map.jsp">能源消耗数据查询</a></div>
<br />
<form name=formlist action="${path}/companySearchEnyRpt" method=post >	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset >
        
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
			<tr>
				<td>
				<fieldset>
					<legend>查询条件</legend>
					
					<table border="0" cellpadding="0" cellspacing="3" >
			            <tr>
		        <!---->   <th>年度:</th>
			              <td>
			                  <select name="nd"  id="nd" >
			                       
									<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
										<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
									</c:forEach>	
								</select>
						  </td>
						 
			              <th>所属区域:</th>
			              <td><select name="ssqy"  id="ssqy" >
			              			<option value="" >所有区域</option>
									<c:forEach items="${dqList}" var="tmp" varStatus="varsta" >
										<option value="${tmp.bh}" <c:if test="${tmp.bh==ssqy}">selected</c:if>>${tmp.mc}</option>
									</c:forEach>	
								</select>
					      </td>
					      
			              <th>行业分类:</th>
			              <td><select name="hyfl"  id="hyfl" style="width:150px;">
			              			<option value="" >所有分类</option>
									<c:forEach items="${hyflList}" var="tmp" varStatus="varsta" >
										<option value="${tmp.bh}" <c:if test="${tmp.bh==hyfl}">selected</c:if>>${tmp.mc}</option>
									</c:forEach>
								</select>
					      </td>
<!--			              <th>单位类型:</th>-->
<!--			              <td>  <select name="dwlx" id="dwlx" style="width:150px;">-->
<!--			              			<option value="" >所有类型</option>-->
<!--									<c:forEach items="${dwlxList}" var="tmp" varStatus="varsta" >-->
<!--										<option value="${tmp.bh}" <c:if test="${tmp.bh==dwlx}">selected</c:if>>${tmp.mc}</option>-->
<!--									</c:forEach>-->
<!--								</select>-->
<!--						  </td>-->
						 
						  <th>重点类型:</th>
			              <td><select name="zdlx" id="zdlx">
			              		<option value="" >所有类型</option>
								<c:forEach items="${zdlxList}" var="tmp" varStatus="varsta" >
									<option value="${tmp.bh}" <c:if test="${tmp.bh==zdlx}">selected</c:if>>${tmp.mc}</option>
								</c:forEach>
							</select>
						  </td>
						  
				          <td>
							<a class="btn"  onClick="searchSubmit()" href="javascript:void(0);"><span class="search">查 询</span></a>
						  </td>
						  
			            </tr>
			          </table>
			    
				</fieldset>								
				</td>
			</tr>
	    </table>
	  
       
       <br />
          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list" id="table1">
			<tr>
			  
			  <th>企业名称</th>
			  <th>行业</th>
<!--			  <th>类型</th>-->
			  <th>重点类型</th>
			  <th>区域</th>
			  <th>上报情况</th>
			</tr>
			
				<c:forEach items="${viewList.items}" var="tmp" varStatus="varsta" >
				<tr>
<!--				  <td><a href="#" onclick="showCompany('showCompanyDiv','${tmp.dwbh}','${nd}','${tmp.yd}','${tmp.dwmc}')" >  ${tmp.dwmc} </a></td>-->
				  <td> ${tmp.dwmc}</td>
				  <td> ${tmp.hyfl}</td>
<!--				  <td> ${tmp.dwlx}</td>-->
				  <td> ${tmp.zdlx}</td>
				  <td> ${tmp.ssqy}</td>
				  <td align="center">
				  <a href="#" onclick="showCompany('showCompanyDiv','${tmp.dwbh}','${nd}','${tmp.yd}','${tmp.dwmc}')">年报</a>
				 |<a href="#" onclick="showCompany1('showCompanyDiv1','${tmp.dwbh}','${nd}','${tmp.yd}','${tmp.dwmc}')">月报</a></td>
				</tr>
				</c:forEach>

	    </table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="page">
			<tr>
				<td> ${viewList.pagefooter} </td>
			</tr>
		</table>
         
        </fieldset></td>
      </tr>
</table>
</form>
<!--弹出层的内容-->
<div id="idBox" class="lightbox" style="width:960px;height:500px">
	<h1 id="idBoxHead"><div id="companyName">上报情况</div><span><img src="templates/image/quit.png" id="idBoxCancel"  /></span></h1>
	<div class="content">
	    
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="list">
		  <tr>
			<td><fieldset>
			  <div id="showCompanyDiv">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
				   <tr>
					  <th>报表</th>
					  <th>年报</th>
					  
					</tr>
			  </table>
			  
              </div>
			</fieldset></td>
		  </tr>
	  </table>
	</div>
</div>
<div id="idOverlay"></div>

<script>
var box = new LightBox("idBox", "idOverlay", { Center: true });
var drag = new Drag("idBox", "idBoxHead", { mxContainer: document.documentElement, Lock: true });
$("idBoxCancel").onclick = function(){ box.Close(); }
//$("idBoxCancel2").onclick = function(){ box.Close(); }
function processRequest() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) { 
    	  document.getElementById("showCompanyDiv").innerHTML=http_request.responseText;

		} 
	}
}
function showCompany(divid,qybh,nd,yd,qymc){
	//ajax 取东西 插入到 id=showCompany的层
	
	http_request = false;
	send_request("${path}/companyYearEnyRpt?dwbh="+qybh+"&nd="+nd+"&yd="+yd);
	processRequest();
	 document.getElementById("companyName").innerHTML=nd+qymc+"-上报情况";
	 box.Show();
}


box.Close();
box.Fixed = false;
drag.Lock = false;

</script>



<!--弹出层的内容-->
<div id="idBox1" class="lightbox" style="width:960px;height:500px">
	<h1 id="idBoxHead1"><div id="companyName1">上报情况</div><span><img src="templates/image/quit.png" id="idBoxCancel1"  /></span></h1>
	<div class="content">
	    
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="list">
		  <tr>
			<td><fieldset>
			  <div id="showCompanyDiv1">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list">
				   <tr>
					  <th>报表</th>
					  <th>1月份</th>
					  <th>2月份</th>
					  <th>3月份</th>
					  <th>4月份</th>
					  <th>5月份</th>
					  <th>6月份</th>
					  <th>7月份</th>
					  <th>8月份</th>
					  <th>9月份</th>
					  <th>10月份</th>
					  <th>11月份</th>
					  <th>12月份</th>
					</tr>
			  </table>
			  
              </div>
			</fieldset></td>
		  </tr>
	  </table>
	</div>
</div>
<div id="idOverlay1"></div>

<script>
var box1 = new LightBox("idBox1", "idOverlay1", { Center: true });
var drag1 = new Drag("idBox1", "idBoxHead1", { mxContainer: document.documentElement, Lock: true });
$("idBoxCancel1").onclick = function(){ box1.Close(); }
//$("idBoxCancel2").onclick = function(){ box.Close(); }
function processRequest1() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) { 
    	  document.getElementById("showCompanyDiv1").innerHTML=http_request.responseText;
		} 
	}
}
function showCompany1(divid,qybh,nd,yd,qymc){
	//ajax 取东西 插入到 id=showCompany的层
	http_request = false;
	send_request("${path}/companyMonthEnyRpt?dwbh="+qybh+"&nd="+nd+"&yd="+yd);
	setTimeout('processRequest1()',2000) ;    
	 document.getElementById("companyName1").innerHTML=nd+qymc+"-上报情况";
	 box1.Show();
}


box1.Close();
box1.Fixed = false;
drag1.Lock = false;

</script>
</body>
</html>
