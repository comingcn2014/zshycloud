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
package com.zshy.system.service;

import com.zshy.system.entity.SysRoleDepart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zshy.core.database.entity.Search;

/**
 * <p>
 * 角色和部门关联表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2021-04-05
 */
public interface ISysRoleDepartService extends IService<SysRoleDepart> {

	/**
     * 分页业务方法
     * @param search　搜索参数
     * @return IPage
     */
	IPage<SysRoleDepart> listPage(Search search);

}
