package indi.xm.jy.test;

import indi.xm.jy.map.my.LinkedListMap;
import org.junit.Test;


/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: LinkedListMapTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/8/5 14:58
 */
public class LinkedListMapTest {

    @Test
    public void add() {
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("name","方翔鸣");
        map.add("age","24");
        map.add("weight","83");
        map.add("height","173cm");
    }

    @Test
    public void remove() {
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("name","方翔鸣");
        map.add("age","24");
        map.add("weight","83");
        map.add("height","173cm");
        map.remove("age");
        map.remove("asdfas");
    }

    @Test
    public void set() {
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("name","方翔鸣");
        map.add("age","24");
        map.add("weight","83");
        map.add("height","173cm");
        map.set("weight","75");
        System.out.println(map.toString());
    }

    @Test
    public void get() {
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("name","方翔鸣");
        map.add("age","24");
        map.add("weight","83");
        map.add("height","173cm");
        map.set("weight","75");
        System.out.println(map.get("name"));
    }

    @Test
    public void containsKey() {
        LinkedListMap<String, String> map = new LinkedListMap<>();
        map.add("name","方翔鸣");
        map.add("age","24");
        map.add("weight","83");
        map.add("height","173cm");
        map.set("weight","75");
        System.out.println(map.containsKey("sdfadsf"));
        System.out.println(map.containsKey("age"));
    }
}