package com.xinlan.traditional;

/**
 * Ïß³Ì»¥³â
 * 
 * @author Administrator
 * 
 */
public class TraditionalThreadSynchronized {

	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}

	private void init() {
		final Outputer out = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("panyi");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("taoxinlan");
				}
			}
		}).start();
	}

	// class Outputer {
	// public void output(String name) {
	// int len = name.length();
	// synchronized(Outputer.class){
	// for (int i = 0; i < len; i++) {
	// System.out.print(name.charAt(i));
	// }
	// System.out.println();
	// }
	// }

	class Outputer {
		public synchronized void output(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		public void output3(String name){
			
		}
	}
}// end class
