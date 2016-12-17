package com.mocker.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Mocker
 * @Date 2016-12-17 下午8:41
 * @Description 系统后台导航
 * @Version 1.0
 */

@Controller
public class SysNavController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "page/login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "page/index";
    }

}
