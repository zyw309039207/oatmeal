package com.mozovw.oatmeal.jodd.core.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

import jodd.util.PropertiesUtil;

public class PropertiesUtilTest extends BaseTestCase {
	
	@Test
	public void test() throws IOException{
		String str  = "src/test/resources/com/mozovw/oatmeal/jodd/core/io/findfile/props.txt";
		File file = new File(str);
		file.createNewFile();
		Properties p = new Properties();
		p.setProperty("usercode", "12312");
		p.setProperty("username", "12312");
		PropertiesUtil.writeToFile(p, str);
		Properties pp = PropertiesUtil.createFromFile(str);
		System.out.println(pp.get("usercode"));
		System.out.println(pp.get("username"));
	}
}
