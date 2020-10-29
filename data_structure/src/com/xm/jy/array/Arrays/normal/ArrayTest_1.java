package com.xm.jy.array.Arrays.normal;

/**
 * @author: albert.fang
 * @date: 2020/10/20 13:22
 * @description: 封装java数组，测试
 */
public class ArrayTest_1 {

    public static int sum(int[] arr){
        return sum(0,arr);
    }

    public static int sum(int border,int[] arr){
        if (border == arr.length){
            return 0;
        }
        return arr[border] + sum(border + 1,arr);
    }
    public static void main(String[] args) throws Exception {
//        Array array = new Array();
//        array.addLast(1);
//        array.addLast(2);
//        array.addLast(3);
//        array.addLast(4);
//        array.addLast(5);
//        System.out.println(array);
//        array.addFirst(6);
//        System.out.println(array);
//        array.addFirst(-1);
//        System.out.println(array);
//        array.add(3,33);
//        System.out.println(array);
//        System.out.println(array.get(3));
//        array.set(5,5);
//        System.out.println(array);
//        System.out.println(array.contains(5));
//        System.out.println(array.find(5));
//        array.removeFirst();
//        System.out.println(array);
//        array.removeLast();
//        System.out.println(array);
//        array.remove(3);
//        System.out.println(array);
//        array.removeLast();
//        array.removeLast();
//        array.removeLast();
//        array.removeLast();
//        array.removeLast();
//        System.out.println(array);
//        array.removeLast();

        int[] ints = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(sum(ints));
    }
}
