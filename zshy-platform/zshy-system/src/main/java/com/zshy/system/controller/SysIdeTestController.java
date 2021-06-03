package com.zshy.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zshy.core.common.api.Result;
import com.zshy.core.ide.annotation.Ide;
import com.zshy.core.ide.enums.IdeTypeEnum;

/**
 * @author yanghaifeng
 */
@RestController
public class SysIdeTestController {

	@GetMapping("/ide/test")
	@Ide(perFix = "TEST_", key = "key", ideTypeEnum = IdeTypeEnum.KEY)
	public Result<?> test(@RequestParam String key) {
		return Result.data(key);
	}
}
