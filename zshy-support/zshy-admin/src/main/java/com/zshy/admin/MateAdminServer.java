package com.zshy.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Admin启动类
 *
 * @author yanghaifeng
 */
@EnableAdminServer
@SpringBootApplication
public class ZshyAdminServer {
	public static void main(String[] args) {
		SpringApplication.run(ZshyAdminServer.class, args);
	}
}
