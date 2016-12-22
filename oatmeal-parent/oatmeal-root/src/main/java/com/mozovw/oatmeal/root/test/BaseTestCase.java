package com.mozovw.oatmeal.root.test;

import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

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
		for (int i = 0; i < list.size(); i++) {
			System.out.println(ReflectionToStringBuilder.toString(list.get(i)));
		}
	}

}
