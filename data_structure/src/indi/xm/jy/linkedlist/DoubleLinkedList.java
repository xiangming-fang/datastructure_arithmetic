package indi.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/10 16:57
 * @description: 双向链表的实现
 */
public class DoubleLinkedList {
    static class Node{
        private Integer value;
        private Integer no;
        private Node next;
        private Node pre;
        public Node(Integer no,Integer value,Node next,Node pre){
            this.no = no;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
        public Node(Integer no,Integer value){
            this.no = no;
            this.value = value;
        }
        public Node(){

        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", no=" + no +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }

    // 给一个头结点
    private static Node head = new Node();

    // 返回头结点
    public Node getHead(){
        return head;
    }

    // 在双向链表尾部增加结点
    public void addNode(Node node){
        if (node == null){
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        node.pre = p;
    }

    // 在双向链表中按节点编号大小顺序增加
    public void addNodeBySort(Node node){
        if (node == null){
            return;
        }
        Node p = head;
        if (p.next == null){
            p.next = node;
            node.pre = p;
            return;
        }
        while (true){
            // 到最后了
            if (p.next == null){
                p.next = node;
                node.pre = p;
                break;
            }
            if (p.next.no >= node.no){
                node.next = p.next;
                p.next.pre = node;
                p.next = node;
                node.pre = p;
                break;
            }
            p = p.next;
        }
    }

    // 按编号删除双向链表中的节点
    public void delete(Node node){
        if (node == null){
            return;
        }
        Node p = head;
        // 只有一个头结点的话，直接返回
        if (p.next == null){
            return;
        }
        while (true){
            p = p.next;
            // 到最后了
            if (p == null){
                break;
            }
            if (p.no.equals(node.no)){
                if (p.next != null){
                    p.next.pre = p.pre;
                }
                p.pre.next = p.next;
            }
        }
    }

    // 按编号更新链表中的节点
    public void update(Node node){
        if (node == null){
            return;
        }
        Node p = head;
        // 只有一个头结点
        if (p.next == null){
            return;
        }
        while (true){
            p = p.next;
            // 到最后了
            if (p == null){
                break;
            }
            if (p.no.equals(node.no)){
                p.value = node.value;
            }
        }
    }

    // 遍历双向链表
    public void show(){
        Node p = head.next;
        if (p == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if (p == null){
                break;
            }
            System.out.println("节点编号："+p.no + "  节点值：" + p.value);
            p = p.next;
        }
    }
}
