package com.xm.jy.stack.Stacks;

/**
 * @author: albert.fang
 * @date: 2020/10/22 13:29
 * @description: 主函数，测试用
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack.toString());
        }
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
    }
}
