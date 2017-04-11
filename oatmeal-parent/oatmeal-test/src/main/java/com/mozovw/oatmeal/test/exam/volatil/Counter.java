package com.mozovw.oatmeal.test.exam.volatil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 比如一个操作i++；实际上这是三个原子操作，先把i的值读取、然后修改(+1)、最后写入给i。所以使用Atomic原子类操作数
 * 
 * 在每个线程中通过increment()来对count进行计数增加的操作，或者其它一些操作。
 * 这样每个线程访问到的将是安全、完整的count。
 * @author Administrator
 *
 */
public class Counter {
	
	private volatile int count;
	
	public int getCount() {
		return count;
	}
	public synchronized void increment() {
		count++;
	}
	
	

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		new MyThread(counter).start();
		new MyThread(counter).start();
	}

}

class MyThread extends Thread {
	private Counter counter;

	public MyThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// TODO Auto-generated method stub
			counter.increment();
			@SuppressWarnings("static-access")
			String name = this.currentThread().getName();
			System.out.println(name + "   " + counter.getCount()+" ");
		}
	}

}