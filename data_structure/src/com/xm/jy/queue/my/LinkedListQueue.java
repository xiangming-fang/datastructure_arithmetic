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
public class LinkedListQueue<E> {
    
    private LinkedList<E> list;

    public LinkedListQueue(){
        list = new LinkedList<>();
    }

    // 入队
    public void offer(E e){
        list.addLast(e);
    }

    // 出队
    public E poll(){
        return list.removeFirst();
    }

    // 替换队首元素
    public void replace(E e){
        list.setFirst(e);
    }

    // 偷偷看一眼队首元素
    public E peek(){
        return list.getFirst();
    }
}
