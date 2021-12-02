package indi.xm.jy.queue;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.queue
 * @ClassName: FixedSizeQueue
 * @Author: albert.fang
 * @Description: 用数组实现固定大小的队列
 * @Date: 2021/12/2 10:46
 */
public class FixedSizeQueue {
    int[] arr;

    // 队列中实际的使用大小
    int size = 0;

    // 维护两个指针，队首和队尾，队尾入队，队首出队
    int head = 0,rear = 0;

    public FixedSizeQueue(int size){
        if (size <= 0 ){
            throw new RuntimeException("固定大小非法");
        }
        arr = new int[size];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == arr.length;
    }

    private int next(int index){
        return index + 1 >= arr.length ? 0 : index + 1;
    }

    public void offer(int e){
        if (isFull()){
            throw new RuntimeException("已经满了，不能再添加了");
        }
        arr[rear] = e;
        rear = next(rear);
        size ++;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("已经空了，没有元素pop了");
        }
        int e = arr[head];
        head = next(head);
        size --;
        return e;
    }
}
class FixedSizeQueueTest{

    public static void main(String[] args) {
        FixedSizeQueue queue = new FixedSizeQueue(7);
        for (int i = 0; i < 7; i++) {
            queue.offer(i);
        }
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        for (int i = 0; i < 3; i++) {
            queue.offer(10);
        }
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}