package com.ljj.javasimple.rxjava;

import com.ljj.javasimple.rxjava.comm.CommObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableBaseTest {

    public static void main(String[] args){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onNext("2");
                e.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                System.out.println("onNext "+value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError "+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
