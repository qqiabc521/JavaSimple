package com.ljj.javasimple.rxjava;


import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.BehaviorSubject;

/**
 * 释放订阅前最后一个数据和订阅后接收到的所有数据
 *
 * 原理就是通过subscribers这个核心的成员，它是一个不断变化的数组。在创建时，其内部只是一个EMPTY（BehaviorDisposable）对象，
 * 每次被订阅，都会在既有的数组上新加一个BehaviorDisposable对象，这个对象中包含了一个List，存储之后会收到的数据。
 *
 * 同时，BehaviorSubject还有一个value的成员，该成员会随着数据的不断接收而进行更新，它总是记录着当前最后一个接收到的数据，
 * 当被subscribe时，会执行emitFirst()方法，发射当前记录的数据，也就是订阅前接收到的最后一个数据。
 */
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
