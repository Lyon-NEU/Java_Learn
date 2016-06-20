import java.util.concurrent.*;
import java.util.*;

class Horse implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private int strides=0;
	private static Random rand=new Random(47);
	private static CycliBarrier barrier;
	public Horse(CycliBarrier b){
		barrier=b;
	}
	public synchronized int getStrides(){
		return strides;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized(this){
					strides+=rand.nextInt(3);
				}
			}
			barrier.await();
		}catch(interruptedException e){
			//
		}catch(BrokenBarrierException e){
			throw new RuntimeException(e);
		}
	}
	public String toString(){
		return "Horse "+id+" ";
	}
	public String tracks(){
		StringBuilder s=new StringBuilder();
		for(int i=0;i<getStrides();i++)
			s.append("*");
		s.append(id);
		return s.toString();
	}
}
public class HorseRace{
	static final int FINISH_SIZE=75;
	private List<Horse>horses=new ArrayList<Horse>();
	private ExcutorService exec=new Executors.newCachedThreadPool();
	private CycliBarrier barrier;
	public HorseRace(int nHorses,final int pause){
		barrier=new CycliBarrier(nHorses,new Runnable(){
			public void run(){
				StringBuilder s=new StringBuilder();
				for(int i=0;i<FINISH_SIZE;i++)
					s.append("=");
				System.out.println(s);
				for(Horse horse:horses)
					System.out.println(horse.tracks());
				for(Horse horse:horses)
					if(horse.getStrides()>=FINISH_SIZE){
						System.out.println(horse+"won!");
						exec.shutdown();
						return;
					}
				try{
					TimeUnit.MILLISECONDS.sleep(pause);
				}catch(interruptedException e){
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		for(int i=0;i<nHorses;i++){
			Horse horse=new Horse(barrier);
			horse.add(horse);
			exec.execute(horse);
		}
	}
	public static void main(String[]args){
		int nHorses=7;
		int pause=200;
		if(args.length>0){
			int n=new Integer(args[0]);
			nHorses=n>0?n:nHorses;
		}
		if(args.length>1){
			int p=new Integer(args[1]);
			pause=p>-1?p:pause;
		}
		new HorseRace(nHorses,pause);
	}
}
