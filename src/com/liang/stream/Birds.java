package com.liang.stream;

enum COLOR{RED,BLUE,BLACK};
public class Birds {
	
	private COLOR color;
	private int weight;
	private String name;
	
	public Birds(int weight,String name){
		this.weight=weight;
		this.name=name;
	}
	public void setWeight(int weight){
		this.weight=weight;
	}
	public int getWeight(){
		return weight;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setColor(COLOR color){
		this.color=color;
	}
	public COLOR getColor(){
		return color;
	}
}
