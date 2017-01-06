package com.mozovw.oatmeal.jodd.core.util;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

import jodd.util.StringUtil;

public class StringUtilTest extends BaseTestCase {
	@Test
	public void test(){
		System.out.println(StringUtil.isAllEmpty(" "));
		System.out.println(StringUtil.isAllBlank(" "));
		System.out.println(StringUtil.remove("sdfsaf", "s"));
		System.out.println(StringUtil.split("sfadfsfafd", "a")[0]);
		System.out.println(StringUtil.surround("aaa", "2323", "797"));
		System.out.println(StringUtil.join("safas","sadd"));
		System.out.println(StringUtil.join(new String[]{"23","sdf"},","));
		System.out.println(StringUtil.insert("sadf", "a",2));
		System.out.println(StringUtil.prefix("tt.exe", "33-"));
		System.out.println(StringUtil.suffix("ff", ".txt"));
		System.out.println(StringUtil.substring("aaasff", 0, 4));
		System.out.println(StringUtil.replace("afsafsa", "a", "2"));
	}
}
