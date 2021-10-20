package indi.xm.jy.stack;


/**
 * @author: albert.fang
 * @date: 2020/8/3 13:45
 * @description: 用数组实现栈的数据结构，FILO
 */
public class StackByArray {
    private static class Stack {
        // 指针，初始为-1
        private int top;
        // 数组栈的大小
        private int maxSize;
        // 用于存储数值的数组
        private int[] stackArray;
        public Stack(){

        }
        public Stack(int maxSize){
            this.maxSize = maxSize;
            this.stackArray = new int[maxSize];
            this.top = -1;
        }
        // 下面实现判断栈是否为满/空的操作
        // 是否满
        public boolean isFull(){
            return top == maxSize - 1;
        }

        // 是否空
        public boolean isEmpty(){
            return top == -1;
        }

        // 下面实现入栈、出栈操作

        // 入栈
        public void push(int value){
            if (isFull()){
                System.out.println("栈是满的，压入不了了");
                return;
            }
            top++;
            stackArray[top] = value;
        }

        // 出栈
        public int pop(){
            if (isEmpty()){
                throw new RuntimeException("栈是空的，没有数据出栈");
            }
            int tempValue = top;
            top --;
            return stackArray[tempValue];
        }

        // 遍历栈
        public void show(){
            for (int i : stackArray) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();
        stack.push(7);
        stack.push(8);
        stack.show();
        stack.push(9);
        System.out.println(stack.pop());
        stack.show();
        stack.push(9);
        stack.show();
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }
        stack.show();
        stack.push(666);
        stack.show();
    }

}
