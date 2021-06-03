

package com.zshy.core.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.zshy.core.mybatis.injector.methods.*;
import com.zshy.core.mybatis.injector.methods.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义的 sql 注入
 *
 * @author L.cm
 */
public class ZshySqlInjector extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
		List<AbstractMethod> methodList = new ArrayList<>();
		methodList.add(new InsertBatch());
		methodList.add(new InsertIgnore());
		methodList.add(new InsertIgnoreBatch());
		methodList.add(new Replace());
		methodList.add(new ReplaceBatch());
		methodList.addAll(super.getMethodList(mapperClass));
		return Collections.unmodifiableList(methodList);
	}
}
