package com.mozovw.oatmeal.jodd.bean;

import jodd.bean.BeanUtil;
import jodd.bean.BeanUtilBean;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class BeanUtilTest extends BaseTestCase {

	@Test
	public void test() {
		/*Method method = BeanUtils.findDeclaredMethod(User.class, "setName",
				String.class);
		String string = method.getName();
		logger.info(string);
		method = BeanUtils.findMethodWithMinimalParameters(User.class,
				"setName");
		string = method.getName();
		logger.info(string);
		Method[] methods = User.class.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}*/
		BeanUtil b = new BeanUtilBean();
		User u = new User();
		b.setProperty(u, "name", "tom");
		System.out.println(u.getName());
		System.out.println(b.getProperty(u, "name"));
		
	}
	

	class User {
		String name;
		String age;

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public String getAge() {

			return age;
		}

		public void setAge(String age) {

			this.age = age;
		}

	}
}
