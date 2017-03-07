package com.liang.concurrency;

public class MultiThreadStatic implements Runnable {
	private static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadStatic mt=new MultiThreadStatic();
		for(int i=0;i<3000;i++){
			new Thread(mt,"Ïß³Ì"+i).start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		count=1;
		System.out.println("["+Thread.currentThread().getName()+"]:"+count);
		count=10;
		System.out.println("["+Thread.currentThread().getName()+"]:"+count*2);
	}

}
