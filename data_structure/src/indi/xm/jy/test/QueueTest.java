package indi.xm.jy.test;

import indi.xm.jy.queue.my.ArrayQueue;
import indi.xm.jy.queue.my.LinkedListQueue;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: QueueTest
 * @Author: albert.fang
 * @Description: 队列测试
 * @Date: 2021/7/30 19:00
 */
public class QueueTest {

    @Test
    public void offerAndPollTest(){
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.offer("asdfdasf");
        arrayQueue.offer("rqwee");
        arrayQueue.offer("2134123");
        arrayQueue.offer("9789678");
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
    }

    @Test
    public void replaceAndPeekTest(){
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.offer("asdfdasf");
        arrayQueue.offer("rqwee");
        arrayQueue.offer("2134123");
        arrayQueue.offer("9789678");
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.peek());
        arrayQueue.replace("fxm");
        System.out.println(arrayQueue.peek());
    }

    @Test
    public void offerAndPollLinkedListTest(){
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.offer("asdfdasf");
        queue.offer("rqwee");
        queue.offer("2134123");
        queue.offer("9789678");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void replaceAndPeekLinkedListTest(){
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.offer("asdfdasf");
        queue.offer("rqwee");
        queue.offer("2134123");
        queue.offer("9789678");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        queue.replace("fxm");
        System.out.println(queue.peek());
    }
}
