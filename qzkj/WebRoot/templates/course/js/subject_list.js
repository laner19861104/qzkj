$(function() {
	$('#mForm').hide();
	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'query_querySubjectAction_query.action',
		loadMsg : '����װ����......',
		idField : 'id',
		sortName : 'code',
		sortOrder : 'asc',
		rownumbers:true,	
		remoteSort : false,
		showFooter : true,
		
		frozenColumns : [ [ 
		{field : 'ck', checkbox : true}, 
		{title : '��Ŀ���', field : 'code', width:200, align:'left', sortable:true},
		{title : '��Ŀ����', field : 'name', width:200, align:'left', sortable:true},
		{title : '�۸�',	field : 'cnres01', width : 200,	align:'right', sortable:true}
		] ],
		columns : [ [] ],
		pagination : true,
		rownumbers : true,
		toolbar : gettoolbar()
	});
	displayMsg();
});

function gettoolbar() {
	return [ {
		text : '����',
		iconCls : 'icon-view',
		handler : view
	}, '-', {
		text : '���',
		iconCls : 'icon-add',
		handler : showadd
	}, '-', {
		text : '�޸�',
		iconCls : 'icon-edit',
		handler : showedit
	}, '-', {
		text : 'ɾ��',
		iconCls : 'icon-remove',
		handler : del
	}, '-', {
		text : '��ѯ',
		iconCls : 'icon-search',
		handler : showquery
	} ];
}
function showadd() {
	$('#mForm').form('clear');
	$('#mForm').appendTo('#aa');
	$('#mForm').show();
	$('#add').window('open');
}
function showedit() {
	
}
function showquery() {}
function view() {}
function add() {
	if (!validateCheck()) {return;}
	$('#mForm').form('submit', {
		url : 'modify_editSubjectAction_add.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
		success : function(msg) {
			var message = eval("(" + msg + ")");
			if (message.success == true) {
				$.messager.alert('��ʾ', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid('reload');
					displayMsg();
				});
				$('#mForm').form('clear');
				return;
			} else {
				$.messager.alert('����', message.info, 'warning');
				return;
			}
		}
	});
}
function edit() {}
function del() {}

function validateCheck() {
	if (null == $('#code').val() || "" == $('#code').val()) {
		$.messager.alert('����', '����д��Ŀ���!', 'warning');
		return false;
	}
	if (null == $('#name').val() || "" == $('#name').val()) {
		$.messager.alert('����', '����д��Ŀ����!', 'warning');
		return false;
	}
	if (null == $('#cost').val() || "" == $('#cost').val()) {
		$.messager.alert('����', '����д��Ŀ�۸�!', 'warning');
		return false;
	}
	return true;
}