package com.liang.annotation;
import java.lang.reflect.*;
import java.util.*;
public class AnnotationDemo {
	public static void trackUseCases(List<Integer>useCase,Class<?>cl){
		for(Method m:cl.getDeclaredMethods()){
			UseCase uc=m.getAnnotation(UseCase.class);
			if(uc!=null){
				System.out.println("Found Use Case:"+uc.id()+" "+uc.description());;
				useCase.remove(new Integer(uc.id()));
			}
		}
		for(int i:useCase){
			System.out.println("Warning£º Missing use case-"+i);
		}
	}
	public static void main(String[]args){
		List<Integer>useCases=new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50);
		trackUseCases(useCases,PasswordUtils.class);
		
		//print all system environment variable
		for(Map.Entry<String, String>entry: System.getenv().entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue()
			);
		}
		
		System.out.println(System.getProperty("user.home"));
	}
}
