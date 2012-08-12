package com.bip.common.page;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class PagerFilter implements Filter {   
    public void destroy() {   
    }   
    public void doFilter(ServletRequest request, ServletResponse response,   
            FilterChain chain) throws IOException, ServletException {   
        HttpServletRequest httpRequest =(HttpServletRequest)request;   
        SystemContext.setOffset(getOffset(httpRequest));   
        SystemContext.setPageSize(getPageSize(httpRequest));   
        try{   
            chain.doFilter(request, response);   
        }finally{   
            //清空ThreadLocal中的值   
            SystemContext.removeOffset();   
            SystemContext.removePageSize();   
        }              
    }   
    public void init(FilterConfig arg0) throws ServletException {   
    }   
    public int getOffset(HttpServletRequest request){   
        int offset = 0;   
        try {   
            offset = Integer.parseInt(request.getParameter("pager.offset"));   
            
            

//System.out.println("         offset        "+offset);
            
        } catch (NumberFormatException ignore) {   
        }   
        return offset;   
    }      
        //设置每页显示多少条记录   
    public int getPageSize(HttpServletRequest request){   
        return 3;   
    }   
}   
