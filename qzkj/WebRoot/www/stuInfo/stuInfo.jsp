<%@ page language="java" import="java.util.*" pageEncoding="gb2312"   contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK2312" />
<meta http-equiv="x-ua-compatible" content="ie=7" /> 
<title>������Ϣ</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/geren.css" rel="stylesheet" type="text/css" />
<link href="css/index_01.css" rel="stylesheet" type="text/css" />

<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<script src="js/datepicker.js" type="text/javascript"></script>
<script src="js/city.js" type="text/javascript"></script>
</head>

<body onload="init('${webuser.birthday}')">
	<div id="ren_top"> 
    	<div id="menu_1">
       		<ul>
            	<li><a href="#">ְҵ����</a></li>
                <li><a href="#">ְҵ����</a></li>
                <li><a href="#">ְҵ����</a></li>
                <li><a href="#">ְҵ����</a></li>
                <li><a href="#">ְҵ����</a></li>
              
            </ul>	
        
      </div><!--menu����-->
         <div class="menu_right">
         	<ul>
            	<li><a href="index.do">��ҳ</a></li>
                <li><a href="entryStuInfo.do">����</a></li>
                <li><a href="#">����</a></li>
                <li><a href="entryAccount.do">�˻�</a></li>
                <li><a href="javascript:location.href='reLogin.do'">�˳�</a></li>
              
            </ul>
         </div> 
        
        
        
        
        
        
        
      
    
    
    
    </div><!--ren_top����-->
    
    <div class="clear mt8"></div>
      
       
	
    
    
    <div id="main"><!--�м俪ʼ-->
    		<div class="position">
		
			 <h2> �װ��� ${webuser.account}�����ã���ӭ�ؼң��ú�ѧϰ�ɣ�<a href="javascript:location.href='reLogin.do'">[�˳�]</a></h2>
             <div class="search">
        	<select name="">
        	  <option value="�γ�">�γ�</option>
        	</select>
        	<input name="" type="text" style="height:18px;"/>
        <img src="images/19.gif" width="43" alt="����" style="margin-top:3px;"/></div><!--search����-->
		   </div> <!--end position-->
            <div class="clear mt8"></div>
           
           <table width="960" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                    <fieldset >
                    	<div class="w200">
                        	<DIV class=left_menu_fu>
<DIV class=text>
<DIV class=din>
<UL>
  <LI><IMG src="images/nav_21.gif"><A 
  href="#" target=_blank>��������</A></LI>
  <LI><IMG src="images/nav_11.gif"><A 
  href="#">˰��/��ƻ�Ա</A></LI>
  <LI><IMG src="images/nav_15.gif"><A 
  href="#" target=_blank>�������ר��</A></LI>
  <LI><IMG src="images/nav_07.gif"><A 
  href="#" target=_blank>ÿ��һ��</A></LI>
  <LI><IMG src="images/nav_08.gif"><A 
  href="#">���ķ���</A></LI>
  <LI><IMG src="images/nav_09.gif"><A 
  href="#" 
  target=_blank>�����ܿ�</A></LI>
  <LI><IMG src="images/nav_19.gif"><A 
  href="#" 
  target=_blank>����˰��Ѷ���¿�</A></LI>
  <LI><IMG src="images/nav_18.jpg"><A 
  href="#" target=_blank>��ʦ������</A></LI>
  <LI><IMG src="images/nav_10.gif"><A 
  href="#" 
  target=_blank>����֧��</A></LI>
  <LI><IMG src="images/liwu.gif"><A 
  href="#">��У���ͻ</A></LI>
  <LI><IMG src="images/nav_18.jpg"><A onclick=tzzhuye(); 
  href="#">�߻����İ�</A></LI>
  <SCRIPT>
			         function tzzhuye(){
			        	 alert("���,�㻹û��ѡ�β��ܲ�������ܣ�");
			      }
			</SCRIPT>
</UL></DIV><!-- 
          <div class="tian">
            <a href="http://java.chinaacc.com/usercenter/tjzj.shtml"><img src="/images/userhome/01/tian.gif" />������</a>
          </div>  --></DIV>
<DIV class=zxkf><img src="images/zxkf.jpg" width="154" height="126" alt="���пͷ�" /></DIV>
<DIV class=zxkf><IMG 
src="images/left_menu_dpic.gif"></DIV></DIV>
                        
                        
                        
                        </div><!--w200����-->
                        <div class="w730">
                    
                            <div class="w521">
                            	<DIV class=main_box>
