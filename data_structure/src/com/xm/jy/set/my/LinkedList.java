package com.xm.jy.set.my;

import com.xm.jy.linkedlist.LinkedLists.List;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.linkedlist
 * @ClassName: LinkedList
 * @Author: albert.fang
 * @Description: 链表
 * @Date: 2021/8/1 12:44
 */
public class LinkedList<E extends Comparable<E>> implements List<E> {

    private Node<E> dummyHead = new Node<>();

    private int size;

    private class Node<E>{

        private E e;

        private Node<E> next;

        Node(){

        }

        Node(E e, Node<E> next){
            this.e = e;
            this.next = next;
        }
    }

    public LinkedList(){

    }

    // 在指定索引位置增加一个节点
    @Override
    public void add(int index,E e){
        // 1、校验索引的合法性
        rangeCheckForAdd(index);

        // 2、校验是否已经包含了这个元素，已经包含不添加
        if (contains(e)) {
            return;
        }
        // 3、找到index - 1位置的节点
        Node<E> cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node<E> next = cur.next;
        // 4、将index - 1的节点next指向新节点
        // 注意在创建新节点的时候，传入了新节点的next节点
        cur.next = new Node<>(e, next);
        size ++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    // 删除指定索引的节点,返回删除节点的值
    @Override
    public E remove(int index){
        // 1、index合法性校验
        rangeCheck(index);
        // 2、找到index - 1 位置的索引
        Node<E> cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node<E> waitDeleteNode = cur.next;
        // 3、index - 1位置的next指向之前的next的next。
        // 待删除节点前一个节点指向 待删除节点之后的节点
        cur.next = waitDeleteNode.next;
        // 4、修改waitDeleteNode节点next指向null，方便GC回收
        waitDeleteNode.next = null;
        size --;
        return waitDeleteNode.e;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    public void remove(E e){
        // 1、先判断是否存在这个节点
        if (contains(e)){
            Node<E> cur = dummyHead;
            // 2、找到这个节点的前一个节点
            while (e.compareTo(cur.next.e) != 0){
                cur = cur.next;
            }
            // 3、断链
            Node<E> wd = cur.next;
            cur.next = wd.next;
            wd.next = null;
            size --;
        }
    }

    // 修改指定索引的节点值
    @Override
    public void set(int index,E e){
        // 1、index合法性校验
        rangeCheck(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        // 2、修改index节点值
        cur.e = e;
    }

    public void setLast(E e){
        set(size - 1, e);
    }

    public void setFirst(E e){
        set(0, e);
    }

    // 得到指定索引的节点值
    @Override
    public E get(int index){
        // 1、index合法性校验
        rangeCheck(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        // 2、返回index位置的节点值
        return cur.e;
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    // 查看是否包含这个元素
    @Override
    public boolean contains(E e){
        Node<E> cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
            if (e.compareTo(cur.e) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        if (!isEmpty()){
            Node<E> cur = this.dummyHead;
            StringBuilder result = new StringBuilder();
            result.append("【");
            for (int i = 0; i < size; i++) {
                result.append(cur.next.e);
                if (i != size - 1){
                    result.append(",");
                }
                cur = cur.next;
            }
            result.append("】");
            return result.toString();
        }
        return null;
    }

    // 辅助方法 —— 是否是空链表
    public boolean isEmpty(){
        return size == 0;
    }

    // 辅助方法 —— 链表长度
    public int getSize(){
        return size;
    }

    // 辅助方法 —— 执行按索引删除、修改、查询节点的时候，判断索引的合法性
    private void rangeCheck(int index){
        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("链表索引不合法 " + index);
        }
    }

    // 辅助方法 —— 执行按索引位置新增节点是判断索引合法性
    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("链表索引不合法 " + index);
        }
    }
}
