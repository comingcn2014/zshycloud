package com.zshy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshy.system.entity.SysMenu;
import com.zshy.system.entity.SysRolePermission;
import com.zshy.system.mapper.SysRolePermissionMapper;
import com.zshy.system.service.ISysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zshy.system.service.ISysMenuService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-07-02
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public List<String> getMenuIdByRoleId(String roleId) {
        LambdaQueryWrapper<SysRolePermission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRolePermission::getRoleId, roleId);

        //1.根据角色ID，查询菜单列表
        List<SysRolePermission> sysRolePermissions = this.baseMapper.selectList(lambdaQueryWrapper);
        //2.将menuId转换为List
        List<Long> menuIds = sysRolePermissions.stream().map(SysRolePermission::getMenuId).collect(Collectors.toList());
        //3.根据menuId查询所有的满足条件的菜单列表,其中type=2为按钮
        List<SysMenu> sysMenuList = sysMenuService.list(new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getType, 2).in(SysMenu::getId, menuIds));
        return sysMenuList.stream().map(SysMenu::getPermission).collect(Collectors.toList());
    }
}
