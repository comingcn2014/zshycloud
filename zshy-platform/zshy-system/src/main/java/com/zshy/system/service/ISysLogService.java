package com.zshy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshy.core.database.entity.Search;
import com.zshy.system.entity.SysLog;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-07-15
 */
public interface ISysLogService extends IService<SysLog> {

	/**
	 * 日志分页列表
	 *
	 * @param search 搜索和分页对象
	 * @return 日志分页列表
	 */
	IPage<SysLog> listPage(Search search);
}
