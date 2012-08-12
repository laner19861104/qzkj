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
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/queryMonthCmpCount.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/energy/comprequery/js/zbSelect.js"></script>
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/util.js"></script>		


</HEAD>
<body class="easyui-layout">
<div region="center" split="true" title="当前位置：综合查询  &gt;&gt; 月度指标查询" style="width:320px;height:100%;padding1:1px;overflow:hidden;">	
		
		<div style="padding:5px;background:#ecf0f6;width:100%;">
		<!-- <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="openQuery()">查询</a>-->
		<form id="ff" name="ff" action="">
	<table width="100%" class="title_table" border="0" cellpadding="0" cellspacing="0" >
		<tr>
		  <th>年&nbsp;&nbsp;&nbsp;&nbsp;月:</th>
              <td>  <select name="nd"  id="nd" style="width:56px">
				  <option value="2007" ${nd==2007?"selected":""}>2007</option>
                  <option value="2008" ${nd==2008?"selected":""}>2008</option>
                  <option value="2009" ${nd==2009?"selected":""}>2009</option>
                  <option value="2010" ${nd==2010?"selected":""}>2010</option>
                  <option value="2011" ${nd==2011?"selected":""}>2011</option>
                  <option value="2012" ${nd==2012?"selected":""}>2012</option>
                  <option value="2013" ${nd==2013?"selected":""}>2013</option>
                  <option value="2014" ${nd==2014?"selected":""}>2014</option>
                  <option value="2015" ${nd==2015?"selected":""}>2015</option>
                  <option value="2016" ${nd==2016?"selected":""}>2016</option>
                  <option value="2017" ${nd==2017?"selected":""}>2017</option>
                  <option value="2018" ${nd==2018?"selected":""}>2018</option>
                  <option value="2019" ${nd==2019?"selected":""}>2019</option>
                  <option value="2020" ${nd==2020?"selected":""}>2020</option>
                  <option value="2021" ${nd==2021?"selected":""}>2021</option>
                  <option value="2022" ${nd==2022?"selected":""}>2022</option>
                  </select>年<select name="beginyd"  id="beginyd" style="width:40px" >
                 <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9">9</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                 </select>-<select name="endyd"  id="endyd" style="width:41px">
                 <option value="1" ${yd=="01"?"selected":""}>1</option>
                  <option value="2" ${yd=="02"?"selected":""}>2</option>
                  <option value="3" ${yd=="03"?"selected":""}>3</option>
                  <option value="4" ${yd=="04"?"selected":""}>4</option>
                  <option value="5" ${yd=="05"?"selected":""}>5</option>
                  <option value="6" ${yd=="06"?"selected":""}>6</option>
                  <option value="7" ${yd=="07"?"selected":""}>7</option>
                  <option value="8" ${yd=="08"?"selected":""}>8</option>
                  <option value="9" ${yd=="09"?"selected":""}>9</option>
                  <option value="10" ${yd=="10"?"selected":""}>10</option>
                  <option value="11" ${yd=="11"?"selected":""}>11</option>
                  <option value="12" ${yd=="12"?"selected":""}>12</option>
                 </select>月<font color="red">(*)</font>
			    <!--<input type="text" id="endyd" value="${endyd}"  name="endyd" style="width: 20px"  onkeydown="onlyNum()" onchange="chekvalue(this,12)"/>
			    -->
			  </td>
		
		<th class="title_h1">企业名称:</th>
		<td><input type="text" name="entername" id="entername" size="20" class="input_text"/>
		<input type="hidden" name="entercode" id="entercode"></td>
		<td rowspan="3"  align="right">  <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onClick="q2_search()">查询</a>&nbsp;&nbsp;<br/>
		<a class="easyui-linkbutton" iconCls="icon-export" href="javascript:void(0);" onClick="q2_export()" >导出</a>&nbsp;&nbsp;
		</td>
		</tr>
		<tr>
		<th class="title_th">行业类别:</th>
		<td class="title_th"><select id="hytype" style="width: 75px" onchange="onChangeValue()">
		<option value="1">传统行业</option>
		<option value="2">标准行业</option>
		</select>
		<select calss="easyui-combotree" id="hyname"  style="display: none"></select>
		</td>
		<th class="title_h1 title_th">区域名称:</th>
		<td class="title_th">
		<select name="areaname" id="areaname" class="easyui-combotree" multiple="true" cascadeCheck="false"  style="width:150px"></select>
		</td>
		
		
		</tr>
		</tr>
		<tr>
		<th class="title_th">指标选择:</th>
		<td colspan="7" class="title_th"><input type="text" size="97" id="zbselecttext" onclick="openzbQuery()" class="input_text" readonly="readonly"/><input type="hidden" id="zbselectid"/></td>
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
	<c:forEach var="tmp" items="${ydList}">
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







        
          
	      
	      
	           
