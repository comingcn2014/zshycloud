package com.zshy.job.config;

import com.xxl.job.core.executor.XxlJobExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置
 *
 * @author yanghaifeng
 */
@Slf4j
@Configuration
@RefreshScope
public class XxlJobConfiguration {

	@Value("${zshy.job.admin.addresses}")
	private String adminAddresses;

	@Value("${zshy.job.executor.appname}")
	private String appname;

	@Value("${zshy.job.executor.ip}")
	private String ip;

	@Value("${zshy.job.executor.port}")
	private int port;

	@Value("${zshy.job.accessToken}")
	private String accessToken;

	@Value("${zshy.job.executor.logpath}")
	private String logPath;

	@Value("${zshy.job.executor.logretentiondays}")
	private int logRetentionDays;


	@Bean(initMethod = "start", destroyMethod = "destroy")
	public XxlJobExecutor xxlJobExecutor() {
		log.info(">>>>>>>>>>> xxl-job config init.");
		XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
		xxlJobExecutor.setAdminAddresses(adminAddresses);
		xxlJobExecutor.setAppname(appname);
		xxlJobExecutor.setIp(ip);
		xxlJobExecutor.setPort(port);
		xxlJobExecutor.setAccessToken(accessToken);
		xxlJobExecutor.setLogPath(logPath);
		xxlJobExecutor.setLogRetentionDays(logRetentionDays);

		return xxlJobExecutor;
	}

}
