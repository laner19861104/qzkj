<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ page import="net.sf.json.JSONArray"%>
<%@ page import="net.sf.json.JSONObject"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);


   //String title=(String)request.getAttribute("title");
    String cellTemplate="nyxfjg.cll";//cell模板名称
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
    sub getCellvar1(varname)
        isDefined = cell1.GetCellVar(varname,col1,row1,sht)
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
    

//String companyName=(String)request.getAttribute("companyName");
//String theYear=(String)request.getAttribute("theYear");
%>

var printListLoop=<%=resStr%>;

function loadCell1(){
   url1="${path}/cellTemplate/dwcpzhnh.cll";
   cell.OpenFile(url1,"");    
   var i=0; 
   var pand=true;
   var startrow=0;
   
   getCellVar('companyName');
  // alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=resMap.get("dwmc")%>");
   getCellVar('theYear');
  //  alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=sbinfoMap.get("nd")%>");
      //填报负责人
   getCellVar('tbfzr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbfzr")%>");
   //填报人
   getCellVar('tbr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbr")%>");
   //填报日期
   getCellVar('tbrq');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbrq")%>");
  
   
   
   
   cell.InsertRow(7, printListLoop.length-1,0);
   
   for(i=0;i<printListLoop.length;i++)
   {
      cell_dic=printListLoop[i];
      
      for(var item in cell_dic)
      {
        getCellVar(item);
       
        if(isDefined);
          {
            //alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
            if(cell_dic[item]==null)
              continue;
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
}

function init(tepName)
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("控件注册失败！");
    }
  loadCell1();  
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

.Menubox li{
	float:left;
	display:block;
	cursor:pointer;
	text-align:center;
	color:#666666;
	margin-right: 2px;
	margin-bottom: -3px;
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
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	  <td>
			<table border="0" cellpadding="0" cellspacing="0" class="Menubox">
			  <tr>
				<td><ul>
					<li id="one1" class="hover"><span style="font-size:12px;">单位产品综合能耗指标情况</span></li>
				  	<li id="one2" ><span style="font-size:12px;"><a href="${path}/unitProductFTEnyRpt?zbid=<%=sbinfoMap.get("zbid")%>&dwbh=<%=resMap.get("dwbh")%>&nd=<%=resMap.get("nd")%>" target="_self">产品能耗分摊汇总表</a></span></li>
				</ul></td>
			  </tr>
			</table>
	 		 
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			 <tr>
		         <td style="padding-left:5px;padding-top:5px;float:right">
		            <a class="btn" onClick="printview();" href="javascript:void(0);"><span class="print">打 印</span></a> <a class="btn" onClick="exportExcel()" href="javascript:void(0);"><span class="export">导 出</span></a>
		         </td>
		      </tr>
			  <tr>
				<td>
						<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
								    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
								      <tr>
								        <td><fieldset >
								           <legend>主表</legend>
								          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1" height="550">
								           <tr>
								             <td><div id="DivIDremain1"></div><br><br><br></td>
								           </tr>
								          </table>
								          
								        </fieldset></td>
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
							
<script type="text/javascript">
  insertCell('DivIDremain1','/fin_pay/images/CellWeb5.CAB', '100%', '100%','cell');
</script>
</body>
</html>
