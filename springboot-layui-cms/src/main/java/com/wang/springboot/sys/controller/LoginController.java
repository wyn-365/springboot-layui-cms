package com.wang.springboot.sys.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.wang.springboot.sys.common.ActiveUser;
import com.wang.springboot.sys.common.ResultObj;
import com.wang.springboot.sys.common.WebUtils;
import com.wang.springboot.sys.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

/**
 * @author 王一宁
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public ResultObj login(String loginname, String pwd, String code,HttpSession session){
        //获得存储在session中的验证码
        String sessionCheckCode = (String) session.getAttribute("code");
        //判断验证码是否正确
        if (code!=null && sessionCheckCode.equals(code)){
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(loginname,pwd);
            try {
                //登录成功
                subject.login(token);
                ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
                WebUtils.getSession().setAttribute("user",activeUser.getUser());
                return ResultObj.LOGIN_SUCCESS;
            }catch (AuthenticationException e){
                //登陆失败
                return ResultObj.LOGIN_ERROR_PASS;
            }
        }else {
            //登陆失败，提示验证码不正确！
            return ResultObj.LOGIN_CHECKCODE_ERROR_PASS;
        }



    }

    /**
     * 得到登陆验证码
     * @param response
     * @param session
     * @throws
     */
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //HuTool定义图形验证码的长和宽,验证码的位数，干扰线的条数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,10);
        //将验证码放入session
        session.setAttribute("code",lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

