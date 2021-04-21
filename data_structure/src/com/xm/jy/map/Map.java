package com.xm.jy.map;

/**
 * @author: albert.fang
 * @date: 2021/4/21 12:04
 * @description: 映射接口
 */
public interface Map<K,V> {
    // 增
    void add(K key,V value);
    // 删
    V remove(K key);
    // 改
    void set(K key,V value);
    // 查
    V get(K key);

    boolean contains(K key);
    boolean isEmpty();
    int getSize();
}
