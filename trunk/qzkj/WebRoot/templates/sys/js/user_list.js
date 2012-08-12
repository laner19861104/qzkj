$(function() {
	$('#mForm').hide();
	$('#mForm_role').hide();
	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'queryuser.action',
		loadMsg : '����װ����......',
		idField : 'userid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		}, {
			title : '�û�����',
			field : 'username',
			width : '100',
			align : 'left',
			sortable : true
		}, {
			title : '�û�����',
			field : 'userxm',
			width : '150',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��������',
			field : 'deptid',
			width : '100',
			align : 'left',
			sortable : true
		} ] ],
		columns : [ [ ] ],
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
				$('#password').removeAttr('readonly');
				$('#password2').removeAttr('readonly');
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
			text : '��Ӧ��ɫ',
			iconCls : 'icon-relation_1',
			handler : getUserrole
		}, '-', {
			text : '����',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg();

	$('#tList_role').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		loadMsg : '����װ����......',
		idField : 'roleid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '��ɫ����',
			field : 'rolename',
			width : '200',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : []

	});
	displayMsg_role();
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

function validateCheckadd() {
	if (mForm.username.value == "") {
		$.messager.alert('��ʾ', '�������û���!', 'warning');
		return false;
	}
	if (mForm.userxm.value == "") {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
		return false;
	}
	if (mForm.password.value == "") {
		$.messager.alert('��ʾ', '����������!', 'warning');
		return false;
	}
	if (mForm.password2.value == "") {
		$.messager.alert('��ʾ', '������ȷ������!', 'warning');
		return false;
	}
	if (mForm.password.value != mForm.password2.value) {
		$.messager.alert('��ʾ', '������������벻һ�£�����������!', 'warning');
		mForm.password.value = "";
		mForm.password2.value = "";
		return false;
	}
	if (mForm.usetype.value == "") {
		$.messager.alert('��ʾ', '�������û�����!', 'warning');
		return false;
	}
	return true;
}

function add() {
	if (!validateCheckadd())
		return;

	$('#mForm').form(
			'submit',
			{
				url : 'adduser.action',
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
										url : 'queryuser.action',
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
var userid;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#edit').window('open');
		$('#password').attr('readonly', 'readonly');
		$('#password2').attr('readonly', 'readonly');
		$('#mForm').show();
		$('#mForm').appendTo('#ee');
		$('#username').val(select[0].username);
		$('#userxm').val(select[0].userxm);
		$('#deptid').combotree('setValue', select[0].deptid);
		$('#regioncode').combotree('setValue', select[0].regioncode);
		$('#sex').val(select[0].sex);
		$('#postpriv').val(select[0].postpriv);
		$('#usertype').val(select[0].usertype);
		$('#dutytype').val(select[0].dutytype);
		$('#birthday').val(select[0].birthday);
		$('#email').val(select[0].email);
		$('#ziphome').val(select[0].ziphome);
		$('#address').val(select[0].address);
		$('#telephone').val(select[0].telephone);
		$('#mobile').val(select[0].mobile);
		$('#qq').val(select[0].qq);
		$('#icqq').val(select[0].icq);
		$('#msn').val(select[0].msn);
		$('#skype').val(select[0].skype);
		$('#state').val(select[0].state);
	
		userid = select[0].userid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
//�鿴
function getView() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#view').window('open');
		$('#password').attr('readonly', 'readonly');
		$('#password2').attr('readonly', 'readonly');
		$('#mForm').show();
		$('#mForm').appendTo('#dd');
		$('#username').val(select[0].username);
		$('#userxm').val(select[0].userxm);
		$('#deptid').combotree('setValue', select[0].deptid);
		$('#regioncode').combotree('setValue', select[0].regioncode);
		$('#sex').val(select[0].sex);
		$('#postpriv').val(select[0].postpriv);
		$('#usertype').val(select[0].usertype);
		$('#dutytype').val(select[0].dutytype);
		$('#birthday').val(select[0].birthday);
		$('#email').val(select[0].email);
		$('#ziphome').val(select[0].ziphome);
		$('#address').val(select[0].address);
		$('#telephone').val(select[0].telephone);
		$('#mobile').val(select[0].mobile);
		$('#qq').val(select[0].qq);
		$('#icqq').val(select[0].icq);
		$('#msn').val(select[0].msn);
		$('#skype').val(select[0].skype);
		$('#state').val(select[0].state);
		
		userid = select[0].userid;
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
function validateCheckedit() {
	if (mForm.username.value == "") {
		$.messager.alert('��ʾ', '�������û���!', 'warning');
		return false;
	}
	if (mForm.userxm.value == "") {
		$.messager.alert('��ʾ', '�������û�����!', 'warning');
		return false;
	}
	return true;
}
function edit() {
	if (!validateCheckedit())
		return;
	$('#mForm').form(
			'submit',
			{
				url : 'edituser?userid=' + userid,
				onSubmit : function() {
					return $('#mForm').form('validate');
				},
				type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
				success : function(message) {
					var message = eval("(" + message + ")");
					if (message.success == true) {
						$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info',
								function() {
									$('#tList').datagrid( {
										url : 'queryuser.action',
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
				id = selected.userid;
				if (ids == "")
					ids = "'" + id + "'";
				else
					ids = ids + "," + "'" + id + "'";
			}
			$.ajax( {
				type : "POST",
				url : "deluser.action",
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
					url : 'queryuser.action',
					loadMsg : '����������......'
				});
			}

			});
		}
	}	);
	}
}

var userid;
//��ɫȨ��
function getUserrole() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		userid = select[0].userid;
		$('#tList_role').datagrid( {
			iconCls : 'icon-save',
			width : "100%",
			height : fixHeight(0.95),
			pageList : [ 15, 30, 45, 60 ],
			nowrap : false,
			striped : true,
			collapsible : true,
			url : 'queryuserrole.action?userid=' + userid,
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
				width : '200',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '���',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_role').window('open');
					$('#mForm_role').show();
					$('#mForm_role').form('clear');
					$('#mForm_role').appendTo('#aa_role');
				}
			}, '-', {
				text : 'ɾ��',
				iconCls : 'icon-remove',
				handler : del_role
			} ]

		});
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'info');
	}
	displayMsg_role();
}

