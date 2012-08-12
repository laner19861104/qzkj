function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ������� 
}

//  ���ݼ���		
$(function() {
	$('#tlist').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.8),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'queryFzr.action',
		loadMsg : '����װ����......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '������',
			field : 'qymc',
			width : '55',
			align : 'left',
			sortable : true
		}, {
			title : '��ҵ����',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��Դ������������',
			field : 'glyxm',
			width : '200',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��ѵ��',
			field : 'pxh',
			width : '150',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��ϵ�绰(�ֻ�)',
			field : 'lxdh',
			width : '150',
			align : 'left',
			sortable : true
			
		}] ],
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

	
	var nd=$('#nd').val();
	var glyxm=$('#glyxm').val();
	var pxh=$('#pxh').val();
	var lxdh=$('#lxdh').val();
	var url="queryFzr.action?nd="+nd;
	if(glyxm!=""&&glyxm!=null)
		url+="&glyxm="+encodeURIComponent(encodeURIComponent(glyxm));
	if(pxh!=null&&pxh!="")
		url+="&pxh="+encodeURIComponent(encodeURIComponent(pxh))
	if(lxdh!=null&&lxdh!="")
		url+="&lxdh="+lxdh;
	$('#tlist').datagrid( {
	url:url,
	loadMsg : '����װ����......',
	pageNumber:1
	});
	displayMsg();
	}






