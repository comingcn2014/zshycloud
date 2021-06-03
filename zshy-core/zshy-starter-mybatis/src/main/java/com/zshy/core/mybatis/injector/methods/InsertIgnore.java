
package com.zshy.core.mybatis.injector.methods;


import com.zshy.core.mybatis.injector.ZshySqlMethod;

/**
 * 插入一条数据（选择字段插入）插入如果中已经存在相同的记录，则忽略当前新数据
 *
 * @author L.cm
 */
public class InsertIgnore extends AbstractInsertMethod {

	public InsertIgnore() {
		super(ZshySqlMethod.INSERT_IGNORE_ONE);
	}
}
