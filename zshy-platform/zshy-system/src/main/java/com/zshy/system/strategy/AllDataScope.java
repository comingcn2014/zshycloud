package com.zshy.system.strategy;

import com.zshy.system.dto.RoleDTO;
import com.zshy.system.entity.SysDepart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.zshy.core.database.enums.DataScopeTypeEnum;
import com.zshy.system.service.ISysDepartService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 所有数据范围
 *
 * @author yanghaifeng
 */
@Component("1")
@AllArgsConstructor
public class AllDataScope implements AbstractDataScopeHandler {

	private final ISysDepartService sysDepartService;

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		List<SysDepart> sysDeparts = sysDepartService.list();
		return sysDeparts.stream().map(SysDepart::getId).collect(Collectors.toList());
	}


}
