package indi.xm.jy.stack;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.stack
 * @ClassName: FixedSizeStack
 * @Author: albert.fang
 * @Description: 用数组实现固定大小的栈
 * @Date: 2021/12/2 10:35
 */
public class FixedSizeStack {

    int[] arr;

    // 栈的实际使用大小
    int size = 0;

    public FixedSizeStack(int size){
        if (size <= 0 ){
            throw new RuntimeException("固定大小非法");
        }
        this.arr = new int[size];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == arr.length;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已经为空了，不能pop");
        }
        return arr[--size];
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈中没有元素");
        }
        return arr[size - 1];
    }

    public void push(int e){
        if (isFull()){
            throw new RuntimeException("栈已满，不能再push了");
        }
        arr[size++] = e;
    }
}
class FixedSizeStackTest{

    public static void main(String[] args) {
        FixedSizeStack fixedSizeStack = new FixedSizeStack(10);
        for (int i = 0; i < 10; i++) {
            fixedSizeStack.push(i);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(fixedSizeStack.pop());
        }
    }
}
