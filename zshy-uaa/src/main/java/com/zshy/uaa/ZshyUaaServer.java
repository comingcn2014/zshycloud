package com.zshy.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zshy.core.feign.annotation.EnableZshyFeign;

/**
 * 认证启动类
 *
 * @author yanghaifeng
 * @date 2019-10-09 15:06
 **/

@EnableZshyFeign
@SpringBootApplication
public class ZshyUaaServer {
    public static void main(String[] args) {
        SpringApplication.run(ZshyUaaServer.class, args);
    }
}
