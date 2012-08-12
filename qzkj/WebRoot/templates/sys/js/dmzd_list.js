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
		loadMsg : '����װ����......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '�������',
			field : 'lbmc',
			width : '150',
			align : 'left',
			sortable : true
		}, {
			title : '�����',
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
			text : '���',
			iconCls : 'icon-add',
			handler : function() {
				$('#add').window('open');
				$('#mForm').show();
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
			}
		}, '-', {
			text : 'ɾ��',
			iconCls : 'icon-remove',
			handler : del
		}, {
			text : '��Ӧ�ֵ�',
			iconCls : 'icon-relation_1',
			handler : getDmzd
		}, '-', {
			text : '����',
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
		loadMsg : '����װ����......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck2',
			checkbox : true
		}, {
			title : '�ֵ���',
			field : 'bh',
			width : '100',
			align : 'left'
		}, {
			title : '�ֵ�����',
			field : 'mc',
			width : '150',
			align : 'left'
		} ] ],
		columns : [ [ {
			title : '�ֵ����',
			field : 'className',
			width : '150',
			align : 'left'
		}, {
			title : '����״̬',
			field : 'cnstartmark',
			width : '100',
			align : 'left'
		}, {
			title : 'ʹ��Ȩ��',
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
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ�������   
}
function displayMsg() {
	$('#tList').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
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
		$.messager.alert('��ʾ', '�����������!', 'warning');
		return false;
	}
	if (mForm.lbmc.value == "") {
		$.messager.alert('��ʾ', '�������������!', 'warning');
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
		type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydmlb.action',
						loadMsg : '����������......'
					});
					displayMsg();
				});
				return;
			} else {
				$.messager.alert('��ʾ', message.info, 'warning');
				return;
			}
		}
	});

}
function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds == "" || selecteds.length <= 0) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	} else {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
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
				url : "deldmlb.action",
				data : "id=" + ids,
				dataType : "json",
				success : function callback(message) {
					//					var message = eval("(" + message + ")");
				if (message.success == false) {
					$.messager.alert('��ʾ', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
				$('#tList').datagrid('clearSelections');
				$('#tList').datagrid( {
					url : 'querydmlb.action',
					loadMsg : '����������......'
				});
			}

			});
		}
	}	);
	}
}

var lbbh;
//�ֵ��ֵ�
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
			loadMsg : '����װ����......',
			idField : 'id',
			remoteSort : false,
			frozenColumns : [ [ {
				field : 'ck2',
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '�ֵ���',
				field : 'bh',
				width : '100',
				align : 'left'
			}, {
				title : '�ֵ�����',
				field : 'mc',
				width : '150',
				align : 'left'
			}, {
				title : '�ֵ����',
				field : 'className',
				width : '150',
				align : 'left'
			}, {
				title : '����״̬',
				field : 'cnstartmark',
				width : '100',
				align : 'left'
			}, {
				title : 'ʹ��Ȩ��',
				field : 'ssxt',
				width : '100',
				align : 'left'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				text : '���',
				iconCls : 'icon-add',
				handler : function() {
					$('#add_dmzd').window('open');
					$('#mForm_dmzd').show();
					$('#mForm_dmzd').form('clear');
					$('#mForm_dmzd').appendTo('#aa_dmzd');
				}
			}, '-', {
				text : '�޸�',
				iconCls : 'icon-edit',
				handler : getSelect_dmzd
			}, '-', {
				text : 'ɾ��',
				iconCls : 'icon-remove',
				handler : del_dmzd
			} ]

		});
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'info');
	}
	displayMsg_dmzd();
}

function displayMsg_dmzd() {
	$('#tList_dmzd').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
function validateCheck_dmzd() {
	if (mForm_dmzd.bh.value == "") {
		$.messager.alert('��ʾ', '�������ֵ���!', 'warning');
		return false;
	}
	if (mForm_dmzd.mc.value == "") {
		$.messager.alert('��ʾ', '�������ֵ�����!', 'warning');
		return false;
	}
	return true;
}
/*
 * ��Ӳ���
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
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList_dmzd').datagrid( {
						url : 'querydmzd.action?lbbh=' + lbbh,
						loadMsg : '����������......'
					});
					displayMsg_dmzd();
				});
				return;
			} else {
				$.messager.alert('��ʾ', message.info, 'warning');
				return;
			}
		}
	});
}

/*
 * ��ȡѡ�����
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
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'info');
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
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
					$('#tList_dmzd').datagrid( {
						url : 'querydmzd.action?lbbh=' + lbbh,
						loadMsg : '����������......'
					});
					close2_dmzd();
					displayMsg_dmzd();
				});
			} else {
				$.messager.alert('��ʾ', message.info, 'warning');
				return;
			}

		}
	});

}
/*
 * ɾ������
 */
function del_dmzd() {
	var selecteds = $('#tList_dmzd').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
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
					$.messager.alert('��ʾ', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
				$('#tList_dmzd').datagrid('clearSelections');
				$('#tList_dmzd').datagrid( {
					url : 'querydmzd.action?lbbh=' + lbbh,
					loadMsg : '����������......'
				});
			}

			});
		}
	}	);
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}

/*
 * �ر���������
 */
function close1_dmzd() {
	$('#add_dmzd').window('close');
}
/*
 * �رձ༭����
 */
function close2_dmzd() {
	$('#edit_dmzd').window('close');
}
