package com.mozovw.oatmeal.root.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.springframework.util.StringUtils;

public class BaseTestCase {
	private long startTime;

	@Before
	public void before() {
		this.startTime = System.currentTimeMillis();
		System.out.println("---------begin---------");
	}

	@After
	public void after() {
		long endTime = System.currentTimeMillis();
		System.out.println("---------end---------");
		System.out.println("程序运行时间:" + (endTime - this.startTime) + "ms");

	}

	/**
	 * @Title: showList
	 * @Description: TODO
	 * @param list
	 * @return: void
	 */

	protected void showList(List<Object> list) {
		String string = null ;
		for (Object object : list) {
			try {
				string = String.valueOf(object);
			} catch (Exception e) {
				new Exception("type of list do not instanceof string");
			}
			System.out.println(string);
		}
	}

	protected void showArr(Object[] array) {
		showArr(array, ",");
	}

	protected void showArr(Object[] array, String separator) {
		final int noOfItems = array.length;
		if (noOfItems <= 0) {
			return;
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = 0; i < noOfItems; i++) {
			String string = (String) array[i];
			if (i > 0) {
				buf.append(separator);
			}
			if (!StringUtils.isEmpty(string)) {
				buf.append(string);
			}
		}
		System.out.println(buf.toString());
	}

}
