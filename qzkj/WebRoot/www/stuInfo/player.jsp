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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" /> 
<title>���������ѵ��У-��Ƶ����</title>
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/shipin.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div id="topflash"> 
    	<div class="btn">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="images/btn_03.jpg" width="58" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_05.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_07.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_09.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_11.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
    <td><img src="images/btn_13.jpg" width="57" height="46" alt="���߿ͷ�" /></td>
  </tr>
</table>

        
        
        
        
        
        </div><!--btnx����-->
    
    
    
    </div><!--topflash����-->
    
    <div class="clear"></div>
      
      <div id="menu">
		<ul>
		  <li><a href="index.html">��ҳ</a></li>
			<li><a href="list.html?a=������̬" rel="dropmenu1">�����γ�</a></li>
			<li><a href="list.html?a=���߷���" rel="dropmenu2">�����γ�</a></li>
			<li><a href="zhongbiao.html?a=�б깫��" rel="dropmenu3">��ֵ����</a></li>
		</ul>
        
        <div class="search">
        	<select name="">
        	  <option value="�γ�">�γ�</option>
        	</select>
        	<input name="" type="text" />
        <img src="images/19.gif" width="43" height="20" alt="����" /></div><!--search����-->
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    
    
    
    <div id="main"><!--�м俪ʼ-->
    		<div class="position">
		
			 <h1> ����λ�ã���ҳ>>��Ƶ</h1>
		   </div> <!--end position-->
           <div class="clear mt8"></div>
           <table width="960" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td> 
                    <fieldset >
          				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
                              <tr>
                                <td width="9%"  VALIGN="top" align="left">
                                	

                           <table width="61" border="0" cellspacing="0" cellpadding="0"  class="shi_img">
                                          <tr>
                                            <td ><img src="images/s_09.jpg" width="60" height="61" alt="�γ�Ŀ¼" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_11.jpg" width="60" height="61" alt="��������" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_19.jpg" width="60" height="61" alt="�γ̽���" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_20.jpg" width="60" height="61" alt="��������" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_23.jpg" width="60" height="61" alt="�ҵ����" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_24.jpg" width="60" height="61" alt="���Դ��" /></td>
                                          </tr>
                                        </table>     
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                </td>
                                <td width="83%" VALIGN="top">
                                <div style="padding-top:6px;">
                                	<div class="mulu">
                                    	 <h2> ��Ƶ</h2>
                                    
                                    <!--��������������-->
<OBJECT name=myWebPlayer9
	id=myWebPlayer9
	classid="clsid:947BA55B-2113-4349-8784-FFB9D7F881C9"
	width=100%
	height=95%
	align=center
	hspace=0
	vspace=0
>
<!--ģʽѡ��, full ��ʾ������ʾ�������Ŵ��ںͿ�����, simple ��ʾ����ʾ, ֻ��ʾ���Ŵ���, ����ʾ������-->
<param name="Mode" value="full">
<!--����ʱ��ʾ�Ĳ����ļ��ı���-->
<param name="Title" value="/${file.realname}">
<!--���ſ�ʼǰ, ��ʾ����URL��ַ, �������Flash,��ò�Ҫ������ʾFlash���Ҽ��˵�����, ��ַΪ��,����ʾ���-->
<param name="AdURL" value="">
<!--���ŵ���Ƶ�ĵ�ַ,Ŀǰ֧�����ֵ�ַ��ʽһ������HTTP��ַ������WP9://���ܵ�ַ������ʹ�ü��ܵ�ַ-->
<param name="URL" value="wp9://6C97AF2C670CBD6997A9EB6DE88CCA9808D8/kad/D9428A0F0102F75BF0AF513589560473A8352C50/D/apache-tomcat-6.0.30/webapps/qzkj/views/${file.name}${file.suffix}">
<!--�����Ƹ��������ֹ��-->
<param name="TextAds" 
value="����֧��|http://www.webplayer9.com/bbs@�þ�Ӱ������|http://www.webplayer9.com">
<!--������Ϻ���ת����һ��ҳ��ĵ�ַ, Ϊ������ת-->
<!--�����Զ�����IE���Ŵ���Ϊ��Ƶ��ԭʼ��С. 0 ��ʾ������, -1 ����-->
<param name="AutoSize" value=0>
</OBJECT>

                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    </div><!--nulu����-->
    </div>                            
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                </td>
                                <td width="8%"  VALIGN="top"><table width="61" border="0" cellspacing="0" cellpadding="0"  class="shi_img1">
  <tr>
                                    <td><img src="images/s_27.jpg" width="60" height="61" alt="���ɰ�" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_28.jpg" width="60" height="61" alt="��������" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_31.jpg" width="60" height="61" alt="�鿴�ʼ�" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_32.jpg" width="60" height="61" alt="��ʦ����" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_35.jpg" width="60" height="61" alt="ѧϰ��¼" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_36.jpg" width="60" height="61" alt="ʹ�ð���" /></td>
                                  </tr>
                                </table>
                                </td>
                              </tr>
                            </table>

                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     	
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
</body>
</html>

