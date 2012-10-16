

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
	"close" : "getLandAllocationbyId.action",
	"open" : "addLandAllocation.action",
});
$(function() {
	$('#mForm').hide();
	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : 'auto',
		height : fixHeight(0.94),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,crDate"), //暂时取json文件中的数据
		loadMsg : '数据装载中......',
		idField : 'uuid',
		remoteSort : false,
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
	displayMsg();
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
function openQuery() {
			$('#query').window('open');


}
/*
 *添加操作
 */
function add() {
	if (!validateCheck()) {
		return;
	}
	$('#mForm').form('submit', {
		url : urls['add'],
		onSubmit : function() {
	},
	type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(message) {

			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tList').datagrid('reload');
					displayMsg('tList');
				});
				return;
			} else {
				$.messager.alert('警告', message.info, 'warning');
				return;
			}
		}
	});

}
/*
 *获取列表中的单条记录
 */
var uuid;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
		return;
	}
	uuid = select[0].uuid;
	jQuery.post(urls['get'] + "?uuid=" + select[0].uuid, "", function(obj) {
		fillForm(obj)
		//$('#mForm').form('validate');
		}, "json");

	$('#edit').window('open');
	$('#mForm').show();
	$('#mForm').appendTo('#ee');

}
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
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
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
/*
 * 删除操作
 */

function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	if(selecteds!=undefined&&selecteds!=null&&selecteds.length!=1){
		$.messager.alert('警告', '请选一条宗地数据进行删除!','warning');
		return;
	}
	var uuid = selecteds[0].uuid;
	
	var selected = selecteds[0];//获取某行的行号
		
		if(selected.state!="01"){
		$.messager.alert('警告','只有草稿状态的宗地才可以删除!','warning');
		return;
	}

	$.messager.confirm('确认',
		'删除操作将删除宗地关联的地类构成、宗地附着物、安置人口信息，确认删除么？', 
		function(r) {
				if(r){
						
					$.ajax( {
						type : "POST",
						url : urls["del"],
						data : "id=" + uuid,
						dataType : "json",
						cache : false,
						success : function callback(msg) {
							if (msg.success) {
								$.messager.alert('提示', msg.info, 'info');
								$('#tList').datagrid('clearSelections');
							} else {
								$.messager.alert('警告', msg.info, 'warning');
								return;
							}
							$('#tList').datagrid('reload');
							displayMsg('tList');
						}
					});
				}else{
					return;
				}
			
		});
	
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


