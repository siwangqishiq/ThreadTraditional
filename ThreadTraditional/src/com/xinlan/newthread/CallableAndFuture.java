package com.xinlan.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable对象
 * @author Administrator
 *
 *future.get()方法回阻塞所在线程 等待执行结果的返回
 */
public class CallableAndFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool = 	Executors.newSingleThreadExecutor();
		Future<String> future = null;
		future = threadPool.submit(new Callable<String>( ) {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				return "你好 世界!";
			}
		});
		
		
		System.out.println("等待结果.....");
		try {
			System.out.println("结果--->"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		threadPool.shutdown();
	}

}//end class
