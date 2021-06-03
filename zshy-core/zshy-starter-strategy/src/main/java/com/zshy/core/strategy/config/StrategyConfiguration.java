package com.zshy.core.strategy.config;

import com.zshy.core.strategy.service.BusinessHandler;
import com.zshy.core.strategy.service.BusinessHandlerChooser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 策略模式自动注入配置
 *
 * @author yanghaifeng
 * @date 2020-9-5
 */
@Configuration
public class StrategyConfiguration {

	@Bean
	public BusinessHandlerChooser businessHandlerChooser(List<BusinessHandler> businessHandlers) {
		BusinessHandlerChooser businessHandlerChooser = new BusinessHandlerChooser();
		businessHandlerChooser.setBusinessHandlerMap(businessHandlers);
		return businessHandlerChooser;
	}

}
