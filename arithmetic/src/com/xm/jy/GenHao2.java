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

    private static double getGenHaoValue(int num){
        double a = 0;
        double b = num;
        return recursion(a,b,num);
    }

    private static double recursion(double a,double b,int num){
        if (b - a < 0.000001){
            return a;
        }
        double mid = (a + b)/2;
        if (isMinus(a,mid,num)) {
            return recursion(a,mid,num);
        }
        return recursion(mid,b,num);
    }

    public static void main(String[] args) {
        System.out.println(getGenHaoValue(2));
        System.out.println(getGenHaoValue(3));
    }
}
