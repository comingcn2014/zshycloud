package com.zshy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zshy.core.feign.annotation.EnableZshyFeign;

/**
 * 代码生成启动类
 *
 * @author yanghaifeng
 * @date 2019-10-09 15:06
 **/
@EnableZshyFeign
@SpringBootApplication
@MapperScan({"com.zshy.generator.mapper"})
public class ZshyCodeServer {
    public static void main(String[] args) {
        SpringApplication.run(ZshyCodeServer.class, args);
    }
}