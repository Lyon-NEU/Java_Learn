package algorithm;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 由于n<20,所以可以预处理前40个自然数中的素数，然后深度搜索某个位置的未被访问过的数字和它相邻的数字之和是否为素数
 * 退出搜索的条件是最后一个位置的数字arr[n]+1为素数，每次搜索完成后，要回溯
 */


public class PrimeRing {
	private static int Primes[]={2,3,5,7,11,13,17,19,23,29,31,37};
	public static void Print(int[]arr){
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println();
	}
	/**
	 * Judge n is a prime number
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n){
		if(n<=1)
			return false;
		for(int j=2;j<=Math.sqrt(n);j++){
			if(n%j==0)
				return false;
		}
		return true;
	}
	public static boolean is_prime(int a){
		for(int i=0;i<Primes.length;i++)
			if(a==Primes[i])
				return true;
		return false;	
	}
	/**
	 * Given n, output circle clockwisely and anticlockwisely
	 * @param start 
	 * @param end
	 */
	public static void dfs(int cur,int []arr,boolean[]visited){
		if(cur==arr.length-1){
			if(is_prime(arr[cur]+arr[0]))  //search end
				Print(arr);
			return;
		}
		for(int i=2;i<=arr.length;i++){
	        if (!visited[i-1]&& is_prime(i+arr[cur])){
	            arr[cur+1] = i;
	            visited[i-1] = true;
	            dfs(cur+1,arr,visited);
	            visited[i-1] = false;  //reset for trace back
	        }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=in.nextInt();
		int arr[]=new int[n];
		boolean []visited=new boolean[n];
		arr[0]=1;
		visited[0]=true;
		for(int i=1;i<n;i++){
			arr[i]=i+1;
			visited[i]=false;
		}
		dfs(0,arr,visited);
	}
}

