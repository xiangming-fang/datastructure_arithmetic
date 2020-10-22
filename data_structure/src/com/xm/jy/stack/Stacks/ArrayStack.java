package com.xm.jy.stack.Stacks;

import com.xm.jy.array.Arrays.dilatation.Array3;

/**
 * @author: albert.fang
 * @date: 2020/10/22 13:16
 * @description: 数组栈，基于动态数组实现
 */
public class ArrayStack<E> implements Stack<E> {

    private Array3<E> array;

    public ArrayStack(int capacity) {
        array = new Array3<E>(capacity);
    }

    public ArrayStack(){
        array = new Array3<E>();
    }

    @Override
    public E pop() throws Exception {
        return array.removeLast();
    }

    @Override
    public E peek() throws Exception {
        return array.getLast();
    }

    @Override
    public void push(E e) throws Exception {
        array.addLast(e);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("栈：[");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("]，top");
        return res.toString();
    }
}
