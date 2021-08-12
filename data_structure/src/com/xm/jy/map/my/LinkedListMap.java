package com.xm.jy.map.my;

import com.xm.jy.map.Map;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.map.my
 * @ClassName: LinkedListMap
 * @Author: albert.fang
 * @Description: 链表实现映射
 * @Date: 2021/8/5 14:53
 */
public class LinkedListMap<K extends Comparable<K>,V> implements Map<K,V> {

    private LinkedList<K,V> list;

    public LinkedListMap(){
        list = new LinkedList<>();
    }

    @Override
    public void add(K key,V value){
        list.add(key,value);
    }

    @Override
    public V remove(K key){
        return list.remove(key);
    }

    @Override
    public void set(K key,V value){
        list.set(key,value);
    }

    @Override
    public V get(K key){
        return list.get(key);
    }

    @Override
    public boolean contains(K key) {
        return list.contains(key);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    public boolean containsKey(K key){
        return list.contains(key);
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
