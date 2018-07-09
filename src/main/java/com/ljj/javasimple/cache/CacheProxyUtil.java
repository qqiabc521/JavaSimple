package com.ljj.javasimple.cache;

import java.lang.reflect.*;

public class CacheProxyUtil {

    private static CacheManager cacheManager = new CacheManager();

    public static <T> T getCacheProxy(T t) {
        Class[] interfaces = t.getClass().getInterfaces();
        if (interfaces == null || interfaces.length == 0) {
            throw new RuntimeException("该类没有实现对应的接口");
        }
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), new Class[]{interfaces[0]}, new CacheInvocationHandler(t));
    }

    private static class CacheInvocationHandler implements InvocationHandler {
        private Object target;

        public CacheInvocationHandler(Object obj) {
            target = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String cacheKey = getKey(args);
            Object cacheValue = cacheManager.getCache(cacheKey);
            if (cacheValue != null) {
                return cacheValue;
            }
            Object result = method.invoke(target, args);
            cacheManager.putCache(cacheKey, result);
            return result;
        }
    }

    private static String getKey(Object[] params) {
        if (params == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : params) {
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
