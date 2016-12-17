package com.mocker.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * @author Mocker
 * @Date 2016-12-17 下午10:32
 * @Description 验证码工具类
 * @Version 1.0
 */
public class CaptchaUtils {

    public static DefaultKaptcha producer;
    static {
        producer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.borde","no");
        properties.setProperty("kaptcha.textproducer.font.color","black");
        properties.setProperty("kaptcha.textproducer.char.space","5");
        Config config = new Config(properties);
        producer.setConfig(config);
    }

    /**
     * 生成验证码
     * @return
     */
    public static String createCaptcha(){
        return producer.createText();
    }

    /**
     * 获取验证码图片
     * @param code
     * @return
     */
    public static BufferedImage createImg(String code){
        return producer.createImage(code);
    }

}
