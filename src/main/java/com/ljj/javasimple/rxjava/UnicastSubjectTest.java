package com.ljj.javasimple.rxjava;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.UnicastSubject;

/**
 * 仅支持订阅一次的Subject,如果多个订阅者试图订阅这个Subject，
 * 若该subject未terminate，将会受到IllegalStateException ，
 * 若已经terminate，那么只会执行onError或者onComplete方法。
 */
public class UnicastSubjectTest {

    public static void main(String[] args){
        UnicastSubject<String> subject = UnicastSubject.create();
        subject.subscribe(new CommObserver("observer1"));
        subject.onNext("1");
        subject.onNext("2");

        subject.subscribe(new CommObserver("observer2"));
        subject.onNext("3");
        subject.onNext("4");
        subject.onComplete();

        subject.subscribe(new CommObserver("observer3"));
    }
}
