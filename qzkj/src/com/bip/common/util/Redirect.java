package com.bip.common.util;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class Redirect {
	private static HttpServletResponse response = ServletActionContext
			.getResponse();

	public static void go() {
		try {
			System.out.println("Go Logout......");
			response.sendRedirect("/zcxgov/templates/quit.html");
		} catch (Exception ex) {

		}
	}
}
