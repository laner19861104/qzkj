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
		loadMsg : '数据装载中......',
		idField : 'roleid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '角色名称',
			field : 'rolename',
			width : '150',
			align : 'left',
			sortable : true
		}, {
			title : '角色类型',
			field : 'cntype',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		} ] ],
		columns : [ [ {
			title : '机构名称',
			field : 'deptname',
			width : '250',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '机构代码',
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
			text : '详情',
			iconCls : 'icon-view',
			handler : getView
		}, '-', {
			text : '添加',
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
			text : '修改',
			iconCls : 'icon-edit',
			handler : getSelect
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '对应权限',
			iconCls : 'icon-relation_1',
			handler : getRolepermission
		}, '-', {
			text : '返回',
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
			width : '100',
			align : 'left'
		}, {
			title : '权限编码',
			field : 'permissionno',
			width : '100',
			align : 'left'
		}, {
			title : '权限名称',
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

function validateCheck() {
	if (mForm.rolename.value == "") {
		$.messager.alert('提示', '请输入角色名称!', 'warning');
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
				type : "POST", // 设置请求类型为"POST"，默认为"GET"
				success : function(message) {
					var message = eval("(" + message + ")");
					if (message.success == true) {
						$.messager.alert('add-success', '添加信息成功!', 'info',
								function() {
									$('#tList').datagrid( {
										url : 'queryrole.action',
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
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
//查看
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
		$.messager.alert('提示', '请选择一行数据!', 'warning');
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
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryrole.action',
						loadMsg : '更新数据中......'
					});
					close2();
					displayMsg();
				});
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
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList').datagrid('clearSelections');
				$('#tList').datagrid( {
					url : 'queryrole.action',
					loadMsg : '更新数据中......'
				});
			}

			});
		}
	}	);
	}
}

//角色权限
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
				width : '100',
				align : 'left'
			}, {
				title : '权限编码',
				field : 'permissionno',
				width : '100',
				align : 'left'
			}, {
				title : '权限名称',
				field : 'permissionname',
				width : '200',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_permission').window('open');
					$('#mForm_permission').show();
					$('#mForm_permission').form('clear');
					$('#mForm_permission').appendTo('#aa_permission');
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : del_permission
			} ]

		});
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'info');
	}
	displayMsg_permission();
}

function displayMsg_permission() {
	$('#tList_permission').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
function validateCheck_permission() {
	if (mForm_permission.permissionid.value == "") {
		$.messager.alert('提示', '请选择权限编码!', 'info');
		return false;
	}
	return true;
}
/*
 * 添加操作
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
												'添加信息成功!!!',
												'info',
												function() {
													$('#tList_permission')
															.datagrid(
																	{
																		url : 'queryrolepermission.action?roleid=' + roleid,
																		loadMsg : '更新数据中......'
																	});
													displayMsg();
												});
								return;
							} else {
								$.messager.alert('提示', message.info,
										'warning');
								return;
							}
						}
					});

}

/*
 * 获取选择的列
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
		$.messager.alert('提示', '请选择一行数据', 'info');
	}
}

/*
 * 删除操作
 */
function del_permission() {
	var selecteds = $('#tList_permission').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('提示', '确认删除么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号	

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
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList_permission').datagrid('clearSelections');
				$('#tList_permission').datagrid( {
					url : 'queryrolepermission.action?roleid=' + roleid,
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
function close1_permission() {
	$('#add_permission').window('close');
	$('#tList_permission').datagrid('clearSelections');
}
/*
 * 关闭编辑窗口
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