package com.zshy.core.log.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.ProviderConstant;
import com.zshy.core.common.dto.CommonLog;
import com.zshy.core.feign.constant.FeignConstant;

/**
 * feign调用mate-system存储日志
 * @author yanghaifeng
 * @date 2020-7-1
 */
@FeignClient(value = FeignConstant.ZSHY_CLOUD_SYSTEM)
public interface ISysLogProvider {

    /**
     * 日志设置
     * @param commonLog　CommonLog对象
     * @return Result
     */
    @PostMapping(ProviderConstant.PROVIDER_LOG_SET)
    Result<Boolean> set(@RequestBody CommonLog commonLog);

}
