package com.liang.patterns.object;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData=new WeatherData();
		CurrentConditionDisplay currentDispaly=new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(80,65,30.4f);
	}

}
