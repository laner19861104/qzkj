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
	String endnds=(String)request.getAttribute("endnd");
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

<!--<c:if test="${alertMSG!=null}">-->
<!--<c:if test="${alertMSG!=''}">-->
<!--<script>alert("${alertMSG}");</script>-->
<!--</c:if>	-->
<!--</c:if>	-->

           
           
           
	
	
<script type="text/javascript">
function setTab(name,cursel,n){
//	for(i=1;i<=n;i++){
//		var menu=document.getElementById(name+i);
//		var con=document.getElementById("con_"+name+"_"+i);
//		menu.className=i==cursel?"hover":"";
//		con.style.display=i==cursel?"block":"none";
//	}
if(cursel==1){
	window.location.href="<%=request.getContextPath()%>/energyndjjzbfx?vonum=1";
	}
	if(cursel==2){	
	window.location.href="<%=request.getContextPath()%>/energyndjjzbczfx?vonum=2";
	}	
}

var tableidArray = new Array('table1','table2');
onloadEvent(showtable);
var obj = new Object();

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



formlist.sfzxcx.value='1';



formlist.submit();
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
<div class="position">��ǰλ�ã��ܺ�ˮƽ����ϵͳ >> ��Դ����״��  >> ��ҵ�ܺ�״������ >> ��Ⱦ���ָ�����</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td>
        
         <table  border="0" cellpadding=0 cellspacing=0 width="100%" height="25" align="center" >
        <tr> 
          <td  class="updown"  style="cursor: hand" onClick="outliner()" child="1ALL" id="updown1" background="templates/image/title_bg_down.jpg"></td>
         </tr>
      </table>
        <div   class="expanded"   id="1ALL" > 
   <form action="<%=request.getContextPath()%>/energyndjjzbczfx" name="formlist" method="post">
   <input type="hidden" name="dwbh" id="dwbh" value="${dwbh}" />
   <input type="hidden" name="dwbhs" id="dwbhs" value="${dwbhs}"/>
   <input type="hidden" name="sfzxcx" id="sfzxcx" value="${sfzxcx}" />
 
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
    <td width="13%">ͳ���·ݣ�</td>
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
    <select name="endnd" >
						  
						 <%
						  for(int i=-10;i<=10;i++){
						  int values1=Integer.parseInt(years)+i;
						  String xdnd1=String.valueOf(values1);						 
						 if(xdnd1.equals(endnds)){					
						   %>
						    <option value="<%=xdnd1 %>" selected><%=xdnd1 %></option>						
						  <%} else{%>
						    <option value="<%=xdnd1 %>" ><%=xdnd1 %></option>
						  <%}} %>
						  
    </select></td>
   
	
</tr><tr >
			   <td colspan="4" style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
					   ָ��ѡ��
                     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${xssr=='xssr'}">checked="checked"</c:if>   value="xssr"/>��������&nbsp;
                      <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${nyxfcb=='nyxfcb'}">checked="checked"</c:if>   value="nyxfcb"/>��Դ���ѳɱ�&nbsp;
<!--				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${zcb=='zcb'}">checked="checked"</c:if>   value="zcb"/> �ܳɱ�&nbsp;-->
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzcz=='gyzcz'}">checked="checked"</c:if>   value="gyzcz"/>��ҵ�ܲ�ֵ&nbsp;
				     <input type="checkbox" name="dbbz" id="dbbz"  <c:if test="${gyzjz=='gyzjz'}">checked="checked"</c:if>   value="gyzjz"/> ��ҵ����ֵ&nbsp;
				    				     
				 </td>
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
  
  
  
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	  <td>
			<table border="0" cellpadding="0" cellspacing="0" class="Menubox">
			  <tr>
				<td><ul>
				  <li id="one1" onmousedown="setTab('one',1,2)"  >��Ⱦ���ָ�����</li>
				  <li id="one2" onmousedown="setTab('one',2,2)" class="hover">��Ⱦ���ָ��ɳ��Է���</li>
				</ul></td>
			   </tr>
			 </table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			  <tr>
				<td>
			
			<!--���ع�ҵ  -->
						
							<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
									<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
										  <tr> 
										    <td valign="top" class="text" align="center"> 
										       <div id="chartdiv_1" align="center"></div>
										       <script type="text/javascript">
													   var chart_1 = new FusionCharts("<%=request.getContextPath()%>/FusionChartsFree/Charts/FCF_MSColumn3D.swf", "ChartId", "600", "380", "0", "0");
													   chart_1.setDataXML('${charsvo.strXML}');	   
													   chart_1.render("chartdiv_1");
												</script>
											</td>
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
   

 
</body>

