package com.ljj.javasimple.pattern.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	private String message;
	
	public String doSomething(){
		return message;
	}

}
