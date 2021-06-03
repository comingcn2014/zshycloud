package com.zshy.system.feign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.ProviderConstant;
import com.zshy.core.log.annotation.Log;
import com.zshy.system.entity.SysDict;
import com.zshy.system.service.ISysDictService;

import java.util.List;

/**
 * 字典远程调用
 * @author yanghaifeng
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "字典远程调用")
public class SysDictProvider implements ISysDictProvider {

    private final ISysDictService sysDictService;

    @Override
    @ApiOperation(value = "字典值", notes = "根据code和dictKey获取值")
    @Log(value = "字典值", exception = "字典值请求失败")
    @GetMapping(ProviderConstant.PROVIDER_DICT_VALUE)
    public Result<String> getValue(String code, String dictKey) {
        return sysDictService.getValue(code, dictKey);
    }

    @Override
    @ApiOperation(value = "字典列表", notes = "根据code获取字典列表")
    @Log(value = "字典列表", exception = "字典列表请求失败")
    @GetMapping(ProviderConstant.PROVIDER_DICT_LIST)
    public Result<List<SysDict>> getList(String code) {
        return sysDictService.getList(code);
    }
}
