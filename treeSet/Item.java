package treeSet;
import java.util.*;

/**
 *An item with a description and a part number
 */
public class Item implements Comparable<Item>{
	private String description;
	private int partNumber;
	/**
	 *Constructs an item
	 */
	public Item(String aDescription,int aPartNumber){
		description=aDescription;
		partNumber=aPartNumber;
	}
	public String getDescriptionb(){
		return description;
	}
	public String toString(){
		return "[description="+description+", partNumber="+partNumber+"]";
	}
	public boolean equals(Object otherObject){
		if (this == otherObject) {
			return true;
		}
		if (otherObject==null) {
			return false;
		}
		if (getClass()!=otherObject.getClass()) {
			return false;
		}
		Item other=(Item)otherObject;
		return Object.equals(description,other.descrpition) && partNumber==other.partNumber;
	}
	public int hasCode(){
		return Ojbects.hash(description,partNumber);
	}
	public int compareTo(Item other){
		return Integer.compare(partNumber,other.partNumber);
	}
}