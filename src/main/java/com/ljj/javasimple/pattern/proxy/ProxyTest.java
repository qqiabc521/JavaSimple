package com.ljj.javasimple.pattern.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Shoper shoper = new RealShoper();
        Shoper proxyShoper = new ProxyShoper(shoper);
        proxyShoper.buy();
    }

}
