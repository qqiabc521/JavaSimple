package com.ljj.javasimple.rxjava;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.AsyncSubject;

/**
 * AsyncSubject仅释放Observable最后一个数据，
 * 并且仅在Observable完成之后。
 *
 * 然而如果当Observable因为异常而终止，AsyncSubject将不会释放任何数据，但是会向Observer传递一个异常通知。
 */
public class AsyncSubjectTest {

    public static void main(String[] args){
        AsyncSubject<String> subject = AsyncSubject.create();
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
