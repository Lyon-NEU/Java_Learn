package com.liang.threads.synchronize;

public class Consumer implements Runnable {
	private EventStorage storage;
	public Consumer(EventStorage storage){
		this.storage=storage;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			storage.get();
		}
	}
	public static void main(String[]args){
		EventStorage storage=new EventStorage();
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		thread2.start();
		thread1.start();
	}
}
