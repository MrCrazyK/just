package com.just.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }



    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse rsp = (HttpServletResponse) response;
        System.out.println("===========================================================================================================");
        rsp.setHeader("Access-Control-Allow-Origin", "*");

        chain.doFilter(request, rsp);
    }



    public void destroy() {

    }
}
