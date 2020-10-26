package com.xm.jy.queue.Queues;

/**
 * @author: albert.fang
 * @date: 2020/10/23 14:28
 * @description: 循环队列：为什么要有循环队列这种数据结构？
 *              因为普通队列的出队时间复杂度为O(n)，太高了。通过循环队列这种数据结构，将队列的出队时间复杂度降为O(1)。
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] array;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        // 这里的初始容量为传入值+1，是因为，我们以（tail + 1）% array.length + 1 == front 为队列已满的条件，要空出一个位置做标示
        array = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private boolean isFull(){
        return (tail + 1)%array.length == front;
    }

    @Override
    public void enqueue(E e) throws Exception {
        if (isFull()){
//            throw new IllegalArgumentException("队列已满，不能入队");
            // 扩容
            resize(array.length * 2 - 1);
        }
        array[tail] = e;
        size ++;
        tail = (tail + 1)%array.length;
    }

    @Override
    public E dequeue() throws Exception {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空，不能出队");
        }
        E e = array[front];
        front = (front + 1)%array.length;
        size --;
        if (size < array.length/4 && array.length/2 != 0){
            resize(array.length/2);
        }
        return e;
    }

    @Override
    public E getfront() throws Exception {
        return array[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return array.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue：head [");
        for (int i = 0; i < size; i++) {
            sb.append(array[(front+i)%array.length]);
            if (i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    private void resize(int newCapacity){
        E[] newArray =(E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front+i)%array.length];
        }
        array = newArray;
        // 之前漏了这两步，扩容缩容之后，得把front和tail变量重新指向
        front = 0;
        tail = size;
    }

    public static void main(String[] args) throws Exception {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        // 入队操作，直接入满
        System.out.println("入队操作，入满");
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue.toString()+" 当前队列大小" + loopQueue.getSize() + " 初始容量：" + loopQueue.getCapacity());
        }

        System.out.println("出队操作");
        for (int i = 0; i < 20; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue.toString()+" 当前队列大小" + loopQueue.getSize() + " 初始容量：" + loopQueue.getCapacity());
        }
    }
}
