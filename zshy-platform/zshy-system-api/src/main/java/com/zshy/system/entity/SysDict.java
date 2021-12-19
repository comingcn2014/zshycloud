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
package com.zshy.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.zshy.core.database.entity.BaseEntity;

/**
 * 字典表实体类
 *
 * @author yanghaifeng
 * @since 2020-07-11
 */
@Data
@TableName("tb_sys_dict")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysDict对象", description = "字典表")
public class SysDict extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 父主键
	*/
	@ApiModelProperty(value = "父主键")
	private Long parentId;
	/**
	* 字典码
	*/
	@ApiModelProperty(value = "字典码")
	private String code;
	/**
	* 字典值
	*/
	@ApiModelProperty(value = "字典值")
	private String dictKey;
	/**
	* 字典名称
	*/
	@ApiModelProperty(value = "字典名称")
	private String dictValue;
	/**
	* 排序
	*/
	@ApiModelProperty(value = "排序")
	private Integer sort;
	/**
	* 字典备注
	*/
	@ApiModelProperty(value = "字典备注")
	private String remark;


}
