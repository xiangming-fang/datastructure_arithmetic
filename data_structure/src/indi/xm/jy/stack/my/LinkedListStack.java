package indi.xm.jy.stack.my;


import indi.xm.jy.linkedlist.my.LinkedList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.stack.my
 * @ClassName: LinkedListStack
 * @Author: albert.fang
 * @Description: 链表实现栈
 * @Date: 2021/8/1 13:53
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    // 入栈
    @Override
    public void push(E e){
        list.addFirst(e);
    }

    // 出栈
    @Override
    public E pop(){
        return list.removeFirst();
    }

    // 替换栈顶元素
    @Override
    public E replace(E e){
        return list.setFirst(e);
    }

    // 返回栈顶元素
    @Override
    public E peek(){
        return list.getFirst();
    }
}
