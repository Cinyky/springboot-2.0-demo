package com.cyy.springdemo.Intreceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * 会话拦截器
 * 没有登录成功的用户除了登录&资源无法访问其他页面
 * @Author： Cyy
 * @Date: 2018/6/1
 * @Time: 上午11:16
 * ========================
 */
public class SessionUserIntreceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(request.getRequestURI());
        //登录不做拦截
        if (request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")  || request.getRequestURI().equals("/test") || request.getRequestURI().contains("/web/resources")) {
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");
        if (obj == null) {
            try {
                response.sendRedirect("/user/login_view");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
