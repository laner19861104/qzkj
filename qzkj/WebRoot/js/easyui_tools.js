/**
 * �Զ���ȡ����������ƴд��ѯ���� Ĭ������Ϊ��idΪ"s_"��ͷ��
 * @param {Object} xp jQueryѡ�����ı��ʽ ����"[id^='s_']"
 * @return {TypeName} conditions=
 */
function appCondition(xp)
{
	var str="";
		$(xp==undefined?"[id^='s_']":xp)
			.each(
					function(i, a) {
						if ($("#" + a.id).attr("class") != undefined) {
							if ($("#" + a.id).attr("class").indexOf(
									'easyui-datebox') != -1) {
								if ($("#" + a.id).datebox('getValue') != "")
									str += "," + a.name + "|"
											+ $("#" + a.id).datebox('getValue');
							} else if ($("#" + a.id).attr("class").indexOf(
									'easyui-numberbox') != -1) {
								if ($("#" + a.id).numberbox('getValue') != "")
									str += ","
											+ a.name
											+ "|"
											+ $("#" + a.id).numberbox(
													'getValue');
							} else if ($("#" + a.id).attr("class").indexOf(
									'combotree') != -1) {
								if ($("#" + a.id).combotree('getValues') != "")
									str += ","
											+ a.name
											+ "|"
											+ $("#" + a.id).combotree(
													'getValues');
							} else if ($("#" + a.id).attr("class").indexOf(
									'easyui-combobox') != -1) {
								if ($("#" + a.id).combobox('getValues') != "")
									str += ","
											+ a.name
											+ "|"
											+ $("#" + a.id).combobox(
													'getValues');
							} else if ($("#" + a.id).attr("class").indexOf(
									'easyui-combogrid') != -1) {
								if ($("#" + a.id).combogrid('getValues') != "")
									str += ","
											+ a.name
											+ "="
											+ $("|" + a.id).combogrid(
													'getValues');
							} else {
								if ($("#" + a.id).val() != "")
									str += "," + a.name + "|"
											+ $("#" + a.id).val();
							}

						} else {
							if ($("#" + a.id).val() != "")
								str += "$" + a.name + "|" + $("#" + a.id).val();
						}

					});
		return "conditions=1|1"+encodeURIComponent(encodeURIComponent(str));
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
			var sN=key+name;
		else
			var sN=key
         ��//��alert("key��"+key+",value��"+json[key]); 
				if ($("#" + key).attr("class") != undefined) {
							if ($("#" + sN).attr("class").indexOf(
									'easyui-datebox') != -1) {
								$("#" + sN).datebox('setValue',json[key]);
									
							} else if ($("#" + key).attr("class").indexOf(
									'easyui-numberbox') != -1) {
								$("#" + sN).numberbox('setValue',json[key]);
									
							} else if ($("#" + key).attr("class").indexOf(
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
	return document.body.clientHeight * percent; //����������Լ�������   
}
/**
 * �޸�datagridҳ�ŵ���ʾ��ʽ
 * @param {Object} name
 */
function displayMsg(name) {
	$('#'+name).datagrid('getPager').pagination( {
		displayMsg : '��ǰ��ʾ��{from}��{to}��{total}��¼'
	});
}
/**
 * �������ֹرմ���
 * @param {Object} name
 */
function closeWin(name) {
	$('#add').window('close');
}


