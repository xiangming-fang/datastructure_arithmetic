package indi.xm.jy.map.my;

/**
 * @author: albert.fang
 * @date: 2020/10/26 10:08
 * @description: 链表接口
 */
public interface List<K,V>{

    void add(K key,V value);

    V remove(K key);

    void set(K key,V value);

    V get(K key);

    boolean contains(K key);

    // 链表是否为空
    boolean isEmpty();

    int getSize();
}
