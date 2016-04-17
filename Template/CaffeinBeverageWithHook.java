package Template;

public abstract  class CaffeinBeverageWithHook {
	void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()){
			addCondiments();
		}
	}
	abstract void brew();
	abstract void addCondiments();
	void boilWater(){
		System.out.println("Boiling water");
	}
	void pourInCup(){
		System.out.println("Puring into cup");
	}
	boolean customerWantsCondiments(){
		return true;
	}
}
