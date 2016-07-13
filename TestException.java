
public class TestException{
	public static void main(String[]args){
		for(int i=0;i<10;i++){
			try{
				throw new NullPointerException("demo");
			}catch(NullPointerException  e){
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
