package com.ljj.javasimple.pattern.builder;

public class ComputerBuilder extends Builder {
	
	private Computer computer = new Computer();

	@Override
	public void setCpu(String cpu) {
		computer.setCpu(cpu);
	}

	@Override
	public void setMainboard(String mainboard) {
		computer.setMainboard(mainboard);
	}

	@Override
	public void setRam(String ram) {
		computer.setRam(ram);
	}

	@Override
	public Computer create() {
		return computer;
	}
	
	

}
