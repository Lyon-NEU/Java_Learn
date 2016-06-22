package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalloonRise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>res=new ArrayList<String>();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String line="";
		line=in.nextLine();
		while((line!=null)&&(!line.equals("0"))){
			int num=Integer.valueOf(line);
			int i=1;
			HashMap<String,Integer>map=new HashMap<String,Integer>();
			while(i<=num){
				line=in.nextLine();
				Integer count=map.get(line);
				map.put(line, count==null?1:count+1);
				i++;
			}
			int count=0;
			String ball="";
			for(Map.Entry<String, Integer>entry:map.entrySet()){
				if(entry.getValue()>count){
					ball=entry.getKey();
					count=entry.getValue();
				}
			}
			res.add(ball);
			line=in.nextLine();
		}
		for(String ball:res)
			System.out.println(ball);
	}

}
