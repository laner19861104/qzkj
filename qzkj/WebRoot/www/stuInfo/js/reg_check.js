	function changeVerifyCode(obj) {

	//1�������<iframe>ʵ�֣������¼���<iframe>������
	//verifyCodeFrame.location.reload();

	//2�������<img>ʵ�֣����޸�<img src=url>��url
	//������һ��С���ɣ������url����ͬ��ֵ��������������·������������js����һ����ʱ��������url�еĲ���
	t = new Date().getTime();
	obj.src = "VerifyCodeServlet.action?t=" + t;
}
	var userNameFlag = false;
	var passwordFlag = false;
	var rePasswordFlag = false;
	var randCode = false;
	var articleFlag = false;
	var mobileFlag = false;
	var emailFlag = false;
	var qqNumberFlag = false;
	
	var userNameObj = document.getElementById("account");
	userNameObj.focus();
	
	var userNameRegex = /^[a-zA-Z0-9\_]{4,20}$/;
	var passwordRegex = /^[a-zA-Z0-9]{4,15}$/;

	var regexMobile = /^1[3|5|8][0-9]\d{8}$/;
	function checkMember(){
		userNameFlag = false;
		var userName = userNameObj.value;
		var reportObj = $("#report");
		if(userNameRegex.test(userName)){
			reportObj.attr("class","msg2");
			reportObj.text("����У����Ե�...");
			$.get("registerExists.do", {account: userName, time: Math.random()},
	  			function(data){
	    			if(data.success==true){
	    				reportObj.css("display","none");
	    				$("#userNameOk").css("display","");
	    				userNameFlag = true;
	    				//reportObj.text("��ϲ������������ע�ᣡ");
	    			}else{
	    				reportObj.css("display","");
	    				reportObj.attr("class","note");
	    				$("#userNameOk").css("display","none");
	    				reportObj.text("�Բ���,����û�����ע�ᣡ");
	    			}
	  		}, "json");
		}else{
			$("#userNameOk").css("display","none");
			if(userName!=""){
				reportObj.css("display","");
				reportObj.attr("class","note");
				reportObj.text("�밴�Ҳ�Ҫ����д�û���");
			}else{
				reportObj.css("display","none");
			}
		}
	}

	function checkMsg(arg,isSubmit){
		switch(arg){
			
			case 2:
			{
				var passwordObj = document.getElementById("password");
				var reportPasswd=$("#reportPassword");
				if(passwordObj.value =="" && isSubmit == 0){
					$("#passwordOk").css("display","none");
					reportPasswd.css("display","none");
					passwordFlag = true;
				}else if(passwordRegex.test(passwordObj.value)){
					$("#passwordOk").css("display","");
					reportPasswd.css("display","none");
					passwordFlag = true;
			   	}else{
			   		$("#passwordOk").css("display","none");
			   		reportPasswd.css("display","");
			   		reportPasswd.attr("class","note");
			   		reportPasswd.text("�밴Ҫ����������");
			   		passwordFlag = false;
			   	}
				break;
			}
			case 3:
			{
				var passwordObj = document.getElementById("password");
				var rePasswordObj = document.getElementById("rePassword");
				var reportRepasswd = $("#reportRePassword");
				if(rePasswordObj.value != "" && !passwordRegex.test(rePasswordObj.value)){
					$("#rePasswordOk").css("display","none");
					reportRepasswd.css("display","");
					reportRepasswd.attr("class","note");
					reportRepasswd.text("ȷ�����벻�Ϸ�");
					rePasswordFlag = false;
				}else if(rePasswordObj.value!=passwordObj.value){
					$("#rePasswordOk").css("display","none");
					reportRepasswd.css("display","");
					reportRepasswd.attr("class","note");
					reportRepasswd.text("������������벻һ��");
					rePasswordFlag = false;
			   	}else if(rePasswordObj.value!=""){
			   		$("#rePasswordOk").css("display","");
			   		reportRepasswd.css("display","none");
			   		rePasswordFlag = true;
			   	}else{
					$("#rePasswordOk").css("display","none");
			   		reportRepasswd.css("display","none");
			   		rePasswordFlag = false;
		   		}
			   	break;
			}
			case 4:
			{
				var validateNumber = document.getElementById("validateNumber");
				var reportRandcode = $("#reportRandcode");
				if(validateNumber.value=="" && isSubmit == 0){
					reportRandcode.css("display","none");
					randCode = false;
				}else if(!/^[0-9a-zA-Z]{4}$/.test(validateNumber.value)){
					reportRandcode.css("display","");
					reportRandcode.attr("class","note");
					reportRandcode.text("������4λ�ַ���֤��");
					randCode = false;
				}else {
					reportRandcode.css("display","none");
					randCode = true;
				}
				break;
			}
			case 5:
			{
				var articleObj = document.getElementById("article");
				if (!articleObj.checked) {
					$("#reportArticle").css("display","");
					articleFlag = false;
					return false;
			   	}else{
			   		$("#reportArticle").css("display","none");
			   		articleFlag =true;
			   	}
			   	break;
			} 	
			case 6 :
			{
				var reportMobile=$("#reportMobile");
				var reportMobileOk=$("#reportMobileOk");
				var mobile = document.getElementById("tel").value;
				mobile = mobile.trim();
				if(mobile.length>0){
					if(regexMobile.test(mobile)){
						if((mobile.length >= 11) && (mobile.length <= 15)){
							reportMobile.css("display","none");
							reportMobileOk.css("display","");
							mobileFlag = true;
						}else{
							reportMobileOk.css("display","none");
							reportMobile.css("display","");
							reportMobile.attr("class","note");
							reportMobile.text("��������ȷ���ֻ���");
							mobileFlag = false;
						}
					}else{
						reportMobileOk.css("display","none");
						reportMobile.css("display","");
						reportMobile.attr("class","note");
						reportMobile.text("��������ȷ���ֻ���");
						mobileFlag = false;
					}
				}else{
					//Ҫ�����������µ�����
					//$("#reportMobileOk").css("display","none");
					//reportMobile.css("display","");
					//reportMobile.attr("class","note");
					//reportMobile.text("�������ֻ���");
					//mobileFlag = false;
					//��Ҫ��������
					
					reportMobile.css("display","none");
					mobileFlag =  true;
				}
				break;
			}
			case 7:
			{
				var emailObj = document.getElementById("email");
				
				var emailReg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;;
				var reportEmail = $("#reportMail");
				var reportEmailOk = $("#reportMailOk");
				if(emailObj.value != "") //email��ַ��Ϊ��
				{
					if(emailReg.test(emailObj.value))//email��ַ�Ϸ�
					{
						reportEmail.css("display","none");
						reportEmailOk.css("display","");
						emailFlag = true;
					}else
					{
						reportEmailOk.css("display","none");
						reportEmail.css("display","");
						reportEmail.attr("class","note");
						reportEmail.text("��������ȷ�������ַ");
						emailFlag = false;	
					}
				}else
				{
					// ǿ��Ҫ��
					//reportEmail.css("display","");
					//reportEmail.attr("class","note");
					//reportEmail.text("�����������ַ");
					//emailFlag = false;
					// ��ǿ��Ҫ��
					reportEmailOk.css("display","none");
					reportEmail.css("display","none");
					emailFlag = true;
				}
				break;	
			}
			case 8:
				{
					var qqNumberObj = document.getElementById("qq");
					var qqNumberReg = /^\s*[.0-9]{5,11}\s*$/;
					var reportQQ = $("#reportQQ");
					var reportQQOk = $("#reportQQOk");
					
					if(qqNumberObj.value != "")
					{
						if(qqNumberReg.test(qqNumberObj.value))
						{
							reportQQOk.css("display","");
							reportQQ.css("display","none");
							qqNumberFlag = true;
						}else
						{
							reportQQOk.css("display","none");
							reportQQ.css("display","");
							reportQQ.attr("class","note");
							reportQQ.text("��������ȷ��QQ����");
							qqNumberFlag = false;
						}
					}else
					{
						// ǿ��Ҫ��
						//reportQQ.css("display","");
						//reportQQ.attr("class","note");
						//reportQQ.text("������QQ����");
						//qqNumberFlag = false;
						// ��ǿ��Ҫ��
						reportQQOk.css("display","none");
						reportQQ.css("display","none");
						qqNumberFlag = true;
					}
					break;
				}
			default:
				
		}
	}
	String.prototype.trim = function(){
		return this.replace(/(^\s*)|(\s*$)/g, "");
	};
	function checkdata() {
		var isEnableSubmit = true;
		do
		{
			// username invalid
			if(!userNameFlag && !userNameRegex.test(userNameObj.value)){
				var reportObj = $("#report");
				reportObj.css("display","");
				reportObj.attr("class","note");
				$("#userNameOk").css("display","none");
				reportObj.text("�밴�Ҳ�Ҫ����д�û���");
				isEnableSubmit = false;
				break;
			}
			// check password/repassword/mobile/validNumber/article/email/qq
			checkMsg(2,1);
			checkMsg(3,1);
			checkMsg(4,1);
			checkMsg(5,1);
			checkMsg(6,1);
			checkMsg(7,1);
			checkMsg(8,1);
			// specially check services
			if(!articleFlag)
			{
				alert("�������Ķ������ܷ����������ע��!");
				isEnableSubmit = false;
				break;
			}
			// if one condition does not match
			if(!passwordFlag || !rePasswordFlag || !randCode || !emailFlag || !qqNumberFlag || !mobileFlag)
			{
				isEnableSubmit = false;
				break;
			}
		}while(false);
		
		return isEnableSubmit;
	}