<%@ page language="java" contentType="text/html;charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="templates/css/main.css" rel="stylesheet" type="text/css" />
		<script src="templates/js/lightbox_zd.js" type="text/javascript">
</script>
		<script src="templates/js/util.js" type="text/javascript">
</script>
		<script src="templates/js/tdcolor.js" type="text/javascript">
</script>
		<script src="templates/js/createxmldoc.js" type="text/javascript">
</script>
		<script src="templates/js/updown.js" type="text/javascript">
</script>
		<c:if test="${alertMSG!=null}">
			<c:if test="${alertMSG!=''}">
				<script>
alert("${alertMSG}");</script>
			</c:if>
		</c:if>
		<%
			session.setAttribute("alertMSG", "");
		%>

		<script type="text/javascript">
var tableidArray = new Array('table1');
onloadEvent(showtable);

var checkdate = true;

function validateCheck(tableName, codeName, outCount) {
	var checkValue = encodeURIComponent(encodeURIComponent(document
			.getElementsByName(codeName)[0].value));
	if (checkValue != '') {
		createxmldoc();
		var pand_check = true;
		xmldoc.open("post", 'validateCheck.action', false);
		xmldoc.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xmldoc.onreadystatechange = function() {
			if (xmldoc.readyState == 4 && xmldoc.status == 200) {

				if (xmldoc.responseText == 'yes') {
					alert(outCount + " �ѱ�ռ�ã�");
					pand_check = false;

					if (checkdate)
						checkdate = false;
					return false;
				} else {
					checkdate = true;
					return true;
				}
			}

		}
		xmldoc.send('checkValue=' + checkValue + '&tableName=' + tableName
				+ '&codeName=' + codeName);
		return pand_check;
	} else {
		alert("������ " + outCount);

		return true;
	}
}

function searchlist() {
	formlist.currentPage.value = 1;
	formlist.submit();
}

function checkAll(e, itemName) {
	var aa = document.getElementsByName(itemName);
	for ( var i = 0; i < aa.length; i++)
		aa[i].checked = e.checked;
}

function plremove() {
	var f = false;
	var arr = document.getElementsByName("allcheck");
	for (i = 0; i < arr.length; i++) {
		if (arr[i].checked) {
			f = true;
			break;
		}
	}

	if (f) {
		var ff = window.confirm("ȷ��Ҫ����ɾ����");
		if (ff) {
			formlist.action = "<%=request.getContextPath()%>/removedmzd";
			formlist.submit();
		}
	} else {
		alert("��ѡ������һ����¼");
		return;
	}
}

