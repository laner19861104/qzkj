<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.bip.sys.codediction.po.SysDmzd" %>
<%@ page import="com.bip.industrialeconomy.reportinfoprediction.vo.ZbzVo" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%

//List<SysDmzd> list_qy = (List<SysDmzd>)request.getAttribute("enterpriseqy"); 
//List<SysDmzd> list_hy = (List<SysDmzd>)request.getAttribute("enterprisehyfl"); 
//String area = (String)request.getAttribute("area");//�������
//String hyfl = (String)request.getAttribute("hyfl");//��ҵ����
String mark = (String)request.getAttribute("mark");
Date currentTime = new Date();
	String currentYYYYmm = currentTime.toString();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String str_date1 = formatter.format(currentTime); //������ʱ���ʽ�� 
	String years=str_date1.substring(0,4);
	
	String nds=(String)request.getAttribute("nd");
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
	<script src="templates/js/Calendar.js" type="text/javascript"></script>
	<link rel="stylesheet" href="js/seekopen/sysjs/css/Style.css" type="text/css" />
<script src="templates/js/updown.js" type="text/javascript"></script>
<script language="JavaScript" src="charts/JSClass/FusionCharts.js"></script>
 <script src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
 <script src="<%=request.getContextPath() %>/templates/js/searchjs.js" type="text/javascript"></script>
 <script src="<%=request.getContextPath() %>/templates/js/zbxzjs.js" type="text/javascript"></script>
<!--<c:if test="${alertMSG!=null}">-->
<!--<c:if test="${alertMSG!=''}">-->
<!--<script>alert("${alertMSG}");</script>-->
<!--</c:if>	-->
<!--</c:if>	-->

           
           
           
	
	
<script type="text/javascript">
var tableidArray = new Array('table1');
//onloadEvent(showtable);

function searchlist()
{
if(formlist.dwmc.value==""){
alert("��ѡ����ҵ");
return;
}
if(formlist.nd.value==""){
alert("��ѡ�����");
return;
}

if(formlist.zbmc.value==""){
alert("��ѡ��ָ��");
return;
}
if(formlist.endyd.value-formlist.beginyd.value<0){
alert("�����·�С�ڿ�ʼ�·ݣ�������ѡ���ѯ�·�");
return;
}

formlist.sfzxcx.value='1';
//document.getElementById('con_one_3').style.display="block"; 


formlist.submit();
}
function doubleOnclick(dwbh){

  formlist.dwbh.value=dwbh;
  
  formlist.submit();
}


function thisheight(){
	
var thirdheight=document.documentElement.clientHeight-213;
var _div=document.getElementById("aaa"); 
var _height=parseInt(_div.style.height); 
var _top=parseInt(_div.style.top); 
_div.style.height=thirdheight+"px"; 
_div.style.top=100+"px";

var _divone=document.getElementById("divone"); 
var _display=parseInt(_divone.style.display); 
_divone.style.display="block";

var _divtwo=document.getElementById("divtwo"); 
var _top=parseInt(_divtwo.style.top); 
_divtwo.style.top=100+"px";
//alert(thirdheight);
//alert(document.documentElement.clientHeight);
//alert(window.innerHeight); 
 parent.leftFrame.document.all.ly.style.display="none"; 
} 
function xsxgxs(){

var _divone=document.getElementById("divone"); 
var _display=parseInt(_divone.style.display); 
_divone.style.display="block";

}
function xsxggb(){

var _divone=document.getElementById("divone"); 
var _display=parseInt(_divone.style.display); 
_divone.style.display="none";

}



function sub() 
{
  var myoptions=form.yy.options;
			var selectclassid="";
			var selectclass="";
			if(myoptions!=null){
			  for(i=0;i<myoptions.length;i++){
			   myoptions[i].selected = true;
			   if(myoptions[i].value!=""){
			   if(i==0){
			   selectclassid =myoptions[i].value;
			   selectclass =myoptions[i].text;
			   }else{
			   selectclassid = selectclassid+","+myoptions[i].value;
			   selectclass = selectclass+","+myoptions[i].text;
			   }
			   }
			  }
            }
           // alert(selectclassid);
           // alert(selectclass);
  document.getElementsByName("dwmc")[0].value=selectclass;
  document.getElementsByName("dwbhs")[0].value=selectclassid;
  box.Close();
}


