package com.bip.common.util;

/*******************************************************
 * <p>Title: PermissionFilter </p>
 * <p>Description:  PermissionFilter is filter</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: zcx</p>
 * <p>author : zhaosy  zhaosy_1022@163.com
 * @version 1.0
 **********************************************************/

import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.http.*;

import com.bip.sys.user.po.SysUsers;

import java.io.IOException;

/**
 * 实现用户登录检查和权限检查。实现此过滤器时，必须在web.xml中进行相应配置，包括过\uFFFD 器的属性和其控制页面的URL模式。 Servlet
 * 2.3以后的版本才支持Filter机制。
 * 
 */
public class PermissionFilter implements Filter {

	protected FilterConfig config;
	private ServletContext context;
	private String filterName;
	String directUrl = null;
	String superAdminId;

	private static Logger logger = Logger.getLogger("com.bip.common.util");

	/**
	 * init
	 */
	public PermissionFilter() {

	}

	/**
	 * 初始化过滤器，系统启动时调用该方法
	 * 
	 * @param config
	 *            - 配置参数，通过它可以访问ServletContext、过滤器名等
	 * @throws javax.servlet.ServletException
	 * 
	 */
	public void init(FilterConfig config) throws ServletException {
		setContext(config.getServletContext());
		setFilterName(config.getFilterName());
		directUrl = config.getInitParameter("directUrl");
	}

	/*
	 * 根据客户端请求的语言输入语言属性，确定对输入的数据的编码方式， 并设置响应的字符集属性
	 * 
	 * @param req 请求对象
	 * 
	 * @param resp 响应对象
	 */
	public void changeCharacterEncoding(HttpServletRequest req,
			HttpServletResponse resp) {
		// 从HTTP请求的头信息中获取客户端的语言设置
		String clientLanguage = req.getHeader("Accept-Language");
		// aiLogger.log("ClientLanguage: " + clientLanguage);
		logger.info("clientLanguage: " + clientLanguage);
		try {
			if (clientLanguage != null) {
				if (clientLanguage.indexOf("zh-cn") >= 0) { // 简体中文浏览器
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: 简体中文浏览器");
				} else if (clientLanguage.indexOf("zh-tw") >= 0) { // 繁体中文浏览器
					req.setCharacterEncoding("BIG5");
					resp.setContentType("text/html; charset=BIG5");
					// aiLogger.log("ClientLanguage: 繁体中文浏览器");
				} else if (clientLanguage.indexOf("jp") >= 0) { // 日文浏览器
					req.setCharacterEncoding("SJIS");
					resp.setContentType("text/html; charset=SJIS");
					// aiLogger.log("ClientLanguage: 日文浏览器");
				} else if (clientLanguage.indexOf("en-us") >= 0) { // 英文浏览器
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: 日文浏览器");
				} else if (clientLanguage.indexOf("en-zh") >= 0) { // 中文浏览器
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: 日文浏览器");
				}

				else { // 缺省认为是英文浏览器
					req.setCharacterEncoding("ISO-8859-1");
					resp.setContentType("text/html; charset=ISO-8859-1");
					// aiLogger.log("ClientLanguage: 缺省认为是英文浏览器");
				}
			}
		} catch (java.io.UnsupportedEncodingException uee) {
			logger
					.severe("Not supported charset! Please check your system environment!");
			uee.printStackTrace();
		}
	}

	/**
	 * 当用户访问此过滤器管辖的页面时，系统调用此过滤器执行过滤操作，根据调用者的权限确
	 * 定是否可以访问本网页。如果调用者未注册，则重定向到登录页面；如果调用者没有权限， 则重定向到无权限错误告警页面；如果通过，则允许用户访问。
	 * 
	 * @param request
	 *            请求，需包含元操作标识
	 * @param response
	 *            响应
	 * @param chain
	 *            过滤器链
	 * @throws javax.servlet.ServletException
	 *             Servlet异常
	 * @throws java.io.IOException
	 *             IO异常
	 * @roseuid 3F73B01F02E9
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		changeCharacterEncoding(req, resp);
		HttpSession session = req.getSession();

		String url = req.getRequestURI();

		url = url.substring(url.lastIndexOf("/"));
		logger.info("url is >>> " + url
				+ " >>> the action is accessed directly!");
		if (directUrl.indexOf(url) > -1) {
			logger.info("directUrl.indexOf(url) > -1!");
			chain.doFilter(request, response);
			return;
		} else {
			logger.info("directUrl.indexOf(url) < -1!");
			/*
			 * 判断登录用户是否已失效
			 */
			if ("web".equals((url.substring(1,4)))) {
				// 企业用户
				
				String projcode = (String) session.getAttribute("projcode");
				if (projcode == null||"".equals(projcode)) {
					resp.sendRedirect("/zcxjngl/templates/ent_quit.html");
				} else {
					chain.doFilter(request, response);
					return;
				}
			} else {
				// 管理用户
				SysUsers sysuser = (SysUsers) session.getAttribute("sysuser");
				if (sysuser == null) {
					resp.sendRedirect("/zcxjngl/templates/quit.html");
				} else {
					chain.doFilter(request, response);
					return;
				}
			}
		}
	}

	/**
	 * 善后处理，系统停止运行时调用此方法
	 * 
	 * @roseuid 3F73B458033D
	 */
	public void destory() {

	}

	/**
	 * 善后处理，系统停止运行时调用此方法
	 */
	public void destroy() {
		config = null;
	}

	/**
	 * 检查操作员是否拥有某元操作的权限。如果有，返回True；否则，返回False。
	 * 
	 * @param operatorId
	 *            操作员编号
	 * @param metaFuncId
	 *            元操作编号
	 * @return Boolean
	 * @roseuid 3F740C480012
	 */

	/**
	 * @roseuid 3F755A8D0215
	 */
	public FilterConfig getFilterConfig() {
		return config;
	}

	/**
	 * @param filterConfig
	 * @roseuid 3F755A8D021F
	 */
	public void setFilterConfig(FilterConfig filterConfig) {
		config = filterConfig;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public ServletContext getContext() {
		return context;
	}

}