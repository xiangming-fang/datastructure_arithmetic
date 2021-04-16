package com.xm.jy.stack.Stacks;

import com.xm.jy.linkedlist.LinkedLists.LinkedList;

/**
 * @author: albert.fang
 * @date: 2020/10/26 13:10
 * @description: 依赖于自己实现的链表来实现栈
 */
public class LinkedListStack<E extends Comparable<E>> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public LinkedListStack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public E pop() throws Exception {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() throws Exception {
        return linkedList.get(0);
    }

    @Override
    public void push(E e) throws Exception {
        linkedList.addLast(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("栈顶：");
        ret.append(linkedList);
        ret.append(" 栈底");
        return ret.toString();
    }

    public static void main(String[] args) throws Exception {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        // 入栈
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        // 出栈
        for (int i = 0; i < 7; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }
}
