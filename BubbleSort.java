/**
 *Bubble Sort
 */
import java.io.*;
import java.util.*;

public class BubbleSort{
	public static void bubbleSort(Integer[]arr){
		for (int i=0; i<arr.length-1; i++) {
			Boolean exchange=false;
			for (int j=0; j<arr.length-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					//swap
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					exchange=true;
				}
			}
			if (exchange == false) {
				return;
			}
			System.out.println("Step---"+(i+1)+": ");
			for (int k=0; k<arr.length; k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Integer []arr={50,10,20,100,90,30,70,40,80,60};
		System.out.println("Before Sort: ");
		BubbleSort(arr);
		System.out.println("After Sort: ");
		for(int m:arr)
			System.out.print(m+" ");
		System.out.println();
	}
}