package indi.xm.jy.linkedlist;

import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.linkedlist
 * @ClassName: IntersectionNode
 * @Author: albert.fang
 * @Description: 两个链表相交的第一个节点
 * 力扣：160. 相交链表
 * @Date: 2021/12/8 18:50
 */
public class IntersectionNode {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 1、用set
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null){
            set.add(cur);
            cur = cur.next;
        }
        // 第二次遍历headB，set中存在的第一个节点就是相交节点
        ListNode sCur = headB;
        while (sCur != null){
            if (set.contains(sCur)){
                return sCur;
            }
            sCur = sCur.next;
        }
        return null;
    }

    // 2、结合数学知识
    // 链表A和链表B相交之后重叠部分为c，各自未相交部分分别为a,b
    // 那么就有 a + c + b = b + c + a
    // 注意：可能不相交的
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        ListNode sCur = headB;
        if (cur == sCur){
            return headA;
        }
        while (true){
            if (cur != null){
                cur = cur.next;
            }else {
                cur = headB;
            }
            if (sCur != null){
                sCur = sCur.next;
            }else {
                sCur = headA;
            }
            // 不想交也在这体现了
            if (sCur == cur){
                return sCur;
            }
        }
    }
}
