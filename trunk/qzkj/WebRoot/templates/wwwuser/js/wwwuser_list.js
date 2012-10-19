

/************************************************************
 * js����landLease_list.js
 *
 * ���js
 * ���ܣ����顢�������޸ġ�ɾ������ѯ��
 * 
 *   Ver     �����     Ȩ��      ������    �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2012-6-12  CFIT-PG   �콭      ����
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
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,crDate"), //��ʱȡjson�ļ��е�����
		loadMsg : '����װ����......',
		idField : 'uuid',
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '�ʺ�',
			field : 'account',
			width : '80',
			sortable : true
		}, {
			title : '����',
			field : 'username',
			width : '250',
			align : 'left',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '״̬',
			field : 'cnstate',
			width : '80',
			align : 'left',
			sortable : true
			
		},{
			title : '�Ա�',
			field : 'sex',
			width : '130',
			align : 'left'
		},{
			title : '�˻����',
			field : 'money',
			width : '130',
			align : 'left'
		},{
			title : '��ϵ�绰',
			field : 'tel',
			width : '130',
			align : 'left'
		},{
			title : '���֤��',
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
			title : '��������',
			field : 'pwdquestion',
			width : '130',
			align : 'left'
		},{
			title : '��������',
			field : 'birthday',
			width : '130',
			align : 'left'
		},{
			title : '��ַ',
			field : 'address',
			width : '130',
			align : 'left'
		},{
			title : 'ѧ��',
			field : 'edulv',
			width : '130',
			align : 'left'
		},{
			title : '������λ',
			field : 'workFor',
			width : '130',
			align : 'left'
		},{
			title : '������λ',
			field : 'workFor',
			width : '130',
			align : 'left'
		},{
			title : 'ͨѶ��ַ',
			field : 'postAddress',
			width : '130',
			align : 'left'
		},{
			title : '�ʱ�',
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
 *��ȡ�б��еĵ�����¼
 */
var uuid;

/*
 * ����
 */
function getView() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
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
 *�޸Ĳ���
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
				$.messager.alert('����', '�޸���Ϣ�ɹ�!', 'info', function() {
					closeWin('edit');
					$('#tList').datagrid('reload');
					$('#tList').datagrid('clearSelections');

					displayMsg('tList');
				});
			} else {
				$.messager.alert('����', message.info, 'warning');
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
		$.messager.confirm('����', 'ȷ��ͣ��ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
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
						$.messager.alert('��ʾ', '��ͣ��!', 'info');
					} else {
						$.messager.alert('����', msg.info, 'warning');
						return;
					}
					$('#tList').datagrid('reload');
					displayMsg('tList');
				}

			});

		}
	}	);
	} else {
		$.messager.alert('����', '��ѡ��һ������', 'warning');
	}
}
function openW()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('����', 'ȷ������ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
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
						$.messager.alert('��ʾ', "������!", 'info');
					} else {
						$.messager.alert('����', msg.info, 'warning');
						return;
					}
					$('#tList').datagrid('reload');
					displayMsg('tList');
				}

			});

		}
	}	);
	} else {
		$.messager.alert('����', '��ѡ��һ������', 'warning');
	}
}

/*
 * ��ѯ����
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
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
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
		url : "queryPayRecord.action?"+appCondition("[id^='p_']","$userAccount|"+select[0].account+"$orderby|payDate|desc"), //��ʱȡjson�ļ��е�����
		loadMsg : '����װ����......',
		idField : 'uuid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '��ֵ���',
			field : 'money',
			width : '80',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '��ֵ����',
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
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
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
		url : "queryConsumptionRecord.action?"+appCondition("[id^='p_']","$userAccount|"+select[0].account+"$orderby|conDate|desc"), //��ʱȡjson�ļ��е�����
		loadMsg : '����װ����......',
		idField : 'uuid',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '���ѽ��',
			field : 'money',
			width : '80',
			align:'right',
			sortable : true
		}]  ],

		columns : [ [{
			title : '��������',
			field : 'payDate',
			width : '250',
			align : 'left',
			sortable : true
		},{
			title : '��Ʒ����',
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
