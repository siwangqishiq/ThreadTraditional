package com.xinlan.newthread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTestDemo {

	/**
	 * LockËø¶ÔÏó
	 * @param args
	 */
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		
		try{
			lock.lock();
			//TODO ....
		}finally{
			lock.unlock();
		}
	}
}//end class
