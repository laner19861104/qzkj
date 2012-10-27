<%@ page language="java" import="java.util.*,com.bip.sys.course.po.*" pageEncoding="gb2312"   contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<JocSubject> subjectlist = (List<JocSubject>)request.getAttribute("subjectlist");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>���������ѵ��У</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<link href="css/gong.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="topflash">
  <div class="btn">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="images/btn_03.jpg" width="58" height="46" alt="���߿ͷ�" /></td>
        <c:if test="${webuser==null}">
        <td><a href="wlogin.do"><img src="images/btn_055.jpg" width="57" height="46" alt="��¼" /></a></td>
        </c:if>
        <c:if test="${webuser!=null}">
        <td><a href="entryStuInfo.do"><img src="images/btn_05.jpg" width="57" height="46" alt="�ҵ��ʻ�" /></a></td>
        </c:if>
        <td><img src="images/btn_07.jpg" width="57" height="46" alt="ѡ���嵥" /></td>
        <td><img src="images/btn_09.jpg" width="57" height="46" alt="��������" /></td>
        <td><img src="images/btn_11.jpg" width="57" height="46" alt="ȥ���" /></td>
        <td><img src="images/btn_13.jpg" width="57" height="46" alt="�����У" /></td>
      </tr>
    </table>
  </div>
  <!--btnx����--> 
  
</div>
<!--topflash����-->

<div class="clear"></div>
<div id="menu">
  <ul>
    <li><a href="index.do">��ҳ</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu1">�����γ�</a></li>
    <li><a href="list.do" target="_blank" rel="dropmenu2">�����γ�</a></li>
    <li><a href="zhongbiao.html?a=�б깫��" rel="dropmenu3">��ֵ����</a></li>
  </ul>
  <div class="search">
    <select name="">
      <option value="�γ�">�γ�</option>
    </select>
    <input name="" type="text" />
    <img src="images/19.gif" width="43" height="20" alt="����" /></div>
  <!--search����--> 
</div>
<!--end menu--> 

<!--end menu-->
<div class="clear"></div>
<div id="main"><!--�м俪ʼ-->
  <div id="left" ><!--���-->
    <div class="department"><!--�γ�-->
      <h1>ȫ���γ�<span><a href="list.do" target="_blank">����>></a></span></h1>
      <div class="news">
        <ul>
          <%for(JocSubject s : subjectlist) { %>
          <li><a href="list.do?subject=<%=s.getCode() %>" target="_blank"><%=s.getName() %></a></li>
          <%} %>
        </ul>
      </div>
    </div>
    <!--�γ̽���--> 
    
  </div>
  <!--������-->
  <div id="right">
    <div class="zuo">
      <div class=box >
        <div class=boxpadding>
          <div id=Slide> <img id=focpic style="FILTER: RevealTrans(duration=1;ransition=12); VISIBILITY: visible; POSITION: absolute; left:484; top:94" 
            src="images/wall1.jpg"  width="534" height="176" />
            <div class=thumb_title id=foctitle></div>
            <div id=Slide_Thumb>
              <div class=thumb_on id=tmb0 onmouseover=setfoc(0); onmouseout=playit();> <img  src="images/wall1.jpg" /></div>
              <div class=thumb_off id=tmb1 onmouseover=setfoc(1); onmouseout=playit();> <img src="images/wall2.jpg" /></div>
              <div class=thumb_off id=tmb2 onmouseover=setfoc(2); onmouseout=playit();> <img  src="images/wall3.jpg" /></div>
              <div class=thumb_off id=tmb3 onmouseover=setfoc(3); onmouseout=playit();> <img  src="images/wall4.jpg" /></div>
              <script language=javascript type=text/javascript>
var picarry = {};
var lnkarry = {};
var ttlarry = {};
picarry[0] = "images/wall1.jpg";
lnkarry[0] = "/";
ttlarry[0] = "ͼһ";
picarry[1] = "images/wall2.jpg";
lnkarry[1] = "/";
ttlarry[1] = "ͼ��";
picarry[2] = "images/wall3.jpg";
lnkarry[2] = "/";
ttlarry[2] = "ͼ��";
picarry[3] = "images/wall4.jpg";
lnkarry[3] = "/";
ttlarry[3] = "ͼ��";

      </script> 
            </div>
          </div>
        </div>
      </div>
      <SCRIPT type=text/javascript>
var currslid = 0;
var slidint;
function setfoc(id){
	document.getElementById("focpic").src = picarry[id];
	
	
	currslid = id;
	for(i=0;i<4;i++){
		document.getElementById("tmb"+i).className = "thumb_off";
	};
	document.getElementById("tmb"+id).className ="thumb_on";
	focpic.style.visibility = "hidden";
	focpic.filters[0].Apply();
	if (focpic.style.visibility == "visible") {
		focpic.style.visibility = "hidden";
		focpic.filters.revealTrans.transition=23;
	}
	else {
		focpic.style.visibility = "visible";
		focpic.filters[0].transition=23;
	}
	focpic.filters[0].Play();
	stopit();
}

function playnext(){
	if(currslid==3){
		currslid = 0;
	}
	else{
		currslid++;
	};
	setfoc(currslid);
	playit();
}
function playit(){
	slidint = setTimeout(playnext,6000);
}
function stopit(){
	clearTimeout(slidint);
	}
