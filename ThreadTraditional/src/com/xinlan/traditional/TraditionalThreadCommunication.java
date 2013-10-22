package com.xinlan.traditional;

public class TraditionalThreadCommunication {

	/**
	 * �̼߳��ͬ��ͨ��
	 * 
	 * ���߳�ѭ��10�� �������߳�ѭ��100�� �����ֻص����߳�ѭ��10�� �����ٻص����߳���ѭ��100�� ���ѭ��50�� д������
	 * 
	 * @param
	 */
	public static void main(String[] args) {
		new TraditionalThreadCommunication().init();
	}

	private void init(){
		final Business business = new Business();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=1;i<=50;i++){
					business.subDo(i);
				}//end for i
			}
		}).start();
		
		for(int i=1;i<=50;i++){
			business.mainDo(i);
		}//end for i
	}
	
	private final class Business {
		private boolean shouldSubRun=true;
		
		public synchronized void subDo(int count) {
			while(!shouldSubRun){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//end while
			
			for (int i = 1; i <= 10; i++) {
				System.out.println("sub-->"+i+",   count--->"+count);
			}// end for
			
			shouldSubRun=false;
			this.notify();
		}

		public synchronized void mainDo(int count) {
			while(shouldSubRun){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//end while
			
			for (int i = 1; i <= 20; i++) {
				System.out.println("main-->"+i+",   count--->"+count);
			}// end for
			
			shouldSubRun = true;
			this.notify();
		}
	}// end inner class
}// end class
