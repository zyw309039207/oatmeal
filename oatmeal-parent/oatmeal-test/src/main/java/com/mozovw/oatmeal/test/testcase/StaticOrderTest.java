package com.mozovw.oatmeal.test.testcase;


public class StaticOrderTest {

	public static void main(String[] args) {
		StaticOrderTest.print();
		new StaticOrderTest().print2();
	}

	static {
		System.out.println(1);
	}
	{
		System.out.println(3);
	}

	static void print() {
		System.out.println(2);
	}

	private void print2() {
		System.out.println(4);
	}
}
