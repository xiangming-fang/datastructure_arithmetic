package com.xm.jy.map.my;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.map.my
 * @ClassName: LinkedListMap
 * @Author: albert.fang
 * @Description: 链表实现映射
 * @Date: 2021/8/5 14:53
 */
public class LinkedListMap<K extends Comparable<K>,V> {

    private LinkedList<K,V> list;

    public LinkedListMap(){
        list = new LinkedList<>();
    }

    public void put(K key,V value){
        list.add(key,value);
    }

    public void remove(K key){
        list.remove(key);
    }

    public void set(K key,V value){
        list.set(key,value);
    }

    public V get(K key){
        return list.get(key);
    }

    public boolean containsKey(K key){
        return list.contains(key);
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
