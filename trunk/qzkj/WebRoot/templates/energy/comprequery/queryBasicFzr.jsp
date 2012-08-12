<%@ page language="java"   pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
 <HEAD>
  <TITLE>潍坊市工业经济运行 </TITLE>
  <meta http-equiv="x-ua-compatible" content="ie=7" /> 
  <meta http-equiv="content-type" content="text/html; charset=gbk">
  <link href="<%=request.getContextPath() %>/templates/css/main_top.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/queryBasicFzr.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/util.js"></script>		


</HEAD>
<body class="easyui-layout">
<div region="center" split="true" title="当前位置：综合查询  &gt;&gt; 能源管理负责人查询" style="width:320px;height:100%;padding1:1px;overflow:hidden;">	
		
		<div style="padding:5px;background:#ecf0f6;width:100%;">
		<!-- <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="openQuery()">查询</a>-->
		<form id="ff" name="ff" action="">
	<table width="100%" class="title_table" border="0" cellpadding="0" cellspacing="0" >
		<tr>
		<th>姓&nbsp;&nbsp;&nbsp;&nbsp;名:</th>
		<td><input name="glyxm" id="glyxm" size="20" type="text" class="input_text"/></td>
		<th>培 训 号:</th>
		<td><input name="pxh" id="pxh" size="20" type="text" class="input_text"/></td>
		<td rowspan="2"  align="right">  <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onClick="q2_search()">查询</a>&nbsp;&nbsp;<br/>
		
		</td>
		</tr>
		<tr>
		<th>联系电话:</th>
		<td><input name="lxdh" id="lxdh" size="20" type="text" class="input_text"/></td>
		<th>年&nbsp;&nbsp;&nbsp;&nbsp;度:</th>
		<td><select name="nd" id="nd" style="width:139px" >
		 <option value="" ></option>
			 <option value="2007" >2007</option>
                  <option value="2008" >2008</option>
                  <option value="2009" >2009</option>
                  <option value="2010" >2010</option>
                  <option value="2011" >2011</option>
                  <option value="2012" >2012</option>
                  <option value="2013" >2013</option>
                  <option value="2014" >2014</option>
                  <option value="2015" >2015</option>
                  <option value="2016" >2016</option>
                  <option value="2017" >2017</option>
                  <option value="2018" >2018</option>
                  <option value="2019" >2019</option>
                  <option value="2020" >2020</option>
                  <option value="2021" >2021</option>
                  <option value="2022" >2022</option>
		</select>
		</td>
		</tr>
		</table>	
		 
	</form>
		</div>
		
		
		<table id="tlist"></table>

	

	</div>
	
	
</body>
</HTML>







        
          
	      
	      
	           
