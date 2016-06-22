/*********************
 * @author Lyon
 * @Description
 * @Date 2014/04/17
 */
import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionCloningTest {
	
	public static void main(String []args){
		Collection<Employee>org=new HashSet<>();
		org.add(new Employee("John","Manager"));
		org.add(new Employee("Tim","Developer"));
		org.add(new Employee("Frank","Developer"));
		Collection<Employee>copy=new HashSet<>(org);


        Iterator<Employee> itr = org.iterator(); 
        while(itr.hasNext()){ 
            itr.next().setDesignation("staff"); 
        } 
        System.out.println(org);
        System.out.println(copy);

 
        /**************
         * deep clone list in java, implement clone
         * 改变原始Collection中Employee对象(改变designation为”staff“)在克隆集合中也有所反映，因为克隆是浅拷贝，
         * 指向堆中相同的Employee对象。为了修正这个问题，需要遍历集合，深克隆Employee对象，在这之前，要重写Employee对象的clone方法。
		 *1)Employee实现Cloneable接口
		 *2)为Employee类增加下面的clone()方法
         */
      /* Collection<Employee> copyDeep = new HashSet<Employee>(org.size()); 
        
        Iterator<Employee> iterator = org.iterator(); 
        while(iterator.hasNext()){ 
            copyDeep.add(iterator.next().clone()); 
        }
        System.out.println(org);
        System.out.println(copyDeep);*/
	}
}

class Employee implements Cloneable{
	private String name;
	private String designation;
	public Employee(String name,String designation){
		this.name=name;
		this.designation=designation;
	}
	public String getDesignation(){
		return designation;
	}
	public String getName(){
		return name;
	}
	public void setDesignation(String designation){
		this.designation=designation;
	}
	public void setName(String name){
		this.name=name;
	}
	@Override
	public String toString(){
		return String.format("%s:%s", name,designation);
	}
	/*@Override
	protected Employee clone(){
		Employee clone;
		try{
			clone=(Employee)super.clone();
		}catch(CloneNotSupportedException e){
			throw new RuntimeException(e);
		}
		return clone;
	}*/
}