function zbxzsub() 
{
  var myoptions=form1.yy1.options;
			var selectclassid="";
			var selectclass="";
			if(myoptions!=null){
			  for(i=0;i<myoptions.length;i++){
			   myoptions[i].selected = true;
			   if(myoptions[i].value!=""){
			   if(i==0){
			   selectclassid =myoptions[i].value;
			   selectclass =myoptions[i].text;
			   }else{
			   selectclassid = selectclassid+","+myoptions[i].value;
			   selectclass = selectclass+","+myoptions[i].text;
			   }
			   }
			  }
            }
           // alert(selectclassid);
           // alert(selectclass);
  document.getElementsByName("zbmc")[0].value=selectclass;
  document.getElementsByName("zbbhs")[0].value=selectclassid;
  box1.Close();
}
</script>

<%
if("0".equals(mark)){
%>
<script type="text/javascript">alert("����ѯ�����ֻ�δ���ɣ����Ƚ����������ɲ���")</script>
<%
}
%>


</head>


<!--<c:if test="${sfxs==1}">-->
<!--<body onload="xsxgxs();"> -->
<!--</c:if>-->
<!--<c:if test="${sfxs!=1}">-->
<!---->
<!--<body onload="xsxggb();"> -->
<!---->
<!--</c:if>-->
<body>
<div class="position">��ǰλ�ã��ܺ�ˮƽ����ϵͳ >> ��Դ����״��  >> ��ҵ�ܺ�״������ >> ��λ�ܺ�ָ�����</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td>
        
         <table  border="0" cellpadding=0 cellspacing=0 width="100%" height="25" align="center" >
        <tr> 
          <td  class="updown"  style="cursor: hand" onClick="outliner()" child="1ALL" id="updown1" background="templates/image/title_bg_down.jpg"></td>
         </tr>
      </table>
        <div   class="expanded"   id="1ALL" > 
   <form action="<%=request.getContextPath()%>/energydwnhzbfx" name="formlist" method="post">
   <input type="hidden" name="dwbh" id="dwbh" value="${dwbh}" />
   <input type="hidden" name="dwbhs" id="dwbhs" value="${dwbhs}"/>
   <input type="hidden" name="sfzxcx" id="sfzxcx" value="${sfzxcx}" />
   <input type="hidden" name="zbbhs" id="zbbhs" value="${zbbhs}"/>
  
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
										<tr>
											<td>
											<fieldset>
												<legend></legend>
												<table width="99%" border="0" cellspacing="6" cellpadding="0">
  <tr>
   <td width="10%">ѡ����ҵ��</td>
    <td width="31%"> <a  id="addbtn" >
    <input type="text" id="dwmc" name="dwmc" value="${dwmc}" size="30" readonly="true"/></a></td>
    <td width="13%">��ʼʱ�䣺</td>
    <td width="46%"><select name="nd" >
    					
						  <%
						  for(int i=-10;i<=10;i++){
						  int values=Integer.parseInt(years)+i;
						  String xdnd=String.valueOf(values);						 
						 if(xdnd.equals(nds)){					
						   %>
						    <option value="<%=xdnd %>" selected><%=xdnd %></option>						
						  <%} else{%>
						    <option value="<%=xdnd %>" ><%=xdnd %></option>
						  <%}} %>
						  
						 
    </select>
    --
    <select name="beginyd" >
						  
						  <option value="01" <c:if test="${beginyd=='01'}">selected</c:if>>1��</option>
						  <option value="02" <c:if test="${beginyd=='02'}">selected</c:if>>2��</option>
						  <option value="03" <c:if test="${beginyd=='03'}">selected</c:if>>3��</option>
						  <option value="04" <c:if test="${beginyd=='04'}">selected</c:if>>4��</option>
						  <option value="05" <c:if test="${beginyd=='05'}">selected</c:if>>5��</option>
						  <option value="06" <c:if test="${beginyd=='06'}">selected</c:if>>6��</option>
						  <option value="07" <c:if test="${beginyd=='07'}">selected</c:if>>7��</option>
						  <option value="08" <c:if test="${beginyd=='08'}">selected</c:if>>8��</option>
						  <option value="09" <c:if test="${beginyd=='09'}">selected</c:if>>9��</option>
						  <option value="10" <c:if test="${beginyd=='10'}">selected</c:if>>10��</option>
						  <option value="11" <c:if test="${beginyd=='11'}">selected</c:if>>11��</option>
						  <option value="12" <c:if test="${beginyd=='12'}">selected</c:if>>12��</option>
						  
    </select>
    --
    <select name="endyd" >
						  
						  <option value="01" <c:if test="${endyd=='01'}">selected</c:if>>1��</option>
						  <option value="02" <c:if test="${endyd=='02'}">selected</c:if>>2��</option>
						  <option value="03" <c:if test="${endyd=='03'}">selected</c:if>>3��</option>
						  <option value="04" <c:if test="${endyd=='04'}">selected</c:if>>4��</option>
						  <option value="05" <c:if test="${endyd=='05'}">selected</c:if>>5��</option>
						  <option value="06" <c:if test="${endyd=='06'}">selected</c:if>>6��</option>
						  <option value="07" <c:if test="${endyd=='07'}">selected</c:if>>7��</option>
						  <option value="08" <c:if test="${endyd=='08'}">selected</c:if>>8��</option>
						  <option value="09" <c:if test="${endyd=='09'}">selected</c:if>>9��</option>
						  <option value="10" <c:if test="${endyd=='10'}">selected</c:if>>10��</option>
						  <option value="11" <c:if test="${endyd=='11'}">selected</c:if>>11��</option>
						  <option value="12" <c:if test="${endyd=='12'}">selected</c:if>>12��</option>
						  
						  
    </select>
    </td>
	
