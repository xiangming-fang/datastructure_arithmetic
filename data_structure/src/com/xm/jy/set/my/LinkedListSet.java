package com.xm.jy.set.my;

import com.xm.jy.set.my.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.set.my
 * @ClassName: LinkedListSet
 * @Author: albert.fang
 * @Description: 基于链表实现集合
 * @Date: 2021/8/5 13:50
 */
public class LinkedListSet<E extends Comparable<E>> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    public void add(E e){
        list.addFirst(e);
    }

    public void remove(E e){
        list.remove(e);
    }

    public void setLast(E e){
        list.setFirst(e);
    }

    public E getLast(){
        return list.getFirst();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public int getSize(){
        return list.getSize();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
