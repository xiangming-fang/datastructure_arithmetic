package indi.xm.jy.bit;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.bit
 * @ClassName: TwoNumsOccurOneTime
 * @Author: albert.fang
 * @Description: 两个数字出现一次，其余均出现偶数次 找出这出现一次的数 ^,&,n & (~n + 1)
 * @Date: 2021/12/2 15:18
 */
public class TwoNumsOccurOneTime {

    // 找到两个一次的数字
    public int[] findTwoNumsOccurOneTime(int[] arr){
        int[] res = new int[2];
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        // 提取 xor 中最右边一个 1
        int rightOne = xor & (~xor + 1);
        int firstNum = 0;
        for (int j : arr) {
            // 注意这里用到了 & 的特性
            if ((rightOne & j) != 0) {
                firstNum = firstNum ^ j;
            }
        }
        int secondNum = xor ^ firstNum;
        res[0] = firstNum;
        res[1] = secondNum;
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findTwoNumsOccurOneTime(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 6, 5})));
    }
}
