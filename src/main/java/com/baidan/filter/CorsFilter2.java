/**
 *    
 *  @Title: CorsFilter.java 
 *  @Description: TODO 
 *  @version V1.0   
 */
package com.baidan.filter;

import org.apache.commons.httpclient.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 
  * @ClassName CorsFilter  
   * @Description TODO 
  * @author A8885 
 *   @date 2017年5月27日  
 *   
 */
@WebFilter("/*")
public class CorsFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpStatus.SC_NO_CONTENT);
        }

        System.out.println("过滤器2执行了...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

}
