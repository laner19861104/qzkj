<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��Դ���ѽṹ</title>
<!--<link href="<%=request.getContextPath() %>/charts/Contents/Style.css"  rel="stylesheet" type="text/css" />-->
<script src="<%=request.getContextPath() %>/charts/JSClass/FusionCharts.js" language="JavaScript" ></script>
<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/updown.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/util.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/templates/js/lightbox.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/templates/css/jsd.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
function searchSubmit(tjfl){
if(tjfl==4){
  searchForm.action="<%=request.getContextPath()%>/energyCZConsumeExportExcel.action";
}else{
 searchForm.action="<%=request.getContextPath()%>/energyCZConsume.action";
document.getElementsByName("tjfl")[0].value=tjfl;
}
 searchForm.submit();

}


</script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="position">
	<tr>
		<td><div style="margin-left: 17px;">��ǰλ�ã��ܺ�ˮƽ����ϵͳ&gt;&gt; ��Ȳ�ֵ�ܺ�</div></td>
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
                      
        <form action="<%=request.getContextPath()%>/energyCZConsume.action" 	name="searchForm" method="post">  
          <table border="0" cellpadding="0" cellspacing="6" width="98%">
               <tr>
			      <th>���:</th>
				  <td  id="nd">
					  <select name="nd"  id="nd" >
					      <c:forEach items="${ndList}" var="tmp" varStatus="varsta" >
							<option value="${tmp.nd}" <c:if test="${tmp.nd==nd}">selected</c:if>>${tmp.nd}</option>
						 </c:forEach>	
					  </select>
				 </td>	
<!--				    <td><select name="xhlx"  id="xhlx" >-->
<!--						<option value="1" <c:if test="${xhlx==1}">selected</c:if>>�ܺ�</option>-->
<!--						<option value="2" <c:if test="${xhlx==2}">selected</c:if>>ˮ��</option>-->
<!--					</select>-->
<!--				 	</td>					 	-->
                 			
               
                 			
				<td><input type="hidden" name="tjfl" id="tjfl" value="1"/></td>
				<td><input type="hidden" name="xhlx" id="xhlx" value="1"/>
				     <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit(1);"><span class="search">���ص�����</span></a></td>
				<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit(2);"><span class="search">�� �� ҵ</span></a></td>
				<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit(3);"><span class="search">�� �� ��</span></a></td>
<!--				<td> <a class="btn" style="float: right;" onclick="" href="Javascript:searchSubmit(4);"><span class="search">�� ��</span></a></td>-->

				 <th>����:</th>
				  <td>
					  <select name="orderfl"  id="orderfl" >
					      <option value="1" <c:if test="${orderfl==1}">selected</c:if>>���ۺ��ܺĵ���</option>
					      <option value="2" <c:if test="${orderfl==2}">selected</c:if>>����Ԫ��ҵ��ֵ�ܺĵ���</option>
					      <option value="3" <c:if test="${orderfl==3}">selected</c:if>>����Ԫ����ֵ�ܺĵ���</option>
					  </select>
				 </td>	
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
<!--	   <td>-->
<!--	 ��ʾ��������ÿһ������鿴�������ϸ�������-->
<!--	   </td>-->
	 </tr>
	 <tr>
      	  <td>
	  		<table  width="100%" border="0" cellspacing="0" cellpadding="0"  class="list_jsd" >
				 <tr >
				   <th  rowspan="2"> 
					 <c:if test="${tjfl==1}">�ص�����</c:if>  
					 <c:if test="${tjfl==2}">��ҵ</c:if>  
					 <c:if test="${tjfl==3}">����</c:if>  
				   </th>
					
                	<th colspan="2">�ۺ��ܺ�</th>
                	<th colspan="2">��ҵ�ܲ�ֵ</th>
                	<th colspan="2">��ҵ����ֵ</th>
                	<th colspan="2">��Ԫ��ҵ��ֵ�ܺ�</th>                	                	
                	<th colspan="2">��Ԫ����ֵ�ܺ�</th>       
                	<th rowspan="2">��ҵ</th>

				 </tr>
				 
                 <tr>
					<th >��ֱ�׼ú</th>
					<th >ͬ��%</th>
					
					<th >��Ԫ</th>
					<th >ͬ��%</th>
					
					<th >��Ԫ</th>
					<th >ͬ��%</th>
					
					<th >�ֱ�׼ú/��Ԫ</th>
					<th >ͬ��%</th>
					
					<th >�ֱ�׼ú/��Ԫ</th>
					<th >ͬ��%</th>
				</tr>
				
			<c:forEach items="${data_list}" var="po" varStatus="varsta">
				<tr>
                 <th>
<!--                 <a href="<%=request.getContextPath() %>/energyCZConsumeYearInfo.action?tjflchildern=${po.tjflchildern}&tjfl=${tjfl}&nd=${nd}&xhlx=${xhlx}">${po.class_hy}</a>-->
                 ${po.class_hy}
                 </th>
                                 
                 <td align="right">${po.zhnyxfldl}</td>
                 <td align="right">${po.zhnhtb}</td>

                 <td align="right">${po.gyzcz}</td>
                 <td align="right">${po.gyzcztb}</td>

                 <td align="right">${po.gyzjz}</td>
                 <td align="right">${po.gyzjztb}</td>

                 <td align="right">${po.dwgyzczdl}</td>
                 <td align="right">${po.dwgyzczdltb}</td>

                 <td align="right">${po.wyzjznhdl}</td>
                 <td align="right">${po.wyzjznhdltb}</td>

                 <th><a href="<%=request.getContextPath() %>/energyCZConsumeInfo.action?tjflchildern=${po.tjflchildern}&tjfl=${tjfl}&nd=${nd}&xhlx=${xhlx}&orderfl=1">��ϸ&nbsp;</a></th>
				</tr>
			</c:forEach>
			</table>
	  
			
		</td>
	</tr>
</table>
</body>
</html>
