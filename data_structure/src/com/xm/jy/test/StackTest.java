package com.xm.jy.test;

import com.xm.jy.stack.my.LinkedListStack;
import com.xm.jy.stack.my.Stack;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: StackTest
 * @Author: albert.fang
 * @Description: 栈测试
 * @Date: 2021/7/30 18:43
 */
public class StackTest {

    @Test
    public void pushAndPopTest(){
        Stack<String> stack = new Stack<>();
        stack.push("34234");
        stack.push("342adf34");
        stack.push("asdfdasf");
        stack.push("asdfasdf");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void replaceAndpeekTest(){
        Stack<String> stack = new Stack<>();
        stack.push("asdfds");
        stack.push("23412");
        stack.push("dgfdfg");
        stack.push("324234");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.replace("fxm");
        System.out.println(stack.peek());
    }

    @Test
    public void pushAndPopLinkedListTest(){
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("34234");
        stack.push("342adf34");
        stack.push("asdfdasf");
        stack.push("asdfasdf");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void replaceAndpeekLinkedListTest(){
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("asdfds");
        stack.push("23412");
        stack.push("dgfdfg");
        stack.push("324234");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.replace("fxm");
        System.out.println(stack.peek());
    }
}
