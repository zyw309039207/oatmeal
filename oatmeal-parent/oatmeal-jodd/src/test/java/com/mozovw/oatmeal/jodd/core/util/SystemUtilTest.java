package com.mozovw.oatmeal.jodd.core.util;

import jodd.util.SystemUtil;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;


public class SystemUtilTest extends BaseTestCase {
	
	@Test
	public void test(){
		System.out.println(SystemUtil.JAVA_VERSION);
		System.out.println(SystemUtil.FILE_ENCODING);
		System.out.println(SystemUtil.fileEncoding());
		System.out.println(SystemUtil.workingFolder());
		System.out.println(SystemUtil.userName());
		System.out.println(SystemUtil.userHome());
		System.out.println(SystemUtil.userDir());
		System.out.println(SystemUtil.systemClassPath());
		System.out.println(SystemUtil.pathSeparator());
		System.out.println(SystemUtil.osName());
		System.out.println(SystemUtil.javaVersion());
	}
}
