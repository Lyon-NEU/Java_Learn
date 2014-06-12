import java.io.*;
public class NoVisibility{
	private static boolean ready;
	private static int number;
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready)
				System.yield();
			System.out.println(number);
		}
	}
	public static void main(String []args){
		new ReaderThread().start();
		ready=true;
		number=32;
	}
}