function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整   
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整 
}

//  数据加载		
$(function() {
	$('#areaname').combotree( {
		url : "getwfregiontree.action?lbbh=enterpriseqy"
	});
});

//    tab2查询方法




function openQuery()
{
	$('#query').window('open');
}
function search_validate()
{

	
//	if(!digCheck(ljzyywsrtbs)||!digCheck(ljzyywsrtbe))
//		{
//			alert("主营业务收入值必须为数字")
//			return false;
//		}
	var nd=$('#nd').val();
	var beginyd=$('#beginyd').val();
	var endyd=$('#endyd').val();
	var entercode=$('#entercode').val();
	var entername=$('#entername').val();
	if(nd==undefined||nd=="")
		{
		alert("年度不能为空!");
		return false;
		}
	if(beginyd==undefined||beginyd=="")
		{
		alert("开始月度不能为空!");
		return false;
		}
	if(endyd==undefined||endyd=="")
		{
		alert("结束月度不能为空!");
		return false;
		}
//	if(entercode==undefined||entercode=="")
//		{
//		alert("企业名称不能为空!");
//		return false;
//		}
//		if(entername==undefined||entername=="")
//		{
//		alert("企业名称不能为空!");
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
	//$('#bq').text(beginTime+" 月份 至"+endTime+' 月份 全市规模以上工业企业主要经济效益月度情况表 （单位：万元）');	  
	var url="queryJnlyj.action?nd="+nd+"&beginyd="+beginyd+"&endyd="+endyd;
		var disStr="";
		disStr+=nd+"年 "+beginyd+"月-"+endyd+"月 ";
		if(hyname!=""&&hyname!=null)
		disStr+=" 行业名称:" + hyname;
		if(areanamecode!=""&&areanamecode!=null)
			{
			disStr+=" 区域名称: "+areaname;
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
