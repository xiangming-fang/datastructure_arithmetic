package indi.xm.jy.queue;

import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2020/7/31 15:05
 * @description: 用数组实现环形队列
 */
public class CircleQueueByArray {

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
         * 队首指针，指向实际队首元素
         */
        private int front;

        /**
         * 队尾指针，指向实际队尾元素的下一个
         */
        private int rear;

        private int[] queue;

        private int maxSize;

        public Queue(int maxSize){
            this.maxSize = maxSize;
            this.queue = new int[maxSize];
            this.front = 0;
            this.rear = 0;
        }

        /**
         * 判断队列是否已满
         * @return
         */
        public boolean isFull(){
            // 为什么rear + 1 % maxSize == front就可以判断是否为空？
            // 画个图，对着图认着思考就会有答案了。
            return (rear + 1)%maxSize == front;
        }

        /**
         * 判断队列是否为空
         * @return
         */
        public boolean isEmpty(){
            return rear == front;
        }

        public void add(int value){
            int index = rear;
            if (isFull()){
                System.out.println("队列已满，不允许添加~~~");
                return;
            }
            rear = (rear + 1) % maxSize;
            queue[index] = value;
        }

        public int get(){
            int index = front;
            if (isEmpty()){
                System.out.println("空队列~~~");
                throw new RuntimeException("空队列不允许获取");
            }
            front = (front + 1) % maxSize;
            return queue[index];
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
