package com.zshy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshy.core.database.entity.Search;
import com.zshy.system.entity.SysUser;
import com.zshy.system.poi.SysUserPOI;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-18
 */
public interface ISysUserService extends IService<SysUser> {

	boolean status(String ids, String status);

	/**
	 * 分页业务方法
	 *
	 * @param search 　搜索参数
	 * @return IPage
	 */
	IPage<SysUser> listPage(Search search);


	/**
	 * 忽略租户查询用户信息
	 * @return
	 */
	SysUser getOneIgnoreTenant(SysUser sysUser);

	/**
	 * 导出列表
	 *
	 * @return 导出POI数据
	 */
	List<SysUserPOI> export();

}
