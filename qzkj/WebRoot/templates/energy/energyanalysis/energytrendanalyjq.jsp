<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��Ȩҳ��</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/charts/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js"></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/Calendar.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/setmonth1.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/searchjs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/lightbox.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/createxmldoc.js" type="text/javascript"></script>  

<script language="javascript"> 

function searchSubmit(){
  var bigin_time = document.getElementsByName("beginTime")[0].value;
  var end_time = document.getElementsByName("endTime")[0].value;

  
  if(bigin_time==""){
  alert("��ѡ�� ��ʼʱ�� ��");
  return;
  }
   
  if(end_time==""){
  alert("��ѡ�� ����ʱ�� ��");
  return;
  }
  
  if(end_time<bigin_time){
  alert("����ʱ�� Ҫ���� ��ʼʱ�䣡");
  return;
  }

  if(document.getElementsByName("searchmodel_class")[0].value=="-1"){
  alert("��ѡ��Ҫ ģ����� ��");
  return;
  }

  if(document.getElementsByName("zbselect")[0].value=="-1"){
  alert("��ѡ��Ҫ ָ�����ͣ�");
  return;
  }

   searchForm.submit();
}


function subSubmit(){
  if(!qz_check()){
   return;
  }
  
    <c:if test="${mathCount==4}">
    var _startValue = document.getElementsByName("startValue")[0];
    var _radioValue = document.getElementsByName("radioValue")[0];
    if(_startValue.value==""||!checkNum(_startValue)){
    alert("��ʼֵ��Ϊ����Ϊ�����֣�");
    return;
    }      		                                   
    if(_radioValue.value==""||!checkNum(_radioValue)){
    alert("ƽ��ϵ������Ϊ����Ϊ�����֣�");
    return;
    }
   </c:if>
   var _steplen = document.getElementsByName("steplen")[0];
   
   if(_steplen.value==""||!checkNum(_steplen)){
    alert("�ƶ�������Ϊ����Ϊ�����֣�");
    return;
    }
    
 subForm.submit();

}

function qz_check(){
  
  var qz_check = true;
    <c:if test="${mathCount==3}"> 
     
    var qz_count =0;
     var flag = true;
	<c:forEach items="${data_list}" var="po_value" varStatus="varsta">
    var  _obj = document.getElementsByName("quanzhong_${varsta.count}")[0];
    if(_obj.value!=""&&!checkNum(_obj)){
     flag = false; 
    }
    
    var _quanzhong = _obj.value*1.0;
    qz_count=qz_count+_quanzhong;
	</c:forEach>
    
    if(!flag){
    alert("��Ȩֵֻ��Ϊ���֣�");
    qz_check=false;
    }
    if(qz_count>1){
    alert("��Ȩֵ�ܺ�Ϊ"+qz_count+",�Ѿ�����1��");
    qz_check=false;
    }
 </c:if>
  return qz_check;

}


</script>




</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
	   <td>&nbsp;&nbsp;&nbsp;��ǰλ�ã���ԴԤ�⡢Ԥ��ϵͳ&gt;&gt; �ܺ�����Ԥ�����</td>
	</tr>
</table>

<table  border="0" cellpadding=0 cellspacing=0 width="100%" height="25" align="center" >
        <tr> 
          <td  class="updown"  style="cursor: hand" onClick="outliner()" child="1ALL" id="updown1" background="templates/image/title_bg_down.jpg">&nbsp;&nbsp;&nbsp;&nbsp;</td>
         </tr>
 </table>
 <div  class="expanded"   id="1ALL" > 
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset>
          <legend></legend>
                      
         <form action="<%=request.getContextPath()%>/energytrendanalysis.action" 	name="searchForm" method="post">  
       <input type="hidden" name="flag" id="flag" value="query"/>
          <table border="0" cellpadding="0" cellspacing="6" width="98%">
            
             <tr>
