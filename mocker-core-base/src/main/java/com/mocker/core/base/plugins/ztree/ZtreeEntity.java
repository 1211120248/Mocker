package com.mocker.core.base.plugins.ztree;

import io.swagger.annotations.ApiModel;

/**
 * @author Mocker
 * @Date 2016-12-28 上午1:41
 * @Description ztree实体
 * @Version 1.0
 */
public class ZtreeEntity {

    /**
     * 节点Id
     */
    private String id;

    /**
     * 父节点ID
     */
    private String pId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 是否展开
     */
    private boolean open;

    /**
     * 图标
     */
    private String icon;


    public ZtreeEntity(String id, String pid, String name, boolean open) {
        this.id = id;
        this.pId = pid;
        this.name = name;
        this.open = open;
    }

    public ZtreeEntity(String id, String pId, String name, boolean open, String icon) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
