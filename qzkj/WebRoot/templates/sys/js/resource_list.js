$(function() {
	$('#mForm').hide();

	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		//    pageSize:5,
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'queryresource.action',
		loadMsg : '����װ����......',
		idField : 'resourceid',
		treeField : 'resourceno',
		sortName : 'resourceno',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '��Դ����',
			field : 'resourceno',
			width : '100',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��Դ����',
			field : 'resourcename',
			width : '200',
			align : 'left'
		}, {
			title : '��Դ����',
			field : 'cnresourcetype',
			width : '200',
			align : 'left'
		} ] ],

		columns : [ [ {
			title : '����Դ����',
			field : 'presourceno',
			width : '100',
			align : 'left'
		}

		] ],
		pagination : true,
		rownumbers : true,
		toolbar : [ {
			text : '���',
			iconCls : 'icon-add',
			handler : function() {
				$('#add').window('open');
				$('#mForm').show();
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');

			}
		}, '-', {
			text : '�޸�',
			iconCls : 'icon-edit',
			handler : getSelect
		}, '-', {
			text : 'ɾ��',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '��ѯ',
			iconCls : 'icon-search',
			handler : function() {
				$('#query').window('open');

			}
		}, '-', {
			text : '����',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg();
});

function goback() {
	window.location = "gohome.action";
}
function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ�������   
}
function displayMsg() {

	//   $('#tList').datagrid('getPager').pagination({displayMsg:'��ǰ��ʾ��{from}��{to}��{total}��¼'});
	$('#tList').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'

	});

}
function close1() {
	$('#add').window('close');
	$('#tList').datagrid('clearSelections');
}
function close2() {
	$('#edit').window('close');
	$('#tList').datagrid('clearSelections');
}

function validateCheck() {
	if (mForm.resourceno.value == "") {
		$.messager.alert('��ʾ', '��������Դ����!', 'warning');
		return false;
	}
	if (!loginCheck(mForm.resourceno.value)) {
		$.messager.alert('��ʾ', '������Դ���벻�Ϸ�������������!', 'warning');
		return false;
	}

	return true;

}
function add() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'addresource.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryresource.action',
						loadMsg : '����������......'
					});
					displayMsg();
				});
				return;
			} else {
				$.messager.alert('��ʾ', message.info, 'warning');
				return;
			}
		}
	});
}
var id;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#edit').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#ee');
		$('#resourceno').val(select[0].resourceno);
		$('#resourcename').val(select[0].resourcename);
		$('#type').val(select[0].type);
		$('#link').val(select[0].link);
		$('#presourceno').val(select[0].presourceno);

		id = select[0].resourceid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
function edit() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'editresource.action?resourceid=' + id,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryresource.action',
						loadMsg : '����������......'
					});
					close2();
					displayMsg();
				});
			} else {
				$.messager.alert('��ʾ', message.info, 'warning');
				return;
			}
		}
	});

}

/*
 * ɾ������
 */
function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
				id = selected.resourceid;
				if (ids == "")
					ids = id;
				else
					ids = ids + "," + id;
			}
			$.ajax( {
				type : "POST",
				url : "delresource.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
//					var message = eval("(" + message + ")");
					if (message.success == false) {
						$.messager.alert('��ʾ', message.info, 'info');
						return;
					}
					$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
					$('#tList').datagrid('clearSelections');
					$('#tList').datagrid( {
						url : 'queryresource.action',
						loadMsg : '����������......'
					});
				}
			});

		}
	}	);
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}

function query() {
	var queryParams = $('#tList').datagrid('options').queryParams;
	if ($('#qresourcename').val() != ""
			&& !descCheck($('#qresourcename').val())) {
		$.messager.alert('��ʾ', '������Դ���Ʋ��Ϸ�������������!', 'warning');
		return;
	}
	queryParams.qresourcename = encodeURIComponent(encodeURIComponent($(
			'#qresourcename').val()));
	$('#tList').datagrid( {
		url : 'queryresource.action',
		loadMsg : '����������......'
	});
	displayMsg();
	$('#query').window('close');
	$('#tList').datagrid('clearSelections');
}
