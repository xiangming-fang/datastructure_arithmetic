package com.xm.jy.test;

import com.xm.jy.array.my.Array;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: ArrayTest
 * @Author: albert.fang
 * @Description: 动态数组测试
 * @Date: 2021/7/30 9:21
 */
public class ArrayTest {

    @Test
    public void addRemoveIndexTest(){
        Array<String> array = new Array<>(1);
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        array.add(0,"sdfasf");
        System.out.println(array.remove(0));
        System.out.println(array.remove(0));
        System.out.println(array.remove(1));
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
    }

    @Test
    public void addRemoveLastTest(){
        Array<String> array = new Array<>();
        array.addLast("a");
        array.addLast("b");
        array.addLast("c");
        array.addLast("d");
        array.addLast("e");
        array.addLast("f");
        array.add(array.getSize()-1,"e1");
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
        System.out.println(array.removeLast());
    }

    @Test
    public void setGetTest(){
        Array<String> array = new Array<>();
        array.addLast("a");
        array.addLast("b");
        array.addLast("c");
        array.addLast("d");
        array.addLast("e");
        array.addLast("f");
        array.set(0,"set");
        System.out.println(array.get(array.getSize() - 1));
    }
}
