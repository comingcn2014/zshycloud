package com.zshy.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zshy.core.common.api.Result;
import com.zshy.message.service.ISmsService;
import com.zshy.message.service.ITransactionOrderService;

/**
 * 发送短信控制器
 *
 * @author yanghaifeng
 */
@RestController
@AllArgsConstructor
@Api(tags = "发送短信控制器")
public class SmsController {

	private final ISmsService smsService;

	private final ITransactionOrderService transactionOrderService;

	@GetMapping("/send/sms")
	@ApiOperation(value = "删除文件", notes = "删除文件")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "message", required = true, value = "msg", paramType = "form")
	})
	public Result<?> sendSms(String message) {
		smsService.sendSms(message);
		return Result.success("操作成功");
	}

	@GetMapping("/send/order")
	public Result<?> sendOrder() {
		transactionOrderService.testStreamTransaction();
		return Result.success("操作成功");
	}
}
