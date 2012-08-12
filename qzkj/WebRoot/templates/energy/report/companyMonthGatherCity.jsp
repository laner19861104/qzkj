<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bip.sys.user.po.SysUsers"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	pageContext.setAttribute("yuefen",new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});//new String[]{ "1 ", "2 ", "3 ", "4 "}
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>

<link href="${path}/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="${path}/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="${path}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${path}/templates/js/listcell.js"></script>
<script src="${path}/templates/js/util.js"></script>
<title>  </title>

<script>
function thisheight(){	
var thirdheight=document.documentElement.clientHeight-195;
var _div=document.getElementById("DivIDremain1"); 
var _height=parseInt(_div.style.height);  
_div.style.height=thirdheight+"px"; 

}

</script>


<script type="text/javascript">
var tableidArray = new Array('table1');
onloadEvent(showtable);
</script>
<SCRIPT LANGUAGE=vbscript>            
<!--
    dim row1,col1,sht,isDefined
    sub getCellvar(varname)
        isDefined = cell.GetCellVar(varname,col1,row1,sht)
    end sub
-->
</SCRIPT>

<SCRIPT LANGUAGE=javascript>
<%
Map resMap=(Map)request.getAttribute("resReportMap");
String resStr="";
if(resMap.get("resJson")!=null)//能耗结构数据
    resStr=resMap.get("resJson").toString();
Map sbinfoMap=new HashMap();
if(resMap.get("jobSbInfo")!=null)//报表填写信息
    sbinfoMap=(Map)resMap.get("jobSbInfo");

String userxm="";
if(session.getAttribute("sysuser")!=null){
	SysUsers users=(SysUsers)session.getAttribute("sysuser"); 
    userxm=users.getUserxm();
}else{
    response.sendRedirect("/"+request.getContextPath());
}
//SysUsers users=(SysUsers)session.getAttribute("sysuser"); 

//String companyName=(String)request.getAttribute("companyName");
//String theYear=(String)request.getAttribute("theYear");
%>

var printListLoop=<%=resStr%>;


function init()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("控件注册失败！");
    }
    
   url1="${path}/cellTemplate/companyMonthGatherCity.cll";
   cell.OpenFile(url1,"");    
   var i=0; 
   var pand=true;
   var startrow=0;
   
	getCellVar('title');
   cell.S(col1,row1,0,'${title}');
   
   getCellVar('companyName');
  // alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"${dwmc}");


   //填报人
   getCellVar('tbr');
   cell.S(col1,row1,0,"<%=userxm%>");
   //填报日期
   getCellVar('tbrq');
   cell.S(col1,row1,0,"${tbrq}");
   
   cell.InsertRow(6, printListLoop.length-1,0);
   
   for(i=0;i<printListLoop.length;i++)
   {
      cell_dic=printListLoop[i];

      for(var item in cell_dic)
      {
       if(cell_dic[item]==null)
          continue;
          
        getCellVar(item);
        if(isDefined);
          {
           // alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1+i,0,cell_dic[item]); 
            else
                cell.S(col1,row1+i,0,cell_dic[item]);
            if(pand&&startrow<row1&&row1<1216428){
          	  startrow=row1;
             }
          }
      }
      
      
   }
	cell.CalculateAll();
	   
   //cell.PrintSetSheetOpt(3);
   //cell.PrintPreview(1,0);
   //top.close();
}
function searchSubmit(){
//  var bb=form1.beginyd.value;
//  var ee=form1.endyd.value;
//  if(ee-bb>=0)
 	 form1.submit();
//  else
//     alert("开始月份不能大于结束月份！");
}

function printview(){
   // printview();
    cell.PrintSetOrient(1);
    cell.PrintPreview(1,0);
}
function exportExcel(){
    cell.ExportExcelDlg();
}
</SCRIPT>


<style>
.search td {padding:0px 2px 0px 0px}
fieldset{
	font-size: 12px;
	margin: 5px 10px 0px 5px;
	padding: 5px;
}
fieldset legend {
	margin-left: 10px;
	color: #003366;
	font-weight: bold;
	padding: 0px 10px;
	margin-bottom: 10px;
}
fieldset table td{
	padding:0px 2px 0px 0px;
	font-size:12px
}
fieldset table th{
	font-weight:normal;
	white-space:nowrap;
	font-size:12px
}
fieldset table select{
	font-size:12px;
}
 .list {
	
	border-width: 0px 0px 0px 0px;
	width: 100%;
}

.list td {
	
	border-width: 0px 0px 0px 0px;
	height: 20px;
	padding: 1px 1px 0px;
}
</style>
</head>
<body onload=init();thisheight();>
	<div class="position">当前位置：能源消耗数据库系统 &gt;&gt; 能源消耗数据汇总 &gt;&gt; 综合能耗汇总 &gt;&gt; <a href="#">全市重点用能企业综合能耗汇总表</a></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td>
        <fieldset>
          <legend>查询条件</legend>
          <form name=form1 action="${path}/cityMonthEnyRptCmpCount" method=post >
          <table border="0" cellpadding="0" cellspacing="3"  width="100%">
            <tr>
              <th>年&nbsp;&nbsp;&nbsp;&nbsp;度:</th>
              <td>  <select name="nd"  id="nd" style="width: 150px">
						<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
						</c:forEach>	
					</select>
			  </td>
