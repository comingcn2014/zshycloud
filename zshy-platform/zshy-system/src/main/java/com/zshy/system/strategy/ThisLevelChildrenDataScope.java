package com.zshy.system.strategy;

import com.zshy.system.dto.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.zshy.core.auth.util.ZshyAuthUser;
import com.zshy.core.common.exception.BaseException;
import com.zshy.core.database.enums.DataScopeTypeEnum;
import com.zshy.system.service.ISysDepartService;

import java.util.List;

/**
 * 本级及以下级别的数据权限
 *
 * @author yanghaifeng
 */
@Component("3")
@AllArgsConstructor
public class ThisLevelChildrenDataScope implements AbstractDataScopeHandler {

	private final ISysDepartService sysDepartService;

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		String deptId = ZshyAuthUser.getUser().getDeptId();
		if (deptId == null) {
			throw new BaseException("部门信息为空！");
		}
		return sysDepartService.selectDeptIds(Long.valueOf(deptId));
	}
}
