package com.liang.algo;

/**
 * Created by Liang on 2016/10/24.
 */
public class QuickSort {
    public static void sort(int []arr,int low,int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
    public static int partition(int[]arr,int low,int high){
        int key=arr[low];
        int i=low,j=high;
        while(i<j){
            while(arr[j]>=key&&i<j)j--;
            if(i<j)arr[i]=arr[j];
            while(arr[i]<=key&&i<j)i++;
            if(i<j)arr[j]=arr[j];
        }
        arr[i]=key;
        return i;
    }
    public static void main(String[]args){
        int[]arr={10,60,70,20,40,30,90,80,100};
        sort(arr,0,arr.length-1);
        for(int a:arr)
            System.out.print(a+" ");
    }
}
