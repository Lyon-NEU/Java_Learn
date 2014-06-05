import java.util.*;
import java.io.*;
public class EditDistance {
	private static int Minium(int a,int b,int c){
		int mi;
		mi=a;
		if(b<mi)mi=b;
		if(c<mi)mi=c;
		return mi;
	}
	public static int  distance(String str1,String str2) {
//		if (str1.equals(str2)) {
//			System.out.println("Same");
//			return 0;
//		}
		int[][]d=new int[str1.length()+1][str2.length()+1];
		int i;
		int j;
		for (i = 0; i <= str1.length(); i++) {
			d[i][0]=i;
		}
		for( j=0;j<=str2.length();j++){
			d[0][j]=j;
		}
		int cost;
		char s_i;
		char s_j;
		for(i=1;i<=str1.length();i++){
			s_i=str1.charAt(i-1);
			for(j=1;j<=str2.length();j++){
				s_j=str2.charAt(j-1);
				if (s_i==s_j) {
					cost=0;
				}
				else{
					cost=1;
				}
				d[i][j]=Minium(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1]+cost);
			}
		}
		return d[str1.length()][str2.length()];
	}
	public static void main(String[] args)throws IOException{
		//Scanner s=new Scanner(System.in);
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input the first string: ");
		String str1=stdin.readLine();
		System.out.println("input the second string:");
		String str2=stdin.readLine();
		System.out.println("The distance between the strings is: "+distance(str1,str2));
	}
}
