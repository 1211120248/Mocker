package com.mocker.core.base.plugins.ztree;

/**
 * @author Mocker
 * @Date 2016-12-28 上午1:41
 * @Description ztree实体
 * @Version 1.0
 */
public class ZtreeEntity {

    private String id;

    private String pid;

    private String name;

    private boolean open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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
}
