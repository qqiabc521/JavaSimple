package com.ljj.javasimple.pattern.observer;

public class ObserverImpl3 implements Observer {

	@Override
	public void onChanged(String message) {
		System.out.println("ObserverImpl3 onChanged :"+message);
	}

}
