package com.ljj.javasimple.rxcallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class RxCallback<T> {

    private static HashMap<Class, RxCallback> map = new HashMap<>();

    private final WeakReference<T> target;
    private final Subject<T> subject;

    public static <T> RxCallback create(T t) {
        return new RxCallback(t);
    }

    private RxCallback(T t) {
        target = new WeakReference<>(t);
        subject = PublishSubject.create();
    }

    public Observable<T> ofType(Class type) {
        if (type == null) {
            throw new RuntimeException("type is not null");
        }
        map.put(type, this);
        return subject.ofType(type);
    }

    public Disposable subscribe(Class type, Consumer<T> consumer) {
        return subject.subscribe(consumer, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                map.remove(type);
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                map.remove(type);
            }
        });
    }

    public static boolean post(Class type) {
        if (!map.containsKey(type)) {
            return false;
        }
        RxCallback rxCallback = map.get(type);
        if (rxCallback != null) {
            Object object = rxCallback.target.get();
            if (object != null) {
                rxCallback.subject.onNext(object);
                return true;
            }
        }
        return false;
    }

    private class ObservableCallback extends Observable<T> {

        @Override
        protected void subscribeActual(Observer<? super T> observer) {

        }
    }
}
