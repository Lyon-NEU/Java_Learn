package com.liang.algo;

/**
 * Created by Liang on 2016/10/21.
 */
public class MergeSort {
    public static void merge(int[]arr,int low,int mid,int high){
        int i=0,j=mid-low+1;    //relative pos and abstract pos transfer
        int []tmp=new int[high-low+1];
        for(int l=0;l<=high-low;l++)
            tmp[l]=arr[low+l];
        for(int k=low;k<=high;k++){
            if(i>mid-low)arr[k]=tmp[j++];
            else if(j>high-low)arr[k]=tmp[i++];
            else if(tmp[i]<=tmp[j]) arr[k] = tmp[i++];
            else arr[k]=tmp[j++];
        }
    }
    public static void sort(int[]arr,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void main(String[]args){
        int[]arr={50,10,20,100,90,30,70,40,80,60};
        sort(arr,0,arr.length-1);
        for(int a:arr)
            System.out.print(a+" ");
    }
}
