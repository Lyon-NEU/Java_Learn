package Template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeinBeverageWithHook {

	@Override
	void brew() {
		// TODO Auto-generated method stub
		System.out.println("Dripping Sugar and Milk");
	}

	@Override
	void addCondiments() {
		// TODO Auto-generated method stub
		System.out.println("Adding Sugar and Milk");
	}
	public boolean customerWantsCondiments(){
		String answer=getUserInput();
		if(answer.toLowerCase().startsWith("y")){
			return true;
		}
		else{
			return false;
		}
	}
	private String getUserInput(){
		String answer=null;
		System.out.println("Would you like milk and sugar with your coffee (y/n)? ");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		try{
			answer=in.readLine();
		}catch(IOException e){
			System.out.println("IO error trying to read your answer");
		}
		if(answer==null){
			return "no";
		}
		return answer;
	}

}