<DIV class=er_title>
<DIV class=biao>�ҵ����<span><a href="#">������ҳ</a></span></DIV>
</DIV>
<DIV class=er_text>

  <div id="TabbedPanels1" class="TabbedPanels">
    <ul class="TabbedPanelsTabGroup">
      <li class="TabbedPanelsTab" tabindex="0">���������޸�</li>
      <li class="TabbedPanelsTab" tabindex="0">�����޸�</li>
      <li class="TabbedPanelsTab" tabindex="0">�ǳ��޸�</li>
    </ul>
    <div class="TabbedPanelsContentGroup">
      <div class="TabbedPanelsContent">
      	<DIV class=wdzh>
<DIV class=zan_w>Ϊ��֤���ĺϷ�Ȩ�棬�������д���¾�������ϸ����ʵ������Ϣ����Ҫ���ڣ�<BR>���� �����붪ʧ�����ȷ�ϣ�<BR>���� 
����У��ѧ��ȷ�ϣ�<BR>���� ����У<A class=link_lan href="http://member.chinaacc.com/shop/" 
target=_blank>�ƻ����</A>�����������ʹ��ȡ��� </DIV>
<DIV class="wdzl mt_10">
<DIV class=wdzl_tit>ע����Ϣ�޸� </DIV>
<DIV class=wdzl_txt>
<DIV class=to>
<form id="form1" method="post" action="userEdit.do">
<DIV class=name>��ʵ������</DIV>
<DIV class=tc><INPUT class=input_zl value='${webuser.username}' maxLength=18 size=20 type=text 
name=wuser.username></DIV></DIV>
<DIV class=to>
<DIV class=name>Email��</DIV>
<DIV class=tc><INPUT id=email class=input_zl maxLength=50 value='${webuser.email}' size=40 type=text 
name=wuser.email></DIV></DIV>
<DIV class=to>
<DIV class=name>QQ���룺</DIV>
<DIV class=tc><INPUT id=qq class=input_zl maxLength=50 size=40 type=text value="${webuser.qq}"
name=wuser.qq></DIV></DIV>
<DIV class=to>
<DIV class=name>��&nbsp;&nbsp;&nbsp;&nbsp;��</DIV>
<DIV class=tc>
<c:if test="${webuser.sex=='Ů'}">
<INPUT value=Ů type=radio checked name=wuser.sex>Ů <INPUT value=��  type=radio name=wuser.sex>�� 
</c:if>
<c:if test="${webuser.sex=='��'}">
<INPUT value=Ů type=radio  name=wuser.sex>Ů <INPUT value=��  type=radio checked name=wuser.sex>�� 
</c:if>
</DIV></DIV>
<DIV class=to>
<DIV class=name>�������ڣ�</DIV>
<DIV class=tc>
<select id="year1"  name=year></select>�� 
<select id="month1" name=month onchange="selectedMonth(form1.month1.value,this.value)"></select>��
<select id="date1"  name=date></select> �� 
 </DIV></DIV>
<DIV class=to>
<DIV class=name>��ס������</DIV>
<DIV class=tc><SELECT onchange="areaMap.city(this.value)" id="province" name=wuser.province></SELECT>ʡ��ֱϽ�У� 
<SELECT id=city name=wuser.city> </SELECT>�У������� </DIV></DIV>
<script>
		var areaMap = new AreaMap('province','city');
		var province='${webuser.province}';
		var city='${webuser.city}';
		if(province=="")
		{
        areaMap.province('��ѡ��ʡ����','��ѡ�������');
        }
		else
		{
		areaMap.province(province,city);
		}
