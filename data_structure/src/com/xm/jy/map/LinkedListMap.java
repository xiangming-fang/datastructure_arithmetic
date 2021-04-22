package com.xm.jy.map;


import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import com.xm.jy.utils.FileOperatorUtils;

/**
 * @author: albert.fang
 * @date: 2021/4/21 12:08
 * @description: 基于链表实现 映射
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private Node dummyHead;
    private int size;
    private class Node{
        K key;
        V value;
        Node next;
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(){
            this(null,null,null);
        }
    }

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    public Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.key.equals(key)){
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public void add(K key,V value){
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }
        else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key){
        Node node = getNode(key);
        if (node != null){
            Node pre = dummyHead;
            while (pre.next != null){
                if (pre.next.key.equals(key)){
                    break;
                }
                pre = pre.next;
            }
            if (pre.next != null){
                Node delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
                size --;
            }
            return node.value;
        }
        return null;
    }

    @Override
    public void set(K key,V value){
        Node node = getNode(key);
        if (node != null){
            node.value = value;
        }
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        if (node != null){
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        Node node = getNode(key);
        return node != null;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        while (cur != null){
            sb.append(cur.key).append(" : ").append(cur.value);
            sb.append("\n");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Instant startTime = Instant.now();
        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        LinkedList<String> wordsList = FileOperatorUtils.getWords("data_structure/pride-and-prejudice.txt");
        System.out.printf("pride-and-prejudice words total ： %d\n" ,wordsList.size());
        for (String temp : wordsList) {
            if (linkedListMap.contains(temp)) {
                linkedListMap.set(temp,linkedListMap.get(temp) + 1);
            }
            else {
                linkedListMap.add(temp,1);
            }
        }
        System.out.printf("不重复的有：%d个\n",linkedListMap.getSize());
        System.out.println("pride occur times is " + linkedListMap.get("pride"));
        System.out.println("prejudice occur times is " + linkedListMap.get("prejudice"));
        System.out.println("\"\" occur times is " + linkedListMap.get(""));
        System.out.println("them occur times is " + linkedListMap.get("them"));
        linkedListMap.remove("");
        System.out.println(linkedListMap.getSize());
        System.out.printf("消耗 %d 毫秒",Duration.between(startTime,Instant.now()).toMillis());
    }
}