<!--              <td >��ʼʱ�䣺&nbsp;&nbsp;<input type="text" name="beginTime"  value="${beginTime}"  size="8" readonly="true" onclick="setMonth(this)"/>&nbsp;����&nbsp;<input type="text" name="endTime" value="${endTime}" size="8" readonly="true" onclick="setMonth(this)"/>&nbsp;&nbsp;</td>-->
<!--                   <td ><table>-->
<!--		           <s:select name="qytype"  label="��ҵ����"  cssStyle="width:200px;" labelSeparator="��" labelposition="-1"  headerValue="��ѡ��" list="qytype_list" listKey="bh" listValue="mc"   />-->
<!--		           </table></td>-->
				 <td >��ʼʱ�䣺&nbsp;&nbsp;
               <select name="beginTime"  id="beginTime" style="width:60px">
                  
                  <option value="2007">2007</option>
                  <option value="2008">2008</option>
                  <option value="2009">2009</option>
                  <option value="2010">2010</option>
                  <option value="2011">2011</option>
                  <option value="2012">2012</option>
                  <option value="2013">2013</option>
                  <option value="2014">2014</option>
                  <option value="2015">2015</option>
                  <option value="2016">2016</option>
                  <option value="2017">2017</option>
                  <option value="2018">2018</option>
                  <option value="2019">2019</option>
                  <option value="2020">2020</option>
                  <option value="2021">2021</option>
                  <option value="2022">2022</option>
				 </select>
              
<!--              <input type="text" name="beginTime"  value="${beginTime}"  size="8" readonly="true" onclick="setMonth(this)"/>-->
              &nbsp;����&nbsp;
              <select name="endTime"  id="endTime" style="width:60px">
                  
                  <option value="2007">2007</option>
                  <option value="2008">2008</option>
                  <option value="2009">2009</option>
                  <option value="2010">2010</option>
                  <option value="2011">2011</option>
                  <option value="2012">2012</option>
                  <option value="2013">2013</option>
                  <option value="2014">2014</option>
                  <option value="2015">2015</option>
                  <option value="2016">2016</option>
                  <option value="2017">2017</option>
                  <option value="2018">2018</option>
                  <option value="2019">2019</option>
                  <option value="2020">2020</option>
                  <option value="2021">2021</option>
                  <option value="2022">2022</option>
				 </select>
<!--              <input type="text" name="endTime" value="${endTime}" size="8" readonly="true" onclick="setMonth(this)"/>-->
              &nbsp;&nbsp;</td>
             </tr>
	           <tr>
		           <td  style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;"><table>
		           <s:select name="searchmodel_class"  label="ģ�����"  cssStyle="width:200px;" labelSeparator="��" labelposition="-1" headerKey="-1" headerValue="��ѡ��" list="model_list" listKey="algid" listValue="name"   />
		           </table></td>
		           
		           <td style="border-bottom: 1px dashed #cccccc;padding: 5px 0px 5px 0px;">
		                         ָ��ѡ��&nbsp;&nbsp;
		          <select name="zbselect" id="zbselect" style="width:200px;">
		          <option value="zhnyxfldl" <c:if test="${zbselect=='zhnyxfldl'}">selected="selected"</c:if>>�ۺ��ܺ�</option>
		          <option value="gyzcz" <c:if test="${zbselect=='gyzcz'}">selected="selected"</c:if>>��ҵ�ܲ�ֵ</option>
		          <option value="gyzjz" <c:if test="${zbselect=='gyzjz'}">selected="selected"</c:if>>��ҵ����ֵ</option>
		          <option value="dwgyzczdl" <c:if test="${zbselect=='dwgyzczdl'}">selected="selected"</c:if>>��Ԫ��ҵ��ֵ�ܺ�</option>
		          <option value="wyzjznhdl" <c:if test="${zbselect=='wyzjznhdl'}">selected="selected"</c:if>>��Ԫ����ֵ�ܺ� </option>
		          </select>               
		      </td>
		       </tr>
				<tr>
				   <td colspan="2" width="100%" ><a class="btn" style="float: right;" onclick="" href="javascript:searchSubmit();"><span class="search">�� ѯ</span></a></td>		
				</tr>
          </table>		
		</form>
	 </fieldset>
