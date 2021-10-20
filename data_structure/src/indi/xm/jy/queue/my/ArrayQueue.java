package indi.xm.jy.queue.my;

import indi.xm.jy.array.my.Array;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.queue
 * @ClassName: ArrayQueue
 * @Author: albert.fang
 * @Description: 队列
 * @Date: 2021/7/30 18:48
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(){
        array = new Array<>();
    }

    // 入队
    @Override
    public void offer(E e){
        array.addLast(e);
    }

    // 出队
    @Override
    public E poll(){
        return array.removeFirst();
    }

    // 替换队首元素
    @Override
    public E replace(E e){
        return array.setFirst(e);
    }

    // 偷偷看一眼队首元素
    @Override
    public E peek(){
        return array.getFirst();
    }
}
