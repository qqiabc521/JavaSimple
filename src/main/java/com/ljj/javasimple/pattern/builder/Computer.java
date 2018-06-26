package com.ljj.javasimple.pattern.builder;

public class Computer {
	private String cpu;
	private String mainboard;
	private String ram;
	
	public void setCpu(String cpu){
		this.cpu = cpu;
	}
	
	public void setMainboard(String mainboard){
		this.mainboard = mainboard;
	}
	
	public void setRam(String ram){
		this.ram = ram;
	}
	
	@Override
	public String toString() {
		return "cpu："+cpu+" mainboard:"+mainboard+" ram:"+ram;
	}
}
