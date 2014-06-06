import java.io.*;
import java.util.*;

public class QuickSort{
	public static int partion(Integer[]arr,int p, int r){
		int key=arr[p];
		int i=p,j=r;
		while(i<j){
			while(i<j&&key<=arr[j]){
				j--;
			}
			if (i<j) {
				arr[i]=arr[j];
			}
			while(i<j&&arr[i]<=key){
				i++;
			}
			if (i<j) {
				arr[j]=arr[i];
			}
		}
		arr[i]=key;
		return i;
	}
	public static void quicksort(Integer []arr,int start,int end){
		if (start<end) {
			int part=partion(arr,start,end);
			quicksort(arr,start,part-1);
			quicksort(arr,part+1,end);
		}
	}
	public static void main(String []args){
		System.out.println("QuickSort:");
		Integer []arr={0,-2,11,-4,13,-5,14,68};
		quicksort(arr,0,7);
		for (int i=0; i<8; i++) {
			System.out.print(arr[i]+(i==7? "\n":" "));
		}
	}
}