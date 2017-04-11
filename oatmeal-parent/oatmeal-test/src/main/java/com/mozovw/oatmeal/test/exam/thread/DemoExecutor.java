package com.mozovw.oatmeal.test.exam.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutor {
	//Executors.
	
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
	}
}	
