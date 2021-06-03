package com.zshy.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 微服务视图对象
 *
 * @author yanghaifeng
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRouteVO implements Serializable {
	private Long id;
	private String name;
}
