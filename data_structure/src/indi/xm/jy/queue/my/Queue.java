package indi.xm.jy.queue.my;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.queue.my
 * @ClassName: Queue
 * @Author: albert.fang
 * @Description: 队列
 * @Date: 2021/8/2 9:34
 */
public interface Queue<E> {

    // 入队
    public void offer(E e);

    // 出队
    public E poll();

    // 替换队首元素
    public E replace(E e);

    // 偷偷看一眼队首元素
    public E peek();

}
