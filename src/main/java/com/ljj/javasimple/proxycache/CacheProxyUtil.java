package com.ljj.javasimple.proxycache;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

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
                if (args != null && args.length > 0) {
                    int lastArgsIndex = args.length - 1;
                    if (args[lastArgsIndex] instanceof ApiCallback) {
                        return exeCacheObservable(cacheValue, (ApiCallback) args[lastArgsIndex]);
                    }
                }
                return Observable.just(cacheValue);
            }
            if (args != null && args.length > 0) {
                int lastArgsIndex = args.length - 1;
                if (args[lastArgsIndex] instanceof ApiCallback) {
                    args[lastArgsIndex] = new ApiCallbackDelegate(cacheKey, (ApiCallback) args[lastArgsIndex]);
                    return method.invoke(target, args);
                }
            }
            Object result = method.invoke(target, args);
            if (result != null) {
                if (result instanceof Observable) {
                    Observable observable = (Observable) result;
                    return observable.doOnNext(o -> cacheManager.putCache(cacheKey, o));
                }
            }
            return result;
        }

        private Disposable exeCacheObservable(Object result, ApiCallback apiCallback) {
            return Observable.create(e -> e.onNext(result)).subscribe(o -> {
                if (apiCallback != null) {
                    apiCallback.onResult(o);
                }
            });
        }
    }

    private static class ApiCallbackDelegate<T> implements ApiCallback<T> {
        private ApiCallback apiCallback;
        private String cacheKey;

        private ApiCallbackDelegate(String cacheKey, ApiCallback apiCallback) {
            this.cacheKey = cacheKey;
            this.apiCallback = apiCallback;
        }

        @Override
        public void onStart() {
            if (apiCallback != null) {
                apiCallback.onStart();
            }
        }

        @Override
        public void onResult(T t) {
            cacheManager.putCache(cacheKey, t);
            if (apiCallback != null) {
                apiCallback.onResult(t);
            }
        }

        @Override
        public void onError(String msg) {
            if (apiCallback != null) {
                apiCallback.onError(msg);
            }
        }
    }

    private static String getKey(Object[] params) {
        if (params == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : params) {
            if (obj instanceof ApiCallback) {
                continue;
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
