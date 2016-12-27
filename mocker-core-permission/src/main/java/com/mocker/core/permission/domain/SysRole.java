package com.mocker.core.permission.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-28 上午12:50
 * @Description 角色
 * @Version 1.0
 */
@Table(name = "S_ROLE")
@Entity
public class SysRole {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @ApiModelProperty("角色名称")
    @Column(name = "name",length = 50,nullable = true)
    private String name;

    @ApiModelProperty("角色备注")
    @Column(name = "note",length = 100,nullable = true)
    private String note;

    @ApiModelProperty("菜单列表")
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = SysUser.class)
    @JoinTable(name = "S_ROLE_MENU", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "MENU_ID") })
    private List<SysMenu> menuList;

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


    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
