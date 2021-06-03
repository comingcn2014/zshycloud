package com.zshy.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import com.zshy.core.feign.annotation.EnableZshyFeign;

/**
 * 日志消息生产者启动类
 * @author yanghaifeng
 */
@EnableZshyFeign
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ZshyLogProducerServer {

    public static void main(String[] args) {
        SpringApplication.run(ZshyLogProducerServer.class, args);
    }

}
