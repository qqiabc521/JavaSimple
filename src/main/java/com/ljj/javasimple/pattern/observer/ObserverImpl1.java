package com.ljj.javasimple.pattern.observer;

public class ObserverImpl1 implements Observer {

    @Override
    public void onChanged(String message) {
        System.out.println("ObserverImpl1 onChanged :" + message);
    }

}
