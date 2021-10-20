package indi.xm.jy.stack.Stacks;

import indi.xm.jy.linkedlist.LinkedLists.LinkedList1;

/**
 * @author: albert.fang
 * @date: 2020/10/26 13:10
 * @description: 依赖于自己实现的链表来实现栈
 */
public class LinkedListStack<E extends Comparable<E>> implements Stack<E> {

    private LinkedList1<E> linkedList1;

    public LinkedListStack(LinkedList1 linkedList1) {
        this.linkedList1 = linkedList1;
    }

    public LinkedListStack() {
        this.linkedList1 = new LinkedList1<>();
    }

    @Override
    public E pop() throws Exception {
        return linkedList1.removeFirst();
    }

    @Override
    public E peek() throws Exception {
        return linkedList1.get(0);
    }

    @Override
    public void push(E e) throws Exception {
        linkedList1.addLast(e);
    }

    @Override
    public int getSize() {
        return linkedList1.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList1.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("栈顶：");
        ret.append(linkedList1);
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
