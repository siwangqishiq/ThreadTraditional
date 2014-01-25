package com.xinlan.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable����
 * @author Administrator
 *
 *future.get()���������������߳� �ȴ�ִ�н���ķ���
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
				return "��� ����!";
			}
		});
		
		
		System.out.println("�ȴ����.....");
		try {
			System.out.println("���--->"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		threadPool.shutdown();
	}

}//end class
