package com.zshy.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zshy.code.entity.SysDataSource;
import com.zshy.code.vo.SysDataSourceVO;

import java.util.List;

/**
 * <p>
 * 数据源表 Mapper 接口
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-07-07
 */
public interface SysDataSourceMapper extends BaseMapper<SysDataSource> {

    List<SysDataSourceVO> optionList();

}
