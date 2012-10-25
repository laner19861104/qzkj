function getPayRecord(page)
{
	var url="queryPayRecord.action";
	$('#plist').html('加载中……');
	$.ajax( {
				type : "POST",
				url : "/qzkj/queryPayRecord.do",
				data : "page=" +page+'&rows=10'+'&conditions=$status-userAccount|'+account+'$orderby|payDate|desc',
				dataType : "json",
				cache : false,
				success : function callback(msg) {
				var str='';
				var fstr='';
				if(msg.rows.length>0)
				{
					for(var i=0;i<msg.rows.length;i++)
					{
					str+='<DIV class=bt>'
               	    str+='<DIV class=fp_box01>'+msg.rows[i].uuid+'</DIV>'
                    str+='<DIV class="fp_box02 text_center">'+msg.rows[i].money+'</DIV>'
                    str+='<DIV class="fp_box02 text_center">'+msg.rows[i].payDate+'</DIV>'
                    str+='<DIV class="fp_box02 text_center">成功</DIV>'
                    str+='<DIV class="fp_box02 text_center">银行转账</DIV>'
                    str+='</DIV>'
					}
					var pages=msg.total<10?1:Math.ceil(msg.total/10);
					fstr+="<a href='javascript:paypre("+(page-1)+",getPayRecord)'>上一页</a>&nbsp;第"
					for(var j=1;j<=pages;j++)
						{
						if(j==page)
						fstr+=j+"&nbsp;";
						else
							fstr+="<a href='javascript:getPayRecord("+j+")'>"+j+"</a>&nbsp;"
						}
					fstr+="页&nbsp;<a href='javascript:paynext("+(page+1)+","+pages+",getPayRecord)'>下一页</a>";
				}else
					{
					str+=' <DIV class="zan_w mt_10">您好，暂无记录！</DIV>';
					}
				 
				 $('#plist').html(str);
				 $('#pfoot').html(fstr);
				}
			});
}
function paypre(page,fn)
{
	if(page<1)
		return ;
	fn(page);
}
function paynext(page,pages,fn)
{
	if(page>pages)
		return ;
	fn(page);
}


function getConRecord(page)
{
	var url="queryConsumptionRecord.do";
	$('#conlist').html('加载中……');
	$.ajax( {
				type : "POST",
				url : url,
				data : "page=" +page+'&rows=10'+'&conditions=$status-userAccount|'+account+'$orderby|conDate|desc',
				dataType : "json",
				cache : false,
				success : function callback(msg) {
				var str='';
				var fstr='';
				if(msg.rows.length>0)
				{
					for(var i=0;i<msg.rows.length;i++)
					{
					str+='<DIV class=bt>'
               	   	str+='<DIV class=jf_box02>'+msg.rows[i].uuid+'</DIV>'
                    str+='<DIV class=jf_box01>'+msg.rows[i].typename+'</DIV>'
                    str+='<DIV class="jf_box02 text_center">'+msg.rows[i].money+'</DIV>'
                    str+='<DIV class="jf_box02 text_center">'+msg.rows[i].conDate+'</DIV>'
                    str+='</DIV>'
					}
					var pages=msg.total<10?1:Math.ceil(msg.total/10);
					fstr+="<a href='javascript:paypre("+(page-1)+",getConRecord)'>上一页</a>&nbsp;第"
					for(var j=1;j<=pages;j++)
						{
						if(j==page)
						fstr+=j+"&nbsp;";
						else
							fstr+="<a href='javascript:getPayRecord("+j+")'>"+j+"</a>&nbsp;"
						}
					fstr+="页&nbsp;<a href='javascript:paynext("+(page+1)+","+pages+",getConRecord)'>下一页</a>";
				}else
					{
					str+=' <DIV class="zan_w mt_10">您好，暂无记录！</DIV>';
					}
				 
				 $('#conlist').html(str);
				 $('#confoot').html(fstr);
				}
			});
}
