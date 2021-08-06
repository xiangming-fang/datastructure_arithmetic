package com.xm.jy.test;

import com.xm.jy.array.my.Array;
import com.xm.jy.bst.my.BST;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.test
 * @ClassName: BSTTest
 * @Author: albert.fang
 * @Description: 二叉搜索树测试
 * @Date: 2021/8/2 16:22
 */
public class BSTTest {

    @Test
    public void addNodeTest(){
        BST<Integer> bst = new BST<>();
        bst.add(23);
        bst.add(43);
        bst.add(83);
        bst.add(93);
        bst.add(33);
        bst.add(13);
        bst.add(13);
        System.out.println(bst.getSize());
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
    }

    @Test
    public void inOrderTest() {
        BST<Integer> bst = new BST<>();
        bst.inorder();
        bst.add(23);
        bst.add(43);
        bst.add(83);
        bst.add(93);
        bst.add(563);
        bst.add(7893);
        bst.add(93333);
        bst.add(33);
        bst.add(33243);
        bst.add(33);
        bst.add(52343);
        bst.add(13);
        bst.inorder();
        System.out.println("BST 大小  " + bst.getSize());
    }

    @Test
    public void setTest(){
        BST<Integer> bst = new BST<>();
        bst.inorder();
        bst.add(23);
        bst.add(43);
        bst.add(83);
        bst.add(93);
        bst.add(563);
        bst.add(7893);
        bst.add(93333);
        bst.add(33);
        bst.add(33243);
        bst.add(33);
        bst.add(52343);
        bst.add(13);
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        bst.setMax(93332);
        bst.setMax(12);
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        bst.setMax(100000);
        bst.setMin(10);
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
    }

    @Test
    public void containTest(){
        BST<Integer> bst = new BST<>();
        bst.inorder();
        bst.add(23);
        bst.add(43);
        bst.add(83);
        bst.add(93);
        bst.add(563);
        bst.add(7893);
        bst.add(93333);
        bst.add(33);
        bst.add(33243);
        bst.add(33);
        bst.add(52343);
        bst.add(13);
        System.out.println(bst.contains(93));
        System.out.println(bst.contains(193));
    }

    @Test
    public void removeTest(){
        BST<Integer> bst = new BST<>();
        bst.inorder();
        bst.add(23);
        bst.add(43);
        bst.add(83);
        bst.add(93);
        bst.add(563);
        bst.add(7893);
        bst.add(93333);
        bst.add(33);
        bst.add(33243);
        bst.add(33);
        bst.add(52343);
        bst.add(13);
        bst.inorder();
        bst.remove(77777);
        bst.inorder();
        bst.remove(52343);
        bst.inorder();
        bst.remove(93);
        bst.inorder();
        bst.remove(93333);
        bst.inorder();
        System.out.println(bst.getSize());
    }

    // 创建一个BST，判断是否是一棵正确的BST
    // 根据bst的中序遍历特性
    @Test
    public void bstTest(){

        long start = System.currentTimeMillis();
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            bst.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(bst.getSize());
        Array<Integer> list = new Array<>();
        bst.inorder(list);
        for (int i = 0; i < bst.getSize() - 1; i ++){
            if (list.get(i + 1) < list.get(i)){
                System.err.println("bst 创建有误");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(list.getSize());
        System.out.println((end - start) / 1000 + "s");
    }
}
