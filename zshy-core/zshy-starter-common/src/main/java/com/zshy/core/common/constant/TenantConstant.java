package com.zshy.core.common.constant;

/**
 * 多租户常量
 * @author yanghaifeng
 * @date 2020-9-7
 */
public interface TenantConstant {

    /**
     * header 中租户ID
     */
    String ZSHY_TENANT_ID = "zshy-tenant";

    /**
     * 租户id参数
     */
    String ZSHY_TENANT_ID_PARAM = "tenantId";

    /**
     * 租户ID
     */
    String TENANT_ID_DEFAULT = "1";

}
