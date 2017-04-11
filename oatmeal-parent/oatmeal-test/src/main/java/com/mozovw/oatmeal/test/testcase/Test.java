package com.mozovw.oatmeal.test.testcase;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		 String ss =  new String("\u5feb\u901f\u5f00\u53d1\u5e73\u53f0"
		 .getBytes(),"utf-8");
	        System.out.println(ss);
	        System.out.println("\u5b9a\u4e49\u6700\u5927\u8fde\u63a5\u6570");
	        int i = 1<<3;
	        System.out.println(i);
	         i = 32>>1;
	        System.out.println(i);
	        i = i<<=2;
	        System.out.println(i);
	        i = 64>>>1;
	        System.out.println(i);
	        if (i==32&(i+=1)==33) {
				System.out.println(i);
			}
	        if (i==32&&(i+=1)==33) {
	        	System.out.println(i);
	        }
	}
}
