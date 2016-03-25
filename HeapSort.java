/**
 * ¶ÑÅÅÐò&Ã°ÅÝÅÅÐò
 * @author Lyon
 * @date 2016//3/23
 */
public class HeapSort {
	/**
	 * ÏÂ³Á²»¶Ïµ÷Õû¶Ñ
	 * @param arr
	 * @param i 
	 * @param len
	 */
	public static void HeapAdjust(int []arr,int i,int len){
		int lchild=2*i;
		int rchild=2*i+1;
		int max=i;
		if(i<=len/2){
			if(lchild<=len&&arr[max]<arr[lchild]){
				max=lchild;
			}
			if(rchild<=len&&arr[max]<arr[rchild]){
				max=rchild;
			}
			if(max!=i){
				int tmp;
				tmp=arr[i];
				arr[i]=arr[max];
				arr[max]=tmp;
				HeapAdjust(arr,max,len);
			}
		}
	}
	/**
	 * build a max-heap 
	 * @param arr initial state
	 * @param len length of array
	 */
	public static void BuildHeap(int []arr,int len){
		for(int i=len/2;i>=1;i--){
			HeapAdjust(arr,i,len);
		}
	}
	/**
	 * heap sort
	 * @param arr 
	 * @param len size of array
	 */
	public static void HpSort(int[]arr,int len){
		BuildHeap(arr,len);
		for(int i=len;i>1;i--){
			int tmp;  //swap arr[0] with arr[i]
			tmp=arr[1];
			arr[1]=arr[i];
			arr[i]=tmp;
			HeapAdjust(arr,1,i-1);
		}
	}
	public static void BubbleSort(int[]arr){
		if(arr==null)
			return;
		boolean exchange=false;
		int tmp;
		for(int i=0;i<arr.length-1;i++){
			exchange=false;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					//swap arr[i] & arr[j]
					tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
					exchange=true;
				}
			}
			if(!exchange){
				System.out.println("Already ordered!");
				return;
			}
		}
	}
	public static void main(String[]args){
		int []arr={0,-2,11,-4,13,-5,14,68};
		BubbleSort(arr);
		for(int a:arr)
			System.out.print(a+",");
		System.out.println("");
		
		int[]hpArr={0,16,7,3,20,17,8};
		//BuildHeap(hpArr,6);
		HpSort(hpArr,6);
		for(int a:hpArr)
			System.out.print(a+",");
		System.out.println("");
	}
}
