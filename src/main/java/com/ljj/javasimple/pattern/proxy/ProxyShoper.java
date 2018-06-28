package com.ljj.javasimple.pattern.proxy;

public class ProxyShoper implements Shoper {

    private Shoper shoper;

    public ProxyShoper(Shoper shoper) {
        this.shoper = shoper;
    }

    @Override
    public void buy() {
        shoper.buy();
    }

}
