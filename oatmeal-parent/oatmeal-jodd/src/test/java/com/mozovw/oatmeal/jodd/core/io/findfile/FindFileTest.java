package com.mozovw.oatmeal.jodd.core.io.findfile;

import java.io.File;

import jodd.io.findfile.FindFile;
import jodd.io.findfile.WildcardFindFile;
import jodd.util.SystemUtil;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class FindFileTest extends BaseTestCase {
	@Test
	public void test() {
		String path = SystemUtil.workingFolder();
		path = path.substring(0, path.lastIndexOf(File.separator));
		@SuppressWarnings("rawtypes")
		FindFile ff = new WildcardFindFile().setRecursive(true)
				.setIncludeDirs(true).searchPath(path);
		File f;
		while ((f = ff.nextFile()) != null) {
			if (f.isDirectory() == true) {
				System.out.println(". > " + f.getAbsolutePath());
			} else {
				System.out.println(". " + f.getName());
			}
		}
	}
	
	
	/*第一种： 

	File f = new File(this.getClass().getResource("/").getPath()); 

	System.out.println(f); 

	结果: 

	C:\Documents%20and%20Settings\Administrator\workspace\projectName\bin 

	获取当前类的所在工程路径; 

	如果不加“/” 

	File f = new File(this.getClass().getResource("").getPath()); 

	System.out.println(f); 

	结果： 

	C:\Documents%20and%20Settings\Administrator\workspace\projectName\bin\com\test 

	获取当前类的绝对路径； 


	第二种： 

	File directory = new File("");//参数为空 

	String courseFile = directory.getCanonicalPath() ; 

	System.out.println(courseFile); 

	结果： 

	C:\Documents and Settings\Administrator\workspace\projectName 

	获取当前类的所在工程路径; 


	第三种： 

	URL xmlpath = this.getClass().getClassLoader().getResource("selected.txt"); 

	System.out.println(xmlpath); 

	结果： 

	file:/C:/Documents%20and%20Settings/Administrator/workspace/projectName/bin/selected.txt 

	获取当前工程src目录下selected.txt文件的路径 


	第四种： 

	System.out.println(System.getProperty("user.dir")); 

	结果： 

	C:\Documents and Settings\Administrator\workspace\projectName 

	获取当前工程路径 


	第五种： 

	System.out.println( System.getProperty("java.class.path")); 

	结果： 

	C:\Documents and Settings\Administrator\workspace\projectName\bin 

	获取当前工程路径*/
	@Test
	public void testPath(){
		System.out.println(System.getProperty("user.dir")); 
	}

}
