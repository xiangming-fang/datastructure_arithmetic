package com.xm.jy.heap;

import com.xm.jy.array.Arrays.dilatation.Array3;
import com.xm.jy.queue.Queues.Queue;
import org.junit.Test;

import java.util.Comparator;
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

    private Comparator<? super E> comparator;

    public MinHeap(Comparator<? super E> comparator){
        this.data = new Array3<>();
        this.comparator = comparator;
    }

    public MinHeap(int size){
        this.data = new Array3<>(size);
    }

    public MinHeap(){
        this.data = new Array3<>();
    }

    public MinHeap(E[] arr) throws Exception {
        heapify(arr);
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
    // 2、新加入的元素和其父节点比较，如果小于父级节单，那么交换位置。
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

    @Override
    public String toString(){
        if (!isEmpty()){
            int size = getSize();
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < size; i++) {
                try {
                    result.append(dequeue()).append("，");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return result.substring(0,result.length()-1);
        }
        return null;
    }

    // 交换下标为a和下标为b的元素位置
    private void swap(int a,int b) throws Exception {
        E temp = data.get(a);
        data.set(a,data.get(b));
        data.set(b,temp);
    }

    // 将位置idx的元素上浮
    private void siftUp(int idx) throws Exception {
        if (comparator == null){
            while (idx != 0 && data.get(idx).compareTo(data.get(parent(idx))) < 0){
                swap(idx,parent(idx));
                idx = parent(idx);
            }
        }
        else {
            while (idx != 0 && comparator.compare(data.get(idx),data.get(parent(idx))) > 0){
                swap(idx,parent(idx));
                idx = parent(idx);
            }
        }
    }

    // 将位置idx的元素下沉
    private void siftDown(int idx) throws Exception {
        int tempIdx = left(idx);
        while (tempIdx < getSize()){
            if (comparator == null){
                if (tempIdx + 1 < getSize() && data.get(tempIdx).compareTo(data.get(tempIdx + 1)) > 0){
                    tempIdx = tempIdx + 1;
                }
            }else {
                if (tempIdx + 1 < getSize() && comparator.compare(data.get(tempIdx + 1),data.get(tempIdx)) > 0){
                    tempIdx = tempIdx + 1;
                }
            }
            // 如果当前节点小于等于左右节点中的最大节点，那么不必进行交换
            if (data.get(idx).compareTo(data.get(tempIdx)) <= 0){
                break;
            }
            swap(tempIdx,idx);
            idx = tempIdx;
            tempIdx = left(idx);
        }
    }

    // 出队一个元素，再往里加一个元素
    // 方案一：用现成的方法可以先dequeue再enqueue。
    // 方案二：直接将数组下标为0的元素替换成待加入的元素，再在下标为0的位置开始执行siftDown操作即可。
    public E replace(E e) throws Exception {
        E result = data.get(0);
        data.set(0,e);
        siftDown(0);
        return result;
    }

    // 将一个数组堆化
    // 方案一：创建一个heap对象，然后依次遍历待堆化数组，将待堆化数组的元素添加到heap对象中。
    // 方案二：从倒数第一个非叶子节点开始执行siftDown操作，一直到根节点。
    public void heapify(E[] arr) throws Exception {
        data = new Array3<>(arr);
        int firstNotLeafIdx = parent(data.getSize() - 1);
        for (int i = firstNotLeafIdx;i >= 0; i--){
            siftDown(i);
        }
    }

    public void clear() throws Exception {
        int size = data.getSize();
        for (int i = 0; i < size; i++) {
            data.removeLast();
        }
    }

    // 判断最小堆是否成功
    private static void createMinHeapSuccess() throws Exception {
        int n = 1000000;
        MinHeap<Integer> maxHeap = new MinHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        int[] test = new int[n];
        for (int i = 0; i < n; i++) {
            test[i] = maxHeap.dequeue();
        }
        for (int j = 1; j < n; j++){
            if (test[j - 1] > test[j]){
                throw new Exception("最小二叉堆创建异常");
            }
        }
        System.out.println("test minHeap success");
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
        // 清空
        minHeap.clear();
        // replace
        for (int i = 0; i < 10; i++) {
            minHeap.enqueue(i);
        }
        Integer replace = minHeap.replace(14);
        System.out.println("replace 的出队元素是：" + replace);
        int size = minHeap.getSize();
        for (int i = 0; i < size; i++) {
            System.out.println(minHeap.dequeue());
        }

        // heapify 测试
        System.out.println("heapify 测试");
        Integer[] arr = {2, 4, 5, 6, 79, 8, 80, 3};
        MinHeap<Integer> heap = new MinHeap<>(arr);
        int size1 = heap.getSize();
        for (int i = 0; i < size1; i++) {
            System.out.println(heap.dequeue());
        }
    }
}
