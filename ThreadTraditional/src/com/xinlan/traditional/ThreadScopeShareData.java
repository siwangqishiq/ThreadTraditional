package com.xinlan.traditional;

import java.util.Random;

public class ThreadScopeShareData {
	/**
	 * 线程范围内的数据共享
	 * ThreadLocal  线程范围内的共享变量
	 * 	
	 */
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+"has put data:"+data);
					x.set(data);
					
					 new A().get();
					 new B().get();
				}
			}).start();
		}//end for
	}
	
	static class A{
		public void get(){
			int data = x.get();
			System.out.println("A  get "+data+" from thread -->"+Thread.currentThread().getName());
		}
	}
	
	static class B{
		public void get(){
			int data = x.get();
			System.out.println("B  get "+data+" from thread -->"+Thread.currentThread().getName());
		}
	}
}
