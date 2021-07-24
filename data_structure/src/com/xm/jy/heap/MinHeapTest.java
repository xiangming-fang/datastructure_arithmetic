package com.xm.jy.heap;

import org.junit.Test;

import java.util.Comparator;

public class MinHeapTest {
    @Test
    public void heapTest() throws Exception {
        Comparator<String> comparator = (v1, v2) -> {
            if (v1.compareTo(v2) > 0){
                return 1;
            }
            else if (v1.compareTo(v2) < 0){
                return -1;
            }
            return 0;
        };
        MinHeap<String> heap = new MinHeap<>(comparator);
        heap.enqueue("aa");
        heap.enqueue("cc");
        heap.enqueue("bb");
        heap.enqueue("dd");
        heap.enqueue("ff");
        heap.enqueue("eee");
        System.out.println(heap.toString());
    }
}
