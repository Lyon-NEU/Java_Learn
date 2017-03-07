package com.liang.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray=new String[]{"hello","world","!"};
		List<String>list=Arrays.asList(strArray);
		//Stream stream=list.stream();
		List<String>output=list.stream().map(String::toUpperCase).collect(Collectors.toList());
		for(String s:output){
			System.out.println(s);
		}
		IntStream.range(1, 3).forEach(System.out::println);
		IntStream.rangeClosed(1, 3).forEach(System.out::println);
		//
		System.out.println();
		Stream.iterate(0, n->n+3).limit(10).forEach(x->System.out.print(x+" "));
		//odd & even
		System.out.println();
		Integer[]sixNums={1,2,3,4,5,6};
		Integer[]evens=Stream.of(sixNums).filter(n->n%2==0).toArray(Integer[]::new);
		Stream.of(evens).forEach(System.out::print);
		
		Integer[] num={1,2,3,4,5,6,7,8,9,10};
		long number=Stream.of(num).count();
		System.out.println("Count of number:"+number);
		//一锟皆讹拷
		System.out.println();
		Stream<List<Integer>>inputStream=Stream.of(Arrays.asList(1),
				Arrays.asList(2,3),
				Arrays.asList(4,5,6));
		
		Stream<Integer>outputStream=inputStream.flatMap((childList)->childList.stream());
		outputStream.forEach(x->System.out.print(x+" "));
		
		//parallel
		System.out.println();
		List<Birds>bird=new ArrayList<Birds>();
		Birds b1=new Birds(1,"red bird");
		b1.setColor(COLOR.RED);
		Birds b2=new Birds(2,"blue bird");
		b2.setColor(COLOR.BLUE);
		Birds b3=new Birds(3,"black bird");
		b3.setColor(COLOR.BLACK);
		Birds b4=new Birds(4,"red bird");
		b4.setColor(COLOR.RED);
		Birds b5=new Birds(5,"red bird");
		b5.setColor(COLOR.RED);
		bird.add(b1);
		bird.add(b2);
		bird.add(b3);
		bird.add(b4);
		bird.add(b5);
		for(int i=10;i<1000;i++){
			Birds b=new Birds(1,i+" bird");
			b.setColor(COLOR.RED);
			bird.add(b);
		}
		long beginTime=System.currentTimeMillis();
		int sumOfWeights = bird.parallelStream()
                .filter(b -> b.getColor() == COLOR.RED)
                .mapToInt(b -> b.getWeight())
                .sum();
		System.out.println(System.currentTimeMillis()-beginTime);
		System.out.println("sumOfWeights:"+sumOfWeights);
		long comStartTime=System.currentTimeMillis();
		int sum=0;
		for(Birds b:bird){
			if(b.getColor()==COLOR.RED){
				sum+=b.getWeight();
			}
		}
		System.out.println(System.currentTimeMillis()-comStartTime+" "+sum);
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);  //Integer.valueOf锟斤拷锟斤拷锟铰的讹拷锟斤拷
		Integer i04 = new Integer(59);
			
		System.out.println(i01 == i02);  //true
		System.out.println(i01 == i03);  //true
		System.out.println(i03 == i04);  //false
		System.out.println(i02 == i04);  //true
		
		Integer i05=130;
		Integer i06=Integer.valueOf(130);
		int i07=130;
		System.out.println(i07 == i05);  //true
		System.out.println(i05 == i06);  //false
		System.out.println(i05 == Integer.parseInt("130")); //true
		System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));  //true -128-127内存缓存
		System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));  //false两个对象比较
		System.out.println(Integer.parseInt("128") == Integer.valueOf("128")); //true parseInt()返回一个整型值 ，valueOf的对象会自动拆箱为整形值 
	}

}
