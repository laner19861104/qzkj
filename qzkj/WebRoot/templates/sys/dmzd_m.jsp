<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="<%=request.getContextPath() %>/templates/css/main.css" rel="stylesheet" type="text/css" />
        <script src="templates/js/tdcolor.js" type="text/javascript"></script>
<style type="text/css">
<!--
body {
	margin-top: 2px;
	margin-left: 0px;
	margin-right: 0px;
	background: #ffffff;
}
-->
</style>
<script >

function checkAll(e, itemName) 
{ 
  var aa = document.getElementsByName(itemName); 
  for (var i=0; i<aa.length; i++) 
 aa[i].checked = e.checked; 
} 

</script>
	</head>
	<body   >
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td width="100%" >
        	<div class="mininav_1">
            <h1>�����ֵ�����<span></h1>
                 <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="list" id="table1">
										<tr>
											<th width="33" align="center">
												<input type="checkbox" name="all" id="all" onclick="javascript:checkAll(this,'allcheck');" />
											</th>
											<th width="100">
												���
											</th>
											<th width="290">
												����
											</th>
											<th >
												���
											</th>
										</tr>
	
		                      
		
						
				 </table>

										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="page">
											<tr>
												<td><a href="#">�� ҳ</a> <a href="#">��һҳ</a> <a href="#">��һҳ</a> <a href="#">ĩ ҳ</a> <input name="textfield" type="text" size="3"/> <a href="#">�� ת</a> ����<span>1</span> ҳ , ��<span>1</span> ҳ ����<span>15</span>��/ҳ , ��<span>0</span>����¼�� </td>
											</tr>
										</table>
            
            </div>
        </td>
      </tr>
    </table>
	</body>
</html>
