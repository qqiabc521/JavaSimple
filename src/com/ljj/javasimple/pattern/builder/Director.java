package com.ljj.javasimple.pattern.builder;

public class Director {
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public Computer createComputer(String cpu,String mainboard,String ram){
		builder.setCpu(cpu);
		builder.setMainboard(mainboard);
		builder.setRam(ram);
		return builder.create();
	}
}
