

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
		url : urls['query']+"?"+appCondition("[id^='s_']","$orderby|state,cRdate"), //暂时取json文件中的数据
		loadMsg : '数据装载中......',
		idField : 'uuid',
		sortName : 'no',
		sortOrder : 'asc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		},  {
			title : '宗地编号',
			field : 'parcelcode',
			width : '80',
			sortable : true
		}, {
			title : '宗地位置',
			field : 'parcelposition',
			width : '250',
			align : 'left',
			sortable : true
		} ] ],

		columns : [ [ {
			title : '状态',
			field : 'cnstate',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		},{
			title : '政府出让批复文号',
			field : 'tradeapprovalcode',
			width : '130',
			align : 'left',
			rowspan:2
		},{
			title : '政府出让批复日期',
			field : 'tradeapprovaldate',
			width : '120',
			align : 'left',
			rowspan:2
		},{
			title : '出让方式',
			field : 'cnlandtranmode',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		},{
			title : '土地用途',
			field : 'landuse',
			width : '80',
			align : 'left',
			rowspan :2
		},{
			title : '面积(平方米)',
			align : 'center',
			colspan :3
		},{
			title : '总成本',
			field : 'totalcost',
			width : '60',
			align : 'right',
			sortable : true,
			rowspan :2
		},{
			title : '支出',
			align : 'center',
			colspan :2
		},{
			title : '规划设计条件',
			align : 'center',
			colspan :3
		},
		   /* {
			title : '储备年月',
			field : 'reserveyear',
			width : '65',
			align : 'left',
			sortable : true,
			rowspan :2
		},  {
			title : '土地级别',
			field : 'landlevel',
			width : '60',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : '原土地级别',
			field : 'landlevelorig',
			width : '80',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : '土地使用权类别',
			field : 'landuserighttype',
			width : '100',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : '原土地使用权类别',
			field : 'landrighttypeorig',
			width : '120',
			align : 'left',
			sortable : true,
			rowspan :2
		}, 
		*/{
			title : '委托单位名称',
			field : 'entrustunitname',
			width : '150',
			align : 'left',
			sortable : true,
			rowspan :2
		}, {
			title : '原用地单位',
			field : 'landuseunitorig',
			width : '150',
			align : 'left',
			sortable : true,
			rowspan :2
		}],[{
			title : '土地面积',
			field : 'landaream',
			width : '60',
			align : 'right',
			sortable : true
		}, {
			title : '报批面积',
			field : 'approvalaream',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '补偿面积',
			field : 'compensateaream',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '应支出',
			field : 'totalexpend',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '已支出',
			field : 'isenpend',
			width : '60',
			align : 'right',
			sortable : true
		},{
			title : '净用地面积',
			field : 'netaream',
			width : '80',
			align : 'right',
			sortable : true
		}, {
			title : '绿化带面积',
			field : 'greenaream',
			width : '80',
			align : 'right',
			sortable : true
		}, {
			title : '道路用地面积',
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
		colseText : '关闭',
		currentText : '',
		okText : '确定',
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
 * 根据权限获取操作按钮
 * @return
 */
function getToolbar() {
	return [ {
		text : '详细',
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
		text : '辅助信息',
		iconCls : 'icon-relation_2',
		handler : showReserveAssistInfo
	}, '-', {
		text : '地类构成',
		iconCls : 'icon-relation_2',
		handler : showParcelComprise
	}, '-', {
		text : '宗地附着物',
		iconCls : 'icon-relation_3',
		handler : showParcelreserveAttachment
	}, '-', {
		text : '宗地安置人口',
		iconCls : 'icon-relation_4',
		handler : showParcelreservePopulation
	}];
}

/*
 *输入字段的有效性校验
 */
function validateCheck() {
	if (mForm.parcelcode.value == "") {
		$.messager.alert('警告', '宗地编号不能为空!', 'warning');
		return false;
	}

	if ($('#landaream').numberbox('getValue') == "") {
		$.messager.alert('警告', '土地面积不能为空!', 'warning');
		return false;
	}
	if (mForm.reserveyear.value == "") {
		$.messager.alert('警告', '请选择储备年月!', 'warning');
		return false;
	}
	if ($('#regioncode').combotree('getValues') == "") {
		$.messager.alert('警告', '所属区域不能为空!', 'warning');
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
//            	if(!confirm('新增批复文号不存在!是否继续?'))
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
            	if(!confirm('储备地块编号不存在!是否继续?'))
            		return false
            	}
	   }

	return true;
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
		$('#landtranmode').val('03')
			//return $('#mForm').form('validate');
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
	if (select[0].state != "01") {
		$.messager.alert('提示', '不可修改!', 'warning');
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
			$('#landtranmode').val('03')
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
	var url = urls['query']+"?"+appCondition("[id^='s_']","$status-landtranmode|03$orderby|state,regioncode,landtranmode");
	$('#tList').datagrid( {
		url : url
	});
	displayMsg('tList');
	$('#tList').datagrid('clearSelections');
	$('#query').window('close');
}

/**
 * 宗地成本
 * @return
 */
var select;
function showParcelComprise() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
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
 * 宗地地块附着物
 * @return
 */
function showParcelreserveAttachment() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
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
 * 宗地安置人口
 * @return
 */
function showParcelreservePopulation() {
	 select = $('#tList').datagrid('getSelections');
	if (select.length != 1) {
		$.messager.alert('提示', '请选择一行数据!', 'warning');
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
		$.messager.confirm('警告', '确认加锁么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
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
						$.messager.alert('提示', msg.info, 'info');
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
function unlock()
{
	var selecteds = $('#tList').datagrid('getSelections');
	var ids = "";
	if (selecteds != "" || selecteds.length > 0) {
		$.messager.confirm('警告', '确认解锁么?', function(id) {
			if (id) {
				for ( var i = 0; i < selecteds.length; i++) {
					var selected = selecteds[i];//获取某行的行号
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
						$.messager.alert('提示', msg.info, 'info');
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