package com.alticci.utils.impl;

import com.alticci.utils.AlticciCache;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AlticciCacheImpl implements AlticciCache {

    private static final HashMap<Long, Long> CACHE = new HashMap<>();

    public Long get(Long key) {
        return CACHE.get(key);
    }

    public void put(Long key, Long value) {
        CACHE.put(key, value);
    }

    public Boolean containsValue(Long value) {
        return CACHE.containsValue(value);
    }

    public Boolean containsKey(Long key) {
        return CACHE.containsKey(key);
    }

}
