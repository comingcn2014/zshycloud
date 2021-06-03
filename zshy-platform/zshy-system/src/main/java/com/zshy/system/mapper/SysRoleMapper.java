package com.zshy.system.mapper;

import com.zshy.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zshy.system.vo.SysRoleVO;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-28
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVO> tree();

}
