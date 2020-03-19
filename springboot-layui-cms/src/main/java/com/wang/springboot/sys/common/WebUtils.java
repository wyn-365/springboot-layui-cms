package com.wang.springboot.sys.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 王一宁
 * @date 2020/3/17 12:27
 */
public class WebUtils {
    /**
     * 拿到request
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    /**
     * 拿到session
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }
}
