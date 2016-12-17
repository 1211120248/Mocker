package com.mocker.web.admin;

import com.mocker.Constants;
import com.mocker.core.base.wrapper.JsonResult;
import com.mocker.core.permission.data.SysUserData;
import com.mocker.core.permission.service.ISysUserService;
import com.mocker.shiro.ShiroUtils;
import com.mocker.util.CaptchaUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


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

    @ApiOperation("生成验证码")
    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = CaptchaUtils.createCaptcha();
        //生成图片验证码
        BufferedImage image = CaptchaUtils.createImg(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.CAPTCHA_SESSION_KEY,text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(@RequestBody SysUserData sysUserData){
        //判断验证码是否正确 从session中取出验证码
        String captcha2 = (String) ShiroUtils.getSessionAttribute(Constants.CAPTCHA_SESSION_KEY);
        ShiroUtils.removeSessionAttribute(Constants.CAPTCHA_SESSION_KEY);
        if(!captcha2.equalsIgnoreCase(sysUserData.getCaptcha())){
            return JsonResult.getError("验证码错误!");
        }

        //获取用户主题
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(sysUserData.getLoginName(),new Sha256Hash(sysUserData.getPassword()).toHex()));
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
