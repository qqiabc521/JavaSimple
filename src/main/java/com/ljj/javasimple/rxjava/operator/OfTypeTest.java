package com.ljj.javasimple.rxjava.operator;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.PublishSubject;

public class OfTypeTest {

    public static void main(String[] args) {
        PublishSubject<Object> subject = PublishSubject.create();
        subject.ofType(String.class).subscribe(new CommObserver("observer1"));
        subject.onNext("1");
        subject.onNext("2");
        subject.ofType(Integer.class);

        subject.ofType(Integer.class).subscribe(new CommObserver("observer2"));
        subject.onNext(3);
        subject.onNext("4");
    }
}
