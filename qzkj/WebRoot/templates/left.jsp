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
  <link href="<%=request.getContextPath() %>/templates/JQuery-zTree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/JQuery-zTree/jquery.ztree-2.6.min.js"></script>

	<script>
$(function(){
         //��λ��
var setting;
function getAsyncUrl(treeNode) {
	var url="";
	if(treeNode!=undefined)
        url= "tree_sysTreeAction_getLeftResourceTree.action?resourceid="+treeNode.id;
	else
		url= "tree_sysTreeAction_getLeftResourceTree.action";
    return url;
};   
var zNodes =[
${treeList}
]; 
setting = {
async : true,
asyncUrl:getAsyncUrl
}; 

var zTree=$("#treedw").zTree( setting, zNodes);//��ʼ��������
         }); 

	</script>
	</head>

<body >
<ul id="treedw" class="tree"></ul> 
</body>
</html>
