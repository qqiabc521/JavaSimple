package com.ljj.javasimple.pattern.proxy;

public class RealShoper implements Shoper{

	@Override
	public void buy() {
		System.out.println("RealShoper buy");
	}

}
