package com.zshy.system.service;

import com.zshy.system.entity.SysRole;
import com.zshy.system.poi.SysRolePOI;
import com.zshy.system.vo.SysRoleVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-28
 */
public interface ISysRoleService extends IService<SysRole> {

    List<SysRoleVO> tree();

    List<SysRole> listSearch(Map<String, String> search);

    List<String> getPermission(String id);

    List<SysRolePOI> export();

}
