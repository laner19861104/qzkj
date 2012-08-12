<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<link href="templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="templates/js/tdcolor.js" type="text/javascript"></script>
<script src="templates/js/upview.js" type="text/javascript"></script>
<script type="text/javascript">
//var tableidArray = new Array('table1');
///onloadEvent(showtable);

</script>
<script type="text/javascript">
function selectlist(){
	table1.style.display="block";
	pag.style.display="block";
}
var obj = new Object();
function add(){	
	window.showModalDialog("/zcxgov/templates/energy/report/consume.jsp",obj,"help: No; resizable: No; status: No;scrollbars:No;center: Yes;scroll:no;dialogWidth:790px;status:no;dialogHeight:320px");
}
</script>
</head>

<body>
<div class="position">当前位置：能源消耗数据库系统 >> 能耗数据查询、统计 >> 能源消耗数据汇总</div>
<br />
	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset >
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
										<tr>
											<td>
											<fieldset>
												<legend>查询条件</legend>
												<table width="1003" border="0" cellpadding="6" cellspacing="0" style="width:auto">
													<tr>
														<th width="117">年：</th>
														<td width="100"><select name="select1">
							  <option value="">2009</option>
							   <option value="">2010</option>
						  </select></td>
														<th width="116">月份：</th>
														<td width="126"><select name="select2">
							  <option value="">1</option>
							  <option value="">2</option>
							  <option value="">3</option>
						  </select></td>
						  <th width="117">地区：</th>
														<td width="126"><select name="select1">
							  <option value="">奎文</option>
							   <option value="">高新</option>
						  </select></td>
														<th width="71">行业：</th>
														<td width="134"><select name="select2">
							  <option value="">纺织</option>
							  <option value="">石油化工</option>
						  </select></td>
						   </tr>
						  <tr>
						  <th width="117">重点类型：</th>
														<td width="100"><select name="select1">
							  <option value="">是</option>
							   <option value="">否</option>
						  </select></td>
						  <th width="116">单位名称：</th>
													  <td width="126"><input name="deptNo" type="text" class="input_text" size="10" /></td>
														<th width="117">上报状态：</th>
														<td width="126"><select name="select2">
							  <option value="">未上报</option>
							  
						  </select></td>
												  </tr>
											</table>
											</fieldset>								
											</td>
										</tr>
	    </table>
								  <br>
								
								 <table border="0" cellpadding="0" cellspacing="0" class="btntable">
                                      <tr>
                                        <td>  <a class="btn" id="searchbtn" onclick="javascript:selectlist()"><span class="search">查 询</span></a> </td>
                                      </tr>
        </table>
          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1"  width="100%" style="display:none">
            <tr>
              <th width="30"><input type="checkbox" name="checkbox" value="checkbox" /></th>
              <th width="686">单位名称</th>
              <th width="289">上报状态</th>
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
              <td><a href="javascript:add()"> 潍坊热电公司</a></td>
              <td>未上报</td>
             
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
              <td><a href="javascript:add()">潍坊热力公司</a></td>
              <td>未上报</td>
             
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox4" value="checkbox" /></td>
              <td><a href="javascript:add()">潍坊燃气公司</a></td>
              <td>未上报</td>
              
            </tr>
           <tr>
              <td align="center"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
              <td><a href="javascript:add()">潍坊热电公司</a></td>
              <td>未上报</td>
             
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
              <td><a href="javascript:add()">潍坊热力公司</a></td>
              <td>未上报</td>
             
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox4" value="checkbox" /></td>
              <td><a href="javascript:add()">潍坊燃气公司</a></td>
              <td>未上报</td>
              
            </tr>
           
        </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="page" style="display:none" id="pag">
            <tr>
              <td><a href="#">首 页</a> <a href="#">上一页</a> <a href="#">下一页</a> <a href="#">末 页</a>
                  <input name="textfield" type="text" size="3"/>
                  <a href="#">跳 转</a> 【第<span>1-10</span>条 - 第 <span>1/6</span>页 共有<span>55</span>条记录】 </td>
            </tr>
          </table>
        </fieldset></td>
      </tr>
</table>

		 

</body>
</html>
