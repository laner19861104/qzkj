<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
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
String companyStr="";
String cpList="";
String glryList="";
String gyzbList="";
String glzdList="";
String fgsList="";
String fzrList="";
if(resMap.get("companyInfo")!=null)
   companyStr=resMap.get("companyInfo").toString();

if(resMap.get("fzrList")!=null)
   fzrList=resMap.get("fzrList").toString();   
if(resMap.get("glryList")!=null)
   glryList=resMap.get("glryList").toString();
if(resMap.get("gyzbList")!=null)
   gyzbList=resMap.get("gyzbList").toString();
if(resMap.get("glzdList")!=null)
   glzdList=resMap.get("glzdList").toString();
if(resMap.get("fgsList")!=null)
   fgsList=resMap.get("fgsList").toString();   

if(resMap.get("cpList")!=null)
   cpList=resMap.get("cpList").toString();
   
Map sbinfoMap=new HashMap();
if(resMap.get("jobSbInfo")!=null)//报表填写信息
    sbinfoMap=(Map)resMap.get("jobSbInfo");
//String companyName=(String)request.getAttribute("companyName");
//String theYear=(String)request.getAttribute("theYear");
%>

var companyInfo=<%=companyStr%>;
var printListLoop=<%=cpList%>;
var glryList=<%=glryList%>;
var gyzbList=<%=gyzbList%>;
var glzdList=<%=glzdList%>;
var fgsList=<%=fgsList%>;
var fzrList=<%=fzrList%>;
function init()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("控件注册失败！");
    }
    
   url1="${path}/cellTemplate/baseInfo_new.cll";
   cell.OpenFile(url1,"");    
   var i=0; 
   var pand=true;
   var startrow=0;
   


    getCellVar('theYear');
  //  alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=resMap.get("nd")%>");
   //填报负责人
   getCellVar('tbfzr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbfzr")%>");
   //填报人
   getCellVar('tbr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbr")%>");
   //填报日期
   getCellVar('tbrq');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbrq")%>");
   //cell_dic[item]==0 ? "否":"是"
   
   var rr0= fzrList.length-1>0 ? fzrList.length-1:0;
   var rr1= glryList.length-1>0 ? glryList.length-1:0;
   var rr2= gyzbList.length-1>0 ? gyzbList.length-1:0;
   var rr3= glzdList.length-1>0 ? glzdList.length-1:0;
   var rr4= fgsList.length-1>0 ? fgsList.length-1:0;
   
   
  if(companyInfo.length>0){
	  cell_dic=companyInfo[0]; 
	  for(var item in cell_dic)
	      {
	        getCellVar(item);
	        if(cell_dic[item]==null)
              continue;
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
   
  // cell.SetCellStyle(1,true);
   //  alert(rr1);
   cell.InsertRow(12, fzrList.length-1,0);
   cellPrintList_fzr(fzrList,"nyfzr");
   
   cell.InsertRow(13+rr0, glryList.length-1,0);
   cellPrintList_gly(glryList,"glryxm");
   cell.InsertRow(15+rr0+rr1, gyzbList.length-1,0);
   cellPrintList_gyzb(gyzbList,"zbmc");
 //   alert(rr2);
    
   cell.InsertRow(16+rr0+rr1+rr2, glzdList.length-1,0);
   cellPrintList_glzd(glzdList,"nyjszd");
 //   alert(rr3);
   cell.InsertRow(17+rr0+rr1+rr2+rr3, fgsList.length-1,0);
   cellPrintList_fgs(fgsList,"fgsmc");
  //  alert(rr4);
   cell.InsertRow(36+rr0+rr1+rr2+rr3+rr4, printListLoop.length-1,0);
  
   i=0;
   pand=true;
   startrow=0;
   for(i=0;i<printListLoop.length;i++)
   {
      cell_dic=printListLoop[i];

      for(var item in cell_dic)
      {
        getCellVar(item);
        //alert(item+"=="+row1+i);

        cell.MergeCells(3,row1+i,4,row1+i);
        cell.MergeCells(5,row1+i,7,row1+i);
        cell.MergeCells(8,row1+i,9,row1+i);
        if(cell_dic[item]==null)
              continue;
        if(isDefined);
          {
           // alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
           // cell.MergeCells(1,row1+i,2,row1+i);
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1+i,0,cell_dic[item]); 
            else
                cell.S(col1,row1+i,0,cell_dic[item]);
            if(pand&&startrow<row1&&row1<1216428){
          	  startrow=row1;
             }
          }
      }
      
      if(pand){
	      var count=printListLoop.length- cell.GetRows(0)+startrow;
	  
	      if(count>0)
	  	  cell.InsertRow(startrow+1, count,0)
  	  
  	  	  pand=false;
      }
   }
   
   
   
   
	cell.CalculateAll();
	   
   //cell.PrintSetSheetOpt(3);
   //cell.PrintPreview(1,0);
   //top.close();
}

function cellPrintList_fzr(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
   for(i=0;i<printList.length;i++)
   {
   	  getCellVar("fzrpxhname");
      cell.S(col1,row1+i,0,"培训号：");
   	  getCellVar("fzrlxdhname");
   	  cell.S(col1,row1+i,0,"联系电话（区号）：");
   	  
   	  cell.MergeCells(5,row1+i,6,row1+i);
   	  cell.MergeCells(7,row1+i,10,row1+i);
   	  
   	  getCellVar(hnname);
      cell.MergeCells(1,row1,1,row1+counts-1);

   	  
      cell_dic=printList[i];
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
            
          }
      }
   }
}


