/**
	@Author wl
	@Date: 2014/05/24
*/
import java.util.HashMap;
import java.util.Map;

final class Employee{
	private String name;
	private int age;
	Employee(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee e=(Employee)o;
		return e.getName().equals(name)&& e.getAge() ==age;
	}
	String getName(){
		return name;
	}
	int getAge(){
		return age;
	}
	/******************
	**It's best practise to override hashcode(), when u override euqals()
	  在同一个Java程序中，对一个相同的对象，无论调用多少次hashCode()，hashCode()返回的整数必须相同，因此必须保证equals()方法比较的内容不会更改。但不必在另一个相同的Java程序中也保证返回值相同。
	  如果两个对象用equals()方法比较的结果是相同的，那么这两个对象调用hashCode()应该返回相同的整数值。
	  当两个对象使用equals()方法比较的结果是不同的，hashCode()返回的整数值可以不同。然而，hashCode()的返回值不同可以提高哈希表的性能。
	  Joshua Bloch的《Effective Java》第八版中给出了一个四步法来正确的覆盖hashCode()
	********************/
	@Override 
	public int hashCode(){
		int result=31;
		result=37*result+name.hashCode();
		result =37*result+age;
		return result;
	}
}
public class HashDemo{
	public static void main(String []args){
		Map<Employee,String>map=new HashMap<>();
		Employee emp=new Employee("Lyon",28);
		map.put(emp,"first employee");
		System.out.println(map.get(emp));
		System.out.println(map.get(new Employee("Lyon",28)));
	}
}