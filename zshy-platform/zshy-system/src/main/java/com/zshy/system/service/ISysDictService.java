package com.zshy.system.service;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zshy.core.common.api.Result;
import com.zshy.core.common.constant.SystemConstant;
import com.zshy.core.database.entity.Search;
import com.zshy.system.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-07-01
 */
public interface ISysDictService extends IService<SysDict> {

    @Cached(name= SystemConstant.SYS_DICT_CACHE, expire = 3600)
    Result<String> getValue(String code, String dictKey);

    @Cached(name= SystemConstant.SYS_DICT_CACHE, key="#code", expire = 3600)
    Result<List<SysDict>> getList(String code);

    IPage<SysDict> listPage(Page page, Search search);

}
