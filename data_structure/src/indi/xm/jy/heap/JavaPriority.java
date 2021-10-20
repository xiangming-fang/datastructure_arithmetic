package indi.xm.jy.heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.heap
 * @ClassName: JavaPriority
 * @Author: albert.fang
 * @Description: Java 中的堆
 * @Date: 2021/7/22 15:32
 */
public class JavaPriority {
    public static void main(String[] args) {
        List<Integer> collect = new LinkedList<>();
        collect.add(23);
        collect.add(26);
        collect.add(52);
        collect.add(86);
        collect.add(99);
        collect.add(13);
        Comparator<Integer> comparator = (o1, o2) -> {
            if (o1 > o2){
                return -1;
            }
            else if (o2 > o1){
                return 1;
            }
            return 0;
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(16, comparator);
        heap.addAll(collect);
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heap.poll());
        }
    }
}
