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
String xStr="";
if(resMap.get("xList")!=null)//x轴数据
    xStr=resMap.get("xList").toString();
    
String yList="";
if(resMap.get("yList")!=null)//y轴数据
    yList=resMap.get("yList").toString();
    
String gdList="";
if(resMap.get("gdList")!=null)//y轴固定栏目数据
    gdList=resMap.get("gdList").toString();
    
Map sbinfoMap=new HashMap();
if(resMap.get("jobSbInfo")!=null)//报表填写信息
    sbinfoMap=(Map)resMap.get("jobSbInfo");

if(session.getAttribute("sysuser")!=null){
	
}else{
    response.sendRedirect("/"+request.getContextPath());
}
%>

var printListLoop=<%=yList%>;
var lbListLoop=<%=xStr%>;
var xCount=<%=resMap.get("xCount")%>;
var gdListLoop=<%=gdList%>;


////  
function init()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("控件注册失败！");
    }
    
   url1="${path}/cellTemplate/energySwph.cll";
   cell.OpenFile(url1,"");    
   
   
   getCellVar('companyName');
  // alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=resMap.get("dwmc")%>");
   //getCellVar('theYear');
  // cell.S(col1,row1,0,"<%=sbinfoMap.get("nd")%>");
   //填报负责人
   getCellVar('tbfzr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbfzr")%>");
   
   
   var pand=true;
   var startrow=0;
   
   var yList1=printListLoop[0];//能源转换系统
   var yList2=printListLoop[1];//生产系统 
   var yList3=printListLoop[2];//辅助生产系统
   
   var ycount1=yList1["count"];//能源转换系统
   var ycount2=yList2["count"];//生产系统 
   var ycount3=yList3["count"];//辅助生产系统
   
   
   cell.InsertCol(4,xCount-1,0);
   
   cell.InsertRow(18, ycount1-1,0);
  // alert(ycount1-1);
   cell.InsertRow(18+ycount1+1, ycount2-1,0);
  // alert(18+ycount1);
   cell.InsertRow(18+ycount1+ycount2+2, ycount3-1,0);
  // alert(18+ycount1+ycount2);
   
   
   cell.MergeCells(1,1,3+xCount-1,1);
   cell.S(3+xCount-3,2,0,"年度：<%=sbinfoMap.get("nd")%>");
   
   cell.MergeCells(xCount,2,3+xCount-1,2);
   if(xCount>=2){
	   cell.S(3,22+ycount1+ycount2+ycount3,0,"填报人：<%=sbinfoMap.get("tbr")%>");
	   cell.MergeCells(3,22+ycount1+ycount2+ycount3,4,22+ycount1+ycount2+ycount3);
   }
   if(xCount>=4){
	   cell.S(5,22+ycount1+ycount2+ycount3,0,"填报日期：<%=sbinfoMap.get("tbrq")%>");
	   cell.MergeCells(5,22+ycount1+ycount2+ycount3,6,22+ycount1+ycount2+ycount3);
   }
   var xlbcount=0;
   
   
   
   //X轴 能源类别填充
   for(i=0;i<lbListLoop.length;i++){
      lb_dic=lbListLoop[i];
      lblist=lb_dic["nylist"];
      
      getCellVar("xmmc");
   //   alert(lb_dic.count+"--"+(3+xlbcount)+","+row1+","+(3+xlbcount+lb_dic.count-1)+","+row1);
      if(lb_dic.count>1){
         cell.MergeCells(3+xlbcount,row1,3+xlbcount+lb_dic.count-1,row1);//合并该类别所占列数
      }
      cell.S(3+xlbcount,row1,0,lb_dic["xmmc"]);//填入该类别名称
      
      getCellVar("nymc");
      for(j=0;j<lblist.length;j++){
      	 ny_dic=lblist[j];
      	// alert(ny_dic["nymc"]+"--"+(col1+xlbcount)+","+row1);
      	 cell.S(col1+xlbcount,row1,0,ny_dic["nymc"]);//填入该能源名称
      	 cell.S(col1+xlbcount,row1+1,0,ny_dic["nydw"]);//填入该能源单位
      	 
      	 cell.DefineCellVar(ny_dic["uuid"],col1+xlbcount,row1+2,0)//设置x轴的变量名称为 能源名称的对应id
      	 xlbcount++;
      }
     
   }
  
   //y轴固定项目部分填充 gdListLoop
   
   for(i=0;i<gdListLoop.length;i++)
   {
        list_gd=gdListLoop[i];
   		getCellVar("xid");
   		var colss=col1;
   		for(var item in list_gd){
   		  if(list_gd[item]==null)
       		 continue;
       		 
          getCellVar(item);
          if(isDefined)                                      
	      {
	         if(item.indexOf('sum')!=-1 || typeof list_gd[item] == 'number')
	             cell.D(colss,row1,0,list_gd[item]); 
	         else
	             cell.S(colss,row1,0,list_gd[item]);
	      }
	     
	    }
   }
   
   
   //动态项目 生成

	cellPrintList(yList1["listValue"],"yname1");
	cellPrintList(yList2["listValue"],"yname2");
	cellPrintList(yList3["listValue"],"yname3");





   
   /*
   
   var ylbcount=0;
   for(i=0;i<printListLoop.length;i++)
   {
   		list_dic=printListLoop[i];
      
      	var lcount=list_dic["count"];
      	getCellVar("zbxmmc");
      	if(list_dic["djdl"]==null || list_dic["djdl"]=="null" || list_dic["djdl"]==""){
      		for(var item in list_dic){
	   		  if(list_dic[item]==null)
	       		 continue;
	       		 
	          getCellVar(item);
	          if(isDefined)                                      
		      {
		         if(item.indexOf('sum')!=-1 || typeof list_dic[item] == 'number')
		             cell.D(col1,row1+ylbcount,0,list_dic[item]); 
		         else
		             cell.S(col1,row1+ylbcount,0,list_dic[item]);
		      }
		      cell.MergeCells(1,row1+ylbcount,2,row1+ylbcount);//合并该类别所占列数
		    }
	      	ylbcount++
      		
      	}else{
      	    if(i==hebing){//如果是两行在一起 就合并
	      		getCellVar("zbxmmc");
	      		cell.MergeCells(1,row1+ylbcount-1,1,row1+ylbcount);//合并该类别所占列数
	      		
      		}else{//碰到第一条要合并的，记录下一条
      			hebing=i+1;
      		}
      		for(var item in list_dic){
	   		  if(list_dic[item]==null)
	       		 continue;
	       		 
	          getCellVar(item);
	          if(isDefined)                                      
		      {
		         if(item.indexOf('sum')!=-1 || typeof list_dic[item] == 'number')
		             cell.D(col1,row1+ylbcount,0,list_dic[item]); 
		         else
		             cell.S(col1,row1+ylbcount,0,list_dic[item]);
		      }
		    }
      		
      		ylbcount++
      	}
   }
   */

	cell.CalculateAll();
	   
   //cell.PrintSetSheetOpt(3);
   //cell.PrintPreview(1,0);
   //top.close();
}

function cellPrintList(printList,hnname){
   var i=0; 
   var pand=true;
   var startrow=0;
   var counts=printList.length;
   var cell_dic;
   	 
   
   for(i=0;i<printList.length;i++)
   {
      cell_dic=printList[i];
   	  getCellVar(hnname);
   	  cell.S(col1,row1+i,0,cell_dic["zbxmmc"]);
      cell.MergeCells(1,row1+i,2,row1+i);
      var rowss=row1;
      
      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
        getCellVar(item);
        if(isDefined);
          {
           // alert(item+"--"+col1+","+(rowss+i)+";=="+cell_dic[item]);
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,rowss+i,0,cell_dic[item]); 
            else
                cell.S(col1,rowss+i,0,cell_dic[item]);
            
          }
      }
   }
}

function searchSubmit(){
  var bb=form1.beginyd.value;
  var ee=form1.endyd.value;
  if(ee-bb>=0)
 	 form1.submit();
  else
     alert("开始月份不能大于结束月份！");
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
           <legend>重点用能单位能源实物平衡明细表</legend>
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
