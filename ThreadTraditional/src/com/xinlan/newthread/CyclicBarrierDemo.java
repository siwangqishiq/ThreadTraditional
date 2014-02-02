package com.xinlan.newthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �߳�ͬ�� CyclicBarrier
 * @author Administrator
 *
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		final CyclicBarrier cycLicBarrier = new CyclicBarrier(3);
		for(int i = 0;i<3;i++){
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread()+"�� ����");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						cycLicBarrier.await();//�ȴ������߳� ���ϵ�һ��
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+"һ������");
				}
			};
			
			threadPool.execute(runnable);
		}//end for
	}
}//end class
