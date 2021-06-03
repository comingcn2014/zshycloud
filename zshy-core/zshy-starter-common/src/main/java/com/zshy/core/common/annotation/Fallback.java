package com.zshy.core.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Feign Fallback注解
 * @author yanghaifeng
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Fallback {

    @AliasFor(annotation = Component.class)
    String value() default "";
}
