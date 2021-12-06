package indi.xm.jy.bit;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.bit
 * @ClassName: BitMapTest
 * @Author: albert.fang
 * @Description: 位图测试类
 * @Date: 2021/12/6 10:01
 */
public class BitMapTest {
    // 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorNotDuplicatedArray(1000);
        BitMap bitMap = new BitMap(1000);
        for (int anInt : ints) {
            bitMap.add(anInt);
        }
        int[] sortArray = new int[ints.length];
        bitMap.bitMapSort(sortArray);
        Arrays.sort(ints);
        return ArrayUtil.isEquals(ints, sortArray);
    }

    @Test
    public void test(){
        for (int i = 0; i < 1000; i++) {
            if (!detector()) {
                throw new RuntimeException("位图排序出现错误");
            }
        }
        System.out.println("位图排序正确");
    }

    // 测试位图对10亿数据量排序速度 和 jdk 底层排序比较
    @Test
    public void testBitMapSortAndQuickSort(){
        int[] ints = ArrayUtil.generatorNotDuplicatedArray(1000000000);
        BitMap bitMap = new BitMap(1000000000);
        for (int anInt : ints) {
            bitMap.add(anInt);
        }

        long bitMapSortStartTime = System.currentTimeMillis();
        int[] sortArray = new int[ints.length];
        bitMap.bitMapSort(sortArray);
        long bitMapSortEndTime = System.currentTimeMillis();
        System.out.println("位图排序方式 对10亿数据量排序 总共消耗: " + (bitMapSortEndTime - bitMapSortStartTime) / 1000 + " s");

        long jdkSortStartTime = System.currentTimeMillis();
        Arrays.sort(ints);
        long jdkSortEndTime = System.currentTimeMillis();
        System.out.println("jdk排序方式 对10亿数据量排序 总共消耗: " + (jdkSortEndTime - jdkSortStartTime) / 1000 + " s");
    }
}
