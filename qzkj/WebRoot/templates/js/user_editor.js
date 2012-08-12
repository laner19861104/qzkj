/*!
 * Ext JS Library 3.2.0
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){
    Ext.QuickTips.init();

    var Employee = Ext.data.Record.create([
    {
        name: 'userName',
        type: 'string'
    },{
        name: 'userId',
        type: 'string'
    }, {
        name: 'phone',
        type: 'string'
    }, {
        name: 'state',
        type: 'string'
    }, {
        name: 'userType',
        type: 'String'
    },{
        name: 'deptName',
        type: 'String'
    },{
        name: 'regionCode',
        type: 'String'
    }]);


    // hideous function to generate employee data
    var genData = function(){
        var data = [];
         data.push({
                    userName: 'test1',
                    userId: '测试1',
                    phone: '13900000000',
                    state: '正常',
                    userType: '管理员',
                    deptName: '信息中心',
                    regionCode: '奎文'
                });
        return data;
    }


    var store = new Ext.data.GroupingStore({
        reader: new Ext.data.JsonReader({fields: Employee}),
        data: genData(),
        sortInfo: {field: 'userType', direction: 'ASC'}
    });

    var editor = new Ext.ux.grid.RowEditor({
        saveText: '保存',
        cancelText: '放弃'
    });

    var grid = new Ext.grid.GridPanel({
        store: store,
        width: 600,
        region:'center',
        margins: '0 5 5 5',
        autoExpandColumn: 'userName',
        plugins: [editor],
        view: new Ext.grid.GroupingView({
            markDirty: false
        }),
        tbar: [{
            iconCls: 'icon-user-add',
            text: '新增',
            handler: function(){
                var e = new Employee({
                    name: 'New User',
                    email: 'new@gov.cn',
                    start: (new Date()).clearTime(),
                    salary: 50000,
                    active: true
                });
                editor.stopEditing();
                store.insert(0, e);
                grid.getView().refresh();
                grid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },{
            ref: '../removeBtn',
            iconCls: 'icon-user-delete',
            text: '删除',
            disabled: true,
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        },{
            ref: '../setPwd',
            iconCls: 'icon-user-delete',
            text: '修改密码',
            disabled: true,
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        },{
            ref: '../setRole',
            iconCls: 'icon-user-delete',
            text: '设置权限',
            disabled: true,
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        }],

        columns: [
        new Ext.grid.RowNumberer(),
        {
            id: 'userName',
            header: '用户名',
            dataIndex: 'userName',
            width: 150,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: false
                
            }
        }, {
            id: 'userId',
            header: '用户姓名',
            dataIndex: 'userId',
            width: 150,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: false
            }
        },{
            header: '电话',
            dataIndex: 'phone',
            width: 150,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: true
              
            }
        },{
            header: '状态',
            dataIndex: 'state',
            width: 100,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: true
           
            }
        },{
            header: '部门',
            dataIndex: 'deptName',
            width: 100,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: true

            }
        },{
            header: '用户类型',
            dataIndex: 'userType',
            width: 100,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: true
            
            }
        },{
            header: '区域',
            dataIndex: 'regionCode',
            width: 100,
            sortable: true,
            editor: {
                xtype: 'textfield',
                allowBlank: true
            
            }
        }],
        
          // paging bar on the bottom
        bbar: new Ext.PagingToolbar({
            pageSize: 25,
            store: store,
            displayInfo: true,
            displayMsg: '显示：{0} - {1}条，总：{2}条',
            emptyMsg: "No topics to display",
            items:[
                '-', {
                pressed: true,
                enableToggle:true,
                text: 'Show Preview',
                cls: 'x-btn-text-icon details',
                toggleHandler: function(btn, pressed){
                    var view = grid.getView();
                    view.showPreview = pressed;
                    view.refresh();
                }
            }]
        })
    });
  var cstore = new Ext.data.JsonStore({
        fields:['userName', 'userId', 'phone','state','deptName','userType','regionCode'],
        data:[],
        refreshData: function(){
            var data = [];
           
            this.loadData(data);
        }
    });
    cstore.refreshData();
    store.on('add', cstore.refreshData, cstore);
    store.on('remove', cstore.refreshData, cstore);
    store.on('update', cstore.refreshData, cstore);
    var layout = new Ext.Panel({
        title: '用户管理',
        layout: 'border',
        layoutConfig: {
            columns: 1
        },
        width:800,
        height: 600,
        items: [grid]
    });
    layout.render(Ext.getBody());

    grid.getSelectionModel().on('selectionchange', function(sm){
        grid.removeBtn.setDisabled(sm.getCount() < 1);
        grid.setPwd.setDisabled(sm.getCount() < 1);
        grid.setRole.setDisabled(sm.getCount() < 1);
    });
});
