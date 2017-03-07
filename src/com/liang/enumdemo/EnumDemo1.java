package com.liang.enumdemo;

enum Shrubbery{GROUND,CRAWLING,HANGING}
public class EnumDemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Shrubbery s:Shrubbery.values()){
			System.out.println(s+" ordinal:"+s.ordinal());
			System.out.println(s.compareTo(Shrubbery.CRAWLING));
			System.out.println(s.equals(Shrubbery.CRAWLING));
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("-----------------");
		}
		for(String s:"HANGING CRAWLING GROUND".split(" ")){
			Shrubbery shrub=Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
		}
	}

}
