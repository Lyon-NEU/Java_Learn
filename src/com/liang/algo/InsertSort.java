package com.liang.algo;

/**
 * Created by Liang on 2016/10/18.
 */
public class InsertSort {
    public static void sort(int[]arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0&& arr[j]<arr[j-1];j--){
                int tmp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
            }
        }
    }
    public static void main(String[]args){
        int []arr={2,1,9,8,3,5};
        sort(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
}
