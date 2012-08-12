
$(function() {
	$('#mForm').hide();
	$('#jnlForm').hide();
	$('#tlist').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.95),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'query_queryEnterpriseAction_query.action',
		loadMsg : '数据装载中......',
		sortName : 'dwbh',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '企业编号',
			field : 'dwbh',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '企业名称',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true
		} ] ],
		columns : [ [ {
			title : '所属区域',
			field : 'cnssqy',
			width : '100',
			align : 'left'
		},{
			title : '行业分类(标准)',
			field : 'cnhyfl',
			width : '200',
			align : 'left'
		},{
			title : '行业分类(传统)',
			field : 'cnxxtype',
			width : '200',
			align : 'left'
		}, {
			title : '企业类型',
			field : 'cnzdlb',
			width : '200',
			align : 'left'
		}, {
			title : '企业性质',
			field : 'cndwlx',
			width : '150',
			align : 'left'
		}, {
			title : '企业规模',
			field : 'cntype',
			width : '100',
			align : 'left'
		}, {
			title : '纳入统计',
			field : 'cnzdlx',
			width : '100',
			align : 'left'
		}, {
			title : '所属系统',
			field : 'cnflag',
			width : '150',
			align : 'left'
		}, {
			title : '企业排序',
			field : 'pxnum',
			width : '100',
			align : 'left'
		}, {
			title : '详细地址',
			field : 'xxdz',
			width : '240',
			align : 'left'
		}, {
			title : '邮政编码',
			field : 'yzbm',
			width : '100',
			align : 'left'
		}, {
			title : '法人代表',
			field : 'frdb',
			width : '100',
			align : 'left'
		}, {
			title : '注册日期',
			field : 'zcrq',
			width : '120',
			align : 'left'
		}, {
			title : '注册资本（万元）',
			field : 'zczj',
			width : '100',
			align : 'right'
		}, {
			title : '电子邮箱',
			field : 'email',
			width : '150',
			align : 'left'
		}, {
			title : '能耗范围',
			field : 'cnnhfw',
			width : '150',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
				$('#add').window('open');
				$('#mForm').show();
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
				$('#qForm').form('clear');
			}
		}, '-', {
			text : '返回',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg('tlist');
	/*
	 * 更改日期控件的格式YYYY-MM-DD
	 * @param {Object} date
	 * @return {TypeName} 
	 */
	$('#zcrq').datebox(
			{
				formatter : function(date) {
					return date.getFullYear()
							+ '-'
							+ ((date.getMonth() + 1)<= 9 ? '0' +(date.getMonth() + 1)
									: (date.getMonth() + 1))
							+ '-'
							+ (date.getDate() <= 9 ? '0' + date.getDate()
									: date.getDate());
				}
			});
});






/*
 * 添加
 */
function add() {

	$('#mForm').form('submit', {
		url : 'modify_addEnterprise_add.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // 设置请求类型为"POST"，默认为"GET"
		success : function(message) {
			
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '添加信息成功!', 'info', function() {
					$('#tlist').datagrid('reload');
					displayMsg('tlist');
				});
				return;
			} else {
				$.messager.alert('warning', message.info, 'warning');
				return;
			}
		}
	});
}
/*
 * 修改
 * @return {TypeName} 
 */
function edit() {
	$('#mForm').form('submit', {
		url : 'modify_editEnterprise_update.action?id=' + id,
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('edit-success', '修改信息成功!', 'info', function() {
					$('#tlist').datagrid('reload');
					closeWin('tlist');
					displayMsg('tlist');
				});
			} else {
				$.messager.alert('warning', message.info, 'warning');
				return;
			}

		}
	});
}

var id;
function getSelect() {
	var select = $('#tlist').datagrid('getSelections');
	if (select.length == 1) {
		$('#mForm').form('clear');
		$('#edit').window('open');
		$('#mForm').show();
		$('#mForm').appendTo('#ee');
		jQuery.post("get_queryEnterpriseAction_getObjById.action?id="+select[0].id, "", function(obj){
			fillForm(obj)
			$('#mForm').form('validate');
		}, "json");
		
	} else {
		$.messager.alert('warning', '请选择一行数据', 'info');
	}
}
/*
 * 删除 
 */
function del() {
	var selecteds = $('#tlist').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('warning', '确认删除么?', function(id) {
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
				url : "modify_editEnterprise_del.action",
				data : "id=" + ids,
				dataType : "json",
				cache : false,
				success : function callback(msg) {
					if (msg.success) {
						$.messager.alert('信息窗口', msg.info, 'info');
					} else {
						$.messager.alert('信息窗口', msg.info, 'info');
						return;
					}
				}
			});
			$('#tlist').datagrid('reload');
			displayMsg('tlist');
		}
	}	);
	} else {
		$.messager.alert('warning', '请选择一行数据', 'warning');
	}
}

/*
 * 查询
 */
function query() {

	var url = "query_queryEnterpriseAction_query.action?"+appCondition();
	$('#tlist').datagrid( {
		url : url
	});
	displayMsg('tlist');
	$('#query').window('close');
}

var dwbh;
