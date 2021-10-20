package indi.xm.jy.linkedlist;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/3 10:01
 * @description: 单链表的实现
 */
public class SingleLinkedList {
    
    private Node node;
    
    private Integer size = 0;

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

    public SingleLinkedList(){

    }

    public SingleLinkedList(Node node){
        this.node = node;
    }
    
    static class Node{
        private Integer value;
        private Node next;
        public Node(Integer value,Node next){
            this.value = value;
            this.next = next;
        }
        public Node(){

        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
    // 下面实现链表的增删改查

    // 在链表尾部增加结点
    public void add(Integer value){
        Node node = new Node(value,null);
        Node p = this.node;
        if (p == null){
            this.node = node;
            size ++;
            return;
        }
        while (true){
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
        if (p == null){
            this.node = node;
            size ++;
            return;
        }
        if (p.value > node.value){
            node.next = p;
            this.node = node;
            size ++;
            return;
        }
        if (p.value.equals(node.value)){
            System.out.println("要插入的节点值已存在链表中");
            return;
        }
        while (true){
            if (p.next == null){
                p.next = node;
                size ++;
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
        if (p == null){
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

    // 翻转单链表
    public void reserve(){
        if (this.node == null){
            System.out.println("链表为空");
            return;
        }
        // 创建一个辅助变量
        Node helper = new Node();

        // 遍历this.node
        Node p = this.node;
        while (true){
            Node next = p.next;
            p.next = helper.next;
            helper.next = p;
            p = next;
            if (p == null){
                break;
            }
        }
        this.node = helper.next;
    }

    // 返回单链表倒数第k个节点
    public Node getLastIndexK(int k){
        if (this.node == null){
            throw new RuntimeException("链表为空");
        }
        if (k <= 0 || k > size){
            throw new RuntimeException("输入的k值有误");
        }
        Stack<Node> stack = new Stack<>();
        Node p = this.node;
        while (true){
            Node next = p.next;
            // 为了只返回一个节点，清空next指向
            p.next = null;
            stack.push(p);
            p = next;
            if (p == null){
                break;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    // 逆序打印单链表
    public void reverseOrderPrint(){
        if (this.node == null){
            System.out.println("链表为空");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        Node p = this.node;
        while (true){
            Node next = p.next;
            stack.push(p.value);
            p = next;
            if (p == null){
                break;
            }
        }
        String result = "";
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            result += stack.pop() + "->";
        }
        System.out.println(result.substring(0, result.length() - 2));
    }

    // 合并两个有序的单链表，合并之后的单链表，仍然是有序的
    public static SingleLinkedList mergeTwoSingleLinkedList(SingleLinkedList list1,SingleLinkedList list2){
        Node p = list1.node;
        Node q = list2.node;
        Node head = new Node();
        Node temp = head;
        Node nextP;
        Node nextQ;
        while (true){
            if (q == null && p == null){
                break;
            }
            if (p.value < q.value){
                nextP = p.next;
                p.next = null;
                temp.next = p;
                p = nextP;
                temp = temp.next;
            }
            if (p == null){
                temp.next = q;
                break;
            }
            if (p.value >= q.value){
                nextQ = q.next;
                q.next = null;
                temp.next = q;
                q = nextQ;
                temp = temp.next;
            }
            if (q == null){
                temp.next = p;
                break;
            }
        }
        SingleLinkedList result = new SingleLinkedList(head.next);
        return result;
    }
}
