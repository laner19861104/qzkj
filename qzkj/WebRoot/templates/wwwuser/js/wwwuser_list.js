

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
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,crDate"), //��ʱȡjson�ļ��е�����
		loadMsg : '����װ����......',
		idField : 'uuid',
		remoteSort : false,
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
 *��Ӳ���
 */
function add() {
	if (!validateCheck()) {
		return;
	}
	$('#mForm').form('submit', {
		url : urls['add'],
		onSubmit : function() {
	},
	type : "POST", // ������������Ϊ"POST"��Ĭ��Ϊ"GET"
		success : function(message) {

			var message = eval("(" + message + ")");
			if (message.success == true) {
				$.messager.alert('add-success', '�����Ϣ�ɹ�!', 'info', function() {
					$('#tList').datagrid('reload');
					displayMsg('tList');
				});
				return;
			} else {
				$.messager.alert('����', message.info, 'warning');
				return;
			}
		}
	});

}
/*
 *��ȡ�б��еĵ�����¼
 */
var uuid;
function getSelect() {
	var select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
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
				$.messager.alert('edit-success', '�޸���Ϣ�ɹ�!', 'info', function() {
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
/*
 * ɾ������
 */

function del() {
	var selecteds = $('#tList').datagrid('getSelections');
	if(selecteds!=undefined&&selecteds!=null&&selecteds.length!=1){
		$.messager.alert('����', '��ѡһ���ڵ����ݽ���ɾ��!','warning');
		return;
	}
	var uuid = selecteds[0].uuid;
	
	var selected = selecteds[0];//��ȡĳ�е��к�
		
		if(selected.state!="01"){
		$.messager.alert('����','ֻ�вݸ�״̬���ڵزſ���ɾ��!','warning');
		return;
	}

	$.messager.confirm('ȷ��',
		'ɾ��������ɾ���ڵع����ĵ��๹�ɡ��ڵظ���������˿���Ϣ��ȷ��ɾ��ô��', 
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
								$.messager.alert('��ʾ', msg.info, 'info');
								$('#tList').datagrid('clearSelections');
							} else {
								$.messager.alert('����', msg.info, 'warning');
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


