package com.mozovw.oatmeal.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class ClassUtilsTest extends BaseTestCase {
	@Test
	public void test() throws Exception {
		// 获取Test类所有实现的接口
		ClassUtils.getAllInterfaces(Test.class);

		// 获取Test类所有父类
		ClassUtils.getAllSuperclasses(Test.class);

		// 获取Test类所在的包名
		String packageName = ClassUtils.getPackageName(Test.class);
		System.out.println(packageName);
		// 获取Test类简单类名
		String shortClassName = ClassUtils.getShortClassName(Test.class);
		System.out.println(shortClassName);
		shortClassName = ClassUtils.getShortCanonicalName("org.junit.Test");
		System.out.println(shortClassName);
		// 判断是否可以转型
		ClassUtils.isAssignable(Test.class, Object.class);

		// 判断是否有内部类
		ClassUtils.isInnerClass(Test.class);

		// Method publicMethod = ClassUtils.getPublicMethod(getClass(), "test",
		// null);
	

	}

	

	public String getHome(String str) {
		return "";
	}
}
