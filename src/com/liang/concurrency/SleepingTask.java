package com.liang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liang on 12/28/2016.
 */
public class SleepingTask implements Runnable {
    private int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+").";
    }
    public void run(){
        try{
            while(countDown-->0){
                System.out.println(status());
                Thread.sleep(100);
            }
        }catch(InterruptedException e){
            System.err.println("Interrupted!");
        }
    }
    public static void main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
