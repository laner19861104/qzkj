function receiverList(myhiddenName, mydataUrl,roottxt, dvalue) {

	var comboxWithTree = new Ext.form.ComboBox({
		store : new Ext.data.SimpleStore({
					fields : [],
					data : [[]]
				}),
		editable : false,
		mode : 'local',
		triggerAction : 'all',
		maxHeight : 200,
		hiddenName : myhiddenName,
		tpl : "<tpl for='.'><div style='height:200px'><div id='tree'></div></div></tpl>",
		selectedClass : '',
		onSelect : Ext.emptyFn
	});
	var treeLoader = new Ext.tree.TreeLoader({
				dataUrl : mydataUrl
				
			})
	var root = new Ext.tree.AsyncTreeNode({
				text : roottxt,
				id : '-1',
				loader : treeLoader
			})
	var tree = new Ext.tree.TreePanel({
				border : false,
				root : root
			});
	tree.on('click', function(node) {

				comboxWithTree.setValue(node.text);
				comboxWithTree.hiddenField.value = node.id == '-1'? '': node.id;
				comboxWithTree.collapse();
			});
	comboxWithTree.on('expand', function() {
				tree.render('tree');	
			});
	comboxWithTree.render('comboxWithTree');

if (dvalue != null && dvalue != '' & dvalue != 'null') {

comboxWithTree.onFocus()
comboxWithTree.expand();
comboxWithTree.collapse();

tree.expandAll();

tree.on('load', function(node) {
			var node2=node.id==dvalue?node2:getnode(node,dvalue);
			if(node2!=null){
			comboxWithTree.setValue(node2.text);
			comboxWithTree.hiddenField.value=dvalue;
			
			node2.select();
			
			}
			});


	}
	
}



function getnode(node,id) {
		
		var ns = node.childNodes;
		for (var i = 0; i < ns.length; i++) {
				if (ns[i].id==id){
					
					return ns[i];
				}
		
			
		
		}

	}
