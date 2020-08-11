package com.xm.jy.linkedlist;

/**
 * @author: albert.fang
 * @date: 2020/8/11 13:26
 * @description: 用单向环形链表解决Josephus问题
 */
public class Josephus {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.show();
        circleSingleLinkedList.addBoys(15);
        circleSingleLinkedList.show();
        circleSingleLinkedList.getBoys(2,45);
    }
}

// 单向环形链表
class CircleSingleLinkedList{
    private static Boy first = null;

    // 由n个孩子构成的单向环形链表
    public void addBoys(int n){
        if (n < 0){
            System.out.println("输入的孩子个数有误");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i == 1){
                first = new Boy(i);
                first.setNext(first);
            }else {
                Boy lastBoy = first;
                while (true){
                    // last变量的下一个节点是第一个节点，此时last变量指向最后一个节点
                    if (lastBoy.getNext() == first){
                        break;
                    }
                    lastBoy = lastBoy.getNext();
                }
                Boy boy = new Boy(i);
                lastBoy.setNext(boy);
                boy.setNext(first);
            }
        }
    }

    // 从编号为k的孩子报数出队,从1报到m，第m个孩子出队
    public void getBoys(Integer k,Integer m){
        Boy curBoy = first;
        Boy lastBoy = first;
        // 得到环形链表最后一个孩子节点
        // TODO：解释一下这里为什么要找到环形链表的最后一个孩子节点，因为这是单向的环形链表，而单向链表的删除需要找到删除节点的前驱节点
        // TODO：因为是环形链表，所以最后一个节点也就是第一个节点的前驱节点
        while (true){
            if (lastBoy.getNext() == first){
                break;
            }
            lastBoy = lastBoy.getNext();
        }
        // 让curBoy和lastBoy同时移动k-1个位置
        for (int i = 0; i < k - 1; i++) {
            curBoy = curBoy.getNext();
            lastBoy = lastBoy.getNext();
        }
        while (true){
            // lastBoy 和 curBoy 后移m-1个位置
            for (int i = 0; i < m - 1; i++) {
                curBoy = curBoy.getNext();
                lastBoy = lastBoy.getNext();
            }
            System.out.println("出队孩子编号："+curBoy.getNo());
            lastBoy.setNext(curBoy.getNext());
            curBoy = curBoy.getNext();
            if (curBoy == lastBoy){
                System.out.println("最后一个出队孩子编号："+curBoy.getNo());
                break;
            }
        }
    }

    // 打印现有的单向环形链表
    public void show(){
        Boy helper = first;
        if (first == null){
            System.out.println("环中没有节点");
            return;
        }
        while (helper.getNext() != first){
            System.out.println("编号：" + helper.getNo());
            helper = helper.getNext();
        }
        // 输出最后一个
        System.out.println("编号：" + helper.getNo());
    }
}

// 孩子节点
class Boy{

    private Boy next;
    private Integer no;

    public Boy(Integer no){
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}
