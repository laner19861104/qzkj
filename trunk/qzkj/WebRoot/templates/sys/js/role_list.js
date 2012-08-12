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
		url : 'queryrole.action',
		loadMsg : '����װ����......',
		idField : 'roleid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '��ɫ����',
			field : 'rolename',
			width : '150',
			align : 'left',
			sortable : true
		}, {
			title : '��ɫ����',
			field : 'cntype',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		} ] ],
		columns : [ [ {
			title : '��������',
			field : 'deptname',
			width : '250',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��������',
			field : 'deptno',
			width : '60',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		} ] ],
		pagination : true,
		rownumbers : true,
		onDblClickRow : function() {
			getView()
		},
		toolbar : [ {
			text : '����',
			iconCls : 'icon-view',
			handler : getView
		}, '-', {
			text : '���',
			iconCls : 'icon-add',
			handler : function() {
				$('#add').window('open');
				$('#mForm').show();
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
				$('#deptno').combotree( {
					url : '$base/getdepttree.action'
				});
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
			text : '��ӦȨ��',
			iconCls : 'icon-relation_1',
			handler : getRolepermission
		}, '-', {
			text : '����',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg();

	$('#tList_permission').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : '',
		loadMsg : '����װ����......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '��ɫ����',
			field : 'rolename',
			width : '100',
			align : 'left'
		}, {
			title : 'Ȩ�ޱ���',
			field : 'permissionno',
			width : '100',
			align : 'left'
		}, {
			title : 'Ȩ������',
			field : 'permissionname',
			width : '200',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : []

	});
	displayMsg_permission();
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
function close3() {
	$('#view').window('close');
	$('#tList').datagrid('clearSelections');
}

function validateCheck() {
	if (mForm.rolename.value == "") {
		$.messager.alert('��ʾ', '�������ɫ����!', 'warning');
		return false;
	}
	return true;
}

function add() {
	if (!validateCheck())
		return;
	$('#mForm').form(
			'submit',
			{
				url : 'addrole.action',
				onSubmit : function() {
					return $('#mForm').form('validate');
				},
				type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
				success : function(message) {
					var message = eval("(" + message + ")");
					if (message.success == true) {
						$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info',
								function() {
									$('#tList').datagrid( {
										url : 'queryrole.action',
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

var roleid;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#deptno').combotree( {
			url : '$base/getdepttree.action'
		});
		$('#edit').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#ee');
		$('#rolename').val(select[0].rolename);
		$('#title').val(select[0].title);
		$('#type').val(select[0].type);
		$('#deptno').combotree('setValue', select[0].deptno);
		$('#description').val(select[0].description);
		roleid = select[0].roleid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
//�鿴
function getView() {

	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#deptno').combotree( {
			url : '$base/getdepttree.action'
		});
		$('#view').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#dd');
		$('#rolename').val(select[0].rolename);
		$('#title').val(select[0].title);
		$('#type').val(select[0].type);
		$('#deptno').combotree('setValue', select[0].deptno);
		$('#description').val(select[0].description);
		roleid = select[0].roleid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
function edit() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'editrole.action?roleid=' + roleid,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryrole.action',
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

function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds == "" || selecteds.length <= 0) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	} else {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
				id = selected.roleid;
				if (ids == "")
					ids = "'" + id + "'";
				else
					ids = ids + "," + "'" + id + "'";
			}
			$.ajax( {
				type : "POST",
				url : "delrole.action",
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
					url : 'queryrole.action',
					loadMsg : '����������......'
				});
			}

			});
		}
	}	);
	}
}

//��ɫȨ��
function getRolepermission() {

	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		roleid = select[0].roleid;
		$('#tList_permission').datagrid( {
			iconCls : 'icon-save',
			width : "100%",
			height : fixHeight(0.95),
			pageList : [ 15, 30, 45, 60 ],
			nowrap : false,
			striped : true,
			collapsible : true,
			url : 'queryrolepermission.action?roleid=' + roleid,
			loadMsg : '����װ����......',
			idField : 'id',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck2',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '��ɫ����',
				field : 'rolename',
				width : '100',
				align : 'left'
			}, {
				title : 'Ȩ�ޱ���',
				field : 'permissionno',
				width : '100',
				align : 'left'
			}, {
				title : 'Ȩ������',
				field : 'permissionname',
				width : '200',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '���',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_permission').window('open');
					$('#mForm_permission').show();
					$('#mForm_permission').form('clear');
					$('#mForm_permission').appendTo('#aa_permission');
				}
			}, '-', {
				text : 'ɾ��',
				iconCls : 'icon-remove',
				handler : del_permission
			} ]

		});
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'info');
	}
	displayMsg_permission();
}

function displayMsg_permission() {
	$('#tList_permission').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
function validateCheck_permission() {
	if (mForm_permission.permissionid.value == "") {
		$.messager.alert('��ʾ', '��ѡ��Ȩ�ޱ���!', 'info');
		return false;
	}
	return true;
}
/*
 * ��Ӳ���
 */
function add_permission() {
	var permissionidsc = $('#permissionid').combotree('getValues');
	$('#mForm_permission')
			.form(
					'submit',
					{
						url : 'addrolepermission.action?roleid=' + roleid
								+ "&permissionidsc=" + permissionidsc,
						onSubmit : function() {
							return $(this).form('validate');
						},
						success : function(message) {
							var message = eval("(" + message + ")");
							if (message.success == true) {
								$.messager
										.alert(
												'add-success',
												'�����Ϣ�ɹ�!!!',
												'info',
												function() {
													$('#tList_permission')
															.datagrid(
																	{
																		url : 'queryrolepermission.action?roleid=' + roleid,
																		loadMsg : '����������......'
																	});
													displayMsg();
												});
								return;
							} else {
								$.messager.alert('��ʾ', message.info,
										'warning');
								return;
							}
						}
					});

}

/*
 * ��ȡѡ�����
 */
var id_role;
var id_permission;
function getSelect_permission() {
	var select = $('#tList_permission').datagrid('getSelections');
	if (select.length == 1) {
		$('#edit_permission').window('open');
		$('#mForm_permission').show();
		$('#mForm_permission').appendTo('#ee_permission');
		$('#roleid').val(select[0].id.roleid);
		$('#permissionid').val(select[0].id.permissionid);

		id_role = select[0].id.roleid;
		id_permission = select[0].id.permissionid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������', 'info');
	}
}

/*
 * ɾ������
 */
function del_permission() {
	var selecteds = $('#tList_permission').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�	

				if (ids == "")
					ids = "(" + selected.id.roleid + ","
							+ selected.id.permissionid + ")";
				else
					ids = ids + "," + "(" + selected.id.roleid + ","
							+ selected.id.permissionid + ")";

			}
			$.ajax( {
				type : "POST",
				url : "delrolepermission.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
					//					var message = eval("(" + message + ")");
				if (message.success == false) {
					$.messager.alert('��ʾ', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
				$('#tList_permission').datagrid('clearSelections');
				$('#tList_permission').datagrid( {
					url : 'queryrolepermission.action?roleid=' + roleid,
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

/*
 * �ر���������
 */
function close1_permission() {
	$('#add_permission').window('close');
	$('#tList_permission').datagrid('clearSelections');
}
/*
 * �رձ༭����
 */
function close2_permission() {
	$('#edit_permission').window('close');
	$('#tList_permission').datagrid('clearSelections');
}
function getSelTree() {
	$('#permissionid').combotree( {
		url : "$base/getpermissiontreeofcheck.action?roleid=" + roleid
	});
}
function getSelTree2() {
	$('#deptno').combotree( {
		url : '$base/getdepttree.action'
	});
};