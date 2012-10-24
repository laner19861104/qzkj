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
		url : 'query_querySubjectAction_query.action',
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
		columns : [ [] ],
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
function showedit() {
	
}
function showquery() {}
function view() {}
function add() {
	if (!validateCheck()) {return;}
	$('#mForm').form('submit', {
		url : 'modify_editSubjectAction_add.action',
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
function edit() {}
function del() {}

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