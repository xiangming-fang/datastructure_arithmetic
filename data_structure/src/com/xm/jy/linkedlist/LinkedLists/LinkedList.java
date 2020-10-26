package com.xm.jy.linkedlist.LinkedLists;

/**
 * @author: albert.fang
 * @date: 2020/10/26 10:05
 * @description: 实现链表
 */
public class LinkedList<E> implements List<E> {


    // 虚拟头结点，不存储元素值，只是用来使添加和删除的逻辑一致
    private Node dummyHead = new Node();

    private int size;

    // 内部私有节点类（用户不能操作这个内部私有类）
    private class Node{

        E e;
        Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null,null);
        }

        public Node(E e){
            this(e,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public void add(int index, E e) {
        if (size < index || index < 0)
            throw new IllegalArgumentException("add failed,index is illegal");
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++)
            prev = prev.next;
        prev.next = new Node(e,prev.next);
        size ++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (size < index || index < 0)
            throw new IllegalArgumentException("delete failed,index is illegal");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        // 方便JVM回收
        delNode.next = null;
        size --;
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        remove(size - 1);
    }

    @Override
    public void set(int index, E e) {
        if (size <= index || index < 0)
            throw new IllegalArgumentException("set failed,index is illegal");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    @Override
    public E get(int index) {
        if (size <= index || index < 0)
            throw new IllegalArgumentException("get failed,index is illegal");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList：");
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur.e.toString()).append(" -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
