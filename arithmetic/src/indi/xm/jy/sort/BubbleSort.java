package indi.xm.jy.sort;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort
 * @ClassName: BubbleSort
 * @Author: albert.fang
 * @Description: 冒泡排序
 * @Date: 2021/12/1 10:59
 */
public class BubbleSort {

    public void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 注意边界条件 len - i - 1
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j + 1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }

    @Test
    public void test(){
        for (int i = 0; i < 1000; i++) {
            if (!detector()){
                throw new RuntimeException("排序失败");
            }
        }
    }

    // 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorArray();
        int[] ans = new int[ints.length];
        System.arraycopy(ints,0,ans,0,ints.length);
        bubbleSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }
}
