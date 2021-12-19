package com.zshy.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-07-02
 */
@Data
@Accessors(chain = true)
@TableName("tb_sys_role_permission")
@ApiModel(value = "SysRolePermission对象", description = "角色权限表")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Long menuId;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;


}
