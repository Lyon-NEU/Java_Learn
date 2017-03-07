package com.liang.threads.blockingQueue;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
public class BlockingQueueTest {
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local)");
		String directory=in.nextLine();
		System.out.println("Enter keyword: (e.g. volatile");
		String keyword=in.nextLine();
		
		final int FILE_QUEUE_SIZE=10;
		final int SEARCH_THREADS=100;
		BlockingQueue<File>queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		FileEnumerationTask enumerator=new FileEnumerationTask(queue,new File(directory));
		new Thread(enumerator).start();
		for(int i=0;i<=SEARCH_THREADS;i++){
			new Thread(new SearchTask(queue,keyword)).start();
		}
	}
	static class FileEnumerationTask implements Runnable{
		public static File DUMMY=new File("");
		private BlockingQueue<File>queue;
		private File startingDirectory;
		
		public FileEnumerationTask(BlockingQueue<File>queue,File startingDirectory){
			this.queue=queue;
			this.startingDirectory=startingDirectory;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				enumerate(startingDirectory);
				queue.put(DUMMY);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		public void enumerate(File directory)throws InterruptedException{
			File[]files=directory.listFiles();
			for(File file:files){
				if(file.isDirectory())enumerate(file);
				else queue.put(file);
			}
		}
		
	}
	static class SearchTask implements Runnable{
		private BlockingQueue<File>queue;
		private String keyword;
		public SearchTask(BlockingQueue<File>queue,String keyword){
			this.queue=queue;
			this.keyword=keyword;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				boolean done=false;
				while(!done){
					File file=queue.take();
					if(file==FileEnumerationTask.DUMMY){
						queue.put(file);
						done=true;
					}
					else search(file);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		public void search(File file)throws IOException{
			try(Scanner in=new Scanner(System.in)){
				int linenumber=0;
				while(in.hasNextLine()){
					linenumber++;
					String line=in.nextLine();
					if(line.contains(keyword))
						System.out.printf("%s:%d:%s%n",file.getPath(),linenumber,line);
				}
			}
		}
	}
}
