package com.ljj.javasimple.pattern.factory;

public class FactoryTest {

    public static void main(String[] args) {
        GDComputerFactory factory = new GDComputerFactory();
        Computer lenovoComputer = factory.createComputer(LenovoComputer.class);
        Computer hpComputer = factory.createComputer(HpComputer.class);

        lenovoComputer.initStart();
        hpComputer.initStart();
    }

}
