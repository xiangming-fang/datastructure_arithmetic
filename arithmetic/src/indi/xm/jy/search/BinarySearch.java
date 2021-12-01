package indi.xm.jy.search;

import indi.xm.jy.utils.ArrayUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.search
 * @ClassName: BinarySearch
 * @Author: albert.fang
 * @Description: 二分查找
 * @Date: 2021/12/1 14:34
 */
public class BinarySearch {


    // 二分查找：(1) 在有序数组中查找某个数是否存在
    public boolean binarySearch(int[] arr,int target){
        // 注意边界条件的语意，左闭右闭[0,len-1]
        int left = 0,right = arr.length - 1;
        int mid;
        // 为什么这里等于也要进入到while代码块
        // 注意left 和 right的语意，表示左闭右闭，那么自然left == right还是有一个元素的
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if (arr[mid] == target){
                return true;
            }
            if (arr[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 二分查找：(2) 在有序数组中查找大于等于某个数的最左侧位置
    public int binarySearch2(int[] arr,int target){
        // 注意语意：左闭右闭
        int left = 0,right = arr.length - 1;
        int mid;
        int index = -1;
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= target){
                index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return index;
    }


    // 二分查找：(3) 在有序数组中查找小于等于某个数的最右侧位置
    public int binarySearch3(int[] arr,int target){
        // 语意：左闭右闭
        int left = 0,right = arr.length - 1;
        int mid;
        int index = -1;
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if (arr[mid] <= target){
                index = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return index;
    }

    // 二分查找：(4) 局部最小问题
    public int binarySearch4(int[] arr){
        if (arr.length < 2){
            return 0;
        }
        if (arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 0,right = arr.length - 1;
        int mid = -1;
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]){
                return mid;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid]){
                right = mid;
            }
            left = mid;
        }
        return mid;
    }
    // (1) 对数器
    private boolean detector(){
        int[] ints = ArrayUtil.generatorOrderArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            set.add(i);
        }
        Random random = new Random();
        int target = random.nextInt(ints.length);
        return binarySearch(ints, target) == set.contains(target);
    }

    @Test
    public void test(){
        for (int i = 0; i < 100000; i++) {
            if (!detector()) {
                throw new RuntimeException("二分查找有误");
            }
        }
    }

    @Test
    public void test2(){
        System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 2)); // 1
        System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 3)); // 7
        System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 1)); // 0
        System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,5,5,5}, 4)); // 12
        System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,5,5,5}, 8)); // -1
    }

    @Test
    public void test3() {
        System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 2)); // 6
        System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 3)); // 11
        System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 1)); // 0
        System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,5,5,5}, 4)); // 11
        System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,5,5,5}, 8)); // 14
    }

    @Test
    public void test4(){
        System.out.println(binarySearch4(new int[]{7,5,1,2,3,4}));
    }
}
