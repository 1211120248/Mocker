package com.mocker.core.permission.utils;

/**
 * @author Mocker
 * @Date 2016-12-17 下午10:13
 * @Description 常量类
 * @Version 1.0
 */
public class Constants {

    /**
     * 验证码 Key
     */
    public static final String CAPTCHA_SESSION_KEY = "captcha.code.session.key";


    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 系统
         */
        SYSTEM(0),
        /**
         * 模块
         */
        MODULE(1),
        /**
         * 页面
         */
        PAGE(2),
        /**
         * 按钮
         */
        BUTTON(3);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
