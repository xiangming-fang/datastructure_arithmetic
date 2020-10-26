package com.xm.jy.linkedlist.LinkedLists;

/**
 * @author: albert.fang
 * @date: 2020/10/26 10:54
 * @description: 测试链表
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 添加到末尾
        for (int i = 0; i < 3; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
        }
        // 添加到头部
        for (int i = 3; i < 6; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
        }
        // 按index来添加
        linkedList.add(2,2);
        System.out.println(linkedList + " 链表大小：" + linkedList.getSize());

        // 修改链表值
        for (int i = 0; i < linkedList.getSize(); i++) {
            linkedList.set(i,i);
            System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
        }

        // 得到链表的值
        System.out.println(linkedList.get(linkedList.getSize() - 1));

        // 删除链表头结点
        for (int i = 0; i < 3; i++) {
            linkedList.removeFirst();
            System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
        }

        // 删除链表尾节点
        for (int i = 0; i < 2; i++) {
            linkedList.removeLast();
            System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
        }

        // 删除指定索引节点
        linkedList.remove(1);
        System.out.println(linkedList + " 链表大小：" + linkedList.getSize());
    }
}
