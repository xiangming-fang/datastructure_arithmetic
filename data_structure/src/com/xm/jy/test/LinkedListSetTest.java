package com.xm.jy.test;

import com.xm.jy.set.my.LinkedListSet;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: LinkedListSetTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/8/5 14:12
 */
public class LinkedListSetTest {

    @Test
    public void add() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        System.out.println(set.toString());
    }

    @Test
    public void remove() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        set.remove(234);
        set.remove(15);
        System.out.println(set.toString());
    }

    @Test
    public void setLast() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        set.setLast(66);
        System.out.println(set.toString());
    }

    @Test
    public void getLast() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        set.setLast(66);
        System.out.println(set.getLast());
        System.out.println(set.toString());
    }

    @Test
    public void contains() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        System.out.println(set.contains(234));
        System.out.println(set.contains(15));
    }

    @Test
    public void getSize() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(123);
        set.add(125);
        set.add(15);
        set.add(12);
        System.out.println(set.getSize());
        set.remove(12);
        set.remove(234234);
        System.out.println(set.getSize());
    }
}
