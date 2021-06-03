package com.zshy.core.encrypt.annotation;

import org.springframework.context.annotation.Import;
import com.zshy.core.encrypt.config.EncryptConfiguration;
import com.zshy.core.encrypt.config.WebConfiguration;

import java.lang.annotation.*;

/**
 * Enable encrypt of the Spring Application Context
 * 支持res和rsa的加密方式
 *
 * @author gaoyang yanghaifeng
 * @since 1.6.8
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EncryptConfiguration.class, WebConfiguration.class})
public @interface EnableEncrypt {
}
