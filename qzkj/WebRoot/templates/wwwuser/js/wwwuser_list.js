

/************************************************************
 * js名：landLease_list.js
 *
 * 类别：js
 * 功能：详情、新增、修改、删除、查询。
 * 
 *   Ver     変更日     权限      担当者    変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2012-6-12  CFIT-PG   朱江      初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/

var urls = eval( {
	"query" : "querywwwuser.action",
	"stop" : "editwwwuser.action",
	"get":"getwwwuser.action"
});
$(function() {
	$('#mForm').hide();
	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : 'auto',
		height : fixHeight(0.94),
		pageList : [ 15, 30, 45, 60 ],
		singleSelect:true,
		nowrap : false,
		striped : true,
		collapsible : true,
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,crDate"), //暂时取json文件中的数据
		loadMsg : '数据装载中......',
		idField : 'uuid',
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '帐号',
			field : 'account',
			width : '80',
			sortable : true
		}, {
			title : '姓名',
			field : 'username',
			width : '250',
			align : 'left',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '状态',
			field : 'cnstate',
			width : '80',
			align : 'left',
			sortable : true
			
		},{
			title : '性别',
			field : 'sex',
			width : '130',
			align : 'left'
		},{
			title : '账户余额',
			field : 'money',
			width : '130',
			align : 'left'
		},{
			title : '联系电话',
			field : 'tel',
			width : '130',
			align : 'left'
		},{
			title : '身份证号',
			field : 'id',
			width : '130',
			align : 'left'
		},{
			title : 'E-mail',
			field : 'email',
			width : '130',
			align : 'left'
		},{
			title : 'QICQ',
			field : 'qq',
			width : '130',
			align : 'left'
		},{
			title : '密码问题',
			field : 'pwdquestion',
			width : '130',
			align : 'left'
		},{
			title : '出生日期',
			field : 'birthday',
			width : '130',
			align : 'left'
		},{
			title : '地址',
			field : 'address',
			width : '130',
			align : 'left'
		},{
			title : '学历',
			field : 'edulv',
			width : '130',
			align : 'left'
		},{
			title : '工作单位',
			field : 'workFor',
			width : '130',
			align : 'left'
		},{
			title : '工作单位',
			field : 'workFor',
			width : '130',
			align : 'left'
		},{
			title : '通讯地址',
			field : 'postAddress',
			width : '130',
			align : 'left'
		},{
			title : '邮编',
			field : 'postNo',
			width : '130',
			align : 'left'
		}
		]],
		pagination : true,
		rownumbers : true,	
		toolbar : '#tb'
	});
	displayMsg('tList');
	init();
});
function init() {

}
function openAdd() {
			$('#add').window('open');
			$('#mForm').show();
			$('#mForm').form('clear');
			$('#mForm').appendTo('#aa');
		}

/*
 *获取列表中的单条记录
 */
var uuid;

/*
 * 详情
 */
function getView() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
		return;
	}
	jQuery.post(urls['get'] + "?uuid=" + select[0].uuid, "", function(obj) {
		fillForm(obj)
		//$('#mForm').form('validate');
		}, "json");
	$('#view').window('open');
	$('#mForm').show();
	$('#mForm').appendTo('#dd');
}

/*
 *修改操作
 */
function edit() {
	if (!validateCheck()) {
		return;
	}
	$('#mForm').form('submit', {
		url : urls['edit'] + '?uuid=' + uuid,
		onSubmit : function() {
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('启用', '修改信息成功!', 'info', function() {
					closeWin('edit');
					$('#tList').datagrid('reload');
					$('#tList').datagrid('clearSelections');

					displayMsg('tList');
				});
			} else {
				$.messager.alert('警告', message.info, 'warning');
				return;
			}

		}
	});

}
function stop()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('警告', '确认停用么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
				if (ids == "")
					ids = + selecteds[i].uuid ;
				else
					ids = ids + "," + "'" + selecteds[i].uuid + "'";
			}

			$.ajax( {
				type : "POST",
				url : urls["stop"],
				data : "uuid=" + ids+'&state=1',
				dataType : "json",
				cache : false,
				success : function callback(msg) {
					if (msg.success) {
						$.messager.alert('提示', '已停用!', 'info');
					} else {
						$.messager.alert('警告', msg.info, 'warning');
						return;
					}
					$('#tList').datagrid('reload');
					displayMsg('tList');
				}

			});

		}
	}	);
	} else {
		$.messager.alert('警告', '请选择一行数据', 'warning');
	}
}
function openW()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('警告', '确认启用么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
				if (ids == "")
					ids =  selecteds[i].uuid;
				else
					ids = ids + "," + "'" + selecteds[i].uuid + "'";
			}

			$.ajax( {
				type : "POST",
				url : urls["stop"],
				data : "uuid=" + ids+'&state=0',
				dataType : "json",
				cache : false,
				success : function callback(msg) {
					if (msg.success) {
						$.messager.alert('提示', "已启用!", 'info');
					} else {
						$.messager.alert('警告', msg.info, 'warning');
						return;
					}
					$('#tList').datagrid('reload');
					displayMsg('tList');
				}

			});

		}
	}	);
	} else {
		$.messager.alert('警告', '请选择一行数据', 'warning');
	}
}

/*
 * 查询操作
 */
function query() {
	var url =urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,crDate");
	$('#tList').datagrid( {
		url : url
	});
	displayMsg('tList');
	$('#tList').datagrid('clearSelections');
	$('#query').window('close');
}


function openPay()
{
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
		return;
	}
	$('#payList').datagrid({
	    iconCls : 'icon-save',
		width : 'auto',
		height : fixHeight(0.94),
		pageList : [ 15, 30, 45, 60 ],
		sigleSelect:true,
		nowrap : false,
		striped : true,
		collapsible : true,
		url : "queryPayRecord.action?"+appCondition("[id^='p_']","$userAccount|"+select[0].account+"$orderby|payDate|desc"), //暂时取json文件中的数据
		loadMsg : '数据装载中......',
		idField : 'uuid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '充值金额',
			field : 'money',
			width : '80',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '充值日期',
			field : 'payDate',
			width : '250',
			align : 'left',
			sortable : true
		}
		]],
		pagination : true,
		rownumbers : true
	});
	displayMsg('payList');
	
	$('#pay').window('open');
}

function openCon()
{
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
		return;
	}
	$('#conList').datagrid({
	    iconCls : 'icon-save',
		width : 'auto',
		height : fixHeight(0.94),
		pageList : [ 15, 30, 45, 60 ],
		sigleSelect:true,
		nowrap : false,
		striped : true,
		collapsible : true,
		url : "queryConsumptionRecord.action?"+appCondition("[id^='p_']","$userAccount|"+select[0].account+"$orderby|conDate|desc"), //暂时取json文件中的数据
		loadMsg : '数据装载中......',
		idField : 'uuid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '消费金额',
			field : 'money',
			width : '80',
			align:'right',
			sortable : true
		}]  ],

		columns : [ [{
			title : '购买日期',
			field : 'payDate',
			width : '250',
			align : 'left',
			sortable : true
		},{
			title : '商品名称',
			field : 'payDate',
			width : '250',
			align : 'left',
			sortable : true
		}
		]],
		pagination : true,
		rownumbers : true
	});
	displayMsg('conList');
	
	$('#consumption').window('open');
}
