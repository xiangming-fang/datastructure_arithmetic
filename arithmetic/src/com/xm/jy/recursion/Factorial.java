package com.xm.jy.recursion;

/**
 * @author: albert.fang
 * @date: 2020/8/31 17:18
 * @description: 阶乘打印
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