</tr><tr>
	<td width="10%">ͼ�����ͣ�</td>
    		<td width="31%"><select name="tblx" >
						  
						  <option value="1"  <c:if test="${tblx=='1'}">selected</c:if>>��״ͼ</option>
						  <option value="2"  <c:if test="${tblx=='2'}">selected</c:if>>����ͼ</option>
						  
    </select></td>
    
    <td width="13%">ָ��ѡ��</td>
    <td width="46%"> <a  id="zbxzbtn" >
    <input type="text" id="zbmc" name="zbmc" value="${zbmc}" size="20" readonly="true"/></a></td>
  </tr>
 
</table>
<div class="line"></div>
<table border="0" cellpadding="0" cellspacing="0" class="btntable">
				<tr>
					<td>
						<a class="btn" onclick="" href="javascript:searchlist();"><span class="search">�� ѯ</span></a>

					</td>
				</tr>
			</table>
											</fieldset>								
											</td>
										</tr>
	    </table>
			</div>
  
  <div id="divone" style="display: ;">  
       <table width="98%" id="con_one_3" >
       <tr>
       <td>
   <table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td valign="top" class="text" align="center"> 
    <div id="chartdiv" > </div>
      <script type="text/javascript">
//		   var chart = new FusionCharts("charts/Charts/ErrorBar2D.swf", "ChartId", "600", "380",'0','1');
//		 chart.setDataXML('${strXML}');		
//		    //chart.setDataURL("charts/Gallery/Data/ErrorBar.xml");	   
//		   chart.render("chartdiv");
		    var chart = new FusionCharts("<%=request.getContextPath() %>/FusionChartsFree/Charts/${charsvo.swfName}", "ChartId", "600", "380", "0", "0");
		   chart.setDataXML('${charsvo.strXML}');	   
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
</div>   
          </form>
       </td>
      </tr>
</table>



  <!--�����������-->
<div id="idBox" class="lightbox" style="width:660px;">
	<h1 id="idBoxHead">��ҵ����<span><img src="templates/image/quit.png" id="idBoxCancel"  /></span></h1>
	<div class="content">
	<form action="" name="form" id="form" method="post">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tableout">
		  <tr>
			<td><fieldset>
			  <table border="0" cellspacing="0" cellpadding="0" class="list_border">
  <tr>

    <th width="180">
<table>
<s:select name="search_area"  label="����"   labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="��ѡ��" list="enterpriseqy" listKey="bh" listValue="mc"   onchange="showSubMenu(this.options[this.options.selectedIndex].value)"/>
 
  </table>   </th>

    <th width="350">
<table>
<s:select name="search_class"  label="��ҵ"   labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="��ѡ��" list="enterprisehyfl" listKey="bh" listValue="mc" onchange="showSubMenu(this.options[this.options.selectedIndex].value)"/>
    </table> </th>
   
  </tr>
  <tr>
    <td colspan="5" align="center" valign="top">
    <TABLE style="margin-top:8px;margin-bottom:8px" >
    <TR>
    <TD width="230">
    <table>
    <s:select   name="search_enterprise" id="search_enterprise" size="21" width="240px"  cssStyle="width:250px;" labelSeparator="��"  labelposition="-1"  list="enterprise_list" listKey="dwbh" listValue="dwmc" />
    </table>
    </TD>
    <TD>
<!--    <a id="movetop" onClick="movetop()" ><img src="<%=request.getContextPath() %>/templates/image/selup.gif" width="36" height="17" alt="�����ƶ�" /></a>-->
    <a id="moveright" onClick="javascript:moveright()" > <img src="<%=request.getContextPath() %>/templates/image/selright.gif" width="36" height="17" alt="����ѡ��"/> </a>
