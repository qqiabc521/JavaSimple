package com.ljj.javasimple.rxjava;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.PublishSubject;

/**
 * PublishSubject仅会向Observer释放在订阅之后Observable释放的数据
 *
 * 原理就是通过subscribers这个核心的成员，它是一个不断变化的数组。
 * 在创建时，其内部只是一个EMPTY（PublishDisposable）对象，
 * 每次被订阅，都会在既有的数组上新加一个PublishDisposable对象，这个对象中包含了一个List，存储之后会收到的数据。
 */
public class PublishSubjectTest {


    public static void main(String[] args){
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(new CommObserver("observer1"));
        subject.onNext("1");
        subject.onNext("2");

        subject.subscribe(new CommObserver("observer2"));
        subject.onNext("3");
        subject.onNext("4");


    }
}
