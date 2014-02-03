package com.xinlan.newthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

	/**
	 * CountDownLatch
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final CountDownLatch countDown = new CountDownLatch(3);
		
		for(int i = 0;i<3;i++){
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread()+"ÔËÐÐ");
					try {
						countDown.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+"ÖÕÖ¹");
				}
			};
			threadPool.execute(runnable);
		}//end for i
		
		try {
			Thread.sleep(5000);
			countDown.countDown();
			countDown.countDown();
			countDown.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		threadPool.shutdown();
	}
}//end class
