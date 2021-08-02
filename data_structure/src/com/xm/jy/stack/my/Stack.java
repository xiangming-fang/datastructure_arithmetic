package com.xm.jy.stack.my;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.stack.my
 * @ClassName: Stack
 * @Author: albert.fang
 * @Description: 栈接口
 * @Date: 2021/8/2 9:38
 */
public interface Stack<E> {

    // 入栈
    public void push(E e);

    // 出栈
    public E pop();

    // 替换栈顶元素
    public E replace(E e);

    // 返回栈顶元素
    public E peek();
}
