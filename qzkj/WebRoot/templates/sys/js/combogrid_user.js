jQuery(function($) {

	$('#deptid').combogrid( {
		panelWidth : 380,
		width : 380,
		height : 250,
		pageList : [ 15, 30, 45, 60 ],
		idField : 'deptno',
		textField : 'deptname',
		url : 'getdeptgrid.action',
		fitColumns : true,
		striped : true,
		columns : [ [ {
			field : 'deptno',
			title : '����',
			width : 100
		}, {
			field : 'deptname',
			title : '����',
			width : 200
		} ] ],
		pagination : true,
		rownumbers : false
	});
})