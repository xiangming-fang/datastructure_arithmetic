package indi.xm.jy.linkedlist;

import java.util.Stack;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.linkedlist
 * @ClassName: PalindromeLinkedList
 * @Author: albert.fang
 * @Description: 回文链表
 * @Date: 2021/12/8 16:49
 */
public class PalindromeLinkedList {

    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }
    }

    // 两次遍历
    // 第一次：用栈接受每个位置的节点值
    // 第二次：从栈中弹出每个节点和链表位置做比较
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        Stack<Integer> stackNode = new Stack<>();
        while (cur != null){
            stackNode.push(cur.val);
            cur = cur.next;
        }
        ListNode sCur = head;
        while (sCur != null){
            if (sCur.val != stackNode.pop()) return false;
            sCur = sCur.next;
        }
        return true;
    }

}
