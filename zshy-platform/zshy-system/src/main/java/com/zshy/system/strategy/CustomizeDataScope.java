package com.zshy.system.strategy;

import com.zshy.system.dto.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.zshy.core.database.enums.DataScopeTypeEnum;
import com.zshy.system.service.ISysDepartService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义数据范围
 *
 * @author yanghaifeng
 */
@Component("4")
@AllArgsConstructor
public class CustomizeDataScope implements AbstractDataScopeHandler {
	private final ISysDepartService sysDepartService;

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		List<Long> roleDeptIds = roleDto.getRoleDepts();
		List<Long> ids = new ArrayList<>();
		for (Long deptId : roleDeptIds) {
			ids.addAll(sysDepartService.selectDeptIds(deptId));
		}
		Set<Long> set = new HashSet<>(ids);
		ids.clear();
		ids.addAll(set);
		return ids;
	}
}
