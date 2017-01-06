package com.mozovw.oatmeal.jodd.core.io;

import java.io.File;
import java.io.IOException;

import jodd.io.FileUtil;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class FileUtilTest extends BaseTestCase {
	String str = "src/test/resources/com/mozovw/oatmeal/jodd/core/io/findfile/props.txt";

	@Test
	public void test() throws IOException {
		FileUtil.isExistingFile(new File(""));
		FileUtil.isExistingFolder(new File(""));
		String[] strings = FileUtil.readLines(str);
		showArr(strings);

	}
}
