package com.zshy.core.feign.constant;

import lombok.experimental.UtilityClass;

/**
 * Feign常量类
 * @author yanghaifeng
 * @Date 2020-7-1
 */
@UtilityClass
public class FeignConstant {

    /**
     * 网关
     */
    public final String ZSHY_CLOUD_GATEWAY = "zshy-gateway";

    /**
     * 系统服务
     */
    public final String ZSHY_CLOUD_SYSTEM = "zshy-system";

    /**
     * 认证服务
     */
    public final String ZSHY_CLOUD_UAA = "zshy-uaa";

    /**
     * 消息生产者
     */
    public final String ZSHY_CLOUD_LOG_PRODUCER = "zshy-log-producer";
}
