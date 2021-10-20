package indi.xm.jy.stack;

/**
 * @author: albert.fang
 * @date: 2020/8/11 9:49
 * @description: 用单链表实现栈数据结构
 */
public class StackByLinkedList {
    static class Node{
        private Node next;
        private Integer value;
        private Integer no;

        public Node(Integer no,Integer value) {
            this.value = value;
            this.no = no;
        }

        public Node() {
        }
    }
    private static Node head  = new Node();

    // 判断栈是否为空
    public boolean isEmtpy(){
        return head.next == null;
    }

    // 入栈
    public void push(Node node){
        Node temp = head;
        while (true){
            if (temp.next == null){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    // 出栈
    public Node pop(){
        if (isEmtpy()){
            throw new RuntimeException("栈为空，不可出栈");
        }
        Node temp = head;
        while (true){
            // 出栈需要断链，断链需要找到断链节点的前驱节点，所以这里找到倒数第二个节点，实现断链操作
            if (temp.next.next == null){
                Node popNode = temp.next;
                temp.next = null;
                System.out.println("节点编号"+popNode.no + " 节点值" + popNode.value);
                return popNode;
            }
            temp = temp.next;
        }
    }

    // 遍历栈
    public void show(){
        if (isEmtpy()){
            System.out.println("栈为空");
            return;
        }
        Node temp = head;
        // 得到栈的长度
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        // 双层遍历栈，第一层是几个节点，遍历几次，从最后一个开始遍历
        for (int i = count; i > 0; i--) {
            Node top = head;
            // 第二层是，要获取第几个节点，就遍历几次
            for (int j = 1; j <= i; j++) {
                top = top.next;
                if (j == i){
                    System.out.println("节点编号"+top.no + " 节点值" + top.value);
                }
            }
        }


    }

    public static void main(String[] args) {
        StackByLinkedList stackByLinkedList = new StackByLinkedList();
        Node node1 = new Node(1,1);
        Node node2 = new Node(2,2);
        Node node3 = new Node(3,3);
        Node node4 = new Node(4,4);
        Node node5 = new Node(5,5);
        Node node6 = new Node(6,6);
        Node node7 = new Node(7,7);
        stackByLinkedList.push(node1);
        stackByLinkedList.pop();
        stackByLinkedList.push(node2);
        stackByLinkedList.push(node3);
        stackByLinkedList.push(node4);
        stackByLinkedList.push(node5);
        stackByLinkedList.push(node6);
        stackByLinkedList.push(node7);
        // 遍历
        stackByLinkedList.show();
        // 出栈
        /*try {
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
            stackByLinkedList.pop();
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
}
