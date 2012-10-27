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
<title>学员注册</title>
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
		  <li><span>◎新学员信息注册</span></li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
		</ul>
        
	</div> 
	<!--end menu-->
 
	<!--end menu-->
  	<div class="clear"></div>
    <div id="main"><!--中间开始-->
    <form method="post" action="<%=basePath%>regEditUser.do" id="form1" ">
    	<div id="reg" ><!--左侧-->
        	<div class="maintop">
        		<div class="left">
        		<img src="images/ft2.gif"/>
        		</div>
        		<div class="left" style="margin-top:4px;padding-left: 20px;color: #ff0000">欢迎 <span style="font-weight: bold">${webuser.account}</span>，您已经注册成功！</div>
        		<div class="right" >
        		如果您已经是我们的学员，请直接&nbsp;<a href="">登录</a>
        		</div>
        	</div>
        	<div class="infotip mid" style="margin-left:auto; margin-right:auto;">
        	<div class="font">以下信息对保护您的帐号安全极为重要，请您慎重填写并牢记，您可以通过手机、邮箱、提问方式找回密码</div>
            </div>	
            <div class="sconter mid">
        	<dl>
            	<dt>手机号码：</dt>
                <dd><input id="tel" type="text" name="wuser.tel" class="put"  value=""></dd>
                </dl>
           </div>
          <div class="sconter mid">
        	<dl>
            	<dt>密码保护问题：</dt>
                <dd class="zonghe">
					  <select name="wuser.pwdquestion" class="bord" style="width:180px">
					  	<option value="" style="color: #BEBEBE;">请选择一个问题</option>
                      	<option value="1">我手机号码的后6位？</option>
                        <option value="2">我母亲的生日？</option>
                        <option value="3">我父亲的生日？</option>
                        <option value="4">我最好朋友的生日？</option>
                        <option value="5">我儿时居住地的地址？</option>
                        <option value="6">我小学校名全称？</option>
                        <option value="7">我中学校名全称？</option>
                        <option value="8">离我家最近的医院全称？</option>
                        <option value="9">离我家最近的公园全称？</option>
                        <option value="10">我的座右铭是？</option>
                        <option value="11">我最喜爱的电影？</option>
                        <option value="12">我最喜爱的歌曲？</option>
                        <option value="13">我最喜爱的食物？</option>
                        <option value="14">我最大的爱好？</option>
                        <option value="15">我最喜欢的小说？</option>
                        <option value="16">我最喜欢的运动队？</option>
                        </select> 
                </dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>您的答案：</dt>
                <dd class="zonghe">
					  <input name="wuser.answer" id="answer" type="text" class="put" maxlength="100" >
                </dd>
            </dl>
        </div>
        <div class="line" style="margin-left:auto; margin-right:auto;"></div>
        <div class="sconter mid">
        	<dl>
            	<dt>性　　别：</dt>
                <dd class="zonghe">
                    <input value="女" type="radio" name="wuser.sex">
                    女
                    <input value="男" type="radio" name="wuser.sex">
                    男
                </dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>出生日期：</dt>
                <dd class="zonghe">
                  <input value="1970" maxlength="4" size="4" name="year" style="border:1px #7E9DB9 solid">
                  年
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
                  月
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
                日 </dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>居住地址：</dt>
                <dd class="zonghe">
                	<select name="province" id="province"  class="bord" onchange="areaMap.city(this.value)">
										
							</select> 省<span class="hui">（直辖市）</span> 
					<select name="city" id="city">
					</select> 市<span class="hui">（地区）</span>
				</dd>
            </dl>
      </div>
      <div class="sconter mid">
        	<dl>
            	<dt>教育程度：</dt>
                <dd class="zonghe">
        			<select name="wuser.edulv">
						<option value="" selected="">请选择</option>
						<option value="1">大专以下</option>
						<option value="2">大专</option>
						<option value="3">本科</option>
						<option value="4">本科以上</option>
						</select>
          		</dd>
            </dl>
        </div>
        <script>
		var areaMap = new AreaMap('province','city');
        areaMap.province('请选择省份名','请选择城市名');
</script>
        <div class="sconter mid">
        	<dl>
            	<dt>会计资质：</dt>
                <dd class="zizhi">
                	<label><input type="checkbox" name="proSkill" value="1"> 
                  初级职称</label>
                    <label><input type="checkbox" name="proSkill" value="2">
                    中级职称</label> 
                    <label><input type="checkbox" name="proSkill" value="3"> 
                    高级职称</label> 
                    <label><input type="checkbox" name="proSkill" value="4"> 
                    注册会计师</label> 
                    <label><input type="checkbox" name="proSkill" value="5"> 
                    注册评估师</label> 
                    <label><input type="checkbox" name="proSkill" value="6"> 
                    注册税务师</label>
                </dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>工作单位：</dt>
                <dd><input id="unitName" type="text" maxlength="100" name="wuser.workFor" class="put" onclick="this.select();"></dd>
                <dt class="mlt50">通讯地址：</dt>
                <dd><input id="mailAddr" type="text" maxlength="100" name="wuser.postAddress" class="put" onclick="this.select();"></dd>
            </dl>
        </div>
        <div class="sconter mid">
        	<dl>
            	<dt>邮政编码：</dt>
                <dd><input id="zipCode" type="text" maxlength="6" name="wuser.postNo" class="put" onclick="this.select();"></dd>
                <dt class="mlt50">身份证号：</dt>
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
	                <input type="submit" value="保　存" class="butom">　　
	                <input type="submit" value="跳　过" class="butom">
                </dd>
            </dl>
      </div>
        </div><!--左侧结束-->
   
    </form>
    </div><!--中间开始结束-->
    <div class="clear mt8"></div>
    <div id="foot">
    	<p>版权所有：潍坊政府采购<br>
            技术支持：潍坊中财信科技有限公司
        </p>
    
    
    
    </div>
</body>
</html>
