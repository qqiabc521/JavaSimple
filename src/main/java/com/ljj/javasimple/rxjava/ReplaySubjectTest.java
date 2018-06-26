package com.ljj.javasimple.rxjava;


import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.ReplaySubject;

/**
 * ReplaySubject
 * 该Subject会接收数据，当被订阅时，将所有接收到的数据全部发送给订阅者。
 *
 *
 * 原理：通过一个List动态存储所有接收到的数据，当被订阅时，将所有的数据都发送给订阅者。
 * 其根本就是一个动态的链表，甚至其创建时的基础容量也是16，并且随着数据的不断增加，每次递增50%，如果想要节省开支，也可以自己定义初始容量和递增规则。
 */
public class ReplaySubjectTest {

    public static void main(String[] args){
        ReplaySubject<String> subject = ReplaySubject.create(3);
        subject.onNext("1");
        subject.onNext("2");
        subject.onNext("3");
        subject.onComplete();


        subject.subscribe(new CommObserver("Observer1"));
        subject.subscribe(new CommObserver("Observer2"));

    }


}
