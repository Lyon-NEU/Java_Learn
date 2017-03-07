package com.liang.algo;

/**
 * Created by Liang on 2016/10/19.
 */
public class BubbleSort {
    public static void  sort(int[]arr){
        if(arr==null)
            return;
        for(int i=0;i<arr.length-1;i++){
            boolean exchange=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    exchange=true;
                }
            }
            if(!exchange)break;
        }
    }
    public static void main(String[]args){
        int []arr={1,6,8,5,7,16,9,10};
        sort(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
}
