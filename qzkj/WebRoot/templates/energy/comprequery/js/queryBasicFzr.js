function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整 
}

//  数据加载		
$(function() {
	$('#tlist').datagrid( {
		iconCls : 'icon-save',
		width : "100%",
		height : fixHeight(0.8),
		pageList : [ 15, 30, 45, 60 ],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'queryFzr.action',
		loadMsg : '数据装载中......',
		idField : 'id',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			title : '县市区',
			field : 'qymc',
			width : '55',
			align : 'left',
			sortable : true
		}, {
			title : '企业名称',
			field : 'dwmc',
			width : '200',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '能源管理负责人姓名',
			field : 'glyxm',
			width : '200',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '培训号',
			field : 'pxh',
			width : '150',
			align : 'left',
			sortable : true,
			sorter : function(a, b) {
				return (a > b ? 1 : -1);
			}
		}, {
			title : '联系电话(手机)',
			field : 'lxdh',
			width : '150',
			align : 'left',
			sortable : true
			
		}] ],
		pagination : true,
		rownumbers : true

	});
	displayMsg();
});
function displayMsg() {

	$('#tlist').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
//    tab2查询方法


function q2_search() {

	
	var nd=$('#nd').val();
	var glyxm=$('#glyxm').val();
	var pxh=$('#pxh').val();
	var lxdh=$('#lxdh').val();
	var url="queryFzr.action?nd="+nd;
	if(glyxm!=""&&glyxm!=null)
		url+="&glyxm="+encodeURIComponent(encodeURIComponent(glyxm));
	if(pxh!=null&&pxh!="")
		url+="&pxh="+encodeURIComponent(encodeURIComponent(pxh))
	if(lxdh!=null&&lxdh!="")
		url+="&lxdh="+lxdh;
	$('#tlist').datagrid( {
	url:url,
	loadMsg : '数据装载中......',
	pageNumber:1
	});
	displayMsg();
	}






