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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/portal.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery.portal.js"></script>
	<script>
		$(function(){
			$('#pp').portal({
				border:false,
				fit:true
			});
		});
	</script>
	</head>

<body class="easyui-layout">
<div region="center" border="false">
	<div id="pp" style="position:relative">
		<div style="width:33%;">
				<div title="Clock" style="text-align:center;background:#f3eeaf;height:150px;padding:5px;">
					<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="100" height="100">
				      <param name="movie" value="http://www.respectsoft.com/onlineclock/analog.swf">
				      <param name=quality value=high>
				      <param name="wmode" value="transparent">
				      <embed src="http://www.respectsoft.com/onlineclock/analog.swf" width="100" height="100" quality=high pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" wmode="transparent"></embed>
				    </object>
			    </div>
			    <div title="Tutorials" collapsible="true" closable="true" style="height:200px;padding:5px;">
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/datagrid/datagrid1.php">Build border layout for Web Pages</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/panel.php">Complex layout on Panel</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/accordion.php">Create Accordion</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/tabs.php">Create Tabs</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/tabs2.php">Dynamically add tabs</a></div>
			    	<div class="t-list"><a href="http://www.jeasyui.com/tutorial/layout/panel2.php">Create XP style left panel</a></div>
			    </div>
			</div>
	
	<div style="width:33%;">
				<div id="pgrid" title="DataGrid" closable="true" style="height:200px;">
					<table class="easyui-datagrid" style="width:650px;height:auto"
							fit="true" border="false"
							singleSelect="true"
							idField="itemid" url="datagrid_data.json">
						<thead>
							<tr>
								<th field="itemid" width="60">Item ID</th>
								<th field="productid" width="60">Product ID</th>
								<th field="listprice" width="80" align="right">List Price</th>
								<th field="unitcost" width="80" align="right">Unit Cost</th>
								<th field="attr1" width="120">Attribute</th>
								<th field="status" width="50" align="center">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
	<div style="width:33%;">
	</div>
	
	</div>
	</div>
</body>
</html>
