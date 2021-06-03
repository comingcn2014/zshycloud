package com.zshy.system.dto;

import com.zshy.system.entity.SysDepart;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DepartDTO extends SysDepart {

	private List<DepartDTO> children;
}
