function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整 
}

//  数据加载		
$(function() {
	$('#areanamecode').combotree( {
		url : "getwfregiontree.action?lbbh=enterpriseqy",
		width : 180
	});
	$("#s_hyname").combotree( {
		url : "getWfhyTree.action?lbbh=enterpriseqy",
		width : 100
	});
	$("#hyname").combotree('disable');
	$('#tlist').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.85),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'query_queryEnterprise_queryByHql.action',
		loadMsg : '数据装载中......',
		sortName : 'dwbh',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '企业编号',
			field : 'dwbh',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '企业名称',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true
		} ] ],
		columns : [ [ {
			title : '所属区域',
			field : 'cnssqy',
			width : '100',
			align : 'left'
		}, {
			title : '行业分类(标准)',
			field : 'cnhyfl',
			width : '200',
			align : 'left'
		}, {
			title : '行业分类(传统)',
			field : 'cnxxtype',
			width : '200',
			align : 'left'
		}, {
			title : '企业类型',
			field : 'cnzdlb',
			width : '200',
			align : 'left'
		}, {
			title : '企业性质',
			field : 'cndwlx',
			width : '150',
			align : 'left'
		}, {
			title : '详细地址',
			field : 'xxdz',
			width : '240',
			align : 'left'
		}, {
			title : '邮政编码',
			field : 'yzbm',
			width : '100',
			align : 'left'
		}, {
			title : '法人代表',
			field : 'frdb',
			width : '100',
			align : 'left'
		}, {
			title : '注册日期',
			field : 'zcrq',
			width : '120',
			align : 'left'
		}, {
			title : '注册资本（万元）',
			field : 'zczj',
			width : '100',
			align : 'right'
		}, {
			title : '电子邮箱',
			field : 'email',
			width : '150',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true

	});
	displayMsg();
});
function displayMsg() {

	$('#tlist').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
//    tab2查询方法

function q2_search() {

	//	var areanamecode=$('#areanamecode').combotree('getValues');
	//	var qdwmc=$('#qdwmc').val();
	//	var res03=$('#res03').val();
	//	var hytype=$('#hytype').val();
	//	var hyname=$('#hyname').combotree('getValues');
	//	var url="queryenterprise.action?hytype="+hytype;
	//	if(qdwmc!=""&&qdwmc!=null)
	//		url+="&qdwmc="+encodeURIComponent(encodeURIComponent(qdwmc));
	//	if(areanamecode!=null&&areanamecode!="")
	//		url+="&areanamecode="+encodeURIComponent(encodeURIComponent(areanamecode))
	//	if(res03!=null&&res03!="")
	//		url+="&res03="+res03;
	//	if(hyname!=null&&hyname!="")
	//		{
	//		url+="&hyname="+encodeURIComponent(encodeURIComponent(hyname));
	//		}
	
	var url = "query_queryEnterprise_queryByHql.action?"+appCondition();
		$('#tlist').datagrid( {
		url:url,
		loadMsg : '数据装载中......',
		pageNumber:1
		});
		displayMsg();
}

function onChangeValue() {
	var value = $('#hytype').val();
	if (value == "1") {
		document.getElementById("hytype").style.width = "75px";
		$("#hyname").combotree( {
			url : "getWfhyTree.action",
			width : 100
		});
	} else {
		document.getElementById("s_hytype").style.width = "75px";
		$("#hyname").combotree('disable');
	}
}
