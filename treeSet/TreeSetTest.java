package treeSet;
/**
 *@Author
 *@Date
 */
import java.util.*;
/**
 *This program sorts a set of item by comparing therir descritions
 * inner class  Comparator
 */
public class TreeSetTest{
	SortedSet<Item>parts=new TreeSet<>();
	parts.add(new Item("Toaster",1024));
	parts.add(new Item("Widget",4562));
	parts.add(new Item("Modem",9912));
	System.out.println(parts);

	SortedSet<Item>sortByDescription=new TreeSet<>(new Comparator<Item>()
	{
		public int compare(Item a,Item b){
			String descrA=a.getDescription();
			String descrB=b.getDescription();
			return descrA.compare(descrB);
		}
	});
	sortByDescription.addAll(parts);
	System.out.println(sortByDescription);
}
