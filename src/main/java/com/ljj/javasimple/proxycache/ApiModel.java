package com.ljj.javasimple.proxycache;

import io.reactivex.Observable;

public interface ApiModel {

    void getResult(String id ,ApiCallback<String> callback);

    Observable<String> getResult(String id);
}
