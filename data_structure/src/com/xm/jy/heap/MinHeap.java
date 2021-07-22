package com.xm.jy.heap;

import com.xm.jy.array.Arrays.dilatation.Array3;
import com.xm.jy.queue.Queues.Queue;

import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.heap
 * @ClassName: MinHeap
 * @Author: albert.fang
 * @Description: 最小堆：二叉堆的根是最小的那个，这个小是指权小，权的定义是主观定义的。
 * @Date: 2021/7/22 14:13
 */
public class MinHeap<E extends Comparable> implements Queue<E> {

    private Array3<E> data;

    public MinHeap(int size){
        this.data = new Array3<>(size);
    }

    public MinHeap(){
        this.data = new Array3<>();
    }

    // 返回该节点的父节点的下标索引
    private int parent(int idx){
        return (idx - 1) / 2;
    }

    // 返回该节点的左孩子节点下标索引
    private int left(int idx){
        return 2 * idx + 1;
    }

    // 返回该节点的右孩子节点下标索引
    private int right(int idx){
        return 2 * idx + 2;
    }

    // 入队操作
    // 1、在data数组末尾加入一个新的元素。
    // 2、新加入的元素和其父节点比较，如果小于腹肌诶单，那么交换位置。
    // 3、重复第2步操作，结束条件：（1）上移到下标为0的位置。（2）新加入元素比父节点大。
    @Override
    public void enqueue(E e) throws Exception {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 出队操作
    // 1、将data数组的第一个位置和最后一个位置元素交换
    // 2、直接去掉最后一个元素（就是之前的根元素）。
    // 3、对交换上去的元素下沉操作。下沉条件，和左右孩子中的最小孩子进行交换，如果都比左右孩子小，那不必交换。
    @Override
    public E dequeue() throws Exception {
        E e = data.get(0);
        swap(0,getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    @Override
    public E getfront() throws Exception {
        return data.get(0);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    // 交换下标为a和下标为b的元素位置
    private void swap(int a,int b) throws Exception {
        E temp = data.get(a);
        data.set(a,data.get(b));
        data.set(b,temp);
    }

    // 将位置idx的元素上浮
    private void siftUp(int idx) throws Exception {
        while (idx != 0 && data.get(idx).compareTo(data.get(parent(idx))) < 0){
            swap(idx,parent(idx));
            idx = parent(idx);
        }
    }

    // 将位置idx的元素下沉
    private void siftDown(int idx) throws Exception {
        int tempIdx = left(idx);
        while (tempIdx < getSize()){
            if (tempIdx + 1 < getSize() && data.get(tempIdx).compareTo(data.get(tempIdx + 1)) > 0){
                tempIdx = tempIdx + 1;
            }
            swap(tempIdx,idx);
            idx = tempIdx;
            tempIdx = left(idx);
        }
    }

    public static void main(String[] args) throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(16);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            minHeap.enqueue(random.nextInt(100));
        }
        for (int i = 0; i < minHeap.getSize(); i++) {
            System.out.println(minHeap.dequeue());
        }
    }
}
