package indi.xm.jy.stack;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.stack
 * @ClassName: CanGetMinValueStack
 * @Author: albert.fang
 * @Description: 实现一个栈，可以得到此时栈中的最小元素
 * push(2,3,2,3) 每个时刻的最小值应该是 min(2,2,2,2)
 * @Date: 2021/12/2 17:11
 */
public class CanGetMinValueStack {

    Stack<Integer> dataStack = new Stack<>();

    Stack<Integer> minStack = new Stack<>();

    public void push(int value){
        dataStack.push(value);
        if (minStack.isEmpty()){
            minStack.push(value);
        }else {
            Integer curMin = minStack.peek();
            // 当前进来的值和最小值栈的栈顶元素进行比较
            // 如果栈顶元素小于当前进来的值，那么对其再次入栈
            minStack.push(curMin < value ? curMin : value);
        }
    }

    public int pop(){
        // 最小值栈，跟随者一同出栈，但是不返回
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin(){
        // 查看此时栈中最小元素
        return minStack.peek();
    }

    @Test
    public void test(){
        CanGetMinValueStack stack = new CanGetMinValueStack();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(1000);
            stack.push(num);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("当前最小值 " + stack.getMin());
            System.out.println(stack.pop());
        }
    }
}
