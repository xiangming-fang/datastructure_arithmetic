package com.xm.jy.queue.Queues;

/**
 * @author: albert.fang
 * @date: 2020/10/23 13:48
 * @description: 测试队列
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 普通队列
        /*ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("入队操作：");
        for (int i = 0; i < 6; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue.toString() + ",队列大小：" + arrayQueue.getSize());
        }
        System.out.println("出队操作：");
        for (int i = 0; i < 5; i++) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue.toString() + ",队列大小：" + arrayQueue.getSize());
        }*/

        // 循环队列
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
