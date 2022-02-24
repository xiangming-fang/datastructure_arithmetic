package indi.xm.jy.linkedlist;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.linkedlist
 * @ClassName: DetectCycle
 * @Author: albert.fang
 * @Description: 判断链表是否有环，有的话返回入环第一个节点，否则返回null;
 * 力扣：142. 环形链表 II
 * @Date: 2021/12/8 17:45
 */
public class DetectCycle {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f != null){
            s = s.next;
            f = f.next;
            if (f != null){
                f = f.next;
            }
            // 有环肯定会相遇
            // 相遇的时候让 f 指针重新指向head
            // 注意这里，为啥要 f != null;如果只有一个无环节点，那么此时s == null && f == null 他们也是相等的
            if (f != null && s == f){
                f = head;
                break;
            }
        }
        // 说明快指针都走完了，走完说明无环
        if (f == null){
            return null;
        }
        // 这个时候 f指针 一次走一步，相遇的地点就是第一个入环指针
        while (s != f){
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
