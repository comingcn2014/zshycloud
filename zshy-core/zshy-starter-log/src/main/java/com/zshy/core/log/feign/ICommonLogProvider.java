package com.zshy.core.log.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.dto.CommonLog;
import com.zshy.core.feign.constant.FeignConstant;

/**
 * 普通日志生产消息调用
 * @author yanghaifeng
 */

@FeignClient(value = FeignConstant.ZSHY_CLOUD_LOG_PRODUCER)
public interface ICommonLogProvider {

    /**
     * 向消息中心发送消息
     * @param commonLog 普通日志
     * @return 状态
     */
    @PostMapping("/provider/common-log/send")
    Result<?> sendCommonLog(CommonLog commonLog);
}
