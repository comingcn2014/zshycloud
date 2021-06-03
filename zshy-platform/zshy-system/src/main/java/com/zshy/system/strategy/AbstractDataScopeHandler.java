package com.zshy.system.strategy;

import com.zshy.core.database.enums.DataScopeTypeEnum;
import com.zshy.system.dto.RoleDTO;

import java.util.List;

/**
 * 创建抽象策略角色 主要作用 数据权限范围使用
 *
 * @author yanghaifeng
 */
public interface AbstractDataScopeHandler {

	/**
	 * 获取部门ID列表
	 *
	 * @param roleDto           角色对象
	 * @param dataScopeTypeEnum 数据权限枚举
	 * @return int数组
	 */
	List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum);
}
