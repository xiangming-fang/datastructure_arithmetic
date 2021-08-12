package com.xm.jy.set.my;

import com.xm.jy.set.Set;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.set.my
 * @ClassName: LinkedListSet
 * @Author: albert.fang
 * @Description: 基于链表实现集合
 * @Date: 2021/8/5 13:50
 */
public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e){
        list.addFirst(e);
    }

    @Override
    public void remove(E e){
        list.remove(e);
    }

    @Override
    public boolean contains(E e){
        return list.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
