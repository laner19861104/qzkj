var urls = eval( {
	"query" : "query_querySubjectAction_query.action",
	"add" : "modify_editSubjectAction_add.action",
	"edit" : "modify_editSubjectAction_edit.action",
	"del" : "modify_editSubjectAction_del.action",
	"get":"get_querySubjectAction_get.action"
});
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
		url : urls['query'],
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
function add() {
	if (!validateCheck()) {return;}
	$('#mForm').form('submit', {
		url : urls['add'],
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
function showedit() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('����', '��ѡ��һ������!', 'warning');
		return;
	}
	jQuery.getJSON(urls['get'], {id:select[0].id}, function(obj) {
			fillForm(obj);
		}
	);
	$('#view').window('open');
	$('#mForm').show();
	$('#mForm').appendTo('#dd');
}
function showquery() {}
function view() {}
function edit() {}
function del() {}

function close1() {
	$('#add').window('close');
}
function close2() {
	$('#edit').window('close');
}
function close3() {
	$('#view').window('close');
}

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