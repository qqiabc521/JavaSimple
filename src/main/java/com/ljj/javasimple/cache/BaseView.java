package com.ljj.javasimple.cache;

public interface BaseView<T> {

    void start();

    void onResult(T t);

    void onError(String msg);
}
