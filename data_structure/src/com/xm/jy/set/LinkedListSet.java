package com.xm.jy.set;

import com.xm.jy.linkedlist.LinkedLists.LinkedList;
import com.xm.jy.utils.FileOperatorUtils;

import java.time.Duration;
import java.time.Instant;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e){
        if (!contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e){
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        java.util.LinkedList<String> words = FileOperatorUtils.getWords("data_structure/pride-and-prejudice.txt");
        LinkedListSet<String>  linkedListSet = new LinkedListSet<>();
        for (String word : words) {
            linkedListSet.add(word);
        }
        System.out.println(linkedListSet.getSize());
        Instant endTime = Instant.now();
        System.out.printf("消耗：%d毫秒\n", Duration.between(startTime,endTime).toMillis());
    }
}
