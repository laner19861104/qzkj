<%@ page language="java"   pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
 <HEAD>
  <TITLE>Ϋ���й�ҵ�������� </TITLE>
  <meta http-equiv="x-ua-compatible" content="ie=7" /> 
  <meta http-equiv="content-type" content="text/html; charset=gbk">
  <link href="<%=request.getContextPath() %>/templates/css/main_top.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/easyui_tools.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/queryEnterpriseCount.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/util.js"></script>		


</HEAD>
<body class="easyui-layout">
<div region="center" split="true" title="��ǰλ�ã��ۺϲ�ѯ  &gt;&gt; ��ҵ����ͳ��" style="width:320px;height:100%;padding1:1px;overflow:hidden;">	
		
		<div style="padding:5px;background:#ecf0f6;width:100%;">
		<!-- <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="openQuery()">��ѯ</a>-->
		<form id="ff" name="ff" action="">
	<table width="100%" class="title_table" border="0" cellpadding="0" cellspacing="0" >
		<tr>
		<th>��ҵ����:</th>
		<td><input name="qdwmc" id="s_qdwmc" size="20" type="text" class="easyui-validatebox input_text" validType="custom_reg['^1\d{10}','�ֻ����������11λ']" missingMessage="������ͻ��绰��"/></td>
		<th>��&nbsp;&nbsp;&nbsp;&nbsp;��:</th>
		<td><select name="status-areanamecode" id="s_areanamecode" class="easyui-combotree" multiple="true" cascadeCheck="false"  style="width:150px"></select>
		</td>
		<td rowspan="2"  align="right">  <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onClick="q2_search()">��ѯ</a>&nbsp;&nbsp;<br/>
		
		</td>
		</tr>
		<tr>
		<th>�ܺķ�Χ:</th>
		<td>
		<select name="status-res03" id="s_res03" style="width: 135px">
		<option value=""></option>
		<c:forEach items="${nhfw}" var="tmp" varStatus="varsta" >
                     <option value="${tmp.bh}" >${tmp.mc}</option>
        </c:forEach>  
		</select>
		</td>
		<th>��&nbsp;&nbsp;&nbsp;&nbsp;ҵ:</th>
		<td><select id="s_hytype" name="status-hytype" style="width: 75px" onchange="onChangeValue()">
		<option value="2">��׼��ҵ</option>
		<option value="1">��ͳ��ҵ</option>	
		</select>
		<select calss="easyui-combotree" id="s_hyname" name="status-hyname" style="display: none"></select>
		</td>
		</tr>
		</table>	
		 
	</form>
		</div>
		
		
		<table id="tlist"></table>

	

	</div>
	
	
</body>
</HTML>







        
          
	      
	      
	           
