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
		loadMsg : '数据装载中......',
		idField : 'resourceid',
		treeField : 'resourceno',
		sortName : 'resourceno',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '资源编码',
			field : 'resourceno',
			width : '100',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '资源名称',
			field : 'resourcename',
			width : '200',
			align : 'left'
		}, {
			title : '资源类型',
			field : 'cnresourcetype',
			width : '200',
			align : 'left'
		} ] ],

		columns : [ [ {
			title : '父资源编码',
			field : 'presourceno',
			width : '100',
			align : 'left'
		}

		] ],
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
			text : '修改',
			iconCls : 'icon-edit',
			handler : getSelect
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '查询',
			iconCls : 'icon-search',
			handler : function() {
				$('#query').window('open');

			}
		}, '-', {
			text : '返回',
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
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整   
}
function displayMsg() {

	//   $('#tList').datagrid('getPager').pagination({displayMsg:'当前显示从{from}到{to}共{total}记录'});
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

function validateCheck() {
	if (mForm.resourceno.value == "") {
		$.messager.alert('提示', '请输入资源编码!', 'warning');
		return false;
	}
	if (!loginCheck(mForm.resourceno.value)) {
		$.messager.alert('提示', '输入资源编码不合法，请重新输入!', 'warning');
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
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryresource.action',
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
		$.messager.alert('提示', '请选择一行数据!', 'warning');
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
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'queryresource.action',
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

/*
 * 删除操作
 */
function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('提示', '确认删除么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
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
						$.messager.alert('提示', message.info, 'info');
						return;
					}
					$.messager.alert('del-success', '删除信息成功!', 'info');
					$('#tList').datagrid('clearSelections');
					$('#tList').datagrid( {
						url : 'queryresource.action',
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

function query() {
	var queryParams = $('#tList').datagrid('options').queryParams;
	if ($('#qresourcename').val() != ""
			&& !descCheck($('#qresourcename').val())) {
		$.messager.alert('提示', '输入资源名称不合法，请重新输入!', 'warning');
		return;
	}
	queryParams.qresourcename = encodeURIComponent(encodeURIComponent($(
			'#qresourcename').val()));
	$('#tList').datagrid( {
		url : 'queryresource.action',
		loadMsg : '更新数据中......'
	});
	displayMsg();
	$('#query').window('close');
	$('#tList').datagrid('clearSelections');
}
