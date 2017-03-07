package com.liang.string;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringDemo {
	public static void main(String[]args){
		String test="acount=? and uu =? or n=?";
		String[]tmp=test.split("and|or");
		Stream.of(tmp).forEach(x->System.out.println(x.length()));
		
		char[] foo, bar; 
		foo = new char[] {'a','b','c'}; 
		bar = new char[] {'a','b','c'}; 
		System.out.println(foo.hashCode() == bar.hashCode() ? "equal" : "not equal"); //false 
		System.out.println(foo.equals(bar) ? "equal" : "not equal"); //false
		System.out.println(Arrays.equals(foo, bar));  //true
		
		System.out.println("CPU:"+Runtime.getRuntime().availableProcessors());
	}
}
