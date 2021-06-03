package com.zshy.system.feign;

import com.zshy.system.dto.UserInfo;
import com.zshy.system.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.ProviderConstant;
import com.zshy.core.feign.constant.FeignConstant;

/**
 * 用户调用类
 *
 * @author yanghaifeng
 */
@FeignClient(value = FeignConstant.ZSHY_CLOUD_SYSTEM)
public interface ISysUserProvider {

    /**
     * 根据id查询用户信息
     *
     * @param id id
     * @return Result
     */
    @GetMapping(ProviderConstant.PROVIDER_USER_ID)
    Result<SysUser> getUserById(@RequestParam("id") Long id);

    /**
     * 根据userName查询用户信息
     * @param userName　用户名
     * @return Result
     */
    @GetMapping(ProviderConstant.PROVIDER_USER_USERNAME)
    Result<UserInfo> getUserByUserName(@RequestParam("userName") String userName);

    /**
     * 根据手机号查询用户信息
     * @param mobile　手机号码
     * @return Result
     */
    @GetMapping(ProviderConstant.PROVIDER_USER_MOBILE)
    Result<UserInfo> getUserByMobile(@RequestParam("mobile") String mobile);

}