<!--              <th>月度范围:</th>-->
<!--              <td>-->
<!--                 <select name="beginyd"  id="beginyd" >-->
<!--                   <c:forEach items="${yuefen}" var="tmp" varStatus="varsta" >-->
<!--                     <option value="${tmp}" <c:if test="${tmp==beginyd}">selected</c:if>>${tmp}</option>-->
<!--                   </c:forEach>  -->
<!--                 </select>-->
<!--               <input type="text" id="beginyd" name="beginyd" value="${beginyd}" style="width: 20px" onkeydown="onlyNum()" onchange="chekvalue(this,1)"/>-->
<!--			  -->
<!--			  </td>-->
<!--			   <td>-->
<!--			      <select name="endyd"  id="endyd" >-->
<!--                   <c:forEach items="${yuefen}" var="tmp" varStatus="varsta" >-->
<!--                     <option value="${tmp}" <c:if test="${tmp==endyd}">selected</c:if>>${tmp}</option>-->
<!--                   </c:forEach>  -->
<!--                 </select>-->
			    <!--<input type="text" id="endyd" value="${endyd}"  name="endyd" style="width: 20px"  onkeydown="onlyNum()" onchange="chekvalue(this,12)"/>
			    -->
<!--			  </td>-->
			  <!-- 
              <th>所属区域:</th>
              <td><select name="ssqy"  id="ssqy">
              			<option value="" >所有区域</option>
						<c:forEach items="${dqList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.bh}" <c:if test="${tmp.bh==ssqy}">selected</c:if>>${tmp.mc}</option>
						</c:forEach>	
					</select>
		      </td> -->
              <th>行业分类:</th>
              	<td > <select name="hyfl" id="hyfl" onchange="javascript:searchSubmit(1);" style="width: 150px">
						<option value="1" <c:if test="${hyfl==1}">selected</c:if>>标准行业</option>
						<option value="2" <c:if test="${hyfl==2}">selected</c:if>>传统行业</option>
						
					</select>
					<select name="hyflchild"  id="hyflchild" style="width: 200px">
					    <option value="-1" >全部</option>
					    <c:forEach items="${hyflList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.bh}" <c:if test="${tmp.bh==hyflchild}">selected</c:if>>${tmp.mc}</option>
						</c:forEach> 
					   </select>
					</td>	
<!--              <th>单位类型:</th>-->
<!--              <td>  <select name="dwlx" id="dwlx"  style="width:150px;">-->
<!--              			<option value="" >所有类型</option>-->
<!--						<c:forEach items="${dwlxList}" var="tmp" varStatus="varsta" >-->
<!--							<option value="${tmp.bh}"  <c:if test="${tmp.bh==dwlx}">selected</c:if>>${tmp.mc}</option>-->
<!--						</c:forEach>-->
<!--					</select>-->
<!--			  </td>-->
			 </tr>
			 <tr>
			  <th >重点类型:</th>
              <td><select name="zdlx" id="zdlx" style="width: 150px">
              		<option value="" >所有类型</option>
					<c:forEach items="${zdlxList}" var="tmp" varStatus="varsta" >
						<option value="${tmp.bh}" <c:if test="${tmp.bh==zdlx}">selected</c:if>>${tmp.mc}</option>
					</c:forEach>
				</select>
			  </td>
			   <th>排&nbsp;&nbsp;&nbsp;&nbsp;序:</th>
				  <td>
					  <select name="orderfl"  id="orderfl" style="width: 150px">
					      <option value="1">按综合能耗倒序</option>
					      <option value="2">按万元工业产值能耗倒序</option>     
					  </select>
				 </td>	
<!--				<td width="160"></td>-->
            </tr>
            
            <tr>
               <td colspan="9">
               		<div class="line"></div>
					<a  class="btn btnright" onClick="exportExcel()" href="javascript:void(0);"><span class="export">导出</span></a>
					<a  class="btn btnright" onClick="printview()" href="javascript:void(0);"><span class="print">打印</span></a>
					<a class="btn btnright" onClick="searchSubmit()" href="javascript:void(0);"><span class="search">查 询</span></a>
               </td>
            </tr>
          </table>
         </form>
		  </fieldset>
	    </td>
      </tr>
    </table>
    
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
      <tr>
        <td><fieldset >
           <legend>汇总表</legend>
     
          <table border="100" cellspacing="0" cellpadding="0" class="list" id="table1">         
           <tr>
             <td><div id="DivIDremain1"  style="height:; overflow: auto;position:relative;" ></div></td>
           </tr>
          </table>
          
        </fieldset></td>
      </tr>
    </table>
    

<script type="text/javascript">
  insertCell('DivIDremain1','/fin_pay/images/CellWeb5.CAB', '100%', '100%','cell');
</script>
</body>
</html>
