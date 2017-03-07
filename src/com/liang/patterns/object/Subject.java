package com.liang.patterns.object;

public interface Subject {
	public void removeObject(Object o);
	public void addObject(Object o);
	public void notifyObserver();
}
