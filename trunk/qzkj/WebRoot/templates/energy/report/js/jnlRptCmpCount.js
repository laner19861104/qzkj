function fixWidth(percent) {
	return document.body.clientWidth * percent; //����������Լ�������   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //����������Լ������� 
}

//  ���ݼ���		
$(function() {
	$('#areaname').combotree( {
		url : "getwfregiontree.action?lbbh=enterpriseqy"
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
//		if(entername==undefined||entername=="")
//		{
//		alert("��ҵ���Ʋ���Ϊ��!");
//		return false;
//		}
	return true;
}
function q2_search() {
	
	if(!search_validate())
		return;
	
	var nd=$('#nd').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entername=$('#entername').val();
	var hyname=$('#hyname').val();
	var hycode=$('#hycode').val();
	var areanamecode=$('#areaname').combotree('getValues');
	var areaname=$('#areaname').combotree('getText');
	//$('#bq').text(beginTime+" �·� ��"+endTime+' �·� ȫ�й�ģ���Ϲ�ҵ��ҵ��Ҫ����Ч���¶������ ����λ����Ԫ��');	  
	var url="queryJnlyj.action?nd="+nd+"&beginyd="+beginyd+"&endyd="+endyd;
		var disStr="";
		disStr+=nd+"�� "+beginyd+"��-"+endyd+"�� ";
		if(hyname!=""&&hyname!=null)
		disStr+=" ��ҵ����:" + hyname;
		if(areanamecode!=""&&areanamecode!=null)
			{
			disStr+=" ��������: "+areaname;
			url+="&areanamecode="+areanamecode
			}
		$('#disQuery').text(disStr);
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
