/**
 * 类名：VerifyCodeServletAction.java
 *
 * 类别：Struts2 Action
 * 功能：验证码生成。
 * 
 *   Ver     変更日               部门            担当者        変更内容
 * ──────────────────────────────────────────────
 *   V1.00  2010-9-12  CFIT-PM   赵胜运         初版
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

import com.opensymphony.xwork2.ActionSupport; //模块包
import com.bip.common.action.baseAction;
import com.bip.common.util.VerifyCode;
@Controller
public class VerifyCodeServletAction extends baseAction {
	private String message;

	public void generateImageCode() {
		try {
			// System.out.println("begin generate verifycode......");
			// 设置浏览器不缓存本页
			// response.setHeader("Cache-Control", "no-cache");

			// 生成验证码，写入用户session
			String verifyCode = VerifyCode.generateTextCode(
					VerifyCode.TYPE_ALL_MIXED, 4, "0oOilJI1");
			// System.out.println("generate verifycode is "+verifyCode);
			this.getSession().setAttribute("verifyCode", verifyCode);

			// 输出验证码给客户端
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
