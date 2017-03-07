package com.liang.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 通过中断来取消任务
 * @author Liang
 * @date 2017.3.7
 */
public class PrimeProducer extends Thread {
	private final BlockingQueue<BigInteger>queue;
	PrimeProducer(BlockingQueue<BigInteger>queue){
		this.queue=queue;
	}
	public void run(){
		try{
			BigInteger p=BigInteger.ONE;
			while(!Thread.currentThread().isInterrupted()){
				queue.put(p=p.nextProbablePrime());
			}
		}catch(InterruptedException e){
			/* 允许线程退出*/
		}
	}
	public void cancel(){
		interrupt();
	}
	public List<BigInteger> get(){
		return new ArrayList<BigInteger>(queue);
	}
	public static void main(String[]args) throws InterruptedException{
		BlockingQueue<BigInteger>queue=new LinkedBlockingQueue<BigInteger>();
		PrimeProducer p=new PrimeProducer(queue);
		p.start();
		try{
			sleep(1000);
		}finally{
			p.cancel();
		}
		List<BigInteger>result=p.get();
		for(BigInteger b:result){
			System.out.println(b);
		}
	}
}
