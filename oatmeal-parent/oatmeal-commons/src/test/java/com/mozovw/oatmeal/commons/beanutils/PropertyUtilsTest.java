package com.mozovw.oatmeal.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class PropertyUtilsTest extends BaseTestCase {

	@Test
	public void test() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Entity entity = new Entity();

		// 通过PropertyUtils的getProperty方法获取指定属性的值
		Integer id = (Integer) PropertyUtils.getProperty(entity, "id");
		String name = (String) PropertyUtils.getProperty(entity, "name");
		System.out.println("id = " + id + "  name = " + name);

		// 调用PropertyUtils的setProperty方法设置entity的指定属性
		PropertyUtils.setProperty(entity, "name", "心梦帆影");
		System.out.println("name = " + entity.getName());

		// 通过PropertyUtils的describe方法把entity的所有属性与属性值封装进Map中
		Map<String, Object> map = PropertyUtils.describe(entity);
		System.out.println("id = " + map.get("id") + "  name = "
				+ map.get("name"));

		// 通过MethodUtils的invokeMethod方法,执行指定的entity中的方法(无参的情况)
		System.out.println(MethodUtils.invokeMethod(entity, "haha", null));

		// 通过MethodUtils的invokeMethod方法,执行指定的entity中的方法（1参的情况）
		MethodUtils.invokeMethod(entity, "sayHelle", "心梦帆影");

		// 通过MethodUtils的invokeMethod方法,执行指定的entity中的方法（多参的情况）
		Object[] params = new Object[] { new Integer(10), new Integer(12) };
		String msg = (String) MethodUtils.invokeMethod(entity, "countAges",
				params);
		System.out.println(msg);

	}
	

}




