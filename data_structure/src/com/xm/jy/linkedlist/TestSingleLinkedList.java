package com.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/3 11:18
 * @description: 测试单链表
 */
public class TestSingleLinkedList {
    public static void main(String[] args) {
            SingleLinkedList singleLinkedList = new SingleLinkedList();
            SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//             插入尾部
            singleLinkedList2.add(3);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.add(5);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.add(7);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.add(9);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.add(11);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.add(13);
        System.out.println(singleLinkedList2.size());
            singleLinkedList2.show();
//             按节点值大小插入
            singleLinkedList.addBySort(3);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(5);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(7);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(3);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(2);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(9);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(10);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(1);
            System.out.println(singleLinkedList.size());
            singleLinkedList.addBySort(11);
            System.out.println(singleLinkedList.size());
            singleLinkedList.show();
//             删除尾部节点
/*        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList.delete();
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());*/
//             按照节点值删除
/*            singleLinkedList.deleteByValue(1);
            singleLinkedList.show();
            System.out.println(singleLinkedList.size());
            singleLinkedList.deleteByValue(3);
            singleLinkedList.show();
            System.out.println(singleLinkedList.size());
            singleLinkedList.deleteByValue(9);
            singleLinkedList.show();
            System.out.println(singleLinkedList.size());*/
//             修改尾部节点值
/*        singleLinkedList.update(10);
        singleLinkedList.show();
        singleLinkedList.update(1);
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());*/

            // 翻转单链表
/*            singleLinkedList.reserve();
            singleLinkedList.show();*/

            // 返回单链表倒数第k个节点
//        System.out.println(singleLinkedList.getLastIndexK(3).toString());

            // 逆序打印单链表
//            singleLinkedList.reverseOrderPrint();

            // 合并两个有序单链表
            SingleLinkedList.mergeTwoSingleLinkedList(singleLinkedList,singleLinkedList2).show();
    }
}
