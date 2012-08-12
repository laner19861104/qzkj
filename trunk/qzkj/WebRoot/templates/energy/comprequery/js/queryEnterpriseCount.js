function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ������� 
}

//  ���ݼ���		
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
		loadMsg : '����װ����......',
		sortName : 'dwbh',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '��ҵ���',
			field : 'dwbh',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��ҵ����',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true
		} ] ],
		columns : [ [ {
			title : '��������',
			field : 'cnssqy',
			width : '100',
			align : 'left'
		}, {
			title : '��ҵ����(��׼)',
			field : 'cnhyfl',
			width : '200',
			align : 'left'
		}, {
			title : '��ҵ����(��ͳ)',
			field : 'cnxxtype',
			width : '200',
			align : 'left'
		}, {
			title : '��ҵ����',
			field : 'cnzdlb',
			width : '200',
			align : 'left'
		}, {
			title : '��ҵ����',
			field : 'cndwlx',
			width : '150',
			align : 'left'
		}, {
			title : '��ϸ��ַ',
			field : 'xxdz',
			width : '240',
			align : 'left'
		}, {
			title : '��������',
			field : 'yzbm',
			width : '100',
			align : 'left'
		}, {
			title : '���˴���',
			field : 'frdb',
			width : '100',
			align : 'left'
		}, {
			title : 'ע������',
			field : 'zcrq',
			width : '120',
			align : 'left'
		}, {
			title : 'ע���ʱ�����Ԫ��',
			field : 'zczj',
			width : '100',
			align : 'right'
		}, {
			title : '��������',
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
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
//    tab2��ѯ����

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
		loadMsg : '����װ����......',
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
