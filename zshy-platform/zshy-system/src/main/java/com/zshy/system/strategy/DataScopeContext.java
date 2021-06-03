package com.zshy.system.strategy;

import com.zshy.system.dto.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.zshy.core.database.enums.DataScopeTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据权限上下文
 *
 * @author yanghaifeng
 */
@Service
@AllArgsConstructor
public class DataScopeContext {

	private final Map<String, AbstractDataScopeHandler> strategyMap = new ConcurrentHashMap<>();

	/**
	 * Component里边的1是指定其名字，这个会作为key放到strategyMap里
	 *
	 * @param strategyMap
	 */
	public DataScopeContext(Map<String, AbstractDataScopeHandler> strategyMap) {
		strategyMap.forEach(this.strategyMap::put);
	}

	public List<Long> getDeptIdsForDataScope(RoleDTO roleDto, Integer type) {
		return strategyMap.get(String.valueOf(type)).getDeptIds(roleDto, DataScopeTypeEnum.valueOf(type));
	}
}
