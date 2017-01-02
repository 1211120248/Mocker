package com.mocker.web.admin;

import com.mocker.core.base.query.BaseQuery;
import com.mocker.core.base.wrapper.JsonResult;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.domain.SysRole;
import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.service.ISysRoleService;
import com.mocker.core.permission.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;


/**
 * @author 角色控制器
 * @Date 2016-12-12 上午12:02
 * @Description
 * @Version 1.0
 */
@Api("角色管理")
@RestController
@RequestMapping(value="/role")
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    @ApiOperation(value="添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRole", value = "菜单详细实体", required = true, dataType = "SysRole")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResult save(@RequestBody SysRole sysRole) {
        sysRoleService.save(sysRole);
        return JsonResult.getSuccess();
    }

    @ApiOperation(value="获取角色列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult list() {
        List<SysRole> sysRoles = sysRoleService.findAll();
        return JsonResult.getSuccess(sysRoles);
    }

}
