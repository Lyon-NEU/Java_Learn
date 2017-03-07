package com.liang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liang on 1/5/2017.
 */
class CarDecrator{
    private boolean waxOn=false;
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }
    public synchronized  void buffed(){
        waxOn=false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while(waxOn==false)
            wait();
    }
    public synchronized  void waitForBuffing()throws  InterruptedException{
        while(waxOn==true)
            wait();
    }
}
class WaxOn implements  Runnable{
    private CarDecrator car;
    public WaxOn(CarDecrator c){
        car=c;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Ending Wax On task");
    }
}
class WaxOff implements  Runnable{
    private CarDecrator car;
    public WaxOff(CarDecrator c){car=c;}
    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[]args)throws Exception {
        CarDecrator car=new CarDecrator();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.MILLISECONDS.sleep(5000);
        exec.shutdown();
    }
}
