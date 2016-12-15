package com.mocker.web.admin;

import com.mocker.core.permission.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * @author 登录
 * @Date 2016-12-12 上午12:02
 * @Description
 * @Version 1.0
 */
@Api("登录管理")
@Controller
@RequestMapping(value="/")
public class LoginController {

    private HttpSessionCsrfTokenRepository csrfTokenRepository = new  HttpSessionCsrfTokenRepository();

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest){
        Object attribute = httpServletRequest.getAttribute("org.springframework.security.web.csrf.CsrfToken");
        return "page/login";
    }
}