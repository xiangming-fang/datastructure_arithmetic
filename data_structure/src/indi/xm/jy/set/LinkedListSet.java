package indi.xm.jy.set;

import indi.xm.jy.linkedlist.LinkedLists.LinkedList1;
import indi.xm.jy.utils.FileOperatorUtils;

import java.time.Duration;
import java.time.Instant;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {
    private LinkedList1<E> linkedList1;

    public LinkedListSet(){
        linkedList1 = new LinkedList1<>();
    }

    @Override
    public void add(E e){
        if (!contains(e)) {
            linkedList1.addFirst(e);
        }
    }

    @Override
    public void remove(E e){
        linkedList1.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList1.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList1.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList1.getSize();
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
