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
 * ʵ���û���¼����Ȩ�޼�顣ʵ�ִ˹�����ʱ��������web.xml�н�����Ӧ���ã�������\uFFFD �������Ժ������ҳ���URLģʽ�� Servlet
 * 2.3�Ժ�İ汾��֧��Filter���ơ�
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
	 * ��ʼ����������ϵͳ����ʱ���ø÷���
	 * 
	 * @param config
	 *            - ���ò�����ͨ�������Է���ServletContext������������
	 * @throws javax.servlet.ServletException
	 * 
	 */
	public void init(FilterConfig config) throws ServletException {
		setContext(config.getServletContext());
		setFilterName(config.getFilterName());
		directUrl = config.getInitParameter("directUrl");
	}

	/*
	 * ���ݿͻ�����������������������ԣ�ȷ������������ݵı��뷽ʽ�� ��������Ӧ���ַ�������
	 * 
	 * @param req �������
	 * 
	 * @param resp ��Ӧ����
	 */
	public void changeCharacterEncoding(HttpServletRequest req,
			HttpServletResponse resp) {
		// ��HTTP�����ͷ��Ϣ�л�ȡ�ͻ��˵���������
		String clientLanguage = req.getHeader("Accept-Language");
		// aiLogger.log("ClientLanguage: " + clientLanguage);
		logger.info("clientLanguage: " + clientLanguage);
		try {
			if (clientLanguage != null) {
				if (clientLanguage.indexOf("zh-cn") >= 0) { // �������������
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: �������������");
				} else if (clientLanguage.indexOf("zh-tw") >= 0) { // �������������
					req.setCharacterEncoding("BIG5");
					resp.setContentType("text/html; charset=BIG5");
					// aiLogger.log("ClientLanguage: �������������");
				} else if (clientLanguage.indexOf("jp") >= 0) { // ���������
					req.setCharacterEncoding("SJIS");
					resp.setContentType("text/html; charset=SJIS");
					// aiLogger.log("ClientLanguage: ���������");
				} else if (clientLanguage.indexOf("en-us") >= 0) { // Ӣ�������
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: ���������");
				} else if (clientLanguage.indexOf("en-zh") >= 0) { // ���������
					req.setCharacterEncoding("GB2312");
					resp.setContentType("text/html; charset=GB2312");
					// aiLogger.log("ClientLanguage: ���������");
				}

				else { // ȱʡ��Ϊ��Ӣ�������
					req.setCharacterEncoding("ISO-8859-1");
					resp.setContentType("text/html; charset=ISO-8859-1");
					// aiLogger.log("ClientLanguage: ȱʡ��Ϊ��Ӣ�������");
				}
			}
		} catch (java.io.UnsupportedEncodingException uee) {
			logger
					.severe("Not supported charset! Please check your system environment!");
			uee.printStackTrace();
		}
	}

	/**
	 * ���û����ʴ˹�������Ͻ��ҳ��ʱ��ϵͳ���ô˹�����ִ�й��˲��������ݵ����ߵ�Ȩ��ȷ
	 * ���Ƿ���Է��ʱ���ҳ�����������δע�ᣬ���ض��򵽵�¼ҳ�棻���������û��Ȩ�ޣ� ���ض�����Ȩ�޴���澯ҳ�棻���ͨ�����������û����ʡ�
	 * 
	 * @param request
	 *            ���������Ԫ������ʶ
	 * @param response
	 *            ��Ӧ
	 * @param chain
	 *            ��������
	 * @throws javax.servlet.ServletException
	 *             Servlet�쳣
	 * @throws java.io.IOException
	 *             IO�쳣
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
			 * �жϵ�¼�û��Ƿ���ʧЧ
			 */
			if ("web".equals((url.substring(1,4)))) {
				// ��ҵ�û�
				
				String projcode = (String) session.getAttribute("projcode");
				if (projcode == null||"".equals(projcode)) {
					resp.sendRedirect("/zcxjngl/templates/ent_quit.html");
				} else {
					chain.doFilter(request, response);
					return;
				}
			} else {
				// �����û�
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
	 * �ƺ���ϵͳֹͣ����ʱ���ô˷���
	 * 
	 * @roseuid 3F73B458033D
	 */
	public void destory() {

	}

	/**
	 * �ƺ���ϵͳֹͣ����ʱ���ô˷���
	 */
	public void destroy() {
		config = null;
	}

	/**
	 * ������Ա�Ƿ�ӵ��ĳԪ������Ȩ�ޡ�����У�����True�����򣬷���False��
	 * 
	 * @param operatorId
	 *            ����Ա���
	 * @param metaFuncId
	 *            Ԫ�������
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