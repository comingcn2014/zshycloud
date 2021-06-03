package com.zshy.core.gray.fegin;

import com.zshy.core.gray.context.VersionContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import com.zshy.core.common.constant.ZshyConstant;

/**
 * feign 请求VERSION 传递
 *
 * @author madi
 * @date 2021-02-24 13:41
 */
@Slf4j
public class GrayFeignRequestInterceptor implements RequestInterceptor {
	@Override
	public void apply(RequestTemplate template) {
		if (VersionContextHolder.getVersion() == null) {
			log.error("TTL 中的 VERSION为空，feign拦截器 >> 增强失败");
			return;
		}
		template.header(ZshyConstant.VERSION, VersionContextHolder.getVersion());
	}
}