</script>
<DIV class=to>
<DIV class=name>�����̶ȣ�</DIV>
<DIV class=tc><SELECT name=wuser.edulv>
<OPTION ${webuser.edulv=='1'?'selected':''} value=1>��ר����</OPTION> 
<OPTION ${webuser.edulv=='2'?'selected':''} value=2>��ר</OPTION>
<OPTION ${webuser.edulv=='3'?'selected':''} value=3>����</OPTION>
<OPTION ${webuser.edulv=='4'?'selected':''} value=4>��������</OPTION>
</SELECT></DIV></DIV>
<DIV class=to>
<DIV class=name>���֤�ţ�</DIV>
<DIV class=tc><INPUT id=cardID value="${webuser.id}" class=input_zl maxLength=18 size=20 type=text 
name=wuser.id></DIV></DIV>
<DIV class=to>
<DIV class=name>������λ��</DIV>
<DIV class=tc><INPUT class=input_zl value="${webuser.workFor}" maxLength=120 size=40 type=text 
name=wuser.workFor></DIV></DIV>
<DIV class=to>
<DIV class=name>ͨ�ŵ�ַ��</DIV>
<DIV class=tc><INPUT class=input_zl maxLength=120 value="${webuser.postAddress}" size=40 type=text 
name=wuser.postAddress></DIV></DIV>
<DIV class=to>
<DIV class=name>�������룺</DIV>
<DIV class=tc><INPUT id=zipCode value="${webuser.postNo}" class=input_zl maxLength=6 size=20 type=text 
name=wuser.postNo></DIV></DIV>
<DIV class=to>
<DIV class=name>�ֻ����룺</DIV>
<DIV class=tc><INPUT class=input_zl value="${webuser.tel}" maxLength=50 size=20 
type=text name=wuser.tel> <SPAN class=font_12><FONT class=color_cheng>*</FONT> 
ǿ�ҽ�����������д�ֻ����룬�Ա�����Ϊ�����Ϳ����������ʾ���ţ�</SPAN></DIV></DIV>
<DIV class=to>
<DIV class=name>������ʣ�</DIV>
<DIV class=tc>
<INPUT value=1 ${fn:indexOf(webuser.proSkill,'1')>-1?'checked':''} type=checkbox name=proSkill> ����ְ��&nbsp;&nbsp; 
<INPUT value=2 ${fn:indexOf(webuser.proSkill,'2')>-1?'checked':''} type=checkbox name=proSkill> �м�ְ��&nbsp;&nbsp; 
<INPUT value=3 ${fn:indexOf(webuser.proSkill,'3')>-1?'checked':''} type=checkbox name=proSkill> �߼�ְ��<BR>
<INPUT value=4 ${fn:indexOf(webuser.proSkill,'4')>-1?'checked':''} type=checkbox name=proSkill> ע����ʦ
<INPUT value=5 ${fn:indexOf(webuser.proSkill,'5')>-1?'checked':''} type=checkbox name=proSkill> ע������ʦ 
<INPUT value=6 ${fn:indexOf(webuser.proSkill,'6')>-1?'checked':''} type=checkbox name=proSkill> ע��˰��ʦ 
</DIV></DIV>
<DIV class="tong input_gg"></DIV>
<DIV class=to>
<DIV class=name>��&nbsp;֤&nbsp;�룺</DIV>
<DIV class=tc><INPUT id=check class=input_zl onfocus=this.select() 
onmouseover=this.focus() onMouseOut="if(this.value=='')this.value='�������Ҳ�����';" 
onclick="if(this.value=='�������Ҳ�����')this.value=''" value=�������Ҳ����� maxLength=4 
size=15 type=text name=verifycode> 
<img name="verifyCodeImg"  src="/qzkj/VerifyCodeServlet.action" style="cursor:hand" align="top" onClick="javascript:changeVerifyCode(this)"/>
 <SPAN class=font_12><FONT 
class=color_cheng>*</FONT> ���ͼƬˢ����֤�� <FONT class=color_cheng>*</FONT></SPAN> 
</DIV></DIV>
<DIV class=to>
<DIV class=name>��</DIV>
<DIV class=tc>
<A href="javascript:if(checkdata()){document.getElementById('form1').submit();}"><IMG src="images/tj2.gif"></A> 
<A href="javascript:document.getElementById('memberform').reset();"><IMG src="images/cz2.gif"></A> 
</DIV></DIV></DIV></DIV></DIV>
 </form>     
      
      
 
      
      
      
      
      
      
      
 <form id="form2" method="post" action="upwpwd.do">     
      </div>
      <div class="TabbedPanelsContent">
      	<DIV class=wdzh>
