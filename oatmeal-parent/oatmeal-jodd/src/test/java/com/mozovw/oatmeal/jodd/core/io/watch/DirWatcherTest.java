package com.mozovw.oatmeal.jodd.core.io.watch;

import java.io.File;

import jodd.io.watch.DirWatcher;
import jodd.io.watch.DirWatcherListener;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class DirWatcherTest extends BaseTestCase {
	@Test
	public void test() throws InterruptedException {
		String root = "src";
		DirWatcher dirWatcher = new DirWatcher(root, "*.java");
		dirWatcher.register(new DirWatcherListener() {
			public void onChange(File file, DirWatcher.Event event) {
				System.out.println(file.getName() + ":" + event.name());
			}
		});
		while (true) {
			dirWatcher.start(1000);
			Thread.sleep(2000);  
		}
	}
}