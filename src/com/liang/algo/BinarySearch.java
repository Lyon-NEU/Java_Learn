package com.liang.algo;

/**
 * Created by Liang on 2016/10/12.
 */
public class BinarySearch {
    public static int b_search(int[]arr,int low,int high,int key){
        int mid=0;
        while(low<=high){
            mid=(high-low)/2+low;
            if(key>arr[mid])low=mid+1;
            else if(key<arr[mid])high=mid-1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println("Search fo 6: "+b_search(arr,0,arr.length-1,6)); //5
        System.out.println("Search fo 6: "+b_search(arr,0,arr.length-1,1)); //0
        System.out.println("Search fo 6: "+b_search(arr,0,arr.length-1,10)); //9
        System.out.println("Search fo 6: "+b_search(arr,0,arr.length-1,30)); //-1
    }
}
