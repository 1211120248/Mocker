package com.mocker.web.admin;

import com.mocker.core.base.query.BaseQuery;
import com.mocker.core.base.utils.BeanCopyUtils;
import com.mocker.core.base.wrapper.JsonResult;
import com.mocker.core.base.wrapper.PageResult;
import com.mocker.core.permission.data.SysMenuData;
import com.mocker.core.permission.domain.SysMenu;
import com.mocker.core.permission.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-12 上午12:02
 * @Description 权限菜单
 * @Version 1.0
 */
@Api("权限菜单")
@RestController
@RequestMapping(value="/menu")
public class SysMenuController {

    @Autowired
    private ISysMenuService authMenuService;


    @ApiOperation("获取所有模块")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public JsonResult getAllModule() {
        List<SysMenu> sysMenuList = authMenuService.findAllModule();
        return JsonResult.getSuccess(sysMenuList);
    }

    @ApiOperation("获取所有的菜单")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public JsonResult getAll() {
        List<SysMenu> sysMenuList = authMenuService.findAll();
        return JsonResult.getSuccess( authMenuService.copyList(sysMenuList));
    }

    @ApiOperation("根据ID获取菜单")
    @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "String",paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult get(@PathVariable("id") String id) {
        SysMenu sysMenu = authMenuService.findById(id);
        return JsonResult.getSuccess(sysMenu);
    }

    @ApiOperation(value="更新菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "sysMenu", value = "菜单实体信息", required = true, dataType = "SysMenu")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult update(@PathVariable("id") String id, @RequestBody SysMenu sysMenu) {
        sysMenu.setId(id);
        authMenuService.save(sysMenu);
        return JsonResult.getSuccess();
    }


    @ApiOperation(value="添加菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysMenu", value = "菜单实体信息", required = true, dataType = "SysMenu")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResult save(@RequestBody SysMenu sysMenu) {
        authMenuService.save(sysMenu);
        return JsonResult.getSuccess();
    }

    @ApiOperation(value="删除菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单Id", required = true, dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delete(@PathVariable("id") String id) {
        authMenuService.delete(id);
        return JsonResult.getSuccess();
    }

}
