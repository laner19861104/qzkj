<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	pageContext.setAttribute("path", request.getContextPath());
//response.setHeader("Pragma","No-cache"); 
//response.setHeader("Cache-Control","no-cache"); 
//response.setDateHeader("Expires", 0);
//  response.setCharacterEncoding("GBK");
String msg=(String)request.getAttribute("massge");

  
  
 
%>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�ޱ����ĵ�</title>
<link href="/zcxjngl/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="/zcxjngl/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="/zcxjngl/templates/js/createxmldoc.js" type="text/javascript"></script>
<script type="text/javascript">
//var tableidArray = new Array('table1');
//onloadEvent(showtable);
</script>
<script type="text/javascript">

function sAlert(str,myclosed){
	      title=document.createElement("h4");
	      msgObj=document.createElement("div");
	      bgObj=document.createElement("div");
            var msgw,msgh,bordercolor;
            msgw=400;//��ʾ���ڵĿ��
            msgh=100;//��ʾ���ڵĸ߶�
            titleheight=25 //��ʾ���ڱ���߶�
            bordercolor="#336699";//��ʾ���ڵı߿���ɫ
            titlecolor="#99CCFF";//��ʾ���ڵı�����ɫ
            
            var sWidth,sHeight;
            sWidth=document.body.offsetWidth;
            sHeight=screen.height;

           
            bgObj.setAttribute('id','bgDiv');
            bgObj.style.position="absolute";
            bgObj.style.top="0";
            bgObj.style.background="#777";
            bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
            bgObj.style.opacity="0.6";
            bgObj.style.left="0";
            bgObj.style.width=sWidth + "px";
            bgObj.style.height=sHeight + "px";
            bgObj.style.zIndex = "10000";
            document.body.appendChild(bgObj);
            
            
            msgObj.setAttribute("id","msgDiv");
            msgObj.setAttribute("align","center");
            msgObj.style.background="white";
            msgObj.style.border="1px solid " + bordercolor;
            msgObj.style.position = "absolute";
            msgObj.style.left = "50%";
            msgObj.style.top = "50%";
            msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
            msgObj.style.marginLeft = "-225px" ;
            msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
            msgObj.style.width = msgw + "px";
            msgObj.style.height =msgh + "px";
            msgObj.style.textAlign = "center";
            msgObj.style.lineHeight ="25px";
            msgObj.style.zIndex = "10001";
   
         
           title.setAttribute("id","msgTitle");
           title.setAttribute("align","right");
           title.style.margin="0";
           title.style.padding="3px";
           title.style.background=bordercolor;
           title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
           title.style.opacity="0.75";
           title.style.border="1px solid " + bordercolor;
           title.style.height="18px";
           title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
           title.style.color="white";
           title.style.cursor="pointer";
           if(myclosed){
             title.innerHTML="�ر�";
           title.onclick=function(){
                document.body.removeChild(bgObj);
                document.getElementById("msgDiv").removeChild(title);
                document.body.removeChild(msgObj);
                }
            }
           
           document.body.appendChild(msgObj);
           document.getElementById("msgDiv").appendChild(title);
           txt=document.createElement("p");
           txt.style.margin="1em 0"
           txt.setAttribute("id","msgTxt");
           txt.innerHTML=str;
           document.getElementById("msgDiv").appendChild(txt);
            }
         
          
      function  sAlertClose(){
                document.body.removeChild(bgObj);
                document.getElementById("msgDiv").removeChild(title);
                document.body.removeChild(msgObj);
                }
                 





function myFormCheck(theform)
		{
			
		   if(theform.uploadImage.value=="")
		     {
		        alert("���������ť��ѡ����Ҫ�ϴ����ļ�!")
		        theform.uploadImage.focus;
		      	return (false);
		     }
		    else
		     {
		    	sAlert("<img  src=\"/zcxjngl/templates/image/Loading.gif\" width=\"24\" height=\"24\" />���ݵ����У����Ժ�.......",false);
		        str= theform.uploadImage.value;
		        //strs=str.toLowerCase();
		       // alert(str);
		        lens=str.length;
		        extname=str.substring(lens-4,lens);
		       if(extname!=".xls")
		        {
		          alert("��ѡ��excel�ļ���")
		         return (false);
		        }
		     
		  
		       
		       		     }
		}



</script>

<%
if("1".equals(msg)){
	 %>  
		<script type="text/javascript">  alert('����ɹ�');</script>
		<%
}
if("2".equals(msg)){
	 %>  
		<script type="text/javascript">  alert('����ʧ��');</script>
		<%
}
%>

</head>

<body>
	<div class="position">��ǰλ�ã���Դ�������ݿ�ϵͳ  &gt;&gt;  ֱ��ϵͳ��Ϣ�ɼ�<br />
      <br />
    </div>
	
   
    
     <table width="60%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset>
          <legend>Excel���룺</legend>
           <form name="uploadform" action="/zcxjngl/InputExcel1" 
     enctype="multipart/form-data" method=post onsubmit="return myFormCheck(this)">
          <table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td >
                <input name="uploadImage" id="uploadImage" type="file" class="input_text" size="60" />
                
               </td>
             <td align="left" > 
             <input type="submit"  value="��  ��" />
          <%--      <a class="btn"  href="javascript:importtable();"><span class="search">��  ��</span></a>--%>
      </td></tr>
            </tr>
             <tr><td width="40%">&nbsp;</td>
             </tr>
             

          </table>
          </form>
        </fieldset></td>
      </tr>
    </table>
    

    
    <br />
    <br />
</body>
</html>
