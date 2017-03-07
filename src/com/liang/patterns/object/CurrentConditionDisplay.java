package com.liang.patterns.object;

public class CurrentConditionDisplay implements Display, Observer {
	private float temp;
	private float humidity;
	private float pressure;
	private Subject weather;
	public CurrentConditionDisplay(Subject wd){
		this.weather=wd;
		weather.addObject(this);
	}
	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temp=temp;
		this.humidity=humidity;
		this.pressure=pressure;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Temp:"+temp+" Humidity:"+humidity+" Pressure:"+pressure);
	}

}
