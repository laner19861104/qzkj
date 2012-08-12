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
		loadMsg : '数据装载中......',
		idField : 'userid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		}, {
			title : '用户名称',
			field : 'username',
			width : '100',
			align : 'left',
			sortable : true
		}, {
			title : '用户姓名',
			field : 'userxm',
			width : '150',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '所属机构',
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
			text : '详情',
			iconCls : 'icon-view',
			handler : getView
		}, '-', {
			text : '添加',
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
			text : '修改',
			iconCls : 'icon-edit',
			handler : getSelect
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '对应角色',
			iconCls : 'icon-relation_1',
			handler : getUserrole
		}, '-', {
			text : '返回',
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
		loadMsg : '数据装载中......',
		idField : 'roleid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '角色名称',
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
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整   
}
function displayMsg() {
	$('#tList').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
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
		$.messager.alert('提示', '请输入用户名!', 'warning');
		return false;
	}
	if (mForm.userxm.value == "") {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
		return false;
	}
	if (mForm.password.value == "") {
		$.messager.alert('提示', '请输入密码!', 'warning');
		return false;
	}
	if (mForm.password2.value == "") {
		$.messager.alert('提示', '请输入确认密码!', 'warning');
		return false;
	}
	if (mForm.password.value != mForm.password2.value) {
		$.messager.alert('提示', '两次输入的密码不一致，请重新输入!', 'warning');
		mForm.password.value = "";
		mForm.password2.value = "";
		return false;
	}
	if (mForm.usetype.value == "") {
		$.messager.alert('提示', '请输入用户类型!', 'warning');
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
				type : "POST", // 设置请求类型为"POST"，默认为"GET"
				success : function(message) {				
					var message = eval("(" + message + ")");
					if (message.success == true) {
						$.messager.alert('add-success', '添加信息成功!', 'info',
								function() {
									$('#tList').datagrid( {
										url : 'queryuser.action',
										loadMsg : '更新数据中......'
									});
									displayMsg();
								});
						return;
					} else {
						$.messager.alert('提示', message.info, 'warning');
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
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
//查看
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
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
function validateCheckedit() {
	if (mForm.username.value == "") {
		$.messager.alert('提示', '请输入用户名!', 'warning');
		return false;
	}
	if (mForm.userxm.value == "") {
		$.messager.alert('提示', '请输入用户姓名!', 'warning');
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
				type : "POST", // 设置请求类型为"POST"，默认为"GET"
				success : function(message) {
					var message = eval("(" + message + ")");
					if (message.success == true) {
						$.messager.alert('edit-success', '修改信息成功!', 'info',
								function() {
									$('#tList').datagrid( {
										url : 'queryuser.action',
										loadMsg : '更新数据中......'
									});
									displayMsg();
								});
						return;
					} else {
						$.messager.alert('提示', message.info, 'warning');
						return;
					}
				}
			});

}
function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds == "" || selecteds.length <= 0) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	} else {
		$.messager.confirm('提示', '确认删除么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
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
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList').datagrid('clearSelections');
				$('#tList').datagrid( {
					url : 'queryuser.action',
					loadMsg : '更新数据中......'
				});
			}

			});
		}
	}	);
	}
}

var userid;
//角色权限
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
			loadMsg : '数据装载中......',
			idField : 'id',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck2',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '角色名称',
				field : 'rolename',
				width : '200',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_role').window('open');
					$('#mForm_role').show();
					$('#mForm_role').form('clear');
					$('#mForm_role').appendTo('#aa_role');
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : del_role
			} ]

		});
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'info');
	}
	displayMsg_role();
}

function displayMsg_role() {
	$('#tList_role').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
function validateCheck_role() {
	if (mForm_role.roleid.value == "") {
		$.messager.alert('提示', '请输入权限编码!', 'warning');
		return false;
	}
	return true;
}
/*
 * 添加操作
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
												'添加信息成功!!!',
												'info',
												function() {
													$('#tList_role')
															.datagrid(
																	{
																		url : 'queryuserrole.action?userid=' + userid,
																		loadMsg : '更新数据中......'
																	});
													displayMsg();
												});
								return;
							} else {
								$.messager.alert('提示', message.info, 'warning');
								return;
							}
						}
					});

}

///*
// * 获取选择的列
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
//		$.messager.alert('提示', '请选择一行数据!', 'info');
//	}
//}

/*
 * 删除操作
 */
function del_role() {
	var selecteds = $('#tList_role').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('提示', '确认删除么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号	

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
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList_role').datagrid('clearSelections');
				$('#tList_role').datagrid( {
					url : 'queryuserrole.action?userid=' + userid,
					loadMsg : '更新数据中......'
				});
			}

			});
		}
	}	);
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}

/*
 * 关闭新增窗口
 */
function close_role() {
	$('#add_role').window('close');
	$('#tList_role').datagrid('clearSelections');
}
///*
// * 关闭编辑窗口
// */
//function close2_role() {
//	$('#edit_permission').window('close');
//}
