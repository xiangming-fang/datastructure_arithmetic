package com.xm.jy.queue;

import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2020/7/31 14:06
 * @description: 用数组实现一个队列：这个队列只能使用一次，前面空出的元素会造成使用不了的情况。这里使用用数组实现环形队列解决
 */
public class QueueByArray {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("a(add)添加");
            System.out.println("g(get)获取");
            System.out.println("q(queryAll)遍历队列");
            System.out.println("e(exit)退出");
            String next = scanner.next();
            switch(next){
                case "a":
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case "g":
                    int obtain = queue.get();
                    System.out.println("得到：" + obtain);
                    break;
                case "q":
                    queue.queryAll();
                    break;
                case "e":
                    flag = false;
                    System.out.println("退出");
                    break;
                default:
                    break;
            }
        }
    }

    static class Queue {

        /**
         * 队首指针，指向实际队首元素前一个位置
         */
        private int front;

        /**
         * 队尾指针，指向实际队尾元素
         */
        private int rear;

        private int[] queue;

        private int maxSize;

        public Queue(int maxSize){
            this.maxSize = maxSize;
            this.queue = new int[maxSize];
            this.front = -1;
            this.rear = -1;
        }

        /**
         * 判断队列是否已满
         * @return
         */
        public boolean isFull(){
            return rear == maxSize - 1;
        }

        /**
         * 判断队列是否为空
         * @return
         */
        public boolean isEmpty(){
            return rear == front;
        }

        public void add(int value){
            if (isFull()){
                System.out.println("队列已满，不允许添加~~~");
                return;
            }
            rear ++;
            queue[rear] = value;
        }

        public int get(){
            if (isEmpty()){
                System.out.println("空队列~~~");
                throw new RuntimeException("空队列不允许获取");
            }
            front ++;
            return queue[front];
        }

        /**
         * 遍历当前queue
         */
        public void queryAll(){
            for (int q : queue) {
                System.out.print(q + " ");
            }
            System.out.println();
        }

    }
}

