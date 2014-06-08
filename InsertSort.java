/**
 *Insert sort
 */
import java.io.*;
import java.util.*;

public class InsertSort{
	public static void insertSort(Integer[]arr){
		int n=arr.length;
		if (n<=1) {
			System.out.println(arr);
			return;
		}
		for (int j=1; j<n; j++) {
			System.out.println("Step: "+j);
			int key=arr[j];
			int i=j-1;
			while(i>=0&&arr[i]>key){
				arr[i+1]=arr[i];
				i--;
			}
			arr[i+1]=key;
			for (Integer t:arr ) {
				System.out.println(t+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[]args){
		System.out.println("Insert Sort:");
		Integer []arr={5,2,4,6,1,3};
		insertSort(arr);
	}
}