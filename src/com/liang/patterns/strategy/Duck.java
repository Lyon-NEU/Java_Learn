package com.liang.patterns.strategy;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public Duck(){
		
	}
	public void swim(){
		System.out.println("All duck swims!");
	}
	public abstract void display();
	public void performFly(){
		flyBehavior.fiy();
	}
	public void performQuack(){
		quackBehavior.quack();
	}
	
}
