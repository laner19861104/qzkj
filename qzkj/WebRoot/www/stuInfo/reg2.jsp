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
<title>ѧԱע��</title>
<base href="<%=basePath+"www/stuInfo/"%>">
<script type="text/javascript" src="<%=basePath%>/templates/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
<script src="js/city.js" type="text/javascript"></script>
<link href="css/gong.css" rel="stylesheet" type="text/css" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
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
		  <li><span>����ѧԱ��Ϣע��</span></li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
		</ul>
        
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    <div id="main"><!--�м俪ʼ-->
    <form method="post" action="<%=basePath%>regEditUser.do" id="form1" ">
    	<div id="reg" ><!--���-->
        	<div class="maintop">
        		<div class="left">
        		<img src="images/ft2.gif"/>
        		</div>
        		<div class="left" style="margin-top:4px;padding-left: 20px;color: #ff0000">��ӭ <span style="font-weight: bold">${webuser.account}</span>�����Ѿ�ע��ɹ���</div>
        		<div class="right" >
        		������Ѿ������ǵ�ѧԱ����ֱ��&nbsp;<a href="">��¼</a>
        		</div>
        	</div>
        	<div class="infotip mid" style="margin-left:auto; margin-right:auto;">
        	<div class="font">������Ϣ�Ա��������ʺŰ�ȫ��Ϊ��Ҫ������������д���μǣ�������ͨ���ֻ������䡢���ʷ�ʽ�һ�����</div>
            </div>	
            <div class="sconter mid">
        	<dl>
            	<dt>�ֻ����룺</dt>
                <dd><input id="tel" type="text" name="wuser.tel" class="put"  value=""></dd>
                </dl>
           </div>
          <div class="sconter mid">
        	<dl>
            	<dt>���뱣�����⣺</dt>
                <dd class="zonghe">
					  <select name="wuser.pwdquestion" class="bord" style="width:180px">
					  	<option value="" style="color: #BEBEBE;">��ѡ��һ������</option>
                      	<option value="1">���ֻ�����ĺ�6λ��</option>
                        <option value="2">��ĸ�׵����գ�</option>
                        <option value="3">�Ҹ��׵����գ�</option>
                        <option value="4">��������ѵ����գ�</option>
                        <option value="5">�Ҷ�ʱ��ס�صĵ�ַ��</option>
                        <option value="6">��СѧУ��ȫ�ƣ�</option>
                        <option value="7">����ѧУ��ȫ�ƣ�</option>
                        <option value="8">���Ҽ������ҽԺȫ�ƣ�</option>
                        <option value="9">���Ҽ�����Ĺ�԰ȫ�ƣ�</option>
                        <option value="10">�ҵ��������ǣ�</option>
                        <option value="11">����ϲ���ĵ�Ӱ��</option>
                        <option value="12">����ϲ���ĸ�����</option>
                        <option value="13">����ϲ����ʳ�</option>
                        <option value="14">�����İ��ã�</option>
                        <option value="15">����ϲ����С˵��</option>
                        <option value="16">����ϲ�����˶��ӣ�</option>
                        </select> 
                </dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>���Ĵ𰸣�</dt>
                <dd class="zonghe">
					  <input name="wuser.answer" id="answer" type="text" class="put" maxlength="100" >
                </dd>
            </dl>
        </div>
        <div class="line" style="margin-left:auto; margin-right:auto;"></div>
        <div class="sconter mid">
        	<dl>
            	<dt>�ԡ�����</dt>
                <dd class="zonghe">
                    <input value="Ů" type="radio" name="wuser.sex">
                    Ů
                    <input value="��" type="radio" name="wuser.sex">
                    ��
                </dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>�������ڣ�</dt>
                <dd class="zonghe">
                  <input value="1970" maxlength="4" size="4" name="year" style="border:1px #7E9DB9 solid">
                  ��
                  <select name="month" class="bord">
                    <option selected="selected" value=""></option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                  </select>
                  ��
                  <select name="date" class="bord">
                    <option selected="selected" value=""></option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                  </select>
                �� </dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>��ס��ַ��</dt>
                <dd class="zonghe">
                	<select name="province" id="province"  class="bord" onchange="areaMap.city(this.value)">
										
							</select> ʡ<span class="hui">��ֱϽ�У�</span> 
					<select name="city" id="city">
					</select> ��<span class="hui">��������</span>
				</dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>�����̶ȣ�</dt>
                <dd class="zonghe">
        			<select name="wuser.edulv">
						<option value="" selected="">��ѡ��</option>
						<option value="1">��ר����</option>
						<option value="2">��ר</option>
						<option value="3">����</option>
						<option value="4">��������</option>
						</select>
          		</dd>
            </dl>
        </div>
        <script>
		var areaMap = new AreaMap('province','city');
        areaMap.province('��ѡ��ʡ����','��ѡ�������');
</script>
        <div class="sconter mid">
        	<dl>
            	<dt>������ʣ�</dt>
                <dd class="zizhi">
                	<label><input type="checkbox" name="proSkill" value="1"> 
                  ����ְ��</label>
                    <label><input type="checkbox" name="proSkill" value="2">
                    �м�ְ��</label> 
                    <label><input type="checkbox" name="proSkill" value="3"> 
                    �߼�ְ��</label> 
                    <label><input type="checkbox" name="proSkill" value="4"> 
                    ע����ʦ</label> 
                    <label><input type="checkbox" name="proSkill" value="5"> 
                    ע������ʦ</label> 
                    <label><input type="checkbox" name="proSkill" value="6"> 
                    ע��˰��ʦ</label>
                </dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>������λ��</dt>
                <dd><input id="unitName" type="text" maxlength="100" name="wuser.workFor" class="put" onclick="this.select();"></dd>
                <dt class="mlt50">ͨѶ��ַ��</dt>
                <dd><input id="mailAddr" type="text" maxlength="100" name="wuser.postAddress" class="put" onclick="this.select();"></dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>�������룺</dt>
                <dd><input id="zipCode" type="text" maxlength="6" name="wuser.postNo" class="put" onclick="this.select();"></dd>
                <dt class="mlt50">���֤�ţ�</dt>
                <dd><input id="cardID" type="text" maxlength="18" name="wuser.id" class="put" onclick="this.select();"></dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<br>
      </div>
      <div class="sconter mid" >
        	<dl>
            	<dt>&nbsp;</dt>
                <dd class="zizhi"> 
	                <input type="submit" value="������" class="butom">����
	                <input type="submit" value="������" class="butom">
                </dd>
            </dl>
      </div>
        </div><!--������-->
   
    </form>
    </div><!--�м俪ʼ����-->
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>��Ȩ���У�Ϋ�������ɹ�<br>
            ����֧�֣�Ϋ���в��ſƼ����޹�˾
        </p>
    
    
    
    </div>
</body>
</html>
