package com.xm.jy.stack.Stacks;

import com.xm.jy.queue.Queues.ArrayQueue;
import com.xm.jy.queue.Queues.LinkedListQueue;
import com.xm.jy.queue.Queues.LoopQueue;
import com.xm.jy.queue.Queues.Queue;

import java.util.Random;

/**
 * @author: albert.fang
 * @date: 2020/10/22 13:29
 * @description: 主函数，测试用
 */
public class Main {
    // 测试三种队列的实现方式
    private static void testQueue(Queue<Integer> queue,int countOp) throws Exception {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < countOp; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < countOp; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/10000000.0);
    }
    public static void main(String[] args) throws Exception {
        int countOp = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        testQueue(arrayQueue,countOp);
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        testQueue(loopQueue,countOp);
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        testQueue(linkedListQueue,countOp);
    }
}
