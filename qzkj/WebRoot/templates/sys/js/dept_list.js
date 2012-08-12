/************************************************************
 * js名：dept_list.js
 *
 * 类别：js
 * 功能：详情、新增、修改、删除、查询。
 * 
 *   Ver     変更日     权限      担当者    変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2011-9-30  CFIT-PM   赵胜运      初版
 *
 * Copyright (c) 2011 CFIT-Weifang Company All Rights Reserved.
 ************************************************************/
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
		url : 'querydept.action',
		loadMsg : '数据装载中......',
		idField : 'deptid',
		sortName : 'deptno',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '机构编码',
			field : 'deptno',
			width : '100',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '机构名称',
			field : 'deptname',
			width : '250',
			align : 'left'
		}, {
			title : '组织机构代码',
			field : 'res12',
			width : '100',
			align : 'left'
		}, {
			title : '机构类型',
			field : 'cndepttype',
			width : '150',
			align : 'left'
		}, {
			title : '机构类别',
			field : 'cndeptlevel',
			width : '100',
			align : 'left'
		} ] ],

		columns : [ [ {
			title : '电    话',
			field : 'telno',
			width : '100',
			align : 'left'
		}, {
			title : '传    真',
			field : 'faxno',
			width : '100',
			align : 'left'
		}, {
			title : '联系人',
			field : 'relap',
			width : '100',
			align : 'left'
		}, {
			title : '联系人电话',
			field : 'relaptelno',
			width : '100',
			align : 'left'
		}, {
			title : '负责人',
			field : 'chargep',
			width : '100',
			align : 'left'
		}, {
			title : '负责人电话',
			field : 'chargeptelno',
			width : '100',
			align : 'left'
		}, {
			title : '邮编',
			field : 'res01',
			width : '100',
			align : 'left'
		}, {
			title : '地址',
			field : 'res02',
			width : '200',
			align : 'left'
		}, {
			title : '注册日期',
			field : 'res03',
			width : '100',
			align : 'left'
		}, {
			title : '注册资本',
			field : 'res05',
			width : '100',
			align : 'right'
		}, {
			title : '企业网址',
			field : 'res04',
			width : '150',
			align : 'left'
		}, {
			title : '企业邮箱',
			field : 'res11',
			width : '150',
			align : 'left'
		}

		] ],
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
	$('#res03').datebox(
			{
				formatter : function(date) {
					return date.getFullYear()
							+ '-'
							+ (date.getMonth() + 1)
							+ '-'
							+ (date.getDate() <= 9 ? '0' + date.getDate()
									: date.getDate());
				},
				parser : function(date) {
					return new Date(Date.parse(date.replace(/-/g, "/")));
				}
			});
});
/*
 * 返回
 */
function goback() {
	window.location = "gohome.action";
}
/*
 *调整页面宽度
 */
function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
/*
 *调整页面高度
 */
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整   
}
/*
 *分页显示中文
 */
