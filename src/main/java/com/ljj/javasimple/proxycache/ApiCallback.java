package com.ljj.javasimple.proxycache;

public interface ApiCallback<T> {

    void onStart();

    void onResult(T t);

    void onError(String msg);
}
