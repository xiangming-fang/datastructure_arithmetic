package com.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/3 10:01
 * @description: 单链表的实现
 */
public class LinkedList {
    
    private Node node;
    
    private Integer size = 0;

    public LinkedList(){

    }
    
    private static class Node{
        private Integer value;
        private Node next;
        public Node(Integer value,Node next){
            this.value = value;
            this.next = next;
        }
        public Node(){

        }
    }
    // 下面实现链表的增删改查

    // 在链表尾部增加结点
    public void add(Integer value){
        Node node = new Node(value,null);
        Node p = this.node;
        while (true){
            if (p == null){
                this.node = node;
                size ++;
                break;
            }
            if (p.next == null){
                p.next = node;
                size ++;
                break;
            }
            p = p.next;
        }
    }

    // 按节点值大小进行插入，比如原先链表为 1->3->7，现在要插入一个节点值为5的节点，插入后的结果为 1->3->5->7
    public void addBySort(Integer value){
        Node node = new Node(value,null);
        Node p = this.node;
        while (true){
            if (p == null){
                this.node = node;
                size ++;
                break;
            }
            if (p.next == null){
                p.next = node;
                size ++;
                break;
            }
            if (p.value > node.value){
                node.next = p;
                this.node = node;
                size ++;
                break;
            }
            if (p.value.equals(node.value)){
                System.out.println("要插入的节点值已存在链表中");
                break;
            }
            if (p.next.value > node.value){
                // 先用新节点指向后面那个节点,先后——后前
                node.next = p.next;
                p.next = node;
                size ++;
                break;
            }
            if (p.next.value.equals(node.value)){
                System.out.println("要插入的节点值已存在链表中");
                break;
            }
            p = p.next;
        }
    }

    // 删除链表末尾节点
    public void delete(){
        Node temp = new Node();
        temp.next = this.node;
        Node fast = temp;
        Node slow = temp;
        fast = fast.next.next;
        while (true){
            if (fast == null){
                slow.next = null;
                // 如果链表长度是1的话，那么将this.node置于null
                if (size == 1){
                    this.node = null;
                }
                size --;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }

    // 按节点值删除指定节点
    public void deleteByValue(Integer value){
        Node p = this.node;
        if (p.next == null){
            return;
        }
        if (p.value.equals(value)){
            this.node = p.next;
            size --;
            return;
        }
        while (true){
            if (p.next == null){
                break;
            }
            if (p.next.value.equals(value)){
                p.next = p.next.next;
                size --;
                break;
            }
            p = p.next;
        }
    }

    // 改变最后一个节点的值
    public void update(Integer value){
        Node p = this.node;
        if (p == null){
            return;
        }
        while (true){
            if (p.next == null){
                p.value = value;
                break;
            }
            p = p.next;
        }
    }

    // 打印链表
    public void show(){
        Node q = this.node;
        if (q == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            System.out.print(q.value);
            if (q.next == null){
                break;
            }
            System.out.print("->");
            q = q.next;
        }
        System.out.println();
    }

    // 得到链表长度
    public int size(){
        return size;
    }
}
