package indi.xm.jy.stack.my;

import indi.xm.jy.array.my.Array;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.stack
 * @ClassName: ArrayStack
 * @Author: albert.fang
 * @Description: 栈
 * @Date: 2021/7/30 18:32
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(){
        array = new Array<>();
    }

    // 入栈
    @Override
    public void push(E e){
        array.addLast(e);
    }

    // 出栈
    @Override
    public E pop(){
        return array.removeLast();
    }

    // 替换栈顶元素
    @Override
    public E replace(E e){
        return array.setLast(e);
    }

    // 返回栈顶元素
    @Override
    public E peek(){
        return array.getLast();
    }
}
