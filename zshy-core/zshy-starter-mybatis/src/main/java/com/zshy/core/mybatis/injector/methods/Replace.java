

package com.zshy.core.mybatis.injector.methods;


import com.zshy.core.mybatis.injector.ZshySqlMethod;

/**
 * 插入一条数据（选择字段插入）
 * <p>
 * 表示插入替换数据，需求表中有PrimaryKey，或者unique索引，如果数据库已经存在数据，则用新数据替换，如果没有数据效果则和insert into一样；
 * </p>
 *
 * @author L.cm
 */
public class Replace extends AbstractInsertMethod {

	public Replace() {
		super(ZshySqlMethod.REPLACE_ONE);
	}
}

