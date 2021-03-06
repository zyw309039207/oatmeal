package com.mozovw.oatmeal.test.exam.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 这个测试我并没有看出太大的效果
 * @author Administrator
 *
 */
public class TestLock {

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    //private Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<Integer, Integer>());
    
    //private Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

    public TestLock() {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(new Integer(i), i);
                }
                System.out.println("t1 over");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t2 over");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t3 over");
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t4 over");
            }
        };

        Thread t5 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(new Integer(i), i);
                }

                System.out.println("t5 over");
            }
        };

        Thread t6 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.get(new Integer(i));
                }

                System.out.println("t6 over");
            }
        };

         final Thread t7 = new Thread() {
			public void run() {
                for (int i = 0; i < 10; i++) {
                    map.get(new Integer(i));
                    System.out.println("7--"+map.get(new Integer(i)));
                }

                System.out.println("t7 over");
            }
        };

        Thread t8 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.get(new Integer(i));
                    System.out.println("8--"+map.get(new Integer(i)));
                }

                System.out.println("t8 over");
            }
        };

        Thread t9 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.get(new Integer(i));
                }

                System.out.println("t9 over");
            }
        };

        Thread t10 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.get(new Integer(i));
                    
                }

                System.out.println("t10 over");
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }

    public static void main(String[] args) {
        new TestLock();
    }
}