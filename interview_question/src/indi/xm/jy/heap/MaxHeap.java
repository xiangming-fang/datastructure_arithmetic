package indi.xm.jy.heap;

import indi.xm.jy.utils.ArrayUtil;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.heap
 * @ClassName: MaxHeap
 * @Author: albert.fang
 * @Description: 面试题：手撸一个大根堆
 * @Date: 2021/12/3 9:46
 */
public class MaxHeap {

    int[] arr;

    int size;

    public MaxHeap(int size){
        arr = new int[size];
        this.size = 0;
    }

    // 将传入的数组进行堆化
    public MaxHeap(int[] arr){
        this.arr = new int[arr.length];
        System.arraycopy(arr,0,this.arr,0,arr.length);
        heapify();
        this.size = arr.length;
    }

    public int getSize(){
        return size;
    }

    // 往大根堆中添加一个元素
    public void offer(int value){
        if (isFull()){
            throw new RuntimeException("堆空间不足，不能添加");
        }
        arr[size] = value;
        siftUp(arr,size);
        size ++;
    }

    // 元素上移
    private void siftUp(int[] arr,int index){
        // 当前index不是堆顶 && 父节点的值小于当前节点 就要执行与父节点交换操作
        while (index != 0 && arr[parentIndex(index)] < arr[index]){
            int parentIndex = parentIndex(index);
            swap(index,parentIndex);
            index = parentIndex;
        }
    }

    // 往大根堆中获取一个元素
    public int poll(){
        if (isEmpty()){
            throw new RuntimeException("堆中无数据");
        }
        int res = arr[0];
        swap(0,--size);
        siftDown(arr,size,0);
        return res;
    }

    // 元素下移
    private void siftDown(int[] arr,int size,int index){
        while (index < size && leftChildIndex(index) < size){
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex =  -1;
            if (rightChildIndex(index) < size){
                rightChildIndex = rightChildIndex(index);
            }
            // 待交换位置，默认为left
            int pendIndex = leftChildIndex;

            // 比较左右元素哪个更大
            if (rightChildIndex != -1 && arr[rightChildIndex] > arr[leftChildIndex]){
                pendIndex = rightChildIndex;
            }

            // 注意这里，左右孩子最大的那个，还得比index元素大才交换
            if (arr[pendIndex] > arr[index]){
                swap(index,pendIndex);
                index = pendIndex;
            }else {break;}
        }
    }

    // 堆化
    private void heapify(){
        for (int i = this.arr.length - 1; i >= 0; i--) {
            siftDown(this.arr,this.arr.length,i);
        }
    }

    private void swap(int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // index 位置的左孩子下标 2 * index + 1
    private int leftChildIndex(int index){
        return (index << 1) + 1;
    }

    // index 位置的右孩子下标 2 * index + 2;
    private int rightChildIndex(int index){
        return (index << 1) + 2;
    }

    // index 位置的父亲节点下标 (index - 1)/2
    private int parentIndex(int index){
        return (index - 1) >> 1;
    }

    // 判断大根堆是否已满
    private boolean isFull(){
        return size == arr.length;
    }

    // 判断大根堆是否为空
    private boolean isEmpty(){
        return size == 0;
    }
}

class MaxHeapTest{
    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            if (!detector(1000)) {
//                throw new RuntimeException("生成最大堆失败");
//            }
//        }
//        System.out.println("全部比较成功");


        // maxHeap 的heapify
        for (int i = 0; i < 100000; i++) {
            if (!detectorHeapify()) {
                throw new RuntimeException("输入数组 heapify 失败");
            }
        }
        System.out.println("全部 heapify 成功");
    }

    private static boolean detector(int size){
        MaxHeap maxHeap = new MaxHeap(size);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(10000);
            maxHeap.offer(num);
            pq.offer(num);
        }
        for (int i = 0; i < size; i++) {
            if (pq.poll() != maxHeap.poll()){
                System.out.println(i);
                return false;
            }
        }
        // 这里是判断自己实现的大根堆移除之后的size 和 pq size 是否一样
        // 如果不一样，说明maxHeap 的size 维护错误
        return maxHeap.getSize() == pq.size();
    }

    private static boolean detectorHeapify(){
        int[] ints = ArrayUtil.generatorArray();
        MaxHeap maxHeap = new MaxHeap(ints);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int anInt : ints) {
            pq.offer(anInt);
        }
        for (int i = 0; i < ints.length; i++) {
            if (pq.poll() != maxHeap.poll()){
                System.out.println(i);
                return false;
            }
        }
        // 这里是判断自己实现的大根堆移除之后的size 和 pq size 是否一样
        // 如果不一样，说明maxHeap 的size 维护错误
        return maxHeap.getSize() == pq.size();
    }
}
