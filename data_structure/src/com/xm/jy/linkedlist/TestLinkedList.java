package com.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/3 11:18
 * @description: 测试单链表
 */
public class TestLinkedList {
    public static void main(String[] args) {
            LinkedList linkedList = new LinkedList();
            linkedList.show();
            // 插入尾部
        linkedList.add(3);
        System.out.println(linkedList.size());
        linkedList.add(5);
        System.out.println(linkedList.size());
        linkedList.add(7);
        System.out.println(linkedList.size());
        linkedList.add(2);
        System.out.println(linkedList.size());
        linkedList.add(9);
        System.out.println(linkedList.size());
        linkedList.add(9);
        System.out.println(linkedList.size());
        linkedList.show();
            // 按节点值大小插入
//            linkedList.addBySort(3);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(5);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(7);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(3);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(2);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(9);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(10);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(1);
//            System.out.println(linkedList.size());
//            linkedList.addBySort(11);
//            System.out.println(linkedList.size());
//            linkedList.show();
            // 删除尾部节点
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
//        linkedList.delete();
//        linkedList.show();
//        System.out.println(linkedList.size());
            // 按照节点值删除
//            linkedList.deleteByValue(1);
//            linkedList.show();
//            System.out.println(linkedList.size());
//            linkedList.deleteByValue(3);
//            linkedList.show();
//            System.out.println(linkedList.size());
//            linkedList.deleteByValue(9);
//            linkedList.show();
//            System.out.println(linkedList.size());
            // 修改尾部节点值
//        linkedList.update(10);
//        linkedList.show();
//        linkedList.update(1);
//        linkedList.show();
//        System.out.println(linkedList.size());
    }
}
