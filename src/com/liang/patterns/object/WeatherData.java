package com.liang.patterns.object;

import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temp;
	private float humidity;
	private float pressure;
	public  WeatherData(){
		observers=new ArrayList<Observer>();
	}
	@Override
	public void removeObject(Object o) {
		// TODO Auto-generated method stub
		int index=observers.indexOf(o);
		if(index!=-1){
			observers.remove(index);
		}
	}
	
	@Override
	public void addObject(Object o) {
		// TODO Auto-generated method stub
		observers.add((Observer) o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer ob:observers){
			ob.update(temp, humidity, pressure);
		}
	}
	public void measurementChanged(){
		notifyObserver();
	}
	public void setMeasurements(float temp,float humidity,float pressure){
		this.humidity=humidity;
		this.temp=temp;
		this.pressure=pressure;
		notifyObserver();
	}
}
