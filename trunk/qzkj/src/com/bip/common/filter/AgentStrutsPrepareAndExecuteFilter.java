package com.bip.common.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareFilter;
//
public class AgentStrutsPrepareAndExecuteFilter implements Filter{
	StrutsExecuteFilter strutsFilter=null;
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain filterChain) throws IOException, ServletException{
		HttpServletRequest req=(HttpServletRequest)request;
		
		String uri=req.getRequestURI();
		
		if(uri.indexOf(".filemanage")==-1)
		strutsFilter.doFilter(request, response, filterChain);
		else
			filterChain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("Ö´ÐÐµ½´Ë£¡£¡£¡");
	}

	public void init(FilterConfig arg0) throws ServletException {
		 strutsFilter=new StrutsExecuteFilter();
		strutsFilter.init(arg0);
		
	}
	
}