<!--    <a id="moverightall" onClick="javascript:moverightall()" ><img src="<%=request.getContextPath() %>/templates/image/selrightall.gif" width="36" height="17" alt="ȫ��ѡ��"  onclick="moverightall()"/></a>-->
    <a id="moveleft" onClick="javascript:moveleft()" > <img src="<%=request.getContextPath() %>/templates/image/selleft.gif" width="36" height="17" alt="�����Ƴ�"  onclick="moveleft()"/></a>
<!--    <a id="moveleftall" onClick="javascript:moveleftall()" > <img src="<%=request.getContextPath() %>/templates/image/selleftall.gif" width="36" height="17" alt="ȫ���Ƴ�"  onclick="moveleftall()"/> </a>-->
<!--    <a id="movedown" onClick="javascript:movedown()" > <img src="<%=request.getContextPath() %>/templates/image/seldown.gif" width="36" height="17" alt="�����ƶ�"  onclick="movedown()"/></a>-->
    </TD>
    <TD width="230">
    
     <select  multiple  size="21"   Id="yy" name="mygroupcodeArray"  ondblclick="moveleft();" style="width:240px"></select>
        
      
    </TD>
   </TR>
  </TABLE>
  </td>
  </tr>
  
</table>

<table style="width:320px; float:left; margin-left:180px;margin-top:6px;"  align="center">
     <tr>
       <td><a class="btn" href="javaScript:sub();">ȷ ��</a> <a class="btn" href="#" id="idBoxCancel2" >ȡ ��</a> </td>
     </tr>
</table>
			</fieldset></td>
		  </tr>
	  </table>
	     <input  type="hidden" name="flag" value="1" id="flag"/>
	 </form>
	</div>
</div>
<div id="idOverlay"></div>

<SCRIPT LANGUAGE="JavaScript">
		
var box = new LightBox("idBox", "idOverlay", { Center: true });
var drag = new Drag("idBox", "idBoxHead", { mxContainer: document.documentElement, Lock: true });
$("idBoxCancel").onclick = function(){ box.Close(); }
$("idBoxCancel2").onclick = function(){ box.Close(); }
$("addbtn").onclick = function(){ box.Show(); }
		
		
function movei(fbox,tbox) {
		 
		var count = tbox.options.length;
		for(var i=0; i<fbox.options.length; i++) {
			if(fbox.options[i].selected && fbox.options[i].value != "") {
					 for(var j=0;j<count;j++){
			         if(fbox.options[i].value==tbox.options[j].value){
			         alert("�����ظ���ӣ�");
			         return;
			          }
			         }
				var no = new Option();
				no.value = fbox.options[i].value;
				no.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no;
				}
			}
		}
		
		
		
 s=document.getElementById("search_enterprise");
 d=document.getElementById("yy");

 
 
 function moveright() //
 {
   now=s.selectedIndex;
   var temp=0;
     for(i=0;i<d.options.length;i++)
     {
     if(d.options[i].value!=""){
     	alert("ֻ��ѡ��һ����ҵ");
       	return;
     }
      
     } 
     
   d.options[temp]=new Option("","");   
   d.options[temp].text=s.options[now].text;
   d.options[temp].value=s.options[now].value;

  }
  

 function moveleft() //
 {
  if(d.selectedIndex>=0&&d.options[d.selectedIndex].value!="")
   {
   now=d.selectedIndex;
   var temp=0;
   d.remove(now);
   }
 }
  
  
  
  
</SCRIPT>
   

 <!--�����������2-->
<div id="idBox1" class="lightbox" style="width:660px;">
	<h1 id="idBoxHead1">ָ��ѡ��<span><img src="templates/image/quit.png" id="idBoxCancel1"  /></span></h1>
	<div class="content">
	<form action="" name="form1" id="form1" method="post">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tableout">
		  <tr>
			<td><fieldset>
		
			  <table border="0" cellspacing="0" cellpadding="0" class="list_border">
 
  <tr>
    <td colspan="5" align="center" valign="top">
    <TABLE style="margin-top:8px;margin-bottom:8px" >
    <TR>
    <TD width="230">
    <table>
    <s:select   name="zbxz_zbmc" id="zbxz_zbmc" size="21" width="240px"  cssStyle="width:250px;" labelSeparator="��"  labelposition="-1"  list="zbxz_list" listKey="nybh" listValue="nymc" />
    </table>
    </TD>
    <TD>
