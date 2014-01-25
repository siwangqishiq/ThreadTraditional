package com.xinlan.newthread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CompletionDemo {

	/**
	 * Completionʹ�� ���ڽ��ն��Callable���صĶ���
	 * @param 
	 */
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		CompletionService<Integer> completion = new ExecutorCompletionService<Integer>(threadPool);
		for(int i = 0;i<10;i++){
			final int seq = i;
			completion.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(3000));
					return seq;
				}
			});
		}//end for i
		
		for(int i =0;i<10;i++){
			try {
				System.out.println("get"+completion.take().get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end for i
		threadPool.shutdown();
	}
}//end class
