function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ������� 
}

//  ���ݼ���		
$(function() {
		$('#areaname').combotree( {
		url : "getwfregiontree.action?lbbh=enterpriseqy",
		width:144
	});
		$("#hyname").combotree({
		url : "getWfhyTree.action?lbbh=enterpriseqy",
		width:100
		});
});

//    tab2��ѯ����




function openQuery()
{
	$('#query').window('open');
}
function search_validate()
{

	
//	if(!digCheck(ljzyywsrtbs)||!digCheck(ljzyywsrtbe))
//		{
//			alert("��Ӫҵ������ֵ����Ϊ����")
//			return false;
//		}
	var nd=$('#nd').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entercode=$('#entercode').val();
	var entername=$('#entername').val();
	if(nd==undefined||nd=="")
		{
		alert("��Ȳ���Ϊ��!");
		return false;
		}
	if(beginyd==undefined||beginyd=="")
		{
		alert("��ʼ�¶Ȳ���Ϊ��!");
		return false;
		}
	if(endyd==undefined||endyd=="")
		{
		alert("�����¶Ȳ���Ϊ��!");
		return false;
		}
//	if(entercode==undefined||entercode=="")
//		{
//		alert("��ҵ���Ʋ���Ϊ��!");
//		return false;
//		}
		if((entername==undefined||entername=="")&&$('#areaname').combotree('getValues')=="")
		{
		alert("��ҵ���ƻ��������Ʊ�����д����һ��!");
		return false;
		}
	return true;
}
function q2_search() {
	
	if(!search_validate())
		return;
	
	var nd=$('#nd').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entername=$('#entername').val();
	var hytype=$('#hytype').val();
	var hycode=$('#hycode').val();
	var areanamecode=$('#areaname').combotree('getValues');
	var hyname=$('#hyname').combotree('getValues');
	//$('#bq').text(beginTime+" �·� ��"+endTime+' �·� ȫ�й�ģ���Ϲ�ҵ��ҵ��Ҫ����Ч���¶������ ����λ����Ԫ��');	  
	var url="queryJnyj.action?nd="+nd+"&beginyd="+beginyd+"&endyd="+endyd+"&hytype="+hytype;
	if(areanamecode!=""&&areanamecode!=null)
		url+="&areanamecode="+areanamecode
	if(entername!=null&&entername!="")
		url+="&entername="+encodeURIComponent(encodeURIComponent($('#entername').val()))
		if(hyname!=null&&hyname!="")
		{
		url+="&hyname="+encodeURIComponent(encodeURIComponent(hyname));
		}
//	var disStr="";
//		disStr+=nd+"�� "+beginyd+"��-"+endyd+"�� ��ҵ����: "+entername;
//		if(hyname!=""&&hyname!=null)
//		disStr+=" ��ҵ����:" + hyname;
//		$('#disQuery').text(disStr);
		document.getElementById("disFrame").src=url;
		$('#query').window('close');
}
function goClear()
{
	$('#ff').form('clear');
}
function close_query()
{
	$('#query').window('close');
}
function onChangeValue()
{
	var value=$('#hytype').val();
	if(value=="1")
		{
		document.getElementById("hytype").style.width="75px";
		$("#hyname").combotree({
		url : "getWfhyTree.action",
		width:100
		});
		}else
			{
			document.getElementById("hytype").style.width="75px";
			$("#hyname").combotree('disable');
			}
}