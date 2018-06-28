package com.ljj.javasimple.pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.ljj.javasimple.pattern.proxy.RealShoper;
import com.ljj.javasimple.pattern.proxy.Shoper;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Shoper shoper = new RealShoper();
        DynamicShoper dynamicShoper = new DynamicShoper(shoper);
        Shoper proxyShoper = (Shoper) Proxy.newProxyInstance(shoper.getClass().getClassLoader(), new Class[]{Shoper.class}, dynamicShoper);
        proxyShoper.buy();
    }

}
