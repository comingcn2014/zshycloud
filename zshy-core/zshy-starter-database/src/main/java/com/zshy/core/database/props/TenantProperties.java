package com.zshy.core.database.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 租户属性
 * @author yanghaifeng
 * @Date 2020-9-6
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "zshy.tenant")
public class TenantProperties {

    /**
     * 是否开启租户模式
     */
    private Boolean enable = false;

    /**
     * 需要排除的多租户的表
     */
    private List<String> ignoreTables = Arrays.asList("tb_sys_menu","tb_sys_dict","tb_sys_client",
            "tb_sys_tenant", "tb_sys_role_permission","tb_sys_config","tb_sys_data_source","tb_sys_attachment");

    /**
     * 多租户字段名称
     */
    private String column = "tenant_id";

    /**
     * 排除不进行租户隔离的sql
     * 样例全路径：com.zshy.system.mapper.UserMapper.findList
     */
    private List<String> ignoreSqls = new ArrayList<>();
}
