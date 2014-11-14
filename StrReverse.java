/**
 *对字符串排序，对于a-zA-Z根据ascii顺序排序，其余字母顺序不变
 *如"Wor#d",排序后为"Wdo#r"
 */
public class StrReverse {
	public static void main(String[] args) {
		reverse("abce");
		//String test = "abcd";
		//System.out.println("");
		
		String str="Wor#d";
		//System.out.print(isLegal(str.charAt(3)));
		sortASCII(str);
	}

	public static void sortASCII(String str){
		if(str.isEmpty()|| str==null){
			System.out.println("string is null");
			return;
		}
		System.out.println(str);
		char[]original=str.toCharArray();  //string是不可变对象
		char[]temp=new char[str.length()];
		char ctemp;
		for(int i=0;i<original.length;i++){
			if(!isLegal(original[i])){
				temp[i]=original[i];
			}
			else{
				//选择排序,需要稳定的排序
				for(int j=i+1;j<original.length;j++){
					if(!isLegal(original[j])){
						continue;
					}
					else if(original[i]>original[j]){
						//交换第i个元素和第j个元素
						ctemp=original[i];
						original[i]=original[j];
						original[j]=ctemp;
					}
				}
				temp[i]=original[i];
			}
		}
		for(char c: temp){
			System.out.print(c);
		}
		System.out.println();
	}

	/**
	 * 判 断是否为a-zA-Z
	 * @param c
	 * @return
	 */
	public static boolean isLegal(char c) {
		if(c<'A'|| c>'z')
		{
			return false;
		}
		else if(c>'Z'&& c<'a'){
			return false;
		}
		else
			return true;
	}
}
