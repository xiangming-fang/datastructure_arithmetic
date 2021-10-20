package indi.xm.jy.test;

import indi.xm.jy.linkedlist.my.LinkedList;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: LinkedListTest
 * @Author: albert.fang
 * @Description: 链表测试
 * @Date: 2021/8/1 13:22
 */
public class LinkedListTest {

    @Test
    public void addAndRemoveTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0,"12");
        linkedList.add(0,"13");
        linkedList.add(0,"14");
        linkedList.add(0,"15");
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.toString());
    }

    @Test
    public void setAndGetTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(0,"12");
        linkedList.add(0,"13");
        linkedList.add(0,"14");
        linkedList.add(0,"15");
        linkedList.set(2,"200");
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.toString());
    }

    @Test
    public void addAndRemoveLast(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("asdf");
        linkedList.addLast("3213");
        linkedList.addLast("L:LM::K");
        linkedList.addLast("asfsadf");
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.toString());
    }

    @Test
    public void addAndRemoveFirst(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("asdf");
        linkedList.addLast("3213");
        linkedList.addLast("L:LM::K");
        linkedList.addLast("asfsadf");
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.toString());
    }

    @Test
    public void setAndGetLast(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("asdf");
        linkedList.addLast("3213");
        linkedList.addLast("L:LM::K");
        linkedList.addLast("asfsadf");
        linkedList.setLast("修改最后一个的值");
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.toString());
    }

    @Test
    public void setAndGetFirst(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("asdf");
        linkedList.addLast("3213");
        linkedList.addLast("L:LM::K");
        linkedList.addLast("asfsadf");
        linkedList.setFirst("修改第一个的值");
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.toString());
    }
}
