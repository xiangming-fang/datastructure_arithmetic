package com.xm.jy.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.sort
 * @ClassName: QuickSort
 * @Author: albert.fang
 * @Description: 快排
 * @Date: 2021/9/6 15:52
 */
public class QuickSort {

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length - 1);
    }

    private void quickSort(int[] nums,int left,int right){
        if (left >= right){
            return;
        }
        // 基数的选择，数组第一个
        int cn = left;
        int end = right;
        int cardinalNumber = nums[cn];
        while (left < right){
            if (nums[left] > cardinalNumber && nums[right] < cardinalNumber){
                swap(nums,left,right);
            }
            if (nums[left] <= cardinalNumber){
                left ++;
            }
            if (nums[right] >= cardinalNumber){
                right --;
            }
        }
        if (nums[left] < nums[cn]){
            swap(nums,cn,left);
            quickSort(nums,cn,left - 1);
            quickSort(nums,left + 1,end);
        }else {
            quickSort(nums,cn,left - 1);
            quickSort(nums,left,end);
        }
    }

    // 交换下标元素
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test(){
//        int[] arr = {4, 85, 6, 5, 3, 7, 56, 9};
//        int[] arr = { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1 };
//        int[] arr = {1, 3, 3, 5, 6, 7, 56, 9};
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            arr[i] = random.nextInt(1000000) + 1;
        }
        quickSort(arr);
        for (int j = 1; j < 1000000; j++) {
            if (arr[j] < arr[j-1] ){
                System.err.println("快排失败");
                return;
            }
        }
        System.out.println("快排成功");
    }
}
