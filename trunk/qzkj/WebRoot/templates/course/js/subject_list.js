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
		loadMsg : '数据装载中......',
		idField : 'id',
		sortName : 'code',
		sortOrder : 'asc',
		rownumbers:true,	
		remoteSort : false,
		showFooter : true,
		
		frozenColumns : [ [ 
		{field : 'ck', checkbox : true}, 
		{title : '科目编号', field : 'code', width:200, align:'left', sortable:true},
		{title : '科目名称', field : 'name', width:200, align:'left', sortable:true},
		{title : '价格',	field : 'cnres01', width : 200,	align:'right', sortable:true}
		] ],
		pagination : true,
		rownumbers : true,
		toolbar : gettoolbar()
	});
	displayMsg();
});

function gettoolbar() {
	return [ {
		text : '详情',
		iconCls : 'icon-view',
		handler : view
	}, '-', {
		text : '添加',
		iconCls : 'icon-add',
		handler : showadd
	}, '-', {
		text : '修改',
		iconCls : 'icon-edit',
		handler : showedit
	}, '-', {
		text : '删除',
		iconCls : 'icon-remove',
		handler : del
	}, '-', {
		text : '查询',
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
		type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(msg) {
			var message = eval("(" + msg + ")");
			if (message.success == true) {
				$.messager.alert('提示', '添加信息成功!', 'info', function() {
					$('#tList').datagrid('reload');
					displayMsg();
				});
				$('#mForm').form('clear');
				return;
			} else {
				$.messager.alert('警告', message.info, 'warning');
				return;
			}
		}
	});
}
var id;
function showedit() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('警告', '请选择一行数据!', 'warning');
		return;
	}
	id = select[0].id;
	jQuery.getJSON(urls['get'], {id:id}, function(obj) {
			fillForm(obj);
		}
	);
	$('#mForm').show();
	$('#mForm').appendTo('#ee');
	$('#edit').window('open');
}
function edit() {
	if (!validateCheck()) {return;}
	
	$('#mForm').form('submit', {
		url : urls['edit']+"?id="+id,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(msg) {
			var message = eval("(" + msg + ")");
			if (message.success == true) {
				$('#edit').window('close');
				$.messager.alert('提示', '修改信息成功!', 'info', function() {
					$('#tList').datagrid('reload');
					displayMsg();
				});
				$('#mForm').form('clear');
				return;
			} else {
				$.messager.alert('警告', message.info, 'warning');
				return;
			}
		}
	});
}
function view() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('警告', '请选择一行数据!', 'warning');
		return;
	}
	id = select[0].id;
	jQuery.getJSON(urls['get'], {id:id}, function(obj) {
			fillForm(obj);
		}
	);
	$('#mForm').show();
	$('#mForm').appendTo('#dd');
	$('#view').window('open');
}
function del() {
	var ids;
	var selects = $('#tList').datagrid('getSelections');
	if (null == selects || 0 == selects.length) {
		$.messager.alert('警告', '请选择要删除的数据!', 'warning');
		return;
	}
	$.messager.confirm('提示', '确认删除么?', function(flag) {
		if (flag) {
			ids = selects[0].id;
			for (var i = 1; i < selects.length; i++) {
				ids = ids + ',' + selects[i].id;
			}
			$.ajax( {
				type : "POST",
				url : urls['del'],
				data : "ids=" + ids,
				dataType : "json",
				success : function callback(message) {
					if (message.success == false) {
						$.messager.alert('提示', message.info, 'info');
						return;
					}
					$.messager.alert('提示', '删除信息成功!', 'info');
					$('#tList').datagrid('clearSelections');
					$('#tList').datagrid('reload');
				},
				error : function() {
					$.messager.alert('警告', '异步执行错误!', 'warning');
				}
			});
		}
	});
}
function showquery() {
	$('#query').window('open');
}
function query() {
	var queryParams = $('#tList').datagrid('options').queryParams;
	queryParams.conditions = getCondition();
	$('#tList').datagrid('reload');
}
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
		$.messager.alert('警告', '请填写科目编号!', 'warning');
		return false;
	}
	if (null == $('#name').val() || "" == $('#name').val()) {
		$.messager.alert('警告', '请填写科目名称!', 'warning');
		return false;
	}
	if (null == $('#cost').val() || "" == $('#cost').val()) {
		$.messager.alert('警告', '请填写科目价格!', 'warning');
		return false;
	}
	return true;
}