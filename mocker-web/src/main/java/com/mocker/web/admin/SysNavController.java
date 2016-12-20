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

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "page/login";
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "page/index";
    }

    /**
     * 用户管理
     * @return
     */
    @RequestMapping(value = "/user/page",method = RequestMethod.GET)
    public String userManager(){
        return "page/user";
    }

    /**
     * 菜单管理
     * @return
     */
    @RequestMapping(value = "/menu/page",method = RequestMethod.GET)
    public String menuManager(){
        return "page/menu";
    }

}
