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
		url : 'querydmlb.action',
		loadMsg : '数据装载中......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '类别名称',
			field : 'lbmc',
			width : '150',
			align : 'left',
			sortable : true
		}, {
			title : '类别编号',
			field : 'lbbh',
			width : '150',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$('#add').window('open');
				$('#mForm').show();
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		}, {
			text : '对应字典',
			iconCls : 'icon-relation_1',
			handler : getDmzd
		}, '-', {
			text : '返回',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg();

	$('#tList_dmzd').datagrid( {
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
		}, {
			title : '字典编号',
			field : 'bh',
			width : '100',
			align : 'left'
		}, {
			title : '字典名称',
			field : 'mc',
			width : '150',
			align : 'left'
		} ] ],
		columns : [ [ {
			title : '字典类别',
			field : 'className',
			width : '150',
			align : 'left'
		}, {
			title : '启用状态',
			field : 'cnstartmark',
			width : '100',
			align : 'left'
		}, {
			title : '使用权限',
			field : 'ssxt',
			width : '100',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : []

	});
	displayMsg_dmzd();
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
	$('#query').window('close');
	$('#tList').datagrid('clearSelections');
}

function validateCheck() {
	if (mForm.lbbh.value == "") {
		$.messager.alert('提示', '请输入类别编号!', 'warning');
		return false;
	}
	if (mForm.lbmc.value == "") {
		$.messager.alert('提示', '请输入类别名称!', 'warning');
		return false;
	}
	return true;
}

function add() {
	if (!validateCheck())
		return;
	$('#mForm').form('submit', {
		url : 'adddmlb.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydmlb.action',
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
				id = selected.id;
				if (ids == "")
					ids = "'" + id + "'";
				else
					ids = ids + "," + "'" + id + "'";
			}
			$.ajax( {
				type : "POST",
				url : "deldmlb.action",
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
					url : 'querydmlb.action',
					loadMsg : '更新数据中......'
				});
			}

			});
		}
	}	);
	}
}

var lbbh;
//字典字典
function getDmzd() {

	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		lbbh = select[0].lbbh;
		$('#tList_dmzd').datagrid( {
			iconCls : 'icon-save',
			width : "100%",
			height : fixHeight(0.95),
			pageList : [ 15, 30, 45, 60 ],
			nowrap : false,
			striped : true,
			collapsible : true,
			url : 'querydmzd.action?lbbh=' + lbbh,
			loadMsg : '数据装载中......',
			idField : 'id',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck2',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '字典编号',
				field : 'bh',
				width : '100',
				align : 'left'
			}, {
				title : '字典名称',
				field : 'mc',
				width : '150',
				align : 'left'
			}, {
				title : '字典类别',
				field : 'className',
				width : '150',
				align : 'left'
			}, {
				title : '启用状态',
				field : 'cnstartmark',
				width : '100',
				align : 'left'
			}, {
				title : '使用权限',
				field : 'ssxt',
				width : '100',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_dmzd').window('open');
					$('#mForm_dmzd').show();
					$('#mForm_dmzd').form('clear');
					$('#mForm_dmzd').appendTo('#aa_dmzd');
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : getSelect_dmzd
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : del_dmzd
			} ]

		});
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'info');
	}
	displayMsg_dmzd();
}

function displayMsg_dmzd() {
	$('#tList_dmzd').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
function validateCheck_dmzd() {
	if (mForm_dmzd.bh.value == "") {
		$.messager.alert('提示', '请输入字典编号!', 'warning');
		return false;
	}
	if (mForm_dmzd.mc.value == "") {
		$.messager.alert('提示', '请输入字典名称!', 'warning');
		return false;
	}
	return true;
}
/*
 * 添加操作
 */
function add_dmzd() {
	if (!validateCheck_dmzd())
		return;
	$('#mForm_dmzd').form('submit', {
		url : 'adddmzd.action?lbbh=' + lbbh,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tList_dmzd').datagrid( {
						url : 'querydmzd.action?lbbh=' + lbbh,
						loadMsg : '更新数据中......'
					});
					displayMsg_dmzd();
				});
				return;
			} else {
				$.messager.alert('提示', message.info, 'warning');
				return;
			}
		}
	});
}

/*
 * 获取选择的列
 */
var id_dmzd;
function getSelect_dmzd() {
	var select = $('#tList_dmzd').datagrid('getSelections');
	if (select.length == 1) {
		$('#edit_dmzd').window('open');
		$('#mForm_dmzd').show();
		$('#mForm_dmzd').appendTo('#ee_dmzd');
		$('#bh').val(select[0].bh);
		$('#mc').val(select[0].mc);
		$('#sjbh').val(select[0].sjbh);
		$('#startmark').val(select[0].startmark);
		$('#ssxt').val(select[0].ssxt);

		id_dmzd = select[0].id;
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'info');
	}
}
function edit_dmzd() {
	if (!validateCheck_dmzd())
		return;

	$('#mForm_dmzd').form('submit', {
		url : 'editdmzd.action?id=' + id_dmzd + '&lbbh=' + lbbh,
		onSubmit : function() {
			return $('#mForm_dmzd').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
					$('#tList_dmzd').datagrid( {
						url : 'querydmzd.action?lbbh=' + lbbh,
						loadMsg : '更新数据中......'
					});
					close2_dmzd();
					displayMsg_dmzd();
				});
			} else {
				$.messager.alert('提示', message.info, 'warning');
				return;
			}

		}
	});

}
/*
 * 删除操作
 */
function del_dmzd() {
	var selecteds = $('#tList_dmzd').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('提示', '确认删除么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
				id = selected.id;
				if (ids == "")
					ids = id;
				else
					ids = ids + "," + id;
			}
			$.ajax( {
				type : "POST",
				url : "deldmzd.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
					//					var message = eval("(" + message + ")");
				if (message.success == false) {
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList_dmzd').datagrid('clearSelections');
				$('#tList_dmzd').datagrid( {
					url : 'querydmzd.action?lbbh=' + lbbh,
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
function close1_dmzd() {
	$('#add_dmzd').window('close');
}
/*
 * 关闭编辑窗口
 */
function close2_dmzd() {
	$('#edit_dmzd').window('close');
}
