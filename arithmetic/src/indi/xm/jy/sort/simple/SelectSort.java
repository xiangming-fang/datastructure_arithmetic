package indi.xm.jy.sort.simple;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort
 * @ClassName: SelectSort
 * @Author: albert.fang
 * @Description: 选择排序
 * @Date: 2021/12/1 10:34
 */
public class SelectSort {

    public void selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 0 ~ len - 2 的位置需要比较
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // i ~ len - 1位置比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果最小值小标不是i，那么就得交换 i和minIndex了
            if ( i != minIndex){
                swap(arr,i,minIndex);
            }
        }
    }

    // 学了就要用
    private void swap(int[] arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
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
        selectSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }

}
