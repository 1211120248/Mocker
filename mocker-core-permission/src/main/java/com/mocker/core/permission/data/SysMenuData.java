package com.mocker.core.permission.data;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-11 下午11:40
 * @Description 权限菜单
 * @Version 1.0
 */
public class SysMenuData {
    private String id;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("菜单地址")
    private String url;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("父级ID")
    private String parentId;

    @ApiModelProperty("父级名称")
    private String parentName;

    @ApiModelProperty("图片")
    private String icon;

    @ApiModelProperty("菜单类型")
    private Integer type;

    @ApiModelProperty("菜单状态:0 禁用 1启用")
    private Integer state;

    @ApiModelProperty("是否是展开的")
    private boolean open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
