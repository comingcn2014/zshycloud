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

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshy.system.entity.SysRoute;
import com.zshy.system.mapper.SysRouteMapper;
import com.zshy.system.vo.SysRouteVO;
import org.springframework.stereotype.Service;
import com.zshy.core.common.util.StringUtil;
import com.zshy.core.database.entity.Search;
import com.zshy.core.database.util.PageUtil;
import com.zshy.system.service.ISysRouteService;

import java.util.List;

/**
 * <p>
 * 系统路由表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-10-17
 */
@Service
public class SysRouteServiceImpl extends ServiceImpl<SysRouteMapper, SysRoute> implements ISysRouteService {

	@Override
	public IPage<SysRoute> listPage(Search search) {
		LambdaQueryWrapper<SysRoute> queryWrapper = Wrappers.<SysRoute>query().lambda()
				.between(StringUtil.isNotBlank(search.getStartDate()), SysRoute::getCreateTime, search.getStartDate(), search.getEndDate());
		boolean isKeyword = StringUtil.isNotBlank(search.getKeyword());
		queryWrapper.like(isKeyword, SysRoute::getServiceId, search.getKeyword())
				.or(isKeyword)
				.like(isKeyword, SysRoute::getName, search.getKeyword());
		queryWrapper.orderByDesc(SysRoute::getCreateTime);
		return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
	}

	@Override
	public List<SysRouteVO> listItem() {
		return this.baseMapper.listItem();
	}
}
