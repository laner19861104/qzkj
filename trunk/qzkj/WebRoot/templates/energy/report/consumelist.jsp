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
<div class="position">��ǰλ�ã���Դ�������ݿ�ϵͳ >> �ܺ����ݲ�ѯ��ͳ�� >> ��Դ�������ݻ���</div>
<br />
	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout">
      <tr>
        <td><fieldset >
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableout" >
										<tr>
											<td>
											<fieldset>
												<legend>��ѯ����</legend>
												<table width="1003" border="0" cellpadding="6" cellspacing="0" style="width:auto">
													<tr>
														<th width="117">�꣺</th>
														<td width="100"><select name="select1">
							  <option value="">2009</option>
							   <option value="">2010</option>
						  </select></td>
														<th width="116">�·ݣ�</th>
														<td width="126"><select name="select2">
							  <option value="">1</option>
							  <option value="">2</option>
							  <option value="">3</option>
						  </select></td>
						  <th width="117">������</th>
														<td width="126"><select name="select1">
							  <option value="">����</option>
							   <option value="">����</option>
						  </select></td>
														<th width="71">��ҵ��</th>
														<td width="134"><select name="select2">
							  <option value="">��֯</option>
							  <option value="">ʯ�ͻ���</option>
						  </select></td>
						   </tr>
						  <tr>
						  <th width="117">�ص����ͣ�</th>
														<td width="100"><select name="select1">
							  <option value="">��</option>
							   <option value="">��</option>
						  </select></td>
						  <th width="116">��λ���ƣ�</th>
													  <td width="126"><input name="deptNo" type="text" class="input_text" size="10" /></td>
														<th width="117">�ϱ�״̬��</th>
														<td width="126"><select name="select2">
							  <option value="">δ�ϱ�</option>
							  
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
                                        <td>  <a class="btn" id="searchbtn" onclick="javascript:selectlist()"><span class="search">�� ѯ</span></a> </td>
                                      </tr>
        </table>
          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1"  width="100%" style="display:none">
            <tr>
              <th width="30"><input type="checkbox" name="checkbox" value="checkbox" /></th>
              <th width="686">��λ����</th>
              <th width="289">�ϱ�״̬</th>
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
              <td><a href="javascript:add()"> Ϋ���ȵ繫˾</a></td>
              <td>δ�ϱ�</td>
             
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
              <td><a href="javascript:add()">Ϋ��������˾</a></td>
              <td>δ�ϱ�</td>
             
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox4" value="checkbox" /></td>
              <td><a href="javascript:add()">Ϋ��ȼ����˾</a></td>
              <td>δ�ϱ�</td>
              
            </tr>
           <tr>
              <td align="center"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
              <td><a href="javascript:add()">Ϋ���ȵ繫˾</a></td>
              <td>δ�ϱ�</td>
             
              
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
              <td><a href="javascript:add()">Ϋ��������˾</a></td>
              <td>δ�ϱ�</td>
             
            </tr>
            <tr>
              <td align="center"><input type="checkbox" name="checkbox4" value="checkbox" /></td>
              <td><a href="javascript:add()">Ϋ��ȼ����˾</a></td>
              <td>δ�ϱ�</td>
              
            </tr>
           
        </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="page" style="display:none" id="pag">
            <tr>
              <td><a href="#">�� ҳ</a> <a href="#">��һҳ</a> <a href="#">��һҳ</a> <a href="#">ĩ ҳ</a>
                  <input name="textfield" type="text" size="3"/>
                  <a href="#">�� ת</a> ����<span>1-10</span>�� - �� <span>1/6</span>ҳ ����<span>55</span>����¼�� </td>
            </tr>
          </table>
        </fieldset></td>
      </tr>
</table>

		 

</body>
</html>
