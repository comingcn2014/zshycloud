/*
 * Copyright 2020-2030, ZshyCloud, DAOTIANDI Technology Inc All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Author: yanghaifeng(694939483@qq.com)
 */
package com.zshy.system.service.impl;

import com.zshy.core.database.entity.Search;
import com.zshy.system.entity.SysRoleDepart;
import com.zshy.system.mapper.SysRoleDepartMapper;
import com.zshy.system.service.ISysRoleDepartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zshy.core.common.util.StringUtil;
import com.zshy.core.database.util.PageUtil;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2021-04-05
 */
@Service
public class SysRoleDepartServiceImpl extends ServiceImpl<SysRoleDepartMapper, SysRoleDepart> implements ISysRoleDepartService {

		@Override
		public IPage<SysRoleDepart> listPage(Search search) {
			LambdaQueryWrapper<SysRoleDepart> queryWrapper = new LambdaQueryWrapper<>();
			if (StringUtil.isNotBlank(search.getStartDate())) {
				queryWrapper.between(SysRoleDepart::getCreateTime, search.getStartDate(), search.getEndDate());
			}
			if (StringUtil.isNotBlank(search.getKeyword())) {
				queryWrapper.like(SysRoleDepart::getId, search.getKeyword());
			}
			queryWrapper.orderByDesc(SysRoleDepart::getCreateTime);
			return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
		}
}
