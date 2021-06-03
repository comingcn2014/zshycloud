package com.zshy.system.poi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import com.zshy.core.common.constant.ZshyConstant;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SysDepartPOI implements Serializable {

    private static final long serialVersionUID = -6959162298649698803L;

    @Excel(name = "部门编号" ,orderNum = "0", width = 30, isImportField = "true_st")
    private Long id;

    @Excel(name = "部门名称" ,orderNum = "1", width = 30, isImportField = "true_st")
    private String name;

    @Excel(name = "创建时间", format = ZshyConstant.DATETIME_FORMAT, orderNum = "4", width = 30, isImportField = "true_st")
    private LocalDateTime createTime;
}
