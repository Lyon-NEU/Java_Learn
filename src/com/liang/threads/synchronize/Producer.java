package com.liang.threads.synchronize;

public class Producer implements Runnable {
	private EventStorage storage;
	public Producer(EventStorage storage){
		this.storage=storage;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			storage.set();
		}
	}

}
