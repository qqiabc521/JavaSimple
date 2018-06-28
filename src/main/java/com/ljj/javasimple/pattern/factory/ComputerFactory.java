package com.ljj.javasimple.pattern.factory;

public abstract class ComputerFactory {
    public abstract <T extends Computer> T createComputer(Class clazz);
}
