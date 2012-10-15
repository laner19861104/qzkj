

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
	"get" : "getLandAllocationbyId.action",
	"add" : "addLandAllocation.action",
	"edit" : "editLandAllocation.action",
	"del" : "delLandAllocation.action",
	"lock" : "lcokLandAllocation.action",
	"unlock" : "unlcokLandAllocation.action"
});
$(function() {
	$('#mForm').hide();
	$('#add').window({
		onOpen:function(){
			$('#parcelcode').removeAttr('readonly');
		}
	});
	$('#edit').window({
		onOpen:function(){
			$('#parcelcode').attr('readonly','readonly');
		}
	});
	$('#tList').datagrid( {
		iconCls : 'icon-save',
		width : 'auto',
		height : fixHeight(0.94),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,cRdate"), //��ʱȡjson�ļ��е�����
		loadMsg : '����װ����......',
		idField : 'uuid',
		sortName : 'no',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '�ڵر��',
			field : 'parcelcode',
			width : '80',
			sortable : true
		}, {
			title : '�ڵ�λ��',
			field : 'parcelposition',
			width : '250',
			align : 'left',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '״̬',
			field : 'cnstate',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		},{
			title : '�������������ĺ�',
			field : 'tradeapprovalcode',
			width : '130',
			align : 'left',
			rowspan:2
		},{
			title : '����������������',
			field : 'tradeapprovaldate',
			width : '120',
			align : 'left',
			rowspan:2
		},{
			title : '���÷�ʽ',
			field : 'cnlandtranmode',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		},{
			title : '������;',
			field : 'landuse',
			width : '80',
			align : 'left',
			rowspan :2
		},{
			title : '���(ƽ����)',
			align : 'center',
			colspan :3
		},{
			title : '�ܳɱ�',
			field : 'totalcost',
			width : '60',
			align : 'right',
			sortable : true,
			rowspan :2
		},{
			title : '֧��',
			align : 'center',
			colspan :2
		},{
			title : '�滮�������',
			align : 'center',
			colspan :3
		},
		   /* {
			title : '��������',
			field : 'reserveyear',
			width : '65',
			align : 'left',
			sortable : true,
			rowspan :2
		},  {
			title : '���ؼ���',
			field : 'landlevel',
			width : '60',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : 'ԭ���ؼ���',
			field : 'landlevelorig',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : '����ʹ��Ȩ���',
			field : 'landuserighttype',
			width : '100',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : 'ԭ����ʹ��Ȩ���',
			field : 'landrighttypeorig',
			width : '120',
			align : 'left',
			sortable : true,
			rowspan :2
		}, 
		*/{
			title : 'ί�е�λ����',
			field : 'entrustunitname',
			width : '150',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : 'ԭ�õص�λ',
			field : 'landuseunitorig',
			width : '150',
			align : 'left',
			sortable : true,
			rowspan :2
		}],[{
			title : '�������',
			field : 'landaream',
			width : '60',
			align : 'right',
			sortable : true
		}, {
			title : '�������',
			field : 'approvalaream',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '�������',
			field : 'compensateaream',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : 'Ӧ֧��',
			field : 'totalexpend',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '��֧��',
			field : 'isenpend',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '���õ����',
			field : 'netaream',
			width : '80',
			align : 'right',
			sortable : true
		}, {
			title : '�̻������',
			field : 'greenaream',
			width : '80',
			align : 'right',
			sortable : true
		}, {
			title : '��·�õ����',
			field : 'roadaream',
			width : '80',
			align : 'left',
			sortable : true
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
	$('#crdate').datebox( {
		colseText : '�ر�',
		currentText : '',
		okText : 'ȷ��',
		//cls:'input_text',
		width : 172,
		formatter : function(date) {
			return date.format('yyyy-MM-dd');
		}
	})

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
/**
 * ����Ȩ�޻�ȡ������ť
 * @return
 */
function getToolbar() {
	return [ {
		text : '��ϸ',
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
		text : '������Ϣ',
		iconCls : 'icon-relation_2',
		handler : showReserveAssistInfo
	}, '-', {
		text : '���๹��',
		iconCls : 'icon-relation_2',
		handler : showParcelComprise
	}, '-', {
		text : '�ڵظ�����',
		iconCls : 'icon-relation_3',
		handler : showParcelreserveAttachment
	}, '-', {
		text : '�ڵذ����˿�',
		iconCls : 'icon-relation_4',
		handler : showParcelreservePopulation
	}];
}

/*
 *�����ֶε���Ч��У��
 */
function validateCheck() {
	if (mForm.parcelcode.value == "") {
		$.messager.alert('����', '�ڵر�Ų���Ϊ��!', 'warning');
		return false;
	}

	if ($('#landaream').numberbox('getValue') == "") {
		$.messager.alert('����', '�����������Ϊ��!', 'warning');
		return false;
	}
	if (mForm.reserveyear.value == "") {
		$.messager.alert('����', '��ѡ�񴢱�����!', 'warning');
		return false;
	}
	if ($('#regioncode').combotree('getValues') == "") {
		$.messager.alert('����', '����������Ϊ��!', 'warning');
		return false;
	}
//  if(mForm.newapprovalcode.value!="")
//	   { 
//	   var newapprovalcode=mForm.newapprovalcode.value;
//                       
//                        var result=$.ajax({
//                            url:'existsJobapprovalAction.action',
//                            dataType:"json",
//                            data:{
//                        	landrescode:newapprovalcode
//                            },
//                            async:false,
//                            cache:false,
//                            type:"post"
//                        }).responseText;
//
//            if(jQuery.parseJSON(result).success==false)
//            	{
//            	if(!confirm('���������ĺŲ�����!�Ƿ����?'))
//            		return false
//            	}
//	   }
	if(mForm.res01.value!="")
	   { 
	   var landrescode=mForm.res01.value;
                       
                        var result=$.ajax({
                            url:'existsJobLandreserve.action',
                            dataType:"json",
                            data:{
                        	landrescode:landrescode
                            },
                            async:false,
                            cache:false,
                            type:"post"
                        }).responseText;

            if(jQuery.parseJSON(result).success==false)
            	{
            	if(!confirm('�����ؿ��Ų�����!�Ƿ����?'))
            		return false
            	}
	   }

	return true;
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
		$('#landtranmode').val('03')
			//return $('#mForm').form('validate');
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
	if (select[0].state != "01") {
		$.messager.alert('��ʾ', '�����޸�!', 'warning');
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
			$('#landtranmode').val('03')
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
	var url = urls['query']+"?"+appCondition("[id^='s_']","$status-landtranmode|03$orderby|state,regioncode,landtranmode");
	$('#tList').datagrid( {
		url : url
	});
	displayMsg('tList');
	$('#tList').datagrid('clearSelections');
	$('#query').window('close');
}

/**
 * �ڵسɱ�
 * @return
 */
var select;
function showParcelComprise() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
		return;
	}
	
	var height=600;
	var width=800;
	var top=(window.screen.height-height)/2;
	var left=(window.screen.width-width)/2;
	var url="parcelreserveCompriseTransferEntry.action?parcelcode="+select[0].parcelcode;
	window.open(url,null,'height='+height+',width='+width+',top='+top+',left='+left+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	
}
/**
 * �ڵصؿ鸽����
 * @return
 */
function showParcelreserveAttachment() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
		return;
	}
	var height=600;
	var width=800;
	var top=(window.screen.height-height)/2;
	var left=(window.screen.width-width)/2;
	var url="parcelreserveAttachmentTransferEntry.action?parcelcode="+select[0].parcelcode;
	window.open(url,null,'height='+height+',width='+width+',top='+top+',left='+left+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	
}
/**
 * �ڵذ����˿�
 * @return
 */
function showParcelreservePopulation() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('��ʾ', '��ѡ��һ������!', 'warning');
		return;
	}
	var height=600;
	var width=800;
	var top=(window.screen.height-height)/2;
	var left=(window.screen.width-width)/2;
	var url="parcelreservePopulationTransferEntry.action?parcelcode="+select[0].parcelcode;
	window.open(url,null,'height='+height+',width='+width+',top='+top+',left='+left+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	
}
function lock()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('����', 'ȷ�ϼ���ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
				if (ids == "")
					ids = "'" + selecteds[i].uuid + "'";
				else
					ids = ids + "," + "'" + selecteds[i].uuid + "'";
			}

			$.ajax( {
				type : "POST",
				url : urls["lock"],
				data : "id=" + ids,
				dataType : "json",
				cache : false,
				success : function callback(msg) {
					if (msg.success) {
						$.messager.alert('��ʾ', msg.info, 'info');
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
function unlock()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('����', 'ȷ�Ͻ���ô?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//��ȡĳ�е��к�
				if (ids == "")
					ids = "'" + selecteds[i].uuid + "'";
				else
					ids = ids + "," + "'" + selecteds[i].uuid + "'";
			}

			$.ajax( {
				type : "POST",
				url : urls["unlock"],
				data : "id=" + ids,
				dataType : "json",
				cache : false,
				success : function callback(msg) {
					if (msg.success) {
						$.messager.alert('��ʾ', msg.info, 'info');
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