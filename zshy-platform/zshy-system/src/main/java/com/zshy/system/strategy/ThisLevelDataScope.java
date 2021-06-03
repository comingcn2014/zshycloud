package com.zshy.system.strategy;

import com.zshy.system.dto.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.zshy.core.auth.util.ZshyAuthUser;
import com.zshy.core.common.exception.BaseException;
import com.zshy.core.database.enums.DataScopeTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 本级数据权限
 *
 * @author yanghaifeng
 */
@Component("2")
@AllArgsConstructor
public class ThisLevelDataScope implements AbstractDataScopeHandler {

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		// 用于存储部门id
		List<Long> deptIds = new ArrayList<>();
		String deptId = ZshyAuthUser.getUser().getDeptId();
		if (deptId == null) {
			throw new BaseException("部门信息为空！");
		}
		deptIds.add(Long.valueOf(ZshyAuthUser.getUser().getDeptId()));
		return deptIds;
	}
}
