
function displayMsg() {
	$('#zblist').datagrid('getPager').pagination( {
		displayMsg : '当前显示从{from}到{to}共{total}记录'
	});
}
function tableSelectChange()
{
	var queryParams = $('#zblist').datagrid('options').queryParams;
	queryParams.zbname = "";
	$('#zbname').val("");
	$('#zblist').datagrid( {
		
		url : 'zhcxzbzdQuery.action?bname='+$('#dybid').val(),
		loadMsg : '数据装载中......',
		pageNumber:1
	});
	$('#zblist').datagrid('clearSelections');
		displayMsg();
		var rows=$('#zblist2').datagrid('getRows');
		
		if(rows.length>0)
			var rownum=rows.length;
			{
			for(var i=0;i<rownum;i++)
				{
				 $('#zblist2').datagrid('deleteRow',0)		 
				}
			}
}

function openzbQuery()
{
	$('#view').window('open');
	$('#zblist').datagrid( {
		iconCls : 'icon-save',
		width : '300',
		height : '350',
		pageList : [ 10],
		nowrap : false,
		striped : true,
		collapsible : true,
		url : 'zhcxzbzdQuery.action?bname='+$('#dybid').val(),
		loadMsg : '数据装载中......',
		idField : 'id',
		remoteSort : false,
		editor : "text",
		frozenColumns : [ [  {
			field : 'ck',
			checkbox : true
		},{
			title : '指标名称',
			field : 'zbmc',
			width : '280',
			align : 'left'
		} ] ],
		pagination : true,
		rownumbers : true,   
		toolbar : [ 
		{
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
			ClearAll();
			var rows=$('#zblist').datagrid('getSelections');
				if(rows.length>0)
					{
					 for(var i=0;i<rows.length;i++)
						 {
						 if($('#zblist2').datagrid('getRowIndex',rows[i])<0)
							 {
							
							 $('#zblist2').datagrid('insertRow',{index:0,row:rows[i]});
							 }
						 }
					}
			}
		} ]
		
	});
	function ClearAll()
	{
		var rows=$('#zblist2').datagrid('getRows');
				var rowsnum=rows.length;
				if(rowsnum>0)
					{
					for(var i=0;i<rowsnum;i++)
						{
						$('#zblist2').datagrid('deleteRow',0)
						}
					}
	}
	$('#zblist').datagrid('clearSelections');
		displayMsg();
		$('#zblist2').datagrid( {
		iconCls : 'icon-save',
		width : '300',
		height : '350',
		nowrap : false,
		striped : true,
		collapsible : true,
		url : '',
		loadMsg : '数据装载中......',
		idField : 'id',
		remoteSort : false,
		editor : "text",
		frozenColumns : [ [  {
			field : 'ck',
			checkbox : true
		},{
			title : '指标名称',
			field : 'zbmc',
			width : '280',
			align : 'left'
		} ] ],
		rownumbers : true,   
		toolbar : [ 
		{
			text : '清空指标',
			iconCls : 'icon-cancel',
			handler : ClearAll
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				var rows=$('#zblist2').datagrid('getSelections');
				var rowsnum=rows.length;
				if(rowsnum>0)
					{
					for(var i=0;i<rowsnum;i++)
						{
						var inedx=$('#zblist2').datagrid('getRowIndex',rows[0]);
						$('#zblist2').datagrid('deleteRow',inedx);
						}
					}
				}
		}]
	});
}
function zbQuery()
{
	var queryParams = $('#zblist').datagrid('options').queryParams;
	queryParams.zbname = encodeURIComponent(encodeURIComponent($('#zbname')
			.val()));
	$('#zblist').datagrid( {
		url : 'zhcxzbzdQuery.action?bname='+$('#dybid').val(),
		pageNumber:1
	});
	displayMsg();
}
function selectedZb(disname)
{
	var dis=document.getElementById(disname);
	var disText="";
	var rows=$('#zblist2').datagrid('getRows');
	if(rows.length>0)
		{
		for(var i=0;i<rows.length;i++)
			{
				if(i==0)
					{
					disText=rows[i].zbmc;
					}else
					{
					disText+=","+rows[i].zbmc;	
						
					}
			}

		}
	dis.value=disText;
	$('#view').window('close');
}
function closezb()
{
	$('#view').window('close');
}
