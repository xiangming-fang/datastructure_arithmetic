package indi.xm.jy.test;

import indi.xm.jy.array.my.Array;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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

    @Test
    public void testBigArray(){
        long start = System.currentTimeMillis();
        Array<Integer> array = new Array<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            array.addLast(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("array 有几个元素：" + array.getSize());
        long end = System.currentTimeMillis();
        System.out.println("插入1000000个数据需要：" + (end - start) / 1000 + "s");

        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            array.removeLast();
        }
        System.out.println("array 有几个元素：" + array.getSize());
        long e = System.currentTimeMillis();
        System.out.println("移除1000000个数据需要：" + (e - s) / 1000 + "s");
    }

    @Test
    public void testJavaArrayList(){
        long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("list 有几个元素：" + list.size());
        long end = System.currentTimeMillis();
        System.out.println("插入1000000个数据需要：" + (end - start) / 1000 + "s");

        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.remove(list.size() - 1);
        }
        System.out.println("array 有几个元素：" + list.size());
        long e = System.currentTimeMillis();
        System.out.println("移除1000000个数据需要：" + (e - s) / 1000 + "s");
    }

    @Test
    public void testArray(){
//        FileOperatorUtils.getWords("");
    }
}
