import java.util.Arrays;
import java.util.LinkedList;


/**
 * 图的实现以及常用操作
 * 图的邻接矩阵，邻接表实现
 * 图的深度优先，广度优先遍历
 * <p></p>
 * @author Lyon
 * @date 2016/04/25
 */
class Vertex{
	private int value;
	public Vertex(){
		
	}
	public void setValue(int value){
		this.value=value;
	}
	public int getValue(){
		return value;
	}
	@Override
	public String toString(){
		return "vex: "+value;
	}
}
class Edge{
	private int start;  //依附结点
	private int end;    //终结结点
	public Edge(int s,int e){
		this.start=s;
		this.end=e;
	}
	@Override
	public String toString(){
		return start+" -> "+end;
	}
}
public class Graph {
	private static final int MAXVEX=100;  //最大顶点数
	private int vex_num;  //顶点数
	private int edge_num; //边数
	private int edges[][]=new int[MAXVEX][MAXVEX];
	private Vertex []vexs=new Vertex[MAXVEX];
	private boolean [] visited = new boolean[MAXVEX];
	public void DFS(Graph graph,int i){
		visited[i]=true;
		System.out.println(graph.vexs[i]);
		for(int j=0;j<graph.vex_num;j++){
			if(graph.edges[i][j]==1&&!visited[j])
				DFS(graph,j);
		}
	}
	public void DFSTraverse(Graph graph){
		for(int i=0;i<graph.vex_num;i++)
			visited[i]=false;
		for(int j=0;j<graph.vex_num;j++){
			if(!visited[j])
				DFS(graph,j);
		}
	}
	/**
	 * 从第i个结点开始广度优先遍历
	 * @param graph
	 * @param i
	 */
	public void BFSTraval(Graph graph, int i){
		LinkedList<Vertex>queue =new LinkedList<Vertex>();
		System.out.println(graph.vexs[i]);
		visited[i]=true;
		queue.addLast(graph.vexs[i]);
		while(!queue.isEmpty()){
			Vertex v=queue.poll();
			for(int j=0;j<graph.vex_num;j++){
				if(graph.edges[i][j]==1&&!visited[j]){
					System.out.println(graph.vexs[j]);
					visited[j]=true;
					queue.addLast(graph.vexs[j]);
				}
			}
		}
	}
	public void BFSTraval(Graph graph){
		for(int i=0;i<graph.vex_num;i++)
			visited[i]=false;
		for(int i=0;i<graph.vex_num;i++){
			if(!visited[i])
				BFSTraval(graph,i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="hello,world";
		char[]wc=test.toCharArray();
		Arrays.sort(wc);
		String test2=wc.toString();  //@
		String test3=String.valueOf(wc); //
		System.out.println(test2+" "+test3);
	}

}
