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
		url : 'querypermission.action',
		loadMsg : '����װ����......',
		idField : 'permissionid',
		sortName : 'permissionno',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : 'Ȩ�ޱ���',
			field : 'permissionno',
			width : '100',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : 'Ȩ������',
			field : 'permissionname',
			width : '250',
			align : 'left'
		}, {
			title : '��Դ����',
			field : 'cnresource',
			width : '250',
			align : 'left'
		}, {
			title : '����',
			field : 'cnaction',
			width : '100',
			align : 'left'
		} ] ],

		columns : [ [ {
			title : '��Ȩ�ޱ���',
			field : 'ppermissionno',
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
	if (mForm.permissionno.value == "") {
		$.messager.alert('��ʾ', '������Ȩ�ޱ���!', 'warning');
		return false;
	}
	if (!loginCheck(mForm.permissionno.value)) {
		$.messager.alert('��ʾ', '����Ȩ�ޱ��벻�Ϸ�������������!', 'warning');
		return false;
	}

	return true;

}
function add() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'addpermission.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querypermission.action',
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
		$('#permissionno').val(select[0].permissionno);
		$('#permissionname').val(select[0].permissionname);
		$('#resourceid').combotree('setValue', select[0].resourceid);
		$('#actionid').val(select[0].actionid);
		$('#ppermissionno').val(select[0].ppermissionno);

		id = select[0].permissionid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
function edit() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'editpermission.action?permissionid=' + id,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querypermission.action',
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
				id = selected.permissionid;
				if (ids == "")
					ids = id;
				else
					ids = ids + "," + id;
			}
			$.ajax( {
				type : "POST",
				url : "delpermission.action",
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
					url : 'querypermission.action',
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

	if ($('#qpermissionname').val() != ""
			&& !descCheck($('#qpermissionname').val())) {
		alert("����Ȩ�����Ʋ��Ϸ�������������!");
		return;
	}

	queryParams.qpermissionname = encodeURIComponent(encodeURIComponent($(
			'#qpermissionname').val()));

	$('#tList').datagrid( {
		url : 'querypermission.action'
	});
	displayMsg();
	$('#query').window('close');
}
