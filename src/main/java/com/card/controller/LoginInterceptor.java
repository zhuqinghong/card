package com.card.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qinghong.zhu on 2021/4/26.
 *
 * @author qinghong.zhu
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 获取请求的uri
        String uri = request.getRequestURI();
        // 除了login.jsp是可以公开访问的，其它的URL都没拦截
        if (uri.contains("login") || uri.contains("index")) {
            return true;
        } else {
            // 获取session
            HttpSession session = request.getSession();
            UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
            CardInfo cardInfo = (CardInfo)session.getAttribute("cardInfo");
            // 判断session中是否有用户数据，如果有数据，则返回true。否则重定向到登录页面
            if (userInfo != null && cardInfo != null) {
                return true;
            } else {
                response.sendRedirect("/card/index");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
