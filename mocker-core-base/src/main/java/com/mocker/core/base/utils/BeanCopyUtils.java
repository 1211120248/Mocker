package com.mocker.core.base.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.List;

/**
 * @author Mocker
 * @Date 2016-12-24 下午7:52
 * @Description Bean对象拷贝 使用Cgilb 性能最好
 * @Version 1.0
 */
public class BeanCopyUtils {
    /**
     * 批量集合元素转换
     * @param beanCopier
     * @param targetClass
     * @param sourceObject
     * @param targetObject
     * @return
     */
    public static List copyList(BeanCopier beanCopier, Class targetClass, List<Object> sourceObject, List<Object> targetObject){
        for (int i = 0; i < sourceObject.size(); i++) {
            try {
                Object o = sourceObject.get(i);
                Object o2 = targetClass.newInstance();
                beanCopier.copy(o,o2,null);
                targetObject.add(o2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return targetObject;
    }
}
