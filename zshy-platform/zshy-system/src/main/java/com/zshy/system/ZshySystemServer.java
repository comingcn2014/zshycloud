package com.zshy.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zshy.core.feign.annotation.EnableZshyFeign;

/**
 * 管理系统后台启动类
 * @author yanghaifeng
 */
@EnableZshyFeign
@SpringBootApplication
public class ZshySystemServer {
    public static void main(String[] args) {
        SpringApplication.run(ZshySystemServer.class, args);
    }
}
