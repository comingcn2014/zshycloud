package com.zshy.system.feign;

import com.zshy.system.entity.SysDict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.ProviderConstant;
import com.zshy.core.feign.constant.FeignConstant;

import java.util.List;

/**
 * 字典远程调用接口类
 * @author yanghaifeng
 */
@FeignClient(value = FeignConstant.ZSHY_CLOUD_SYSTEM)
public interface ISysDictProvider {

    /**
     * 根据code和dictKey获取值
     * @param code code
     * @param dictKey key
     * @return Result
     */
    @GetMapping(ProviderConstant.PROVIDER_DICT_VALUE)
    Result<String> getValue(@RequestParam("code") String code, @RequestParam("dictKey") String dictKey);

    /**
     * 根据code获取字典列表
     * @param code　code
     * @return Result
     */
    @GetMapping(ProviderConstant.PROVIDER_DICT_LIST)
    Result<List<SysDict>> getList(@RequestParam("code") String code);

}
