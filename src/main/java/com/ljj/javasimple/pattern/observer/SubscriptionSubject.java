package com.ljj.javasimple.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        synchronized (observers) {
            for (Observer observer : observers) {
                observer.onChanged(message);
            }
        }
    }

}
