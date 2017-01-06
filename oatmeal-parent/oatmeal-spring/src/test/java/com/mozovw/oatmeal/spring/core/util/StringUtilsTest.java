package com.mozovw.oatmeal.spring.core.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class StringUtilsTest extends BaseTestCase {
	enum alph {
		aa("a"), dd("d"), cc("c");
		@SuppressWarnings("unused")
		private String name;

		private alph(String name) {
			this.name = name;
		}
	}

	@Test
	public void test() {
		System.out.println(alph.aa);
		System.out.println(StringUtils.containsWhitespace(" "));
		System.out.println(StringUtils.containsWhitespace(""));
		System.out.println(StringUtils.delete("adafasf", "a"));
		System.out.println(StringUtils.replace("afsafsaf", "a", "b"));
		showArr(StringUtils.mergeStringArrays(new String[] { "a" },
				new String[] { "b", "a" }));
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		showArr(StringUtils.toStringArray(list));
		showArr(StringUtils.addStringToArray(new String[] { "a" }, "c"));
		String path = "src/test/resources/com/mozovw/oatmeal/spring/core/tt.txt";
		System.out.println(StringUtils.getFilename(path));
		System.out.println(StringUtils.getFilenameExtension(path));
		System.out.println(StringUtils.stripFilenameExtension(path));
		// For example, "this:name:is:qualified" returns "qualified" if using a
		// ':' separator.
		System.out.println(StringUtils.unqualify(path, '/'));
		System.out.println(StringUtils
				.trimWhitespace("  adfafd afasfsa adfsafs afs "));
		System.out.println(StringUtils
				.trimAllWhitespace("adfasadf adfs adf af "));
		//Take a String which is a delimited list and convert it to a String array. 
		showArr(StringUtils.delimitedListToStringArray(path, "/"));
	}
}
