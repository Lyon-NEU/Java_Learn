package com.liang.concurrency;

/**
 * Created by Liang on 12/29/2016.
 */
class Sleeper extends Thread{
    private  int duration;
    public Sleeper(String name,int sleeptime){
        super(name);
        duration=sleeptime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName()+" was interrupted. "+"isInterrupted():"+ isInterrupted())
;
            return;
        }
        System.out.println(getName()+" has awakened");
    }
}
class Joiner extends  Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}
public class Joining{
    public static void main(String[]args){
        Sleeper sleepy=new Sleeper("Sleepy",1500),
                grumpy=new Sleeper("Grummy ",1500);
        Joiner dopey=new Joiner("Dopey",sleepy),
                doc=new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }
}

