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
		$("#hyname").combotree({
		url : "getWfhyTree.action?lbbh=enterpriseqy",
		width:100
		});
});

//    tab2��ѯ����


function search_validate()
{

	
var zbselecttext=$('#zbselecttext').val();
if(zbselecttext=="")
	{
	alert("ָ��ѡ����Ϊ��!")
	return false;
	}
	

	return true;
}
function q2_search() {
	
	if(!search_validate())
		return;
	
	var nds=$('#nds').val();
	var nde=$('#nde').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entername=$('#entername').val();
	var hytype=$('#hytype').val();
	var reg=new RegExp("%","g");
	var zbselecttext=$('#zbselecttext').val();
	zbselecttext=zbselecttext.replace(reg,'@');
	var hyname=$('#hyname').combotree('getValues');
	var areanamecode=$('#areaname').combotree('getValues');
	var bname=$('#dybid').val();
	var url="queryYear.action?nds="+nds+"&nde="+nde+"&bname="+bname+"&hytype="+hytype;
	if(areanamecode!=""&&areanamecode!=null)
		url+="&areanamecode="+areanamecode
	if(entername!=null&&entername!="")
		url+="&entername="+encodeURIComponent(encodeURIComponent($('#entername').val()))
	if(zbselecttext!=null&&zbselecttext!="")
		{
		url+="&zbselecttext="+encodeURIComponent(encodeURIComponent(zbselecttext));
		}
	if(hyname!=null&&hyname!="")
		{
		url+="&hyname="+encodeURIComponent(encodeURIComponent(hyname));
		}
		document.getElementById("disFrame").src=url;
		$('#query').window('close');
}
function q2_export() {
	
	if(!search_validate())
		return;
	
	var nds=$('#nds').val();
	var nde=$('#nde').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entername=$('#entername').val();
	var hytype=$('#hytype').val();
	var reg=new RegExp("%","g");
	var zbselecttext=$('#zbselecttext').val();
	zbselecttext=zbselecttext.replace(reg,'@');
	var hyname=$('#hyname').combotree('getValues');
	var areanamecode=$('#areaname').combotree('getValues');
	var bname=$('#dybid').val();
	var url="yearExport.action?nds="+nds+"&nde="+nde+"&bname="+bname+"&hytype="+hytype;
	if(areanamecode!=""&&areanamecode!=null)
		url+="&areanamecode="+areanamecode
	if(entername!=null&&entername!="")
		url+="&entername="+encodeURIComponent(encodeURIComponent($('#entername').val()))
	if(zbselecttext!=null&&zbselecttext!="")
		{
		url+="&zbselecttext="+encodeURIComponent(encodeURIComponent(zbselecttext));
		}
	if(hyname!=null&&hyname!="")
		{
		url+="&hyname="+encodeURIComponent(encodeURIComponent(hyname));
		}
		document.getElementById("disFrame").src=url;
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



