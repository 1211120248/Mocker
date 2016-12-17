package com.mocker.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author Mocker
 * @Date 2016-12-17 下午10:09
 * @Description shiro工具类
 * @Version 1.0
 */
public class ShiroUtils {

    /**
     * 获取shiro session
     * @return
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 设置属性
     * @param key
     * @param value
     */
    public static void setSessionAttribute(Object key,Object value){
        getSession().setAttribute(key,value);
    }

    /**
     * 获取属性
     * @param key
     * @return
     */
    public static Object getSessionAttribute(String key) {
        return  getSession().getAttribute(key);
    }

    /**
     * 删除属性
     * @param key
     * @return
     */
    public static void removeSessionAttribute(String key) {
        getSession().removeAttribute(key);
    }
}
