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

<body >
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
		
			 <h2> �װ��� ${webuser.account}�����ã���ӭ�ؼң��ú�ѧϰ�ɣ� <a href="#">[�˳�]</a></h2>
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

<DIV class=er_text>
�װ��� ���޸ĳɹ���<a href="javascript:location.href='entryStuInfo.do'">���ظ�������</a>

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
