package indi.xm.jy.sort.simple;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.sort
 * @ClassName: InsertSort
 * @Author: albert.fang
 * @Description: 插入排序
 * @Date: 2021/12/1 11:15
 */
public class InsertSort {

    public void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int len = arr.length;
        // 从 i 到 len - 1的数都需要往前看
        for (int i = 1; i < len; i++) {
            // 每个数往前看几次
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    arr[j] = arr[j] ^ arr[j - 1];
                    arr[j - 1] = arr[j] ^ arr[j - 1];
                    arr[j] = arr[j] ^ arr[j - 1];
                }
                // 如果每个数往前的时候，看见相等，那么停止往前看
                else {
                    break;
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
        insertSort(ints);
        Arrays.sort(ans);
        return ArrayUtil.isEquals(ints, ans);
    }

}
