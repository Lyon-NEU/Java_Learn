class Dog implements Comparable<Dog>{
    String color;
    int size;
 
    Dog(String c, int s) {
        color = c;
        size = s;
    }
 
    public String toString(){   
        return color + " dog";
    }
 
    @Override
    public int compareTo(Dog o) {
        return  o.size - this.size;
    }
}
 
public class TestTreeMap {
    public static void main(String[] args) {
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 10);
 
        TreeMap treeMap = new TreeMap();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
 
        for (Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
