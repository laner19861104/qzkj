<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" /> 
<title>无标题文档</title>
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/shipin.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div id="topflash"> 
    	<div class="btn">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="images/btn_03.jpg" width="58" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_05.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_07.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_09.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_11.jpg" width="57" height="46" alt="在线客服" /></td>
    <td><img src="images/btn_13.jpg" width="57" height="46" alt="在线客服" /></td>
  </tr>
</table>

        
        
        
        
        
        </div><!--btnx结束-->
    
    
    
    </div><!--topflash结束-->
    
    <div class="clear"></div>
      
      <div id="menu">
		<ul>
		  <li><a href="index.html">首页</a></li>
			<li><a href="list.html?a=工作动态" rel="dropmenu1">促销课程</a></li>
			<li><a href="list.html?a=政策法规" rel="dropmenu2">热销课程</a></li>
			<li><a href="zhongbiao.html?a=招标公告" rel="dropmenu3">增值服务</a></li>
		</ul>
        
        <div class="search">
        	<select name="">
        	  <option value="课程">课程</option>
        	</select>
        	<input name="" type="text" />
        <img src="images/19.gif" width="43" height="20" alt="搜索" /></div><!--search结束-->
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    
    
    
    <div id="main"><!--中间开始-->
    		<div class="position">
		
			 <h1> 您的位置：首页>>视频</h1>
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
                                            <td ><img src="images/s_09.jpg" width="60" height="61" alt="课程目录" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_11.jpg" width="60" height="61" alt="下载中心" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_19.jpg" width="60" height="61" alt="课程讲义" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_20.jpg" width="60" height="61" alt="历年试题" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_23.jpg" width="60" height="61" alt="我的题库" /></td>
                                          </tr>
                                          <tr>
                                            <td><img src="images/s_24.jpg" width="60" height="61" alt="考试大纲" /></td>
                                          </tr>
                                        </table>     
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                </td>
                                <td width="83%" VALIGN="top">
                                <div style="padding-top:6px;">
                                	<div class="mulu">
                                    	 <h2> 视频</h2>
                                    
                                    <!--创建播放器对象-->
<OBJECT name=myWebPlayer9
	id=myWebPlayer9
	classid="clsid:947BA55B-2113-4349-8784-FFB9D7F881C9"
	width=100%
	height=95%
	align=center
	hspace=0
	vspace=0
>
<!--模式选择, full 表示完整显示包括播放窗口和控制栏, simple 表示简单显示, 只显示播放窗口, 不显示控制栏-->
<param name="Mode" value="full">
<!--播放时显示的播放文件的标题-->
<param name="Title" value="亚瑟的迷你王国A">
<!--播放开始前, 显示广告的URL地址, 如果包含Flash,最好不要启用显示Flash的右键菜单功能, 地址为空,不显示广告-->
<param name="AdURL" value="">
<!--播放的视频的地址,目前支持两种地址格式一是明文HTTP地址，二是WP9://加密地址，见意使用加密地址-->
<param name="URL" value="wp9://48311CA3881895FAB8D9FEA4FA8857586B84/kad/D9428A0F0102F75BF0AF513589560473A8352C50/E/吸血鬼日记/第一季/吸血鬼日记.The.Vampire.Diaries.S01E01.Chi_Eng.HDTVrip.720X396-YYeTs人人影视.rmvb">
<!--不限制个数的文字广告-->
<param name="TextAds" 
value="技术支持|http://www.webplayer9.com/bbs@久久影音官网|http://www.webplayer9.com">
<!--播放完毕后跳转到下一个页面的地址, 为空则不跳转-->
<param name="NextVideoURL" value="wp9://48311CA3881895FAB8D9FEA4FA8857586B84/kad/D9428A0F0102F75BF0AF513589560473A8352C50/E/吸血鬼日记/第一季/吸血鬼日记.The.Vampire.Diaries.S01E02.Chi_Eng.HDTVrip.720X396-YYeTs人人影视.rmvb">
<!--控制自动控制IE播放窗口为视频的原始大小. 0 表示不启用, -1 启用-->
<param name="AutoSize" value=0>
</OBJECT>

                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    </div><!--nulu结束-->
    </div>                            
                                
                                
                                
                                
                                
                                
                                
                                
                                
                                </td>
                                <td width="8%"  VALIGN="top"><table width="61" border="0" cellspacing="0" cellpadding="0"  class="shi_img1">
  <tr>
                                    <td><img src="images/s_27.jpg" width="60" height="61" alt="答疑板" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_28.jpg" width="60" height="61" alt="梦想在真" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_31.jpg" width="60" height="61" alt="查看笔记" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_32.jpg" width="60" height="61" alt="教师评价" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_35.jpg" width="60" height="61" alt="学习记录" /></td>
                                  </tr>
                                  <tr>
                                    <td><img src="images/s_36.jpg" width="60" height="61" alt="使用帮助" /></td>
                                  </tr>
                                </table>
                                </td>
                              </tr>
                            </table>

                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     	
          			</fieldset>
                    
                    
                    
                    
                    
                    
                    </td>
                  </tr>
                </table>

           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
    
    
	</div><!--中间开始结束-->
    
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>版权所有：潍坊政府采购<br>
            技术支持：潍坊中财信科技有限公司
        </p>
    
    
    
    </div>
</body>
</html>

