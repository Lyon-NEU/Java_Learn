/**
 *Merge Sort
 *
 */
import java.util.*;
import java.io.*;

public class MergeSort{
	/**
	 *merge two sorted parts of arr
	 */
	public static void merge(Integer[]arr,int p,int q,int r){
		int n1=q-p+1;
		int n2=r-q;
		Integer []L=new Integer[n1+1];
		Integer []R=new Integer[n2];
		int i,j;
		for (i=0; i<n1; i++) {
			L[i]=arr[p+i];
		}
		for (j=0; j<n2; j++) {
			R[j]=arr[q+j+1];
		}
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		i=0;
		j=0;
		for (int k=p; k<=r; k++) {
			if (L[i]>R[j]) {
				arr[k]=L[i];
				i++;
			}
			else{
				arr[k]=R[j];
				j++;
			}
		}
	}

	/**
	 *merge sort arr[p...q]
	 */
	public static void mSort(Integer[] arr, int p,int q){
		if (p<q) {
			int mid=(p+q)/2;
			mSort(arr,p,mid);
			mSort(arr,mid+1,q);
			merge(arr,p,mid,q);
		}
	}

	/**
	 *main
	 */
	public static void main(String[]args){
		Integer []arr={50,10,20,100,90,30,70,40,80,60};
		System.out.println("Before Sort: ");
		for (int t:arr) {
			System.out.print(t+":");
		}
		System.out.println();
		mSort(arr,0,arr.Length-1);
		System.out.println("After Sort: "):
		for (int m:arr ) {
			System.out.print(m+" ");
		}
		System.out.println();
	}
}