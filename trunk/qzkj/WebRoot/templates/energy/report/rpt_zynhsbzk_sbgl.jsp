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
    String cellTemplate="nyxfjg.cll";//cellģ������
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
String resStr1="";
if(resMap.get("resJson1")!=null)//�������ܵ�λ
    resStr1=resMap.get("resJson1").toString();
String resStr2="";
if(resMap.get("resJson2")!=null)//�μ��������ܵ�λ
    resStr2=resMap.get("resJson2").toString();
String resStr3="";
if(resMap.get("resJson3")!=null)//��Ҫ�����豸
    resStr3=resMap.get("resJson3").toString();
    
String resXj="";    
if(resMap.get("xjJson")!=null)//С��
    resXj=resMap.get("xjJson").toString();
    

String resXm="";    
if(resMap.get("xmJson")!=null)//��Ŀ��Ҫ��
    resXm=resMap.get("xmJson").toString();    


    
Map sbinfoMap=new HashMap();
if(resMap.get("jobSbInfo")!=null)//������д��Ϣ
    sbinfoMap=(Map)resMap.get("jobSbInfo");
    

//String companyName=(String)request.getAttribute("companyName");
//String theYear=(String)request.getAttribute("theYear");
%>
var printListLoop=<%=resXj%>;
var printListLoop1=<%=resStr1%>;
var printListLoop2=<%=resStr2%>;
var printListLoop3=<%=resStr3%>;

var xmListLoop=<%=resXm%>;
var xmCount=<%=resMap.get("xmCount")%>;

function loadCell1(){
   url1="${path}/cellTemplate/zynhsbzkb_sbgl.cll";
   cell.OpenFile(url1,"");    
   var i=0; 
   var pand=true;
   var startrow=0;
   
   getCellVar('companyName');
  // alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=resMap.get("dwmc")%>");
   getCellVar('theYear');
  //  alert("--"+col1+","+row1);
   cell.S(col1,row1,0,"<%=resMap.get("nd")%>");
   //�������
   getCellVar('tbfzr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbfzr")%>");
   //���
   getCellVar('tbr');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbr")%>");
   //�����
   getCellVar('tbrq');
   cell.S(col1,row1,0,"<%=sbinfoMap.get("tbrq")%>");
   
   
   var p1=printListLoop1.length;
   var p2=printListLoop2.length;
   var p3=printListLoop3.length;
   if(p1<=0)
      p1=1;
   if(p2<=0)
      p2=1;
   if(p3<=0)
      p3=1;
   
      
   cell.InsertRow(5, p1-1,0);
   cellPrintList(printListLoop1,1);

   cell.InsertRow(10+p1-1, p2-1,0);
   cellPrintList(printListLoop2,2);
   
   cell.InsertRow(15+(p2-1)+(p1-1), p3-1,0);
   cellPrintList(printListLoop3,3);
   
   
   for(i=0;i<printListLoop.length;i++)
   {
      var cell_dic=printListLoop[i];

      for(var item in cell_dic)
      {
        if(cell_dic[item]==null)
              continue;
         getCellVar(item+(i+1));
        if(isDefined);
          {
           // alert(item+(i+1)+"--"+col1+","+(row1)+";value="+cell_dic[item]);
           
            if(cell_dic[item]==null)
              continue;
            if(item.indexOf('sum')!=-1 || typeof cell_dic[item] == 'number')
                cell.D(col1,row1,0,cell_dic[item]); 
            else
                cell.S(col1,row1,0,cell_dic[item]);
            if(pand&&startrow<row1&&row1<1216428){
          	  startrow=row1;
             }
          }
      }
      
   }
   var nr1=1;
   var ii=0;
   if(xmCount>0){
	   getCellVar("xm");
	 //   alert(col1+","+(row1+1)+",===="+(xmCount-1));
	   cell.InsertRow(row1+1, xmCount-1,0);
	   
	   for(i=0;i<xmListLoop.length;i++)
	   {
	      var cell_dic1=xmListLoop[i];
		  getCellVar("xm");
		  cell.S(col1,row1+ii,0,cell_dic1["xm"]);
		 
		  var xmyqList=cell_dic1.xmyq;
		  if(xmyqList.length>1){
		     cell.MergeCells(1,row1+ii,2,row1+ii+xmyqList.length-1);
		   //  cell.MergeCells(7,row1+ii,8,row1+ii);
		  }else{
		     cell.MergeCells(1,row1+ii,2,row1+ii);
		    // cell.MergeCells(7,row1+ii,8,row1+ii);
		  }
		  
		  for(j=0;j<xmyqList.length;j++){
		      var cell_dic2=xmyqList[j];
		      getCellVar("xm");
		      cell.MergeCells(3,row1+ii,6,row1+ii);
		      for(var item in cell_dic2)
		      {
		        if(cell_dic2[item]==null)
		              continue;
		         getCellVar(item);
		        if(isDefined);
		          {
		            //alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
		            if(item=="sfbz"){
		           		cell.S(col1,row1+ii,0,cell_dic[item]==0 ? "��":"��");
		            }else{
		            
			            if(item.indexOf('sum')!=-1 || typeof cell_dic2[item] == 'number')
			                cell.D(col1,row1+ii,0,cell_dic2[item]); 
			            else
			                cell.S(col1,row1+ii,0,cell_dic2[item]);
			            if(pand&&startrow<row1&&row1<1216428){
			          	  startrow=row1;
			             }
		            }
		          }
		      }
		      ii=ii+1;
	      }
	   }
   }
   
 /*  */
   
   
	cell.CalculateAll();
}

