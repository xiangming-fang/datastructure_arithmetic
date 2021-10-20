package indi.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/10 18:00
 * @description: 测试双向链表
 */
public class TestDoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleLinkedList.Node node1 = new DoubleLinkedList.Node(1,1);
        DoubleLinkedList.Node node2 = new DoubleLinkedList.Node(2,2);
        DoubleLinkedList.Node node3 = new DoubleLinkedList.Node(3,3);
        DoubleLinkedList.Node node4 = new DoubleLinkedList.Node(4,4);
        DoubleLinkedList.Node node5 = new DoubleLinkedList.Node(5,5);
        DoubleLinkedList.Node node6 = new DoubleLinkedList.Node(6,6);
        // 往双向链表末尾增加节点
        System.out.println("往双向链表末尾增加节点");
        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);
        doubleLinkedList.addNode(node6);
        doubleLinkedList.show();
        // 按编号大小顺序来增加
        System.out.println("按编号大小顺序来增加");
        doubleLinkedList.addNodeBySort(node5);
        doubleLinkedList.show();
        // 按编号来删除
        System.out.println("按编号来删除");
        doubleLinkedList.delete(node3);
        doubleLinkedList.show();
        // 按编号来修改节点
        System.out.println("按编号修改节点");
        DoubleLinkedList.Node node = new DoubleLinkedList.Node(5,55);
        doubleLinkedList.update(node);
        doubleLinkedList.show();
    }
}
