package com.liang.concurrency;
import java.util.concurrent.*;
import java.util.*;

class TaskPortion implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private static Random rand=new Random(30);
	private final CountDownLatch latch;
	TaskPortion(CountDownLatch latch){
		this.latch=latch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			doWork();
			latch.countDown();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public void doWork() throws InterruptedException{
		TimeUnit.MICROSECONDS.sleep(rand.nextInt(2000));
		System.out.println(this+" completed.");
	}
	public String toString(){
		return String.format("%1$-3d ",	id);
	}
}
class WaitingTask implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch){
		this.latch=latch;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			latch.await();
			System.out.println("Latch barrier passed for "+this);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public String toString(){
		return String.format("WaitingTask %1$-3d", id);
	}
}
public class CountDownLatchDemo{ 
	static final int SIZE=100;
	public static void main(String[]args){
		ExecutorService exec=Executors.newCachedThreadPool();
		CountDownLatch latch=new CountDownLatch(SIZE);
		for(int i=0;i<10;i++){
			exec.execute(new WaitingTask(latch));
		}
		for(int i=0;i<SIZE;i++){
			exec.execute(new TaskPortion(latch));
		}
		System.out.println("Launched all takks");
		exec.shutdown();
		
		String originurl="http://www.fj.xinhuanet.com/whyl/2013-10/29/c_117913723.htm";
        String[] url = originurl.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < url.length - 1; i++) {
            sb.append(url[i]).append("/");
        }
        System.out.println(sb.toString());
	}

}
