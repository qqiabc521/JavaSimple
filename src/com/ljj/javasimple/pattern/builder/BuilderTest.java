package com.ljj.javasimple.pattern.builder;

public class BuilderTest {

	public static void main(String[] args) {
		Builder builder = new ComputerBuilder();
		Director dirctor = new Director(builder);
		System.out.println(dirctor.createComputer("cpu", "mainboard", "ram"));
	}

}
