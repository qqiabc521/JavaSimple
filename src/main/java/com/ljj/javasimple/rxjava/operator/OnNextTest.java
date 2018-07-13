package com.ljj.javasimple.rxjava.operator;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class OnNextTest {

    public static void main(String[] args){
        Observable mapObservable = Observable.just("123").map(new Function<String, Integer>() {

            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        });

        System.out.println("mapObservable:"+mapObservable);

        mapObservable.subscribeOn(Schedulers.single());

        Observable doEachObservable = mapObservable.doOnNext(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println(o);
            }
        });

        System.out.println("doEachObservable:"+doEachObservable);

        doEachObservable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
               System.out.println("onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
