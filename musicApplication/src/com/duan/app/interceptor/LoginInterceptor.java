package com.duan.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName:LoginInterceptor.java
 * @Description:TODO
 * @author duan
 * @Time 2019年5月23日下午4:54:35
 * 
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
	    throws Exception {
	// TODO 自动生成的方法存根

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
	    throws Exception {
	// TODO 自动生成的方法存根

    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
	System.out.println("LoginInterceptor。。。。。。");
	
	String url = arg0.getRequestURI();
	HttpSession session = arg0.getSession();
	if (url.equals("/musicApplication/admin/login.action")
		|| url.equals("/musicApplication/musics/selectAllMusics.action")) {
	    return true;
	} else if (session.getAttribute("adminname") != null) {
	    return true;
	}
	arg1.sendRedirect("/musicApplication/login");
	return false;
    }

}
