package indi.xm.jy.linkedlist;

import java.util.HashMap;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.linkedlist
 * @ClassName: CopyRandomList
 * @Author: albert.fang
 * @Description: 复制带有随机节点的链表：力扣 138. 复制带随机指针的链表
 * @Date: 2021/12/8 17:28
 */
public class CopyRandomList {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // key -> 老节点
        // value -> 新节点
        // 第一次遍历：将老节点自身节点存储在hashmap中
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        // 第二次遍历：将老节点的next和random都给新节点
        Node sCur = head;
        while (sCur != null){
            // 注意右侧的写法，必须连接的是新建立的节点
            map.get(sCur).next = map.get(sCur.next);
            map.get(sCur).random = map.get(sCur.random);
            sCur = sCur.next;
        }
        return map.get(head);
    }

}
