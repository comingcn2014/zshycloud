package com.zshy.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成增强版本启动类
 *
 * @author yanghaifeng
 * @since 2.3.8
 */
@SpringBootApplication
@MapperScan({"com.zshy.generator.mapper"})
public class ZshyGeneratorServer {
	public static void main(String[] args) {
		SpringApplication.run(ZshyGeneratorServer.class, args);
	}
}
