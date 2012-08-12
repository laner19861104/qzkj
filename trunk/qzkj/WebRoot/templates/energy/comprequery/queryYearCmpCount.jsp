<%@ page language="java"   pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
 <HEAD>
  <TITLE> </TITLE>
  <meta http-equiv="x-ua-compatible" content="ie=7" /> 
  <meta http-equiv="content-type" content="text/html; charset=gbk">
  <link href="<%=request.getContextPath() %>/templates/css/main_top.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/queryYearCmpCount.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/zbSelect.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/util.js"></script>		


</HEAD>
<body class="easyui-layout">
<div region="center" split="true" title="当前位置：综合查询  &gt;&gt; 年度指标查询" style="width:320px;height:100%;padding1:1px;overflow:hidden;">	
		
		<div style="padding:5px;background:#ecf0f6;width:100%;">
		<!-- <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="openQuery()">查询</a>-->
		<form id="ff" name="ff" action="">
	<table width="100%" class="title_table" border="0" cellpadding="0" cellspacing="0" >
		<tr>
		 <th>年&nbsp;&nbsp;&nbsp;&nbsp;度:</th>
              <td>  <select name="nds"  id="nds" style="width:59px">
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
                  </select>-<select name="nde"  id="nde" style="width:59px">
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
               <font color="red">(*)</font>
			    <!--<input type="text" id="endyd" value="${endyd}"  name="endyd" style="width: 20px"  onkeydown="onlyNum()" onchange="chekvalue(this,12)"/>
			    -->
			  </td>
		
		
		<th>区域名称:</th>
		<td>
		<select name="areaname" id="areaname" class="easyui-combotree" multiple="true" cascadeCheck="false"  style="width:150px"></select>
		</font></td>
		<th class="title_th">行业类别:</th>
		<td class="title_th"><select id="hytype" style="width: 84px" onchange="onChangeValue()">
		<option value="1">传统行业</option>
		<option value="2">标准行业</option>
		</select>
		<select calss="easyui-combotree" id="hyname"  style="display: none"></select></td>
		<td rowspan="2" width="100px">&nbsp;</td>
		<td rowspan="2"><a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onClick="q2_search()" >查询</a>&nbsp;&nbsp;<br/>
		<a class="easyui-linkbutton" iconCls="icon-export" href="javascript:void(0);" onClick="q2_export()" >导出</a>&nbsp;&nbsp;
		
		</td>
		</tr>
		<tr>
		<th class="title_th">指标选择:</th>
		<td colspan="6" class="title_th"><input type="text" size="110" id="zbselecttext" onclick="openzbQuery()" class="input_text" readonly="readonly"/><input type="hidden" id="zbselectid"/></td>
		
		</tr>
		</table>
	</form>
		</div>
		
		
		<iframe id="disFrame" src="" width="100%" height="80%" scrolling="no"></iframe>

	

	</div>
	
	
	
	 <div id="query" class="easyui-window" modal="true"  title="查询" style="top:50px;padding: 10px;width: 800px;height:200px;"
    iconCls="icon-search" closed="true" maximizable="false" minimizable="false" collapsible="false">
	
	</div>
	
	<div id="view" class="easyui-window" modal="true" title="查询" style="top:50px;padding: 10px;width: 645px;height:460px"
    iconCls="icon-search" closed="true" maximizable="false" minimizable="false" collapsible="false" >
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
	<th>表名:</th>
	<td><select id="dybid" style="width: 138px" onchange="tableSelectChange()">
	<c:forEach var="tmp" items="${ndList}">
	<option value="${tmp.tablecode}">${tmp.tablename}</option>
	</c:forEach>
	</select></td>
	<th width="100px">指标名称:</th>
	<td><input type="text" id="zbname" class="input_text" size="20"/></td>
	<td><a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onClick="zbQuery()">查询</a></td>
	</tr>
	<tr>
	<td colspan="5">
	<table border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td><table id="zblist"></table></td>
	<td>&nbsp;</td>
	<td><table id="zblist2"></table></td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	<div align="center">
	<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0);" onClick="selectedZb('zbselecttext')">确定</a>&nbsp;
	<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0);" onClick="closezb()">取消</a>
	</div>
	</div>
</body>
</HTML>







        
          
	      
	      
	           
