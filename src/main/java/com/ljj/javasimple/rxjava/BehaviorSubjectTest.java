package com.ljj.javasimple.rxjava;


import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectTest {

    public static void main(String[] args){
        BehaviorSubject<String> subject = BehaviorSubject.create();
        subject.subscribe(new CommObserver("Observer1"));
        subject.onNext("0");
        subject.onNext("1");
        subject.onNext("2");
        subject.onNext("3");

        System.out.println("========================================");
        BehaviorSubject<String> subject2 = BehaviorSubject.create();
        subject2.onNext("0");
        subject2.onNext("1");
        subject2.subscribe(new CommObserver("Observer2"));
        subject2.onNext("2");
        subject2.onNext("3");

        System.out.println("========================================");
        BehaviorSubject<String> subject3 = BehaviorSubject.create();
        subject3.onNext("0");
        subject3.onNext("1");
        subject3.onComplete();
        subject3.subscribe(new CommObserver("Observer3"));
        subject3.onNext("2");
        subject3.onNext("3");

        System.out.println("========================================");
        BehaviorSubject<String> subject4 = BehaviorSubject.create();
        subject4.onNext("0");
        subject4.onNext("1");
        subject4.onError(new RuntimeException("error"));
        subject4.subscribe(new CommObserver("Observer4"));
        subject4.onNext("2");
        subject4.onNext("3");
    }

}
