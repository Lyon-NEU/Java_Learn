package com.liang.algo;

/**
 * Created by Liang on 2016/10/13.
 */
public class ArraySum {
    public static int sumArr(int[]arr){
        int sum=0;
        int b=0;
        for (int i=0;i<arr.length;i++){
            if (b>=0)b+=arr[i];
            else b=arr[i];
            if(sum<b)sum=b;
        }
        return sum;
    }

    public static void main(String[]args){
        int arr[]={1,2,6,-16,8,0};
        System.out.println("Sum: "+sumArr(arr));
    }
}
