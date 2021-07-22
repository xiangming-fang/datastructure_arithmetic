package com.xm.jy.heap;

import com.xm.jy.array.Arrays.dilatation.Array3;
import com.xm.jy.queue.Queues.Queue;

import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.heap
 * @ClassName: HeapByLinear
 * @Author: albert.fang
 * @Description: 普通线性结构创建最小堆
 * @Date: 2021/7/22 15:02
 */
public class HeapByLinear<E extends Comparable> implements Queue<E> {

    private Array3<E> data;

    public HeapByLinear(){
        this.data = new Array3<>();
    }

    public HeapByLinear(int size){
        this.data = new Array3<>(size);
    }

    @Override
    public void enqueue(E e) throws Exception {
        data.addLast(e);
    }

    @Override
    public E dequeue() throws Exception {
        int min = getMin();
        swap(min,data.getSize() - 1);
        return data.removeLast();
    }

    @Override
    public E getfront() throws Exception {
        int min = getMin();
        return data.get(min);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // 交换两个元素
    private void swap(int a,int b) throws Exception {
        E temp = data.get(a);
        data.set(a,data.get(b));
        data.set(b,temp);
    }

    // 找到最小的那个元素下标
    private int getMin() throws Exception {
        if (isEmpty()){
            throw new IllegalArgumentException("数组为空");
        }
        E min = data.get(0);
        int minIdx = 0;
        for (int i = 1; i < data.getSize(); i++) {
            if (min.compareTo(data.get(i)) > 0) {
                min = data.get(i);
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) throws Exception {
        HeapByLinear<Comparable> heap = new HeapByLinear<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            heap.enqueue(random.nextInt(1000));
        }
        for (int i = 0; i < heap.getSize(); i++) {
            System.out.println(heap.dequeue());
        }
    }
}
// 普通线性数据结构创建堆
// 有一个注意点：如何不造成数组空间浪费。

// 普通线性数据结构创建堆的过程。
// 1、既然这个非线性数据结构是数组，那么入队的时候，直接在数组末尾添加一个元素即可。时间复杂度为O(1)。
// 2、出队的话，既然是最小堆，出来的肯定是最小的那个元素。所以要进行遍历比较。时间复杂度为O(n)。

// 注意点：出队的时候，如果只是找到最小元素，然后出队的话，那么频繁的入队出队会造成数组元素中间的内存位置浪费了。
// 解决，在出队的时候，找到最小元素下标，并不要立马出队，而是和最后一个元素进行位置交换，然后这里只需要移除最后一个元素就可以了。