function displayMsg_role() {
	$('#tList_role').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
function validateCheck_role() {
	if (mForm_role.roleid.value == "") {
		$.messager.alert('��ʾ', '������Ȩ�ޱ���!', 'warning');
		return false;
	}
	return true;
}
/*
 * ��Ӳ���
 */
function add_role() {
	//var roleidsc = $('#roleid').combotree('getValues');
	$('#mForm_role')
			.form(
					'submit',
					{
						url : 'adduserrole.action?userid=' + userid
								+ '&roleid=' + $('#roleid').val(),
						onSubmit : function() {
							return $('#mForm_role').form('validate');
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
													$('#tList_role')
															.datagrid(
																	{
																		url : 'queryuserrole.action?userid=' + userid,
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

///*
// * ��ȡѡ�����
// */
//var id_user;
//var id_role;
//function getSelect_role() {
//	var select = $('#tList_role').datagrid('getSelections');
//	if (select.length == 1) {
//		$('#edit_role').window('open');
//		$('#mForm_role').show();
//		$('#mForm_role').appendTo('#ee_role');
//		$('#userid').val(select[0].id.userid);
//		$('#roleid').val(select[0].id.roleid);
//
//		id_user = select[0].id.userid;
//		id_role = select[0].id.roleid;
//	} else {
//		$.messager.alert('��ʾ', '��ѡ��һ������!', 'info');
//	}
//}

/*
 * ɾ������
 */
function del_role() {
	var selecteds = $('#tList_role').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�	

				if (ids == "")
					ids = "(" + selected.id.userid + "," + selected.id.roleid
							+ ")";
				else
					ids = ids + "," + "(" + selected.id.userid + ","
							+ selected.id.roleid + ")";
			}
			$.ajax( {
				type : "POST",
				url : "deluserrole.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
					//					var message = eval("(" + message + ")");
				if (message.success == false) {
					$.messager.alert('��ʾ', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
				$('#tList_role').datagrid('clearSelections');
				$('#tList_role').datagrid( {
					url : 'queryuserrole.action?userid=' + userid,
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
function close_role() {
	$('#add_role').window('close');
	$('#tList_role').datagrid('clearSelections');
}
///*
// * �رձ༭����
// */
//function close2_role() {
//	$('#edit_permission').window('close');
//}
