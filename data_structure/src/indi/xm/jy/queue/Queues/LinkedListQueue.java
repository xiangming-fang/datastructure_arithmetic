package indi.xm.jy.queue.Queues;


/**
 * @author: albert.fang
 * @date: 2020/10/26 13:24
 * @description: 链表队列的实现：重新定义链表（去掉虚拟头结点，新增尾指针含义）
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head,tail;
    private int size;

    public LinkedListQueue(Node head,Node tail,int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public LinkedListQueue(){
        this(null,null,0);
    }

    // 内部私有节点类（用户不能操作这个内部私有类）
    private class Node{

        E e;
        Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null,null);
        }

        public Node(E e){
            this(e,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public void enqueue(E e) throws Exception {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() throws Exception {
        if (head == null){
            throw new IllegalArgumentException("dequeue failed,no value");
        }
        Node removeNode = head;
        head = head.next;
        // 如果链表中只有一个节点，那么删除之后，要改变一下tail尾指针的指向
        if (head == null)
            tail = null;
        // 为了便于JVM回收
        removeNode.next = null;
        size --;
        return removeNode.e;
    }

    @Override
    public E getfront() throws Exception {
        if (isEmpty()){
            throw new IllegalArgumentException("getfront failed,ArrayQueue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("ArrayQueue head: [");
        Node cur = head;
        while (cur != null){
            ret.append(cur.e.toString()).append(" -> ");
            cur = cur.next;
        }
        ret.append(" NULL ] tail");
        return ret.toString();
    }

    public static void main(String[] args) throws Exception {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        // 入队
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
            System.out.println(queue + "队列大小：" + queue.getSize());
        }

        // 出队
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
            System.out.println(queue + "队列大小：" + queue.getSize());
        }

        System.out.println(queue.getfront());
        System.out.println(queue + "队列大小：" + queue.getSize());
    }
}
