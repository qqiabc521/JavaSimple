package com.ljj.javasimple.pattern.observer;

public class ObserverTest {

    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new ObserverImpl1());
        subject.attach(new ObserverImpl2());
        subject.attach(new ObserverImpl3());

        subject.notify("notify");
    }

}
