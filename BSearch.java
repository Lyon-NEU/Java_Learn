/**
* 二分查找
* @date 2016/03/25
*/

public class BSearch{
	/**
	* @param arr 查找数组
	* @param key 待查找元组
	*/
	public static int binarySearch(int[] arr,int key){
		int i=0;
		int j=arr.length-1;
		int mid;
		while(i<=j){
			mid=(i+j)/2;
			if(key>arr[mid])
				i=mid+1;
			else if(key<arr[mid])
				j=mid-1;
			else 
				return mid;
		}
		return -1;
	}
	public static void main(String[]args){
		int []arr={1,2,3,4,5,6,7,8,9,10};
		System.out.println(arr,8);  //output:7
	}
}
