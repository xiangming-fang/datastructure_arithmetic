package com.xm.jy.queue.Queues;

import com.xm.jy.array.Arrays.dilatation.Array3;

/**
 * @author: albert.fang
 * @date: 2020/10/23 13:39
 * @description: 数组队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array3<E> array;

    public ArrayQueue(int capacity){
        array = new Array3<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) throws Exception {
        array.addLast(e);
    }

    @Override
    public E dequeue() throws Exception {
        return array.removeFirst();
    }

    @Override
    public E getfront() throws Exception {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue:head [");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                sb.append(array.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("入队操作：");
        for (int i = 0; i < 6; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue.toString() + ",队列大小：" + arrayQueue.getSize());
        }
        System.out.println("出队操作：");
        for (int i = 0; i < 5; i++) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue.toString() + ",队列大小：" + arrayQueue.getSize());
        }
    }
}
