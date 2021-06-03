package com.zshy.core.security.annotation;

import com.zshy.core.security.config.ZshyResourceServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 资源服务注解
 *
 * @author yanghaifeng
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ZshyResourceServerConfig.class)
public @interface EnableZshyResourceServer {
}