<DIV class=zan_w>Ϊ�����ĸ����ʻ���ȫ�����������ڸ����������룡</DIV>
<DIV class="wdzl mt_10">
<DIV class=wdzl_tit>�޸�����</DIV>
<DIV class=wdzl_txt>
<DIV class=to>
<DIV class=name>�����룺</DIV>
<DIV class=tc><INPUT id=oldPwd class=input_zl tabIndex=1 size=20 
type=password name=oldPwd> ����д��ȷ�ľ����� </DIV></DIV>
<DIV class="tong input_gg"></DIV>
<DIV class=to>
<DIV class=name>�����룺</DIV>
<DIV class=tc><INPUT id=newPwd class=input_zl tabIndex=2 
onkeyup=chkpassw(value.length) size=20 type=password name=newPwd> 
��4��15λ���ֺ���ĸ���</DIV></DIV>
<DIV class=to>
<DIV class=name>ȷ�������룺</DIV>
<DIV class=tc><INPUT id=newPassword1 class=input_zl tabIndex=3 
onkeyup=chkpassw(value.length) size=20 type=password name=newPwd1> 
�ظ�����������</DIV></DIV>
<DIV class=to>
<DIV class=name>��</DIV>
<DIV class=tc><A 
href="javascript:if(checkPasswordData()){document.getElementById('form2').submit();}"><IMG 
src="images/tj2.gif"></A> ����<A 
href="javascript:document.getElementById('passwd').reset();"><IMG 
src="images/cz2.gif"></A>
</DIV></DIV></DIV></DIV></DIV>
      
      
    </form>  
      
      
      
      
      
      
      
      
      
      </div>
       <div class="TabbedPanelsContent">
       		<DIV class=wdzh>
<TABLE style="MARGIN-TOP: 15px" class=backcolor3 border=0 cellSpacing=1 
cellPadding=6 width=700 align=center>
  <TBODY>
  <TR>
    <TD class=backcolor8>
      <FORM id=uploadForm method=post name=iconform 
      action=/myhome/myInfo/updateUsericon.shtm>
      <TABLE border=0 cellSpacing=0 cellPadding=0 width=600 align=center>
        <TBODY>
        <TR>
          <TD style="PADDING-BOTTOM: 10px; PADDING-TOP: 10px" class=font14 
          height=40>�ҵ��ǳƣ�<LABEL> <INPUT id=nickName maxLength=16 type=text 
            name=nickName> <INPUT id=nickName_old type=hidden name=nickName_old> 
            <INPUT id=nickName_old 
            value=http://img.cdeledu.com/ADVC/2009/1119/1258620743934-0.jpg 
            type=hidden name=newicon_old> </LABEL></TD></TR>
        <TR>
          <TD style="PADDING-BOTTOM: 10px; PADDING-TOP: 10px" class=font14 
          height=80>����ͷ�� <IMG 
            style="BORDER-BOTTOM: #dddddd 1px solid; BORDER-LEFT: #dddddd 1px solid; PADDING-BOTTOM: 2px; PADDING-LEFT: 2px; PADDING-RIGHT: 2px; BORDER-TOP: #dddddd 1px solid; BORDER-RIGHT: #dddddd 1px solid; PADDING-TOP: 2px" 
            id=usericon src="images/man1.gif" width=111 
            height=111><INPUT id=iconUrl type=hidden name=iconUrl></TD></TR>
        <TR>
           <TD class=font14 height=40>
          �ϴ��ؼ�
          
          
          </TD></TR>
        <TR>
          <TD height=50><LABEL><SPAN><A 
            href="javascript:document.getElementById('uploadForm').submit();"><IMG 
            src="images/bcsz.gif"></A> <INPUT value=1 type=hidden 
            name=s> <INPUT type=hidden name=classid> <INPUT value=31259736 
            type=hidden name=uid> <INPUT value=zhujiang0006 type=hidden 
            name=userName> <INPUT type=hidden name=userID> 
        </SPAN></LABEL></TD></TR></TBODY></TABLE></FORM></TD></TR></TBODY></TABLE></DIV>
       
       
       
       
       
       </div>
    </div>
  </div>
</DIV></DIV>
                            
                            </div><!--w521����-->
                    
                    
                    		
                    
                    
                   	  </div><!--w730����-->
                    
                    
                    
                    
                    </fieldset>
                    
                    
                    
                    
                    
                    
                    </td>
                  </tr>
      </table>

           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
    
    
	</div><!--�м俪ʼ����-->
    
    <div class="clear mt8"></div>
<div id="foot">
    	<p>��Ȩ���У�Ϋ�������ɹ�<br>
            ����֧�֣�Ϋ���в��ſƼ����޹�˾
        </p>
    
    
    
    </div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
    </script>
</body>
</html>
