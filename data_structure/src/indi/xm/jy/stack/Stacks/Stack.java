package indi.xm.jy.stack.Stacks;

/**
 * @author: albert.fang
 * @date: 2020/10/22 13:13
 * @description: 接口：栈
 */
public interface Stack<E> {
    E pop() throws Exception;
    E peek() throws Exception;
    void push(E e) throws Exception;
    int getSize();
    boolean isEmpty();
}