function cellPrintList_gly(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
 for(i=0;i<printList.length;i++)
   {
   	  getCellVar("glrypxhname");
      cell.S(col1,row1+i,0,"培训号：");
   	  getCellVar("glrylxdhname");
   	  cell.S(col1,row1+i,0,"联系电话（区号）：");
   	  
   	  cell.MergeCells(5,row1+i,6,row1+i);
   	  cell.MergeCells(7,row1+i,10,row1+i);
   	  
   	   getCellVar(hnname);
       cell.MergeCells(1,row1,1,row1+counts-1);

   	  
      cell_dic=printList[i];
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
            
          }
      }
   }
}


function cellPrintList_gyzb(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
 for(i=0;i<printList.length;i++)
   {
   	  getCellVar("scnlname");
      cell.S(col1,row1+i,0,"生产能力：");
   	  getCellVar("jldwname");
   	  cell.S(col1,row1+i,0,"计量单位：");
   	  getCellVar("slname");
   	  cell.S(col1,row1+i,0,"台(套):");
   	  
   	  cell.MergeCells(2,row1+i,4,row1+i);
   	  
   	  getCellVar(hnname);
      cell.MergeCells(1,row1,1,row1+counts-1);
        	
   	  
      cell_dic=printList[i];
      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
        getCellVar(item);
        if(isDefined);
          {
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1+i,0,cell_dic[item]); 
            else
                cell.S(col1,row1+i,0,cell_dic[item]);
            
          }
      }
   }
}

function cellPrintList_glzd(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
 for(i=0;i<printList.length;i++)
   {
   	  getCellVar(hnname);
   	  
      cell.MergeCells(1,row1,1,row1+counts-1);	 
      cell.MergeCells(2,row1+i,10,row1+i); 
      cell_dic=printList[i];
      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
        getCellVar(item);
        if(isDefined);
          {
           // alert(item+"--"+col1+","+(row1+i)+";=="+cell_dic[item]);
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1+i,0,cell_dic[item]); 
            else
                cell.S(col1,row1+i,0,cell_dic[item]);
            
          }
      }
   }
}

function cellPrintList_fgs(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
   for(i=0;i<printList.length;i++)
   {
   	  getCellVar(hnname);
   	  cell.MergeCells(1,row1,1,row1+counts-1);
      cell.MergeCells(2,row1+i,4,row1+i);	 
      getCellVar("fddbrname");
   	  cell.S(col1,row1+i,0,"负责(法定代表)人姓名：");
   	  getCellVar("lxdhname");
   	  cell.S(col1,row1+i,0,"联系电话：");
      cell.MergeCells(5,row1+i,6,row1+i); 
      cell.MergeCells(8,row1+i,9,row1+i);
      cell_dic=printList[i];
      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
        getCellVar(item);
        if(isDefined);
          {
           // alert(item+"--"+col1+","+(row1+i)+";=="+cell_dic[item]);
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1+i,0,cell_dic[item]); 
            else
                cell.S(col1,row1+i,0,cell_dic[item]);
            
          }
      }
   }
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
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
      <tr>
         <td>
            <a class="btn" onClick="printview();" href="javascript:void(0);"><span class="print">打 印</span></a> <a class="btn" onClick="exportExcel()" href="javascript:void(0);"><span class="export">导 出</span></a>
         </td>
      </tr>
      <tr>
        <td><fieldset >
           <legend>基本情况表</legend>
          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1" height="580">
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