window.onload = function(){
	playit();
}</SCRIPT>
      <div class="clear mt8"></div>
      <div class="new zhong_box"><!--�ɹ���ʼ-->
        <h2>�ɹ�����<span><a href="#">����>></a></span></h2>
        <table border="0" cellspacing="0" cellpadding="0"  class="list" >
          <tr>
            <th>�γ�����</th>
            <th>ԭ��</th>
            <th>������</th>
            <th>����</th>
          </tr>
          <tr>
            <td class="zhong_zuo">�۴�����2013�꿼�������߰���</td>
            <td>2800</td>
            <td>2350</td>
            <td><img src="images/mai_19.jpg" width="46" height="19" alt="����" /></td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <!--�ɹ�����-->
      <div class="clear mt8"></div>
      <div class="new zhong_box"><!--�ɹ���ʼ-->
        <h2>�ɹ�����<span><a href="#">����>></a></span></h2>
        <table width="98%" border="0" cellspacing="0" cellpadding="0"  class="list" >
          <tr>
            <th>�γ�����</th>
            <th>ԭ��</th>
            <th>������</th>
            <th>����</th>
          </tr>
          <tr>
            <td class="zhong_zuo">�۴�����2013�꿼�������߰���</td>
            <td>2800</td>
            <td>2350</td>
            <td><img src="images/mai_19.jpg" width="46" height="19" alt="����" /></td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td class="zhong_zuo">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <!--�ɹ�����-->
      
      <div class="clear mt8"></div>
      <div class="tese zhong_box"><!--�ɹ���ʼ-->
        <h2>��ѧ��ɫ<span><a href="#">����>></a></span></h2>
        <table width="98%" border="0" cellspacing="0" cellpadding="0" class="list1">
          <tr>
            <td width="17%"  valign=top><img src="images/btn1.jpg" width="72" height="18" alt="��ɫ��" /></td>
            <td width="83%" class="line_height">�����ο�ѧ���侭���ο�ѧ���侭���ο�ѧ�����ο�ѧ���侭���ο�ѧ���侭���ο�ѧ�������</td>
          </tr>
          <tr>
            <td  valign=top><img src="images/btn2.jpg" width="72" height="18" alt="��ɫ��" /></td>
            <td class="line_height">֣�س�ŵ:�����ο�ѧ���侭���ο�ѧ���侭���ο�ѧ����֣�س�ŵ:�����ο�ѧ���侭���ο�ѧ���侭���ο�ѧ����</td>
          </tr>
          <tr>
            <td valign=top><img src="images/btn3.jpg" width="72" height="18" alt="��ɫ��" /></td>
            <td class="line_height">֣�س�ŵ:�����ο�ѧ���侭���ο�ѧ���侭����֣�س�ŵ:�����ο�ѧ���侭���ο�ѧ���侭����</td>
          </tr>
        </table>
      </div>
    </div>
    <!--zuo����-->
    
    <div class="w203">
      <div class="canyu right_box">
        <h3>���ڲ���<span><a href="#">����>></a></span></h3>
        <div class="main_new">
          <ul>
            <li><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><a href="#"> �������� </a> </li>
          </ul>
        </div>
      </div>
      <!--canyu right_box����-->
      
      <div class="clear mt8"></div>
      <div class="c_zhi  right_box">
        <h3>���ٳ�ֵ</h3>
        <div class="ka"> ����:
          <input name="" type="text" />
          <input name="" type="submit" value="������ֵ" style="margin-left:50px;margin-top:10px;"/>
        </div>
      </div>
      <!--c_zhi����-->
      
      <div class="clear mt8"></div>
      <div class="canyu right_box" style="height:200px;">
        <h3>��ֵ����<span><a href="#">����>></a></span></h3>
        <div class="main_new">
          <ul>
            <li><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><a href="#"> �������� </a> </li>
            <li><a href="#"> �������� </a> </li>
          </ul>
        </div>
      </div>
      <div class="clear mt8"></div>
      <div class="shuzi right_box" >
        <h3>��ֵ����<span><a href="#">����>></a></span></h3>
        <div class="shuzi_new">
          <ul>
            <li><img src="images/n1.gif" width="13" height="11" alt="1" /><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><img src="images/n2.gif" width="13" height="11" alt="1" /><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><img src="images/n3.gif" width="13" height="11" alt="1" /><a href="#"> Ͷ��Ԫ���������Ļ���... </a> </li>
            <li><img src="images/n4.gif" width="13" height="11" alt="1" /><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><img src="images/n5.gif" width="13" height="11" alt="1" /><a href="#"> �������� </a> </li>
            <li><img src="images/n6.gif" width="13" height="11" alt="1" /><a href="#"> �������� </a> </li>
            <li><img src="images/n7.gif" width="13" height="11" alt="1" /><a href="#"> ����Ů�ؾ����нٷ�... </a> </li>
            <li><img src="images/n8.gif" width="13" height="11" alt="1" /><a href="#"> �������� </a> </li>
            <li><img src="images/n9.gif" width="13" height="11" alt="1" /><a href="#"> �������� </a> </li>
          </ul>
        </div>
      </div>
      <!--shuzi����-->
      
      <div class="clear mt8"></div>
      <div class="congshu right_box">
        <h3>��ֵ����<span><a href="#">����>></a></span></h3>
        <ul>
          <li><a href="#">��ʦ��д</a></li>
          <li><a href="#">Ȩ��ר</a></li>
          <li><a href="#">�����ǿ</a></li>
          <li><a href="#">�������</a></li>
          <li><a href="#">�����ϸ</a></li>
          <li><a href="#">�����ɿ�</a></li>
        </ul>
      </div>
      <!--congshu����--> 
      
    </div>
    <!--w203����--> 
    
  </div>
  <!--�Ҳ����--> 
  
</div>
<!--�м俪ʼ����-->

<div class="clear mt8"></div>
<div id="foot">
  <p>��Ȩ���У�Ϋ�������ɹ�<br>
    ����֧�֣�Ϋ���в��ſƼ����޹�˾ </p>
</div>
</body>
</html>
