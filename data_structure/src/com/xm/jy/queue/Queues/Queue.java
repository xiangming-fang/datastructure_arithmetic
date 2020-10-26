package com.xm.jy.queue.Queues;

/**
 * @author: albert.fang
 * @date: 2020/10/23 13:39
 * @description: 队列接口
 */
public interface Queue<E> {

    void enqueue(E e) throws Exception;
    E dequeue() throws Exception;
    E getfront() throws Exception;
    int getSize();
    boolean isEmpty();
}
