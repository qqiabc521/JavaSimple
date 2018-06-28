package com.ljj.javasimple.pattern.factory;

public class GDComputerFactory extends ComputerFactory {

    @Override
    public <T extends Computer> T createComputer(Class clazz) {
        Computer computer = null;
        try {
            computer = (Computer) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) computer;
    }

}
