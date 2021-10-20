package indi.xm.jy.map.my;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.linkedlist
 * @ClassName: LinkedList
 * @Author: albert.fang
 * @Description: 链表
 * @Date: 2021/8/1 12:44
 */
public class LinkedList<K extends Comparable<K>,V> implements List<K,V>{

    private Node<K,V> dummyHead = new Node<>();

    private int size;

    private class Node<K,V>{

        private K key;

        private V value;

        private Node<K,V> next;

        Node(){

        }

        Node(K key,V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList(){

    }

    // 增加一个节点，如果key已存在，那么不增加
    @Override
    public void add(K key,V value){
        if (!contains(key)){
            Node<K,V> cur = dummyHead;
            cur.next = new Node<>(key, value, cur.next);
            size ++;
        }
    }

    // 根据指定key移除节点
    @Override
    public V remove(K key){
        // 1、先判断是否存在这个节点
        if (contains(key)){
            Node<K,V> cur = dummyHead;
            // 2、找到这个节点的前一个节点
            while (key.compareTo(cur.next.key) != 0){
                cur = cur.next;
            }
            // 3、断链
            Node<K,V> wd = cur.next;
            cur.next = wd.next;
            wd.next = null;
            size --;
            return wd.value;
        }
        return null;
    }

    // 根据key修改指定节点的值
    // 节点不存在报错
    @Override
    public void set(K key,V value){
        if (contains(key)){
            Node<K,V> cur = dummyHead.next;
            while (cur.key.compareTo(key) != 0){
                cur = cur.next;
            }
            cur.value = value;
        }
        else {
            throw new RuntimeException("不存在key " + key);
        }
    }

    // 根据key返回指定value
    // key 不存在抛出异常
    @Override
    public V get(K key){
        if (contains(key)){
            Node<K,V> cur = dummyHead.next;
            while (cur.key.compareTo(key) != 0){
                cur = cur.next;
            }
            return cur.value;
        }
        else {
            throw new RuntimeException("不存在key " + key);
        }
    }

    // 查看链表是否包含这个key
    @Override
    public boolean contains(K key){
        Node<K,V> cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
            if (key.compareTo(cur.key) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        if (!isEmpty()){
            Node<K,V> cur = this.dummyHead;
            StringBuilder result = new StringBuilder();
            result.append("【");
            for (int i = 0; i < size; i++) {
                result.append("< ").append(cur.next.key).append(" , ").append(cur.next.value).append(" >");
                if (i != size - 1){
                    result.append(" ");
                }
                cur = cur.next;
            }
            result.append("】");
            return result.toString();
        }
        return null;
    }

    // 辅助方法 —— 是否是空链表
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    // 辅助方法 —— 链表长度
    @Override
    public int getSize(){
        return size;
    }
}
