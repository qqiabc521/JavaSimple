package com.ljj.javasimple.proxycache;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private Map<String, Object> caches = new HashMap<>();


    public Object getCache(String key) {
        return caches.get(key);
    }

    public boolean putCache(String key, Object value) {
        caches.put(key, value);
        return true;
    }
}
