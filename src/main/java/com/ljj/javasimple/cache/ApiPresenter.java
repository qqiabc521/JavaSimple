package com.ljj.javasimple.cache;

public class ApiPresenter {
    private BaseView baseView;

    public ApiPresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    public void doApi(String id) {
        ApiModel apiModel = CacheProxyUtil.getCacheProxy(new ApiModelImpl());
        baseView.onResult(apiModel.getResult(id));
    }
}
