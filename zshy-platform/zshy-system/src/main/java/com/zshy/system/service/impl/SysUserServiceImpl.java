package com.zshy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshy.system.entity.SysUser;
import com.zshy.system.mapper.SysUserMapper;
import com.zshy.system.poi.SysUserPOI;
import com.zshy.system.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.zshy.core.common.exception.BaseException;
import com.zshy.core.common.util.StringUtil;
import com.zshy.core.database.entity.Search;
import com.zshy.core.database.enums.OrderTypeEnum;
import com.zshy.core.database.util.PageUtil;
import com.zshy.core.web.util.CollectionUtil;
import com.zshy.system.service.ISysDepartService;
import com.zshy.system.service.ISysDictService;
import com.zshy.system.service.ISysRoleService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-18
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

	private final ISysDepartService sysDepartService;
	private final ISysDictService dictService;
	private final ISysRoleService sysRoleService;

	@Override
	public boolean status(String ids, String status) {
		Collection<? extends Serializable> collection = CollectionUtil.stringToCollection(ids);

		if (ObjectUtils.isEmpty(collection)) {
			throw new BaseException("传入的ID值不能为空！");
		}

		collection.forEach(id -> {
			SysUser sysUser = this.baseMapper.selectById(CollectionUtil.objectToLong(id, 0L));
			sysUser.setStatus(status);
			this.baseMapper.updateById(sysUser);
		});
		return true;
	}

	@Override
	public IPage<SysUser> listPage(Search search) {

		LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.between(StringUtil.isNotBlank(search.getStartDate()), SysUser::getCreateTime, search.getStartDate(), search.getEndDate());
		boolean isKeyword = StringUtil.isNotBlank(search.getKeyword());
		queryWrapper.like(isKeyword, SysUser::getName, search.getKeyword()).or(isKeyword)
				.like(isKeyword, SysUser::getId, search.getKeyword());

		// 根据排序字段进行排序
		if (StringUtil.isNotBlank(search.getProp())) {
			if (OrderTypeEnum.ASC.getValue().equalsIgnoreCase(search.getOrder())) {
				queryWrapper.orderByAsc(SysUser::getId);
			} else {
				queryWrapper.orderByDesc(SysUser::getId);
			}
		}
		// 分页查询
		IPage<SysUser> sysUserPage = this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);

		// 拼装转换为中文字段数据
		List<SysUser> sysUserList = sysUserPage.getRecords().stream().peek(sysUser -> {
			sysUser.setDepartName(sysDepartService.getById(sysUser.getDepartId()).getName());
			sysUser.setStatusName(dictService.getValue("status", sysUser.getStatus()).getData());
			sysUser.setRoleName(sysRoleService.getById(sysUser.getRoleId()).getRoleName());
		}).collect(Collectors.toList());
		sysUserPage.setRecords(sysUserList);
		return sysUserPage;
	}

	@Override
	public SysUser getOneIgnoreTenant(SysUser sysUser) {
		return this.baseMapper.selectOneIgnoreTenant(sysUser);
	}

	@Override
	public List<SysUserPOI> export() {
		LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(SysUser::getIsDeleted, "0");
		List<SysUser> sysUsers = this.baseMapper.selectList(queryWrapper);
		return sysUsers.stream().map(sysUser -> {
			SysUserPOI sysUserPOI = new SysUserPOI();
			BeanUtils.copyProperties(sysUser, sysUserPOI);
			sysUserPOI.setDepartName(sysDepartService.getById(sysUser.getDepartId()).getName());
			sysUserPOI.setRoleName(sysRoleService.getById(sysUser.getRoleId()).getRoleName());
			sysUserPOI.setStatusName(dictService.getValue("status", sysUser.getStatus()).getData());
			return sysUserPOI;
		}).collect(Collectors.toList());
	}
}
