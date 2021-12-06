package indi.xm.jy.sort.medium;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort
 * @ClassName: MergeSort
 * @Author: albert.fang
 * @Description: 归并排序
 * @Date: 2021/12/2 13:24
 */
public class MergeSort {

    public void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }

    // 归并排序1：递归写法
    private void mergeSort(int[] arr,int left,int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] helpArr = new int[right - left + 1];
        // helpArr 填充数据的指针，从0开始填充
        int helpIndex = 0;
        // 左组辅助指针
        int p = left;
        // 右组辅助指针
        int q = mid + 1;

        // 保证左组和右组的两个指针都不越界
        while (p <= mid && q <= right){
            // 左组p指定的元素小于等于右组p指定的元素，将左组元素加入 helpArr
            if (arr[p] <= arr[q]){
                helpArr[helpIndex++] = arr[p++];
            }
            else {
                helpArr[helpIndex++] = arr[q++];
            }
        }
        // 如果是右组越界了（说明左组更长），那么左组后续元素依序填充
        while (p <= mid){
            helpArr[helpIndex ++] = arr[p++];
        }
        // 如果是左组越界了（说明右组更长），那么右组后续元素依序填充
        while (q <= right){
            helpArr[helpIndex ++] = arr[q++];
        }

        // 辅助数组 helpArr填充完毕（此时helpArr是有序的数组）
        // 将helpArr数组的元素依次回填到 arr 中
        for (int ha : helpArr) {
            arr[left++] = ha;
        }
    }

    // 归并排序2：非递归写法（迭代写法）
    public void mergeSort2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int len = arr.length;
        int mergeSize = 1;
        // 只有归并的长度小于len才需要再继续归并
        while (mergeSize < len){
            int left = 0;
            int right,mid;
            while (left < len){
                // 先计算mid
                mid = left + mergeSize - 1;
                // 中点都大于等于len了，那就不必继续了
                // 注意语意，这里是有等号的，为什么等也不行？因为在等于的情况下，已经是越界了
                // 长度为len的数组，最后一个元素下标是len-1，所以为len已经越界
                if (mid >= len){
                    break;
                }
                right = Math.min(mid + mergeSize,len - 1);
                merge(arr,left,mid,right);
                left = right + 1;
            }
            // 一个优化，防止溢出
            // 如果此时mergeSize == Integer.MaxValue/2 + 1，那么下面扩大两倍之后会产生溢出问题
            if (mergeSize > len/2){
                break;
            }
            // 归并长度扩大1倍
            mergeSize = mergeSize << 1;
        }
    }

    // 对数器 - 递归归并
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        mergeSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }

    // 对数器 - 迭代归并
    private boolean detector2(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        mergeSort2(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }

    @Test
    public void test(){
        for (int i = 0; i < 100000; i++) {
            if (!detector()) {
                throw new RuntimeException("递归 归并排序错误");
            }
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 100000; i++) {
            if (!detector2()) {
                throw new RuntimeException("迭代 归并排序错误");
            }
        }
    }


}
