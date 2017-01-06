package com.mozovw.oatmeal.commons.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class FileUtilsTest extends BaseTestCase{
	String str  = "src/test/resources/com/mozovw/oatmeal/commons/io/tt.txt";
	@Test
	public void test() throws IOException{
		File file = FileUtils.getUserDirectory();
		System.out.println(file.getAbsolutePath());
		String readFileToString = FileUtils.readFileToString(new File(str));
		System.out.println(readFileToString);
		FileUtils.write(new File(str), readFileToString, false);
	}
}
