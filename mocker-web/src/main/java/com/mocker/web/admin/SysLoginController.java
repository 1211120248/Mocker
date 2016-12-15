package com.mocker.web.admin;

import com.mocker.core.base.wrapper.JsonResult;
import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author 登录
 * @Date 2016-12-12 上午12:02
 * @Description
 * @Version 1.0
 */
@Api("登录管理")
@Controller
@RestController(value="/")
public class SysLoginController {

    @Autowired
    private ISysUserService userService;

    @ApiOperation("登录")
    @ApiImplicitParam(name = "sysUser", value = "用户", required = true, dataType = "SysUser")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(@RequestBody SysUser sysUser){
        //获取用户主题
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(sysUser.getUsername(),sysUser.getPassword()));
        }catch (UnknownAccountException e) {
            return JsonResult.getError(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return JsonResult.getError(e.getMessage());
        }catch (LockedAccountException e) {
            return JsonResult.getError(e.getMessage());
        }catch (AuthenticationException e) {
            return JsonResult.getError(e.getMessage());
        }
        return JsonResult.getSuccess();
    }
}