package com.mozovw.oatmeal.test.exam.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
//当有任务添加到线程池被拒绝时，会抛出RejectedExecutionException。
public class AbortPolicyDemo {  
  
    private static final int THREADS_SIZE = 1;  
    private static final int CAPACITY = 1;  
  
    public static void main(String[] args) throws Exception {  
  
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。  
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,  
                new ArrayBlockingQueue<Runnable>(CAPACITY));  
        // 设置线程池的拒绝策略为"抛出异常"  
        // 这个是默认的拒绝策略
        /*
         * 
         * private static final RejectedExecutionHandler defaultHandler =new AbortPolicy();
         * 
         * public ThreadPoolExecutor(int corePoolSize,
                int maximumPoolSize,
                long keepAliveTime,
                TimeUnit unit,
                BlockingQueue<Runnable> workQueue) {
			this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
			Executors.defaultThreadFactory(), defaultHandler);
			}
    	*/
        //pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());  
  
        try {  
  
            // 新建10个任务，并将它们添加到线程池中。  
            for (int i = 0; i < 10; i++) {  
                Runnable myrun = new MyRunnable("task-"+i);  
                pool.execute(myrun);  
            }  
        } catch (RejectedExecutionException e) {  
            e.printStackTrace();  
            // 关闭线程池  
            pool.shutdown();  
        }  
    }  
}  