<!--    <a id="movetop" onClick="movetop()" ><img src="<%=request.getContextPath() %>/templates/image/selup.gif" width="36" height="17" alt="�����ƶ�" /></a>-->
    <a id="moveright1" onClick="javascript:moveright1()" > <img src="<%=request.getContextPath() %>/templates/image/selright.gif" width="36" height="17" alt="����ѡ��"/> </a>
    <a id="moverightall" onClick="javascript:moverightall()" ><img src="<%=request.getContextPath() %>/templates/image/selrightall.gif" width="36" height="17" alt="ȫ��ѡ��"  onclick="moverightall()"/></a>
    <a id="moveleft1" onClick="javascript:moveleft1()" > <img src="<%=request.getContextPath() %>/templates/image/selleft.gif" width="36" height="17" alt="�����Ƴ�"  onclick="moveleft1()"/></a>
    <a id="moveleftall" onClick="javascript:moveleftall()" > <img src="<%=request.getContextPath() %>/templates/image/selleftall.gif" width="36" height="17" alt="ȫ���Ƴ�"  onclick="moveleftall()"/> </a>
<!--    <a id="movedown" onClick="javascript:movedown()" > <img src="<%=request.getContextPath() %>/templates/image/seldown.gif" width="36" height="17" alt="�����ƶ�"  onclick="movedown()"/></a>-->
    </TD>
    <TD width="230">
    
     <select  multiple  size="21"   Id="yy1" name="mygroupcodeArray1"  ondblclick="moveleft1();" style="width:240px"></select>
        
      
    </TD>
   </TR>
  </TABLE>
  </td>
  </tr>
  
</table>


<table style="width:320px; float:left; margin-left:180px;margin-top:6px;"  align="center">
     <tr>
       <td><a class="btn" href="javaScript:zbxzsub();">ȷ ��</a> <a class="btn" href="#" id="idBoxCancel21" >ȡ ��</a> </td>
     </tr>
</table>
			</fieldset></td>
		  </tr>
	  </table>
	    
	 </form>
	</div>
</div>
<div id="idOverlay1"></div>

<SCRIPT LANGUAGE="JavaScript">
		
var box1 = new LightBox("idBox1", "idOverlay1", { Center: true });
var drag1 = new Drag("idBox1", "idBoxHead1", { mxContainer: document.documentElement, Lock: true });
$("idBoxCancel1").onclick = function(){ box1.Close(); }
$("idBoxCancel21").onclick = function(){ box1.Close(); }
$("zbxzbtn").onclick = function(){


if(document.getElementById("dwbhs").value==''){
alert("��ѡ���ѯ����ҵ");
return;

}if(document.getElementById("nd").value==''){
alert("��ѡ���ѯʱ��");
return;
}
else{

showSubMenu1();
box1.Show();
}



  }
		
		
function movei1(fbox,tbox) {
		 
		var count = tbox.options.length;
		for(var i=0; i<fbox.options.length; i++) {
			if(fbox.options[i].selected && fbox.options[i].value != "") {
					 for(var j=0;j<count;j++){
			         if(fbox.options[i].value==tbox.options[j].value){
			         alert("�����ظ���ӣ�");
			         return;
			          }
			         }
				var no1 = new Option();
				no1.value = fbox.options[i].value;
				no1.text = fbox.options[i].text;
				tbox.options[tbox.options.length] = no1;
				}
			}
		}
		
		
		
 s1=document.getElementById("zbxz_zbmc");
 d1=document.getElementById("yy1");

  
 
 function moveright1() //
 {
   now1=s1.selectedIndex;
   var temp1=0;
     for(i=0;i<d1.options.length;i++)
     {
       if(d1.options[i].value!=""){temp1=i+1;}
       if(d1.options[i].value==s1.options[now1].value)
       {
       	alert("��¼�Ѵ��ڣ�");
       	return;
      }
     } 
     for(j=temp1;j<s1.options.length;j++)
     {
      d1.options[j]=new Option("","");
     }
   d1.options[temp1].text=s1.options[now1].text;
   d1.options[temp1].value=s1.options[now1].value;

  }
  function moverightall() //
  {
     moveleftall();
     for(i=0;i<s1.options.length;i++)
     {
     	d1.options[i]=new Option("","");
      d1.options[i].text=s1.options[i].text;
      d1.options[i].value=s1.options[i].value;
     }
  }

 function moveleft1() //
 {
  if(d1.selectedIndex>=0&&d1.options[d1.selectedIndex].value!="")
   {
   now1=d1.selectedIndex;
   var temp=0;
   d1.remove(now1);
   }
 }
  function moveleftall() //
  {
  d1.innerHTML=null;
 //    for(i=0;i<d.options.length;i++)
 //    {
 //     d.remove(i);
 //    }
  }
  
  
  
</SCRIPT>
</body>

