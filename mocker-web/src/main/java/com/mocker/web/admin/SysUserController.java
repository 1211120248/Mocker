package com.mocker.web.admin;

import com.mocker.core.base.query.BaseQuery;
import com.mocker.core.base.wrapper.JsonResult;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;


/**
 * @author 用户控制器
 * @Date 2016-12-12 上午12:02
 * @Description
 * @Version 1.0
 */
@Api("用户管理")
@RestController
@RequestMapping(value="/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @PermitAll
    @ApiOperation("获取用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult list(BaseQuery baseQuery) {
        PageResult pageResult = userService.findAll(baseQuery);
        return JsonResult.getSuccess(pageResult);
    }

    @ApiOperation("根据ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String",paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult get(@PathVariable("id") String id) {
        SysUser sysUser = userService.findById(id);
        return JsonResult.getSuccess(sysUser);
    }

    @ApiOperation(value="更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "sysUser", value = "用户详细实体user", required = true, dataType = "SysUser")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult update(@PathVariable("id") String id, @RequestBody SysUser sysUser) {
        sysUser.setId(id);
        userService.save(sysUser);
        return JsonResult.getSuccess();
    }


    @ApiOperation(value="添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUser", value = "用户详细实体user", required = true, dataType = "SysUser")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResult save(@RequestBody SysUser sysUser) {
        sysUser.setPassword(new Sha256Hash(sysUser.getPassword()).toHex());
        userService.save(sysUser);
        return JsonResult.getSuccess();
    }

    @ApiOperation(value="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delete(@PathVariable("id") String id) {
        userService.delete(id);
        return JsonResult.getSuccess();
    }
}
