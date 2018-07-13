package com.ljj.javasimple.proxycache;

public interface BaseView<T> {

    void dostart();

    void doResult(T t);

    void doError(String msg);
}
