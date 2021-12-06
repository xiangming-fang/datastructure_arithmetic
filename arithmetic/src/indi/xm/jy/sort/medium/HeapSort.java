package indi.xm.jy.sort.medium;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort
 * @ClassName: HeapSort
 * @Author: albert.fang
 * @Description: 堆排序
 * @Date: 2021/12/3 14:48
 */
public class HeapSort {

    public void heapSort(int[] arr){
        heapify(arr);
        for (int i = 0; i < arr.length; i++) {
            swap(arr,0,arr.length - 1 - i);
            siftDown(arr,0,arr.length - i - 1);
        }
    }

    private void heapify(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            siftDown(arr,i,arr.length);
        }
    }


    // 将数组中的index位置元素进行下沉操作
    private void siftDown(int[] arr,int index,int len){
        while (index < len && leftChildIndex(index) < len){
            int leftIndex = leftChildIndex(index);
            int pendIndex = leftIndex;
            if (rightChildIndex(index) < len && arr[rightChildIndex(index)] > arr[leftIndex] ){
                pendIndex = rightChildIndex(index);
            }
            // 注意：只有孩子节点最大的节点，比当前节点还大才交换
            if (arr[index] < arr[pendIndex]){
                swap(arr,index,pendIndex);
                index = pendIndex;
            }else {break;}

        }
    }


    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int leftChildIndex(int index){
        return (index << 1) + 1;
    }

    private int rightChildIndex(int index){
        return (index << 1) + 2;
    }


    @Test
    public void test(){
        for (int i = 0; i < 100000; i++) {
            if (!detector()){
                throw new RuntimeException("堆排序失败");
            }
        }
        System.out.println("堆排序正确……");

        int[] arr = {4, 5, 6, 2, 3, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        heapSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }
}
