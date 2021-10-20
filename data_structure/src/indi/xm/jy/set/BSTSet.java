package indi.xm.jy.set;

import indi.xm.jy.bst.BST;
import indi.xm.jy.utils.FileOperatorUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

// 利用BST构建集合
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bstSet;

    public BSTSet(){
        bstSet = new BST<>();
    }

    @Override
    public void add(E e){
        bstSet.add(e);
    }

    @Override
    public void remove(E e){
        bstSet.removeElement(e);
    }

    @Override
    public boolean contains(E e){
        return bstSet.contains(e);
    }

    @Override
    public boolean isEmpty(){
        return bstSet.isEmpty();
    }

    @Override
    public int getSize(){
        return bstSet.getSize();
    }

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        LinkedList<String> words = FileOperatorUtils.getWords("data_structure/pride-and-prejudice.txt");
        BSTSet<String>  bstSet = new BSTSet<>();
        for (String word : words) {
            bstSet.add(word);
        }
        System.out.println(bstSet.getSize());
        Instant endTime = Instant.now();
        System.out.printf("消耗：%d毫秒\n", Duration.between(startTime,endTime).toMillis());
    }
}