function checkinfo() {

	if (formadd.bh.value == "") {
		alert("����д �ֵ���룡");
		return;
	}

	if (!descCheck(formadd.bh.value)) {
		alert("����� �ֵ���� ���зǷ��ַ���");
		return;
	}

	if (formadd.mc.value == "") {
		alert("����д �ֵ����ƣ�");
		return;
	}

	if (!descCheck(formadd.mc.value)) {
		alert("����� �ֵ����� ���зǷ��ַ���");
		return;
	}

	if (!descCheck(formadd.sjbh.value)) {
		alert("����� ������ ���зǷ��ַ���");
		return;
	}

	if (!descCheck(formadd.remark.value)) {
		alert("����� ��ע ���зǷ��ַ���");
		return;
	}

	if (!checkdate) {
		alert("����� ���� ���Ϸ� ��");
		return;
	}

	if (document.getElementsByName('id')[0].value == "") {
		/*����*/

		formadd.flag.value = "add";
		formadd.submit();

	} else {
		/*�޸�*/

		formadd.flag.value = "edit";
		formadd.submit();
	}
}
</script>
<style type="text/css">
<!--
body {
	margin-top: 2px;
	margin-left: 0px;
	margin-right: 0px;
	background: #ffffff;
}
-->
</style>
	</head>
	<body style="overflow:scroll;overflow-y:hidden;">
		<form action="<%=request.getContextPath()%>/dmzdentry" name="formlist"
			method="post">

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="tableout">
				<tr>
					<td width="100%">

						<div class="mininav_1">
							<h1>
								�����ֵ�����
								<span><img src="templates/image/t.gif" alt="���" /><a
									href="#" id="addbtn">&nbsp;���</a>&nbsp;&nbsp;<img
										src="templates/image/s.gif" alt="ɾ��" /><a
									href="javascript:plremove();">&nbsp;ɾ��</a>
								</span>&nbsp;&nbsp;&nbsp;&nbsp;
							</h1>
							<input type="hidden" name="lbbh" value="${lbbh}" id="lbbh" />
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="list" id="table1">
								<tr>
									<th width="30" align="center">
										<input type="checkbox" name="all" id="all"
											onclick="javascript:checkAll(this,'allcheck');" />
									</th>
									<th width="100">
										�ֵ����
									</th>
									<th width="100">
										�ֵ�����
									</th>
									<th width="100">
										���
									</th>

									<th width="100">
										�Ƿ�����
									</th>
									<th  >
										����
									</th>
								</tr>

								<c:forEach items="${ps.items}" var="po" varStatus="varsta">
									<tr>
										<td width="33" align="center">
											<input type="checkbox" name="allcheck" id="allcheck"
												value="${po.id}" />
											<td>
												${po.bh}
											</td>
											<td>
												${po.mc}
											</td>
											<td>
												${po.className}
											</td>

											<td align="center">
												<c:if test="${po.startmark==0}">����</c:if>
												<c:if test="${po.startmark==1}">δ����</c:if>
												&nbsp;
											</td>
											<td >
												<a href="javascript:void(0)" class="listbte" id="editbtn"
													onclick="javascript:entryedit('${po.id}');">�޸�</a>
											</td>
									</tr>
								</c:forEach>
							</table>

							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="page">
								<tr>
									<td>
										${ps.pagefooter}
									</td>
								</tr>
							</table>

						</div>
					</td>
				</tr>
			</table>

		</form>

		<!--�����������-->
		<div id="idBox" class="lightbox" style="width: 450px;">
			<h1 id="idBoxHead">
				�༭��������
				<span><img src="templates/image/quit.png" id="idBoxCancel" />
				</span>
			</h1>
			<div class="content">

				<form action="<%=request.getContextPath()%>/adddmzdentry"
					name="formadd" method="post">
					<table width="440" border="0" align="center" cellpadding="0"
						cellspacing="0" class="tableout">
						<tr>
							<td>
								<fieldset>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="list">
										<tr>
											<th>
												�ֵ���룺
											</th>
											<td>
												<input name="bh" type="text" maxlength="36"
													class="input_text" size="20" />
												(<font class="hong">*</font>)
												<input type="hidden" name="lbbh" value="${lbbh}" id="lbbh" />
												<input name="id" type="hidden" value="" />
												&nbsp;&nbsp; &nbsp;&nbsp;
											</td>
										</tr>
										<tr>
											<th>
												�ֵ����ƣ�
											</th>
											<td>
												<input name="mc" type="text" maxlength="36"
													class="input_text" size="20"
													onblur="validateCheck('sys_dmzd','mc','�ֵ�����');" />
												(<font class="hong">*</font>) &nbsp;&nbsp;
											</td>
										</tr>

										<tr>
											<th>
												�����ţ�
											</th>
											<td>
												<input name="sjbh" type="text" maxlength="36"
													class="input_text" size="20" />
											</td>
										</tr>
										<tr>
											<th>
												����״̬��
											</th>
											<td>
												<select name="startmark">
													<option value="0">
														��&nbsp;&nbsp;��
													</option>
													<option value="1">
														������
													</option>
												</select>
											</td>
										</tr>


										<tr>
											<th>
												��ע��
											</th>
											<td align="left">
												<textarea rows="5" cols="35" name="remark"></textarea>
											</td>
										</tr>
									</table>
							</td>
						</tr>

						</div>
						</div>


					</table>
					<br />
					<table align="center">
						<tr>
							<td>
								<input type="hidden" name="flag" id="flag" />
								<a class="btn" id="editbtn" onclick="javascript:checkinfo();">ȷ
									��</a>
								<a class="btn" href="#" id="idBoxCancel2">ȡ ��</a>
							</td>
						</tr>
					</table>
					</fieldset>
					</td>
					</tr>
					</table>
					<input type="hidden" name="currentPage" id="currentPage"
						value="${currentPage}" />
				</form>
			</div>
		</div>
		<div id="idOverlay"></div>
		<script>

var box = new LightBox("idBox", "idOverlay", {
	Center : true
});
var box = new LightBox("idBox", "idOverlay", {
	Center : true
});
var drag = new Drag("idBox", "idBoxHead", {
	mxContainer : document.documentElement,
	Lock : true
});
$("idBoxCancel").onclick = function() {
	box.Close();
}
$("idBoxCancel2").onclick = function() {
	box.Close();
}
$("addbtn").onclick = function() {
	document.getElementsByName('id')[0].value = "";
	document.getElementsByName('bh')[0].value = "";
	document.getElementsByName('mc')[0].value = "";

	document.getElementsByName('sjbh')[0].value = "";
	document.getElementsByName('remark')[0].innerText = "";

	box.Show();
}

function entryedit(poid) {
<c:forEach items="${ps.items}" var="po" varStatus="varsta">
    if("${po.id}"==poid){
    
     document.getElementsByName('id')[0].value="${po.id}";  
     document.getElementsByName('bh')[0].value="${po.bh}"; 	
     document.getElementsByName('mc')[0].value="${po.mc}"; 	
   
     document.getElementsByName('sjbh')[0].value="${po.sjbh}"; 	
     
     document.getElementsByName('remark')[0].innerText="${po.remark}"; 

          document.getElementsByName('currentPage')[0].value="${currentPage}";
     
    }
  </c:forEach>

   box.Show();
};

box.Close();
box.Fixed = false;
drag.Lock = false;
</script>
	</body>
</html>
