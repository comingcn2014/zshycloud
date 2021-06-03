package com.zshy.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshy.system.entity.SysRole;
import com.zshy.system.entity.SysRolePermission;
import com.zshy.system.mapper.SysRoleMapper;
import com.zshy.system.poi.SysRolePOI;
import com.zshy.system.service.ISysRolePermissionService;
import com.zshy.system.vo.SysRoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zshy.system.service.ISysRoleService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	@Autowired
	private ISysRolePermissionService sysRolePermissionService;

	@Override
	public List<SysRoleVO> tree() {
		return this.baseMapper.tree();
	}

	@Override
	public List<SysRole> listSearch(Map<String, String> search) {
		String keyword = String.valueOf(search.get("keyword"));
		String startDate = String.valueOf(search.get("startDate"));
		String endDate = String.valueOf(search.get("endDate"));
		LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		if (StrUtil.isNotBlank(startDate) && !startDate.equals("null")) {
			lambdaQueryWrapper.between(SysRole::getCreateTime, startDate, endDate);
		}
		if (StrUtil.isNotBlank(keyword) && !keyword.equals("null")) {
			lambdaQueryWrapper.like(SysRole::getRoleName, keyword);
			lambdaQueryWrapper.or();
			lambdaQueryWrapper.like(SysRole::getId, keyword);
		}
		return this.baseMapper.selectList(lambdaQueryWrapper);
	}

	@Override
	public List<String> getPermission(String id) {
		LambdaQueryWrapper<SysRolePermission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(SysRolePermission::getRoleId, id);
		List<SysRolePermission> sysRolePermissions = sysRolePermissionService.list(lambdaQueryWrapper);
		List<String> list = sysRolePermissions.stream().map(sysRolePermission -> {
			String menuId = sysRolePermission.getMenuId().toString();
			return menuId;
		}).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<SysRolePOI> export() {
		LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(SysRole::getIsDeleted, 0);
		List<SysRole> sysRoles = this.baseMapper.selectList(queryWrapper);
		return sysRoles.stream().map(sysRole -> {
			SysRolePOI sysRolePOI = new SysRolePOI();
			BeanUtils.copyProperties(sysRole, sysRolePOI);
			return sysRolePOI;
		}).collect(Collectors.toList());
	}
}
