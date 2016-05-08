package algorithm;

import java.util.Arrays;

/**
 * 计算最小差
 * @author Lyon
 * @date 2016/05/09
 */
public class MiniDifference {
	/**
	 * n个点，差最的距离
	 * @param arr
	 * @param n
	 * @return
	 */
	public static double miniDiff(double []arr,int n){
		if(n<2)
			return 0;
		Arrays.sort(arr);
		double diff=arr[1]-arr[0];
		for(int i=2;i<n;i++){
			double tmp=arr[i]-arr[i-1];
			if(tmp<diff)
				diff=tmp;
		}
		return diff;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double []arr={0.2,3,0.1,10,8,6.6};
		System.out.println(miniDiff(arr,6));
	}

}
