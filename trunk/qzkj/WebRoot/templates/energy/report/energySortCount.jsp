<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	pageContext.setAttribute("yuefen",new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});//new String[]{ "1 ", "2 ", "3 ", "4 "}
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);


  
%>
<html>
<head>

<link href="${path}/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="${path}/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="${path}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${path}/templates/js/listcell.js"></script>
<script src="${path}/templates/js/util.js"></script>
<title>  </title>




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
String lbStr="";
if(resMap.get("lbJson")!=null)//�ܺĽṹ����
    lbStr=resMap.get("lbJson").toString();
    
String resStr="";
if(resMap.get("resJson")!=null)//�ܺĽṹ����
    resStr=resMap.get("resJson").toString();
    
Map sbinfoMap=new HashMap();
if(resMap.get("jobSbInfo")!=null)//������д��Ϣ
    sbinfoMap=(Map)resMap.get("jobSbInfo");

if(session.getAttribute("sysuser")!=null){
	
}else{
    response.sendRedirect("/"+request.getContextPath());
}
%>

var printListLoop=<%=resStr%>;
var lbListLoop=<%=lbStr%>;

function init()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("�ؼ�ע��ʧ�ܣ�");
    }
    
   url1="${path}/cellTemplate/energySortCount.cll";
   cell.OpenFile(url1,"");    
   
   var pand=true;
   var startrow=0;
   cell.InsertCol(3,lbListLoop.length-1,0);
  // alert(printListLoop.length)
   cell.InsertRow(4, printListLoop.length-1,0);
   
   for(i=0;i<lbListLoop.length;i++){
      lb_dic=lbListLoop[i];
      cell.S(2+i,2,0,lb_dic["mc"]);
   	  cell.DefineCellVar(lb_dic["bh"],2+i, 3, 0) 
   //	 alert("==");
   	  var ll=numberToAbc(2+i,1);
   	  //  alert("=="+ll);
   	 // alert("��="+(2+i)+"; ��="+(printListLoop.length+3)+"; ��ʽ="+"SUM("+ll+"3:"+ll+(printListLoop.length+2)+")");
   	  cell.SetFormula(2+i,printListLoop.length+3,0,"SUM("+ll+"3:"+ll+(printListLoop.length+2)+")");
   }
   var lz=numberToAbc(2+lbListLoop.length,1);
   
 //  alert("��="+(2+lbListLoop.length)+"; ��="+(printListLoop.length+3)+"; ��ʽ="+"SUM("+lz+"3:"+lz+(printListLoop.length+2)+")");
   cell.SetFormula(2+lbListLoop.length,printListLoop.length+3,0,"SUM("+lz+"3:"+lz+(printListLoop.length+2)+")");
   
   
   
   var i=0; 
   for(i=0;i<printListLoop.length;i++)
   {
      cell_dic=printListLoop[i];
      var lc=numberToAbc(2,1);
      var lr=numberToAbc(2+lbListLoop.length-1,1);
     // alert("��="+(2+lbListLoop.length)+"; ��="+(i+3)+"; ��ʽ="+"SUM("+lc+(i+3)+":"+lr+(i+3)+")");
      cell.SetFormula(2+lbListLoop.length,i+3,0,"SUM("+lc+(i+3)+":"+lr+(i+3)+")");
      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
              
        getCellVar(item);
        if(isDefined);
          {
            //alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
            
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
  var bb=form1.beginyd.value;
  var ee=form1.endyd.value;
  if(ee-bb>=0)
 	 form1.submit();
  else
     alert("��ʼ�·ݲ��ܴ��ڽ����·ݣ�");
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
<body onload=init()>
	<div class="position">��ǰλ�ã���Դ�������ݿ�ϵͳ &gt;&gt; <a href="#">��Դ�������ݷ������</a></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td>
        <fieldset>
          <legend>��ѯ����</legend>
          <form name=form1 action="${path}/showListEnyRptSortCount" method=post >
	          <table border="0" cellpadding="0" cellspacing="3" >
	            <tr>
	              <th>���:</th>
	              <td>  <select name="nd"  id="nd" >
							<c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
								<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
							</c:forEach>	
						</select>
				  </td>
	              <th>�¶ȷ�Χ:</th>
	              <td>
	                 <select name="beginyd"  id="beginyd" >
	                   <c:forEach items="${yuefen}" var="tmp" varStatus="varsta" >
	                     <option value="${tmp}" <c:if test="${tmp==beginyd}">selected</c:if>>${tmp}</option>
	                   </c:forEach>  
	                 </select>
	              <!-- <input type="text" id="beginyd" name="beginyd" value="${beginyd}" style="width: 20px" onkeydown="onlyNum()" onchange="chekvalue(this,1)"/>
				  -->
				  </td>
				   <td>
				      <select name="endyd"  id="endyd" >
	                   <c:forEach items="${yuefen}" var="tmp" varStatus="varsta" >
	                     <option value="${tmp}" <c:if test="${tmp==endyd}">selected</c:if>>${tmp}</option>
	                   </c:forEach>  
	                 </select>
				    <!--<input type="text" id="endyd" value="${endyd}"  name="endyd" style="width: 20px"  onkeydown="onlyNum()" onchange="chekvalue(this,12)"/>
				    -->
				  </td>
	              <th>��������:</th>
	              <td><select name="ssqy"  id="ssqy">
	              			<option value="" >��������</option>
							<c:forEach items="${dqList}" var="tmp" varStatus="varsta" >
								<option value="${tmp.bh}" <c:if test="${tmp.bh==ssqy}">selected</c:if>>${tmp.mc}</option>
							</c:forEach>	
						</select>
			      </td>
	              <th>��ҵ����:</th>
	              <td><select name="hyfl"  id="hyfl"  style="width:150px;">
	              			<option value="" >���з���</option>
							<c:forEach items="${hyflList}" var="tmp" varStatus="varsta" >
								<option value="${tmp.bh}"  <c:if test="${tmp.bh==hyfl}">selected</c:if>>${tmp.mc}</option>
							</c:forEach>
						</select>
			      </td>
	              <th>��λ����:</th>
	              <td>  <select name="dwlx" id="dwlx"  style="width:150px;">
	              			<option value="" >��������</option>
							<c:forEach items="${dwlxList}" var="tmp" varStatus="varsta" >
								<option value="${tmp.bh}"  <c:if test="${tmp.bh==dwlx}">selected</c:if>>${tmp.mc}</option>
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
				 
	            </tr>
	            <tr>
	               <td colspan="13">
	                    <div class="line"></div>
						<a  class="btn btnright" onClick="exportExcel()" href="javascript:void(0);"><span class="export">����</span></a>
						<a  class="btn btnright" onClick="printview()" href="javascript:void(0);"><span class="print">��ӡ</span></a>
						<a class="btn btnright" onClick="searchSubmit()" href="javascript:void(0);"><span class="search">�� ѯ</span></a>
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
           <legend>���ܱ�</legend>
          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1" height="550">
           <tr>
             <td><div id="DivIDremain1"></div><br><br><br></td>
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