</td>
</tr>
 </table>
 </div>   
    <br />
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	  <td>
			<table border="0" cellpadding="0" cellspacing="0" class="Menubox">
			  <tr>
				<td><ul>
				  <li id="one1"  class="hover">���������</li>
				</ul></td>
			  </tr>
			</table>
	  
			<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" class="Contentbox">
			  <tr>
				<td>

        <form action="<%=request.getContextPath()%>/energytrendanalysiscreatchars.action" 	name="subForm" method="post">  
						<table width="100%" id="con_one_1" class="hover">
							<tr>
								<td>
										<table  width="100%" border="0" cellspacing="0" cellpadding="0"  class="tableout_jsd list_jsd " >
										  
										  <tr>
										    <th colspan="100">${beginTime}����${endTime} �����������ҵ��������Ԥ�� </th>
										  </tr>

										  <tr>
										    <th  width="15%" rowspan="2">ָ������</th>
										  </tr>
	
										  <tr>
										 
   	    								    <c:forEach items="${time_list}" var="time_value" varStatus="varsta">
										    <td>${time_value}</td>
										    </c:forEach>
										  </tr>
		
		
		                                  <tr>
		                                    <th  width="15%">��&nbsp��&nbspֵ</th>
		                                  	<c:forEach items="${data_list}" var="po_value" varStatus="varsta">
										         <td>${po_value}&nbsp;</td>
										      </c:forEach>
		                                  </tr>
									      
									      
									      <c:if test="${mathCount>1}">
										    <tr>
			                                  <th  width="15%">�ƶ�����</th>
			                                   <td colspan="100" width="100%" style="float: left;TEXT-ALIGN: left;"><input size="10" maxlength="10"  type="text"  name="steplen" id="steplen"  value="${steplen}"/>&nbsp;*ע���������д���ƶ�����Ĭ��ֵΪ3</td>
			                                </tr></c:if>
										      
									      
									      <c:if test="${mathCount==3}"> 
					                    <tr>
		                                  <th  width="15%">��&nbspȨ&nbspֵ</th>
		                                  	<c:forEach items="${data_list}" var="po_value" varStatus="varsta">
										       <td ><input size="5" maxlength="10"  type="text"  name="quanzhong_${varsta.count}" id="quanzhong_${varsta.count}" />&nbsp;</td>
										    </c:forEach>
		                                 </tr>
		                                 </c:if>
		                                 
								             <c:if test="${mathCount==4}">
										      <tr>
			                                  <th  width="15%">��&nbsp;ʼ&nbsp;ֵ</th>
			                                   <td colspan="100" width="100%" style="float: left;TEXT-ALIGN: left;"><input size="10" maxlength="10"  type="text"  name="startValue" id="startValue"  value="${startValue}"/>&nbsp;</td>
			                                   </tr>
			                                  
			                                   <tr>
			                                   <th  width="15%">ƽ��ϵ����</th>
			                                   <td colspan="100" width="100%" style="float: left;TEXT-ALIGN: left;"><input size="10" maxlength="10"  type="text"  name="radioValue" id="radioValue"  value="${radioValue}"/>&nbsp;*ע������Сֵ 0.1��0.3;���м�ֵ  0.3��0.5�����ϴ�ֵ  0.6��0.8��
			                                   </td>
			                                   </tr></c:if>
										      	      
		                                 
		                                 
									</table>
								</td>
							</tr>

                          <tr>
                             <td colspan="2" width="100%" ><a class="btn" style="float: right;" onclick="" href="javascript:subSubmit();"><span class="search">����ģ��</span></a></td>
                          </tr> 
						</table>
			</form>
			
			
			
			
			
						
							
										
				</td>
			  </tr>
			</table>
			
		</td>
	</tr>
</table>



</body>
</html>
