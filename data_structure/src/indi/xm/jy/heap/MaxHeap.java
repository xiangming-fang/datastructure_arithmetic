package indi.xm.jy.heap;

import indi.xm.jy.array.Arrays.dilatation.Array3;

import java.util.Random;

/**
 * 最大堆的实现
 */
public class MaxHeap<E extends Comparable<E>> {
    // 自己实现的动态数组
    private Array3<E> data;

    public MaxHeap(){
        data = new Array3<>();
    }

    // 返回数组下标为index的父亲节点的index
    private int getParent(int index){
        if (index <= 0){
            throw new IllegalArgumentException("index is illegal");
        }
        return (index - 1) / 2;
    }

    // 得到节点index的左孩子节点索引
    private int getLeftChild(int index){
        return 2 * index + 1;
    }

    // 节点index的右孩子节点索引
    private int getRightChild(int index){
        return 2 * index + 2;
    }

    // 添加一个元素，sift up 上浮
    public void add(E e) throws Exception {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) throws Exception {
        while (k != 0 && data.get(k).compareTo(data.get(getParent(k))) > 0){
            data.swap(k,getParent(k));
            k = getParent(k);
        }
    }

    // 移除的就是最大的那个，也就是二叉堆的根
    public E extractMax() throws Exception {
        E e = data.get(0);
        // 进行 sift down 下沉操作
        // 1、先交换最后一个和第一个的元素位置
        data.swap(0, data.getSize() - 1);
        // 2、去掉最后一个元素（就是之前的根节点）
        data.removeLast();
        // 3、sift down 下沉操作
        siftDown(0);
        return e;
    }

    private void siftDown(int k) throws Exception {
        while (getLeftChild(k) < data.getSize()){
            int index = getLeftChild(k);
            if (index + 1 < data.getSize()
                    && data.get(index + 1).compareTo(data.get(index)) > 0){
                index ++;
            }
            if (data.get(k).compareTo(data.get(index)) >= 0){
                break;
            }
            data.swap(k,index);
            k = index;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] test = new int[n];
        for (int i = 0; i < n; i++) {
            test[i] = maxHeap.extractMax();
        }
        for (int j = 1; j < n; j++){
            if (test[j - 1] < test[j]){
                throw new Exception("二叉堆创建异常");
            }
        }
        System.out.println("test maxHeap success");
    }
}
