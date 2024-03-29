package indi.xm.jy.sort.medium;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort.medium
 * @ClassName: Partition
 * @Author: albert.fang
 * @Description: 分区问题
 * @Date: 2021/12/6 13:28
 */
public class Partition {

    // partition1：将小于等于target的元素放在arr左边，大于target的元素放在arr右边
    public int[] partition1(int[] arr,int target){
        if (arr == null) {
            return null;
        }
        int left = -1;
        int right = arr.length;
        int cur = 0;
        while (cur < right){
            if (arr[cur] <= target){
                swap(arr,left + 1,cur);
                left = cur;
                cur ++;
            }
            else {
                swap(arr,--right,cur);
            }
        }
        return new int[]{left, right};
    }

    // partition2：将小于target的元素放在arr左边，大于target的元素放在arr右边，等于target放中间
    public int[] partition2(int[] arr,int target){
        if (arr == null){
            return null;
        }

        int left = -1;
        int right = arr.length;
        int cur = 0;
        while (cur < right){
            if (arr[cur] > target){
                swap(arr,cur,--right);
            }
            else if (arr[cur] < target){
                swap(arr,cur++,++left);
            }
            else {
                cur ++;
            }
        }
        return new int[]{left,right};
    }

    public void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,-1,arr.length);
    }

    // 左开右开
    private void quickSort(int[] arr, int left, int right) {
        if (right - left <= 2){
            return;
        }
        // 保存一份 left 副本
        int copyLeft = left;
        // 保存一份 right 副本
        int copyRight = right;
        int cur = left + 1;
        int target = arr[cur];
        while (cur < right){
            if (arr[cur] > target){
                swap(arr,cur,--right);
            }
            else if (arr[cur] < target){
                swap(arr,cur++,++left);
            }
            else {
                cur ++;
            }
        }
        quickSort(arr,copyLeft,left+1);
        quickSort(arr,right - 1,copyRight);
    }

    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void partition1Test(){
        for (int i = 0; i < 10000; i++) {
            if (!detector1()){
                throw new RuntimeException("partition 分区失败");
            }
        }
        System.out.println("partition 分区成功");
    }

    private boolean detector1(){
        int[] ints = ArrayUtil.generatorArray();
        int pivot = ints[0];
        int[] resA = partition1(ints, pivot);
        int count = 0;
        for (int anInt : ints) {
            if (anInt <= pivot){
                count ++;
            }
        }
        int[] resB = {count - 1, count};
        return ArrayUtil.isEquals(resA, resB);
    }

    @Test
    public void partition2Test(){
        for (int i = 0; i < 10000; i++) {
            if (!detector2()){
                System.out.println(i);
                throw new RuntimeException("partition2 分区失败");
            }
        }
        System.out.println("partition2 分区成功");
    }

    private boolean detector2(){
        int[] ints = ArrayUtil.generatorArray();
        int pivot = ints[0];
        int[] resA = partition2(ints, pivot);
        int count = 0;
        int gather = 0;
        for (int anInt : ints) {
            if (anInt < pivot){
                count ++;
            }
            if (anInt > pivot){
                gather ++;
            }
        }
        int[] resB = {count - 1, ints.length - gather};
        boolean equals = ArrayUtil.isEquals(resA, resB);
        if (!equals){
            System.out.println(Arrays.toString(resA));
            System.out.println(Arrays.toString(resB));
        }
        return equals;
    }

    @Test
    public void quickSortTest(){
        for (int i = 0; i < 10000; i++) {
            if (!detector()){
                System.out.println("快排 失败了~~~");
            }
        }
        System.out.println("快排成功~~");
    }

    // 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        quickSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }
}
