package com.zshy.system.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.ProviderConstant;
import com.zshy.core.common.dto.CommonLog;
import com.zshy.core.log.feign.ISysLogProvider;
import com.zshy.system.entity.SysLog;
import com.zshy.system.service.ISysLogService;

/**
 * 日志远程调用
 * @author yanghaifeng
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "日志远程调用")
public class SysLogProvider implements ISysLogProvider {

    private final ISysLogService sysLogService;

    @Override
    @PostMapping(ProviderConstant.PROVIDER_LOG_SET)
    @ApiOperation(value = "日志设置", notes = "日志设置")
    public Result<Boolean> set(CommonLog commonLog) {
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(commonLog, sysLog);
        return Result.data(sysLogService.save(sysLog));
    }
}
