/**
 * ������VerifyCodeServletAction.java
 *
 * ���Struts2 Action
 * ���ܣ���֤�����ɡ�
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-12  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */
package com.bip.sys.login.action;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport; //ģ���
import com.bip.common.action.baseAction;
import com.bip.common.util.VerifyCode;
@Controller
public class VerifyCodeServletAction extends baseAction {
	private String message;

	public void generateImageCode() {
		try {
			// System.out.println("begin generate verifycode......");
			// ��������������汾ҳ
			// response.setHeader("Cache-Control", "no-cache");

			// ������֤�룬д���û�session
			String verifyCode = VerifyCode.generateTextCode(
					VerifyCode.TYPE_ALL_MIXED, 4, "0oOilJI1");
			// System.out.println("generate verifycode is "+verifyCode);
			this.getSession().setAttribute("verifyCode", verifyCode);

			// �����֤����ͻ���
			this.getResponse().setContentType("image/jpeg");
			BufferedImage bim = VerifyCode.generateImageCode(verifyCode, 120,
					30, 2, true, Color.WHITE, Color.BLACK, null);
			ImageIO.write(bim, "JPEG", this.getResponse().getOutputStream());

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
