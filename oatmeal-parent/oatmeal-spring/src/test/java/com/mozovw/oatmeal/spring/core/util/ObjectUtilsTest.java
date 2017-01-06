package com.mozovw.oatmeal.spring.core.util;

import org.junit.Test;
import org.springframework.util.ObjectUtils;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class ObjectUtilsTest extends BaseTestCase{
	
	@Test
	public void test(){
		System.out.println(ObjectUtils.getDisplayString(new Object[]{2,"3",true,3.3}));
		//System.out.println(ObjectUtils.addObjectToArray(array, obj));
	}
}
