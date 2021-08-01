package com.xm.jy.stack.my;

import com.xm.jy.array.my.Array;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.stack
 * @ClassName: Stack
 * @Author: albert.fang
 * @Description: 栈
 * @Date: 2021/7/30 18:32
 */
public class Stack<E> {

    private Array<E> array;

    public Stack(){
        array = new Array<>();
    }

    // 入栈
    public void push(E e){
        array.addLast(e);
    }

    // 出栈
    public E pop(){
        return array.removeLast();
    }

    // 替换栈顶元素
    public E replace(E e){
        return array.setLast(e);
    }

    // 返回栈顶元素
    public E peek(){
        return array.getLast();
    }


}
