package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
	//合并排序后的区间
	public static List<Node> mergeInterval(List<Node> nodes){
		List<Node>sortedNode=new ArrayList<>();
		if(nodes.size()>1){
			Node cur=nodes.get(0);
			int i=1;
			while(i<nodes.size()){
				Node tmp=new Node();
				tmp.setX(cur.getX());
				tmp.setY(cur.getY());
				while((i<nodes.size())&&(nodes.get(i).getX()==cur.getY())){
					tmp.setY(nodes.get(i).getY());
					i++;
				}
				sortedNode.add(tmp);
				cur=nodes.get(i);
				if(i<nodes.size())
					i++;		
			}
		}
		return sortedNode;
	}
	//对区间进行排序
	public static void sortInterval(ArrayList<Node>list){
		
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
			nodes=mergeInterval(nodes);
			System.out.println("---merged---");
			PrintInterval(nodes);
			
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
