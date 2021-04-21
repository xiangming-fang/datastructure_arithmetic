package com.xm.jy;

/**
 * @author: albert.fang
 * @date: 2021/4/20 11:42
 * @description: 求解根号2的近似值
 */
public class GenHao2 {

    // 判断函数x轴上两点的函数值相乘是否为负数，负数返回true,正数返回false
    private static boolean isMinus(double a,double b,int num){
        return (a * a - num) * (b * b - num) < 0;
    }

    // 求num这个数的根号值
    private static double getGenHaoValue(int num){
        double a = 0;
        double b = num;
        return recursion(a,b,num);
    }

    /**
     * 递归求解，终止条件 （1）b - a的精度 小于指定值 （2）选择的起始区间中点的函数值刚好等于0
     * 符合终止条件，直接返回。不符合，将问题划分成更小的子问题，递归执行子问题。
     * @param a 左区间最边的值
     * @param b 右区间最边的值
     * @param num 求num这个数的根号值
     * @return
     */
    private static double recursion(double a,double b,int num){
        if (b - a < 0.000001){
            return a;
        }
        double mid = (a + b)/2;
        // 如果两数的中点，使得函数值正好为0，那么直接返回mid值
        if ((mid * mid - num) == 0){
            return mid;
        }
        if (isMinus(a,mid,num)) {
            return recursion(a,mid,num);
        }
        return recursion(mid,b,num);
    }

    public static void main(String[] args) {
        System.out.println(getGenHaoValue(2));
        System.out.println(getGenHaoValue(9));
        System.out.println(getGenHaoValue(4));
        System.out.println(getGenHaoValue(16));
        System.out.println(getGenHaoValue(25));
        System.out.println(getGenHaoValue(36));
    }
}
