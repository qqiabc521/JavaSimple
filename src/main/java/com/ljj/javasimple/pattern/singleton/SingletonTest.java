package com.ljj.javasimple.pattern.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(DoubleCheckSingleton.getInstance().toString());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(StaticInnerSingleton.getInstance().toString());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(EnumSingleton.INSTANCE.hashCode());
        }
    }

}
