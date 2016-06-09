class Dog{
	String color;
	Dog(String c){
		color=c;
	}
	public boolean equals(Object o){
		return (Dog)o.color==this.color;
	}
	public int hashCode(){
		return color.length;
	}
	public String toString(){
		return color+"dog";
	}
}
public class TestHashMap{
	public static void main(String[]args){
		Dog d1 = new Dog("red");
        Dog d2 = new Dog("black");
        Dog d3 = new Dog("white");
        Dog d4 = new Dog("white");
 
        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);
 
        //print size
        System.out.println(hashMap.size());	
        
        for(Entry entry:hashMap.entrySet()){
        	System.out.println(entry.getKey().toString()+"-"+entry.getValue());
        }
	}
}	
