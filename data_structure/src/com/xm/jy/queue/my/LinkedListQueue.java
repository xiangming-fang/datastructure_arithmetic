package com.xm.jy.queue.my;

import com.xm.jy.linkedlist.my.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.queue.my
 * @ClassName: LinkedListQueue
 * @Author: albert.fang
 * @Description: 链表实现队列
 * @Date: 2021/8/1 13:51
 */
public class LinkedListQueue<E> implements Queue<E>{
    
    private LinkedList<E> list;

    public LinkedListQueue(){
        list = new LinkedList<>();
    }

    // 入队
    @Override
    public void offer(E e){
        list.addLast(e);
    }

    // 出队
    @Override
    public E poll(){
        return list.removeFirst();
    }

    // 替换队首元素
    @Override
    public E replace(E e){
        return list.setFirst(e);
    }

    // 偷偷看一眼队首元素
    @Override
    public E peek(){
        return list.getFirst();
    }
}
