package com.ljj.javasimple.rxjava.comm;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CommObserver implements Observer {
    private String name;

    public CommObserver(String name) {
        this.name = name;
    }

    public void onSubscribe(Disposable disposable) {
        System.out.println(name + " onSubscribe");
    }

    public void onNext(Object o) {
        System.out.println(name + " onNext: " + o.toString());
    }

    public void onError(Throwable throwable) {
        System.out.println(name + " onError: " + throwable.getMessage());
    }

    public void onComplete() {
        System.out.println(name + " onComplete");
    }
}
