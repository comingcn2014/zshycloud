package com.zshy.gateway.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.zshy.core.common.enums.EnvType;

/**
 * 网关默认首页
 *
 * @author yanghaifeng
 */
@RestController
public class IndexHandler {

	@Value("${spring.profiles.active}")
	private String env;

	@GetMapping("/")
	public Mono<String> index() {
		return Mono.just(desc());
	}

	private String desc() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("<div style='color: blue'>ZshyCloud gateway has been started!</div>");
		if (!EnvType.PROD.getValue().equals(env)) {
			sb.append("<br/>");
			sb.append("<div><ul><li>文档地址：<a href='doc.html'>doc.html</a></li></ul></div>");
		}
		return sb.toString();
	}
}
