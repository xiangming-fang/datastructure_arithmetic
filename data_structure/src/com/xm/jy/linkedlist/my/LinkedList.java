package com.xm.jy.linkedlist.my;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.linkedlist
 * @ClassName: LinkedList
 * @Author: albert.fang
 * @Description: 链表
 * @Date: 2021/8/1 12:44
 */
public class LinkedList<E> {

    private Node<E> dummyHead = new Node<>();

    private int size;

    private class Node<E>{

        private E e;

        private Node<E> next;

        Node(){

        }

        public Node(E e,Node<E> next){
            this.e = e;
            this.next = next;
        }
    }

    public LinkedList(){

    }

    // 在指定索引位置增加一个节点
    public void add(int index,E e){
        rangeCheckForAdd(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node<E> next = cur.next;
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
    public E remove(int index){
        rangeCheck(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node<E> waitDeleteNode = cur.next;
        // 待删除节点前一个节点指向 待删除节点之后的节点
        cur.next = cur.next.next;
        size --;
        return waitDeleteNode.e;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    // 修改指定索引的节点值
    public void set(int index,E e){
        rangeCheck(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public void setLast(E e){
        set(size-1,e);
    }

    public void setFirst(E e){
        set(0,e);
    }

    // 得到指定索引的节点值
    public E get(int index){
        rangeCheck(index);
        Node<E> cur = dummyHead;
        for (int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
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
