package com.mocker;/**
 * Created by sunwukong on 16/12/10.
 */

import com.mocker.core.permission.domain.SysUser;
import com.mocker.core.permission.service.ISysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mocker
 * @Date 2016-12-10 下午2:40
 * @Version 1.0
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
