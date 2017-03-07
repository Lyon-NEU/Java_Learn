package com.liang.algo;

import java.util.stream.Stream;

/**
 * Created by Liang on 2016/10/18.
 */
public class SelectSort {
    public static void sort(int[]arr){
        if(arr==null)
            return;
        for(int i=0;i<arr.length-1;i++){
            int min_index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_index]){  //change min index each time
                    min_index=j;
                }
            }
            int tmp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=tmp;
        }
    }
    public static void main(String[]args){
        int []arr={5,63,28,1,0,100,99,-100};
        sort(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
}
