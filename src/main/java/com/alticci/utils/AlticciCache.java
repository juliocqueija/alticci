package com.alticci.utils;

public interface AlticciCache {

    Long get(Long key);

    void put(Long key, Long value);

    Boolean containsValue(Long value);

    Boolean containsKey(Long key);

}
