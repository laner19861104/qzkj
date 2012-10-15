Date.prototype.format = function(format)   
{   
   var o = {   
     "M+" : this.getMonth()+1, //month   
     "d+" : this.getDate(),    //day   
     "h+" : this.getHours(),   //hour   
     "m+" : this.getMinutes(), //minute   
     "s+" : this.getSeconds(), //second   
     "q+" : Math.floor((this.getMonth()+3)/3), //quarter   
     "S" : this.getMilliseconds() //millisecond   
   }   
   if(/(y+)/.test(format)) format=format.replace(RegExp.$1,   
     (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
   for(var k in o)if(new RegExp("("+ k +")").test(format))   
     format = format.replace(RegExp.$1,   
       RegExp.$1.length==1 ? o[k] :    
         ("00"+ o[k]).substr((""+ o[k]).length));   
   return format;   
}  
/**
 * �Զ���ȡ����������ƴд��ѯ���� Ĭ������Ϊ��idΪ"s_"��ͷ��
 * @param {Object} xp jQueryѡ�����ı��ʽ ����"[id^='s_']"
 * @param {Object} add �̶������� $startmark|1
 * @return {TypeName} conditions=
 */
function appCondition(xp,add)
{
	var str="";
		$(xp==undefined?"[id^='s_']":xp)
			.each(
					function(i, a) {
						if ($("#" + a.id).attr("class") != undefined) {
							if ($("#" + a.id).attr("class").indexOf(
									'easyui-datebox') != -1) {
								if ($("#" + a.id).datebox('getValue') != "")
									str += "$" + a.id.split("_")[1] + "|"
											+ $("#" + a.id).datebox('getValue');
							}else if ($("#" + a.id).attr("class").indexOf(
									'datebox-f') != -1) {
								if ($("#" + a.id).datebox('getValue') != "")
									str += "$" + a.id.split("_")[1] + "|"
											+ $("#" + a.id).datebox('getValue');
							}else if ($("#" + a.id).attr("class").indexOf(
									'easyui-numberbox') != -1) {
								if ($("#" + a.id).numberbox('getValue') != "")
									str += "$"
											+ a.id.split("_")[1]
											+ "|"
											+ $("#" + a.id).numberbox(
													'getValue');
							} else if ($("#" + a.id).attr("class").indexOf(
									'combotree') != -1) {
								if ($("#" + a.id).combotree('getValues') != "")
									str += "$"
											+ a.id.split("_")[1]
											+ "|"
											+ $("#" + a.id).combotree(
													'getValues');
							} else if ($("#" + a.id).attr("class").indexOf(
									'easyui-combobox') != -1) {
								if ($("#" + a.id).combobox('getValues') != "")
									str += "$"
											+ a.id.split("_")[1]
											+ "|"
											+ $("#" + a.id).combobox(
													'getValues');
							} else if ($("#" + a.id).attr("class").indexOf(
									'easyui-combogrid') != -1) {
								if ($("#" + a.id).combogrid('getValues') != "")
									str += "$"
											+ a.id.split("_")[1]
											+ "="
											+ $("|" + a.id).combogrid(
													'getValues');
							} else {
								if ($("#" + a.id).val() != "")
									str += "$" + a.id.split("_")[1] + "|"
											+ $("#" + a.id).val();
							}

						} else {
							if ($("#" + a.id).val() != "")
								str += "$" + a.id.split("_")[1] + "|" + $("#" + a.id).val();
						}

					});
		return "conditions=1|1"+encodeURIComponent(encodeURIComponent(str+(add||"")));
}
/**
 * �Զ���json����
 * @param {Object} json
 * @param {Object} name
 * @return {TypeName} 
 */
function fillForm(json,name)
{
	for(var key in json){
		if(name!=undefined)
			var sN=name + key;
		else
			var sN=key
         ����//alert("key��"+sN+",value��"+json[key]); 
				if ($("#" + sN).attr("class") != undefined) {
							if ($("#" + sN).attr("class").indexOf(
									'datebox-f') != -1) {
								if(json[key]!=null&&json[key]!=""&&json[key]!=undefined)
								$("#" + sN).datebox('setValue',json[key]);
									
							} else if ($("#" + sN).attr("class").indexOf(
									'easyui-numberbox') != -1) {
								$("#" + sN).numberbox('setValue',json[key]);
									
							}else if ($("#" + sN).attr("searchboxname")!=undefined) {
								$("#" + sN).searchbox('setValue',json[key]);
									
							}else if ($("#" + sN).attr("class").indexOf(
									'combotree') != -1) {
								
								if ($("#" + sN).attr("mutiple")==true)
									$("#" + sN).combotree('setValues',json[key])
								else
									$("#" + sN).combotree('setValue',json[key])
									
							} else if ($("#" + sN).attr("class").indexOf(
									'easyui-combobox') != -1) {
								if ($("#" + sN).attr("mutiple")==true)
								$("#" + sN).combobox('setValues',json[key])
								else
								$("#" + sN).combobox('setValue',json[key])
									
							} else if ($("#" + sN).attr("class").indexOf(
									'easyui-combogrid') != -1) {
								if ($("#" + sN).attr("mutiple")==true)
								$("#" + sN).combogrid('setValues',json[key])
								else
								$("#" + sN).combogrid('setValue',json[key])	
							} else {
								$("#" + sN).val(json[key])
							}
        } else {
								$("#" + sN).val(json[key])
								//$("#" + sN).attr('value',json[key])
								
							}
}
}

/**
 * ����
 */
function goback() {
	window.location = "gohome.action";
}
/**
 * ��ȡ���
 * @param {Object} percent
 * @return {TypeName} 
 */
function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
/**
 * ��ȡ�߶�
 * @param {Object} percent
 * @return {TypeName} 
 */
function fixHeight(percent) {
	return document.body.clientHeight-28; //����������Լ�������   
}
/**
 * �޸�datagridҳ�ŵ���ʾ��ʽ
 * @param {Object} name
 */
function displayMsg(name) {
	name = name || "tList";
	$('#'+name).datagrid('getPager').pagination( {
		beforePageText: '��',//ҳ���ı���ǰ��ʾ�ĺ���   
        afterPageText: 'ҳ �� {pages} ҳ',   
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
function displayTreeMsg(name) {
	name = name || "tList";
	$('#'+name).datagrid('getPager').pagination( {
		beforePageText: '��',//ҳ���ı���ǰ��ʾ�ĺ���   
        afterPageText: 'ҳ �� {pages} ҳ',   
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
/**
 * �������ֹرմ���
 * @param {Object} name
 */
function closeWin(name,name2) {
	$('#'+name).window('close');
	if(name2!=undefined&&name2!=""&&name2!="")
	$('#'+name2).datagrid('clearSelections');;
}
function clearF(name)
{
	$('#'+name).form('clear');
}
/**
 * dateBox���ڸ�ʽ��
 * @param {Object} date
 * @return {TypeName} 
 */
function dateF(name)
		{
		$('#'+name).datebox( {
		colseText : '�ر�',
		currentText : '',
		okText : 'ȷ��',
		editable:false,
		width : 172,
		formatter : function(date) {
			return date.format('yyyy-MM-dd');
		}
	})
		}
function dateH(name)
		{
		$('#'+name).datebox( {
		colseText : '�ر�',
		currentText : '',
		okText : 'ȷ��',
		editable:false,
		width : 83,
		formatter : function(date) {
			return date.format('yyyy-MM-dd');
		}
	})
		}
/**
 * �Զ�����DataGrid��ֻ�ʺ���һά��ͷ��
 * @author lxt
 * @return
 */
function fitColumnToDataGrid(dg_id, col_id) {
	var options = $('#'+dg_id).datagrid('options');
	var colswidth = 0;
	var fcols = options.frozenColumns;
	var width = 0;
	for (var i=0; i < fcols.length; i++) {
		for (var j=0; j < fcols[i].length; j++) {
			width = fcols[i][j].width;
			if ('ck' == fcols[i][j].field) {
				colswidth += 30; 
				continue;
			}
			if (isNaN(width) || col_id == fcols[i][j].field) {
				continue;
			}
			colswidth += parseInt(width);
		}
	}
	fcols = options.columns;
	for (var i=0; i < fcols.length; i++) {
		for (var j=0; j < fcols[i].length; j++) {
			width = fcols[i][j].width;
			if ('ck' == fcols[i][j].field) {
				colswidth += 30; 
				continue;
			}
			if (isNaN(width) || col_id == fcols[i][j].field) {
				continue;
			}
			colswidth += parseInt(width);
		}
	}
	var fw = document.body.clientWidth-colswidth-50;
	$('#'+dg_id).datagrid('getColumnOption', col_id).width = fw;
	$('#'+dg_id).datagrid();displayMsg();
}

/**
 * ��ձ�
 * @param el_ids_arr	�����ֵ��Ԫ�ص�id���飨��ʱֻ������ͨԪ�أ�
 * @return
 */
function cleardetailform(el_ids_arr) {
	if (null == el_ids_arr || undefined == el_ids_arr || 0 == el_ids_arr.length) {
		$('#mForm_detail').form('clear');
		return;
	}
	var el_vals_arr = new Array();
	for (var i = 0; i < el_ids_arr.length; i++) {
		el_vals_arr[i] = $('#mForm_detail #' + el_ids_arr[i]).val();
	}
	$('#mForm_detail').form('clear');
	for (var i = 0; i < el_ids_arr.length; i++) {
		$('#mForm_detail #' + el_ids_arr[i]).val(el_vals_arr[i]);
	}
}

  /**
 * �Կ�ֵ��δ����ֵ��ת��
 * @param {Object} budget
 * @return {TypeName} 
 */
function decodeBudget(budget){
	if(budget==null||budget==""||budget==undefined||trim(budget)=='')
		return 0;
	else
		return budget;
}
/**
 * ���������ƽ�����Զ�ת����Ķ
 * @param {Object} id
 * @param {Object} obj
 */
function setMtoA(id,obj){
	$('#'+id).val(interceptNumber(decodeBudget(obj.value)*0.0015,4));
}
/**
 * ���������ƽ�����Զ�ת����Ķ
 * @param {Object} id
 * @param {Object} obj
 */
function setAtoM(id,obj){
	$('#'+id).val(interceptNumber(decodeBudget(obj.value)/0.0015,4));
}