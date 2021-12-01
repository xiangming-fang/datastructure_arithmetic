package indi.xm.jy.sort;

import indi.xm.jy.utils.ArrayUtil;
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
        for (int i = 0; i < 10000; i++) {
            if (!detector()){
                System.out.println("失败了");
            }
        }
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
