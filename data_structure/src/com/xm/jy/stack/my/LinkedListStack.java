package com.xm.jy.stack.my;


import com.xm.jy.linkedlist.my.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.stack.my
 * @ClassName: LinkedListStack
 * @Author: albert.fang
 * @Description: 链表实现栈
 * @Date: 2021/8/1 13:53
 */
public class LinkedListStack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    // 入栈
    public void push(E e){
        list.addLast(e);
    }

    // 出栈
    public E pop(){
        return list.removeLast();
    }

    // 替换栈顶元素
    public void replace(E e){
        list.setLast(e);
    }

    // 返回栈顶元素
    public E peek(){
        return list.getLast();
    }
}
