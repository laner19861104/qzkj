
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
		loadMsg : '����װ����......',
		sortName : 'dwbh',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '��ҵ���',
			field : 'dwbh',
			width : '100',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��ҵ����',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true
		} ] ],
		columns : [ [ {
			title : '��������',
			field : 'cnssqy',
			width : '100',
			align : 'left'
		},{
			title : '��ҵ����(��׼)',
			field : 'cnhyfl',
			width : '200',
			align : 'left'
		},{
			title : '��ҵ����(��ͳ)',
			field : 'cnxxtype',
			width : '200',
			align : 'left'
		}, {
			title : '��ҵ����',
			field : 'cnzdlb',
			width : '200',
			align : 'left'
		}, {
			title : '��ҵ����',
			field : 'cndwlx',
			width : '150',
			align : 'left'
		}, {
			title : '��ҵ��ģ',
			field : 'cntype',
			width : '100',
			align : 'left'
		}, {
			title : '����ͳ��',
			field : 'cnzdlx',
			width : '100',
			align : 'left'
		}, {
			title : '����ϵͳ',
			field : 'cnflag',
			width : '150',
			align : 'left'
		}, {
			title : '��ҵ����',
			field : 'pxnum',
			width : '100',
			align : 'left'
		}, {
			title : '��ϸ��ַ',
			field : 'xxdz',
			width : '240',
			align : 'left'
		}, {
			title : '��������',
			field : 'yzbm',
			width : '100',
			align : 'left'
		}, {
			title : '���˴���',
			field : 'frdb',
			width : '100',
			align : 'left'
		}, {
			title : 'ע������',
			field : 'zcrq',
			width : '120',
			align : 'left'
		}, {
			title : 'ע���ʱ�����Ԫ��',
			field : 'zczj',
			width : '100',
			align : 'right'
		}, {
			title : '��������',
			field : 'email',
			width : '150',
			align : 'left'
		}, {
			title : '�ܺķ�Χ',
			field : 'cnnhfw',
			width : '150',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,
		toolbar : [ {
			text : '���',
			iconCls : 'icon-add',
			handler : function() {
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
				$('#add').window('open');
				$('#mForm').show();
			}
		}, '-', {
			text : '�޸�',
			iconCls : 'icon-edit',
			handler : getSelect
		}, '-', {
			text : 'ɾ��',
			iconCls : 'icon-remove',
			handler : del
		}, '-', {
			text : '��ѯ',
			iconCls : 'icon-search',
			handler : function() {
				$('#query').window('open');
				$('#qForm').form('clear');
			}
		}, '-', {
			text : '����',
			iconCls : 'icon-back',
			handler : goback
		} ]
	});
	displayMsg('tlist');
	/*
	 * �������ڿؼ��ĸ�ʽYYYY-MM-DD
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
 * ���
 */
function add() {

	$('#mForm').form('submit', {
		url : 'modify_addEnterprise_add.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
		success : function(message) {
			
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
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
 * �޸�
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
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
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
		$.messager.alert('warning', '��ѡ��һ������', 'info');
	}
}
/*
 * ɾ�� 
 */
function del() {
	var selecteds = $('#tlist').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('warning', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
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
						$.messager.alert('��Ϣ����', msg.info, 'info');
					} else {
						$.messager.alert('��Ϣ����', msg.info, 'info');
						return;
					}
				}
			});
			$('#tlist').datagrid('reload');
			displayMsg('tlist');
		}
	}	);
	} else {
		$.messager.alert('warning', '��ѡ��һ������', 'warning');
	}
}

/*
 * ��ѯ
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
