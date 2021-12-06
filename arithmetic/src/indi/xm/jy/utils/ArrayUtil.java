package indi.xm.jy.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.utils
 * @ClassName: ArraysUtil
 * @Author: albert.fang
 * @Description: 数组工具类
 * @Date: 2021/12/1 10:42
 */
public class ArrayUtil {

    // 产生一个有序数组
    public static int[] generatorOrderArray(){
        Random random = new Random();
        int len = random.nextInt(10000) + 1;
        int[] ints = new int[len];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        return ints;
    }

    // 产生一个有序 & 有重复数字的数组
    public static int[] generatorOrderDuplicatedArray(int duplicatedNum){
        Random random = new Random();
        int len = random.nextInt(10000) + duplicatedNum + 1;
        int[] ints = new int[len];
        for (int i = 0; i < ints.length; i++) {
            // 重复位置
            if ( i >= duplicatedNum - 10 && i <= duplicatedNum){
                ints[i] = duplicatedNum;
            }else {
                ints[i] = i;
            }
        }
        return ints;
    }

    // 产生一个随机数组
    public static int[] generatorArray(){
        Random random = new Random();
        int len = random.nextInt(1000) + 1;
        int[] ints = new int[len];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10000);
        }
        return ints;
    }

    // 产生一个随机数组，里面的元素不能重复
    // 给位图排序用
    public static int[] generatorNotDuplicatedArray(int range){
        Random random = new Random();
        int len = random.nextInt(range) + 1;
        int[] ints = new int[len];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        shuffle(ints);
        return ints;
    }

    // 比较两个数组的内容是否相等
    public static boolean isEquals(int[] a,int[] b){
        if (a == null || b == null){
            return false;
        }
        if (a.length != b.length){
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.out.println("不相等……" + i);
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] arr){
        Random rd = new Random();
        for (int i = arr.length; i > 0 ; i --) {
            swap(arr,i - 1,rd.nextInt(i));
        }
    }

    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
