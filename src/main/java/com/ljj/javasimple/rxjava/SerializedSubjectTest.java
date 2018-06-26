package com.ljj.javasimple.rxjava;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * 将Subject串行化的方法，所有其他的Observable和Subject方法都是线程安全的。
 *
 * 通过Subject.toSerialized()方法将Subject对象串行化保证其线程安全
 *
 * 使用RxBus，会额外增加更多的支出（因为RxBus中PublisSuject本身的单例对象就是调用了toSerialized()方法保证线程安全
 */
public class SerializedSubjectTest {

    public static void main(String[] args){
        Subject<Object> subject = PublishSubject.create().toSerialized();
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
