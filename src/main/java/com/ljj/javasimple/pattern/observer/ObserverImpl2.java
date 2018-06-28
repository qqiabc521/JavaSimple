package com.ljj.javasimple.pattern.observer;

public class ObserverImpl2 implements Observer {

    @Override
    public void onChanged(String message) {
        System.out.println("ObserverImpl2 onChanged :" + message);
    }

}
