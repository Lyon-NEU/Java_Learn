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
         * �ı�ԭʼCollection��Employee����(�ı�designationΪ��staff��)�ڿ�¡������Ҳ������ӳ����Ϊ��¡��ǳ������
         * ָ�������ͬ��Employee����Ϊ������������⣬��Ҫ�������ϣ����¡Employee��������֮ǰ��Ҫ��дEmployee�����clone������
		 *1)Employeeʵ��Cloneable�ӿ�
		 *2)ΪEmployee�����������clone()����
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