function cellPrintList(printList,n){
   var i=0; 
   var pand=true;
   var startrow=0;
   if(printList.length<=0)
      return;
   
   getCellVar("xh"+n);
  
   cell.MergeCells(1,row1,1,row1+printList.length-1);
   
 for(i=0;i<printList.length;i++)
   {
      cell_dic=printList[i];

      for(var item in cell_dic)
      {
      
        if(cell_dic[item]==null)
              continue;
              
        getCellVar(item+n);
       
        if(isDefined);
          {
            //alert(item+"--"+col1+","+(row1+i)+";value="+cell_dic[item]);
            if(item=="sfzqn"){
		        cell.S(col1,row1+i,0,cell_dic[item]==0 ? "��":"��");
		    }else{	
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
      
      if(pand){
     	 var count=printList.length- cell.GetRows(0)+startrow;
	     if(count>0)
	  	   cell.InsertRow(startrow+1, count,0)
	  	  
	  	 pand=false;
      }
   }
}



function init(tepName)
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("�ؼ�ע��ʧ�ܣ�");
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
					<li id="one1" ><span style="font-size:12px;"><a href="${path}/facilityStatusEnyRpt?zbid=<%=sbinfoMap.get("zbid")%>&dwbh=<%=resMap.get("dwbh")%>&nd=<%=resMap.get("nd")%>&yd=<%=resMap.get("yd")%>" target="_self">��Ҫ�ܺ��豸״����</a></span></li>
				  	<li id="one2" class="hover"><span style="font-size:12px;">��ҵ��Դ���������䱸�͹��������</span></li>
				  	<li id="one2" ><span style="font-size:12px;"><a href="${path}/facilityStatusRYEnyRpt?zbid=<%=sbinfoMap.get("zbid")%>&dwbh=<%=resMap.get("dwbh")%>&nd=<%=resMap.get("nd")%>&yd=<%=resMap.get("yd")%>" target="_self">������Ա��ѵ������ܱ�</a></span></li>
				</ul></td>
			  </tr>
			</table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			 <tr>
				<td style="padding-left:5px;padding-top:5px;float:right"><a class="btn" onClick="printview();" href="javascript:void(0);"><span class="print">�� ӡ</span></a> <a class="btn" onClick="exportExcel()" href="javascript:void(0);"><span class="export">�� ��</span></a></td>
			 </tr>
			  <tr>
				<td>
						<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
								    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
								      <tr>
								        <td><fieldset >
								           <legend>����1</legend>
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
