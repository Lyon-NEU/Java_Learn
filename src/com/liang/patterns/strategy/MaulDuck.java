package com.liang.patterns.strategy;

public class MaulDuck extends Duck {
	public MaulDuck(){
		this.flyBehavior=new FlyWithWings();
		this.quackBehavior=new QuackMute();
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I'm a Maul Duck!");
	}
	public static void main(String[]args){
		MaulDuck d=new MaulDuck();
		d.performFly();
		d.performQuack();
		d.display();
		d.swim();
	}

}