function displayMsg() {
	$('#tList').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
/*
 *添加页面关闭
 */
function close1() {
	$('#add').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *修改页面关闭
 */
function close2() {
	$('#edit').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *详情页面关闭
 */
function close3() {
	$('#view').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *输入字段的有效性校验
 */
function validateCheck() {
	if (mForm.deptno.value == "") {
		$.messager.alert('提示', '请输入机构编码!', 'warning');
		return false;
	}
	if (!loginCheck(mForm.deptno.value)) {
		$.messager.alert('提示', '输入机构编码不合法，请重新输入!', 'warning');
		return false;
	}
	if (((mForm.deptno.value).length) % 2 != 0) {
		$.messager.alert('提示', '输入机构编码必须为偶数，请重新输入!', 'warning');
		return false;
	}
	if (mForm.depttype.value == "") {
		$.messager.alert('提示', '请选择机构类型!', 'warning');
		return false;
	}
	if (mForm.deptlevel.value == "") {
		$.messager.alert('提示', '请选择机构类别!', 'warning');
		return false;
	}
	return true;
}
/*
 *添加操作
 */
function add() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'adddept.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydept.action',
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
/*
 *获取列表中的单条记录
 */
var id;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#edit').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#ee');
		$('#deptno').val(select[0].deptno);
		$('#deptname').val(select[0].deptname);
		$('#depttype').val(select[0].depttype);
		$('#deptlevel').val(select[0].deptlevel);
		$('#telno').val(select[0].telno);
		$('#faxno').val(select[0].faxno);
		$('#chargep').val(select[0].chargep);
		$('#chargeptelno').val(select[0].chargeptelno);
		$('#relap').val(select[0].relap);
		$('#relaptelno').val(select[0].relaptelno);
		$('#res01').val(select[0].res01);
		$('#res02').val(select[0].res02);
		$('#res03').val(select[0].res03);
		$('#res04').val(select[0].res04);
		$('#res05').val(select[0].res05);
		$('#res11').val(select[0].res11);
		$('#res12').val(select[0].res12);
		id = select[0].deptid;
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
/*
 * 详情
 */
function getView() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length == 1) {
		$('#view').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#dd');
		$('#deptno').val(select[0].deptno);
		$('#deptname').val(select[0].deptname);
		$('#depttype').val(select[0].depttype);
		$('#deptlevel').val(select[0].deptlevel);
		$('#telno').val(select[0].telno);
		$('#faxno').val(select[0].faxno);
		$('#chargep').val(select[0].chargep);
		$('#chargeptelno').val(select[0].chargeptelno);
		$('#relap').val(select[0].relap);
		$('#relaptelno').val(select[0].relaptelno);
		$('#res01').val(select[0].res01);
		$('#res02').val(select[0].res02);
		$('#res03').val(select[0].res03);
		$('#res04').val(select[0].res04);
		$('#res05').val(select[0].res05);
		$('#res11').val(select[0].res11);
		$('#res12').val(select[0].res12);
		id = select[0].deptid;
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
/*
 *修改操作
 */
function edit() {
	if (!validateCheck())
		return;
	$('#mForm').form('submit', {
		url : 'editdept.action?deptid=' + id,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydept.action',
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
				id = selected.deptid;
				if (ids == "")
					ids = id;
				else
					ids = ids + "," + id;
			}
			$.ajax( {
				type : "POST",
				url : "deldept.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
					//var message = eval("(" + message + ")");
				if (message.success == false) {
					$.messager.alert('提示', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', '删除信息成功!', 'info');
				$('#tList').datagrid('clearSelections');
				$('#tList').datagrid( {
					url : 'querydept.action',
					loadMsg : '更新数据中......'
				});
			},
			error : function() {
				$.messager.alert('del-failure', '异步执行错误!', 'warning');
			}
			});
		}
	}	);
	} else {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
	}
}
/*
 * 查询操作
 */
function query() {
	var queryParams = $('#tList').datagrid('options').queryParams;
	if ($('#qdeptno').val() != "" && !loginCheck($('#qdeptno').val())) {
		$.messager.alert('提示', '输入机构编码不合法，请重新输入!', 'warning');
		return;
	}
	if ($('#qdeptname').val() != "" && !descCheck($('#qdeptname').val())) {
		$.messager.alert('提示', '输入机构名称不合法，请重新输入!', 'warning');
		return;
	}
	queryParams.qdeptno = $('#qdeptno').val();
	queryParams.qdeptname = encodeURIComponent(encodeURIComponent($(
			'#qdeptname').val()));
	queryParams.qdepttype = $('#qdepttype').val();
	queryParams.qdeptlevel = $('#qdeptlevel').val();
	$('#tList').datagrid( {
		url : 'querydept.action',
		loadMsg : '更新数据中......'
	});
	displayMsg();
	$('#query').window('close');
}
