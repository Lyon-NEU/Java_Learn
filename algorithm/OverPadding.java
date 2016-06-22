package com.wangliang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间重合判断
 * @author Lyon
 * @date 2016/05/03
 */
class Node{
	private int x;
	private int y;
	public Node(int x,int y){
		this.x=x;
		this.y=y;
	}
	public Node(){
		
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	@Override
	public String toString(){
		return "x="+x+", y="+y;
	}
}
public class OverPadding {
	/**
	 * 合并排序后的区间，
	 * @param nodes
	 * @return
	 */
	public static List<Node> mergeInterval(List<Node> nodes){
		List<Node>sortedNode=new ArrayList<>();
		if(nodes.size()>1){
			Node cur=nodes.get(0);
			int i=1;
			while(i<nodes.size()){
				if(nodes.get(i).getX()==cur.getY()){
					cur.setY(nodes.get(i).getY());	
				}
				else{
					sortedNode.add(cur);
					cur=nodes.get(i);
				}	
				i++;
			}
			sortedNode.add(cur);  //添加最后一个区间
		}
		return sortedNode;
	}
	//对区间进行排序
	public static void sortInterval(List<Node> nodes2){
		Node[]nodes=(Node[]) nodes2.toArray(new Node[nodes2.size()]);
		Arrays.sort(nodes,new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.getX()<o2.getX()?-1:(o1.getX()==o2.getX()?0:1);
			}
			
		});
		nodes2.clear(); //清空原先数据，重新依次插入
		for(Node node:nodes)
			nodes2.add(node);
	}
	/**
	 * 在list中查询指定区间node
	 * @param list
	 * @param node
	 * @return true if find the node
	 */
	public static boolean search(List<Node>list,Node node){
		for(Node a:list){
			if(a.getX()<=node.getX()&&a.getY()>=node.getY())
				return true;
		}
		return false;
	}
	public static void PrintInterval(List<Node>list){
		for(Node node:list){
			System.out.println(node);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		List<Node>nodes=new ArrayList<Node>();
		try{
			in=new BufferedReader(new FileReader(new File("interval.txt")));
			String line;
			while((line=in.readLine())!=null){
				String[]xy=line.split(" ");
				int x=Integer.valueOf(xy[0]);
				int y=Integer.valueOf(xy[1]);
				Node node=new Node(x,y);
				nodes.add(node);
			}
			PrintInterval(nodes);
			System.out.println("---sorted---");
			sortInterval(nodes);
			PrintInterval(nodes);
			
			nodes=mergeInterval(nodes);
			System.out.println("---merged---");
			PrintInterval(nodes);
			
			Node node=new Node(1,3);
			System.out.println("Search interval[ "+node.getX()+" "+node.getY()+"]");
			System.out.println(search(nodes,node));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
