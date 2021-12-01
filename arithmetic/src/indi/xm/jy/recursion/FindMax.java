package indi.xm.jy.recursion;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.recursion
 * @ClassName: FindMax
 * @Author: albert.fang
 * @Description: 递归寻找最大值
 * @Date: 2021/12/1 18:09
 */
public class FindMax {

    public int findMax(int[] arr){
        return findMax(arr,0,arr.length - 1);
    }

    private int findMax(int[] arr, int left, int right) {
        if (left == right){
            return arr[left];
        }
        int res = 0;
        int mid = left + ((right - left) >> 1);
        res = Math.max(res,findMax(arr,left,mid));
        res = Math.max(res,findMax(arr,mid + 1,right));
        return res;
    }

    // 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        return findMax(ints) == getMax(ints);
    }

    private int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max,i);
        }
        return max;
    }

    @Test
    public void test(){
        for (int i = 0; i < 100000; i++) {
            if (!detector()) {
                throw new RuntimeException("查找错误");
            }
        }
    }
}
