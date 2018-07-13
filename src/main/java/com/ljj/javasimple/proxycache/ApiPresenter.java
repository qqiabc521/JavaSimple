package com.ljj.javasimple.proxycache;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ApiPresenter {
    private BaseView baseView;

    public ApiPresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    public void doApi(String id) {
        ApiModel apiModel = CacheProxyUtil.getCacheProxy(new ApiModelImpl());
//        ApiModel apiModel = new ApiModelImpl();
//        System.out.println("参数回调====================================");
//        apiModel.getResult(id, new ApiCallback<String>() {
//            @Override
//            public void onStart() {
//                if(baseView != null){
//                    baseView.dostart();
//                }
//            }
//
//            @Override
//            public void onResult(String s) {
//                if(baseView != null){
//                    baseView.doResult(s);
//                }
//            }
//
//            @Override
//            public void onError(String msg) {
//                if(baseView != null){
//                    baseView.doError(msg);
//                }
//            }
//        });
//
//        System.out.println("Observable 返回====================================");
        apiModel.getResult(id).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                if(baseView != null){
                    baseView.dostart();
                }
            }

            @Override
            public void onNext(String value) {
                if(baseView != null){
                    baseView.doResult(value);
                }
            }

            @Override
            public void onError(Throwable e) {
                if(baseView != null){
                    baseView.doError(e.getMessage());
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
