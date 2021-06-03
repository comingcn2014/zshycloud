package com.zshy.core.common.constant;

import lombok.experimental.UtilityClass;

/**
 * Zshy基本常量
 *
 * @author yanghaifeng
 */
@UtilityClass
public class ZshyConstant {

	/**
	 * 应用版本号
	 */
	public static final String ZSHY_APP_VERSION = "1.0.0-SNAPSHOT";

	/**
	 * Spring 应用名 prop key
	 */
	public static final String SPRING_APP_NAME_KEY = "spring.application.name";


	/**
	 * 默认为空消息
	 */
	public static final String DEFAULT_NULL_MESSAGE = "承载数据为空";
	/**
	 * 默认成功消息
	 */
	public static final String DEFAULT_SUCCESS_MESSAGE = "处理成功";
	/**
	 * 默认失败消息
	 */
	public static final String DEFAULT_FAIL_MESSAGE = "处理失败";
	/**
	 * 树的根节点值
	 */
	public static final Long TREE_ROOT = -1L;
	/**
	 * 允许的文件类型，可根据需求添加
	 */
	public static final String[] VALID_FILE_TYPE = {"xlsx", "zip"};

	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 微服务之间传递的唯一标识
	 */
	public static final String ZSHY_TRACE_ID = "zshy-trace-id";

	/**
	 * 日志链路追踪id日志标志
	 */
	public static final String LOG_TRACE_ID = "traceId";

	/**
	 * Java默认临时目录
	 */
	public static final String JAVA_TEMP_DIR = "java.io.tmpdir";

	/**
	 * 版本
	 */
	public static final String VERSION = "version";

	/**
	 * 默认版本号
	 */
	public static final String DEFAULT_VERSION = "v1";

	/**
	 * 服务资源
	 */
	public static final String ZSHY_SERVICE_RESOURCE = "zshy-service-resource";

	/**
	 * API资源
	 */
	public static final String ZSHY_API_RESOURCE = "zshy-api-resource";

	/**
	 * 权限认证的排序
	 */
	public static final int ZSHY_UAA_FILTER_ORDER = -200;

	/**
	 * 签名排序
	 */
	public static final int ZSHY_SIGN_FILTER_ORDER = -300;

	/**
	 * json类型报文，UTF-8字符集
	 */
	public static final String JSON_UTF8 = "application/json;charset=UTF-8";


	public static final String CONFIG_DATA_ID_DYNAMIC_ROUTES = "zshy-dynamic-routes.yaml";
	public static final String CONFIG_GROUP = "DEFAULT_GROUP";
	public static final long CONFIG_TIMEOUT_MS = 5000;


}
