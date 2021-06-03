package com.zshy.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * 消息中心消费者启动类
 *
 * @author yanghaifeng
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ZshyMessageConsumerServer {
	public static void main(String[] args) {
		SpringApplication.run(ZshyMessageConsumerServer.class, args);
	}
}
