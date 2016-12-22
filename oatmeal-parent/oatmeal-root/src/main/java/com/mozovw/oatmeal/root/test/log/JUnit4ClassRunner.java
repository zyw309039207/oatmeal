package com.mozovw.oatmeal.root.test.log;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;


public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
	static {
		try {
			Log4jConfigurer.initLogging("classpath:com/mozovw/oatmeal/root/log/test/log4j.properties");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.err.println("Cannot Initialize log4j");
		}
	}

	public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
}