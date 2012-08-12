/************************************************************
 * js����dept_list.js
 *
 * ���js
 * ���ܣ����顢�������޸ġ�ɾ������ѯ��
 * 
 *   Ver     �����     Ȩ��      ������    �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2011-9-30  CFIT-PM   ��ʤ��      ����
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
		loadMsg : '����װ����......',
		idField : 'deptid',
		sortName : 'deptno',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			title : '��������',
			field : 'deptno',
			width : '100',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '��������',
			field : 'deptname',
			width : '250',
			align : 'left'
		}, {
			title : '��֯��������',
			field : 'res12',
			width : '100',
			align : 'left'
		}, {
			title : '��������',
			field : 'cndepttype',
			width : '150',
			align : 'left'
		}, {
			title : '�������',
			field : 'cndeptlevel',
			width : '100',
			align : 'left'
		} ] ],

		columns : [ [ {
			title : '��    ��',
			field : 'telno',
			width : '100',
			align : 'left'
		}, {
			title : '��    ��',
			field : 'faxno',
			width : '100',
			align : 'left'
		}, {
			title : '��ϵ��',
			field : 'relap',
			width : '100',
			align : 'left'
		}, {
			title : '��ϵ�˵绰',
			field : 'relaptelno',
			width : '100',
			align : 'left'
		}, {
			title : '������',
			field : 'chargep',
			width : '100',
			align : 'left'
		}, {
			title : '�����˵绰',
			field : 'chargeptelno',
			width : '100',
			align : 'left'
		}, {
			title : '�ʱ�',
			field : 'res01',
			width : '100',
			align : 'left'
		}, {
			title : '��ַ',
			field : 'res02',
			width : '200',
			align : 'left'
		}, {
			title : 'ע������',
			field : 'res03',
			width : '100',
			align : 'left'
		}, {
			title : 'ע���ʱ�',
			field : 'res05',
			width : '100',
			align : 'right'
		}, {
			title : '��ҵ��ַ',
			field : 'res04',
			width : '150',
			align : 'left'
		}, {
			title : '��ҵ����',
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
			text : '����',
			iconCls : 'icon-view',
			handler : getView
		}, '-', {
			text : '���',
			iconCls : 'icon-add',
			handler : function() {
				$('#add').window('open');
				$('#mForm').show();
				$('#mForm').form('clear');
				$('#mForm').appendTo('#aa');
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

			}
		}, '-', {
			text : '����',
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
 * ����
 */
function goback() {
	window.location = "gohome.action";
}
/*
 *����ҳ����
 */
function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
/*
 *����ҳ��߶�
 */
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ�������   
}
/*
 *��ҳ��ʾ����
 */
function displayMsg() {
	$('#tList').datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
/*
 *���ҳ��ر�
 */
function close1() {
	$('#add').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *�޸�ҳ��ر�
 */
function close2() {
	$('#edit').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *����ҳ��ر�
 */
function close3() {
	$('#view').window('close');
	$('#tList').datagrid('clearSelections');
}
/*
 *�����ֶε���Ч��У��
 */
function validateCheck() {
	if (mForm.deptno.value == "") {
		$.messager.alert('��ʾ', '�������������!', 'warning');
		return false;
	}
	if (!loginCheck(mForm.deptno.value)) {
		$.messager.alert('��ʾ', '����������벻�Ϸ�������������!', 'warning');
		return false;
	}
	if (((mForm.deptno.value).length) % 2 != 0) {
		$.messager.alert('��ʾ', '��������������Ϊż��������������!', 'warning');
		return false;
	}
	if (mForm.depttype.value == "") {
		$.messager.alert('��ʾ', '��ѡ���������!', 'warning');
		return false;
	}
	if (mForm.deptlevel.value == "") {
		$.messager.alert('��ʾ', '��ѡ��������!', 'warning');
		return false;
	}
	return true;
}
/*
 *��Ӳ���
 */
function add() {
	if (!validateCheck())
		return;

	$('#mForm').form('submit', {
		url : 'adddept.action',
		onSubmit : function() {
			return $('#mForm').form('validate');
		},
		type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
		success : function(message) {
			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydept.action',
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
/*
 *��ȡ�б��еĵ�����¼
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
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
/*
 * ����
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
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
/*
 *�޸Ĳ���
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
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid( {
						url : 'querydept.action',
						loadMsg : '����������......'
					});
					close2();
					displayMsg();
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
function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('��ʾ', 'ȷ��ɾ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
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
					$.messager.alert('��ʾ', message.info, 'info');
					return;
				}
				$.messager.alert('del-success', 'ɾ����Ϣ�ɹ�!', 'info');
				$('#tList').datagrid('clearSelections');
				$('#tList').datagrid( {
					url : 'querydept.action',
					loadMsg : '����������......'
				});
			},
			error : function() {
				$.messager.alert('del-failure', '�첽ִ�д���!', 'warning');
			}
			});
		}
	}	);
	} else {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
	}
}
/*
 * ��ѯ����
 */
function query() {
	var queryParams = $('#tList').datagrid('options').queryParams;
	if ($('#qdeptno').val() != "" && !loginCheck($('#qdeptno').val())) {
		$.messager.alert('��ʾ', '����������벻�Ϸ�������������!', 'warning');
		return;
	}
	if ($('#qdeptname').val() != "" && !descCheck($('#qdeptname').val())) {
		$.messager.alert('��ʾ', '����������Ʋ��Ϸ�������������!', 'warning');
		return;
	}
	queryParams.qdeptno = $('#qdeptno').val();
	queryParams.qdeptname = encodeURIComponent(encodeURIComponent($(
			'#qdeptname').val()));
	queryParams.qdepttype = $('#qdepttype').val();
	queryParams.qdeptlevel = $('#qdeptlevel').val();
	$('#tList').datagrid( {
		url : 'querydept.action',
		loadMsg : '����������......'
	});
	displayMsg();
	$('#query').window('close');
}
