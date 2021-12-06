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

    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Test
    public void test(){
        for (int i = 0; i < 1000; i++) {
            if (!detector()){
                throw new RuntimeException("partition 分区失败");
            }
        }
        System.out.println("partition 分区成功");
    }

    private boolean detector(){
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
}
