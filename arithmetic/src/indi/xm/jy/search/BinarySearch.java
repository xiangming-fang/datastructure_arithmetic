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

    // 二分查找：(4) 局部最值问题
    // 这里是最小值
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
            }else {
                left = mid;
            }
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

    // (2) 对数器
    private boolean detector2(){
        int[] ints = ArrayUtil.generatorOrderDuplicatedArray(1000);
        int index = binarySearch2(ints, 1000);
        return index == 990;
    }

    // (3) 对数器
    private boolean detector3(){
        int[] ints = ArrayUtil.generatorOrderDuplicatedArray(1000);
        int index = binarySearch3(ints, 1000);
        return index == 1000;
    }

    // (4) 对数器
    private boolean detector4(){
        int[] ans = ArrayUtil.generatorArray();
        int index = binarySearch4(ans);
        if (index == -1){
            System.out.println("不存在局部最小值");
            System.out.println(Arrays.toString(ans));
            return false;
        }
        // 只有一个元素
        if (index == 0 && ans.length < 2){
            return true;
        }
        // 第一位是局部最小值
        if (index == 0 && ans[1] > ans[0]){
            return true;
        }
        // 倒数第一位是局部最小值
        if (index == ans.length - 1 && ans[index] < ans[ans.length - 2]){
            return true;
        }
        // 中间产生局部最小值
        return ans[index] < ans[index - 1] && ans[index] < ans[index + 1];
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
        for (int i = 0; i < 200000; i++) {
            if (!detector2()) {
                throw new RuntimeException(">= target的最左边界有误");
            }
        }
    }

    @Test
    public void test3() {
        for (int i = 0; i < 200000; i++) {
            if (!detector3()) {
                throw new RuntimeException("<= target的最右边界有误");
            }
        }
    }

    @Test
    public void test4(){
        for (int i = 0; i < 200000; i++) {
            if (!detector4()) {
                throw new RuntimeException("局部最小查找有误");
            }
        }
    }
}
