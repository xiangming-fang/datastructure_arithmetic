package indi.xm.jy.stack.Stacks;

import java.util.Random;

/**
 * @author: albert.fang
 * @date: 2020/10/22 13:29
 * @description: 主函数，测试用
 */
public class Main {
    // 测试两种栈的实现方式
    private static void testStack(Stack<Integer> stack,int countOp) throws Exception {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < countOp; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < countOp; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/10000000.0);
    }
    public static void main(String[] args) throws Exception {
        int countOp = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        testStack(arrayStack,countOp);
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        testStack(linkedListStack,countOp);
    }
}
