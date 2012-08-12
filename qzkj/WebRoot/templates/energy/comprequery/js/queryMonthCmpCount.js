function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整 
}

//  数据加载		
$(function() {
		$('#areaname').combotree( {
		url : "getwfregiontree.action?lbbh=enterpriseqy",
		width:139
		});
		$("#hyname").combotree({
		url : "getWfhyTree.action?lbbh=enterpriseqy",
		width:100
		});
});

//    tab2查询方法


function search_validate()
{

	
var zbselecttext=$('#zbselecttext').val();
if(zbselecttext=="")
	{
	alert("指标选择不能为空!")
	return false;
	}
	

	return true;
}
function q2_search() {
	
//	if(!search_validate())
//		return;
//	
//	var nd=$('#nd').val();
//	var beginyd=$('#beginyd').val();
//	var endyd=$('#endyd').val();
//	var entername=$('#entername').val();
//	var hytype=$('#hytype').val();
//	var reg=new RegExp("%","g");
//	var zbselecttext=$('#zbselecttext').val();
//	zbselecttext=zbselecttext.replace(reg,'@');
//	var areanamecode=$('#areaname').combotree('getValues');
//	var hyname=$('#hyname').combotree('getValues');
//	var bname=$('#dybid').val();
//	var url="queryMonth.action?nd="+nd+"&bname="+bname+"&hytype="+hytype+"&beginyd="+beginyd+"&endyd="+endyd;
//	if(areanamecode!=""&&areanamecode!=null)
//		url+="&areanamecode="+areanamecode
//	if(entername!=null&&entername!="")
//		url+="&entername="+encodeURIComponent(encodeURIComponent($('#entername').val()))
//	if(zbselecttext!=null&&zbselecttext!="")
//		{
//		url+="&zbselecttext="+encodeURIComponent(encodeURIComponent(zbselecttext));
//		}
//	if(hyname!=null&&hyname!="")
//		{
//		url+="&hyname="+encodeURIComponent(encodeURIComponent(hyname));
//		}
//		document.getElementById("disFrame").src=url;
//		$('#query').window('close');
	alert($)



}
function q2_export() {
	
	if(!search_validate())
		return;
	
	var nd=$('#nd').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entername=$('#entername').val();
	var hytype=$('#hytype').val();
	var reg=new RegExp("%","g");
	var zbselecttext=$('#zbselecttext').val();
	zbselecttext=zbselecttext.replace(reg,'@');
	var areanamecode=$('#areaname').combotree('getValues');
	var hyname=$('#hyname').combotree('getValues');
	var bname=$('#dybid').val();
	var url="monthExport.action?nd="+nd+"&bname="+bname+"&hytype="+hytype+"&beginyd="+beginyd+"&endyd="+endyd;
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



