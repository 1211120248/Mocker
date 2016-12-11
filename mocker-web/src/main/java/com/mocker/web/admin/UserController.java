package com.mocker.web.admin;

import com.mocker.core.permission.domain.User;
import com.mocker.core.permission.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 用户控制器
 * @Date 2016-12-12 上午12:02
 * @Description 权限菜单按钮
 * @Version 1.0
 */
@Api("用户管理")
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list() {
        List<User> userList = userService.findAll();
        return userList;
    }

    @ApiOperation("根据ID获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") String id) {
        User user = userService.getOne(id);
        return user;
    }

    @ApiOperation(value="更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id,@RequestBody User user) {
        user.setId(id);
        userService.save(user);
        return "success";
    }


    @ApiOperation(value="添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String save(@PathVariable String id,@RequestBody User user) {
        user.setId(id);
        userService.save(user);
        return "success";
    }

    @ApiOperation(value="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "String")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        userService.delete(id);
        return "success";
    }
}