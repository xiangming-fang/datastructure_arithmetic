package indi.xm.jy.linkedlist.LinkedLists;

/**
 * @author: albert.fang
 * @date: 2020/10/26 10:08
 * @description: 链表接口
 */
public interface List<E>{
    // 在节点具体索引加入节点值为e的节点（不常用，但是经常用于练习使用）
    void add(int index,E e);

    // 判断链表中是否包含值为e的节点
    boolean contains(E e);

    // 移除指定索引的节点（不常用，但是经常用于练习使用）
    E remove(int index);

    // 修改指定索引的节点（不常用，但是经常用于练习使用）
    void set(int index,E e);

    // 查找指定索引的节点（不常用，但是经常用于练习使用）
    E get(int index);

    // 链表是否为空
    boolean isEmpty();
}
