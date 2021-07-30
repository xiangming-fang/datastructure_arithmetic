package com.xm.jy.queue;

import com.xm.jy.array.Array;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.queue
 * @ClassName: Queue
 * @Author: albert.fang
 * @Description: 队列
 * @Date: 2021/7/30 18:48
 */
public class Queue<E> {

    private Array<E> array;

    public Queue(){
        array = new Array<>();
    }

    // 入队
    public void offer(E e){
        array.addLast(e);
    }

    // 出队
    public E poll(){
        return array.removeFirst();
    }

    // 替换队首元素
    public E replace(E e){
        return array.setFirst(e);
    }

    // 偷偷看一眼队首元素
    public E peek(){
        return array.getFirst();
    }
}
