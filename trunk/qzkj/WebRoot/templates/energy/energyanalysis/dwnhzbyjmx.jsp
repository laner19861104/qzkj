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
formlist.action="<%=request.getContextPath()%>/energydwnhzbyj.action";
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
<div class="position">��ǰλ�ã��ܺ�ˮƽ����ϵͳ >> ��Դ����״��  >> ��ҵ�ܺ�״������ >> ��λ�ܺ�ָ��Ԥ��������ϸ</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td>
        
         <table  border="0" cellpadding=0 cellspacing=0 width="100%" height="25" align="center" >
        <tr> 
          <td  class="updown"  style="cursor: hand" onClick="outliner()" child="1ALL" id="updown1" background="templates/image/title_bg_down.jpg"></td>
         </tr>
      </table>
        <div   class="expanded"   id="1ALL" > 
   <form action="<%=request.getContextPath()%>/energydwnhzbyjmx" name="formlist" method="post">
   <input type="hidden" name="dwmc" id="dwbh" value="${dwmc}" />
   <input type="hidden" name="dwbhs" id="dwbhs" value="${dwbhs}"/>
   <input type="hidden" name="nd" id="nd" value="${nd}" />
    <input type="hidden" name="beginyd" id="beginyd" value="${beginyd}" />
 <input type="hidden" name="mczh" id="mczh" value="1" />
    <input type="hidden" name="sfzxcx" id="sfzxcx" value="1" />
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
										<tr>
											<td>
											<fieldset>
												<legend></legend>
											
<table border="0" cellpadding="0" cellspacing="0" class="btntable" width="97%">
				<tr>
				<td width="80%" align="center"><font size="+3">${nymc}�ɳ��Է����б�</font></td>
					<td>
						<a class="btn" onclick="" href="javascript:searchlist();"><span class="search">�� ��</span></a>
					</td>
				</tr>
			</table>
											</fieldset>								
											</td>
										</tr>
	    </table>
			</div>
   <table border="0" cellspacing="0" cellpadding="0" class="listjx" id="table1"  width="97%" >
          <tr>

              <th width="19%" height="23"  >�·�</th>             
			  <th width="29%" >����</th>
			  <th width="30%" >ͬ��</th>			 
			  <th width="22%" >ͬ��</th>
			 
			 
</tr>
</table>
 <div  id="divtop" style="width:100%;height:100px;overflow: auto;" >
       <table border="0" cellspacing="0" cellpadding="0" class="listjx" id="table1"  width="97%" >
   <c:forEach items="${viewlist}" var="tmp" varStatus="varsta"  >
    
   
  <tr >

<!--    <td align="center">${varsta.count}&nbsp;</td>-->
    <td width="19%">${tmp.yf}&nbsp;</td>
    <td width="29%">${tmp.byz}&nbsp;</td>
    <td width="30%">${tmp.tqz}&nbsp;</td>
    <td width="22%">${tmp.tb}&nbsp;</td>
   
   
    
  </tr>
 
  
  
  </c:forEach>
    
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




   

 
</body>

