/**   
 * @Project: tfs-plm-web 
 * @Title: OnlineInterceptor.java 
 * @Package com.tfstec.plm.interceptor 
 * @Description: 拦截器 
 * @author lx 
 * @date 2016年6月2日 下午5:37:10 
 * @Copyright: 2016 年 前海阿拉海钜科技. All rights reserved  
 * @version V1.0   
 */
package com.baidan.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * @ClassName OnlineInterceptor  
 * @Description 拦截器
 */
public class OnlineInterceptor implements HandlerInterceptor {
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>(
			"StopWatch-StartTime");
	private static Logger logger = LoggerFactory.getLogger(OnlineInterceptor.class);

	/**
	 * 不需要登陆的链接地址
	 */
	private static final String[] MAPPING = new String[]{"/tfs-jhzt-web/user/login.htm","/tfs-jhzt-web/page/login.htm","/tfs-jhzt-web/"};


	/*
	 * 处理完成后被调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2,
			Exception arg3) throws Exception {
		// 结束时间
		long endTime = System.currentTimeMillis();
		// 得到线程绑定的局部变量（开始时间）
		long beginTime = startTimeThreadLocal.get();
		// 消耗的时间
		long consumeTime = endTime - beginTime;
		// 此处认为处理时间超过500毫秒的请求为慢请求
		if (consumeTime > 500) {
			// 记录到日志文件
			System.out.println(
					String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
		}
	}

	/*
	 * 处理前被调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
	    response.setContentType("text/html;charset=UTF-8");
		long beginTime = System.currentTimeMillis();// 1、开始时间
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）

        HttpSession session = request.getSession();
		String requestURI = request.getRequestURI();
		logger.info(requestURI);

		if(!requestURI.equals("")) {
			//不需要登陆的链接地址
			for (int i = 0; i < MAPPING.length; i++) {
				logger.info("MAPPING[i]==="+MAPPING[i]);
				logger.info("requestURI==="+requestURI);
				if (requestURI.equals(MAPPING[i])) {
					logger.error(MAPPING[i] + "======放行");
					return true;
				}
			}
		}

		String token = (String) session.getAttribute("token");
		return false;
	}

	/*
	 * 处理完成后，生成视图前被调用
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView model) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
	}
}
