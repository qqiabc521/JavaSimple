package com.ljj.javasimple.proxycache;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class ApiModelImpl implements ApiModel {

    private Random random;

    public ApiModelImpl() {
        random = new Random();
    }

    @Override
    public void getResult(String id, ApiCallback<String> callback) {
        Observable.just(id).map(s -> "result " + random.nextInt(1000)).subscribeOn(Schedulers.single())
        .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                if(callback != null){
                    callback.onStart();
                }
            }

            @Override
            public void onNext(String value) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(callback != null){
                    callback.onResult(value);
                }
            }

            @Override
            public void onError(Throwable e) {
                if(callback != null){
                    callback.onError(e.getMessage());
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public Observable<String> getResult(String id) {
        return Observable.just(id).map(s -> "result " + random.nextInt(1000)).subscribeOn(Schedulers.single());
    }


}
